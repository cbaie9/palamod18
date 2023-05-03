
package palamod.client.gui;

import palamod.world.inventory.PalahelporeMenu;

import palamod.network.PalahelporeButtonMessage;

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

public class PalahelporeScreen extends AbstractContainerScreen<PalahelporeMenu> {
	private final static HashMap<String, Object> guistate = PalahelporeMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_back;
	Button button_menu;

	public PalahelporeScreen(PalahelporeMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 300;
		this.imageHeight = 220;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/screens/palahelpore.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/amethyst_ingot.png"));
		this.blit(ms, this.leftPos + 9, this.topPos + 155, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/paladium_ingot.png"));
		this.blit(ms, this.leftPos + 10, this.topPos + 77, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/findium.png"));
		this.blit(ms, this.leftPos + 10, this.topPos + 99, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/titane_ingot.png"));
		this.blit(ms, this.leftPos + 10, this.topPos + 123, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/paladium_green_ingot.png"));
		this.blit(ms, this.leftPos + 10, this.topPos + 56, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/endium_ingot.png"));
		this.blit(ms, this.leftPos + 10, this.topPos + 28, 0, 0, 16, 16, 16, 16);

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
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.palahelpore.label_paladium_le_minerais_le_plus_pu"), 28, 81, -52480);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.palahelpore.label_tres_rare_sert_a_quelque_craft"), 27, 103, -205);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.palahelpore.label_resitanttres_bon_pour_ses_premi"), 28, 126, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.palahelpore.label_amthyste"), 29, 158, -6750055);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.palahelpore.label_paladium_vert_equivalent_en_pl"), 28, 59, -10027213);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.palahelpore.label_endium_le_materiau_ultime_obte"), 28, 27, -13434727);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.palahelpore.label_via_le_paladium_crusher_voir_m"), 28, 38, -13434727);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.palahelpore.label_tools"), 29, 136, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.palahelpore.label_assez_facilement"), 26, 170, -6750055);
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
		button_back = new Button(this.leftPos + 249, this.topPos + 4, 45, 20, new TranslatableComponent("gui.palamod.palahelpore.button_back"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalahelporeButtonMessage(0, x, y, z));
				PalahelporeButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_back", button_back);
		this.addRenderableWidget(button_back);
		button_menu = new Button(this.leftPos + 4, this.topPos + 4, 45, 20, new TranslatableComponent("gui.palamod.palahelpore.button_menu"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalahelporeButtonMessage(1, x, y, z));
				PalahelporeButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_menu", button_menu);
		this.addRenderableWidget(button_menu);
	}
}
