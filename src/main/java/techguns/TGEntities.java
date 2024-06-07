package techguns;

import java.util.ArrayList;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import techguns.entities.npcs.NPCTurret;
import techguns.entities.npcs.TGDummySpawn;
import techguns.entities.projectiles.AdvancedBulletProjectile;
import techguns.entities.projectiles.AlienBlasterProjectile;
import techguns.entities.projectiles.BioGunProjectile;
import techguns.entities.projectiles.BlasterProjectile;
import techguns.entities.projectiles.ChainsawProjectile;
import techguns.entities.projectiles.CyberdemonBlasterProjectile;
import techguns.entities.projectiles.DeatomizerProjectile;
import techguns.entities.projectiles.FlamethrowerProjectile;
import techguns.entities.projectiles.FragGrenadeProjectile;
import techguns.entities.projectiles.GaussProjectile;
import techguns.entities.projectiles.GenericProjectile;
import techguns.entities.projectiles.GenericProjectileExplosive;
import techguns.entities.projectiles.GenericProjectileIncendiary;
import techguns.entities.projectiles.Grenade40mmProjectile;
import techguns.entities.projectiles.GrenadeProjectile;
import techguns.entities.projectiles.GuidedMissileProjectile;
import techguns.entities.projectiles.GuidedMissileProjectileHV;
import techguns.entities.projectiles.LaserProjectile;
import techguns.entities.projectiles.NDRProjectile;
import techguns.entities.projectiles.PowerHammerProjectile;
import techguns.entities.projectiles.RocketProjectile;
import techguns.entities.projectiles.RocketProjectileHV;
import techguns.entities.projectiles.RocketProjectileNuke;
import techguns.entities.projectiles.SonicShotgunProjectile;
import techguns.entities.projectiles.StoneBulletProjectile;
import techguns.entities.projectiles.TFGProjectile;
import techguns.entities.projectiles.TeslaProjectile;
import techguns.entities.spawn.TGNpcSpawn;
import techguns.entities.spawn.TGSpawnManager;
import techguns.entities.special.EntityRadiation;
import techguns.init.ITGInitializer;

public class TGEntities implements ITGInitializer {

	public static final int bulletTrackRange = 128;
	
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		
		/**
		 * PROJECTILES
		 */
		//int bulletTrackRange = 128;
		
