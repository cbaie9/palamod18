
package palamod.client.gui;

import palamod.world.inventory.MoneypanelMenu;

import palamod.network.MoneypanelButtonMessage;

import palamod.PalamodMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class MoneypanelScreen extends AbstractContainerScreen<MoneypanelMenu> {
	private final static HashMap<String, Object> guistate = MoneypanelMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox Admin_player_money;
	EditBox Admin_money_change;
	Button button_change;
	Button button_avanced;

	public MoneypanelScreen(MoneypanelMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 210;
		this.imageHeight = 170;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/screens/moneypanel.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		Admin_player_money.render(ms, mouseX, mouseY, partialTicks);
		Admin_money_change.render(ms, mouseX, mouseY, partialTicks);
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
		if (Admin_player_money.isFocused())
			return Admin_player_money.keyPressed(key, b, c);
		if (Admin_money_change.isFocused())
			return Admin_money_change.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		Admin_player_money.tick();
		Admin_money_change.tick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.moneypanel.label_money_panel"), 68, 7, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.moneypanel.label_money_to_change_for_remove_m"), 5, 73, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.moneypanel.label_player_to_change_money"), 22, 38, -12829636);
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
		Admin_player_money = new EditBox(this.font, this.leftPos + 21, this.topPos + 49, 120, 20, new TranslatableComponent("gui.palamod.moneypanel.Admin_player_money")) {
			{
				setSuggestion(new TranslatableComponent("gui.palamod.moneypanel.Admin_player_money").getString());
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(new TranslatableComponent("gui.palamod.moneypanel.Admin_player_money").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(new TranslatableComponent("gui.palamod.moneypanel.Admin_player_money").getString());
				else
					setSuggestion(null);
			}
		};
		Admin_player_money.setMaxLength(32767);
		guistate.put("text:Admin_player_money", Admin_player_money);
		this.addWidget(this.Admin_player_money);
		Admin_money_change = new EditBox(this.font, this.leftPos + 24, this.topPos + 88, 120, 20, new TranslatableComponent("gui.palamod.moneypanel.Admin_money_change")) {
			{
				setSuggestion(new TranslatableComponent("gui.palamod.moneypanel.Admin_money_change").getString());
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(new TranslatableComponent("gui.palamod.moneypanel.Admin_money_change").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(new TranslatableComponent("gui.palamod.moneypanel.Admin_money_change").getString());
				else
					setSuggestion(null);
			}
		};
		Admin_money_change.setMaxLength(32767);
		guistate.put("text:Admin_money_change", Admin_money_change);
		this.addWidget(this.Admin_money_change);
		button_change = new Button(this.leftPos + 25, this.topPos + 122, 56, 20, new TranslatableComponent("gui.palamod.moneypanel.button_change"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new MoneypanelButtonMessage(0, x, y, z));
				MoneypanelButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_change", button_change);
		this.addRenderableWidget(button_change);
		button_avanced = new Button(this.leftPos + 121, this.topPos + 122, 61, 20, new TranslatableComponent("gui.palamod.moneypanel.button_avanced"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new MoneypanelButtonMessage(1, x, y, z));
				MoneypanelButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_avanced", button_avanced);
		this.addRenderableWidget(button_avanced);
	}
}
