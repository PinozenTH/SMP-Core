package io.github.pinont.smp.Cosmetic;

import io.github.pinont.smp.Utils.LoreUtils;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.recipe.CraftingBookCategory;
import org.bukkit.scheduler.BukkitScheduler;

import java.awt.*;
import java.util.Optional;

import static io.github.pinont.smp.Core.plugin;

public class Sparking implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {

        Player player = event.getPlayer();
        if (Optional.ofNullable(player.getInventory().getBoots()).isEmpty()) return;
        if (!player.getInventory().getBoots().getType().isAir() && !(player.getInventory().getBoots().getItemMeta().lore() == null)) {
            if (player.getInventory().getBoots().getItemMeta().lore().contains("Sparking")) {
                BukkitScheduler scheduler = player.getServer().getScheduler();
                scheduler.scheduleSyncRepeatingTask(plugin, new Runnable() {
                    @Override
                    public void run() {
                        player.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, player.getLocation().add(0, 0.5, 0), 1, 0, 0, 0, 0);
                    }
                }, 5L, 5L);
            }
        }

    }

    public static void Recipe() {
        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
        LoreUtils.addLore(boots, ChatColor.YELLOW + "Sparking");
        ShapedRecipe shaped = new ShapedRecipe(boots);
        shaped.shape("111", "121", "111");
        shaped.setIngredient('1', Material.FIREWORK_ROCKET);
        shaped.setIngredient('2', Material.LEATHER_BOOTS);
        shaped.setCategory(CraftingBookCategory.EQUIPMENT);
        plugin.getServer().addRecipe(shaped);
    }
}
