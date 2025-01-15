package name.lhm_mod.registry;

import name.lhm_mod.LhmMod;
import name.lhm_mod.entity.ModEntities;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item LHMBOYFRIEND = registerItem("lhm_boyfriend", new Item(new Item.Settings().food(ModFoodComponents.LHMBOYFRIEND)),ItemGroups.FOOD_AND_DRINK);
    public static final Item LHM_SPAWN_EGG = registerItem("lhm_spawn_egg",new SpawnEggItem(ModEntities.Lhm,0xffec8b,0xff69b,new Item.Settings()),ItemGroups.SPAWN_EGGS);

    @SafeVarargs
    public static Item registerItem(String name, Item item, RegistryKey<ItemGroup>...itemGroups){
        Item registeredItem=Registry.register(Registries.ITEM,new Identifier(LhmMod.MOD_ID,name),item);
        for(RegistryKey<ItemGroup> itemGroup:itemGroups){
            ItemGroupEvents.modifyEntriesEvent(itemGroup).register(fabricItemGroupEntries -> {
                fabricItemGroupEntries.add(registeredItem);
            });
        }
        return registeredItem;
    }

    public static void registerModItems(){
        LhmMod.LOGGER.info("Registering mod items for"+LhmMod.MOD_ID);
    }
}
