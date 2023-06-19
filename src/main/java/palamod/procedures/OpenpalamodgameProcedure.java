package palamod.procedures;

import palamod.init.PalamodModBlocks;

import palamod.configuration.PalamodconfirgurationfileConfiguration;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class OpenpalamodgameProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity().level, event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!((world.getBlockState(new BlockPos(0, 10, 0))).getBlock() == PalamodModBlocks.NBTBLOCK.get())) {
			LunchallsetupProcedure.execute(world, entity);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("[ Palamod ] intern-setup are initalised, multiplayer function should work now"), false);
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos(0, 10, 0);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putString("servername", "nothing");
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if (!(entity.getPersistentData().getBoolean("Paladium_setupnbt") == true)) {
			entity.getPersistentData().putBoolean("Paladium_setupnbt", true);
			entity.getPersistentData().putBoolean("Palamod.alive", true);
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos(0, 10, 0);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putBoolean(("Minage_setlayer_dynamic_enda_" + entity.getDisplayName().getString()), true);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((PalamodconfirgurationfileConfiguration.LANGUAGE.get()).equals("french")) {
			entity.getPersistentData().putString("language", "french");
		} else if ((PalamodconfirgurationfileConfiguration.LANGUAGE.get()).equals("english")) {
			entity.getPersistentData().putString("language", "english");
		}
		if (world.isClientSide() || 1 <= world.players().size()) {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("Merci d'avoir installer le Palamod"), false);
			if (world.isClientSide()) {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal(PalamodgameverProcedure.execute(world)), false);
			} else {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal(PalamodgameserververProcedure.execute(world)), false);
			}
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("Cr\u00E9er par cb9 et fufu "), false);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("Aller soutenir le vrai palamod "), false);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("Le mod peut \u00EAtre instable due qu'il soit en beta, penser a le mettre a jour"), false);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("Bon jeu :)"), false);
		} else {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("Powered by Palamod Renew"), false);
			if (!("nothing").equals(new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getString(tag);
					return "";
				}
			}.getValue(world, new BlockPos(0, 10, 0), "servername"))) {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal(("Welcome to " + (new Object() {
						public String getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getString(tag);
							return "";
						}
					}.getValue(world, new BlockPos(0, 10, 0), "servername")))), false);
			} else {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal("Welcome to [get servername --> Palamodserverconfiog/toml ]"), false);
			}
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal(PalamodgameserververProcedure.execute(world)), false);
		}
	}
}
