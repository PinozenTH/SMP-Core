package io.github.pinont.smp.Shop;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import static io.github.pinont.smp.Core.shopName;

public class ShopHandler {

    @EventHandler
    public void getClickItem(InventoryClickEvent e) {
        if (e.getView().getOriginalTitle().equals(shopName)) {
            Player p = (Player) e.getWhoClicked();
            if (e.getCurrentItem() == null) {
                return;
            }
            if (e.getCurrentItem().getType() == Material.AIR) {
                return;
            }
            if (e.getCurrentItem().getItemMeta() == null) {
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName() == null) {
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Buy")) {
                e.setCancelled(true);
                p.sendMessage(ChatColor.GREEN + "You bought " + e.getCurrentItem().getItemMeta().getLore().get(0));
                p.getInventory().addItem(e.getCurrentItem());
                p.updateInventory();
            }
        }
    }

    public static void setShopUI(Player player) {
       Inventory inventory = player.getServer().createInventory(null, 9, shopName);
    }
}
