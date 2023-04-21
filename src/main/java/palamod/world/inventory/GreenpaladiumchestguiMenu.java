
package palamod.world.inventory;

import palamod.network.GreenpaladiumchestguiSlotMessage;

import palamod.init.PalamodModMenus;

import palamod.PalamodMod;

import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

public class GreenpaladiumchestguiMenu extends AbstractContainerMenu implements Supplier<Map<Integer, Slot>> {
	public final static HashMap<String, Object> guistate = new HashMap<>();
	public final Level world;
	public final Player entity;
	public int x, y, z;
	private IItemHandler internal;
	private final Map<Integer, Slot> customSlots = new HashMap<>();
	private boolean bound = false;

	public GreenpaladiumchestguiMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
		super(PalamodModMenus.GREENPALADIUMCHESTGUI, id);
		this.entity = inv.player;
		this.world = inv.player.level;
		this.internal = new ItemStackHandler(112);
		BlockPos pos = null;
		if (extraData != null) {
			pos = extraData.readBlockPos();
			this.x = pos.getX();
			this.y = pos.getY();
			this.z = pos.getZ();
		}
		if (pos != null) {
			if (extraData.readableBytes() == 1) { // bound to item
				byte hand = extraData.readByte();
				ItemStack itemstack;
				if (hand == 0)
					itemstack = this.entity.getMainHandItem();
				else
					itemstack = this.entity.getOffhandItem();
				itemstack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					this.internal = capability;
					this.bound = true;
				});
			} else if (extraData.readableBytes() > 1) {
				extraData.readByte(); // drop padding
				Entity entity = world.getEntity(extraData.readVarInt());
				if (entity != null)
					entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						this.internal = capability;
						this.bound = true;
					});
			} else { // might be bound to block
				BlockEntity ent = inv.player != null ? inv.player.level.getBlockEntity(pos) : null;
				if (ent != null) {
					ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						this.internal = capability;
						this.bound = true;
					});
				}
			}
		}
		this.customSlots.put(0, this.addSlot(new SlotItemHandler(internal, 0, 32, 4) {
			@Override
			public void setChanged() {
				super.setChanged();
				slotChanged(0, 0, 0);
			}
		}));
		this.customSlots.put(1, this.addSlot(new SlotItemHandler(internal, 1, 50, 4) {
			@Override
			public void setChanged() {
				super.setChanged();
				slotChanged(1, 0, 0);
			}
		}));
		this.customSlots.put(2, this.addSlot(new SlotItemHandler(internal, 2, 68, 4) {
			@Override
			public void setChanged() {
				super.setChanged();
				slotChanged(2, 0, 0);
			}
		}));
		this.customSlots.put(3, this.addSlot(new SlotItemHandler(internal, 3, 86, 4) {
			@Override
			public void setChanged() {
				super.setChanged();
				slotChanged(3, 0, 0);
			}
		}));
		this.customSlots.put(4, this.addSlot(new SlotItemHandler(internal, 4, 122, 4) {
			@Override
			public void setChanged() {
				super.setChanged();
				slotChanged(4, 0, 0);
			}
		}));
		this.customSlots.put(5, this.addSlot(new SlotItemHandler(internal, 5, 104, 4) {
			@Override
			public void setChanged() {
				super.setChanged();
				slotChanged(5, 0, 0);
			}
		}));
		this.customSlots.put(6, this.addSlot(new SlotItemHandler(internal, 6, 140, 4) {
			@Override
			public void setChanged() {
				super.setChanged();
				slotChanged(6, 0, 0);
			}
		}));
		this.customSlots.put(7, this.addSlot(new SlotItemHandler(internal, 7, 158, 4) {
			@Override
			public void setChanged() {
				super.setChanged();
				slotChanged(7, 0, 0);
			}
		}));
		this.customSlots.put(8, this.addSlot(new SlotItemHandler(internal, 8, 176, 4) {
			@Override
			public void setChanged() {
				super.setChanged();
				slotChanged(8, 0, 0);
			}
		}));
		this.customSlots.put(9, this.addSlot(new SlotItemHandler(internal, 9, 194, 4) {
			@Override
			public void setChanged() {
				super.setChanged();
				slotChanged(9, 0, 0);
			}
		}));
		this.customSlots.put(10, this.addSlot(new SlotItemHandler(internal, 10, 212, 4) {
			@Override
			public void setChanged() {
				super.setChanged();
				slotChanged(10, 0, 0);
			}
		}));
		this.customSlots.put(11, this.addSlot(new SlotItemHandler(internal, 11, 230, 4) {
			@Override
			public void setChanged() {
				super.setChanged();
				slotChanged(11, 0, 0);
			}
		}));
		this.customSlots.put(14, this.addSlot(new SlotItemHandler(internal, 14, 32, 22) {
		}));
		this.customSlots.put(15, this.addSlot(new SlotItemHandler(internal, 15, 50, 22) {
		}));
		this.customSlots.put(16, this.addSlot(new SlotItemHandler(internal, 16, 68, 22) {
		}));
		this.customSlots.put(17, this.addSlot(new SlotItemHandler(internal, 17, 86, 22) {
		}));
		this.customSlots.put(18, this.addSlot(new SlotItemHandler(internal, 18, 104, 22) {
		}));
		this.customSlots.put(19, this.addSlot(new SlotItemHandler(internal, 19, 122, 22) {
		}));
		this.customSlots.put(20, this.addSlot(new SlotItemHandler(internal, 20, 140, 22) {
		}));
		this.customSlots.put(21, this.addSlot(new SlotItemHandler(internal, 21, 158, 22) {
		}));
		this.customSlots.put(22, this.addSlot(new SlotItemHandler(internal, 22, 176, 22) {
		}));
		this.customSlots.put(23, this.addSlot(new SlotItemHandler(internal, 23, 194, 22) {
		}));
		this.customSlots.put(24, this.addSlot(new SlotItemHandler(internal, 24, 212, 22) {
		}));
		this.customSlots.put(25, this.addSlot(new SlotItemHandler(internal, 25, 230, 22) {
		}));
		this.customSlots.put(26, this.addSlot(new SlotItemHandler(internal, 26, 32, 40) {
		}));
		this.customSlots.put(27, this.addSlot(new SlotItemHandler(internal, 27, 50, 40) {
		}));
		this.customSlots.put(28, this.addSlot(new SlotItemHandler(internal, 28, 68, 40) {
		}));
		this.customSlots.put(29, this.addSlot(new SlotItemHandler(internal, 29, 86, 40) {
		}));
		this.customSlots.put(30, this.addSlot(new SlotItemHandler(internal, 30, 104, 40) {
		}));
		this.customSlots.put(31, this.addSlot(new SlotItemHandler(internal, 31, 122, 40) {
		}));
		this.customSlots.put(32, this.addSlot(new SlotItemHandler(internal, 32, 140, 40) {
		}));
		this.customSlots.put(33, this.addSlot(new SlotItemHandler(internal, 33, 158, 40) {
		}));
		this.customSlots.put(34, this.addSlot(new SlotItemHandler(internal, 34, 176, 40) {
		}));
		this.customSlots.put(35, this.addSlot(new SlotItemHandler(internal, 35, 194, 40) {
		}));
		this.customSlots.put(36, this.addSlot(new SlotItemHandler(internal, 36, 212, 40) {
		}));
		this.customSlots.put(37, this.addSlot(new SlotItemHandler(internal, 37, 230, 40) {
		}));
		this.customSlots.put(38, this.addSlot(new SlotItemHandler(internal, 38, 32, 58) {
		}));
		this.customSlots.put(39, this.addSlot(new SlotItemHandler(internal, 39, 50, 58) {
		}));
		this.customSlots.put(40, this.addSlot(new SlotItemHandler(internal, 40, 68, 58) {
		}));
		this.customSlots.put(41, this.addSlot(new SlotItemHandler(internal, 41, 86, 58) {
		}));
		this.customSlots.put(42, this.addSlot(new SlotItemHandler(internal, 42, 104, 58) {
		}));
		this.customSlots.put(43, this.addSlot(new SlotItemHandler(internal, 43, 122, 58) {
		}));
		this.customSlots.put(44, this.addSlot(new SlotItemHandler(internal, 44, 140, 58) {
		}));
		this.customSlots.put(45, this.addSlot(new SlotItemHandler(internal, 45, 158, 58) {
		}));
		this.customSlots.put(46, this.addSlot(new SlotItemHandler(internal, 46, 176, 58) {
		}));
		this.customSlots.put(47, this.addSlot(new SlotItemHandler(internal, 47, 194, 58) {
		}));
		this.customSlots.put(48, this.addSlot(new SlotItemHandler(internal, 48, 212, 58) {
		}));
		this.customSlots.put(49, this.addSlot(new SlotItemHandler(internal, 49, 230, 58) {
		}));
		this.customSlots.put(50, this.addSlot(new SlotItemHandler(internal, 50, 32, 76) {
		}));
		this.customSlots.put(51, this.addSlot(new SlotItemHandler(internal, 51, 50, 76) {
		}));
		this.customSlots.put(52, this.addSlot(new SlotItemHandler(internal, 52, 68, 76) {
		}));
		this.customSlots.put(53, this.addSlot(new SlotItemHandler(internal, 53, 86, 76) {
		}));
		this.customSlots.put(54, this.addSlot(new SlotItemHandler(internal, 54, 104, 76) {
		}));
		this.customSlots.put(55, this.addSlot(new SlotItemHandler(internal, 55, 122, 76) {
		}));
		this.customSlots.put(56, this.addSlot(new SlotItemHandler(internal, 56, 140, 76) {
		}));
		this.customSlots.put(57, this.addSlot(new SlotItemHandler(internal, 57, 158, 76) {
		}));
		this.customSlots.put(58, this.addSlot(new SlotItemHandler(internal, 58, 176, 76) {
		}));
		this.customSlots.put(59, this.addSlot(new SlotItemHandler(internal, 59, 194, 76) {
		}));
		this.customSlots.put(60, this.addSlot(new SlotItemHandler(internal, 60, 212, 76) {
		}));
		this.customSlots.put(61, this.addSlot(new SlotItemHandler(internal, 61, 230, 76) {
		}));
		this.customSlots.put(62, this.addSlot(new SlotItemHandler(internal, 62, 32, 94) {
		}));
		this.customSlots.put(63, this.addSlot(new SlotItemHandler(internal, 63, 50, 94) {
		}));
		this.customSlots.put(64, this.addSlot(new SlotItemHandler(internal, 64, 68, 94) {
		}));
		this.customSlots.put(65, this.addSlot(new SlotItemHandler(internal, 65, 86, 94) {
		}));
		this.customSlots.put(66, this.addSlot(new SlotItemHandler(internal, 66, 104, 94) {
		}));
		this.customSlots.put(67, this.addSlot(new SlotItemHandler(internal, 67, 122, 94) {
		}));
		this.customSlots.put(68, this.addSlot(new SlotItemHandler(internal, 68, 140, 94) {
		}));
		this.customSlots.put(69, this.addSlot(new SlotItemHandler(internal, 69, 158, 94) {
		}));
		this.customSlots.put(70, this.addSlot(new SlotItemHandler(internal, 70, 176, 94) {
		}));
		this.customSlots.put(71, this.addSlot(new SlotItemHandler(internal, 71, 194, 94) {
		}));
		this.customSlots.put(72, this.addSlot(new SlotItemHandler(internal, 72, 212, 94) {
		}));
		this.customSlots.put(73, this.addSlot(new SlotItemHandler(internal, 73, 230, 94) {
		}));
		this.customSlots.put(74, this.addSlot(new SlotItemHandler(internal, 74, 32, 112) {
		}));
		this.customSlots.put(75, this.addSlot(new SlotItemHandler(internal, 75, 50, 112) {
		}));
		this.customSlots.put(76, this.addSlot(new SlotItemHandler(internal, 76, 68, 112) {
		}));
		this.customSlots.put(77, this.addSlot(new SlotItemHandler(internal, 77, 86, 112) {
		}));
		this.customSlots.put(78, this.addSlot(new SlotItemHandler(internal, 78, 104, 112) {
		}));
		this.customSlots.put(79, this.addSlot(new SlotItemHandler(internal, 79, 122, 112) {
		}));
		this.customSlots.put(80, this.addSlot(new SlotItemHandler(internal, 80, 140, 112) {
		}));
		this.customSlots.put(81, this.addSlot(new SlotItemHandler(internal, 81, 158, 112) {
		}));
		this.customSlots.put(82, this.addSlot(new SlotItemHandler(internal, 82, 176, 112) {
		}));
		this.customSlots.put(83, this.addSlot(new SlotItemHandler(internal, 83, 194, 112) {
		}));
		this.customSlots.put(84, this.addSlot(new SlotItemHandler(internal, 84, 212, 112) {
		}));
		this.customSlots.put(85, this.addSlot(new SlotItemHandler(internal, 85, 230, 112) {
		}));
		this.customSlots.put(86, this.addSlot(new SlotItemHandler(internal, 86, 14, 76) {
		}));
		this.customSlots.put(87, this.addSlot(new SlotItemHandler(internal, 87, 14, 22) {
		}));
		this.customSlots.put(88, this.addSlot(new SlotItemHandler(internal, 88, 14, 40) {
		}));
		this.customSlots.put(89, this.addSlot(new SlotItemHandler(internal, 89, 14, 58) {
		}));
		this.customSlots.put(90, this.addSlot(new SlotItemHandler(internal, 90, 14, 94) {
		}));
		this.customSlots.put(91, this.addSlot(new SlotItemHandler(internal, 91, 14, 112) {
		}));
		this.customSlots.put(92, this.addSlot(new SlotItemHandler(internal, 92, 248, 22) {
		}));
		this.customSlots.put(93, this.addSlot(new SlotItemHandler(internal, 93, 248, 40) {
		}));
		this.customSlots.put(94, this.addSlot(new SlotItemHandler(internal, 94, 248, 58) {
		}));
		this.customSlots.put(95, this.addSlot(new SlotItemHandler(internal, 95, 248, 76) {
		}));
		this.customSlots.put(96, this.addSlot(new SlotItemHandler(internal, 96, 248, 94) {
		}));
		this.customSlots.put(97, this.addSlot(new SlotItemHandler(internal, 97, 248, 112) {
		}));
		this.customSlots.put(98, this.addSlot(new SlotItemHandler(internal, 98, 266, 22) {
		}));
		this.customSlots.put(99, this.addSlot(new SlotItemHandler(internal, 99, 266, 40) {
		}));
		this.customSlots.put(100, this.addSlot(new SlotItemHandler(internal, 100, 266, 58) {
		}));
		this.customSlots.put(101, this.addSlot(new SlotItemHandler(internal, 101, 266, 76) {
		}));
		this.customSlots.put(102, this.addSlot(new SlotItemHandler(internal, 102, 266, 94) {
		}));
		this.customSlots.put(103, this.addSlot(new SlotItemHandler(internal, 103, 266, 112) {
		}));
		this.customSlots.put(104, this.addSlot(new SlotItemHandler(internal, 104, 284, 22) {
		}));
		this.customSlots.put(105, this.addSlot(new SlotItemHandler(internal, 105, 284, 40) {
		}));
		this.customSlots.put(106, this.addSlot(new SlotItemHandler(internal, 106, 284, 58) {
		}));
		this.customSlots.put(107, this.addSlot(new SlotItemHandler(internal, 107, 284, 76) {
		}));
		this.customSlots.put(108, this.addSlot(new SlotItemHandler(internal, 108, 284, 94) {
		}));
		this.customSlots.put(109, this.addSlot(new SlotItemHandler(internal, 109, 284, 112) {
			@Override
			public void setChanged() {
				super.setChanged();
				slotChanged(109, 0, 0);
			}
		}));
		this.customSlots.put(110, this.addSlot(new SlotItemHandler(internal, 110, 270, 163) {
		}));
		this.customSlots.put(111, this.addSlot(new SlotItemHandler(internal, 111, 270, 181) {
		}));
		this.customSlots.put(12, this.addSlot(new SlotItemHandler(internal, 12, 252, 163) {
		}));
		this.customSlots.put(13, this.addSlot(new SlotItemHandler(internal, 13, 252, 181) {
		}));
		for (int si = 0; si < 3; ++si)
			for (int sj = 0; sj < 9; ++sj)
				this.addSlot(new Slot(inv, sj + (si + 1) * 9, 65 + 8 + sj * 18, 60 + 84 + si * 18));
		for (int si = 0; si < 9; ++si)
			this.addSlot(new Slot(inv, si, 65 + 8 + si * 18, 60 + 142));
	}

	@Override
	public boolean stillValid(Player player) {
		return true;
	}

	@Override
	public ItemStack quickMoveStack(Player playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = (Slot) this.slots.get(index);
		if (slot != null && slot.hasItem()) {
			ItemStack itemstack1 = slot.getItem();
			itemstack = itemstack1.copy();
			if (index < 112) {
				if (!this.moveItemStackTo(itemstack1, 112, this.slots.size(), true)) {
					return ItemStack.EMPTY;
				}
				slot.onQuickCraft(itemstack1, itemstack);
			} else if (!this.moveItemStackTo(itemstack1, 0, 112, false)) {
				if (index < 112 + 27) {
					if (!this.moveItemStackTo(itemstack1, 112 + 27, this.slots.size(), true)) {
						return ItemStack.EMPTY;
					}
				} else {
					if (!this.moveItemStackTo(itemstack1, 112, 112 + 27, false)) {
						return ItemStack.EMPTY;
					}
				}
				return ItemStack.EMPTY;
			}
			if (itemstack1.getCount() == 0) {
				slot.set(ItemStack.EMPTY);
			} else {
				slot.setChanged();
			}
			if (itemstack1.getCount() == itemstack.getCount()) {
				return ItemStack.EMPTY;
			}
			slot.onTake(playerIn, itemstack1);
		}
		return itemstack;
	}

	@Override
	protected boolean moveItemStackTo(ItemStack p_38904_, int p_38905_, int p_38906_, boolean p_38907_) {
		boolean flag = false;
		int i = p_38905_;
		if (p_38907_) {
			i = p_38906_ - 1;
		}
		if (p_38904_.isStackable()) {
			while (!p_38904_.isEmpty()) {
				if (p_38907_) {
					if (i < p_38905_) {
						break;
					}
				} else if (i >= p_38906_) {
					break;
				}
				Slot slot = this.slots.get(i);
				ItemStack itemstack = slot.getItem();
				if (slot.mayPlace(itemstack) && !itemstack.isEmpty() && ItemStack.isSameItemSameTags(p_38904_, itemstack)) {
					int j = itemstack.getCount() + p_38904_.getCount();
					int maxSize = Math.min(slot.getMaxStackSize(), p_38904_.getMaxStackSize());
					if (j <= maxSize) {
						p_38904_.setCount(0);
						itemstack.setCount(j);
						slot.set(itemstack);
						flag = true;
					} else if (itemstack.getCount() < maxSize) {
						p_38904_.shrink(maxSize - itemstack.getCount());
						itemstack.setCount(maxSize);
						slot.set(itemstack);
						flag = true;
					}
				}
				if (p_38907_) {
					--i;
				} else {
					++i;
				}
			}
		}
		if (!p_38904_.isEmpty()) {
			if (p_38907_) {
				i = p_38906_ - 1;
			} else {
				i = p_38905_;
			}
			while (true) {
				if (p_38907_) {
					if (i < p_38905_) {
						break;
					}
				} else if (i >= p_38906_) {
					break;
				}
				Slot slot1 = this.slots.get(i);
				ItemStack itemstack1 = slot1.getItem();
				if (itemstack1.isEmpty() && slot1.mayPlace(p_38904_)) {
					if (p_38904_.getCount() > slot1.getMaxStackSize()) {
						slot1.set(p_38904_.split(slot1.getMaxStackSize()));
					} else {
						slot1.set(p_38904_.split(p_38904_.getCount()));
					}
					slot1.setChanged();
					flag = true;
					break;
				}
				if (p_38907_) {
					--i;
				} else {
					++i;
				}
			}
		}
		return flag;
	}

	@Override
	public void removed(Player playerIn) {
		super.removed(playerIn);
		if (!bound && playerIn instanceof ServerPlayer serverPlayer) {
			if (!serverPlayer.isAlive() || serverPlayer.hasDisconnected()) {
				for (int j = 0; j < internal.getSlots(); ++j) {
					playerIn.drop(internal.extractItem(j, internal.getStackInSlot(j).getCount(), false), false);
				}
			} else {
				for (int i = 0; i < internal.getSlots(); ++i) {
					playerIn.getInventory().placeItemBackInInventory(internal.extractItem(i, internal.getStackInSlot(i).getCount(), false));
				}
			}
		}
	}

	private void slotChanged(int slotid, int ctype, int meta) {
		if (this.world != null && this.world.isClientSide()) {
			PalamodMod.PACKET_HANDLER.sendToServer(new GreenpaladiumchestguiSlotMessage(slotid, x, y, z, ctype, meta));
			GreenpaladiumchestguiSlotMessage.handleSlotAction(entity, slotid, ctype, meta, x, y, z);
		}
	}

	public Map<Integer, Slot> get() {
		return customSlots;
	}
}
