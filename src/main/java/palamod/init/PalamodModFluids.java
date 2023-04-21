
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package palamod.init;

import palamod.fluid.PalalavaFluid;
import palamod.fluid.FakewaterFluid;
import palamod.fluid.AngelicwaterFluid;

import palamod.PalamodMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

public class PalamodModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(ForgeRegistries.FLUIDS, PalamodMod.MODID);
	public static final RegistryObject<Fluid> FAKEWATER = REGISTRY.register("fakewater", () -> new FakewaterFluid.Source());
	public static final RegistryObject<Fluid> FLOWING_FAKEWATER = REGISTRY.register("flowing_fakewater", () -> new FakewaterFluid.Flowing());
	public static final RegistryObject<Fluid> PALALAVA = REGISTRY.register("palalava", () -> new PalalavaFluid.Source());
	public static final RegistryObject<Fluid> FLOWING_PALALAVA = REGISTRY.register("flowing_palalava", () -> new PalalavaFluid.Flowing());
	public static final RegistryObject<Fluid> ANGELICWATER = REGISTRY.register("angelicwater", () -> new AngelicwaterFluid.Source());
	public static final RegistryObject<Fluid> FLOWING_ANGELICWATER = REGISTRY.register("flowing_angelicwater", () -> new AngelicwaterFluid.Flowing());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(FAKEWATER.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_FAKEWATER.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(PALALAVA.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_PALALAVA.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(ANGELICWATER.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_ANGELICWATER.get(), renderType -> renderType == RenderType.translucent());
		}
	}
}
