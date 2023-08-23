package io.github.pinont.smp.Utils;

import org.bukkit.block.Block;
import org.bukkit.entity.Item;

public class AirCheck {

    public static Boolean Fix(Block block) {
        return block.isEmpty() || block.getType().isAir();
    }

    public static Boolean Fix(Item item) {
        return item.isEmpty() || item.getItemStack().getType().isAir();
    }

}
