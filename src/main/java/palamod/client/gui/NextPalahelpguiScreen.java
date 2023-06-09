
package palamod.client.gui;

import palamod.world.inventory.NextPalahelpguiMenu;

import palamod.network.NextPalahelpguiButtonMessage;

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

public class NextPalahelpguiScreen extends AbstractContainerScreen<NextPalahelpguiMenu> {
	private final static HashMap<String, Object> guistate = NextPalahelpguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_commands;
	Button button_lucky_stats;
	Button button_back;

	public NextPalahelpguiScreen(NextPalahelpguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/screens/next_palahelpgui.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/palablock_green_palahelp2-removebg-preview_1.png"));
		this.blit(ms, this.leftPos + 5, this.topPos + 20, 0, 0, 75, 80, 75, 80);

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
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.next_palahelpgui.label_palahelp"), 5, 4, -52429);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.next_palahelpgui.label_22"), 4, 102, -16750951);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.next_palahelpgui.label_more_in_the_future"), 63, 111, -12829636);
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
		button_commands = new Button(this.leftPos + 87, this.topPos + 24, 80, 20, new TranslatableComponent("gui.palamod.next_palahelpgui.button_commands"), e -> {
		});
		guistate.put("button:button_commands", button_commands);
		this.addRenderableWidget(button_commands);
		button_lucky_stats = new Button(this.leftPos + 87, this.topPos + 56, 80, 20, new TranslatableComponent("gui.palamod.next_palahelpgui.button_lucky_stats"), e -> {
		});
		guistate.put("button:button_lucky_stats", button_lucky_stats);
		this.addRenderableWidget(button_lucky_stats);
		button_back = new Button(this.leftPos + 6, this.topPos + 134, 75, 20, new TranslatableComponent("gui.palamod.next_palahelpgui.button_back"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new NextPalahelpguiButtonMessage(2, x, y, z));
				NextPalahelpguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_back", button_back);
		this.addRenderableWidget(button_back);
	}
}
