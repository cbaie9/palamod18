package palamod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class SupportProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent("Support du mod :"), false);
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
					"tellraw @p {\"text\":\"Discord\",\"color\":\"#02FF00\",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"https://discord.com/invite/dVvNDrQENA\"}}");
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent("Code du mod"), false);
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
					"tellraw @p {\"text\":\"Github\",\"color\":\"#02FF00\",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"https://github.com/cbaie9/palamod19\"}}");
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent("v3.1___1.19hat"), false);
	}
}
