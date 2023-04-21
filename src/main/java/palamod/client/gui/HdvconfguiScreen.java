
package palamod.client.gui;

import palamod.world.inventory.HdvconfguiMenu;

import palamod.network.HdvconfguiButtonMessage;

import palamod.PalamodMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class HdvconfguiScreen extends AbstractContainerScreen<HdvconfguiMenu> {
	private final static HashMap<String, Object> guistate = HdvconfguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_revenir_au_shop;
	Button button_acheter;

	public HdvconfguiScreen(HdvconfguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 255;
		this.imageHeight = 166;
	}

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
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.hdvconfgui.label_vous_allez_acheter"), 7, 13, -13369600);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.hdvconfgui.label_varmarket_conf_name"), 109, 14, -16764058);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.hdvconfgui.label_a_varmarket_conf_price"), 6, 26, -13369600);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.hdvconfgui.label_cette_action_est_irreversible"), 53, 116, -3407821);
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
		button_revenir_au_shop = new Button(this.leftPos + 5, this.topPos + 136, 103, 20, new TranslatableComponent("gui.palamod.hdvconfgui.button_revenir_au_shop"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new HdvconfguiButtonMessage(0, x, y, z));
				HdvconfguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_revenir_au_shop", button_revenir_au_shop);
		this.addRenderableWidget(button_revenir_au_shop);
		button_acheter = new Button(this.leftPos + 188, this.topPos + 136, 61, 20, new TranslatableComponent("gui.palamod.hdvconfgui.button_acheter"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new HdvconfguiButtonMessage(1, x, y, z));
				HdvconfguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_acheter", button_acheter);
		this.addRenderableWidget(button_acheter);
	}
}
