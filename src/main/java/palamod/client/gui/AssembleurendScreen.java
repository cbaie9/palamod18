
package palamod.client.gui;

import palamod.world.inventory.AssembleurendMenu;

import palamod.network.AssembleurendButtonMessage;

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

public class AssembleurendScreen extends AbstractContainerScreen<AssembleurendMenu> {
	private final static HashMap<String, Object> guistate = AssembleurendMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_trade;
	Button button_ouvrir;

	public AssembleurendScreen(AssembleurendMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 200;
		this.imageHeight = 234;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/screens/assembleurend.png");

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
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.assembleurend.label_the_assembleur_will_deleted_in_t"), 8, 26, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.assembleurend.label_update_you_can_trade_it_for_a"), 9, 38, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.assembleurend.label_collectr_grinder"), 10, 51, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.assembleurend.label_hey_le_chercheur"), 3, 129, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.assembleurend.label_une_maj_sera_bientot_faite"), 4, 149, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.assembleurend.label_mais_cest_fufu_qui_doit_sen_ch"), 4, 162, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.assembleurend.label_donc_tu_a_le_temps_de_trifouille"), 4, 174, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.assembleurend.label_si_tes_en_jeu_voici_un_surprise"), 6, 185, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.assembleurend.label_bouton"), 6, 195, -12829636);
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
		button_trade = new Button(this.leftPos + 55, this.topPos + 72, 51, 20, new TranslatableComponent("gui.palamod.assembleurend.button_trade"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AssembleurendButtonMessage(0, x, y, z));
				AssembleurendButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_trade", button_trade);
		this.addRenderableWidget(button_trade);
		button_ouvrir = new Button(this.leftPos + 138, this.topPos + 206, 56, 20, new TranslatableComponent("gui.palamod.assembleurend.button_ouvrir"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AssembleurendButtonMessage(1, x, y, z));
				AssembleurendButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_ouvrir", button_ouvrir);
		this.addRenderableWidget(button_ouvrir);
	}
}
