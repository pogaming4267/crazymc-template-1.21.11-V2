package crazy.modid;

import crazy.modid.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.CreativeModeTabs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CrazyMC implements ModInitializer {
	public static final String MOD_ID = "crazymc";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static void initialize(){
			ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT)
				.register((itemGroup)-> itemGroup.accept(ModItems.BOB));
	}
	@Override
	public void onInitialize() {

		LOGGER.info("Hello Fabric world!");
	}
}