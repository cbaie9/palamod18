
package palamod.client.gui;

import palamod.world.inventory.HdvhelpMenu;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class HdvhelpScreen extends AbstractContainerScreen<HdvhelpMenu> {
	private final static HashMap<String, Object> guistate = HdvhelpMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public HdvhelpScreen(HdvhelpMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 280;
		this.imageHeight = 200;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/screens/hdvhelp.png");

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
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.hdvhelp.label_hotel_de_vente_aide"), 19, 4, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.hdvhelp.label_lhotel_de_vente_est_un_endroit"), 18, 27, -10066330);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.hdvhelp.label_vendent_et_sachetent_des_items"), 19, 37, -10066330);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.hdvhelp.label_valeur_de_facon_securise_sans_in"), 16, 47, -10066330);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.hdvhelp.label_entre_les_joueurs"), 17, 57, -10066330);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.hdvhelp.label_pour_mettre_en_vente_un_objet_cl"), 18, 77, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.hdvhelp.label_longlet_correspondant_mettez_l"), 18, 88, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.hdvhelp.label_dans_le_slot_puis_selectionne_le"), 18, 98, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.hdvhelp.label_nom_qui_sera_affiche"), 18, 109, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.hdvhelp.label_pour_acheter_trouvez_un_item_in"), 17, 135, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.hdvhelp.label_appuyer_le_bouton_buy_puis_con"), 17, 144, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.hdvhelp.label_choix"), 18, 155, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.hdvhelp.label_vente"), 17, 67, -16751104);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.hdvhelp.label_achat"), 16, 125, -3407821);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.hdvhelp.label_toute_anarque_nest_pas_de_notre"), 16, 168, -16777012);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.hdvhelp.label_bug_les_exploit_sont_souvent_des"), 16, 176, -16777012);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.hdvhelp.label_prevue_soyez_prudent"), 17, 185, -16777012);
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
	}
}
