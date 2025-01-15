package name.lhm_mod.entity;

import name.lhm_mod.LhmMod;
import name.lhm_mod.entity.custom.LhmEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities{

    public static final EntityType<LhmEntity> Lhm = Registry.register(Registries.ENTITY_TYPE,
        Identifier.of(LhmMod.MOD_ID,"lhm"),
        EntityType.Builder.create(LhmEntity::new,SpawnGroup.CREATURE)
                .setDimensions(1f,2f).build("lhm"));

    public static void registerModEntities(){
        LhmMod.LOGGER.info("Registering Mod Entities for"+LhmMod.MOD_ID);
    }
}
