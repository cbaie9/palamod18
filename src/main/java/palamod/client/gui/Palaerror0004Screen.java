
package palamod.client.gui;

import palamod.world.inventory.Palaerror0004Menu;

import palamod.network.Palaerror0004ButtonMessage;

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

public class Palaerror0004Screen extends AbstractContainerScreen<Palaerror0004Menu> {
	private final static HashMap<String, Object> guistate = Palaerror0004Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_return_to_hdv;

	public Palaerror0004Screen(Palaerror0004Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 70;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/screens/palaerror_0004.png");

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
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.palaerror_0004.label_err0r_0004_hdv"), 45, 3, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.palaerror_0004.label_this_item_has_already_been_bough"), 0, 14, -12829636);
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
		button_return_to_hdv = new Button(this.leftPos + 39, this.topPos + 42, 92, 20, new TranslatableComponent("gui.palamod.palaerror_0004.button_return_to_hdv"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new Palaerror0004ButtonMessage(0, x, y, z));
				Palaerror0004ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_return_to_hdv", button_return_to_hdv);
		this.addRenderableWidget(button_return_to_hdv);
	}
}
