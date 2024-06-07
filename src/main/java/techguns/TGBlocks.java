package techguns;

import java.util.ArrayList;
import java.util.function.Predicate;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;
import techguns.blocks.BlockBioblob;
import techguns.blocks.BlockDebugMarker;
import techguns.blocks.BlockMilitaryCrate;
import techguns.blocks.BlockOreCluster;
import techguns.blocks.BlockSandbags;
import techguns.blocks.BlockTGCamoNet;
import techguns.blocks.BlockTGCamoNetTop;
import techguns.blocks.BlockTGDoor2x1;
import techguns.blocks.BlockTGDoor3x3;
import techguns.blocks.BlockTGLadder;
import techguns.blocks.BlockTGLamp;
import techguns.blocks.BlockTGOre;
import techguns.blocks.BlockTGSandHard;
import techguns.blocks.BlockTGSlimy;
import techguns.blocks.BlockTGSlimyLadder;
import techguns.blocks.BlockTGStairs;
import techguns.blocks.EnumCamoNetType;
import techguns.blocks.EnumConcreteType;
import techguns.blocks.EnumDebugBlockType;
import techguns.blocks.EnumDoorType;
import techguns.blocks.EnumLadderType;
import techguns.blocks.EnumLampType;
import techguns.blocks.EnumLightblockType;
import techguns.blocks.EnumNetherMetalType;
import techguns.blocks.EnumOreClusterType;
import techguns.blocks.EnumOreType;
import techguns.blocks.EnumTGSandHardTypes;
import techguns.blocks.EnumTGSlimyType;
import techguns.blocks.GenericBlockMetaEnum;
import techguns.blocks.GenericBlockMetaEnumCamoChangeable;
import techguns.blocks.GenericBlockMetaEnumCamoChangeableLightlevel;
import techguns.blocks.IGenericBlock;
import techguns.blocks.TGMetalPanelType;
import techguns.blocks.machines.BasicMachine;
import techguns.blocks.machines.BlockExplosiveCharge;
import techguns.blocks.machines.BlockOreDrill;
import techguns.blocks.machines.EnumExplosiveChargeType;
import techguns.blocks.machines.EnumMachineType;
import techguns.blocks.machines.EnumMultiBlockMachineType;
import techguns.blocks.machines.EnumSimpleMachineType2;
import techguns.blocks.machines.MultiBlockMachine;
import techguns.blocks.machines.SimpleMachine;
import techguns.init.ITGInitializer;
import techguns.tools.BlockJsonCreator;

public class TGBlocks implements ITGInitializer{
	public static final ArrayList<IGenericBlock> BLOCKLIST = new ArrayList<>();
	
	//Machines
	public static BasicMachine<EnumMachineType> BASIC_MACHINE;
	
	public static SimpleMachine<EnumSimpleMachineType2> SIMPLE_MACHINE2;
	
	public static MultiBlockMachine<EnumMultiBlockMachineType> MULTIBLOCK_MACHINE;
	
	public static BlockTGOre TG_ORE;
	
	public static BlockBioblob BIOBLOB;
	
	public static BlockSandbags SANDBAGS;
	
	public static BlockTGLamp<EnumLampType> LAMP_0;
	
	public static GenericBlockMetaEnum<TGMetalPanelType> METAL_PANEL;
	
	public static GenericBlockMetaEnum<EnumNetherMetalType> NETHER_METAL;
		
	public static BlockTGLadder<EnumLadderType> LADDER_0;
	
	public static GenericBlockMetaEnum<EnumConcreteType> CONCRETE;
	
	public static BlockTGDoor3x3<EnumDoorType> DOOR3x3;
	
	public static BlockTGCamoNet CAMONET;
	public static BlockTGCamoNetTop CAMONET_TOP;
	
	public static BlockTGDoor2x1 BUNKER_DOOR;
	
	public static BlockTGStairs METAL_STAIRS;
	public static BlockTGStairs CONCRETE_STAIRS;
	
	public static GenericBlockMetaEnumCamoChangeable<EnumLightblockType> NEONLIGHT_BLOCK;
	
	public static BlockMilitaryCrate MILITARY_CRATE;
	
	public static BlockExplosiveCharge<EnumExplosiveChargeType> EXPLOSIVE_CHARGE;
	
	public static BlockTGSandHard SAND_HARD;
	
	public static BlockTGSlimy SLIMY_BLOCK;
	
	public static GenericBlockMetaEnum<EnumDebugBlockType> DEBUG_BLOCK;
	
	public static BlockTGSlimyLadder SLIMY_LADDER;
	
	public static BlockOreCluster<EnumOreClusterType> ORE_CLUSTER;
	
	public static BlockOreDrill ORE_DRILL_BLOCK;
	
	public void registerBlocks(RegistryEvent.Register<Block> event) {
		BLOCKLIST.forEach(b -> b.registerBlock(event));
	}
	
	public void registerItems(RegistryEvent.Register<Item> event) {
		BLOCKLIST.forEach(b -> event.getRegistry().register(b.createItemBlock()));
		
		OreDictionary.registerOre("oreCopper", TGBlocks.TG_ORE.getStackFor(EnumOreType.ORE_COPPER));
		OreDictionary.registerOre("oreTin", TGBlocks.TG_ORE.getStackFor(EnumOreType.ORE_TIN));
		OreDictionary.registerOre("oreLead", TGBlocks.TG_ORE.getStackFor(EnumOreType.ORE_LEAD));
		OreDictionary.registerOre("oreUranium", TGBlocks.TG_ORE.getStackFor(EnumOreType.ORE_URANIUM));
		OreDictionary.registerOre("oreTitaniumIron", TGBlocks.TG_ORE.getStackFor(EnumOreType.ORE_TITANIUM));
		OreDictionary.registerOre("oreIllmenite", TGBlocks.TG_ORE.getStackFor(EnumOreType.ORE_TITANIUM));
	}
	
