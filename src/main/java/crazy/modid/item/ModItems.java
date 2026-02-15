package crazy.modid.item;

import crazy.modid.CrazyMC;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;


import java.util.function.Function;

public class ModItems {
    public static final TagKey<Item> REPAIRS_GUIDITE_ARMOR = TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(CrazyMC.MOD_ID,"repair_guidite_armor"));
public static final ToolMaterial SWORD_MOLD = new ToolMaterial(
        BlockTags.INCORRECT_FOR_COPPER_TOOL,
        4,
        12f,
        300.0f,
        1,
        ModItems.REPAIRS_GUIDITE_ARMOR
);

public static final Item GUIDITE_SWORD = register("guidite_sword", Item::new, new Item.Properties().sword(SWORD_MOLD,12f,-3.6f));


    public static final Item BOB=register("bob", Item::new, new Item.Properties());

    public static final Item OP_SWORD=register("op_sword",Item::new,new Item.Properties());

    public static <GenericItem extends Item> GenericItem register(String name, Function<Item.Properties, GenericItem> itemFactory, Item.Properties settings){


        ResourceKey<Item> itemKey=ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(CrazyMC.MOD_ID, name));

        GenericItem item = itemFactory.apply(settings.setId(itemKey));

        Registry.register(BuiltInRegistries.ITEM, itemKey,item);

        return item;
    }

    public static void initialize() {

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT)
                .register((itemGroup)-> itemGroup.accept(ModItems.BOB));

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT)
                        .register((itemGroup)->itemGroup.accept(ModItems.OP_SWORD));

        ItemGroupEvents.modifyEntriesEvent((CreativeModeTabs.COMBAT))
                        .register((itemGroup)-> itemGroup.accept(ModItems.GUIDITE_SWORD));


        FuelRegistryEvents.BUILD.register((builder, context) -> {
            builder.add(ModItems.BOB,120*20);
        });
    }

}
