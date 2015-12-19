package cubimod.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cubimod.PacketAnalysis;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.BlockPos;

public class CommandShowPacket extends CommandBase
{
    public static final String[] packetNameServer = 
    {
        "S00PacketKeepAlive",
        "S01PacketJoinGame",
        "S02PacketChat",
        "S03PacketTimeUpdate",
        "S04PacketEntityEquipment",
        "S05PacketSpawnPosition",
        "S06PacketUpdateHealth",
        "S07PacketRespawn",
        "S08PacketPlayerPosLook",
        "S09PacketHeldItemChange",
        "S0APacketUseBed",
        "S0BPacketAnimation",
        "S0CPacketSpawnPlayer",
        "S0DPacketCollectItem",
        "S0EPacketSpawnObject",
        "S0FPacketSpawnMob",
        "S10PacketSpawnPainting",
        "S11PacketSpawnExperienceOrb",
        "S12PacketEntityVelocity",
        "S13PacketDestroyEntities",
        "S14PacketEntity",
        null,
        null,
        null,
        "S18PacketEntityTeleport",
        "S19PacketEntityHeadLook",
        "S19PacketEntityStatus",
        "S1BPacketEntityAttach",
        "S1CPacketEntityMetadata",
        "S1DPacketEntityEffect",
        "S1EPacketRemoveEntityEffect",
        "S1FPacketSetExperience",
        "S20PacketEntityProperties",
        "S21PacketChunkData",
        "S22PacketMultiBlockChange",
        "S23PacketBlockChange",
        "S24PacketBlockAction",
        "S25PacketBlockBreakAnim",
        "S26PacketMapChunkBulk",
        "S27PacketExplosion",
        "S28PacketEffect",
        "S29PacketSoundEffect",
        "S2APacketParticles",
        "S2BPacketChangeGameState",
        "S2CPacketSpawnGlobalEntity",
        "S2DPacketOpenWindow",
        "S2EPacketCloseWindow",
        "S2FPacketSetSlot",
        "S30PacketWindowItems",
        "S31PacketWindowProperty",
        "S32PacketConfirmTransaction",
        "S33PacketUpdateSign",
        "S34PacketMaps",
        "S35PacketUpdateTileEntity",
        "S36PacketSignEditorOpen",
        "S37PacketStatistics",
        "S38PacketPlayerListItem",
        "S39PacketPlayerAbilities",
        "S3APacketTabComplete",
        "S3BPacketScoreboardObjective",
        "S3CPacketUpdateScore",
        "S3DPacketDisplayScoreboard",
        "S3EPacketTeams",
        "S3FPacketCustomPayload",
        "S40PacketDisconnect",
        "S41PacketServerDifficulty",
        "S42PacketCombatEvent",
        "S43PacketCamera",
        "S44PacketWorldBorder",
        "S45PacketTitle",
        "S46PacketSetCompressionLevel",
        "S47PacketPlayerListHeaderFooter",
        "S48PacketResourcePackSend",
        "S49PacketUpdateEntityNBT"
    };
    
    
    public String getCommandName()
    {
        return "showpacket";
    }

    public int getRequiredPermissionLevel()
    {
        return 0;
    }

    public String getCommandUsage(ICommandSender sender)
    {
        return "/showpacket [PACKET_TYPE] [true/false]";
    }

    public void processCommand(ICommandSender sender, String[] args) throws CommandException
    {
        if(args.length <= 0) {
            notifyOperators(sender, this,
                    "§eThe following packets are currently supported for analysis:\n" +
                    "§fS03PacketTimeUpdate: §7update world time\n" +
                    "§fS06PacketUpdateHealth: §7update health, food and saturation\n" +
                    "§fS0FPacketSpawnMob: §7spawning/loading entity\n" +
                    "§fS21PacketChunkData: §7send 64 or more block changes in a chunk\n" +
                    "§fS22PacketMultiBlockChange: §72-63 block changes in chunk\n" +
                    "§fS23PacketBlockChange: §7a single block change\n" +
                    "§fS24PacketBlockAction: §7triggers onBlockEventReceived()\n" +
                    "§fS26PacketMapChunkBulk: §7chunk loading (block content will not be displayed here)"
                    );
        } else {
            int type = Arrays.asList(packetNameServer).indexOf(args[0]);
            if(type >= 0 && args[0] != ""){
                if(args.length >= 2 && args[1].equals("true")) {
                    PacketAnalysis.packetS[type] = true;
                    notifyOperators(sender, this, args[0] + " analysis mode §aactivated");
                } else if (args.length >= 2 && args[1].equals("false")) {
                    PacketAnalysis.packetS[type] = false;
                    notifyOperators(sender, this, args[0] + " analysis mode §cdeactivated");
                } else {
                    notifyOperators(sender, this, "Analysis mode for "+args[0]+" is currently "+(PacketAnalysis.packetS[type]?"§aactive":"§cinactive"));
                }
            } else {
                notifyOperators(sender, this, "§cUsage:\n§c" + getCommandUsage(sender));
            }
        }
    }

    public List addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos)
    {
        if(args.length == 1){
            return getListOfStringsMatchingLastWord(args, new String[] {
                    "S03PacketTimeUpdate",
                    "S06PacketUpdateHealth",
                    "S0FPacketSpawnMob",
                    "S21PacketChunkData", 
                    "S22PacketMultiBlockChange", 
                    "S23PacketBlockChange",
                    "S24PacketBlockAction",
                    "S26PacketMapChunkBulk"
                    });
        }
        else if (args.length == 2){
            return getListOfStringsMatchingLastWord(args, new String[] {"true", "false"});
        }
        else return null;
    }
    
    public boolean isUsernameIndex(String[] args, int index)
    {
        return index == 0;
    }
}
