
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package palamod.init;

import palamod.world.features.ores.XpbushFeature;
import palamod.world.features.ores.TrixiumoredeepslateFeature;
import palamod.world.features.ores.TrixiumoreFeature;
import palamod.world.features.ores.TitaneoredeepslateFeature;
import palamod.world.features.ores.TitaneOreFeature;
import palamod.world.features.ores.PaladiumoredeepslateFeature;
import palamod.world.features.ores.PaladiumgreenoredeepslateFeature;
import palamod.world.features.ores.PaladiumOreFeature;
import palamod.world.features.ores.PaladiumGreenoreFeature;
import palamod.world.features.ores.FindiumoredeepslateFeature;
import palamod.world.features.ores.FindiumOreFeature;
import palamod.world.features.ores.EndiumnuggetoredeepslateFeature;
import palamod.world.features.ores.EndiumnuggetoreFeature;
import palamod.world.features.ores.AmethystoredeepslateFeature;
import palamod.world.features.ores.AmethysteOreFeature;
import palamod.world.features.IgloodestrFeature;
import palamod.world.features.IglooFeature;
import palamod.world.features.IcepicsFeature;
import palamod.world.features.Icepics2Feature;
import palamod.world.features.DonjonbiblFeature;
import palamod.world.features.DonjonbibiFeature;
import palamod.world.features.DesertcreeperFeature;
import palamod.world.features.DesertabandonnedhouseFeature;
import palamod.world.features.CustomtempleFeature;

import palamod.PalamodMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Holder;

