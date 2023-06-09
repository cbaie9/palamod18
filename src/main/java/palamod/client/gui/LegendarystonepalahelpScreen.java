
package palamod.client.gui;

import palamod.world.inventory.LegendarystonepalahelpMenu;

import palamod.network.LegendarystonepalahelpButtonMessage;

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

public class LegendarystonepalahelpScreen extends AbstractContainerScreen<LegendarystonepalahelpMenu> {
	private final static HashMap<String, Object> guistate = LegendarystonepalahelpMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_back;
	Button button_menu;

	public LegendarystonepalahelpScreen(LegendarystonepalahelpMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 220;
		this.imageHeight = 200;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/screens/legendarystonepalahelp.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/legend_fortune.png"));
		this.blit(ms, this.leftPos + 11, this.topPos + 33, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/legend_invisibility.png"));
		this.blit(ms, this.leftPos + 13, this.topPos + 65, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/legend_jobs.png"));
		this.blit(ms, this.leftPos + 14, this.topPos + 84, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/legend_power.png"));
		this.blit(ms, this.leftPos + 14, this.topPos + 100, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/legend_tp.png"));
		this.blit(ms, this.leftPos + 14, this.topPos + 124, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/legend_random.png"));
		this.blit(ms, this.leftPos + 10, this.topPos + 149, 0, 0, 16, 16, 16, 16);

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
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.legendarystonepalahelp.label_legendary_stone_wiki"), 60, 4, -65536);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.legendarystonepalahelp.label_forturne_permet_de_vous_give"), 28, 38, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.legendarystonepalahelp.label_des_minerais"), 18, 51, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.legendarystonepalahelp.label_note_utilisable_une_fois_tous_l"), 23, 15, -3407872);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.legendarystonepalahelp.label_invisible_vous_rend_invisible"), 35, 69, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.legendarystonepalahelp.label_jobs_vous_donne_de_lxp"), 36, 88, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.legendarystonepalahelp.label_power_vous_permet_detre_prote"), 30, 105, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.legendarystonepalahelp.label_contre_la_fake_water"), 16, 115, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.legendarystonepalahelp.label_teleportation_vous_tp_aletorem"), 29, 126, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.legendarystonepalahelp.label_sur_la_map"), 14, 138, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.legendarystonepalahelp.label_random_vous_donne_une_des_5_pi"), 26, 153, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.legendarystonepalahelp.label_au_dessus"), 13, 164, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.legendarystonepalahelp.label_deux_jour_dans_le_jeu"), 23, 24, -52429);
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
		button_back = new Button(this.leftPos + 31, this.topPos + 173, 45, 20, new TranslatableComponent("gui.palamod.legendarystonepalahelp.button_back"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new LegendarystonepalahelpButtonMessage(0, x, y, z));
				LegendarystonepalahelpButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_back", button_back);
		this.addRenderableWidget(button_back);
		button_menu = new Button(this.leftPos + 98, this.topPos + 173, 45, 20, new TranslatableComponent("gui.palamod.legendarystonepalahelp.button_menu"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new LegendarystonepalahelpButtonMessage(1, x, y, z));
				LegendarystonepalahelpButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_menu", button_menu);
		this.addRenderableWidget(button_menu);
	}
}
