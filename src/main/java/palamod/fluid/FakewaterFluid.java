
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

public abstract class FakewaterFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(PalamodModFluids.FAKEWATER, PalamodModFluids.FLOWING_FAKEWATER,
			FluidAttributes.builder(new ResourceLocation("palamod:blocks/fakewater_still"), new ResourceLocation("palamod:blocks/fake_water"))

	).explosionResistance(100f)

			.bucket(PalamodModItems.FAKEWATER_BUCKET).block(() -> (LiquidBlock) PalamodModBlocks.FAKEWATER.get());

	private FakewaterFluid() {
		super(PROPERTIES);
	}

	public static class Source extends FakewaterFluid {
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

	public static class Flowing extends FakewaterFluid {
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
