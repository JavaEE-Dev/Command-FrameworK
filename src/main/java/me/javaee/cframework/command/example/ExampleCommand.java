package me.javaee.cframework.command.example;

import me.javaee.cframework.command.ACommand;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.Arrays;

/*
 * Copyright (c) 2017, Álvaro Mariano. All rights reserved.
 *
 * Do not redistribute without permission from the author.
 */
public class ExampleCommand extends ACommand {
    public ExampleCommand() {
        super("example", Arrays.asList("shit", "ass"), false, false);
    }

    @Override
    public void execute(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(ChatColor.RED + "Hello!");
    }
}
