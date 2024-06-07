package techguns;

import java.util.ArrayList;

import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;
import techguns.damagesystem.ShieldStats;
import techguns.init.ITGInitializer;
import techguns.items.armors.ArmorPowerType;
import techguns.items.armors.GenericArmor;
import techguns.items.armors.GenericArmorMultiCamo;
import techguns.items.armors.GenericShield;
import techguns.items.armors.PoweredArmor;
import techguns.items.armors.TGArmorMaterial;
import techguns.tools.ItemJsonCreator;
import techguns.util.ItemStackOreDict;

public class TGArmors implements ITGInitializer {
	public static final ArrayList<GenericArmor> armors = new ArrayList<>();
	public static final ArrayList<GenericShield> shields = new ArrayList<>();
	
	public static final ResourceLocation ARMORMODEL_STEAM_ARMOR_0 = new ResourceLocation(Techguns.MODID, "steam_armor_0");
	public static final ResourceLocation ARMORMODEL_STEAM_ARMOR_1 = new ResourceLocation(Techguns.MODID, "steam_armor_1");
	public static final ResourceLocation ARMORMODEL_POWER_ARMOR_0 = new ResourceLocation(Techguns.MODID, "power_armor_0");
	public static final ResourceLocation ARMORMODEL_POWER_ARMOR_1 = new ResourceLocation(Techguns.MODID, "power_armor_1");
	public static final ResourceLocation ARMORMODEL_EXO_SUIT_0 = new ResourceLocation(Techguns.MODID, "exo_suit_0");
	public static final ResourceLocation ARMORMODEL_EXO_SUIT_1 = new ResourceLocation(Techguns.MODID, "exo_suit_1");
	public static final ResourceLocation ARMORMODEL_EXO_SUIT_2 = new ResourceLocation(Techguns.MODID, "exo_suit_2");
	public static final ResourceLocation ARMORMODEL_BERET_0 = new ResourceLocation(Techguns.MODID, "beret_0");
	public static final ResourceLocation ARMORMODEL_COAT_0 = new ResourceLocation(Techguns.MODID, "coat_0");
	public static final ResourceLocation ARMORMODEL_COAT_1 = new ResourceLocation(Techguns.MODID, "coat_1");
	public static final ResourceLocation ARMORMODEL_COAT_2 = new ResourceLocation(Techguns.MODID, "coat_2");
	public static final ResourceLocation ARMORMODEL_COAT_3 = new ResourceLocation(Techguns.MODID, "coat_3");
	public static final ResourceLocation ARMORMODEL_STEAM_ARMOR_2 = new ResourceLocation(Techguns.MODID, "steam_armor_2");
	public static final ResourceLocation ARMORMODEL_POWER_ARMOR_2 = new ResourceLocation(Techguns.MODID, "power_armor_2");
	public static final ResourceLocation ARMORMODEL_POWER_ARMOR_MK2_0 = new ResourceLocation(Techguns.MODID, "power_armor_mk2_0");
	public static final ResourceLocation ARMORMODEL_POWER_ARMOR_MK2_1 = new ResourceLocation(Techguns.MODID, "power_armor_mk2_1");
	public static final ResourceLocation ARMORMODEL_POWER_ARMOR_MK2_2 = new ResourceLocation(Techguns.MODID, "power_armor_mk2_2");
	
	
	public static TGArmorMaterial T1_COMBAT = new TGArmorMaterial("T1_COMBAT", 60, 0, 15.0f, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,0.5f);
	public static TGArmorMaterial T1_SCOUT = new TGArmorMaterial("T1_SCOUT", 60, 0, 13.0f,  SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,0f);
	public static TGArmorMaterial T1_MINER = new TGArmorMaterial("T1_MINER", 60, 0, 13.0f,  SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,0f);
	public static TGArmorMaterial T1_STEAM = new TGArmorMaterial("T1_STEAM", 200, 0, 19.0f,  SoundEvents.ITEM_ARMOR_EQUIP_IRON,1f).setArmorElemental(17.0f).setArmorExplosion(18.0f).setArmorPoison(10.0f).setArmorRadiation(6.0f).setPenetrationResistance(0.1f);
	
