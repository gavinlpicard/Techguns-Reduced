package techguns.server;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import techguns.CommonProxy;
import techguns.events.TechgunsGuiHandler.GuiHandlerRegister;
import techguns.gui.containers.AmmoPressContainer;
import techguns.gui.containers.UpgradeBenchContainer;
import techguns.gui.containers.ChemLabContainer;
import techguns.gui.containers.Door3x3Container;
import techguns.gui.containers.ExplosiveChargeContainer;
import techguns.gui.containers.FabricatorContainer;
import techguns.gui.containers.GrinderContainer;
import techguns.gui.containers.MetalPressContainer;
import techguns.gui.containers.OreDrillContainer;
import techguns.gui.containers.ReactionChamberContainer;
import techguns.gui.containers.TurretContainer;
import techguns.tileentities.AmmoPressTileEnt;
import techguns.tileentities.UpgradeBenchTileEnt;
import techguns.tileentities.ChemLabTileEnt;
import techguns.tileentities.Door3x3TileEntity;
import techguns.tileentities.ExplosiveChargeAdvTileEnt;
import techguns.tileentities.ExplosiveChargeTileEnt;
import techguns.tileentities.FabricatorTileEntMaster;
import techguns.tileentities.GrinderTileEnt;
import techguns.tileentities.MetalPressTileEnt;
import techguns.tileentities.OreDrillTileEntMaster;
import techguns.tileentities.ReactionChamberTileEntMaster;
import techguns.tileentities.TurretTileEnt;

@Mod.EventBusSubscriber(Side.SERVER)
public class ServerProxy extends CommonProxy {

	protected GuiHandlerRegister guihandler = new GuiHandlerRegister();
	
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
		guihandler.<AmmoPressTileEnt>addEntry(AmmoPressTileEnt.class, AmmoPressContainer::new);
		guihandler.<MetalPressTileEnt>addEntry(MetalPressTileEnt.class, MetalPressContainer::new);
		guihandler.<ChemLabTileEnt>addEntry(ChemLabTileEnt.class, ChemLabContainer::new);
		guihandler.<TurretTileEnt>addEntry(TurretTileEnt.class, TurretContainer::new);
		guihandler.<FabricatorTileEntMaster>addEntry(FabricatorTileEntMaster.class, FabricatorContainer::new);
		guihandler.<ReactionChamberTileEntMaster>addEntry(ReactionChamberTileEntMaster.class, ReactionChamberContainer::new);
		guihandler.<Door3x3TileEntity>addEntry(Door3x3TileEntity.class, Door3x3Container::new);
		guihandler.<ExplosiveChargeTileEnt>addEntry(ExplosiveChargeTileEnt.class, ExplosiveChargeContainer<ExplosiveChargeTileEnt>::new);
		guihandler.<ExplosiveChargeAdvTileEnt>addEntry(ExplosiveChargeAdvTileEnt.class, ExplosiveChargeContainer<ExplosiveChargeAdvTileEnt>::new);
		guihandler.<OreDrillTileEntMaster>addEntry(OreDrillTileEntMaster.class, OreDrillContainer::new);
		guihandler.<GrinderTileEnt>addEntry(GrinderTileEnt.class, GrinderContainer::new);
		guihandler.<UpgradeBenchTileEnt>addEntry(UpgradeBenchTileEnt.class, UpgradeBenchContainer::new);
	}
	
	@Override
	public GuiHandlerRegister getGuihandlers() {
		return guihandler;
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}

	
	
}
