
package palamod.client.gui;

import palamod.world.inventory.Palahelpgui1Menu;

import palamod.procedures.Palahelpgui1ValueProcedure;

import palamod.network.Palahelpgui1ButtonMessage;

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

public class Palahelpgui1Screen extends AbstractContainerScreen<Palahelpgui1Menu> {
	private final static HashMap<String, Object> guistate = Palahelpgui1Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_blocks;
	Button button_items;
	Button button_gui;
	Button button_next;
	Button button_lucky_blocks;
	Button button_metiers_soon;

	public Palahelpgui1Screen(Palahelpgui1Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/screens/palahelpgui_1.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/palablock_palahelp1-removebg-preview.png"));
		this.blit(ms, this.leftPos + 3, this.topPos + 19, 0, 0, 100, 100, 100, 100);

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
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.palahelpgui_1.label_palahelp"), 6, 5, -52429);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.palahelpgui_1.label_12"), 6, 147, -16750951);
		this.font.draw(poseStack,

				Palahelpgui1ValueProcedure.execute(entity), 87, 82, -12829636);
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
		button_blocks = new Button(this.leftPos + 88, this.topPos + 6, 81, 20, new TranslatableComponent("gui.palamod.palahelpgui_1.button_blocks"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new Palahelpgui1ButtonMessage(0, x, y, z));
				Palahelpgui1ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_blocks", button_blocks);
		this.addRenderableWidget(button_blocks);
		button_items = new Button(this.leftPos + 88, this.topPos + 31, 81, 20, new TranslatableComponent("gui.palamod.palahelpgui_1.button_items"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new Palahelpgui1ButtonMessage(1, x, y, z));
				Palahelpgui1ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_items", button_items);
		this.addRenderableWidget(button_items);
		button_gui = new Button(this.leftPos + 88, this.topPos + 57, 81, 20, new TranslatableComponent("gui.palamod.palahelpgui_1.button_gui"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new Palahelpgui1ButtonMessage(2, x, y, z));
				Palahelpgui1ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_gui", button_gui);
		this.addRenderableWidget(button_gui);
		button_next = new Button(this.leftPos + 7, this.topPos + 123, 45, 20, new TranslatableComponent("gui.palamod.palahelpgui_1.button_next"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new Palahelpgui1ButtonMessage(3, x, y, z));
				Palahelpgui1ButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:button_next", button_next);
		this.addRenderableWidget(button_next);
		button_lucky_blocks = new Button(this.leftPos + 88, this.topPos + 122, 81, 20, new TranslatableComponent("gui.palamod.palahelpgui_1.button_lucky_blocks"), e -> {
		});
		guistate.put("button:button_lucky_blocks", button_lucky_blocks);
		this.addRenderableWidget(button_lucky_blocks);
		button_metiers_soon = new Button(this.leftPos + 88, this.topPos + 97, 81, 20, new TranslatableComponent("gui.palamod.palahelpgui_1.button_metiers_soon"), e -> {
		});
		guistate.put("button:button_metiers_soon", button_metiers_soon);
		this.addRenderableWidget(button_metiers_soon);
	}
}
