package cubimod.command;

import java.util.List;

import cubimod.Cubitick;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.CommandResultStats;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.GameRules;

public class CommandTickSync extends CommandBase
{
    public String getCommandName()
    {
        return "ticksync";
    }

    public int getRequiredPermissionLevel()
    {
        return 2;
    }

    public String getCommandUsage(ICommandSender sender)
    {
        return "/ticksync [true/false]";
    }

    public void processCommand(ICommandSender sender, String[] args) throws CommandException
    {
    	if(args.length < 1) {
    		notifyOperators(sender, this, (Cubitick.synctick) ? "Tickrate is currently synchronised" : "Tickrate is currently desynchronised");
    		return;
    	} else {
    		if(args[0].equals("true") || args[0].equals("on")) {
    			Cubitick.synctick = true;
    			notifyOperators(sender, this, "Tickrate is now synchronised");
    		} else if(args[0].equals("false") || args[0].equals("off")) {
    			Cubitick.synctick = false;
    			notifyOperators(sender, this, "Tickrate is now desynchronised");
    		} else {
    			notifyOperators(sender, this, "Tickrate synchronisation can only be true/on or false/off");
    		}
    	}
    }

    public List addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos)
    {
        return null;
    }

    public boolean isUsernameIndex(String[] args, int index)
    {
        return index == 0;
    }
}
