package palamod.procedures;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModBlocks;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.GameType;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import java.util.Iterator;
import java.util.HashMap;

public class PhonecodeProcedure {
	public static void execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		if (!(entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel && _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("palamod:achmluckyphone"))).isDone())) {
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("palamod:achmluckyphone"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemainingCriteria().iterator();
					while (_iterator.hasNext())
						_player.getAdvancements().award(_adv, (String) _iterator.next());
				}
			}
		}
		if ((guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("cbaie9")
				|| (guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("cb9")
				|| (guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("4009")) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(PalamodModBlocks.FAKEPALADIUMORE.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			entity.hurt(DamageSource.GENERIC, 1);
			if (entity instanceof Player _player)
				_player.closeContainer();
		} else if ((guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("Combocircle")
				|| (guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("CombocircleZ")
				|| (guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("Combocircle123")
				|| (guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("CombocircleZ123")) {
			if (entity instanceof ServerPlayer _player)
				_player.setGameMode(GameType.ADVENTURE);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("msg @s an cheater has been detected"), false);
			if (entity instanceof Player _player)
				_player.closeContainer();
		} else if ((guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("reset.gamemode")) {
			if (entity instanceof ServerPlayer _player)
				_player.setGameMode(GameType.SURVIVAL);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("reset.gamemode has been succesful executed You now in gamemode survival"), false);
			if (entity instanceof Player _player)
				_player.closeContainer();
		} else if ((guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("Wolfen")
				|| (guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("wolfen")) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(Items.LEAD);
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("No suicide today please. Suicide is bad :{"), false);
			if (entity instanceof Player _player)
				_player.closeContainer();
		} else if ((guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("jojo")
				|| (guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("wlf")
				|| (guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("jojo_xd30")) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUM_SWORD.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("msg @p Jojo veut la mort de quelqu'un ici"), false);
		} else if ((guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("fufu")
				|| (guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("fufuBS1")
				|| (guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("BS1")) {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("Rejoins le serveur communautaire https://discord.gg/3J772jpRt2"), false);
		} else if ((guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("Hat")
				|| (guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("hat")
				|| (guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("HAT")) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUMARMORCUSTOM_2_HELMET.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("Voila un chapeau Monsieur"), false);
		} else if ((guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("Arthurninja69800")
				|| (guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("arthurninja69800")
				|| (guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("Arthurninja")) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUM_PICKAXE.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("Eh ben maintenant tu peux aller miner des chose et se sera positif"), false);
		} else if ((guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("help")
				|| (guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("/?")
				|| (guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("dir")) {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("Paladium system program"), false);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("dir : M:/"), false);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("Textures"), false);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("Crafts"), false);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("Codeultracheats2235.txt"), false);
		} else if ((guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("open Codeultracheats2235.txt")) {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("Paladium system program"), false);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("dir : M:/Codeultracheats2235.txt"), false);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("text file : Le code du cheats est "), false);
		} else if ((guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("0259.cf42214")) {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("Cheats Activated"), false);
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(PalamodModItems.LEGENDARYSTONEPOWER.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			(new ItemStack(PalamodModItems.LEGENDARYSTONEPOWER.get())).setHoverName(new TextComponent("Legudary diorite of unPower"));
		} else if ((guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("alo")
				|| (guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("allo")) {
			if (Math.random() < 0.5) {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(new TextComponent("a l'huile"), false);
			} else {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(new TextComponent("a hopital"), false);
			}
		}
	}
}
