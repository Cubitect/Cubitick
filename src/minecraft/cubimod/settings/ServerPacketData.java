package cubimod.settings;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockEnderChest;
import net.minecraft.block.BlockNote;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.BlockPistonExtension;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.event.HoverEvent;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.S20PacketEntityProperties;
import net.minecraft.network.play.server.S22PacketMultiBlockChange;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import cubimod.Cubitick;

public class ServerPacketData 
{
    public static final String configFileName = "packet_analysis.cfg";
    
    public static final String[] packetName = 
    {
        "S00 Keep Alive",
        "S01 Join Game",
        "S02 Chat Message",
        "S03 Time Update",
        "S04 Entity Equipment",
        "S05 Spawn Position",
        "S06 Update Health",
        "S07 Respawn",
        "S08 Player Position And Look",
        "S09 Held Item Change",
        "S0A Use Bed",
        "S0B Animation",
        "S0C Spawn Player",
        "S0D Collect Item",
        "S0E Spawn Object",
        "S0F Spawn Mob",
        "S10 Spawn Painting",
        "S11 Spawn Experience Orb",
        "S12 Entity Velocity",
        "S13 Destroy Entities",
        "S14 Entity",
        "S15 Entity Relative Move",
        "S16 Entity Look",
        "S17 Entity Look And Relative Move",
        "S18 Entity Teleport",
        "S19 Entity Head Look",
        "S1A Entity Status",
        "S1B Attach Entity",
        "S1C Entity Metadata",
        "S1D Entity Effect",
        "S1E Remove Entity Effect",
        "S1F Set Experience",
        "S20 Entity Properties",
        "S21 Chunk Data",
        "S22 Multi Block Change",
        "S23 Block Change",
        "S24 Block Action",
        "S25 Block Break Animation",
        "S26 Map Chunk Bulk",
        "S27 Explosion",
        "S28 Effect",
        "S29 Sound Effect",
        "S2A Particle",
        "S2B Change Game State",
        "S2C Spawn Global Entity",
        "S2D Open Window",
        "S2E Close Window",
        "S2F Set Slot",
        "S30 Window Items",
        "S31 Window Property",
        "S32 Confirm Transaction",
        "S33 Update Sign",
        "S34 Map",
        "S35 Update Block Entity",
        "S36 Open Sign Editor",
        "S37 Statistics",
        "S38 Player List Item",
        "S39 Player Abilities",
        "S3A Tab-Complete",
        "S3B Scoreboard Objective",
        "S3C Update Score",
        "S3D Display Scoreboard",
        "S3E Teams",
        "S3F Plugin Message",
        "S40 Disconnect",
        "S41 Server Difficulty",
        "S42 Combat Event",
        "S43 Camera",
        "S44 World Border",
        "S45 Title",
        "S46 Set Compression",
        "S47 Player List Header And Footer",
        "S48 Resource Pack Send",
        "S49 Update Entity NBT"
    };
    
    public static final String packetTip[] =
    {
        
    };
    
    
    public static boolean enabled = false;
    public static boolean isActive[] = new boolean[packetName.length];
    
    public static void init()
    {
        Arrays.fill(isActive, false);
        loadSettings();
    }
    