		EntityRegistry.registerModEntity(new ResourceLocation(Techguns.MODID,"GenericProjectile"),GenericProjectile.class, "GenericProjectile", ++Techguns.modEntityID, Techguns.MODID, bulletTrackRange, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Techguns.MODID,"GenericProjectileIncendiary"),GenericProjectileIncendiary.class, "GenericProjectileIncendiary", ++Techguns.modEntityID, Techguns.MODID, bulletTrackRange, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Techguns.MODID,"RocketProjectile"),RocketProjectile.class, "RocketProjectile", ++Techguns.modEntityID, Techguns.MODID, bulletTrackRange, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Techguns.MODID,"StoneBulletProjectile"),StoneBulletProjectile.class, "StoneBulletProjectile", ++Techguns.modEntityID, Techguns.MODID, bulletTrackRange, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Techguns.MODID,"BioGunProjectile"),BioGunProjectile.class, "BioGunProjectile", ++Techguns.modEntityID, Techguns.MODID, bulletTrackRange, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Techguns.MODID,"FlamethrowerProjectile"),FlamethrowerProjectile.class, "FlamethrowerProjectile", ++Techguns.modEntityID, Techguns.MODID, bulletTrackRange, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Techguns.MODID,"GrenadeProjectile"),GrenadeProjectile.class, "GrenadeProjectile", ++Techguns.modEntityID, Techguns.MODID, bulletTrackRange, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Techguns.MODID,"Grenade40mmProjectile"),Grenade40mmProjectile.class, "Grenade40mmProjectile", ++Techguns.modEntityID, Techguns.MODID, bulletTrackRange, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Techguns.MODID,"LaserProjectile"),LaserProjectile.class, "LaserProjectile", ++Techguns.modEntityID, Techguns.MODID, bulletTrackRange, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Techguns.MODID,"TeslaProjectile"),TeslaProjectile.class, "TeslaProjectile", ++Techguns.modEntityID, Techguns.MODID, bulletTrackRange, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Techguns.MODID,"NDRProjectile"),NDRProjectile.class, "NDRProjectile", ++Techguns.modEntityID, Techguns.MODID, bulletTrackRange, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Techguns.MODID,"BlasterProjectile"),BlasterProjectile.class, "BlasterProjectile", ++Techguns.modEntityID, Techguns.MODID, bulletTrackRange, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Techguns.MODID,"GaussProjectile"),GaussProjectile.class, "GaussProjectile", ++Techguns.modEntityID, Techguns.MODID, bulletTrackRange, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Techguns.MODID,"AdvancedBulletProjectile"),AdvancedBulletProjectile.class, "AdvancedBulletProjectile", ++Techguns.modEntityID, Techguns.MODID, bulletTrackRange, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Techguns.MODID,"GuidedMissileProjectile"),GuidedMissileProjectile.class, "GuidedMissileProjectile", ++Techguns.modEntityID, Techguns.MODID, bulletTrackRange, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Techguns.MODID,"DeatomizerProjectile"),DeatomizerProjectile.class, "DeatomizerProjectile", ++Techguns.modEntityID, Techguns.MODID, bulletTrackRange, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Techguns.MODID,"AlienBlasterProjectile"),AlienBlasterProjectile.class, "AlienBlasterProjectile", ++Techguns.modEntityID, Techguns.MODID, bulletTrackRange, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Techguns.MODID,"SonicShotgunProjectile"),SonicShotgunProjectile.class, "SonicShotgunProjectile", ++Techguns.modEntityID, Techguns.MODID, bulletTrackRange, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Techguns.MODID,"CyberdemonBlasterProjectile"),CyberdemonBlasterProjectile.class, "CyberdemonBlasterProjectile", ++Techguns.modEntityID, Techguns.MODID, bulletTrackRange, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Techguns.MODID,"PowerHammerProjectile"),PowerHammerProjectile.class, "PowerHammerProjectile", ++Techguns.modEntityID, Techguns.MODID, bulletTrackRange, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Techguns.MODID,"ChainsawProjectile"),ChainsawProjectile.class, "ChainsawProjectile", ++Techguns.modEntityID, Techguns.MODID, bulletTrackRange, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Techguns.MODID,"FragGrenadeProjectile"),FragGrenadeProjectile.class, "FragGrenadeProjectile", ++Techguns.modEntityID, Techguns.MODID, bulletTrackRange, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Techguns.MODID,"RocketProjectileNuke"),RocketProjectileNuke.class, "RocketProjectileNuke", ++Techguns.modEntityID, Techguns.MODID, bulletTrackRange, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Techguns.MODID,"TFGProjectile"),TFGProjectile.class, "TFGProjectile", ++Techguns.modEntityID, Techguns.MODID, bulletTrackRange, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Techguns.MODID,"GenericProjectileExplosive"),GenericProjectileExplosive.class, "GenericProjectileExplosive", ++Techguns.modEntityID, Techguns.MODID, bulletTrackRange, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Techguns.MODID,"RocketProjectileHV"),RocketProjectileHV.class, "RocketProjectileHV", ++Techguns.modEntityID, Techguns.MODID, bulletTrackRange, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Techguns.MODID,"RadiationEntity"), EntityRadiation.class, "RadiationEntity", ++Techguns.modEntityID, Techguns.MODID, bulletTrackRange, 1, false);
		EntityRegistry.registerModEntity(new ResourceLocation(Techguns.MODID,"GuidedMissileProjectileHV"),GuidedMissileProjectileHV.class, "GuidedMissileProjectileHV", ++Techguns.modEntityID, Techguns.MODID, bulletTrackRange, 1, true);
		
		
		/**
		 * NPCS
		 */
		EntityRegistry.registerModEntity(new ResourceLocation(Techguns.MODID,"turret"),NPCTurret.class,  Techguns.MODID+".Turret", ++Techguns.modEntityID, Techguns.MODID, 80, 3, false);
		EntityRegistry.registerModEntity(new ResourceLocation(Techguns.MODID,"TGDummySpawn"),TGDummySpawn.class,  Techguns.MODID+".DummySpawn", ++Techguns.modEntityID, Techguns.MODID, 80, 3, false);
	}


	static void registerModEntityWithEgg(Class parEntityClass, String parEntityName, 
		      int parEggColor, int parEggSpotsColor)
	{
		registerModEntityWithEgg(parEntityClass, parEntityName, parEggColor, parEggSpotsColor,80);
	}
	
	static void registerModEntityWithEgg(Class parEntityClass, String parEntityName, 
		      int parEggColor, int parEggSpotsColor, int trackingrange)
	{
	    EntityRegistry.registerModEntity(new ResourceLocation(Techguns.MODID,parEntityName),parEntityClass, Techguns.MODID+"."+parEntityName, ++Techguns.modEntityID, Techguns.instance, trackingrange, 3, false, parEggColor, parEggSpotsColor);
	}
	
	@Override
	public void init(FMLInitializationEvent event) {

		//registerSpawn does not add the spawn if the spawnweight is <=0
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		ArrayList<Biome> overworldBiomes = new ArrayList<>();
		ArrayList<Biome> netherBiomes = new ArrayList<>();
		ForgeRegistries.BIOMES.forEach(b -> {
			
			if (!isBlacklisted(b.getRegistryName().toString())) {
			
				if (!BiomeDictionary.hasType(b, BiomeDictionary.Type.NETHER) && !BiomeDictionary.hasType(b, BiomeDictionary.Type.END)){
					overworldBiomes.add(b);
				} else if (BiomeDictionary.hasType(b, Type.NETHER)) {
					netherBiomes.add(b);
				}
			}
		});

		if(TGConfig.spawnWeightTGOverworld>0) {
			EntityRegistry.addSpawn(TGDummySpawn.class, TGConfig.spawnWeightTGOverworld, 1, 3, EnumCreatureType.MONSTER,overworldBiomes.toArray(new Biome[overworldBiomes.size()]));
		}
		if(TGConfig.spawnWeightTGNether>0) {
			EntityRegistry.addSpawn(TGDummySpawn.class, TGConfig.spawnWeightTGNether, 1, 3, EnumCreatureType.MONSTER,netherBiomes.toArray(new Biome[netherBiomes.size()]));
		}
	}

	protected static boolean isBlacklisted(String registryName) {
		for (String s: TGConfig.biomeBlacklist) {
			if(registryName.equals(s)) {
				return true;
			}
		}
		return false;
	}
	
	@SideOnly(Side.CLIENT)
    public static void initModels() {
    }
}
