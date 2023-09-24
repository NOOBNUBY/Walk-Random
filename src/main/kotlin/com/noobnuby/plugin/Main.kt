package com.noobnuby.plugin

import com.noobnuby.plugin.event.EveryWalking
import org.bukkit.plugin.java.JavaPlugin

class Main: JavaPlugin() {
    override fun onEnable() {
        logger.info("Enable Plugin!")
        server.pluginManager.registerEvents(EveryWalking(), this)
    }
}