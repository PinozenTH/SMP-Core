package io.github.pinont.smp.Events;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.metadata.FixedMetadataValue;

import static io.github.pinont.smp.Core.plugin;

public class PlaceBlock implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        block.setMetadata("placed", new FixedMetadataValue(plugin, true));
        block.setMetadata("placedByPlayer", new FixedMetadataValue(plugin, player.getUniqueId()));
    }

}