	@SideOnly(Side.CLIENT)
	public static void initModels() {
		BLOCKLIST.forEach(b -> b.registerItemBlockModels());
	}
	
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		BASIC_MACHINE= new BasicMachine<EnumMachineType>("basicmachine",EnumMachineType.class);
		SIMPLE_MACHINE2 = new SimpleMachine<EnumSimpleMachineType2>("simplemachine2",EnumSimpleMachineType2.class);
		MULTIBLOCK_MACHINE = new MultiBlockMachine<EnumMultiBlockMachineType>("multiblockmachine", EnumMultiBlockMachineType.class);
		TG_ORE = new BlockTGOre("basicore");
		BIOBLOB= new BlockBioblob("bioblob");
		SANDBAGS = (BlockSandbags) new BlockSandbags("sandbags").setHardness(6.0f);
		LAMP_0 = (BlockTGLamp<EnumLampType>) new BlockTGLamp<EnumLampType>("lamp0", EnumLampType.class).setHardness(4.0f);
		METAL_PANEL = (GenericBlockMetaEnum) new GenericBlockMetaEnumCamoChangeable<TGMetalPanelType>("metalpanel", Material.IRON, Material.IRON.getMaterialMapColor(), SoundType.METAL, TGMetalPanelType.class).setHardness(8.0f);
		NETHER_METAL = (GenericBlockMetaEnum) new GenericBlockMetaEnumCamoChangeableLightlevel<EnumNetherMetalType>("nethermetal", Material.IRON, Material.IRON.getMaterialMapColor(), SoundType.METAL, EnumNetherMetalType.class).setHardness(8.0f);
		
		CONCRETE = (GenericBlockMetaEnum<EnumConcreteType>) new GenericBlockMetaEnumCamoChangeable<EnumConcreteType>("concrete", Material.ROCK, EnumConcreteType.class).setHardness(8.0f);
		LADDER_0 = (BlockTGLadder<EnumLadderType>) new BlockTGLadder<EnumLadderType>("ladder0", EnumLadderType.class).setHardness(6.0f);
		DOOR3x3 = (BlockTGDoor3x3<EnumDoorType>) new BlockTGDoor3x3<EnumDoorType>("door3x3", EnumDoorType.class, TGItems.DOOR3x3).setHardness(6.0f);
		CAMONET = new BlockTGCamoNet("camonet");
		CAMONET_TOP = new BlockTGCamoNetTop("camonet_top");
		BUNKER_DOOR = (BlockTGDoor2x1) new BlockTGDoor2x1("bunkerdoor",TGItems.BUNKER_DOOR).setHardness(8.0f);
		
		METAL_STAIRS = (BlockTGStairs) new BlockTGStairs("stairs_metal", Material.IRON, SoundType.METAL).setHardness(8.0f);
		CONCRETE_STAIRS = (BlockTGStairs) new BlockTGStairs("stairs_concrete", Material.ROCK, SoundType.STONE).setHardness(6.0f);
		
		NEONLIGHT_BLOCK = (GenericBlockMetaEnumCamoChangeable<EnumLightblockType>) new GenericBlockMetaEnumCamoChangeable<EnumLightblockType>("neonlights", Material.GLASS, MapColor.YELLOW, SoundType.GLASS, EnumLightblockType.class).setLightLevel(1f).setHardness(4.0f);
		
		MILITARY_CRATE = (BlockMilitaryCrate) new BlockMilitaryCrate("military_crate", Material.WOOD).setHardness(4.0f);
		
		EXPLOSIVE_CHARGE = new BlockExplosiveCharge<EnumExplosiveChargeType>("explosive_charge", EnumExplosiveChargeType.class);
		
		SAND_HARD = new BlockTGSandHard("sand_hard", EnumTGSandHardTypes.class);
		
		SLIMY_BLOCK = new BlockTGSlimy("slimy", EnumTGSlimyType.class);
		SLIMY_LADDER = new BlockTGSlimyLadder("slimyladder");
		
		ORE_CLUSTER= new BlockOreCluster<EnumOreClusterType>("orecluster", Material.ROCK, EnumOreClusterType.class);
		
		ORE_DRILL_BLOCK = new BlockOreDrill("oredrill");
		
		//if (TGConfig.debug) {
		DEBUG_BLOCK = new BlockDebugMarker("debugblock", Material.GROUND);
		//}
		
		if(TGItems.WRITE_ITEM_JSON && event.getSide()==Side.CLIENT){
			BLOCKLIST.stream().filter(new Predicate<IGenericBlock>() {
				@Override
				public boolean test(IGenericBlock t) {
					if(t instanceof GenericBlockMetaEnum) {
						return ((GenericBlockMetaEnum)t).shouldAutoGenerateJsonForEnum();
					}
					return false;
				}
			}).forEach(b -> BlockJsonCreator.writeBlockstateJsonFileForBlock((GenericBlockMetaEnum)b));			
		}	
	}

	@Override
	public void init(FMLInitializationEvent event) {

	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {

	}


}
