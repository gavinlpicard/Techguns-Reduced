package techguns.deatheffects;

import java.util.HashMap;
import java.util.HashSet;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityEvoker;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityHusk;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.monster.EntityShulker;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityStray;
import net.minecraft.entity.monster.EntityVex;
import net.minecraft.entity.monster.EntityVindicator;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.EntityZombieVillager;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityDonkey;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.passive.EntityMule;
import net.minecraft.entity.passive.EntityParrot;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Server and client side, needed by server to know to send out packets
 *
 */
public class EntityDeathUtils {
	
	public static HashMap<DeathType, HashSet<Class<? extends EntityLivingBase>>> entityDeathTypes;

	public static HashSet<Class<? extends EntityLivingBase>> goreMap = new HashSet<>();
	static {
		entityDeathTypes = new HashMap<>();
		//Gore
		
		goreMap.add(EntityPlayer.class);
		goreMap.add(EntityZombie.class);
		goreMap.add(EntitySkeleton.class);
		goreMap.add(EntityEnderman.class);
		goreMap.add(EntityCreeper.class);
		goreMap.add(EntityCow.class);
		goreMap.add(EntitySheep.class);
		goreMap.add(EntityPig.class);
		goreMap.add(EntityChicken.class);
		goreMap.add(EntityPigZombie.class);
		goreMap.add(EntitySpider.class);
		goreMap.add(EntityCaveSpider.class);
		goreMap.add(EntityWitch.class);
		goreMap.add(EntitySlime.class);
		goreMap.add(EntityHorse.class);
		goreMap.add(EntityMooshroom.class);
		goreMap.add(EntityWolf.class);
		goreMap.add(EntitySquid.class);
		//goreMap.add(EntityGhast.class);
		goreMap.add(EntityVillager.class);
		goreMap.add(EntityLlama.class);
		goreMap.add(EntityEvoker.class);
		goreMap.add(EntityHusk.class);
		goreMap.add(EntityPolarBear.class);
		goreMap.add(EntityMagmaCube.class);
		goreMap.add(EntityParrot.class);
		goreMap.add(EntityRabbit.class);
		goreMap.add(EntityStray.class);
		goreMap.add(EntitySilverfish.class);
		goreMap.add(EntityVindicator.class);
		goreMap.add(EntityVex.class);
		goreMap.add(EntityShulker.class);
		goreMap.add(EntityWitherSkeleton.class);
		goreMap.add(EntityGhast.class);
		goreMap.add(EntityZombieVillager.class);
		goreMap.add(EntityHorse.class);
		goreMap.add(EntityDonkey.class);
		goreMap.add(EntityMule.class);
		
		
		entityDeathTypes.put(DeathType.GORE, goreMap);
	}
	
	/**
	 * Add an entity to the gore death type list
	 * @param clazz
	 */
	public static void addEntityToDeathEffectList(Class<? extends EntityLivingBase> clazz) {
		entityDeathTypes.get(DeathType.GORE).add(clazz);
	}
	
	public static boolean hasSpecialDeathAnim(EntityLivingBase entityLiving, DeathType deathtype) {

		//TEST CODE:
		if (deathtype == DeathType.BIO || deathtype == DeathType.LASER) return true;
		
		//GenericGore
		if (entityDeathTypes.get(DeathType.GORE).contains(entityLiving.getClass())){
			return true;
		}
		
		return false;
		

	}
	
    public enum DeathType {
    	DEFAULT(0), GORE(1), BIO(2), LASER(3), DISMEMBER(4);
    	
    	int value;
    	
    	private DeathType(int value) {
    		this.value = value;
    	}
    	
    	public int getValue() {
    		return value;
    	}
    }
}
