
package palamod.client.gui;

import palamod.world.inventory.PalahelpnotsupportedMenu;

import palamod.network.PalahelpnotsupportedButtonMessage;

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

public class PalahelpnotsupportedScreen extends AbstractContainerScreen<PalahelpnotsupportedMenu> {
	private final static HashMap<String, Object> guistate = PalahelpnotsupportedMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_crowdin_link;
	Button button_language;
	Button button_exit;
	Button button_back;

	public PalahelpnotsupportedScreen(PalahelpnotsupportedMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 190;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/screens/palahelpnotsupported.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/sad_ntsuport.png"));
		this.blit(ms, this.leftPos + 14, this.topPos + 5, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/sad_ntsuport.png"));
		this.blit(ms, this.leftPos + 143, this.topPos + 6, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/sad_ntsuport.png"));
		this.blit(ms, this.leftPos + 14, this.topPos + 127, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/sad_ntsuport.png"));
		this.blit(ms, this.leftPos + 143, this.topPos + 127, 0, 0, 32, 32, 32, 32);

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
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.palahelpnotsupported.label_an_error_has_been_encountred"), 14, 39, -26368);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.palahelpnotsupported.label_palahelp_error"), 49, 7, -65485);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.palahelpnotsupported.label_your_language_is_not_supported"), 12, 53, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.palahelpnotsupported.label_your_can_help_for_translation"), 5, 74, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.palahelpnotsupported.label_on_crowdin"), 4, 86, -12829636);
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
		button_crowdin_link = new Button(this.leftPos + 50, this.topPos + 137, 87, 20, new TranslatableComponent("gui.palamod.palahelpnotsupported.button_crowdin_link"), e -> {
		});
		guistate.put("button:button_crowdin_link", button_crowdin_link);
		this.addRenderableWidget(button_crowdin_link);
		button_language = new Button(this.leftPos + 4, this.topPos + 103, 67, 20, new TranslatableComponent("gui.palamod.palahelpnotsupported.button_language"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalahelpnotsupportedButtonMessage(1, x, y, z));
				PalahelpnotsupportedButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_language", button_language);
		this.addRenderableWidget(button_language);
		button_exit = new Button(this.leftPos + 76, this.topPos + 103, 46, 20, new TranslatableComponent("gui.palamod.palahelpnotsupported.button_exit"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalahelpnotsupportedButtonMessage(2, x, y, z));
				PalahelpnotsupportedButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_exit", button_exit);
		this.addRenderableWidget(button_exit);
		button_back = new Button(this.leftPos + 135, this.topPos + 103, 46, 20, new TranslatableComponent("gui.palamod.palahelpnotsupported.button_back"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalahelpnotsupportedButtonMessage(3, x, y, z));
				PalahelpnotsupportedButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:button_back", button_back);
		this.addRenderableWidget(button_back);
	}
}
