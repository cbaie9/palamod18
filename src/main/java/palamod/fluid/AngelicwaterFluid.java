
package palamod.fluid;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModFluids;
import palamod.init.PalamodModBlocks;

import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fluids.FluidAttributes;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.resources.ResourceLocation;

public abstract class AngelicwaterFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(PalamodModFluids.ANGELICWATER, PalamodModFluids.FLOWING_ANGELICWATER,
			FluidAttributes.builder(new ResourceLocation("palamod:blocks/angelic_water_still"), new ResourceLocation("palamod:blocks/angelic_water_flowing"))

	).explosionResistance(100f)

			.bucket(PalamodModItems.ANGELICWATER_BUCKET).block(() -> (LiquidBlock) PalamodModBlocks.ANGELICWATER.get());

	private AngelicwaterFluid() {
		super(PROPERTIES);
	}

	public static class Source extends AngelicwaterFluid {
		public Source() {
			super();
		}

		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends AngelicwaterFluid {
		public Flowing() {
			super();
		}

		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}
