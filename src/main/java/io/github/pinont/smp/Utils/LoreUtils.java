package io.github.pinont.smp.Utils;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class LoreUtils {

    public static void addLore(ItemStack item, String lore) {
        ArrayList<String> loreList = new ArrayList<>();
        loreList.add(lore);
        ItemMeta meta = item.getItemMeta();
        meta.setLore(loreList);
        item.setItemMeta(meta);
    }

    public static void removeLore(ItemStack item, String lore) {
        ItemMeta meta = item.getItemMeta();
        for (String line : meta.getLore()) {
            if (line.equals(lore)) {
                int index = meta.getLore().indexOf(line);
                meta.getLore().remove(index);
                item.setItemMeta(meta);
            }
        }
    }
}