    public static void saveSettings()
    {
        Properties prop = new Properties();
        OutputStream output = null;
        
        try {
            output = new FileOutputStream(configFileName);
            
            for(int i = 0; i < packetName.length; i++)
            {
                if(packetName[i] != null && !packetName[i].isEmpty()) 
                    prop.setProperty(packetName[i], Boolean.toString(isActive[i]));
            }
            
            prop.store(output, null);
        }
        catch (IOException io) {
            io.printStackTrace();
        }
        finally {
            if(output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static void loadSettings()
    {
        Properties prop = new Properties();
        InputStream input = null;
        
        try {
            input = new FileInputStream(configFileName);
            
            prop.load(input);
            
            for(int i = 0; i < packetName.length; i++)
            {
                if(packetName[i] != null && !packetName[i].isEmpty()) 
                    isActive[i] = Boolean.parseBoolean(prop.getProperty(packetName[i]));
            }
        }
        catch (IOException io) {
            io.printStackTrace();
        }
        finally {
            if(input != null) {
                try {
                	input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    
    public static void playerChat(String str)
    {
        if(Minecraft.getMinecraft().thePlayer == null) return;
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(str));
    }
    
    public static void playerChat(String str, String hoverText)
    {
        if(Minecraft.getMinecraft().thePlayer == null) return;
        ChatComponentText strChat =  new ChatComponentText(str);
        ChatComponentText hoverChat = new ChatComponentText(hoverText);
        HoverEvent he = new HoverEvent(HoverEvent.Action.SHOW_TEXT, hoverChat);
        strChat.getChatStyle().setChatHoverEvent(he);
        Minecraft.getMinecraft().thePlayer.addChatMessage(strChat);
    }
    
    private static void playerChatPacketInfo(int packetID, String quickInfo, String hoverInfo)
    {
        if(packetID < 0 || packetID >= ServerPacketData.isActive.length || !ServerPacketData.isActive[packetID]) return;
        String chatStr = "§eTick §f" + Minecraft.getMinecraft().tickcounter + " §e[" + packetName[packetID] + "]";
        if(quickInfo != null && !quickInfo.isEmpty()) chatStr +=  " §7" + quickInfo;
        playerChat(chatStr, hoverInfo);
    }
    
    private static String eid2str(int entityID)
    {
        WorldClient world = Minecraft.getMinecraft().theWorld; 
        if(world != null)
        {
            Entity entity = world.getEntityByID(entityID);
            if(entity != null) return entity.getName();
        }
        return "(null)";
    }
    
    private static String eidTag(int entityID)
    {
        String str = "EntityID: " + entityID;
        WorldClient world = Minecraft.getMinecraft().theWorld; 
        if(world != null)
        {
            Entity entity = world.getEntityByID(entityID);
            
            if(entity != null) {
                str += " §7→" + entity.getName();
            }
            else {
                str += " §7→(null)";
            }
        }
        return str;
    }
    
    private static String eidInfo(int entityID) {
        return eid2str(entityID) + " (" + entityID + ")";
    }
    
    private static String pos2str(BlockPos pos) {
        return "[" + pos.getX() + "," + pos.getY() + "," + pos.getZ() + "]";
    }
    
    private static String pos2str(int x, int z) {
        return "[" + x + "," + z + "]";
    }
    
    private static String pos2str(int x, int y, int z) {
        return "[" + x + "," + y + "," + z + "]";
    }
    
    private static String pos2str(double x, double y, double z) {
        return "[" + x + "," + y + "," + z + "]";
    }
    
    private static String rot2str(float yaw, float pitch) {
        return "[Yaw:" + yaw + ",Pitch:" + pitch + "]";
    }
    
    // Keep Alive
    public static void displayS00(int keepAlive)
    {
        String info = "Keep Alive: " + keepAlive;
        playerChatPacketInfo(0x00, "", info);
    }
    
    // Join Game
    public static void displayS01(int entityID, int gameMode, int dimension, int difficulty, int maxPlayers, String levelType, boolean reducedDebugInfo)
    {
        String info =   
                eidTag(entityID) + "\n" + 
                "Gamemode: " + gameMode + "\n" + 
                "Dimension: " + dimension + "\n" +
                "Difficulty: " + difficulty + "\n" +
                "Max Players: " + maxPlayers + "\n" +
                "Level Type: " + levelType + "\n" +
                "Reduced Debug Info: " + reducedDebugInfo;
        playerChatPacketInfo(0x01, "", info);
    }
    
    // Chat Message
    public static void displayS02(IChatComponent chat, byte position)
    {
        String posstr;
        switch(position) {
        case 0: posstr = "chat"; break;
        case 1: posstr = "system message"; break;
        case 2: posstr = "above hotbar"; break;
        default: posstr = "unknown";
        }
        
        String info =   
                "Text: " + chat.getUnformattedText() + "\n" +
                "Position: " + position + " §7[" + posstr + "]";
        playerChatPacketInfo(0x02, "", info);
    }
    
    // Time Update
    public static void displayS03(long worldAge, long timeOfDay)
    {
        String info = 
                "World Age: " + worldAge + "\n" + 
                "Time of Day: " + timeOfDay;
        playerChatPacketInfo(0x03, "" + worldAge, info);
    }
    
    // Entity Equipment
    public static void displayS04(int entityID, int slot, ItemStack item)
    {
        String itemName = (item == null) ? "(null)" : item.getDisplayName();
        String info = 
                eidTag(entityID) + "\n" + 
                "Slot: " + slot + "\n" + 
                "Item: " + itemName;
        playerChatPacketInfo(0x04, "\"" + itemName + "\" for " + eidInfo(entityID), info);
    }
    
    // Spawn Position
    public static void displayS05(BlockPos position)
    {
        String posStr = pos2str(position);
        String info = "Position: " + posStr;
        playerChatPacketInfo(0x05, posStr, info);
    }
    
    // Update Health
    public static void displayS06(float health, int food, float saturation)
    {
        String info = 
                "Health: " + health + "\n" + 
                "Food: " + food + "\n" + 
                "Saturation: " + saturation;
        playerChatPacketInfo(0x06, "", info);
    }
    
    // Respawn
    public static void displayS07(int dimension, int difficulty, int gameMode, String levelType)
    {
        String info = 
                "Dimension: " + dimension + "\n" + 
                "Difficulty: " + difficulty + "\n" +
                "Gamemode: " + gameMode + "\n" + 
                "Level Type: " + levelType;
        playerChatPacketInfo(0x07, "", info);
    }
    
    // Player Position And Look
    public static void displayS08(double x, double y, double z, float yaw, float pitch, String flags)
    {
        // about flags:
        // <Dinnerbone> It's a bitfield, X/Y/Z/Y_ROT/X_ROT. If X is set, the x value is relative and not absolute. 
        String info = 
                "Position: " + pos2str(x,y,z) + "\n" + 
                "Rotation: " + rot2str(yaw,pitch) + "\n" +
                "Flags: " + flags;
        playerChatPacketInfo(0x08, "", info);
    }
    
    // Held Item Change
    public static void displayS09(int slot)
    {
        String info = "Slot: " + slot;
        playerChatPacketInfo(0x09, "", info);
    }
    
    // Use Bed
    public static void displayS0A(EntityPlayer player, BlockPos location)
    {
        String info = 
                "Player: " + player.getName() + "\n" + 
                "Location: " + pos2str(location);
        playerChatPacketInfo(0x0A, "", info);
    }
    
    // Animation
    public static void displayS0B(int entityID, int animation)
    {
        // animation:
        // 0 = Swing arm, 1 = Take damage, 2 = Leave bed, 3 = Eat food, 4 = Critical effect, 5 = Magic critical effect
        String anim;
        switch(animation){
        case 0: anim = "Swing arm"; break;
        case 1: anim = "Take damage"; break;
        case 2: anim = "Leave bed"; break;
        case 3: anim = "Eat food"; break;
        case 4: anim = "Critical effect"; break;
        case 5: anim = "Magic critical effect"; break;
        default: anim = "Unknown"; break;
        }
        
        String info = 
                eidTag(entityID) + "\n" +
                "Animation: " + animation + " §7[" + anim + "]";
        playerChatPacketInfo(0x0B, eidInfo(entityID), info);
    }
    
    // Spawn Player
    public static void displayS0C(int entityID, UUID uuid, double x, double y, double z, float yaw, float pitch, int currentItem, List meta)
    {
        String info = 
                eidTag(entityID) + "\n" +
                "UUID: " + ((uuid==null)?"(null)":uuid.toString()) + "\n" +
                "Position" + pos2str(x,y,z) + "\n" + 
                "Rotation: " + rot2str(yaw,pitch) + "\n" + 
                "Held ItemID: " + currentItem + "\n" + 
                "<Metadata>";
        playerChatPacketInfo(0x0C, eidInfo(entityID), info);
    }
    
    // Collect Item
    public static void displayS0D(int collectedEntityID, int collectorEntityID)
    {
        String info = 
                "Collected " + eidTag(collectedEntityID) + "\n" + 
                "Collector " + eidTag(collectorEntityID);
        playerChatPacketInfo(0x0D, "", info);
    }
    
    // Spawn Object
    public static void displayS0E(int entityID, int type, double x, double y, double z, float yaw, float pitch, int data, double velX, double velY, double velZ)
    {
        String info =   
                eidTag(entityID) + "\n" + 
                "Type: " + type + "\n" +
                "Position" + pos2str(x,y,z) + "\n" + 
                "Rotation: " + rot2str(yaw,pitch) + "\n" + 
                "Data: " + data + "\n" +
                "Velocity: " + pos2str(velX,velY,velZ);
        playerChatPacketInfo(0x0E, eidInfo(entityID), info);
    }
    
    // Spawn Mob
    public static void displayS0F(int entityID, int type, double x, double y, double z, float yaw, float pitch, float headPitch, double velX, double velY, double velZ, List meta)
    {
        String info =   
                eidTag(entityID) + "\n" + 
                "Type: " + type + "\n" +
                "Position" + pos2str(x,y,z) + "\n" + 
                "Rotation: " + rot2str(yaw,pitch) + "\n" + 
                "Head Pitch: " + headPitch + "\n" +
                "Velocity: " + pos2str(velX,velY,velZ) + "\n" + 
                "<Metadata>";
        playerChatPacketInfo(0x0F, eidInfo(entityID) + " @" + pos2str(x,y,z), info);
    }
    
    // Spawn Painting
    public static void displayS10(int entityID, String title, BlockPos location, String facing)
    {
        String info = 
                eidTag(entityID) + "\n" +
                "Title: " + title + "\n" +
                "Position: " + pos2str(location) + "\n" +
                "Facing: " + facing;
        playerChatPacketInfo(0x10, "", info);
    }

    // Spawn Experience Orb
    public static void displayS11(int entityID, double x, double y, double z, int count)
    {
        String info = 
                eidTag(entityID) + "\n" +
                "Position: " + pos2str(x,y,z) + "\n" +
                "Count: " + count;
        playerChatPacketInfo(0x11, "Count: " + count, info);
    }
    
    // Entity Velocity
    public static void displayS12(int entityID, double velX, double velY, double velZ)
    {
        String info = 
                eidTag(entityID) + "\n" +
                "Velocity: " + pos2str(velX,velY,velZ);
        playerChatPacketInfo(0x12, eidInfo(entityID), info);
    }
    
    // Destroy Entities
    // Called before processing to determine the entities before they are destroyed
    public static void displayS13(int count, int entityIDs[])
    {
        final int displayMax = 8;
        String info = "Count: " + count;
        for(int i = 0; i < count && i < displayMax; i++)
        {
            info += "\nEntity[" + i + "]: " + eid2str(entityIDs[i]) + " (" + entityIDs[i] + ")";
        }
        if(count > displayMax) info += " ...";
        playerChatPacketInfo(0x13, "", info);
    }
    
    // Entity
    public static void displayS14(int entityID)
    {
        String info = eidTag(entityID);
        playerChatPacketInfo(0x14, eidInfo(entityID), info);
    }
    
    // Entity Relative Move
    public static void displayS15(int entityID, double x, double y, double z, boolean onGround)
    {
        String info = 
                eidTag(entityID) + "\n" +
                "Delta Position: " + pos2str(x,y,z) + "\n" +
                "On Ground: " + onGround;
        playerChatPacketInfo(0x15, eidInfo(entityID), info);
    }
    
    // Entity Look
    public static void displayS16(int entityID, float yaw, float pitch, boolean onGround)
    {
        String info = 
                eidTag(entityID) + "\n" +
                "Rotation: " + rot2str(yaw,pitch) + "\n" +
                "On Ground: " + onGround;
        playerChatPacketInfo(0x16, eidInfo(entityID), info);
    }
    
    // Entity Look And Relative Move
    public static void displayS17(int entityID, double x, double y, double z, float yaw, float pitch, boolean onGround)
    {
        String info = 
                eidTag(entityID) + "\n" +
                "Delta Position: " + pos2str(x,y,z) + "\n" +
                "Rotation: " + rot2str(yaw,pitch) + "\n" +
                "On Ground: " + onGround;
        playerChatPacketInfo(0x17, eidInfo(entityID), info);
    }
    
    // Entity Teleport
    public static void displayS18(int entityID, double x, double y, double z, float yaw, float pitch, boolean onGround)
    {
        String info = 
                eidTag(entityID) + "\n" +
                "Position: " + pos2str(x,y,z) + "\n" +
                "Rotation: " + rot2str(yaw,pitch) + "\n" +
                "On Ground: " + onGround;
        playerChatPacketInfo(0x18, eidInfo(entityID), info);
    }
    
    // Entity Head Look
    public static void displayS19(int entityID, float yaw)
    {
        String info = 
                eidTag(entityID) + "\n" +
                "Yaw: " + yaw;
        playerChatPacketInfo(0x19, eidInfo(entityID), info);
    }
    
    // Entity Status
    public static void displayS1A(int entityID, int statusID)
    {
        String info = 
                eidTag(entityID) + "\n" +
                "Status: " + statusID;
        playerChatPacketInfo(0x1A, eidInfo(entityID), info);
    }
    
    // Attach Entity
    public static void displayS1B(int attachedEntityID, int holdingEntityID, int leash)
    {
        String info = 
                "Attached " + eidTag(attachedEntityID) + "\n" +
                "Vehicle " + eidTag(holdingEntityID) + "\n" + 
                "Leash: " + leash;
        playerChatPacketInfo(0x1B, "", info);
    }
    
    // Entity Metadata
    public static void displayS1C(int entityID, List meta)
    {
        String info = 
                eidTag(entityID) + "\n" +
                "<Metadata>";
        playerChatPacketInfo(0x1C, eidInfo(entityID), info);
    }
    
    // Entity Effect
    public static void displayS1D(int entityID, int effectID, int duration, int amplifier, boolean particles)
    {
        String info = 
                eidTag(entityID) + "\n" +
                "EffectID: " + effectID + "\n" +
                "Amplifier: " + amplifier + "\n" +
                "Duration: " + duration + "\n" +
                "Particles: " + particles;
        playerChatPacketInfo(0x1D, eidInfo(entityID), info);
    }
    
    // Remove Entity Effect
    public static void displayS1E(int entityID, int effectID)
    {
        String info = 
                eidTag(entityID) + "\n" +
                "EffectID: " + effectID;
        playerChatPacketInfo(0x1E, eidInfo(entityID), info);
    }
    
    // Set Experience
    public static void displayS1F(float expBar, int level, int total)
    {
        String info = 
                "Experience bar: " + expBar + "\n" +
                "Level: " + level + "\n" +
                "Total Experience: " + total;
        playerChatPacketInfo(0x1F, "", info);
    }
    
    // Entity Properties
    public static void displayS20(int entityID, List attributes)
    {
        String info = 
                eidTag(entityID) + "\n" +
                "<Attributes>";
        
        playerChatPacketInfo(0x20, eidInfo(entityID), info);
    }
    
    // Chunk Data
    // Updated an existing chunk
    public static void displayS21(int chunkX, int chunkZ, boolean groundUpCont, int primBitMask, int size, byte data[], byte biomes[])
    {
        String info = 
                "Chunk Position: " + pos2str(chunkX,chunkZ) + "\n" +
                "Ground-Up Continuous: " + groundUpCont + "\n" +
                "Primary Bit Mask: " + String.format("%16s", Integer.toBinaryString(primBitMask))
                                       .replace(' ', '0').replace("1", "§a1§f") + "\n" +
                //"Size:" + size + "\n" +
                "<Chunk Sections Data>\n" +
                "<Biomes>";
        playerChatPacketInfo(0x21, pos2str(chunkX,chunkZ), info);
    }
    
    // Multi Block Change
    public static void displayS22(S22PacketMultiBlockChange.BlockUpdateData blockUpdates[])
    {
        String info = "";
        
        for(int i = 0; i < blockUpdates.length; i++)
        {
            S22PacketMultiBlockChange.BlockUpdateData update = blockUpdates[i];
            BlockPos pos = update.func_180090_a();
            IBlockState ibs = update.func_180088_c();
            
            info += pos2str(pos) + ":§c" + (ibs + "").substring(10).replace("[", "§7[");
            if(i < blockUpdates.length-1) info += "\n";
        }
        
        playerChatPacketInfo(0x22, "" + blockUpdates.length + " Block Updates", info);
    }
    
    // Block Change
    public static void displayS23(BlockPos pos, IBlockState ibs)
    {
        String info = pos2str(pos) + ":§c" + (ibs + "").substring(10).replace("[", "§7[");
        playerChatPacketInfo(0x23, pos2str(pos), info);
    }
    
    // Block Action
    public static void displayS24(BlockPos pos, Block block, int event, int eventParam)
    {
        String blockName = I18n.format(block.getUnlocalizedName() + ".name");
        String action = "";
        String info = 
                "Block: " + blockName + "\n" + 
                "Position: " + pos2str(pos) + "\n" +
                "Action: " + event + " §7[";
        
        if(block instanceof BlockNote)
        {
            switch(event) {
            case 0: action += "Harp"; break;
            case 1: action += "Double Bass"; break;
            case 2: action += "Snare Drum"; break;
            case 3: action += "Clicks/Sticks"; break;
            case 4: action += "Bass Drum"; break;
            default: action += "Unknown";
            }
            
            info += action + "]\nParameter: " + eventParam + " §7[Pitch]";
        }
        else if(block instanceof BlockPistonExtension || block instanceof BlockPistonBase)
        {
            switch(event) {
            case 0: action += "Pushing"; break;
            case 1: action += "Pulling"; break;
            default: action += "Unknown";
            }
            
            info += action + "]\nParameter: " + eventParam + " §7[";
            
            switch(eventParam) {
            case 0: info += "Down"; break;
            case 1: info += "Up"; break;
            case 2: info += "South"; break;
            case 3: info += "West"; break;
            case 4: info += "North"; break;
            case 5: info += "East"; break;
            default: info += "Unknown";
            }
            
            info += "]";
        }
        else if(block instanceof BlockChest || block instanceof BlockEnderChest)
        {
            info += "]\n" + "Parameter: " + eventParam + " §7[Players Opening]";
        }
        else
        {
            info += "Unknown]\n" + "Parameter: " + eventParam + " §7[Unknown]";
        }
        
        String quickInfo = "§c" + blockName;
        if(!action.isEmpty()) quickInfo += ": §7" + action; 
        playerChatPacketInfo(0x24, quickInfo, info);
    }
    
    // Block Break Animation
    public static void displayS25(int entityID, BlockPos pos, int destroyStage)
    {
        String info = 
                eidTag(entityID) + "\n" +
                "Position: " + pos2str(pos) + "\n" +
                "Destroy Stage: " + destroyStage;
        playerChatPacketInfo(0x25, eidInfo(entityID), info);
    }
    
    // Map Chunk Bulk
    // Initial chunk loading
    public static void displayS26(int chunkX[], int chunkZ[], int bitMasks[])
    {
        String info = "Loading Chunks: ";
        int minX = Integer.MAX_VALUE, minZ = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE, maxZ = -Integer.MIN_VALUE;
        
        for(int i = 0; i < chunkX.length; i++)
        {
            if(chunkX[i] < minX) minX = chunkX[i];
            if(chunkZ[i] < minZ) minZ = chunkZ[i];
            if(chunkX[i] > maxX) maxX = chunkX[i];
            if(chunkZ[i] > maxZ) maxZ = chunkZ[i];
            
            info += "\n" + String.format("%1$-9s", pos2str(chunkX[i],chunkZ[i])) + " Sections:" + 
                    String.format("%16s", Integer.toBinaryString(bitMasks[i])).replace(' ', '0').replace("1", "§a1§f");
        }
        
        String quickInfo = "[" + minX + "," + minZ + "]->[" + maxX + "," + maxZ + "] (" + chunkX.length + ")";
        
        playerChatPacketInfo(0x26, quickInfo, info);
    }
    
    // Explosion
    public static void displayS27(double x, double y, double z, float radius, List affectedBlockOffsets, float velX, float velY, float velZ)
    {
        String info = 
                "Position: " + pos2str(x,y,z) + "\n" +
                "Radius: " + radius + "\n" +
                "Player Motion: " + pos2str(velX,velY,velZ) + "\n" +
                "No. of Affected Blocks: " + affectedBlockOffsets.size() + "\n" +
                "Affected Block Coordinated:";
        
        final int maxLen = 20;
        for(int i = 0; i < maxLen && i < affectedBlockOffsets.size(); i++)
        {
            if(i % 5 == 0) info += "\n"; 
            info += pos2str((BlockPos)affectedBlockOffsets.get(i)) + " ";
        }
        
        if(affectedBlockOffsets.size() > maxLen) info += "...";
        
        playerChatPacketInfo(0x27, "@" + pos2str(Math.floor(x),Math.floor(y),Math.floor(z)), info);
    }
    
    // Effect
    public static void displayS28(int effectID, BlockPos pos, int data, boolean noRelativeVol)
    {
        String info = 
                "Effect ID: " + effectID + "\n" +
                "Position: " + pos2str(pos) + "\n" +
                "Data: " + data + "\n" +
                "Serverwide: " + noRelativeVol;
        playerChatPacketInfo(0x28, "", info);
    }
    
    // Sound Effect
    public static void displayS29(double x, double y, double z, String soundName, float volume, float pitch)
    {
        String info = 
                "Sound Name: " + soundName + "\n" +
                "Position: " + pos2str(x,y,z) + "\n" +
                "Volume: " + volume + "\n" +
                "Pitch: " + pitch;
        playerChatPacketInfo(0x29, soundName, info);
    }
    
    // Particle
    public static void displayS2A(String particleID, int count, boolean isLongDist, double x, double y, double z, float Dx, float Dy, float Dz, float offsetScale)
    {
        String info = 
                "ParticleType: " + particleID + "\n" +
                "Count: " + count + "\n" +
                "Is Long Distance: " + isLongDist + "\n" +
                "Position: " + pos2str(x,y,z) + "\n" +
                "Offset: " + pos2str(Dx,Dy,Dz) + "\n" +
                "Offset Scale: " + offsetScale;
        playerChatPacketInfo(0x2A, particleID + " ×" + count, info);
    }
    
    // Change Game State
    public static void displayS2B(int reason, float data)
    {
        String info = "";
        
        String str;
        switch(reason) {
        case 0: str = "Invalid Bed"; break;
        case 1: str = "End raining"; break;
        case 2: str = "Begin raining"; break;
        case 3: str = "Change game mode"; break;
        case 4: str = "Enter credits"; break;
        case 5: str = "Demo message"; break;
        case 6: str = "Arrow hitting player"; break;
        case 7: str = "Rain strength"; break;
        case 8: str = "Thunder strength"; break;
        case 10: str = "Play mob appearance"; break;
        default: str = "Unknown";
        }
        info += "State: " + str + "\n" + 
                "Value: " + data;
        
        playerChatPacketInfo(0x2B, str, info);
    }
    
    // Spawn Global Entity
    public static void displayS2C(int entityID, int isLightningBlot, double x, double y, double z)
    {
        String info = 
                eidTag(entityID) + "\n" +
                "Is Lightning Blot: " + isLightningBlot + "\n" +
                "Position: " + pos2str(x,y,z);
        playerChatPacketInfo(0x2C, eid2str(entityID), info);
    }
    
    // Open Window
    public static void displayS2D(int windowID, String type, IChatComponent title, int slotNum, int entityID)
    {
        String info = 
                "WindowID: " + windowID + "\n" +
                "Type: " + type + "\n" +
                "Title: " + (title == null ? "(null)" : title.getUnformattedText()) + "\n" +
                "Number of Slots: " + slotNum + "\n" +
                eidTag(entityID);
        playerChatPacketInfo(0x2D, type, info);
    }
    
    // Close Window
    public static void displayS2E()
    {
        String info = "§7[Closes Current Window]";
        playerChatPacketInfo(0x2E, "", info);
    }
    
    // Set Slot
    public static void displayS2F(int windowID, int slot, ItemStack stack)
    {
        String stackStr;
        if(stack == null) stackStr = "(null)";
        else stackStr = stack.getDisplayName() + " §7×" + stack.stackSize;
        
        String info = 
                "WindowID: " + windowID + "\n" +
                "Slot: " + slot + "\n" +
                "ItemStack: " + stackStr;
        playerChatPacketInfo(0x2F, "" + slot + " → [" + stackStr + "]", info);
    }
    
    // Window Items
    public static void displayS30(int windowID, ItemStack slots[])
    {
        String info = 
                "WindowID: " + windowID;
        
        final int dispMax = 9;
        int dispCnt = 0;
        for(int i = 0; i < slots.length && dispCnt < dispMax; i++)
        {
            if(slots[i] == null) continue;
            
            String stackName = slots[i].getDisplayName() + " §8×" + slots[i].stackSize;
            info += "\nSlot[" + i + "]: " + i + " §7[" + stackName + "§7]";
            dispCnt++;
        }
        if(dispCnt > dispMax) info += " ...";
        
        playerChatPacketInfo(0x30, "", info);
    }
    
    // Window Property
    public static void displayS31(int windowID, int property, int value)
    {
        String info = 
                "WindowID: " + windowID + "\n" +
                "Property: " + property + "\n" +
                "Value: " + value;
        playerChatPacketInfo(0x31, "", info);
    }
    
    // Confirm Transaction
    public static void displayS32(int windowID, int actionNumber, boolean accepted)
    {
        String info = 
                "WindowID: " + windowID + "\n" +
                "Action Number: " + actionNumber + "\n" +
                "Accepted: " + accepted;
        playerChatPacketInfo(0x32, "", info);
    }
    
    // Update Sign
    public static void displayS33(BlockPos pos, IChatComponent lines[])
    {
        String info = 
                "Position: " + pos2str(pos);
        
        for(int i = 0; i < lines.length; i++)
        {
            info += "\nL[" + i + "]: " + (lines[i] == null ? "(null)" : lines[i].getUnformattedText());
        }
        
        playerChatPacketInfo(0x33, "", info);
    }
    
    // Map
    public static void displayS34(int mapID)
    {
        String info = 
                "MapID: " + mapID + "\n" +
                "<Map Data>";
        playerChatPacketInfo(0x34, "", info);
    }
    
    // Update Block Entity
    public static void displayS35(BlockPos pos, int type, NBTTagCompound nbt)
    {
        String typestr;
        switch(type) {
        case 1: typestr = "TileEntityMobSpawner"; break;
        case 2: typestr = "TileEntityCommandBlock"; break;
        case 3: typestr = "TileEntityBeacon"; break;
        case 4: typestr = "TileEntitySkull"; break;
        case 5: typestr = "TileEntityFlowerPot"; break;
        case 6: typestr = "TileEntityBanner"; break;
        default: typestr = "Unknown";
        }
        
        
        String info = 
                "Position: " + pos2str(pos) + "\n" +
                "Type: " + typestr + "\n" +
                "<NBT>";
        playerChatPacketInfo(0x35, typestr, info);
    }
    
    // Open Sign Editor
    public static void displayS36(BlockPos pos)
    {
        String info = "Position: " + pos2str(pos);
        playerChatPacketInfo(0x36, "", info);
    }
    
    // Statistics
    public static void displayS37()
    {
        String info = 
                "<Statistics>";
        playerChatPacketInfo(0x37, "", info);
    }
    
    // Player List Item
    public static void displayS38(String uuids[], String[] action)
    {
        String info = "";
        for(int i = 0; i < uuids.length; i++)
        {
            info += uuids[i] + ": " + action[i];
            if(i < uuids.length-1) info += "\n";
        }
        
        playerChatPacketInfo(0x38, "", info);
    }
    
    // Player Abilities
    public static void displayS39(boolean isFlying, boolean isCreativeMode, boolean isInvulnerable, boolean isAllowFlying, float flySpeed, float fieldOfView)
    {
        String info = 
                "IsFlying: " + isFlying + "\n" +
                "IsCreativeMode: " + isCreativeMode + "\n" +
                "IsInvulnerable: " + isInvulnerable + "\n" +
                "IsAllowFlying: " + isAllowFlying + "\n" +
                "Flying Speed: " + flySpeed + "\n" +
                "Field of View: " + fieldOfView;
        playerChatPacketInfo(0x39, "", info);
    }
    
    // Tab-Complete
    public static void displayS3A(String strs[])
    {
        String info = "";
        final int dispMax = 9;
        for(int i = 0; i < strs.length; i++)
        {
            if(i >= dispMax) {
                info += " ...";
                break;
            }
            info += strs[i];
            if(i < strs.length-1) info += "\n";
        }
        
        playerChatPacketInfo(0x3A, "", info);
    }
    
    //  Scoreboard Objective
    public static void displayS3B(String name, String type, int mode, String renderType)
    {
        String info = 
                "Name: " + name + "\n" +
                "Type: " +  type + "\n" +
                "Mode: " + mode + "\n" +
                "Render Type: " + renderType;
        playerChatPacketInfo(0x3B, "", info);
    }
    
    // Update Score
    public static void displayS3C(String scoreName, String objectiveName, String action, int value)
    {
        String info = 
                "Score Name: " + scoreName + "\n" +
                "Objective Name: " + objectiveName + "\n" +
                "Action: " + action + "\n" +
                "Value: " + value;
        playerChatPacketInfo(0x3C, "", info);
    }
    
    // Display Scoreboard
    public static void displayS3D(int pos, String scoreName)
    {
        String posstr = pos == 0 ? "List" : pos == 1 ? "Sidebar" : pos == 2 ? "Below Name" : "Unknown";
        
        String info = 
                "Position: " + pos + " §7[" + posstr + "]\n" +
                "Score Name: " + scoreName;
        playerChatPacketInfo(0x3D, "", info);
    }
    
    // Teams
    public static void displayS3E(int mode, String teamName, 
            String teamDispName, String prefix, String suffix, 
            int chatFormatting, int friendlyFire, String nameTagVisibility, 
            Collection playerNames)
    {
        String modeStr;
        switch(mode) {
        case 0: modeStr = "Create Team"; break;
        case 1: modeStr = "Remove Team"; break;
        case 2: modeStr = "Update Team Info"; break;
        case 3: modeStr = "Add Players to Team"; break;
        case 4: modeStr = "Remove Players from Team"; break;
        default: modeStr = "Unknown";
        }
        
        String info = 
                "Team Name: " + teamName + "\n" +
                "Mode: " + mode + " §7[" + modeStr + "]\n" +
                "Team Display Name: " + teamDispName + "\n" +
                "Prefix: " + prefix + "\n" +
                "Suffix: " + suffix + "\n" +
                "Chat Formatting: " + chatFormatting + "\n" +
                "Friendly Fire: " + friendlyFire + "\n" +
                "Name Tag Visibility: " + nameTagVisibility + "\n" +
                "Players: ";
        
        String player;
        Iterator iterator = playerNames.iterator();

        if(iterator == null)
        {
            info += "(null)";
        }
        else
        {
            final int dispMax = 4;
            int i;
            for(i = 0; iterator.hasNext() && i < dispMax; i++)
            {
                info += (String)iterator.next();
                if(iterator.hasNext()) info += ", ";
            }
            if(i >= dispMax) info += "...";
        }
        
        playerChatPacketInfo(0x3E, "", info);
    }
    
    // Plugin Message
    public static void displayS3F(String channelName)
    {
        String info = 
                "Channel Name: " + channelName + "\n" +
                "<Buffer Data>";
        playerChatPacketInfo(0x3F, channelName, info);
    }
    
    // Disconnect
    public static void displayS40(IChatComponent reason)
    {
        String info = "Reason: " + reason.getUnformattedText();
        playerChatPacketInfo(0x40, "", info);
    }
    
    // Server Difficulty
    public static void displayS41(int difficulty, boolean isLocked)
    {
        String info = 
                "Difficulty: " + difficulty + "\n" +
                "Locked: " + isLocked;
        playerChatPacketInfo(0x41, "", info);
    }
    
    // Combat Event
    public static void displayS42(String event, int duration, int entityID, int playerID, String message)
    {   
        String info = 
                "Event: " + event + "\n" + 
                "Duration: " + duration + "\n" + 
                "EntityID: " + entityID + " §7→" + eid2str(entityID) + "\n" + 
                "PlayerID: " + playerID + " §7→" + eid2str(playerID) + "\n" +
                "Message: " + message;
        playerChatPacketInfo(0x42, "", info);
    }
    
    // Camera
    public static void displayS43(int camEntityID)
    {
        String info = "Camera " + eidTag(camEntityID);
        playerChatPacketInfo(0x43, eidInfo(camEntityID), info);
    }
    
    // World Border 35
    public static void displayS44()
    {
        String info = "<World Border>";
        playerChatPacketInfo(0x44, "", info);
    }
    
    // Title 45
    public static void displayS45(String action, String title, String subTitle, int fadeIn, int stay, int fadeOut)
    {
        String info = 
                "Action: " + action + "\n" +
                "Title: " + title + "\n" +
                "Subtitle: " + subTitle + "\n" +
                "Fade In: " + fadeIn + "\n" +
                "Stay: " + stay + "\n" + 
                "Fade Out: " + fadeOut;
        playerChatPacketInfo(0x45, "", info);
    }
    
    // Set Compression Level 
    public static void displayS46(int compressionLevel)
    {
        String info = "Compression Level: " + compressionLevel;
        playerChatPacketInfo(0x46, "", info);
    }
    
    // Player List Header And Footer
    public static void displayS47(IChatComponent header, IChatComponent footer)
    {
        String info = 
                "Header: " + header.getUnformattedText() + "\n" +
                "Footer: " + footer.getUnformattedText();
        playerChatPacketInfo(0x47, "", info);
    }
    
    // Resource Pack Send 32
    public static void displayS48(String url, String hash)
    {
        String info = 
                "URL: " + url + "\n" +
                "Hash: " + hash;
        playerChatPacketInfo(0x48, "", info);
    }
    
    // Entity NBT ?
    public static void displayS49(int entityID, NBTTagCompound nbt)
    {
        String info = 
                eidTag(entityID) + "\n" +
                "<NBT>";
        playerChatPacketInfo(0x49, eidInfo(entityID), info);
    }
}
