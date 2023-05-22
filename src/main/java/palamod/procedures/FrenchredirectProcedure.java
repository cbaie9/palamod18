package palamod.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;

public class FrenchredirectProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putString("language", "french");
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent("La langue du palamod a \u00E9t\u00E9 chang\u00E9 par le fran\u00E7ais"), false);
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent("Due au fonctionnement du jeux, le changement de langue est temporaire et sera re-initialis\u00E9 au prochain lancement du jeu"), false);
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent("Pour rentre ce changement d\u00E9finitif "), false);
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent("Tapez la touche Windows+r puis entrer %appdata%\\.minecraft\\config"), false);
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent("Puis cherchez un fichier nomm\u00E9 Palamod_client_settings.toml"), false);
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent("Dans ce fichier remplacer la variable language par english ( anglais ) ou par french ( fran\u00E7ais )"), false);
	}
}
