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

public class CommandTickrate extends CommandBase
{
    public String getCommandName()
    {
        return "tickrate";
    }
    
    public int getRequiredPermissionLevel()
    {
        return 2;
    }

    public String getCommandUsage(ICommandSender sender)
    {
        return "/tickrate [rate]";
    }

    public void processCommand(ICommandSender sender, String[] args) throws CommandException
    {
    	if(args.length < 1) {
    		notifyOperators(sender, this, "Tickrate is " + Cubitick.tickrateWorld + " ticks per second");
    		return;
    	} else {
    		float tickspeed = (float)parseDouble(args[0], 0);
    		if(tickspeed >= 0) {
    			Cubitick.setTickWorld(tickspeed);
    			notifyOperators(sender, this, "Tickrate set to " + tickspeed);
    		} else {
    			notifyOperators(sender, this, "Tickrate should be a non-negative floating point number");
    			return;
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

