
package palamod.client.gui;

import palamod.world.inventory.ArmorpalahelpguiMenu;

import palamod.network.ArmorpalahelpguiButtonMessage;

import palamod.PalamodMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class ArmorpalahelpguiScreen extends AbstractContainerScreen<ArmorpalahelpguiMenu> {
	private final static HashMap<String, Object> guistate = ArmorpalahelpguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_back;
	Button button_menu;

	public ArmorpalahelpguiScreen(ArmorpalahelpguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 300;
		this.imageHeight = 200;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/screens/armorpalahelpgui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/amethyst_helmet.png"));
		this.blit(ms, this.leftPos + 4, this.topPos + 6, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/amethyst_chestplate.png"));
		this.blit(ms, this.leftPos + 4, this.topPos + 40, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/amethyst_leggings.png"));
		this.blit(ms, this.leftPos + 5, this.topPos + 77, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/amethyst_boots.png"));
		this.blit(ms, this.leftPos + 5, this.topPos + 121, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/endium_helmet.png"));
		this.blit(ms, this.leftPos + 216, this.topPos + 12, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/endium_chestplate.png"));
		this.blit(ms, this.leftPos + 217, this.topPos + 45, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/endium_leggings.png"));
		this.blit(ms, this.leftPos + 216, this.topPos + 80, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/endium_boots.png"));
		this.blit(ms, this.leftPos + 220, this.topPos + 117, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/paladium_chestplate.png"));
		this.blit(ms, this.leftPos + 150, this.topPos + 44, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/paladium_green_chestplate.png"));
		this.blit(ms, this.leftPos + 114, this.topPos + 42, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/paladium_green_boots.png"));
		this.blit(ms, this.leftPos + 114, this.topPos + 118, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/paladium_green_helmet.png"));
		this.blit(ms, this.leftPos + 114, this.topPos + 11, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/paladium_green_leggings.png"));
		this.blit(ms, this.leftPos + 114, this.topPos + 79, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/paladium_helmet.png"));
		this.blit(ms, this.leftPos + 150, this.topPos + 13, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/paladium_leggings.png"));
		this.blit(ms, this.leftPos + 149, this.topPos + 81, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/paladium_boots.png"));
		this.blit(ms, this.leftPos + 152, this.topPos + 118, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/titane_helmet.png"));
		this.blit(ms, this.leftPos + 56, this.topPos + 6, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/titane_chestplate.png"));
		this.blit(ms, this.leftPos + 59, this.topPos + 41, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/titane_leggings.png"));
		this.blit(ms, this.leftPos + 60, this.topPos + 79, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/titane_boots.png"));
		this.blit(ms, this.leftPos + 60, this.topPos + 117, 0, 0, 32, 32, 32, 32);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.armorpalahelpgui.label_45"), 35, 18, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.armorpalahelpgui.label_5"), 36, 51, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.armorpalahelpgui.label_4"), 36, 83, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.armorpalahelpgui.label_451"), 37, 130, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.armorpalahelpgui.label_452"), 82, 16, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.armorpalahelpgui.label_453"), 88, 124, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.armorpalahelpgui.label_51"), 88, 88, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.armorpalahelpgui.label_52"), 90, 51, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.armorpalahelpgui.label_454"), 179, 21, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.armorpalahelpgui.label_night_vision_ii"), 159, 7, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.armorpalahelpgui.label_65"), 183, 50, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.armorpalahelpgui.label_force"), 181, 59, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.armorpalahelpgui.label_55"), 179, 85, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.armorpalahelpgui.label_haste"), 180, 98, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.armorpalahelpgui.label_5_speed"), 179, 124, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.armorpalahelpgui.label_53"), 248, 21, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.armorpalahelpgui.label_7"), 248, 53, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.armorpalahelpgui.label_551"), 243, 87, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.armorpalahelpgui.label_552"), 247, 122, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.armorpalahelpgui.label_night_vision_ii1"), 218, 37, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.armorpalahelpgui.label_force1"), 248, 62, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.armorpalahelpgui.label_haste1"), 249, 96, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.armorpalahelpgui.label_speed"), 253, 131, -12829636);
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
		button_back = new Button(this.leftPos + 9, this.topPos + 155, 45, 20, new TranslatableComponent("gui.palamod.armorpalahelpgui.button_back"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new ArmorpalahelpguiButtonMessage(0, x, y, z));
				ArmorpalahelpguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_back", button_back);
		this.addRenderableWidget(button_back);
		button_menu = new Button(this.leftPos + 62, this.topPos + 155, 45, 20, new TranslatableComponent("gui.palamod.armorpalahelpgui.button_menu"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new ArmorpalahelpguiButtonMessage(1, x, y, z));
				ArmorpalahelpguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_menu", button_menu);
		this.addRenderableWidget(button_menu);
	}
}
