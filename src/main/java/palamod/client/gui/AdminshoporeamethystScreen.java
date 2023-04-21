
package palamod.client.gui;

import palamod.world.inventory.AdminshoporeamethystMenu;

import palamod.network.AdminshoporeamethystButtonMessage;

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

public class AdminshoporeamethystScreen extends AbstractContainerScreen<AdminshoporeamethystMenu> {
	private final static HashMap<String, Object> guistate = AdminshoporeamethystMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox number_buy;
	Button button_buy;
	Button button_sell;
	Button button_back;

	public AdminshoporeamethystScreen(AdminshoporeamethystMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/screens/adminshoporeamethyst.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		number_buy.render(ms, mouseX, mouseY, partialTicks);
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
		if (number_buy.isFocused())
			return number_buy.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		number_buy.tick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.adminshoporeamethyst.label_amethyst"), 58, 6, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.adminshoporeamethyst.label_mode_set"), 29, 74, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.adminshoporeamethyst.label_sell_price_70"), 39, 28, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.adminshoporeamethyst.label_buy_price_75"), 45, 40, -12829636);
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
		number_buy = new EditBox(this.font, this.leftPos + 26, this.topPos + 87, 120, 20, new TranslatableComponent("gui.palamod.adminshoporeamethyst.number_buy")) {
			{
				setSuggestion(new TranslatableComponent("gui.palamod.adminshoporeamethyst.number_buy").getString());
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(new TranslatableComponent("gui.palamod.adminshoporeamethyst.number_buy").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(new TranslatableComponent("gui.palamod.adminshoporeamethyst.number_buy").getString());
				else
					setSuggestion(null);
			}
		};
		number_buy.setMaxLength(32767);
		guistate.put("text:number_buy", number_buy);
		this.addWidget(this.number_buy);
		button_buy = new Button(this.leftPos + 26, this.topPos + 108, 40, 20, new TranslatableComponent("gui.palamod.adminshoporeamethyst.button_buy"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshoporeamethystButtonMessage(0, x, y, z));
				AdminshoporeamethystButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_buy", button_buy);
		this.addRenderableWidget(button_buy);
		button_sell = new Button(this.leftPos + 100, this.topPos + 107, 46, 20, new TranslatableComponent("gui.palamod.adminshoporeamethyst.button_sell"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshoporeamethystButtonMessage(1, x, y, z));
				AdminshoporeamethystButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_sell", button_sell);
		this.addRenderableWidget(button_sell);
		button_back = new Button(this.leftPos + 7, this.topPos + 139, 46, 20, new TranslatableComponent("gui.palamod.adminshoporeamethyst.button_back"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshoporeamethystButtonMessage(2, x, y, z));
				AdminshoporeamethystButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_back", button_back);
		this.addRenderableWidget(button_back);
	}
}
