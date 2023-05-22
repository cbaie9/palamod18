
package palamod.client.gui;

import palamod.world.inventory.AnalyserresultMenu;

import palamod.procedures.AnalyreturnwoolProcedure;
import palamod.procedures.AnalyreturnstoneProcedure;
import palamod.procedures.AnalyreturnshulkerProcedure;
import palamod.procedures.AnalyreturnplanksProcedure;
import palamod.procedures.AnalyreturnoresProcedure;
import palamod.procedures.AnalyreturnlogsProcedure;
import palamod.procedures.AnalyreturnendstoneProcedure;
import palamod.procedures.AnalyreturndirtProcedure;
import palamod.procedures.AnalyreturncobbleProcedure;
import palamod.procedures.AnalyreturnclayProcedure;
import palamod.procedures.AnalyreturnchestProcedure;
import palamod.procedures.AnalyreturnbedrockProcedure;
import palamod.procedures.AnalyreturnairProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class AnalyserresultScreen extends AbstractContainerScreen<AnalyserresultMenu> {
	private final static HashMap<String, Object> guistate = AnalyserresultMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public AnalyserresultScreen(AnalyserresultMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 400;
		this.imageHeight = 220;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/screens/analyserresult.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/end_stone.png"));
		this.blit(ms, this.leftPos + 5, this.topPos + 7, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/clay.png"));
		this.blit(ms, this.leftPos + 118, this.topPos + 6, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/paladium_ore.png"));
		this.blit(ms, this.leftPos + 5, this.topPos + 39, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/planks_oak.png"));
		this.blit(ms, this.leftPos + 5, this.topPos + 71, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/cobblestone.png"));
		this.blit(ms, this.leftPos + 5, this.topPos + 102, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/chest_ico32.png"));
		this.blit(ms, this.leftPos + 3, this.topPos + 135, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/dirt.png"));
		this.blit(ms, this.leftPos + 5, this.topPos + 166, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/erable_log.png"));
		this.blit(ms, this.leftPos + 118, this.topPos + 38, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/wool_colored_white.png"));
		this.blit(ms, this.leftPos + 118, this.topPos + 70, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/bedrock.png"));
		this.blit(ms, this.leftPos + 118, this.topPos + 101, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/air_scre.png"));
		this.blit(ms, this.leftPos + 118, this.topPos + 133, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/shulker_screen.png"));
		this.blit(ms, this.leftPos + 118, this.topPos + 165, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/stone32.png"));
		this.blit(ms, this.leftPos + 231, this.topPos + 9, 0, 0, 32, 32, 32, 32);

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
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.analyserresult.label_ores"), 40, 40, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.analyserresult.label_endstone"), 39, 7, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.analyserresult.label_planks"), 38, 73, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.analyserresult.label_clay"), 153, 6, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.analyserresult.label_cobblestone"), 37, 99, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.analyserresult.label_chests"), 35, 137, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.analyserresult.label_dirt"), 37, 166, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.analyserresult.label_logs"), 151, 39, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.analyserresult.label_wool"), 153, 71, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.analyserresult.label_bedrock"), 151, 101, -12829636);
		this.font.draw(poseStack,

				AnalyreturnoresProcedure.execute(), 39, 59, -12829636);
		this.font.draw(poseStack,

				AnalyreturndirtProcedure.execute(), 37, 187, -12829636);
		this.font.draw(poseStack,

				AnalyreturnstoneProcedure.execute(), 268, 22, -12829636);
		this.font.draw(poseStack,

				AnalyreturnendstoneProcedure.execute(), 43, 24, -12829636);
		this.font.draw(poseStack,

				AnalyreturnairProcedure.execute(), 152, 148, -12829636);
		this.font.draw(poseStack,

				AnalyreturnshulkerProcedure.execute(), 152, 178, -12829636);
		this.font.draw(poseStack,

				AnalyreturnchestProcedure.execute(), 34, 148, -12829636);
		this.font.draw(poseStack,

				AnalyreturnwoolProcedure.execute(), 153, 84, -12829636);
		this.font.draw(poseStack,

				AnalyreturnbedrockProcedure.execute(), 152, 112, -12829636);
		this.font.draw(poseStack,

				AnalyreturncobbleProcedure.execute(), 39, 113, -12829636);
		this.font.draw(poseStack,

				AnalyreturnlogsProcedure.execute(), 153, 51, -12829636);
		this.font.draw(poseStack,

				AnalyreturnplanksProcedure.execute(), 38, 84, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.analyserresult.label_air"), 151, 130, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.analyserresult.label_stone"), 267, 9, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.analyserresult.label_shulker"), 151, 165, -12829636);
		this.font.draw(poseStack,

				AnalyreturnclayProcedure.execute(), 151, 22, -12829636);
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
	}
}
