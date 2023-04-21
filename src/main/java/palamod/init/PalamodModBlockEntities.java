
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package palamod.init;

import palamod.block.entity.UploaderBlockEntity;
import palamod.block.entity.TrixiumnbtblockBlockEntity;
import palamod.block.entity.TitanechestBlockEntity;
import palamod.block.entity.Tcv2BlockEntity;
import palamod.block.entity.PaladiummachineBlockEntity;
import palamod.block.entity.PaladiumfurnaceonBlockEntity;
import palamod.block.entity.PaladiumfurnaceBlockEntity;
import palamod.block.entity.PaladiumforgeBlockEntity;
import palamod.block.entity.PaladiumcrusherBlockEntity;
import palamod.block.entity.PaladiumchestBlockEntity;
import palamod.block.entity.NbtblockBlockEntity;
import palamod.block.entity.MegasafechestBlockEntity;
import palamod.block.entity.LuckyblockBlockEntity;
import palamod.block.entity.HdvblockBlockEntity;
import palamod.block.entity.GrinderblockBlockEntity;
import palamod.block.entity.GreenpaladiumchestBlockEntity;
import palamod.block.entity.EndiumchestBlockEntity;
import palamod.block.entity.DownloaderBlockEntity;
import palamod.block.entity.AmethystchestBlockEntity;

import palamod.PalamodMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

public class PalamodModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, PalamodMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> PALADIUMCHEST = register("paladiumchest", PalamodModBlocks.PALADIUMCHEST, PaladiumchestBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> TITANECHEST = register("titanechest", PalamodModBlocks.TITANECHEST, TitanechestBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> AMETHYSTCHEST = register("amethystchest", PalamodModBlocks.AMETHYSTCHEST, AmethystchestBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> PALADIUMCRUSHER = register("paladiumcrusher", PalamodModBlocks.PALADIUMCRUSHER, PaladiumcrusherBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ENDIUMCHEST = register("endiumchest", PalamodModBlocks.ENDIUMCHEST, EndiumchestBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> GREENPALADIUMCHEST = register("greenpaladiumchest", PalamodModBlocks.GREENPALADIUMCHEST, GreenpaladiumchestBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> PALADIUMFURNACE = register("paladiumfurnace", PalamodModBlocks.PALADIUMFURNACE, PaladiumfurnaceBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> PALADIUMFORGE = register("paladiumforge", PalamodModBlocks.PALADIUMFORGE, PaladiumforgeBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> MEGASAFECHEST = register("megasafechest", PalamodModBlocks.MEGASAFECHEST, MegasafechestBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> UPLOADER = register("uploader", PalamodModBlocks.UPLOADER, UploaderBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> DOWNLOADER = register("downloader", PalamodModBlocks.DOWNLOADER, DownloaderBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> LUCKYBLOCK = register("luckyblock", PalamodModBlocks.LUCKYBLOCK, LuckyblockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> GRINDERBLOCK = register("grinderblock", PalamodModBlocks.GRINDERBLOCK, GrinderblockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> TCV_2 = register("tcv_2", PalamodModBlocks.TCV_2, Tcv2BlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> PALADIUMMACHINE = register("paladiummachine", PalamodModBlocks.PALADIUMMACHINE, PaladiummachineBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> NBTBLOCK = register("nbtblock", PalamodModBlocks.NBTBLOCK, NbtblockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> PALADIUMFURNACEON = register("paladiumfurnaceon", PalamodModBlocks.PALADIUMFURNACEON, PaladiumfurnaceonBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> TRIXIUMNBTBLOCK = register("trixiumnbtblock", PalamodModBlocks.TRIXIUMNBTBLOCK, TrixiumnbtblockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> HDVBLOCK = register("hdvblock", PalamodModBlocks.HDVBLOCK, HdvblockBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
