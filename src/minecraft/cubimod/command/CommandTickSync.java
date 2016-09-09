package cubimod.command;

import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import cubimod.Cubitick;

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
    
	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException 
	{
		processCommand(sender, args);
	}
    
    public void processCommand(ICommandSender sender, String[] args) throws CommandException
    {
        if(args.length < 1) {
        	notifyCommandListener(sender, this, (Cubitick.synctick) ? "Tickrate is currently synchronised" : "Tickrate is currently desynchronised");
            return;
        } else {
            if(args[0].equals("true") || args[0].equals("on")) {
                Cubitick.synctick = true;
                notifyCommandListener(sender, this, "Tickrate is now synchronised");
            } else if(args[0].equals("false") || args[0].equals("off")) {
                Cubitick.synctick = false;
                notifyCommandListener(sender, this, "Tickrate is now desynchronised");
            } else {
            	notifyCommandListener(sender, this, "Tickrate synchronisation can only be true/on or false/off");
            }
        }
    }

    public boolean isUsernameIndex(String[] args, int index)
    {
        return index == 0;
    }
}
