package com.sakurarealm.recipecraft.command;

import com.sakurarealm.recipecraft.recipecraft.material.SimpleArmorTool;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Optional;

public class TestCommand implements CommandExecutor {

    public TestCommand() {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            SimpleArmorTool armorTool = SimpleArmorTool.TestSimpleArmorTool();
            Optional<ItemStack> itemStack = armorTool.toItemStack(armorTool);
            itemStack.ifPresent(stack -> ((Player) sender).getInventory().addItem(stack));
            sender.sendMessage("Give you a test item.");
        }
        return false;
    }

}
