package crazy.modid;

import crazy.modid.enchantment.effect.ModEnchantmentEffects;
import crazy.modid.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static crazy.modid.enchantment.effect.ModEnchantmentEffects.registerModEnchantmentEffect;


public class CrazyMC implements ModInitializer {
	public static final String MOD_ID = "crazymc";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.initialize();
		ModEnchantmentEffects.registerModEnchantmentEffect();



		LOGGER.info("Hello Fabric world!");
	}
}