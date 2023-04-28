package palamod.procedures;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModEnchantments;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class Upgradepotgv2Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean auto_smelt = false;
		double big_hole = 0;
		double Pickaxe_stone_seen = 0;
		double potg_fuel = 0;
		Pickaxe_stone_seen = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("Pickaxe_stone");
		potg_fuel = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("potg_fuel");
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.STONE || (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.GRANITE || (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.DIORITE
				|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.ANDESITE || (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.COBBLESTONE
				|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.BLACKSTONE || (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.NETHERRACK
				|| (world.getBlockState(new BlockPos(x, y, z))).is(BlockTags.create(new ResourceLocation("forge:stone"))) || (world.getBlockState(new BlockPos(x, y, z))).is(BlockTags.create(new ResourceLocation("forge:multitool_mb")))) {
			(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("Pickaxe_stone", (Pickaxe_stone_seen + 1));
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("Pickaxe_stone") >= 2000000) {
				if (EnchantmentHelper.getItemEnchantmentLevel(PalamodModEnchantments.AUTOSMELTPOTG.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
					auto_smelt = true;
				} else if (EnchantmentHelper.getItemEnchantmentLevel(PalamodModEnchantments.BIGHOLE.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
					big_hole = EnchantmentHelper.getItemEnchantmentLevel(PalamodModEnchantments.BIGHOLE.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY));
				}
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_20.get());
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).enchant(Enchantments.BLOCK_EFFICIENCY, 5);
				((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).enchant(Enchantments.BLOCK_FORTUNE, 3);
				if (auto_smelt) {
					((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).enchant(PalamodModEnchantments.AUTOSMELTPOTG.get(), 1);
				} else if (0 < big_hole) {
					((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).enchant(PalamodModEnchantments.BIGHOLE.get(), (int) big_hole);
				}
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("Pickaxe_stone", (Pickaxe_stone_seen + 1));
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("potg_fuel", (potg_fuel + 1));
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("Pickaxe_stone") >= 1000000) {
				if (EnchantmentHelper.getItemEnchantmentLevel(PalamodModEnchantments.AUTOSMELTPOTG.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
					auto_smelt = true;
				} else if (EnchantmentHelper.getItemEnchantmentLevel(PalamodModEnchantments.BIGHOLE.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
					big_hole = EnchantmentHelper.getItemEnchantmentLevel(PalamodModEnchantments.BIGHOLE.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY));
				}
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_19.get());
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("Pickaxe_stone", (Pickaxe_stone_seen + 1));
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("potg_fuel", (potg_fuel + 1));
				((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).enchant(Enchantments.BLOCK_EFFICIENCY, 5);
				((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).enchant(Enchantments.BLOCK_FORTUNE, 3);
				if (auto_smelt) {
					((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).enchant(PalamodModEnchantments.AUTOSMELTPOTG.get(), 1);
				} else if (0 < big_hole) {
					((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).enchant(PalamodModEnchantments.BIGHOLE.get(), (int) big_hole);
				}
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("Pickaxe_stone", (Pickaxe_stone_seen + 1));
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("Pickaxe_stone") >= 800000) {
				if (EnchantmentHelper.getItemEnchantmentLevel(PalamodModEnchantments.AUTOSMELTPOTG.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
					auto_smelt = true;
				} else if (EnchantmentHelper.getItemEnchantmentLevel(PalamodModEnchantments.BIGHOLE.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
					big_hole = EnchantmentHelper.getItemEnchantmentLevel(PalamodModEnchantments.BIGHOLE.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY));
				}
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_18.get());
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).enchant(Enchantments.BLOCK_EFFICIENCY, 5);
				((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).enchant(Enchantments.BLOCK_FORTUNE, 3);
				if (auto_smelt) {
					((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).enchant(PalamodModEnchantments.AUTOSMELTPOTG.get(), 1);
				} else if (0 < big_hole) {
					((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).enchant(PalamodModEnchantments.BIGHOLE.get(), (int) big_hole);
				}
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("potg_fuel", (potg_fuel + 1));
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("Pickaxe_stone", (Pickaxe_stone_seen + 1));
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("Pickaxe_stone") >= 700000) {
				if (EnchantmentHelper.getItemEnchantmentLevel(PalamodModEnchantments.AUTOSMELTPOTG.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
					auto_smelt = true;
				} else if (EnchantmentHelper.getItemEnchantmentLevel(PalamodModEnchantments.BIGHOLE.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
					big_hole = EnchantmentHelper.getItemEnchantmentLevel(PalamodModEnchantments.BIGHOLE.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY));
				}
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_17.get());
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).enchant(Enchantments.BLOCK_EFFICIENCY, 5);
				((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).enchant(Enchantments.BLOCK_FORTUNE, 3);
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("potg_fuel", (potg_fuel + 1));
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("Pickaxe_stone", (Pickaxe_stone_seen + 1));
				if (auto_smelt) {
					((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).enchant(PalamodModEnchantments.AUTOSMELTPOTG.get(), 1);
				} else if (0 < big_hole) {
					((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).enchant(PalamodModEnchantments.BIGHOLE.get(), (int) big_hole);
				}
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("Pickaxe_stone", (Pickaxe_stone_seen + 1));
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("Pickaxe_stone") >= 600000) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_16.get());
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).enchant(Enchantments.BLOCK_EFFICIENCY, 5);
				((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).enchant(Enchantments.BLOCK_FORTUNE, 3);
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("potg_fuel", (potg_fuel + 1));
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("Pickaxe_stone", (Pickaxe_stone_seen + 1));
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("Pickaxe_stone") >= 7440) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_15.get());
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).enchant(Enchantments.BLOCK_EFFICIENCY, 5);
				((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).enchant(Enchantments.BLOCK_FORTUNE, 2);
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("Pickaxe_stone", (Pickaxe_stone_seen + 1));
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("Pickaxe_stone") >= 6750) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_14.get());
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).enchant(Enchantments.BLOCK_EFFICIENCY, 5);
				((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).enchant(Enchantments.BLOCK_FORTUNE, 1);
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("Pickaxe_stone", (Pickaxe_stone_seen + 1));
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("Pickaxe_stone") >= 5150) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_13.get());
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).enchant(Enchantments.BLOCK_EFFICIENCY, 5);
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("Pickaxe_stone", (Pickaxe_stone_seen + 1));
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("Pickaxe_stone") >= 4563) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_12.get());
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).enchant(Enchantments.BLOCK_EFFICIENCY, 4);
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("Pickaxe_stone", (Pickaxe_stone_seen + 1));
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("Pickaxe_stone") >= 5000) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_11.get());
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).enchant(Enchantments.BLOCK_EFFICIENCY, 3);
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("Pickaxe_stone", (Pickaxe_stone_seen + 1));
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("Pickaxe_stone") >= 5000) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_10.get());
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).enchant(Enchantments.BLOCK_EFFICIENCY, 2);
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("Pickaxe_stone", (Pickaxe_stone_seen + 1));
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("Pickaxe_stone") >= 8684) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_9.get());
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).enchant(Enchantments.BLOCK_EFFICIENCY, 1);
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("Pickaxe_stone", (Pickaxe_stone_seen + 1));
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("Pickaxe_stone") >= 2616) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_8.get());
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("Pickaxe_stone", (Pickaxe_stone_seen + 1));
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("Pickaxe_stone") >= 5000) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_7.get());
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("Pickaxe_stone", (Pickaxe_stone_seen + 1));
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("Pickaxe_stone") >= 1370) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_6.get());
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("Pickaxe_stone", (Pickaxe_stone_seen + 1));
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("Pickaxe_stone") >= 1172) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_5.get());
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("Pickaxe_stone", (Pickaxe_stone_seen + 1));
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("Pickaxe_stone") >= 757) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_4.get());
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("Pickaxe_stone", (Pickaxe_stone_seen + 1));
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("Pickaxe_stone") >= 250) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_3.get());
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("Pickaxe_stone", (Pickaxe_stone_seen + 1));
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("Pickaxe_stone") >= 100) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_2.get());
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("Pickaxe_stone", (Pickaxe_stone_seen + 1));
			}
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(PalamodModEnchantments.BIGHOLE.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0
				&& ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PalamodModItems.PALAMIXEDCHARCOAL.get())) : false)
						|| 0 < (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("potg_fuel"))) {
			HammernormalProcedure.execute(world, x, y, z, entity);
			if (0 < (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("potg_fuel")) {
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("potg_fuel",
						((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("potg_fuel") - 1));
			} else {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(PalamodModItems.PALAMIXEDCHARCOAL.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("potg_fuel",
						((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("potg_fuel") + 2500));
			}
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(PalamodModEnchantments.AUTOSMELTPOTG.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0 && (world instanceof Level _lvlCanSmelt
				? _lvlCanSmelt.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), _lvlCanSmelt).isPresent()
				: false)) {
			if (world instanceof Level _level && !_level.isClientSide()) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z,
						((world instanceof Level _lvlSmeltResult
								&& _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), _lvlSmeltResult).isPresent())
										? _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), _lvlSmeltResult).get().getResultItem()
												.copy()
										: ItemStack.EMPTY));
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
			world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
		}
	}
}
