
package palamod.command;

import palamod.procedures.ConnectadminshoputilitiesredstoneProcedure;
import palamod.procedures.ConnectadminshoputilitiesemeraldProcedure;
import palamod.procedures.ConnectadminshoputilitiesdiampicProcedure;
import palamod.procedures.ConnectadminshoputilitiesProcedure;
import palamod.procedures.ConnectadminshopplantwheatProcedure;
import palamod.procedures.ConnectadminshopplantwarpedfungusProcedure;
import palamod.procedures.ConnectadminshopplantsugarcaneProcedure;
import palamod.procedures.ConnectadminshopplantredmushroomProcedure;
import palamod.procedures.ConnectadminshopplantpotatoProcedure;
import palamod.procedures.ConnectadminshopplantmelonProcedure;
import palamod.procedures.ConnectadminshopplantcrimsonfungusProcedure;
import palamod.procedures.ConnectadminshopplantcarrotProcedure;
import palamod.procedures.ConnectadminshopplantcactusProcedure;
import palamod.procedures.ConnectadminshopplantbrownmushroomProcedure;
import palamod.procedures.ConnectadminshopmobswitherskullProcedure;
import palamod.procedures.ConnectadminshopmobsstringProcedure;
import palamod.procedures.ConnectadminshopmobsspidereyesProcedure;
import palamod.procedures.ConnectadminshopmobsslimeballProcedure;
import palamod.procedures.ConnectadminshopmobsrottenfleshProcedure;
import palamod.procedures.ConnectadminshopmobsghasttearsProcedure;
import palamod.procedures.ConnectadminshopmobsfrspidereyesProcedure;
import palamod.procedures.ConnectadminshopmobsenderpearlProcedure;
import palamod.procedures.ConnectadminshopmobseggProcedure;
import palamod.procedures.ConnectadminshopmobsboneProcedure;
import palamod.procedures.ConnectadminshopmobsProcedure;
import palamod.procedures.ConnectadhoretitaneProcedure;
import palamod.procedures.ConnectadhorepalaProcedure;
import palamod.procedures.ConnectadhoreironProcedure;
import palamod.procedures.ConnectadhoregoldProcedure;
import palamod.procedures.ConnectadhorefindiumProcedure;
import palamod.procedures.ConnectadhorediamondProcedure;
import palamod.procedures.ConnectadhorecoalProcedure;
import palamod.procedures.ConnectadhoreameProcedure;
import palamod.procedures.ConnectadhoreProcedure;
import palamod.procedures.ConnectadhblkstoneProcedure;
import palamod.procedures.ConnectadhblksoulsandProcedure;
import palamod.procedures.ConnectadhblksandProcedure;
import palamod.procedures.ConnectadhblkoakwoodProcedure;
import palamod.procedures.ConnectadhblknetherrackProcedure;
import palamod.procedures.ConnectadhblkgravelProcedure;
import palamod.procedures.ConnectadhblkgrassProcedure;
import palamod.procedures.ConnectadhblkglowstoneProcedure;
import palamod.procedures.ConnectadhblkdirtProcedure;
import palamod.procedures.ConnectadhblkblackstoneProcedure;
import palamod.procedures.ConnectAdminshopmobs2steakProcedure;
import palamod.procedures.ConnectAdminshopmobs2leatherProcedure;
import palamod.procedures.ConnectAdminshopmobs2inksacProcedure;
import palamod.procedures.ConnectAdminshopmobs2gunpowderProcedure;
import palamod.procedures.ConnectAdminshopmobs2glowinksacProcedure;
import palamod.procedures.ConnectAdminshopmobs2featherProcedure;
import palamod.procedures.ConnectAdminshopmobs2blazeProcedure;
import palamod.procedures.AdminshopblockconnectProcedure;
import palamod.procedures.Adminshop_openProcedure;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.common.util.FakePlayerFactory;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.Commands;

