
package palamod.client.gui;

import palamod.world.inventory.Adminshopmobs2Menu;

import palamod.network.Adminshopmobs2ButtonMessage;

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

public class Adminshopmobs2Screen extends AbstractContainerScreen<Adminshopmobs2Menu> {
	private final static HashMap<String, Object> guistate = Adminshopmobs2Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_back;
	Button button_exit;
	Button button_next;
	Button button_honey_comb;
	Button button_leather;
	Button button_feather;
	Button button_ink_sac;
	Button button_glow_in_sac;
	Button button_blaze;
	Button button_gun_powder;
	Button button_steak;

	public Adminshopmobs2Screen(Adminshopmobs2Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 190;
		this.imageHeight = 200;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/screens/adminshopmobs_2.png");

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
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.adminshopmobs_2.label_adminshop_plant_section"), 12, 5, -52480);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.adminshopmobs_2.label_page_2"), 11, 13, -12829636);
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
		button_back = new Button(this.leftPos + 4, this.topPos + 174, 46, 20, new TranslatableComponent("gui.palamod.adminshopmobs_2.button_back"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new Adminshopmobs2ButtonMessage(0, x, y, z));
				Adminshopmobs2ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_back", button_back);
		this.addRenderableWidget(button_back);
		button_exit = new Button(this.leftPos + 119, this.topPos + 174, 61, 20, new TranslatableComponent("gui.palamod.adminshopmobs_2.button_exit"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new Adminshopmobs2ButtonMessage(1, x, y, z));
				Adminshopmobs2ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_exit", button_exit);
		this.addRenderableWidget(button_exit);
		button_next = new Button(this.leftPos + 63, this.topPos + 174, 46, 20, new TranslatableComponent("gui.palamod.adminshopmobs_2.button_next"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new Adminshopmobs2ButtonMessage(2, x, y, z));
				Adminshopmobs2ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_next", button_next);
		this.addRenderableWidget(button_next);
		button_honey_comb = new Button(this.leftPos + 9, this.topPos + 135, 77, 20, new TranslatableComponent("gui.palamod.adminshopmobs_2.button_honey_comb"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new Adminshopmobs2ButtonMessage(3, x, y, z));
				Adminshopmobs2ButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:button_honey_comb", button_honey_comb);
		this.addRenderableWidget(button_honey_comb);
		button_leather = new Button(this.leftPos + 115, this.topPos + 135, 61, 20, new TranslatableComponent("gui.palamod.adminshopmobs_2.button_leather"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new Adminshopmobs2ButtonMessage(4, x, y, z));
				Adminshopmobs2ButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:button_leather", button_leather);
		this.addRenderableWidget(button_leather);
		button_feather = new Button(this.leftPos + 116, this.topPos + 104, 61, 20, new TranslatableComponent("gui.palamod.adminshopmobs_2.button_feather"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new Adminshopmobs2ButtonMessage(5, x, y, z));
				Adminshopmobs2ButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:button_feather", button_feather);
		this.addRenderableWidget(button_feather);
		button_ink_sac = new Button(this.leftPos + 116, this.topPos + 77, 61, 20, new TranslatableComponent("gui.palamod.adminshopmobs_2.button_ink_sac"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new Adminshopmobs2ButtonMessage(6, x, y, z));
				Adminshopmobs2ButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		});
		guistate.put("button:button_ink_sac", button_ink_sac);
		this.addRenderableWidget(button_ink_sac);
		button_glow_in_sac = new Button(this.leftPos + 10, this.topPos + 104, 82, 20, new TranslatableComponent("gui.palamod.adminshopmobs_2.button_glow_in_sac"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new Adminshopmobs2ButtonMessage(7, x, y, z));
				Adminshopmobs2ButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		});
		guistate.put("button:button_glow_in_sac", button_glow_in_sac);
		this.addRenderableWidget(button_glow_in_sac);
		button_blaze = new Button(this.leftPos + 10, this.topPos + 77, 51, 20, new TranslatableComponent("gui.palamod.adminshopmobs_2.button_blaze"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new Adminshopmobs2ButtonMessage(8, x, y, z));
				Adminshopmobs2ButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		});
		guistate.put("button:button_blaze", button_blaze);
		this.addRenderableWidget(button_blaze);
		button_gun_powder = new Button(this.leftPos + 100, this.topPos + 47, 77, 20, new TranslatableComponent("gui.palamod.adminshopmobs_2.button_gun_powder"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new Adminshopmobs2ButtonMessage(9, x, y, z));
				Adminshopmobs2ButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		});
		guistate.put("button:button_gun_powder", button_gun_powder);
		this.addRenderableWidget(button_gun_powder);
		button_steak = new Button(this.leftPos + 10, this.topPos + 46, 51, 20, new TranslatableComponent("gui.palamod.adminshopmobs_2.button_steak"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new Adminshopmobs2ButtonMessage(10, x, y, z));
				Adminshopmobs2ButtonMessage.handleButtonAction(entity, 10, x, y, z);
			}
		});
		guistate.put("button:button_steak", button_steak);
		this.addRenderableWidget(button_steak);
	}
}
