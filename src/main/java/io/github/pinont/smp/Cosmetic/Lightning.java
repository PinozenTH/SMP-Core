package io.github.pinont.smp.Cosmetic;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.meta.tags.ItemTagType;

import static io.github.pinont.smp.Core.plugin;

public class Lightning {
    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        if (event.getEntity().getKiller() instanceof Player) {
            Player player = event.getEntity().getKiller();
            if (player.getInventory().getItemInMainHand().getItemMeta().getCustomTagContainer().hasCustomTag(plugin.key("lightning"), ItemTagType.BYTE)) {
                entity.getWorld().strikeLightning(entity.getLocation());
            }
        }

    }
}