@Mod.EventBusSubscriber
public class AdminshopCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("adminshop")

				.executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					Adminshop_openProcedure.execute(world, x, y, z, entity);
					return 0;
				}).then(Commands.literal("ores").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadhoreProcedure.execute(world, x, y, z, entity);
					return 0;
				}).then(Commands.literal("paladium").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadhorepalaProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("titane").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadhoretitaneProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("amethyst").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadhoreameProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("diamond").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadhorediamondProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("coal").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadhorecoalProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("findium").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadhorefindiumProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("emerald").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadminshoputilitiesemeraldProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("iron").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadhoreironProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("gold").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadhoregoldProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("redstone").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadminshoputilitiesredstoneProcedure.execute(world, x, y, z, entity);
					return 0;
				}))).then(Commands.literal("mobs").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadminshopmobsProcedure.execute(world, x, y, z, entity);
					return 0;
				}).then(Commands.literal("slimeball").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadminshopmobsslimeballProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("ender_pearl").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadminshopmobsenderpearlProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("string").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadminshopmobsstringProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("spider_eyes").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadminshopmobsspidereyesProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("fermented_spider_eyes").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadminshopmobsfrspidereyesProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("egg").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadminshopmobseggProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("bone").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadminshopmobsboneProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("ghast_tears").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadminshopmobsghasttearsProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("rotten_flesh").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadminshopmobsrottenfleshProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("wither_skull").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadminshopmobswitherskullProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("steak").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectAdminshopmobs2steakProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("gunpowder").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectAdminshopmobs2gunpowderProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("blaze").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectAdminshopmobs2blazeProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("ink_sac").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectAdminshopmobs2inksacProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("glow_ink_sac").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectAdminshopmobs2glowinksacProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("feather").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectAdminshopmobs2featherProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("leather").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectAdminshopmobs2leatherProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("honey_comb").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectAdminshopmobs2leatherProcedure.execute(world, x, y, z, entity);
					return 0;
				}))).then(Commands.literal("utilities").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadminshoputilitiesProcedure.execute(world, x, y, z, entity);
					return 0;
				}).then(Commands.literal("emerald").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadminshoputilitiesemeraldProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("redstone").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadminshoputilitiesredstoneProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("oak_wood").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadhblkoakwoodProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("ender_pearl").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadminshopmobsenderpearlProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("coal").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadhorecoalProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("stone").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadhblkstoneProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("netherrack").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadhblknetherrackProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("steak").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectAdminshopmobs2steakProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("bone").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadminshopmobsboneProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("pickaxe").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadminshoputilitiesdiampicProcedure.execute(world, x, y, z, entity);
					return 0;
				}))).then(Commands.literal("blocks").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					AdminshopblockconnectProcedure.execute(world, x, y, z, entity);
					return 0;
				}).then(Commands.literal("dirt").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadhblkdirtProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("stone").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadhblkstoneProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("grass").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadhblkgrassProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("sand").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadhblksandProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("soulsand").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadhblksoulsandProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("netherrack").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadhblknetherrackProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("gravel").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadhblkgravelProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("blackstone").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadhblkblackstoneProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("glowstone").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadhblkglowstoneProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("oak_wood").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadhblkoakwoodProcedure.execute(world, x, y, z, entity);
					return 0;
				}))).then(Commands.literal("plant").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					AdminshopblockconnectProcedure.execute(world, x, y, z, entity);
					return 0;
				}).then(Commands.literal("cactus").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadminshopplantcactusProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("potato").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadminshopplantpotatoProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("carrot").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadminshopplantcarrotProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("melon").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadminshopplantmelonProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("wheat").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadminshopplantwheatProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("red_mushroom").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadminshopplantredmushroomProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("brown_mushroom").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadminshopplantbrownmushroomProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("crimson_fungus").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadminshopplantcrimsonfungusProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("warped_fungus").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadminshopplantwarpedfungusProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("sugar_cane").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					ConnectadminshopplantsugarcaneProcedure.execute(world, x, y, z, entity);
					return 0;
				}))));
	}
}
