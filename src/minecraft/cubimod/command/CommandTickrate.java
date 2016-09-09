package cubimod.command;

import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import cubimod.Cubitick;

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
    
	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException 
	{
		processCommand(sender, args);
	}

    public void processCommand(ICommandSender sender, String[] args) throws CommandException
    {
        if(args.length < 1) {
        	notifyCommandListener(sender, this, "Tickrate is " + Cubitick.tickrateWorld + " ticks per second");
            return;
        } else {
            float tickspeed = (float)parseDouble(args[0], 0);
            if(tickspeed >= 0) {
                Cubitick.setTickWorld(tickspeed);
                notifyCommandListener(sender, this, "Tickrate set to " + tickspeed);
            } else {
            	notifyCommandListener(sender, this, "Tickrate should be a non-negative floating point number");
                return;
            }
        }
    }

    public boolean isUsernameIndex(String[] args, int index)
    {
        return index == 0;
    }
}

