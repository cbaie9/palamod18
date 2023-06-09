
package palamod.client.gui;

import palamod.world.inventory.VoidstoneminerconfigMenu;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class VoidstoneminerconfigScreen extends AbstractContainerScreen<VoidstoneminerconfigMenu> {
	private final static HashMap<String, Object> guistate = VoidstoneminerconfigMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Checkbox mv_picon;

	public VoidstoneminerconfigScreen(VoidstoneminerconfigMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 200;
		this.imageHeight = 100;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/screens/voidstoneminerconfig.png");

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
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.voidstoneminerconfig.label_activer_le_deplacement_automatiq"), 2, 29, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.voidstoneminerconfig.label_voidstone_configuration"), 74, 4, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.voidstoneminerconfig.label_put_the_stone_into_the_voidst"), 5, 40, -12829636);
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
		mv_picon = new Checkbox(this.leftPos + 4, this.topPos + 4, 20, 20, new TranslatableComponent("gui.palamod.voidstoneminerconfig.mv_picon"), false);
		guistate.put("checkbox:mv_picon", mv_picon);
		this.addRenderableWidget(mv_picon);
	}
}
