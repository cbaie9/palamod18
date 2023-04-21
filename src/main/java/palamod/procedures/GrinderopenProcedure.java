package palamod.procedures;

import palamod.world.inventory.GrinderguiMenu;

import palamod.init.PalamodModBlocks;

import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import io.netty.buffer.Unpooled;

public class GrinderopenProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == PalamodModBlocks.GRINDERFRAME.get() && (world.getBlockState(new BlockPos(x + 1, y - 1, z))).getBlock() == PalamodModBlocks.GRINDERFRAME.get()
				&& (world.getBlockState(new BlockPos(x - 1, y - 1, z))).getBlock() == PalamodModBlocks.GRINDERFRAME.get() && (world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == PalamodModBlocks.GRINDERFRAME.get()
				&& (world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == PalamodModBlocks.GRINDERFRAME.get() && (world.getBlockState(new BlockPos(x - 1, y + 1, z))).getBlock() == PalamodModBlocks.GRINDERFRAME.get()
				&& (world.getBlockState(new BlockPos(x + 1, y + 1, z))).getBlock() == PalamodModBlocks.GRINDERFRAME.get() && (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == PalamodModBlocks.GRINDERFRAME.get()
				&& (world.getBlockState(new BlockPos(x, y - 1, z - 1))).getBlock() == PalamodModBlocks.GRINDERCASING.get() && (world.getBlockState(new BlockPos(x + 1, y - 1, z - 1))).getBlock() == PalamodModBlocks.GRINDERFRAME.get()
				&& (world.getBlockState(new BlockPos(x - 1, y - 1, z - 1))).getBlock() == PalamodModBlocks.GRINDERFRAME.get() && (world.getBlockState(new BlockPos(x - 1, y, z - 1))).getBlock() == PalamodModBlocks.GRINDERCASING.get()
				&& (world.getBlockState(new BlockPos(x + 1, y, z - 1))).getBlock() == PalamodModBlocks.GRINDERCASING.get() && (world.getBlockState(new BlockPos(x - 1, y + 1, z - 1))).getBlock() == PalamodModBlocks.GRINDERFRAME.get()
				&& (world.getBlockState(new BlockPos(x + 1, y + 1, z - 1))).getBlock() == PalamodModBlocks.GRINDERFRAME.get() && (world.getBlockState(new BlockPos(x, y + 1, z - 1))).getBlock() == PalamodModBlocks.GRINDERCASING.get()
				&& (world.getBlockState(new BlockPos(x, y - 1, z - 2))).getBlock() == PalamodModBlocks.GRINDERFRAME.get() && (world.getBlockState(new BlockPos(x + 1, y - 1, z - 2))).getBlock() == PalamodModBlocks.GRINDERFRAME.get()
				&& (world.getBlockState(new BlockPos(x - 1, y - 1, z - 2))).getBlock() == PalamodModBlocks.GRINDERFRAME.get() && (world.getBlockState(new BlockPos(x - 1, y, z - 2))).getBlock() == PalamodModBlocks.GRINDERFRAME.get()
				&& (world.getBlockState(new BlockPos(x, y, z - 2))).getBlock() == PalamodModBlocks.GRINDERCASING.get() && (world.getBlockState(new BlockPos(x + 1, y, z - 2))).getBlock() == PalamodModBlocks.GRINDERFRAME.get()
				&& (world.getBlockState(new BlockPos(x - 1, y + 1, z - 2))).getBlock() == PalamodModBlocks.GRINDERFRAME.get() && (world.getBlockState(new BlockPos(x + 1, y + 1, z - 2))).getBlock() == PalamodModBlocks.GRINDERFRAME.get()
				&& (world.getBlockState(new BlockPos(x, y + 1, z - 2))).getBlock() == PalamodModBlocks.GRINDERFRAME.get()) {
			if (entity instanceof Player _player)
				_player.closeContainer();
			{
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = new BlockPos(x, y, z);
					NetworkHooks.openGui((ServerPlayer) _ent, new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return new TextComponent("Grindergui");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new GrinderguiMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getTileData().putBoolean("grinder_tick", (true));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			world.scheduleTick(new BlockPos(x, y, z), world.getBlockState(new BlockPos(x, y, z)).getBlock(), 1);
		} else if ((world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == PalamodModBlocks.GRINDERFRAME.get() && (world.getBlockState(new BlockPos(x + 1, y - 1, z))).getBlock() == PalamodModBlocks.GRINDERFRAME.get()
				&& (world.getBlockState(new BlockPos(x - 1, y - 1, z))).getBlock() == PalamodModBlocks.GRINDERFRAME.get() && (world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == PalamodModBlocks.GRINDERFRAME.get()
				&& (world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == PalamodModBlocks.GRINDERFRAME.get() && (world.getBlockState(new BlockPos(x - 1, y + 1, z))).getBlock() == PalamodModBlocks.GRINDERFRAME.get()
				&& (world.getBlockState(new BlockPos(x + 1, y + 1, z))).getBlock() == PalamodModBlocks.GRINDERFRAME.get() && (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == PalamodModBlocks.GRINDERFRAME.get()
				&& (world.getBlockState(new BlockPos(x, y - 1, z + 1))).getBlock() == PalamodModBlocks.GRINDERCASING.get() && (world.getBlockState(new BlockPos(x + 1, y - 1, z + 1))).getBlock() == PalamodModBlocks.GRINDERFRAME.get()
				&& (world.getBlockState(new BlockPos(x - 1, y - 1, z + 1))).getBlock() == PalamodModBlocks.GRINDERFRAME.get() && (world.getBlockState(new BlockPos(x - 1, y, z + 1))).getBlock() == PalamodModBlocks.GRINDERCASING.get()
				&& (world.getBlockState(new BlockPos(x + 1, y, z + 1))).getBlock() == PalamodModBlocks.GRINDERCASING.get() && (world.getBlockState(new BlockPos(x - 1, y + 1, z + 1))).getBlock() == PalamodModBlocks.GRINDERFRAME.get()
				&& (world.getBlockState(new BlockPos(x + 1, y + 1, z + 1))).getBlock() == PalamodModBlocks.GRINDERFRAME.get() && (world.getBlockState(new BlockPos(x, y + 1, z + 1))).getBlock() == PalamodModBlocks.GRINDERCASING.get()
				&& (world.getBlockState(new BlockPos(x, y - 1, z + 2))).getBlock() == PalamodModBlocks.GRINDERFRAME.get() && (world.getBlockState(new BlockPos(x + 1, y - 1, z + 2))).getBlock() == PalamodModBlocks.GRINDERFRAME.get()
				&& (world.getBlockState(new BlockPos(x - 1, y - 1, z + 2))).getBlock() == PalamodModBlocks.GRINDERFRAME.get() && (world.getBlockState(new BlockPos(x - 1, y, z + 2))).getBlock() == PalamodModBlocks.GRINDERFRAME.get()
				&& (world.getBlockState(new BlockPos(x, y, z + 2))).getBlock() == PalamodModBlocks.GRINDERCASING.get() && (world.getBlockState(new BlockPos(x + 1, y, z + 2))).getBlock() == PalamodModBlocks.GRINDERFRAME.get()
				&& (world.getBlockState(new BlockPos(x - 1, y + 1, z + 2))).getBlock() == PalamodModBlocks.GRINDERFRAME.get() && (world.getBlockState(new BlockPos(x + 1, y + 1, z + 2))).getBlock() == PalamodModBlocks.GRINDERFRAME.get()
				&& (world.getBlockState(new BlockPos(x, y + 1, z + 2))).getBlock() == PalamodModBlocks.GRINDERFRAME.get()) {
			if (entity instanceof Player _player)
				_player.closeContainer();
			{
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = new BlockPos(x, y, z);
					NetworkHooks.openGui((ServerPlayer) _ent, new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return new TextComponent("Grindergui");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new GrinderguiMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getTileData().putBoolean("grinder_tick", (true));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			world.scheduleTick(new BlockPos(x, y, z), world.getBlockState(new BlockPos(x, y, z)).getBlock(), 1);
		} else if ((world.getBlockState(new BlockPos(x + 2, y - 1, z))).getBlock() == PalamodModBlocks.GRINDERFRAME.get() && (world.getBlockState(new BlockPos(x + 2, y - 1, z + 1))).getBlock() == PalamodModBlocks.GRINDERFRAME.get()
				&& (world.getBlockState(new BlockPos(x + 2, y - 1, z - 1))).getBlock() == PalamodModBlocks.GRINDERFRAME.get() && (world.getBlockState(new BlockPos(x + 2, y, z + 1))).getBlock() == PalamodModBlocks.GRINDERFRAME.get()
				&& (world.getBlockState(new BlockPos(x + 2, y, z))).getBlock() == PalamodModBlocks.GRINDERCASING.get() && (world.getBlockState(new BlockPos(x + 2, y, z - 1))).getBlock() == PalamodModBlocks.GRINDERFRAME.get()
				&& (world.getBlockState(new BlockPos(x + 2, y + 1, z + 1))).getBlock() == PalamodModBlocks.GRINDERFRAME.get() && (world.getBlockState(new BlockPos(x + 2, y + 1, z))).getBlock() == PalamodModBlocks.GRINDERFRAME.get()
				&& (world.getBlockState(new BlockPos(x + 2, y + 1, z + 1))).getBlock() == PalamodModBlocks.GRINDERFRAME.get() && (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == PalamodModBlocks.GRINDERFRAME.get()
				&& (world.getBlockState(new BlockPos(x, y - 1, z + 1))).getBlock() == PalamodModBlocks.GRINDERFRAME.get() && (world.getBlockState(new BlockPos(x, y - 1, z - 1))).getBlock() == PalamodModBlocks.GRINDERFRAME.get()
				&& (world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == PalamodModBlocks.GRINDERFRAME.get() && (world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == PalamodModBlocks.GRINDERFRAME.get()
				&& (world.getBlockState(new BlockPos(x, y + 1, z + 1))).getBlock() == PalamodModBlocks.GRINDERFRAME.get() && (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == PalamodModBlocks.GRINDERFRAME.get()
				&& (world.getBlockState(new BlockPos(x, y + 1, z + 1))).getBlock() == PalamodModBlocks.GRINDERFRAME.get() && (world.getBlockState(new BlockPos(x + 1, y - 1, z))).getBlock() == PalamodModBlocks.GRINDERCASING.get()
				&& (world.getBlockState(new BlockPos(x + 1, y - 1, z + 1))).getBlock() == PalamodModBlocks.GRINDERFRAME.get() && (world.getBlockState(new BlockPos(x + 1, y - 1, z - 1))).getBlock() == PalamodModBlocks.GRINDERFRAME.get()
				&& (world.getBlockState(new BlockPos(x + 1, y, z + 1))).getBlock() == PalamodModBlocks.GRINDERCASING.get() && (world.getBlockState(new BlockPos(x + 1, y, z - 1))).getBlock() == PalamodModBlocks.GRINDERCASING.get()
				&& (world.getBlockState(new BlockPos(x + 1, y + 1, z + 1))).getBlock() == PalamodModBlocks.GRINDERFRAME.get() && (world.getBlockState(new BlockPos(x + 1, y + 1, z))).getBlock() == PalamodModBlocks.GRINDERCASING.get()
				&& (world.getBlockState(new BlockPos(x + 1, y + 1, z + 1))).getBlock() == PalamodModBlocks.GRINDERFRAME.get()) {
			if (entity instanceof Player _player)
				_player.closeContainer();
			{
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = new BlockPos(x, y, z);
					NetworkHooks.openGui((ServerPlayer) _ent, new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return new TextComponent("Grindergui");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new GrinderguiMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getTileData().putBoolean("grinder_tick", (true));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			world.scheduleTick(new BlockPos(x, y, z), world.getBlockState(new BlockPos(x, y, z)).getBlock(), 1);
		} else if ((world.getBlockState(new BlockPos(x - 2, y - 1, z))).getBlock() == PalamodModBlocks.GRINDERFRAME.get() && (world.getBlockState(new BlockPos(x - 2, y - 1, z + 1))).getBlock() == PalamodModBlocks.GRINDERFRAME.get()
				&& (world.getBlockState(new BlockPos(x - 2, y - 1, z - 1))).getBlock() == PalamodModBlocks.GRINDERFRAME.get() && (world.getBlockState(new BlockPos(x - 2, y, z + 1))).getBlock() == PalamodModBlocks.GRINDERFRAME.get()
				&& (world.getBlockState(new BlockPos(x - 2, y, z))).getBlock() == PalamodModBlocks.GRINDERCASING.get() && (world.getBlockState(new BlockPos(x - 2, y, z - 1))).getBlock() == PalamodModBlocks.GRINDERFRAME.get()
				&& (world.getBlockState(new BlockPos(x - 2, y + 1, z + 1))).getBlock() == PalamodModBlocks.GRINDERFRAME.get() && (world.getBlockState(new BlockPos(x - 2, y + 1, z))).getBlock() == PalamodModBlocks.GRINDERFRAME.get()
				&& (world.getBlockState(new BlockPos(x - 2, y + 1, z + 1))).getBlock() == PalamodModBlocks.GRINDERFRAME.get() && (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == PalamodModBlocks.GRINDERFRAME.get()
				&& (world.getBlockState(new BlockPos(x, y - 1, z + 1))).getBlock() == PalamodModBlocks.GRINDERFRAME.get() && (world.getBlockState(new BlockPos(x, y - 1, z - 1))).getBlock() == PalamodModBlocks.GRINDERFRAME.get()
				&& (world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == PalamodModBlocks.GRINDERFRAME.get() && (world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == PalamodModBlocks.GRINDERFRAME.get()
				&& (world.getBlockState(new BlockPos(x, y + 1, z + 1))).getBlock() == PalamodModBlocks.GRINDERFRAME.get() && (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == PalamodModBlocks.GRINDERFRAME.get()
				&& (world.getBlockState(new BlockPos(x, y + 1, z + 1))).getBlock() == PalamodModBlocks.GRINDERFRAME.get() && (world.getBlockState(new BlockPos(x - 1, y - 1, z))).getBlock() == PalamodModBlocks.GRINDERCASING.get()
				&& (world.getBlockState(new BlockPos(x - 1, y - 1, z + 1))).getBlock() == PalamodModBlocks.GRINDERFRAME.get() && (world.getBlockState(new BlockPos(x - 1, y - 1, z - 1))).getBlock() == PalamodModBlocks.GRINDERFRAME.get()
				&& (world.getBlockState(new BlockPos(x - 1, y, z + 1))).getBlock() == PalamodModBlocks.GRINDERCASING.get() && (world.getBlockState(new BlockPos(x - 1, y, z - 1))).getBlock() == PalamodModBlocks.GRINDERCASING.get()
				&& (world.getBlockState(new BlockPos(x - 1, y + 1, z + 1))).getBlock() == PalamodModBlocks.GRINDERFRAME.get() && (world.getBlockState(new BlockPos(x - 1, y + 1, z))).getBlock() == PalamodModBlocks.GRINDERCASING.get()
				&& (world.getBlockState(new BlockPos(x - 1, y + 1, z + 1))).getBlock() == PalamodModBlocks.GRINDERFRAME.get()) {
			if (entity instanceof Player _player)
				_player.closeContainer();
			{
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = new BlockPos(x, y, z);
					NetworkHooks.openGui((ServerPlayer) _ent, new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return new TextComponent("Grindergui");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new GrinderguiMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getTileData().putBoolean("grinder_tick", (true));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			world.scheduleTick(new BlockPos(x, y, z), world.getBlockState(new BlockPos(x, y, z)).getBlock(), 1);
		} else {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("The structure is incomplete"), (false));
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getTileData().putBoolean("grinder_tick", (false));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			world.scheduleTick(new BlockPos(x, y, z), world.getBlockState(new BlockPos(x, y, z)).getBlock(), 1);
		}
	}
}
