package name.lhm_mod.registry;

import name.lhm_mod.LhmMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {

    public static final ItemGroup LHM_GROUP= Registry.register(Registries.ITEM_GROUP,
            Identifier.of(LhmMod.MOD_ID,"lhm_items"),
            FabricItemGroup.builder().icon(()->new ItemStack(ModItems.LHMBOYFRIEND))
                    .displayName(Text.translatable("itemgroup.lhm-mod.lhm"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.LHMBOYFRIEND);
                        entries.add(ModItems.LHM_SPAWN_EGG);
                    }).build()
            );

    public static void registerItemGroups(){
        LhmMod.LOGGER.info("Registering Item Groups for"+LhmMod.MOD_ID);
    }
}
