
package palamod.client.gui;

import palamod.world.inventory.AdminshopmobsRottenfleshMenu;

import palamod.network.AdminshopmobsRottenfleshButtonMessage;

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

public class AdminshopmobsRottenfleshScreen extends AbstractContainerScreen<AdminshopmobsRottenfleshMenu> {
	private final static HashMap<String, Object> guistate = AdminshopmobsRottenfleshMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox number_buy;
	Button button_buy;
	Button button_sell;
	Button button_back;

	public AdminshopmobsRottenfleshScreen(AdminshopmobsRottenfleshMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/screens/adminshopmobs_rottenflesh.png");

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
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.adminshopmobs_rottenflesh.label_paladium"), 61, 6, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.adminshopmobs_rottenflesh.label_mode_set"), 29, 74, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.adminshopmobs_rottenflesh.label_sell_price_120"), 25, 30, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.adminshopmobs_rottenflesh.label_buy_price_125"), 25, 44, -12829636);
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
		number_buy = new EditBox(this.font, this.leftPos + 26, this.topPos + 87, 120, 20, new TranslatableComponent("gui.palamod.adminshopmobs_rottenflesh.number_buy")) {
			{
				setSuggestion(new TranslatableComponent("gui.palamod.adminshopmobs_rottenflesh.number_buy").getString());
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(new TranslatableComponent("gui.palamod.adminshopmobs_rottenflesh.number_buy").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(new TranslatableComponent("gui.palamod.adminshopmobs_rottenflesh.number_buy").getString());
				else
					setSuggestion(null);
			}
		};
		number_buy.setMaxLength(32767);
		guistate.put("text:number_buy", number_buy);
		this.addWidget(this.number_buy);
		button_buy = new Button(this.leftPos + 26, this.topPos + 109, 40, 20, new TranslatableComponent("gui.palamod.adminshopmobs_rottenflesh.button_buy"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopmobsRottenfleshButtonMessage(0, x, y, z));
				AdminshopmobsRottenfleshButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_buy", button_buy);
		this.addRenderableWidget(button_buy);
		button_sell = new Button(this.leftPos + 99, this.topPos + 109, 46, 20, new TranslatableComponent("gui.palamod.adminshopmobs_rottenflesh.button_sell"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopmobsRottenfleshButtonMessage(1, x, y, z));
				AdminshopmobsRottenfleshButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_sell", button_sell);
		this.addRenderableWidget(button_sell);
		button_back = new Button(this.leftPos + 6, this.topPos + 139, 46, 20, new TranslatableComponent("gui.palamod.adminshopmobs_rottenflesh.button_back"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopmobsRottenfleshButtonMessage(2, x, y, z));
				AdminshopmobsRottenfleshButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_back", button_back);
		this.addRenderableWidget(button_back);
	}
}