	public static TGArmorMaterial T2_HAZMAT = new TGArmorMaterial("T2_HAZMAT", 80, 0, 10.0f, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,0f).setArmorElemental(16.0f).setArmorExplosion(10.0f).setArmorPoison(20.0f).setArmorRadiation(20.0f);
	
	
	public static TGArmorMaterial T2_COMBAT = new TGArmorMaterial("T2_COMBAT", 72, 0, 18.0f, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,1f);
	public static TGArmorMaterial T2_COMMANDO = new TGArmorMaterial("T2_COMMANDO", 72, 0, 18.0f, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,1f).setArmorElemental(16.0f).setArmorExplosion(16.0f).setArmorPoison(10.0f).setArmorRadiation(5.0f);
	
	public static TGArmorMaterial T2_RIOT = new TGArmorMaterial("T2_RIOT", 96, 0, 18.5f, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,1.5f).setArmorFire(18.0f).setArmorExplosion(18.0f).setArmorEnergy(18.0f).setArmorIce(17.0f).setArmorLightning(17.0f).setArmorPoison(16.0f).setArmorRadiation(16.0f).setPenetrationResistance(0.1f);
	
	
	public static TGArmorMaterial T3_COMBAT = new TGArmorMaterial("T3_COMBAT", 240, 0, 21.0f, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN,2.0f).setArmorFire(18.0f).setArmorExplosion(18.0f).setArmorEnergy(19.0f).setArmorIce(18.0f).setArmorLightning(18.0f).setArmorPoison(10.0f).setArmorRadiation(12.0f).setPenetrationResistance(0.15f);
	
	public static TGArmorMaterial T3_POWER = new TGArmorMaterial("T3_POWER", 360, 0, 22.0f, SoundEvents.ITEM_ARMOR_EQUIP_IRON,2.5f).setArmorFire(19.0f).setArmorExplosion(21.0f).setArmorEnergy(20.0f).setArmorIce(19.0f).setArmorLightning(19.0f).setArmorPoison(15.0f).setArmorRadiation(17.0f).setPenetrationResistance(0.25f);
	
	public static TGArmorMaterial T3_MINER = new TGArmorMaterial("T3_MINER",300,0,20.0f, SoundEvents.ITEM_ARMOR_EQUIP_IRON,2.0f).setArmorFire(20.0f).setArmorExplosion(20.0f).setArmorEnergy(20.0f).setArmorIce(20.0f).setArmorLightning(20.0f).setArmorPoison(20.0f).setArmorRadiation(20.0f).setPenetrationResistance(0.15f);
	
	//Same as T3_Combat
	public static TGArmorMaterial T3_EXO = new TGArmorMaterial("T3_EXO", 300, 0, 21.0f, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN,2.0f).setArmorFire(18.5f).setArmorExplosion(18.5f).setArmorEnergy(19.0f).setArmorIce(18.5f).setArmorLightning(18.5f).setArmorPoison(10.0f).setArmorRadiation(12.0f).setPenetrationResistance(0.15f);
	
	public static TGArmorMaterial T2_BERET = new TGArmorMaterial("T2_BERET",60,0,8.0f, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,0);

	
	public static TGArmorMaterial T4_PRAETOR = new TGArmorMaterial("T4_PRAETOR",360,0,22.0f, SoundEvents.ITEM_ARMOR_EQUIP_IRON,3.0f).setArmorFire(21.0f).setArmorExplosion(21.0f).setArmorEnergy(21.0f).setArmorIce(21.0f).setArmorLightning(21.0f).setArmorPoison(21.0f).setArmorRadiation(20.0f).setPenetrationResistance(0.25f);
	
	public static TGArmorMaterial T4_POWER = new TGArmorMaterial("T4_POWER", 460, 0, 23.0f, SoundEvents.ITEM_ARMOR_EQUIP_IRON,3.5f).setArmorFire(21.0f).setArmorExplosion(22.0f).setArmorEnergy(21.0f).setArmorIce(21.0f).setArmorLightning(21.0f).setArmorPoison(19.0f).setArmorRadiation(20.0f).setPenetrationResistance(0.3f);
	
	/**
	 * ARMORS
	 */
	public static GenericArmor t1_combat_Helmet;
	public static GenericArmor t1_combat_Chestplate;
	public static GenericArmor t1_combat_Leggings;
	public static GenericArmor t1_combat_Boots;
	
	public static GenericArmor t1_scout_Helmet;
	public static GenericArmor t1_scout_Chestplate;
	public static GenericArmor t1_scout_Leggings;
	public static GenericArmor t1_scout_Boots;
	
	public static GenericArmor t1_miner_Helmet;
	public static GenericArmor t1_miner_Chestplate;
	public static GenericArmor t1_miner_Leggings;
	public static GenericArmor t1_miner_Boots;
	
