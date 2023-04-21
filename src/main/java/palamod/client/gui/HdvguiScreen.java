
package palamod.client.gui;

import palamod.world.inventory.HdvguiMenu;

import palamod.network.HdvguiButtonMessage;

import palamod.PalamodMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class HdvguiScreen extends AbstractContainerScreen<HdvguiMenu> {
	private final static HashMap<String, Object> guistate = HdvguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox recs;
	Button button_suivant;
	Button button_aide;
	Button button_buy;
	Button button_mettre_en_vente_un_article;
	Button button_buy1;
	Button button_buy2;
	Button button_buy3;

	public HdvguiScreen(HdvguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 300;
		this.imageHeight = 225;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/screens/hdvgui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		recs.render(ms, mouseX, mouseY, partialTicks);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/beta_block.png"));
		this.blit(ms, this.leftPos + 7, this.topPos + 74, 0, 0, 16, 16, 16, 16);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (recs.isFocused())
			return recs.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		recs.tick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.hdvgui.label_hotel_de_vente"), 47, 5, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.hdvgui.label_wip_build_0031"), 220, 4, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.hdvgui.label_premium"), 7, 59, -26368);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.hdvgui.label_barre_de_recherche"), 10, 20, -12829636);
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
		recs = new EditBox(this.font, this.leftPos + 7, this.topPos + 33, 120, 20, new TranslatableComponent("gui.palamod.hdvgui.recs")) {
			{
				setSuggestion(new TranslatableComponent("gui.palamod.hdvgui.recs").getString());
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(new TranslatableComponent("gui.palamod.hdvgui.recs").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(new TranslatableComponent("gui.palamod.hdvgui.recs").getString());
				else
					setSuggestion(null);
			}
		};
		recs.setMaxLength(32767);
		guistate.put("text:recs", recs);
		this.addWidget(this.recs);
		button_suivant = new Button(this.leftPos + 234, this.topPos + 194, 61, 20, new TranslatableComponent("gui.palamod.hdvgui.button_suivant"), e -> {
		});
		guistate.put("button:button_suivant", button_suivant);
		this.addRenderableWidget(button_suivant);
		button_aide = new Button(this.leftPos + 178, this.topPos + 194, 46, 20, new TranslatableComponent("gui.palamod.hdvgui.button_aide"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new HdvguiButtonMessage(1, x, y, z));
				HdvguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_aide", button_aide);
		this.addRenderableWidget(button_aide);
		button_buy = new Button(this.leftPos + 234, this.topPos + 71, 40, 20, new TranslatableComponent("gui.palamod.hdvgui.button_buy"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new HdvguiButtonMessage(2, x, y, z));
				HdvguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_buy", button_buy);
		this.addRenderableWidget(button_buy);
		button_mettre_en_vente_un_article = new Button(this.leftPos + 9, this.topPos + 194, 160, 20, new TranslatableComponent("gui.palamod.hdvgui.button_mettre_en_vente_un_article"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new HdvguiButtonMessage(3, x, y, z));
				HdvguiButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:button_mettre_en_vente_un_article", button_mettre_en_vente_un_article);
		this.addRenderableWidget(button_mettre_en_vente_un_article);
		button_buy1 = new Button(this.leftPos + 234, this.topPos + 94, 40, 20, new TranslatableComponent("gui.palamod.hdvgui.button_buy1"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new HdvguiButtonMessage(4, x, y, z));
				HdvguiButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:button_buy1", button_buy1);
		this.addRenderableWidget(button_buy1);
		button_buy2 = new Button(this.leftPos + 234, this.topPos + 119, 40, 20, new TranslatableComponent("gui.palamod.hdvgui.button_buy2"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new HdvguiButtonMessage(5, x, y, z));
				HdvguiButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:button_buy2", button_buy2);
		this.addRenderableWidget(button_buy2);
		button_buy3 = new Button(this.leftPos + 234, this.topPos + 143, 40, 20, new TranslatableComponent("gui.palamod.hdvgui.button_buy3"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new HdvguiButtonMessage(6, x, y, z));
				HdvguiButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		});
		guistate.put("button:button_buy3", button_buy3);
		this.addRenderableWidget(button_buy3);
	}
}
