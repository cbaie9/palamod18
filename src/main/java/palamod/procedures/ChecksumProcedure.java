package palamod.procedures;

import palamod.configuration.PalamodserverconfirgurationConfiguration;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;

public class ChecksumProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double output = 0;
		boolean valid = false;
		boolean crusher_valid = false;
		boolean Grinder_valid = false;
		if (PalamodserverconfirgurationConfiguration.CRUSHER_CUSTOM.get()) {
			if (0 < (double) PalamodserverconfirgurationConfiguration.CRUSHER_AMETHYST.get() && 0 < (double) PalamodserverconfirgurationConfiguration.CRUSHER_TITANE.get() && 0 < (double) PalamodserverconfirgurationConfiguration.CRUSHER_PALADIUM.get()
					&& 0 < (double) PalamodserverconfirgurationConfiguration.CRUSHER_ENDIUM.get() && 0 <= (double) PalamodserverconfirgurationConfiguration.CRUSHER_OUT_AMETHYST.get()
					&& 64 >= (double) PalamodserverconfirgurationConfiguration.CRUSHER_OUT_AMETHYST.get() && 0 <= (double) PalamodserverconfirgurationConfiguration.CRUSHER_OUT_TITANE.get()
					&& 64 >= (double) PalamodserverconfirgurationConfiguration.CRUSHER_OUT_TITANE.get() && 0 <= (double) PalamodserverconfirgurationConfiguration.CRUSHER_OUT_PALADIUM.get()
					&& 64 >= (double) PalamodserverconfirgurationConfiguration.CRUSHER_OUT_PALADIUM.get() && 0 <= (double) PalamodserverconfirgurationConfiguration.CRUSHER_OUT_ENDIUM.get()
					&& 64 >= (double) PalamodserverconfirgurationConfiguration.CRUSHER_OUT_ENDIUM.get()) {
				if (0 <= (double) PalamodserverconfirgurationConfiguration.CRUSHER_OUT_ENDIUM.get()) {
					crusher_valid = true;
				} else {
					crusher_valid = false;
				}
			} else {
				crusher_valid = false;
			}
		} else {
			valid = true;
		}
		if (PalamodserverconfirgurationConfiguration.GRINDER_CUSTOM.get()) {
			if (0 < (double) PalamodserverconfirgurationConfiguration.GNUM_MAX.get() && 0 < (double) PalamodserverconfirgurationConfiguration.GRINDER_STATE1.get() && 0 < (double) PalamodserverconfirgurationConfiguration.GRINDER_STATE2.get()
					&& 0 < (double) PalamodserverconfirgurationConfiguration.GRINDER_STATE3.get()) {
				Grinder_valid = true;
			} else {
				Grinder_valid = false;
			}
		}
		if (Grinder_valid && crusher_valid) {
			valid = true;
		} else {
			valid = false;
		}
		if (valid) {
			output = Math.round(
					Math.pow((double) PalamodserverconfirgurationConfiguration.GRINDER_STATE1.get() + (double) PalamodserverconfirgurationConfiguration.GRINDER_STATE2.get() + (double) PalamodserverconfirgurationConfiguration.GRINDER_STATE3.get(),
							(double) PalamodserverconfirgurationConfiguration.GNUM_MAX.get())
							* ((Math.pow((double) PalamodserverconfirgurationConfiguration.CRUSHER_AMETHYST.get(), (double) PalamodserverconfirgurationConfiguration.CRUSHER_TITANE.get())
									+ Math.pow((double) PalamodserverconfirgurationConfiguration.CRUSHER_PALADIUM.get(), (double) PalamodserverconfirgurationConfiguration.CRUSHER_ENDIUM.get()))
									/ Math.pow((double) PalamodserverconfirgurationConfiguration.CRUSHER_OUT_PALADIUM.get(), (double) PalamodserverconfirgurationConfiguration.CRUSHER_OUT_ENDIUM.get()))
							* ((double) PalamodserverconfirgurationConfiguration.CRUSHER_OUT_TITANE.get() + (double) PalamodserverconfirgurationConfiguration.CRUSHER_OUT_AMETHYST.get()));
		}
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent(("Checksum :" + output)), (false));
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent(("Valid value :" + valid)), (false));
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent(("Crusher cheat : " + PalamodserverconfirgurationConfiguration.CRUSHER_CUSTOM.get())), (false));
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent(("Crusher :" + PalamodserverconfirgurationConfiguration.GRINDER_CUSTOM.get())), (false));
	}
}
