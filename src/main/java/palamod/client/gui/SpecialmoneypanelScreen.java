
package palamod.client.gui;

import palamod.world.inventory.SpecialmoneypanelMenu;

import palamod.network.SpecialmoneypanelButtonMessage;

import palamod.PalamodMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class SpecialmoneypanelScreen extends AbstractContainerScreen<SpecialmoneypanelMenu> {
	private final static HashMap<String, Object> guistate = SpecialmoneypanelMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox player_name;
	EditBox money;
	Checkbox custom_destructible;
	Button button_give;

	public SpecialmoneypanelScreen(SpecialmoneypanelMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 224;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/screens/specialmoneypanel.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		player_name.render(ms, mouseX, mouseY, partialTicks);
		money.render(ms, mouseX, mouseY, partialTicks);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (player_name.isFocused())
			return player_name.keyPressed(key, b, c);
		if (money.isFocused())
			return money.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		player_name.tick();
		money.tick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.specialmoneypanel.label_specific_player"), 33, 3, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.specialmoneypanel.label_amount_of_money"), 32, 34, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.specialmoneypanel.label_item_default_money_item"), 7, 74, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		player_name = new EditBox(this.font, this.leftPos + 9, this.topPos + 13, 120, 20, new TranslatableComponent("gui.palamod.specialmoneypanel.player_name")) {
			{
				setSuggestion(new TranslatableComponent("gui.palamod.specialmoneypanel.player_name").getString());
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(new TranslatableComponent("gui.palamod.specialmoneypanel.player_name").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(new TranslatableComponent("gui.palamod.specialmoneypanel.player_name").getString());
				else
					setSuggestion(null);
			}
		};
		player_name.setMaxLength(32767);
		guistate.put("text:player_name", player_name);
		this.addWidget(this.player_name);
		money = new EditBox(this.font, this.leftPos + 8, this.topPos + 46, 120, 20, new TranslatableComponent("gui.palamod.specialmoneypanel.money")) {
			{
				setSuggestion(new TranslatableComponent("gui.palamod.specialmoneypanel.money").getString());
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(new TranslatableComponent("gui.palamod.specialmoneypanel.money").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(new TranslatableComponent("gui.palamod.specialmoneypanel.money").getString());
				else
					setSuggestion(null);
			}
		};
		money.setMaxLength(32767);
		guistate.put("text:money", money);
		this.addWidget(this.money);
		button_give = new Button(this.leftPos + 120, this.topPos + 94, 46, 20, new TranslatableComponent("gui.palamod.specialmoneypanel.button_give"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new SpecialmoneypanelButtonMessage(0, x, y, z));
				SpecialmoneypanelButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_give", button_give);
		this.addRenderableWidget(button_give);
		custom_destructible = new Checkbox(this.leftPos + 6, this.topPos + 118, 20, 20, new TranslatableComponent("gui.palamod.specialmoneypanel.custom_destructible"), false);
		guistate.put("checkbox:custom_destructible", custom_destructible);
		this.addRenderableWidget(custom_destructible);
	}
}
