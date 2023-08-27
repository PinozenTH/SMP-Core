package io.github.pinont.smp.Cosmetic;

import io.github.pinont.smp.Utils.LoreUtils;
import io.github.pinont.smp.Utils.Msg;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.tags.CustomItemTagContainer;
import org.bukkit.inventory.meta.tags.ItemTagType;
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
        if (player.isSprinting()) {
            if (Optional.ofNullable(player.getInventory().getBoots().getItemMeta().getCustomTagContainer().hasCustomTag(new NamespacedKey(plugin, "sparking"), ItemTagType.BYTE)).get()) {
                player.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, player.getLocation().add(0, 0.1, 0), 1, 0, 0, 0, 0);
            }
        }

    }

    private static void leatherRecipe() {
        NamespacedKey key = new NamespacedKey(plugin, "leather_boots");

        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
        ItemMeta bootsMeta = boots.getItemMeta();
        CustomItemTagContainer bootsTag = bootsMeta.getCustomTagContainer();
        bootsTag.setCustomTag(plugin.key("sparking"), ItemTagType.BYTE, (byte) 1);
        boots.setItemMeta(bootsMeta);
        LoreUtils.addLore(boots, ChatColor.YELLOW + "Sparking");
        ShapedRecipe shaped = new ShapedRecipe(key, boots);
        shaped.shape("111", "121", "111");
        shaped.setIngredient('1', Material.FIREWORK_ROCKET);
        shaped.setIngredient('2', Material.LEATHER_BOOTS);
        shaped.setCategory(CraftingBookCategory.EQUIPMENT);
        plugin.getServer().addRecipe(shaped);
    }

    private static void chainmailRecipe() {
        NamespacedKey key = new NamespacedKey(plugin, "chainmail_boots");

        ItemStack boots = new ItemStack(Material.CHAINMAIL_BOOTS);
        ItemMeta bootsMeta = boots.getItemMeta();
        CustomItemTagContainer bootsTag = bootsMeta.getCustomTagContainer();
        bootsTag.setCustomTag(plugin.key("sparking"), ItemTagType.BYTE, (byte) 1);
        boots.setItemMeta(bootsMeta);
        LoreUtils.addLore(boots, ChatColor.YELLOW + "Sparking");
        ShapedRecipe shaped = new ShapedRecipe(key, boots);
        shaped.shape("111", "121", "111");
        shaped.setIngredient('1', Material.FIREWORK_ROCKET);
        shaped.setIngredient('2', Material.LEATHER_BOOTS);
        shaped.setCategory(CraftingBookCategory.EQUIPMENT);
        plugin.getServer().addRecipe(shaped);
    }

    private static void ironRecipe() {
        NamespacedKey key = new NamespacedKey(plugin, "iron_boots");

        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
        ItemMeta bootsMeta = boots.getItemMeta();
        CustomItemTagContainer bootsTag = bootsMeta.getCustomTagContainer();
        bootsTag.setCustomTag(plugin.key("sparking"), ItemTagType.BYTE, (byte) 1);
        boots.setItemMeta(bootsMeta);
        LoreUtils.addLore(boots, ChatColor.YELLOW + "Sparking");
        ShapedRecipe shaped = new ShapedRecipe(key, boots);
        shaped.shape("111", "121", "111");
        shaped.setIngredient('1', Material.FIREWORK_ROCKET);
        shaped.setIngredient('2', Material.LEATHER_BOOTS);
        shaped.setCategory(CraftingBookCategory.EQUIPMENT);
        plugin.getServer().addRecipe(shaped);
    }

    private static void goldRecipe() {
        NamespacedKey key = new NamespacedKey(plugin, "gold_boots");

        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
        ItemMeta bootsMeta = boots.getItemMeta();
        CustomItemTagContainer bootsTag = bootsMeta.getCustomTagContainer();
        bootsTag.setCustomTag(plugin.key("sparking"), ItemTagType.BYTE, (byte) 1);
        boots.setItemMeta(bootsMeta);
        LoreUtils.addLore(boots, ChatColor.YELLOW + "Sparking");
        ShapedRecipe shaped = new ShapedRecipe(key, boots);
        shaped.shape("111", "121", "111");
        shaped.setIngredient('1', Material.FIREWORK_ROCKET);
        shaped.setIngredient('2', Material.LEATHER_BOOTS);
        shaped.setCategory(CraftingBookCategory.EQUIPMENT);
        plugin.getServer().addRecipe(shaped);
    }

    private static void diamondRecipe() {
        NamespacedKey key = new NamespacedKey(plugin, "diamond_boots");

        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
        ItemMeta bootsMeta = boots.getItemMeta();
        CustomItemTagContainer bootsTag = bootsMeta.getCustomTagContainer();
        bootsTag.setCustomTag(plugin.key("sparking"), ItemTagType.BYTE, (byte) 1);
        boots.setItemMeta(bootsMeta);
        LoreUtils.addLore(boots, ChatColor.YELLOW + "Sparking");
        ShapedRecipe shaped = new ShapedRecipe(key, boots);
        shaped.shape("111", "121", "111");
        shaped.setIngredient('1', Material.FIREWORK_ROCKET);
        shaped.setIngredient('2', Material.LEATHER_BOOTS);
        shaped.setCategory(CraftingBookCategory.EQUIPMENT);
        plugin.getServer().addRecipe(shaped);
    }

    private static void netheriteRecipe() {
        NamespacedKey key = new NamespacedKey(plugin, "netherite_boots");

        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
        ItemMeta bootsMeta = boots.getItemMeta();
        CustomItemTagContainer bootsTag = bootsMeta.getCustomTagContainer();
        bootsTag.setCustomTag(plugin.key("sparking"), ItemTagType.BYTE, (byte) 1);
        boots.setItemMeta(bootsMeta);
        LoreUtils.addLore(boots, ChatColor.YELLOW + "Sparking");
        ShapedRecipe shaped = new ShapedRecipe(key, boots);
        shaped.shape("111", "121", "111");
        shaped.setIngredient('1', Material.FIREWORK_ROCKET);
        shaped.setIngredient('2', Material.LEATHER_BOOTS);
        shaped.setCategory(CraftingBookCategory.EQUIPMENT);
        plugin.getServer().addRecipe(shaped);
    }

    public static void Recipe() {
        leatherRecipe();
        chainmailRecipe();
        ironRecipe();
        goldRecipe();
        diamondRecipe();
        netheriteRecipe();
    }
}
