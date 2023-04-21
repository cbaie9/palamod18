
package palamod.block;

import palamod.init.PalamodModFluids;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

public class PalalavaBlock extends LiquidBlock {
	public PalalavaBlock() {
		super(() -> (FlowingFluid) PalamodModFluids.PALALAVA.get(), BlockBehaviour.Properties.of(Material.LAVA, MaterialColor.COLOR_RED).strength(100f)

				.lightLevel(s -> 12));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}
}
