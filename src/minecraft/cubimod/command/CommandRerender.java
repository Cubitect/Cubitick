package cubimod.command;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockProperties;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;

public class CommandRerender extends CommandBase
{
    public String getCommandName()
    {
        return "rerender";
    }

    public int getRequiredPermissionLevel()
    {
        return 0;
    }

    public String getCommandUsage(ICommandSender sender)
    {
        return "/rerender [fromX fromY fromZ toX toY toZ]\n§7Marks a region to be rendered again (without reloading)\n§7Specifying no arguments will also reload and do the same as F3+A";
    }

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException 
	{
		processCommand(sender, args);
	}
    
    public void processCommand(ICommandSender sender, String[] args) throws CommandException
    {
        if(args.length == 0) {
            Minecraft.getMinecraft().scheduledReload = true;
        }
        else if(args.length <= 5) {
        	notifyCommandListener(sender, this, "§cUsage:\n§c"+getCommandUsage(sender));
            return;
        } else {
        	BlockPos pos1 = parseBlockPos(sender, args, 0, false);
            BlockPos pos2 = parseBlockPos(sender, args, 3, false);
            
            BlockPos from = new BlockPos(Math.min(pos1.getX(), pos2.getX()), Math.min(pos1.getY(), pos2.getY()), Math.min(pos1.getZ(), pos2.getZ()));
            BlockPos to   = new BlockPos(Math.max(pos1.getX(), pos2.getX()), Math.max(pos1.getY(), pos2.getY()), Math.max(pos1.getZ(), pos2.getZ()));
            sender.getEntityWorld().markBlockRangeForRenderUpdate(from, to);
        }
    }

    public boolean isUsernameIndex(String[] args, int index)
    {
        return index == 0;
    }
}