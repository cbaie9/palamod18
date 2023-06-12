
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package palamod.init;

import palamod.world.features.ores.XpbushFeature;
import palamod.world.features.ores.TrixiumoredeepslateFeature;
import palamod.world.features.ores.TrixiumoreFeature;
import palamod.world.features.ores.TitaneoredeepslateFeature;
import palamod.world.features.ores.TitaneOreFeature;
import palamod.world.features.ores.ProtodeepslateFeature;
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
import palamod.world.features.TreeostryaFeature;
import palamod.world.features.TreejudeecercisFeature;
import palamod.world.features.TreejacarandaFeature;
import palamod.world.features.TreeerableFeature;
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

import net.minecraft.world.level.levelgen.feature.Feature;

@Mod.EventBusSubscriber
public class PalamodModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, PalamodMod.MODID);
	public static final RegistryObject<Feature<?>> PALADIUM_ORE = REGISTRY.register("paladium_ore", PaladiumOreFeature::new);
	public static final RegistryObject<Feature<?>> PALADIUMOREDEEPSLATE = REGISTRY.register("paladiumoredeepslate", PaladiumoredeepslateFeature::new);
	public static final RegistryObject<Feature<?>> TITANE_ORE = REGISTRY.register("titane_ore", TitaneOreFeature::new);
	public static final RegistryObject<Feature<?>> TITANEOREDEEPSLATE = REGISTRY.register("titaneoredeepslate", TitaneoredeepslateFeature::new);
	public static final RegistryObject<Feature<?>> AMETHYSTE_ORE = REGISTRY.register("amethyste_ore", AmethysteOreFeature::new);
	public static final RegistryObject<Feature<?>> AMETHYSTOREDEEPSLATE = REGISTRY.register("amethystoredeepslate", AmethystoredeepslateFeature::new);
	public static final RegistryObject<Feature<?>> ENDIUMNUGGETORE = REGISTRY.register("endiumnuggetore", EndiumnuggetoreFeature::new);
	public static final RegistryObject<Feature<?>> ENDIUMNUGGETOREDEEPSLATE = REGISTRY.register("endiumnuggetoredeepslate", EndiumnuggetoredeepslateFeature::new);
	public static final RegistryObject<Feature<?>> PALADIUM_GREENORE = REGISTRY.register("paladium_greenore", PaladiumGreenoreFeature::new);
	public static final RegistryObject<Feature<?>> PALADIUMGREENOREDEEPSLATE = REGISTRY.register("paladiumgreenoredeepslate", PaladiumgreenoredeepslateFeature::new);
	public static final RegistryObject<Feature<?>> FINDIUM_ORE = REGISTRY.register("findium_ore", FindiumOreFeature::new);
	public static final RegistryObject<Feature<?>> FINDIUMOREDEEPSLATE = REGISTRY.register("findiumoredeepslate", FindiumoredeepslateFeature::new);
	public static final RegistryObject<Feature<?>> TRIXIUMORE = REGISTRY.register("trixiumore", TrixiumoreFeature::new);
	public static final RegistryObject<Feature<?>> TRIXIUMOREDEEPSLATE = REGISTRY.register("trixiumoredeepslate", TrixiumoredeepslateFeature::new);
	public static final RegistryObject<Feature<?>> XPBUSH = REGISTRY.register("xpbush", XpbushFeature::new);
	public static final RegistryObject<Feature<?>> DONJONBIBL = REGISTRY.register("donjonbibl", DonjonbiblFeature::new);
	public static final RegistryObject<Feature<?>> DONJONBIBI = REGISTRY.register("donjonbibi", DonjonbibiFeature::new);
	public static final RegistryObject<Feature<?>> DESERTCREEPER = REGISTRY.register("desertcreeper", DesertcreeperFeature::new);
	public static final RegistryObject<Feature<?>> ICEPICS = REGISTRY.register("icepics", IcepicsFeature::new);
	public static final RegistryObject<Feature<?>> ICEPICS_2 = REGISTRY.register("icepics_2", Icepics2Feature::new);
	public static final RegistryObject<Feature<?>> DESERTABANDONNEDHOUSE = REGISTRY.register("desertabandonnedhouse", DesertabandonnedhouseFeature::new);
	public static final RegistryObject<Feature<?>> IGLOO = REGISTRY.register("igloo", IglooFeature::new);
	public static final RegistryObject<Feature<?>> IGLOODESTR = REGISTRY.register("igloodestr", IgloodestrFeature::new);
	public static final RegistryObject<Feature<?>> CUSTOMTEMPLE = REGISTRY.register("customtemple", CustomtempleFeature::new);
	public static final RegistryObject<Feature<?>> TREEJUDEECERCIS = REGISTRY.register("treejudeecercis", TreejudeecercisFeature::new);
	public static final RegistryObject<Feature<?>> TREEJACARANDA = REGISTRY.register("treejacaranda", TreejacarandaFeature::new);
	public static final RegistryObject<Feature<?>> TREEERABLE = REGISTRY.register("treeerable", TreeerableFeature::new);
	public static final RegistryObject<Feature<?>> TREEOSTRYA = REGISTRY.register("treeostrya", TreeostryaFeature::new);
	public static final RegistryObject<Feature<?>> PROTODEEPSLATE = REGISTRY.register("protodeepslate", ProtodeepslateFeature::new);
}
