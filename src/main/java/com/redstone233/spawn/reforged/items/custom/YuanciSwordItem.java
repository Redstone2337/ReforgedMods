package com.redstone233.spawn.reforged.items.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.EvokerFangsEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class YuanciSwordItem extends SwordItem {

    public YuanciSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
       if (attacker instanceof PlayerEntity) {
            World world = attacker.getWorld();
            BlockPos pos = attacker.getBlockPos();
            for (int i = 0; i < 10; i++) {
                double x = pos.getX() + world.random.nextDouble();
                double y = pos.getY() + world.random.nextDouble();
                double z = pos.getZ() + world.random.nextDouble();
                EvokerFangsEntity entity = new EvokerFangsEntity(world, x, y, z, 0, 0, attacker);
                world.addParticle(ParticleTypes.FLAME, false, x, y, z, 0.0, 0.0, 0.0);
                world.spawnEntity(entity);
            }
        }
        return true;
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (user instanceof PlayerEntity) {
            entity.kill();
        }
        return ActionResult.SUCCESS;
    }

}
