package crazy.modid.enchantment.effect;

import com.mojang.serialization.MapCodec;
import crazy.modid.CrazyMC;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;

import static net.minecraft.core.Registry.register;

public class ModEnchantmentEffects {
    public static MapCodec<LightningEnchantmentEffect> LIGHTNING_EFFECT = register("lightning_effect", LightningEnchantmentEffect.CODEC);
    public static <T extends EnchantmentEntityEffect> MapCodec<T> register(String id, MapCodec<T> codec){
     return Registry.register(BuiltInRegistries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.fromNamespaceAndPath(CrazyMC.MOD_ID, id),codec);
    }
    public static void registerModEnchantmentEffect(){
        CrazyMC.LOGGER.info("Registering for " + CrazyMC.MOD_ID);
        LIGHTNING_EFFECT.toString();
    }
}
