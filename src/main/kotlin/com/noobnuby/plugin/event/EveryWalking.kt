package com.noobnuby.plugin.event

import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerMoveEvent
import java.util.*


class EveryWalking : Listener {
    val blocks: MutableList<Material> = ArrayList()

    init {
        for (block in Material.entries) {
            if (block.isBlock) {
                blocks.add(block)
            }
        }
    }

    @EventHandler
    fun onPlayerMove(e: PlayerMoveEvent) {
        val p = e.player

        val pos = p.location.subtract(0.0, 1.0, 0.0)

        if (pos.isBlock != e.hasChangedBlock()) {
            if (!pos.block.isEmpty) {
                val randomBlock = blocks[Random().nextInt(blocks.size)]
                pos.block.type = randomBlock
            }
        }
    }
}