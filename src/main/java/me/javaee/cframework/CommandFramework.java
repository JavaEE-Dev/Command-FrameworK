package me.javaee.cframework;

import lombok.Getter;
import me.javaee.cframework.command.ACommand;
import me.javaee.cframework.command.example.ExampleCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.craftbukkit.v1_7_R4.CraftServer;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

/*
 * Copyright (c) 2017, Álvaro Mariano. All rights reserved.
 *
 * Do not redistribute without permission from the author.
 */
public class CommandFramework extends JavaPlugin {
    @Getter private CommandFramework instance;
    @Getter private List<ACommand> commands;
    @Getter private CommandMap commandMap;

    @Override
    public void onEnable() {
        instance = this;

        //Always follow this order
        setCommands();
        addCommands();
        postCommands();
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    private void setCommands() {
        commands = new LinkedList<>();

        try {
            if (Bukkit.getServer() instanceof CraftServer) {
                final Field field = CraftServer.class.getDeclaredField("commandMap");
                //Sets the field accessible as it is private
                field.setAccessible(true);
                commandMap = (CommandMap) field.get(Bukkit.getServer());
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private void postCommands() {
        //Register the commands
        for (ACommand command : commands) {
            commandMap.register(command.getCommand(), command);
        }
    }

    private void addCommands() {
        //Add your commands
        commands.add(new ExampleCommand());
    }
}
