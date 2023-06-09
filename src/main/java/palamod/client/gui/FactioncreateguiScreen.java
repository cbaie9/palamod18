
package palamod.client.gui;

import palamod.world.inventory.FactioncreateguiMenu;

import palamod.network.FactioncreateguiButtonMessage;

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

public class FactioncreateguiScreen extends AbstractContainerScreen<FactioncreateguiMenu> {
	private final static HashMap<String, Object> guistate = FactioncreateguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox faction_name_input_bow;
	Button button_creer;
	Button button_annuler;

	public FactioncreateguiScreen(FactioncreateguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 200;
		this.imageHeight = 200;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/screens/factioncreategui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		faction_name_input_bow.render(ms, mouseX, mouseY, partialTicks);
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
		if (faction_name_input_bow.isFocused())
			return faction_name_input_bow.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		faction_name_input_bow.tick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.factioncreategui.label_creer_un_faction_coute"), 5, 3, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.factioncreategui.label_100_lingot"), 123, 4, -65536);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.factioncreategui.label_nom"), 54, 53, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.factioncreategui.label_inserer_les_lingot"), 12, 35, -16737946);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.factioncreategui.label_de_paladium"), 5, 14, -65536);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.factioncreategui.label_varfaction_create_ing"), 68, 71, -10027162);
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
		faction_name_input_bow = new EditBox(this.font, this.leftPos + 76, this.topPos + 47, 120, 20, new TranslatableComponent("gui.palamod.factioncreategui.faction_name_input_bow")) {
			{
				setSuggestion(new TranslatableComponent("gui.palamod.factioncreategui.faction_name_input_bow").getString());
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(new TranslatableComponent("gui.palamod.factioncreategui.faction_name_input_bow").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(new TranslatableComponent("gui.palamod.factioncreategui.faction_name_input_bow").getString());
				else
					setSuggestion(null);
			}
		};
		faction_name_input_bow.setMaxLength(32767);
		guistate.put("text:faction_name_input_bow", faction_name_input_bow);
		this.addWidget(this.faction_name_input_bow);
		button_creer = new Button(this.leftPos + 18, this.topPos + 95, 51, 20, new TranslatableComponent("gui.palamod.factioncreategui.button_creer"), e -> {
		});
		guistate.put("button:button_creer", button_creer);
		this.addRenderableWidget(button_creer);
		button_annuler = new Button(this.leftPos + 118, this.topPos + 95, 61, 20, new TranslatableComponent("gui.palamod.factioncreategui.button_annuler"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new FactioncreateguiButtonMessage(1, x, y, z));
				FactioncreateguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_annuler", button_annuler);
		this.addRenderableWidget(button_annuler);
	}
}
