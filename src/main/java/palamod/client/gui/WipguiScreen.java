
package palamod.client.gui;

import palamod.world.inventory.WipguiMenu;

import palamod.network.WipguiButtonMessage;

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

public class WipguiScreen extends AbstractContainerScreen<WipguiMenu> {
	private final static HashMap<String, Object> guistate = WipguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_acces_hdv;

	public WipguiScreen(WipguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 275;
		this.imageHeight = 225;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/screens/wipgui.png");

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
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.wipgui.label_palamod_not_in_working_in_prog"), 45, 6, -3407872);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.wipgui.label_beta_2_build_t1_0026"), 153, 209, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.wipgui.label_lhotel_des_vente_ou_hdv_a_ete_a"), 30, 41, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.wipgui.label_a_cause_dun_bug_de_stockage_di"), 30, 52, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.wipgui.label_le_projet_etant_en_open_source"), 5, 86, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.wipgui.label_aider_conctacter_les_devloppeu"), 8, 96, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.wipgui.label_httpsgithubcomcbaie9palamo"), 9, 112, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.wipgui.label_le_hdv_ses_processus_ont_ete_ret"), 6, 136, -65485);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.wipgui.label_de_lag_et_de_compilation_code"), 7, 145, -65485);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.wipgui.label_github_discord"), 7, 123, -12829636);
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
		button_acces_hdv = new Button(this.leftPos + 38, this.topPos + 179, 186, 20, new TranslatableComponent("gui.palamod.wipgui.button_acces_hdv"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new WipguiButtonMessage(0, x, y, z));
				WipguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_acces_hdv", button_acces_hdv);
		this.addRenderableWidget(button_acces_hdv);
	}
}
