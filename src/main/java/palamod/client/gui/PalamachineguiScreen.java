
package palamod.client.gui;

import palamod.world.inventory.PalamachineguiMenu;

import palamod.procedures.Palamachinesubprocess9Procedure;
import palamod.procedures.Palamachinesubprocess8Procedure;
import palamod.procedures.Palamachinesubprocess7Procedure;
import palamod.procedures.Palamachinesubprocess6Procedure;
import palamod.procedures.Palamachinesubprocess5Procedure;
import palamod.procedures.Palamachinesubprocess4Procedure;
import palamod.procedures.Palamachinesubprocess3Procedure;
import palamod.procedures.Palamachinesubprocess1Procedure;
import palamod.procedures.Palamachinesubprocess11Procedure;
import palamod.procedures.Palamachinesubprocess10Procedure;
import palamod.procedures.Palafurnacesubprocess2Procedure;
import palamod.procedures.Grindertrans0Procedure;

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

public class PalamachineguiScreen extends AbstractContainerScreen<PalamachineguiMenu> {
	private final static HashMap<String, Object> guistate = PalamachineguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public PalamachineguiScreen(PalamachineguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/screens/palamachinegui.png");

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
		if (Palamachinesubprocess1Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/palamchine_load1.png"));
			this.blit(ms, this.leftPos + 79, this.topPos + 42, 0, 0, 9, 11, 9, 11);
		}
		if (Palafurnacesubprocess2Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/palamachine_load2.png"));
			this.blit(ms, this.leftPos + 79, this.topPos + 42, 0, 0, 9, 11, 9, 11);
		}
		if (Palamachinesubprocess3Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/palamachine_load3.png"));
			this.blit(ms, this.leftPos + 79, this.topPos + 42, 0, 0, 9, 11, 9, 11);
		}
		if (Palamachinesubprocess4Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/palamachine_load4.png"));
			this.blit(ms, this.leftPos + 79, this.topPos + 42, 0, 0, 9, 11, 9, 11);
		}
		if (Palamachinesubprocess5Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/palamachine_load5.png"));
			this.blit(ms, this.leftPos + 79, this.topPos + 42, 0, 0, 9, 11, 9, 11);
		}
		if (Palamachinesubprocess6Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/palamachine_load6.png"));
			this.blit(ms, this.leftPos + 79, this.topPos + 42, 0, 0, 9, 11, 9, 11);
		}
		if (Palamachinesubprocess7Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/palamachine_load7.png"));
			this.blit(ms, this.leftPos + 79, this.topPos + 42, 0, 0, 9, 11, 9, 11);
		}
		if (Palamachinesubprocess8Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/palamachine_load8.png"));
			this.blit(ms, this.leftPos + 79, this.topPos + 42, 0, 0, 9, 11, 9, 11);
		}
		if (Palamachinesubprocess9Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/palamachine_load9.png"));
			this.blit(ms, this.leftPos + 79, this.topPos + 42, 0, 0, 9, 11, 9, 11);
		}
		if (Palamachinesubprocess10Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/palamachine_load10.png"));
			this.blit(ms, this.leftPos + 79, this.topPos + 42, 0, 0, 9, 11, 9, 11);
		}
		if (Palamachinesubprocess11Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/palamachine_load11.png"));
			this.blit(ms, this.leftPos + 79, this.topPos + 42, 0, 0, 9, 11, 9, 11);
		}
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
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.palamachinegui.label_palamachine"), 57, 4, -3407872);
		this.font.draw(poseStack,

				Grindertrans0Procedure.execute(entity), 4, 72, -12829636);
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
