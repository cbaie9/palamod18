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
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

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
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.STONE || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.GRANITE
				|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.DIORITE || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.ANDESITE
				|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.COBBLESTONE || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.BLACKSTONE
				|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.NETHERRACK || (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(new ResourceLocation("forge:stone")))
				|| (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(new ResourceLocation("forge:multitool_mb")))) {
			(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("Pickaxe_stone", (Pickaxe_stone_seen + 1));
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("Pickaxe_stone") >= 2000000) {
				if (EnchantmentHelper.getItemEnchantmentLevel(PalamodModEnchantments.AUTOSMELTPOTG.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
					auto_smelt = true;
				} else if (EnchantmentHelper.getItemEnchantmentLevel(PalamodModEnchantments.BIGHOLE.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
					big_hole = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.BIGHOLE.get());
				}
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_20.get());
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(Enchantments.BLOCK_EFFICIENCY, 5);
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(Enchantments.BLOCK_FORTUNE, 3);
				if (auto_smelt) {
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(PalamodModEnchantments.AUTOSMELTPOTG.get(), 1);
				} else if (0 < big_hole) {
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(PalamodModEnchantments.BIGHOLE.get(), (int) big_hole);
				}
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("Pickaxe_stone", (Pickaxe_stone_seen + 1));
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("potg_fuel", (potg_fuel + 1));
				if (!(entity instanceof ServerPlayer _plr45 && _plr45.level instanceof ServerLevel
						&& _plr45.getAdvancements().getOrStartProgress(_plr45.server.getAdvancements().getAdvancement(new ResourceLocation("palamod:achmpotg_17new"))).isDone())) {
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("palamod:achmpotg_17new"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
				if (!(entity instanceof ServerPlayer _plr47 && _plr47.level instanceof ServerLevel
						&& _plr47.getAdvancements().getOrStartProgress(_plr47.server.getAdvancements().getAdvancement(new ResourceLocation("palamod:achmpotg_12new"))).isDone())) {
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("palamod:achmpotg_12new"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
				if (!(entity instanceof ServerPlayer _plr49 && _plr49.level instanceof ServerLevel
						&& _plr49.getAdvancements().getOrStartProgress(_plr49.server.getAdvancements().getAdvancement(new ResourceLocation("palamod:achmpotg_20new"))).isDone())) {
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("palamod:achmpotg_20new"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("Pickaxe_stone") >= 1000000) {
				if (EnchantmentHelper.getItemEnchantmentLevel(PalamodModEnchantments.AUTOSMELTPOTG.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
					auto_smelt = true;
				} else if (EnchantmentHelper.getItemEnchantmentLevel(PalamodModEnchantments.BIGHOLE.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
					big_hole = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.BIGHOLE.get());
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
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(Enchantments.BLOCK_EFFICIENCY, 5);
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(Enchantments.BLOCK_FORTUNE, 3);
				if (auto_smelt) {
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(PalamodModEnchantments.AUTOSMELTPOTG.get(), 1);
				} else if (0 < big_hole) {
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(PalamodModEnchantments.BIGHOLE.get(), (int) big_hole);
				}
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("Pickaxe_stone", (Pickaxe_stone_seen + 1));
				if (!(entity instanceof ServerPlayer _plr74 && _plr74.level instanceof ServerLevel
						&& _plr74.getAdvancements().getOrStartProgress(_plr74.server.getAdvancements().getAdvancement(new ResourceLocation("palamod:achmpotg_12new"))).isDone())) {
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("palamod:achmpotg_12new"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
				if (!(entity instanceof ServerPlayer _plr76 && _plr76.level instanceof ServerLevel
						&& _plr76.getAdvancements().getOrStartProgress(_plr76.server.getAdvancements().getAdvancement(new ResourceLocation("palamod:achmpotg_17new"))).isDone())) {
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("palamod:achmpotg_17new"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("Pickaxe_stone") >= 800000) {
				if (EnchantmentHelper.getItemEnchantmentLevel(PalamodModEnchantments.AUTOSMELTPOTG.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
					auto_smelt = true;
				} else if (EnchantmentHelper.getItemEnchantmentLevel(PalamodModEnchantments.BIGHOLE.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
					big_hole = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.BIGHOLE.get());
				}
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_18.get());
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(Enchantments.BLOCK_EFFICIENCY, 5);
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(Enchantments.BLOCK_FORTUNE, 3);
				if (auto_smelt) {
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(PalamodModEnchantments.AUTOSMELTPOTG.get(), 1);
				} else if (0 < big_hole) {
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(PalamodModEnchantments.BIGHOLE.get(), (int) big_hole);
				}
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("potg_fuel", (potg_fuel + 1));
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("Pickaxe_stone", (Pickaxe_stone_seen + 1));
				if (!(entity instanceof ServerPlayer _plr99 && _plr99.level instanceof ServerLevel
						&& _plr99.getAdvancements().getOrStartProgress(_plr99.server.getAdvancements().getAdvancement(new ResourceLocation("palamod:achmpotg_17new"))).isDone())) {
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("palamod:achmpotg_17new"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
				if (!(entity instanceof ServerPlayer _plr101 && _plr101.level instanceof ServerLevel
						&& _plr101.getAdvancements().getOrStartProgress(_plr101.server.getAdvancements().getAdvancement(new ResourceLocation("palamod:achmpotg_12new"))).isDone())) {
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("palamod:achmpotg_12new"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("Pickaxe_stone") >= 700000) {
				if (EnchantmentHelper.getItemEnchantmentLevel(PalamodModEnchantments.AUTOSMELTPOTG.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
					auto_smelt = true;
				} else if (EnchantmentHelper.getItemEnchantmentLevel(PalamodModEnchantments.BIGHOLE.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
					big_hole = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.BIGHOLE.get());
				}
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_17.get());
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(Enchantments.BLOCK_EFFICIENCY, 5);
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(Enchantments.BLOCK_FORTUNE, 3);
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("potg_fuel", (potg_fuel + 1));
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("Pickaxe_stone", (Pickaxe_stone_seen + 1));
				if (auto_smelt) {
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(PalamodModEnchantments.AUTOSMELTPOTG.get(), 1);
				} else if (0 < big_hole) {
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(PalamodModEnchantments.BIGHOLE.get(), (int) big_hole);
				}
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("Pickaxe_stone", (Pickaxe_stone_seen + 1));
				if (!(entity instanceof ServerPlayer _plr126 && _plr126.level instanceof ServerLevel
						&& _plr126.getAdvancements().getOrStartProgress(_plr126.server.getAdvancements().getAdvancement(new ResourceLocation("palamod:achmpotg_17new"))).isDone())) {
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("palamod:achmpotg_17new"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
				if (!(entity instanceof ServerPlayer _plr128 && _plr128.level instanceof ServerLevel
						&& _plr128.getAdvancements().getOrStartProgress(_plr128.server.getAdvancements().getAdvancement(new ResourceLocation("palamod:achmpotg_12new"))).isDone())) {
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("palamod:achmpotg_12new"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("Pickaxe_stone") >= 600000) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_16.get());
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(Enchantments.BLOCK_EFFICIENCY, 5);
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(Enchantments.BLOCK_FORTUNE, 3);
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("potg_fuel", (potg_fuel + 1));
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("Pickaxe_stone", (Pickaxe_stone_seen + 1));
				if (!(entity instanceof ServerPlayer _plr141 && _plr141.level instanceof ServerLevel
						&& _plr141.getAdvancements().getOrStartProgress(_plr141.server.getAdvancements().getAdvancement(new ResourceLocation("palamod:achmpotg_12new"))).isDone())) {
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("palamod:achmpotg_12new"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("Pickaxe_stone") >= 7440) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_15.get());
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(Enchantments.BLOCK_EFFICIENCY, 5);
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(Enchantments.BLOCK_FORTUNE, 2);
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("Pickaxe_stone", (Pickaxe_stone_seen + 1));
				if (!(entity instanceof ServerPlayer _plr152 && _plr152.level instanceof ServerLevel
						&& _plr152.getAdvancements().getOrStartProgress(_plr152.server.getAdvancements().getAdvancement(new ResourceLocation("palamod:achmpotg_12new"))).isDone())) {
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("palamod:achmpotg_12new"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("Pickaxe_stone") >= 6750) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_14.get());
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(Enchantments.BLOCK_EFFICIENCY, 5);
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(Enchantments.BLOCK_FORTUNE, 1);
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("Pickaxe_stone", (Pickaxe_stone_seen + 1));
				if (!(entity instanceof ServerPlayer _plr163 && _plr163.level instanceof ServerLevel
						&& _plr163.getAdvancements().getOrStartProgress(_plr163.server.getAdvancements().getAdvancement(new ResourceLocation("palamod:achmpotg_12new"))).isDone())) {
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("palamod:achmpotg_12new"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("Pickaxe_stone") >= 5150) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_13.get());
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(Enchantments.BLOCK_EFFICIENCY, 5);
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("Pickaxe_stone", (Pickaxe_stone_seen + 1));
				if (!(entity instanceof ServerPlayer _plr172 && _plr172.level instanceof ServerLevel
						&& _plr172.getAdvancements().getOrStartProgress(_plr172.server.getAdvancements().getAdvancement(new ResourceLocation("palamod:achmpotg_12new"))).isDone())) {
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("palamod:achmpotg_12new"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("Pickaxe_stone") >= 4563) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_12.get());
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(Enchantments.BLOCK_EFFICIENCY, 4);
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("Pickaxe_stone", (Pickaxe_stone_seen + 1));
				if (!(entity instanceof ServerPlayer _plr181 && _plr181.level instanceof ServerLevel
						&& _plr181.getAdvancements().getOrStartProgress(_plr181.server.getAdvancements().getAdvancement(new ResourceLocation("palamod:achmpotg_12new"))).isDone())) {
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("palamod:achmpotg_12new"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("Pickaxe_stone") >= 5000) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_11.get());
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(Enchantments.BLOCK_EFFICIENCY, 3);
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("Pickaxe_stone", (Pickaxe_stone_seen + 1));
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("Pickaxe_stone") >= 5000) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_10.get());
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(Enchantments.BLOCK_EFFICIENCY, 2);
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("Pickaxe_stone", (Pickaxe_stone_seen + 1));
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("Pickaxe_stone") >= 8684) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_9.get());
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(Enchantments.BLOCK_EFFICIENCY, 1);
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
			if (2 == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.BIGHOLE.get())) {
				Bighole2Procedure.execute(world, x, y, z, entity);
			} else {
				HammernormalProcedure.execute(world, x, y, z, entity);
			}
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
		if (EnchantmentHelper.getItemEnchantmentLevel(PalamodModEnchantments.AUTOSMELTPOTG.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0 && world instanceof Level _level261
				&& _level261.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer((new ItemStack((world.getBlockState(BlockPos.containing(x, y, z))).getBlock()))), _level261).isPresent()) {
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z,
						(world instanceof Level _lvlSmeltResult
								? _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer((new ItemStack((world.getBlockState(BlockPos.containing(x, y, z))).getBlock()))), _lvlSmeltResult)
										.map(recipe -> recipe.getResultItem(_lvlSmeltResult.registryAccess()).copy()).orElse(ItemStack.EMPTY)
								: ItemStack.EMPTY));
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
			world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
		}
	}
}
