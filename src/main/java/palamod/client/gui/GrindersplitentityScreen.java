
package palamod.client.gui;

import palamod.world.inventory.GrindersplitentityMenu;

import palamod.procedures.Grindersubprocessarrowsplit9Procedure;
import palamod.procedures.Grindersubprocessarrowsplit8Procedure;
import palamod.procedures.Grindersubprocessarrowsplit7Procedure;
import palamod.procedures.Grindersubprocessarrowsplit6Procedure;
import palamod.procedures.Grindersubprocessarrowsplit5Procedure;
import palamod.procedures.Grindersubprocessarrowsplit4Procedure;
import palamod.procedures.Grindersubprocessarrowsplit3Procedure;
import palamod.procedures.Grindersubprocessarrowsplit2Procedure;
import palamod.procedures.Grindersubprocessarrowsplit1Procedure;
import palamod.procedures.Grindersubprocessarrowsplit10Procedure;

import palamod.network.GrindersplitentityButtonMessage;

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

public class GrindersplitentityScreen extends AbstractContainerScreen<GrindersplitentityMenu> {
	private final static HashMap<String, Object> guistate = GrindersplitentityMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_code;

	public GrindersplitentityScreen(GrindersplitentityMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 196;
		this.imageHeight = 120;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/screens/grindersplitentity.png");

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
		if (Grindersubprocessarrowsplit1Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/arrow_1red_new.png"));
			this.blit(ms, this.leftPos + 79, this.topPos + 8, 0, 0, 48, 20, 48, 20);
		}
		if (Grindersubprocessarrowsplit1Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/arrow_3red_new.png"));
			this.blit(ms, this.leftPos + 79, this.topPos + 8, 0, 0, 48, 20, 48, 20);
		}
		if (Grindersubprocessarrowsplit2Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/arrow_5red_new.png"));
			this.blit(ms, this.leftPos + 79, this.topPos + 8, 0, 0, 48, 20, 48, 20);
		}
		if (Grindersubprocessarrowsplit3Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/arrow_7red_new.png"));
			this.blit(ms, this.leftPos + 79, this.topPos + 8, 0, 0, 48, 20, 48, 20);
		}
		if (Grindersubprocessarrowsplit4Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/arrow_9red_new.png"));
			this.blit(ms, this.leftPos + 79, this.topPos + 8, 0, 0, 48, 20, 48, 20);
		}
		if (Grindersubprocessarrowsplit5Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/arrow_11red_new.png"));
			this.blit(ms, this.leftPos + 79, this.topPos + 8, 0, 0, 48, 20, 48, 20);
		}
		if (Grindersubprocessarrowsplit6Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/arrow_13red_new.png"));
			this.blit(ms, this.leftPos + 79, this.topPos + 8, 0, 0, 48, 20, 48, 20);
		}
		if (Grindersubprocessarrowsplit7Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/arrow_15red_new.png"));
			this.blit(ms, this.leftPos + 79, this.topPos + 8, 0, 0, 48, 20, 48, 20);
		}
		if (Grindersubprocessarrowsplit8Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/arrow_17red_new.png"));
			this.blit(ms, this.leftPos + 79, this.topPos + 8, 0, 0, 48, 20, 48, 20);
		}
		if (Grindersubprocessarrowsplit9Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/arrow_18red_new.png"));
			this.blit(ms, this.leftPos + 79, this.topPos + 8, 0, 0, 48, 20, 48, 20);
		}
		if (Grindersubprocessarrowsplit10Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/arrow_19red_new.png"));
			this.blit(ms, this.leftPos + 79, this.topPos + 8, 0, 0, 48, 20, 48, 20);
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
		button_code = new Button(this.leftPos + 3, this.topPos + 10, 46, 20, new TranslatableComponent("gui.palamod.grindersplitentity.button_code"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new GrindersplitentityButtonMessage(0, x, y, z));
				GrindersplitentityButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_code", button_code);
		this.addRenderableWidget(button_code);
	}
}
