package com.noobnuby.plugin.event

import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerMoveEvent
import java.util.*


class EveryWalking : Listener {
    val blocks: MutableList<Material> = ArrayList()

    @EventHandler
    fun onPlayerMove(e: PlayerMoveEvent) {
        val p = e.player

        for (block in Material.entries) {
            if (block.isBlock) {
                blocks.add(block)
            }
        }

        val x = p.location.x
        val y = p.location.y
        val z = p.location.z

        if (isIntegerCoordinate(x) || isIntegerCoordinate(y) || isIntegerCoordinate(z)) {
            if (e.getFrom().getX() != e.getTo().getX() || e.getFrom().getY() != e.getTo().getY() || e.getFrom().getZ() != e.getTo().getZ()) {
                val pos = p.getLocation().subtract(0.0, 1.0, 0.0).block
                if (!pos.isEmpty) {
                    val randomBlock = blocks[Random().nextInt(blocks.size)]
                    pos.setType(randomBlock)
                }
            }
        }
    }

    private fun isIntegerCoordinate(coordinate: Double): Boolean {
        return coordinate == coordinate.toInt().toDouble()
    }
}