	public static GenericArmor steam_Helmet;
	public static GenericArmor steam_Chestplate;
	public static GenericArmor steam_Leggings;
	public static GenericArmor steam_Boots;

	public static GenericArmor hazmat_Helmet;
	public static GenericArmor hazmat_Chestplate;
	public static GenericArmor hazmat_Leggings;
	public static GenericArmor hazmat_Boots;
	
	public static GenericArmor t2_combat_Helmet;
	public static GenericArmor t2_combat_Chestplate;
	public static GenericArmor t2_combat_Leggings;
	public static GenericArmor t2_combat_Boots;
	
	public static GenericArmor t2_commando_Helmet;
	public static GenericArmor t2_commando_Chestplate;
	public static GenericArmor t2_commando_Leggings;
	public static GenericArmor t2_commando_Boots;
	
	public static GenericArmor t2_riot_Helmet;
	public static GenericArmor t2_riot_Chestplate;
	public static GenericArmor t2_riot_Leggings;
	public static GenericArmor t2_riot_Boots;
	
	public static GenericArmor t3_combat_Helmet;
	public static GenericArmor t3_combat_Chestplate;
	public static GenericArmor t3_combat_Leggings;
	public static GenericArmor t3_combat_Boots;
	
	public static GenericArmor t3_power_Helmet;
	public static GenericArmor t3_power_Chestplate;
	public static GenericArmor t3_power_Leggings;
	public static GenericArmor t3_power_Boots;
	
	public static GenericArmor t3_miner_Helmet;
	public static GenericArmor t3_miner_Chestplate;
	public static GenericArmor t3_miner_Leggings;
	public static GenericArmor t3_miner_Boots;
	
	public static GenericArmor t3_exo_Helmet;
	public static GenericArmor t3_exo_Chestplate;
	public static GenericArmor t3_exo_Leggings;
	public static GenericArmor t3_exo_Boots;
	
	public static GenericArmor t4_praetor_Helmet;
	public static GenericArmor t4_praetor_Chestplate;
	public static GenericArmor t4_praetor_Leggings;
	public static GenericArmor t4_praetor_Boots;
	
	public static GenericArmor t4_power_Helmet;
	public static GenericArmor t4_power_Chestplate;
	public static GenericArmor t4_power_Leggings;
	public static GenericArmor t4_power_Boots;
	
	public static GenericArmor t2_beret;

	/**
	 * SHIELDS
	 */
	public static GenericShield riot_shield;
	public static GenericShield ballistic_shield;
	public static GenericShield advanced_shield;
	
	@Override
	public void preInit(FMLPreInitializationEvent event) {

		riot_shield = new GenericShield("riot_shield",1200,4).setRepairMat(new ItemStackOreDict("ingotSteel",3));
		ballistic_shield = new GenericShield("ballistic_shield",2400,4).setRepairMat(new ItemStackOreDict("plateObsidianSteel",3));
		advanced_shield = new GenericShield("advanced_shield",3200,3).setRepairMat(new ItemStackOreDict("plateCarbon",3));
		
		if(TGItems.WRITE_ITEM_JSON && event.getSide()==Side.CLIENT){
			armors.forEach(a -> ItemJsonCreator.writeItemJsonFileForPath("models/item/", a.getRegistryName().getResourcePath(),a.getRegistryName().getResourcePath()));
		}

	}
	
	public static void registerItems(RegistryEvent.Register<Item> event){
		IForgeRegistry<Item> reg = event.getRegistry();
		armors.forEach(a -> reg.register(a));
		shields.forEach(s -> reg.register(s));
		
		ShieldStats.SHIELD_STATS.put(Items.SHIELD, ShieldStats.VANILLA_SHIELD);
		ShieldStats.SHIELD_STATS.put(riot_shield, ShieldStats.RIOT_SHIELD_STATS);
		ShieldStats.SHIELD_STATS.put(ballistic_shield, ShieldStats.BALLISTIC_SHIELD_STATS);
		ShieldStats.SHIELD_STATS.put(advanced_shield, ShieldStats.ADVANCED_SHIELD_STATS);
	}
	
	@SideOnly(Side.CLIENT)
    public static void initModels() {
		armors.forEach(a -> a.initModel());
		shields.forEach(s -> s.initModel());
    }
	
	@Override
	public void init(FMLInitializationEvent event) {
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent event) {

	}
	
}
