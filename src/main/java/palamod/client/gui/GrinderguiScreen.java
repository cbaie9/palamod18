
package palamod.client.gui;

import palamod.world.inventory.GrinderguiMenu;

import palamod.procedures.Grindertrans1Procedure;
import palamod.procedures.Grindertrans0Procedure;
import palamod.procedures.Grindersubprocessarrowinsertn4Procedure;
import palamod.procedures.Grindersubprocessarrowinsertn3Procedure;
import palamod.procedures.Grindersubprocessarrowinsertn2Procedure;
import palamod.procedures.Grindersubprocessarrowinsertn1Procedure;
import palamod.procedures.Grindersubprocessarrowinsertn0Procedure;
import palamod.procedures.Grinderguiarrow2n9Procedure;
import palamod.procedures.Grinderguiarrow2n8Procedure;
import palamod.procedures.Grinderguiarrow2n7Procedure;
import palamod.procedures.Grinderguiarrow2n6Procedure;
import palamod.procedures.Grinderguiarrow2n5Procedure;
import palamod.procedures.Grinderguiarrow2n4Procedure;
import palamod.procedures.Grinderguiarrow2n3Procedure;
import palamod.procedures.Grinderguiarrow2n2Procedure;
import palamod.procedures.Grinderguiarrow2n1Procedure;
import palamod.procedures.Grinderguiarrow2n10Procedure;
import palamod.procedures.Grinderguiarrow2n0Procedure;

import palamod.network.GrinderguiButtonMessage;

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

public class GrinderguiScreen extends AbstractContainerScreen<GrinderguiMenu> {
	private final static HashMap<String, Object> guistate = GrinderguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_upgrade;
	Button button_help;

	public GrinderguiScreen(GrinderguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 195;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/screens/grindergui.png");

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
		if (Grinderguiarrow2n0Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/arrow_1red_new.png"));
			this.blit(ms, this.leftPos + 33, this.topPos + 30, 0, 0, 24, 10, 24, 10);
		}
		if (Grindersubprocessarrowinsertn0Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/arr0.png"));
			this.blit(ms, this.leftPos + 137, this.topPos + 81, 0, 0, 32, 16, 32, 16);
		}

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/gnew_indicator.png"));
		this.blit(ms, this.leftPos + 102, this.topPos + 12, 0, 0, 64, 64, 64, 64);

		if (Grinderguiarrow2n1Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/arrow_3red_new.png"));
			this.blit(ms, this.leftPos + 33, this.topPos + 30, 0, 0, 24, 10, 24, 10);
		}
		if (Grinderguiarrow2n2Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/arrow_5red_new.png"));
			this.blit(ms, this.leftPos + 33, this.topPos + 30, 0, 0, 24, 10, 24, 10);
		}
		if (Grinderguiarrow2n3Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/arrow_7red_new.png"));
			this.blit(ms, this.leftPos + 33, this.topPos + 30, 0, 0, 24, 10, 24, 10);
		}
		if (Grinderguiarrow2n4Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/arrow_9red_new.png"));
			this.blit(ms, this.leftPos + 33, this.topPos + 30, 0, 0, 24, 10, 24, 10);
		}
		if (Grinderguiarrow2n5Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/arrow_11red_new.png"));
			this.blit(ms, this.leftPos + 33, this.topPos + 30, 0, 0, 24, 10, 24, 10);
		}
		if (Grinderguiarrow2n6Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/arrow_13red_new.png"));
			this.blit(ms, this.leftPos + 33, this.topPos + 30, 0, 0, 24, 10, 24, 10);
		}
		if (Grinderguiarrow2n7Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/arrow_15red_new.png"));
			this.blit(ms, this.leftPos + 33, this.topPos + 30, 0, 0, 24, 10, 24, 10);
		}
		if (Grinderguiarrow2n8Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/arrow_17red_new.png"));
			this.blit(ms, this.leftPos + 33, this.topPos + 30, 0, 0, 24, 10, 24, 10);
		}
		if (Grinderguiarrow2n9Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/arrow_18red_new.png"));
			this.blit(ms, this.leftPos + 33, this.topPos + 30, 0, 0, 24, 10, 24, 10);
		}
		if (Grindersubprocessarrowinsertn1Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/arr1.png"));
			this.blit(ms, this.leftPos + 137, this.topPos + 81, 0, 0, 32, 16, 32, 16);
		}
		if (Grindersubprocessarrowinsertn2Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/arr2.png"));
			this.blit(ms, this.leftPos + 137, this.topPos + 81, 0, 0, 32, 16, 32, 16);
		}
		if (Grindersubprocessarrowinsertn3Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/arr3.png"));
			this.blit(ms, this.leftPos + 137, this.topPos + 81, 0, 0, 32, 16, 32, 16);
		}
		if (Grindersubprocessarrowinsertn4Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/arr4.png"));
			this.blit(ms, this.leftPos + 137, this.topPos + 81, 0, 0, 32, 16, 32, 16);
		}
		if (Grinderguiarrow2n10Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/arrow_19red_new.png"));
			this.blit(ms, this.leftPos + 33, this.topPos + 30, 0, 0, 24, 10, 24, 10);
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
		this.font.draw(poseStack,

				Grindertrans1Procedure.execute(), 82, 100, -12829636);
		this.font.draw(poseStack,

				Grindertrans0Procedure.execute(entity), 6, 101, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.grindergui.label_grinder_v41_noautotick"), 15, 1, -12829636);
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
		button_upgrade = new Button(this.leftPos + 7, this.topPos + 77, 76, 20, new TranslatableComponent("gui.palamod.grindergui.button_upgrade"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new GrinderguiButtonMessage(0, x, y, z));
				GrinderguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_upgrade", button_upgrade);
		this.addRenderableWidget(button_upgrade);
		button_help = new Button(this.leftPos + 7, this.topPos + 57, 42, 20, new TranslatableComponent("gui.palamod.grindergui.button_help"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new GrinderguiButtonMessage(1, x, y, z));
				GrinderguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_help", button_help);
		this.addRenderableWidget(button_help);
	}
}