import java.util.function.Supplier;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber
public class PalamodModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, PalamodMod.MODID);
	private static final List<FeatureRegistration> FEATURE_REGISTRATIONS = new ArrayList<>();
	public static final RegistryObject<Feature<?>> PALADIUM_ORE = register("paladium_ore", PaladiumOreFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, PaladiumOreFeature.GENERATE_BIOMES, PaladiumOreFeature::placedFeature));
	public static final RegistryObject<Feature<?>> PALADIUMOREDEEPSLATE = register("paladiumoredeepslate", PaladiumoredeepslateFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, PaladiumoredeepslateFeature.GENERATE_BIOMES, PaladiumoredeepslateFeature::placedFeature));
	public static final RegistryObject<Feature<?>> TITANE_ORE = register("titane_ore", TitaneOreFeature::feature, new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, TitaneOreFeature.GENERATE_BIOMES, TitaneOreFeature::placedFeature));
	public static final RegistryObject<Feature<?>> TITANEOREDEEPSLATE = register("titaneoredeepslate", TitaneoredeepslateFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, TitaneoredeepslateFeature.GENERATE_BIOMES, TitaneoredeepslateFeature::placedFeature));
	public static final RegistryObject<Feature<?>> AMETHYSTE_ORE = register("amethyste_ore", AmethysteOreFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, AmethysteOreFeature.GENERATE_BIOMES, AmethysteOreFeature::placedFeature));
	public static final RegistryObject<Feature<?>> AMETHYSTOREDEEPSLATE = register("amethystoredeepslate", AmethystoredeepslateFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, AmethystoredeepslateFeature.GENERATE_BIOMES, AmethystoredeepslateFeature::placedFeature));
	public static final RegistryObject<Feature<?>> ENDIUMNUGGETORE = register("endiumnuggetore", EndiumnuggetoreFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, EndiumnuggetoreFeature.GENERATE_BIOMES, EndiumnuggetoreFeature::placedFeature));
	public static final RegistryObject<Feature<?>> ENDIUMNUGGETOREDEEPSLATE = register("endiumnuggetoredeepslate", EndiumnuggetoredeepslateFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, EndiumnuggetoredeepslateFeature.GENERATE_BIOMES, EndiumnuggetoredeepslateFeature::placedFeature));
	public static final RegistryObject<Feature<?>> PALADIUM_GREENORE = register("paladium_greenore", PaladiumGreenoreFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, PaladiumGreenoreFeature.GENERATE_BIOMES, PaladiumGreenoreFeature::placedFeature));
	public static final RegistryObject<Feature<?>> PALADIUMGREENOREDEEPSLATE = register("paladiumgreenoredeepslate", PaladiumgreenoredeepslateFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, PaladiumgreenoredeepslateFeature.GENERATE_BIOMES, PaladiumgreenoredeepslateFeature::placedFeature));
	public static final RegistryObject<Feature<?>> FINDIUM_ORE = register("findium_ore", FindiumOreFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, FindiumOreFeature.GENERATE_BIOMES, FindiumOreFeature::placedFeature));
	public static final RegistryObject<Feature<?>> FINDIUMOREDEEPSLATE = register("findiumoredeepslate", FindiumoredeepslateFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, FindiumoredeepslateFeature.GENERATE_BIOMES, FindiumoredeepslateFeature::placedFeature));
	public static final RegistryObject<Feature<?>> TRIXIUMORE = register("trixiumore", TrixiumoreFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, TrixiumoreFeature.GENERATE_BIOMES, TrixiumoreFeature::placedFeature));
	public static final RegistryObject<Feature<?>> TRIXIUMOREDEEPSLATE = register("trixiumoredeepslate", TrixiumoredeepslateFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, TrixiumoredeepslateFeature.GENERATE_BIOMES, TrixiumoredeepslateFeature::placedFeature));
	public static final RegistryObject<Feature<?>> XPBUSH = register("xpbush", XpbushFeature::feature, new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, XpbushFeature.GENERATE_BIOMES, XpbushFeature::placedFeature));
	public static final RegistryObject<Feature<?>> DONJONBIBL = register("donjonbibl", DonjonbiblFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_STRUCTURES, DonjonbiblFeature.GENERATE_BIOMES, DonjonbiblFeature::placedFeature));
	public static final RegistryObject<Feature<?>> DONJONBIBI = register("donjonbibi", DonjonbibiFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_STRUCTURES, DonjonbibiFeature.GENERATE_BIOMES, DonjonbibiFeature::placedFeature));
	public static final RegistryObject<Feature<?>> DESERTCREEPER = register("desertcreeper", DesertcreeperFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, DesertcreeperFeature.GENERATE_BIOMES, DesertcreeperFeature::placedFeature));
	public static final RegistryObject<Feature<?>> ICEPICS = register("icepics", IcepicsFeature::feature, new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, IcepicsFeature.GENERATE_BIOMES, IcepicsFeature::placedFeature));
	public static final RegistryObject<Feature<?>> ICEPICS_2 = register("icepics_2", Icepics2Feature::feature, new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, Icepics2Feature.GENERATE_BIOMES, Icepics2Feature::placedFeature));
	public static final RegistryObject<Feature<?>> DESERTABANDONNEDHOUSE = register("desertabandonnedhouse", DesertabandonnedhouseFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, DesertabandonnedhouseFeature.GENERATE_BIOMES, DesertabandonnedhouseFeature::placedFeature));
	public static final RegistryObject<Feature<?>> IGLOO = register("igloo", IglooFeature::feature, new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, IglooFeature.GENERATE_BIOMES, IglooFeature::placedFeature));
	public static final RegistryObject<Feature<?>> IGLOODESTR = register("igloodestr", IgloodestrFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, IgloodestrFeature.GENERATE_BIOMES, IgloodestrFeature::placedFeature));
	public static final RegistryObject<Feature<?>> CUSTOMTEMPLE = register("customtemple", CustomtempleFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, CustomtempleFeature.GENERATE_BIOMES, CustomtempleFeature::placedFeature));

	private static RegistryObject<Feature<?>> register(String registryname, Supplier<Feature<?>> feature, FeatureRegistration featureRegistration) {
		FEATURE_REGISTRATIONS.add(featureRegistration);
		return REGISTRY.register(registryname, feature);
	}

	@SubscribeEvent
	public static void addFeaturesToBiomes(BiomeLoadingEvent event) {
		for (FeatureRegistration registration : FEATURE_REGISTRATIONS) {
			if (registration.biomes() == null || registration.biomes().contains(event.getName()))
				event.getGeneration().getFeatures(registration.stage()).add(registration.placedFeature().get());
		}
	}

	private static record FeatureRegistration(GenerationStep.Decoration stage, Set<ResourceLocation> biomes, Supplier<Holder<PlacedFeature>> placedFeature) {
	}
}
