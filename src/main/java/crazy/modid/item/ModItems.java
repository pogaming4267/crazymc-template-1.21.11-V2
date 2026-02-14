package crazy.modid.item;

import crazy.modid.CrazyMC;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public class ModItems {
    public static final Item BOB=register("bob", Item::new, new Item.Properties());
    public static <GenericItem extends Item> GenericItem register(String name, Function<Item.Properties, GenericItem> itemFactory, Item.Properties settings){
        ResourceKey<Item> itemKey=ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(CrazyMC.MOD_ID, name));
        GenericItem item = itemFactory.apply(settings.setId(itemKey));
        Registry.register(BuiltInRegistries.ITEM, itemKey,item);
        return item;
    }
}
