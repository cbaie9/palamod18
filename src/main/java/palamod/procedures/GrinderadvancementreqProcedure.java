package palamod.procedures;

import palamod.init.PalamodModBlocks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import java.util.Iterator;

public class GrinderadvancementreqProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (((world.getBlockState(new BlockPos(x, y, z))).getBlock() == PalamodModBlocks.TCV_2.get() || (world.getBlockState(new BlockPos(x, y, z))).getBlock() == PalamodModBlocks.GRINDERBLOCK.get())
				&& !(entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel && _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("palamod:avancementgrindre"))).isDone())) {
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("palamod:avancementgrindre"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemainingCriteria().iterator();
					while (_iterator.hasNext())
						_player.getAdvancements().award(_adv, (String) _iterator.next());
				}
			}
		}
	}
}
