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

public class ServerPacketData 
{
    public static final String configFileName = "packet_analysis.cfg";
    
    public static final String[] packetName = 
    {
        "S00 Spawn Object",
        "S01 Spawn Experience Orb",
        "S02 Spawn Global Entity",
        "S03 Spawn Mob",
        "S04 Spawn Painting",
        "S05 Spawn Player",
        "S06 Animation",
        "S07 Statistics",
        "S08 Block Break Animation",
        "S09 Update Block Entity",
        "S0A Block Action",
        "S0B Block Change",
        "S0C Boss Bar",
        "S0D Server Difficulty",
        "S0E Tab-Complete",
        "S0F Chat Message",
        "S10 Multi Block Change",
        "S11 Confirm Transaction",
        "S12 Close Window",
        "S13 Open Window",
        "S14 Window Items",
        "S15 Window Property",
        "S16 Set Slot",
        "S17 Set Cooldown",
        "S18 Plugin Message",
        "S19 Named Sound Effect",
        "S1A Disconnect",
        "S1B Entity Status",
        "S1C Explosion",
        "S1D Unload Chunk",
        "S1E Change Game State",
        "S1F Keep Alive",
        "S20 Chunk Data",
        "S21 Effect",
        "S22 Particle",
        "S23 Join Game",
        "S24 Map",
        "S25 Entity Relative Move",
        "S26 Entity Look And Relative Move",
        "S27 Entity Look",
        "S28 Entity",
        "S29 Vehicle Move",
        "S2A Open Sign Editor",
        "S2B Player Abilities",
        "S2C Combat Event",
        "S2D Player List Item",
        "S2E Player Position And Look",
        "S2F Use Bed",
        "S30 Destroy Entities",
        "S31 Remove Entity Effect",
        "S32 Resource Pack Send",
        "S33 Respawn",
        "S34 Entity Head Look",
        "S35 World Border",
        "S36 Camera",
        "S37 Held Item Change",
        "S38 Display Scoreboard",
        "S39 Entity Metadata",
        "S3A Attach Entity",
        "S3B Entity Velocity",
        "S3C Entity Equipment",
        "S3D Set Experience",
        "S3E Update Health",
        "S3F Scoreboard Objective",
        "S40 Set Passengers",
        "S41 Teams",
        "S42 Update Score",
        "S43 Spawn Position",
        "S44 Time Update",
        "S45 Title",
        "S46 Update Sign",
        "S47 Sound Effect",
        "S48 Player List Header And Footer",
        "S49 Collect Item",
        "S4A Entity Teleport",
        "S4B Entity Properties",
        "S4C Entity Effect"
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
        if(bcc.z().h == null) return;
        bcc.z().h.b(new fa(str));
    }
    
    public static void playerChat(String str, String hoverText)
    {
        if(bcc.z().h == null) return;
        fa strChat =  new fa(str); // fa : ChatComponentText, eu : IChatComponent
        fa hoverChat = new fa(hoverText);
        ew he = new ew(ew.a.a, hoverChat); // ew : HoverEvent
        strChat.b().a(he); // strChat.getChatStyle().setChatHoverEvent(he);
        bcc.z().h.a(strChat);
    }
    
    private static void playerChatPacketInfo(int packetID, String quickInfo, String hoverInfo)
    {
        if(packetID < 0 || packetID >= ServerPacketData.isActive.length || !ServerPacketData.isActive[packetID]) return;
        String chatStr = "§eTick §f" + bcc.z().tickcounter + " §e[" + packetName[packetID] + "]";
        if(quickInfo != null && !quickInfo.isEmpty()) chatStr +=  " §7" + quickInfo;
        playerChat(chatStr, hoverInfo);
    }
    
    private static String eid2str(int entityID)
    {
        bkr world = bcc.z().f; 
        if(world != null)
        {
            rr entity = world.a(entityID); // getEntityByID(.)
            if(entity != null) return entity.h_(); // getName()
        }
        return "(null)";
    }
    
    private static String eidTag(int entityID)
    {
        String str = "EntityID: " + entityID;
        bkr world = bcc.z().f; 
        if(world != null)
        {
            rr entity = world.a(entityID);
            
            if(entity != null) {
                str += " §7→" + entity.h_();
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
    
    private static String pos2str(cj pos) {
        return "[" + pos.p() + "," + pos.q() + "," + pos.r() + "]";
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
    
    // Spawn Object 00
    public static void display_S00(int entityID, UUID uuid, int type, double x, double y, double z, float yaw, float pitch, int data, double velX, double velY, double velZ)
    {
        String info =   
                eidTag(entityID) + "\n" + 
                "UUID: " + ((uuid==null)?"(null)":uuid.toString()) + "\n" +
                "Type: " + type + "\n" +
                "Position" + pos2str(x,y,z) + "\n" + 
                "Rotation: " + rot2str(yaw,pitch) + "\n" + 
                "Data: " + data + "\n" +
                "Velocity: " + pos2str(velX,velY,velZ);
        playerChatPacketInfo(0x00, eidInfo(entityID), info);
    }
    
    // Spawn Experience Orb 01
    public static void display_S01(int entityID, double x, double y, double z, int count)
    {
        String info = 
                eidTag(entityID) + "\n" +
                "Position: " + pos2str(x,y,z) + "\n" +
                "Count: " + count;
        playerChatPacketInfo(0x01, "Count: " + count, info);
    }
    
    // Spawn Global Entity 02
    public static void displayS02(int entityID, int isLightningBlot, double x, double y, double z)
    {
        String info = 
                eidTag(entityID) + "\n" +
                "Is Lightning Blot: " + isLightningBlot + "\n" +
                "Position: " + pos2str(x,y,z);
        playerChatPacketInfo(0x02, eid2str(entityID), info);
    }
    
    // Spawn Mob 03
    public static void display_S03(int entityID, UUID uuid, int type, double x, double y, double z, float yaw, float pitch, float headPitch, double velX, double velY, double velZ, List meta)
    {
        String info =   
                eidTag(entityID) + "\n" + 
                "UUID: " + ((uuid==null)?"(null)":uuid.toString()) + "\n" +
                "Type: " + type + "\n" +
                "Position" + pos2str(x,y,z) + "\n" + 
                "Rotation: " + rot2str(yaw,pitch) + "\n" + 
                "Head Pitch: " + headPitch + "\n" +
                "Velocity: " + pos2str(velX,velY,velZ) + "\n" + 
                "<Metadata>";
        playerChatPacketInfo(0x03, eidInfo(entityID) + " @" + pos2str(x,y,z), info);
    }
    
    // Spawn Painting 04
    public static void display_S04(int entityID, UUID uuid, String title, cj location, String facing)
    {
        String info = 
                eidTag(entityID) + "\n" +
                "UUID: " + ((uuid==null)?"(null)":uuid.toString()) + "\n" +
                "Title: " + title + "\n" +
                "Position: " + pos2str(location) + "\n" +
                "Facing: " + facing;
        playerChatPacketInfo(0x04, "", info);
    }
    
    // Spawn Player 05
    public static void display_S05(int entityID, UUID uuid, double x, double y, double z, float yaw, float pitch, List meta)
    {
        // meta = held item id
        String info = 
                eidTag(entityID) + "\n" +
                "UUID: " + ((uuid==null)?"(null)":uuid.toString()) + "\n" +
                "Position" + pos2str(x,y,z) + "\n" + 
                "Rotation: " + rot2str(yaw,pitch) + "\n" + 
                "Held Meta: " + meta; // TODO
        playerChatPacketInfo(0x05, eidInfo(entityID), info);
    }
    
    // Animation 06
    public static void display_S06(int entityID, int animation)
    {
        // animation:
        // 0 = Swing arm, 1 = Take damage, 2 = Leave bed, 3 = Eat food, 4 = Critical effect, 5 = Magic critical effect
        String anim;
        switch(animation){
        case 0: anim = "Swing Arm"; break;
        case 1: anim = "Take Damage"; break;
        case 2: anim = "Leave Bed"; break;
        case 3: anim = "Eat Food"; break;
        case 4: anim = "Critical Effect"; break;
        case 5: anim = "Magic Critical Effect"; break;
        default: anim = "Unknown"; break;
        }
        
        String info = 
                eidTag(entityID) + "\n" +
                "Animation: " + animation + " §7[" + anim + "]";
        playerChatPacketInfo(0x06, eidInfo(entityID), info);
    }
    
    // Statistics 07
    public static void display_S07()
    {
        String info = 
                "<Statistics>";
        playerChatPacketInfo(0x07, "", info);
    }
    
    // Block Break Animation 08
    public static void display_S08(int entityID, cj pos, int destroyStage)
    {
        String info = 
                eidTag(entityID) + "\n" +
                "Position: " + pos2str(pos) + "\n" +
                "Destroy Stage: " + destroyStage;
        playerChatPacketInfo(0x08, eidInfo(entityID), info);
    }
    
    // Update Block Entity 09
    public static void display_S09(cj pos, int type, Object nbt)
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
        playerChatPacketInfo(0x09, typestr, info);
    }
    
    
    // Block Action 0A
    public static void display_S0A(cj pos, ajt block, int event, int eventParam)
    {
        String blockName = bwl.a(block.a() + ".name", new Object[0]);
        String action = "";
        String info = 
                "Block: " + blockName + "\n" + 
                "Position: " + pos2str(pos) + "\n" +
                "Action: " + event + " §7[";
        
        if(block instanceof and) // BlockNote : and
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
        // BlockPistonBase : aqu,  BlockPistonExtension : aqv
        else if(block instanceof aqu || block instanceof aqv)
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
        // BlockChest : ake, BlockEnderChest : alf
        else if(block instanceof ake || block instanceof alf)
        {
            info += "]\n" + "Parameter: " + eventParam + " §7[Players Opening]";
        }
        else
        {
            info += "Unknown]\n" + "Parameter: " + eventParam + " §7[Unknown]";
        }
        
        String quickInfo = "§c" + blockName;
        if(!action.isEmpty()) quickInfo += ": §7" + action; 
        playerChatPacketInfo(0x0A, quickInfo, info);
    }
    
    // Block Change 0B
    public static void display_S0B(cj pos, arc ibs)
    {
        String info = pos2str(pos) + ":§c" + (ibs + "").substring(10).replace("[", "§7[");
        playerChatPacketInfo(0x0B, pos2str(pos), info);
    }

    // Boss Bar 0C
    public static void display_S0C(UUID uuid, String action, eu title, float health, String color, String division, boolean bool1, boolean bool2, boolean bool3)
    {
        // meta = held item id
        String info = 
                "UUID: " + ((uuid==null)?"(null)":uuid.toString()) + "\n" +
                "Action: " + action + "\n" + 
                "Title: " + title.c() + "\n" + 
                "Health: " + health + "\n" + 
                "Color: " + color + "\n" + 
                "Type: " + division + "\n" + 
                "B1: " + bool1 + ", B2: " + bool2 + ", B3: " + bool3;
        playerChatPacketInfo(0x0C, "", info);
    }
    
    // Server Difficulty 0D
    public static void display_S0D(int difficulty, boolean isLocked)
    {
        String info = 
                "Difficulty: " + difficulty + "\n" +
                "Locked: " + isLocked;
        playerChatPacketInfo(0x0D, "", info);
    }
    
    // Tab-Complete (clientbound) 0E
    public static void display_S0E(String strs[])
    {
        String info = "";
        final int dispMax = 9;
        for(int i = 0; i < strs.length; i++)
        {
            if(i >= dispMax) {
                info += "...";
                break;
            }
            info += strs[i];
            if(i < strs.length-1) info += "\n";
        }
        
        playerChatPacketInfo(0x0E, "", info);
    }
    
    // Chat Message 0F
    public static void display_S0F(eu chat, byte position)
    {
        String pos;
        switch(position){
        case 0: pos = "chat"; break;
        case 1: pos = "system message"; break;
        case 2: pos = "above hotbar"; break;
        default: pos = "Unknown";
        }
        
        String info =   
                "Text: " + chat.c() + "\n" +
                "Position: " + position + " §7[" + pos + "]";
        playerChatPacketInfo(0x0F, "", info);
    }
    
    
    // Multi Block Change 10
    public static void display_S10(fz.a blockUpdates[])
    {
        String info = "";
        
        for(int i = 0; i < blockUpdates.length; i++)
        {
            fz.a update = blockUpdates[i];
            cj pos = update.a();
            arc ibs = update.c();
            
            info += pos2str(pos) + ":§c" + (ibs + "").substring(10).replace("[", "§7[");
            if(i < blockUpdates.length-1) info += "\n";
        }
        
        playerChatPacketInfo(0x10, "" + blockUpdates.length + " Block Updates", info);
    }
    
    // Confirm Transaction (clientbound) 11
    public static void display_S11(int windowID, int actionNumber, boolean accepted)
    {
        String info = 
                "WindowID: " + windowID + "\n" +
                "Action Number: " + actionNumber + "\n" +
                "Accepted: " + accepted;
        playerChatPacketInfo(0x11, "", info);
    }

    // Close Window 12
    public static void display_S12()
    {
        String info = "§7[Closes Current Window]";
        playerChatPacketInfo(0x12, "", info);
    }
    
    // Open Window 13
    public static void display_S13(int windowID, String type, eu title, int slotNum, int entityID)
    {
        String info = 
                "WindowID: " + windowID + "\n" +
                "Type: " + type + "\n" +
                "Title: " + (title == null ? "(null)" : title.c()) + "\n" +
                "Number of Slots: " + slotNum + "\n" +
                eidTag(entityID);
        playerChatPacketInfo(0x13, type, info);
    }
    
    // Window Items 14
    public static void display_S14(int count, adq slots[])
    {
        String info = 
                "Count: " + count;
        
        final int dispMax = 9;
        int dispCnt = 0;
        for(int i = 0; i < slots.length && dispCnt < dispMax; i++)
        {
            if(slots[i] == null) continue;
            
            String stackName = slots[i] == null ? "(null)" : slots[i].q() + " §8×" + slots[i].b;
            info += "\nSlot: " + i + " §7[" + stackName + "§7]";
            dispCnt++;
        }
        if(dispCnt >= dispMax) info += "\n...";
        
        playerChatPacketInfo(0x14, "", info);
    }
    
    // Window Property 15
    public static void display_S15(int windowID, int property, int value)
    {
        String info = 
                "WindowID: " + windowID + "\n" +
                "Property: " + property + "\n" +
                "Value: " + value;
        playerChatPacketInfo(0x15, "", info);
    }
    
    // Set Slot 16
    public static void display_S16(int windowID, int slot, adq stack)
    {
        String stackStr;
        if(stack == null) stackStr = "(null)";
        else stackStr = stack.q() + " §7×" + stack.b; // ItemStack.stacksize : adq.b
        
        String info = 
                "WindowID: " + windowID + "\n" +
                "Slot: " + slot + "\n" +
                "ItemStack: " + stackStr;
        playerChatPacketInfo(0x16, "" + slot + " → [" + stackStr + "]", info);
    }

    // Set Cooldown 17 (NEW)
    public static void display_S17(String itemId, int coolDown)
    {
        String info = 
                "Item: " + itemId + "\n" +
                "Cooldown Ticks: " + coolDown;
        playerChatPacketInfo(0x17, "", info);
    }
    
    // Plugin Message (clientbound) 18
    public static void display_S18(String channelName)
    {
        String info = 
                "Channel Name: " + channelName + "\n" +
                "<Buffer Data>";
        playerChatPacketInfo(0x18, channelName, info);
    }
    
    // Named Sound Effect
    public static void display_S19(double x, double y, double z, String soundName, String soundCategory, float volume, float pitch)
    {
        String info = 
                "Sound Name: " + soundName + "\n" +
                "Sound Category: " + soundCategory + "\n" +
                "Position: " + pos2str(x,y,z) + "\n" +
                "Volume: " + volume + "\n" +
                "Pitch: " + pitch;
        playerChatPacketInfo(0x19, soundName, info);
    }
    
    // Disconnect (play) 1A
    public static void display_S1A(eu reason)
    {
        String info = "Reason: " + reason.c();
        playerChatPacketInfo(0x1A, "", info);
    }
    
    // Entity Status 1B
    public static void display_S1B(int entityID, int statusID)
    {
        String info = 
                eidTag(entityID) + "\n" +
                "Status: " + statusID;
        playerChatPacketInfo(0x1B, eidInfo(entityID), info);
    }
    
    // Explosion 1C
    public static void display_S1C(double x, double y, double z, float radius, List affectedBlockOffsets, float velX, float velY, float velZ)
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
            info += pos2str((cj)affectedBlockOffsets.get(i)) + " ";
        }
        
        if(affectedBlockOffsets.size() > maxLen) info += "...";
        
        playerChatPacketInfo(0x1C, "@" + pos2str(Math.floor(x),Math.floor(y),Math.floor(z)), info);
    }
    
    // Unload Chunk 1D (NEW) TODO: ADD
    public static void display_S1D(int chunkX, int chunkZ)
    {
        String info = "Chunk Coords: " + pos2str(chunkX,chunkZ);
        playerChatPacketInfo(0x1D, pos2str(chunkX,chunkZ), info);
    }
    
    // Change Game State 1E
    public static void display_S1E(int reason, float data)
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
        
        playerChatPacketInfo(0x1E, str, info);
    }
    
    // Keep Alive 1F
    public static void displayS1F(int keepAlive)
    {
        String info = "Keep Alive ID: " + keepAlive;
        playerChatPacketInfo(0x1F, "", info);
    }
    
    // Chunk Data 20
    public static void display_S20(int chunkX, int chunkZ, boolean groundUpCont, int primBitMask, int size, byte data[], byte biomes[])
    {
        String info = 
                "Chunk Position: " + pos2str(chunkX,chunkZ) + "\n" +
                "Ground-Up Continuous: " + groundUpCont + "\n" +
                "Primary Bit Mask: " + String.format("%16s", Integer.toBinaryString(primBitMask))
                                       .replace(' ', '0').replace("1", "§a1§f") + "\n" +
                // "Size:" + size + "\n" +
                "<Chunk Sections Data>\n" +
                "<Biomes>";
        playerChatPacketInfo(0x20, pos2str(chunkX,chunkZ), info);
    }
    
    // Effect 21
    public static void display_S21(int effectID, cj pos, int data, boolean noRelativeVol)
    {
        String info = 
                "Effect ID: " + effectID + "\n" +
                "Position: " + pos2str(pos) + "\n" +
                "Data: " + data + "\n" +
                "Serverwide: " + noRelativeVol;
        playerChatPacketInfo(0x21, "", info);
    }
    
    // Particle 22
    public static void display_S22(String particleID, int count, boolean isLongDist, double x, double y, double z, float Dx, float Dy, float Dz, float offsetScale)
    {
        String info = 
                "ParticleType: " + particleID + "\n" +
                "Count: " + count + "\n" +
                "Is Long Distance: " + isLongDist + "\n" +
                "Position: " + pos2str(x,y,z) + "\n" +
                "Offset: " + pos2str(Dx,Dy,Dz) + "\n" +
                "Offset Scale: " + offsetScale;
        playerChatPacketInfo(0x22, particleID + " ×" + count, info);
    }
    
    // Join Game 23
    public static void display_S23(int entityID, int gameMode, int dimension, int difficulty, int maxPlayers, String levelType, boolean reducedDebugInfo)
    {
        String info =   
                eidTag(entityID) + "\n" + 
                "Gamemode: " + gameMode + "\n" + 
                "Dimension: " + dimension + "\n" +
                "Difficulty: " + difficulty + "\n" +
                "Max Players: " + maxPlayers + "\n" +
                "Level Type: " + levelType + "\n" +
                "Reduced Debug Info: " + reducedDebugInfo;
        playerChatPacketInfo(0x23, "", info);
    }
    
    // Map 24
    public static void display_S24(int mapID)
    {
        String info = 
                "MapID: " + mapID + "\n" +
                "<Map Data>";
        playerChatPacketInfo(0x24, "", info);
    }
    
    // Entity Relative Move 25
    public static void display_S25(int entityID, double x, double y, double z, boolean onGround)
    {
        String info = 
                eidTag(entityID) + "\n" +
                "Delta Position: " + pos2str(x,y,z) + "\n" +
                "On Ground: " + onGround;
        playerChatPacketInfo(0x25, eidInfo(entityID), info);
    }
    
    // Entity Look 26
    public static void display_S26(int entityID, float yaw, float pitch, boolean onGround)
    {
        String info = 
                eidTag(entityID) + "\n" +
                "Rotation: " + rot2str(yaw,pitch) + "\n" +
                "On Ground: " + onGround;
        playerChatPacketInfo(0x26, eidInfo(entityID), info);
    }
    
    // Entity Look And Relative Move 27
    public static void display_S27(int entityID, double x, double y, double z, float yaw, float pitch, boolean onGround)
    {
        String info = 
                eidTag(entityID) + "\n" +
                "Delta Position: " + pos2str(x,y,z) + "\n" +
                "Rotation: " + rot2str(yaw,pitch) + "\n" +
                "On Ground: " + onGround;
        playerChatPacketInfo(0x27, eidInfo(entityID), info);
    }
    
    // Entity 28
    public static void display_S28(int entityID)
    {
        String info = eidTag(entityID);
        playerChatPacketInfo(0x28, eidInfo(entityID), info);
    }
    
    // Vehicle Move (clientbound) 29 (NEW) TODO: ADD
    public static void display_S29(double x, double y, double z, float yaw, float pitch)
    {
        String info = 
                "Position: " + pos2str(x,y,z) + "\n" +
                "Rotation: " + rot2str(yaw,pitch);;
        playerChatPacketInfo(0x29, "", info);
    }
    
    // Open Sign Editor 2A
    public static void display_S2A(cj pos)
    {
        String info = "Position: " + pos2str(pos);
        playerChatPacketInfo(0x2A, "", info);
    }
    
    // Player Abilities (clientbound) 2B
    public static void display_S2B(boolean isFlying, boolean isCreativeMode, boolean isInvulnerable, boolean isAllowFlying, float flySpeed, float fieldOfView)
    {
        String info = 
                "IsFlying: " + isFlying + "\n" +
                "IsCreativeMode: " + isCreativeMode + "\n" +
                "IsInvulnerable: " + isInvulnerable + "\n" +
                "IsAllowFlying: " + isAllowFlying + "\n" +
                "Flying Speed: " + flySpeed + "\n" +
                "Field of View: " + fieldOfView;
        playerChatPacketInfo(0x2B, "", info);
    }
    
    // Combat Event 2C : - GuiDeathScreen
    public static void display_S2C(String event, int playerID, eu chatComponent)
    {   
        // IChatComponent : eu
        String info = 
                "Event: " + event + "\n" + 
                "PlayerID: " + playerID + " §7→" + eid2str(playerID) + "\n" + 
                "Message: " + chatComponent.c();
        playerChatPacketInfo(0x2C, "", info);
    }
    
    // Player List Item 2D
    public static void display_S2D(String uuids[], String[] action)
    {
        String info = "";
        for(int i = 0; i < uuids.length; i++)
        {
            info += uuids[i] + ": " + action[i];
            if(i < uuids.length-1) info += "\n";
        }
        
        playerChatPacketInfo(0x2D, "", info);
    }
    
    // Player Position And Look 2E
    public static void display_S2E(double x, double y, double z, float yaw, float pitch, String flags, Integer teleportID)
    {
        // about flags:
        // <Dinnerbone> It's a bitfield, X/Y/Z/Y_ROT/X_ROT. If X is set, the x value is relative and not absolute. 
        String info = 
                "Position: " + pos2str(x,y,z) + "\n" + 
                "Rotation: " + rot2str(yaw,pitch) + "\n" +
                "Flags: " + flags + "\n" +
                "TeleportID: " + teleportID;
        playerChatPacketInfo(0x2E, "", info);
    }
    
    // Use Bed 2F
    public static void display_S2F(zj player, cj location)
    {
        String info = 
                "Player: " + player.h_() + "\n" + 
                "Location: " + pos2str(location);
        playerChatPacketInfo(0x2F, player.h_(), info);
    }
    
    // Destroy Entities 30
    // Called before processing to determine the entities before they are destroyed
    public static void display_S30(int count, int entityIDs[])
    {
        final int displayMax = 8;
        String info = "Count: " + count;
        for(int i = 0; i < count && i < displayMax; i++)
        {
            info += "\nEntity[" + i + "]: " + eid2str(entityIDs[i]) + " (" + entityIDs[i] + ")";
        }
        if(count > displayMax) info += " ...";
        playerChatPacketInfo(0x30, "", info);
    }
    
    // Remove Entity Effect 31
    public static void display_S31(int entityID, String effect)
    {
        String info = 
                eidTag(entityID) + "\n" +
                "Effect: " + effect;
        playerChatPacketInfo(0x31, eidInfo(entityID), info);
    }
    
    // Resource Pack Send 32
    public static void display_S32(String url, String hash)
    {
        String info = 
                "URL: " + url + "\n" +
                "Hash: " + hash;
        playerChatPacketInfo(0x32, url, info);
    }
    
    // Respawn 33
    public static void display_S33(int dimension, int difficulty, int gameMode, String levelType)
    {
        String info = 
                "Dimension: " + dimension + "\n" + 
                "Difficulty: " + difficulty + "\n" +
                "Gamemode: " + gameMode + "\n" + 
                "Level Type: " + levelType;
        playerChatPacketInfo(0x33, "", info);
    }
    
    // Entity Head Look 34
    public static void display_S34(int entityID, float yaw)
    {
        String info = 
                eidTag(entityID) + "\n" +
                "Head Yaw: " + yaw;
        playerChatPacketInfo(0x34, eidInfo(entityID), info);
    }
    
    // World Border 35
    public static void display_S35()
    {
        String info = "<World Border>";
        playerChatPacketInfo(0x35, "", info);
    }
    
    // Camera 36
    public static void display_S36(int camEntityID)
    {
        String info = "Camera " + eidTag(camEntityID);
        playerChatPacketInfo(0x36, eidInfo(camEntityID), info);
    }
    
    // Held Item Change (clientbound) 37
    public static void display_S37(int slot)
    {
        String info = "Slot: " + slot;
        playerChatPacketInfo(0x37, "", info);
    }
    
    // Display Scoreboard 38
    public static void display_S38(int pos, String scoreName)
    {
        String posstr = pos == 0 ? "List" : pos == 1 ? "Sidebar" : pos == 2 ? "Below Name" : "Unknown";
        
        String info = 
                "Position: " + pos + " §7[" + posstr + "]\n" +
                "Score Name: " + scoreName;
        playerChatPacketInfo(0x38, "", info);
    }
    
    // Entity Metadata 39
    public static void display_S39(int entityID, List meta)
    {
        String info = 
                eidTag(entityID) + "\n" +
                "<Metadata>";
        playerChatPacketInfo(0x39, eidInfo(entityID), info);
    }
    
    // Attach Entity 3A (NEW)
    public static void display_S3A(int entityID, int holdingEntityID)
    {
        String info = 
                eidTag(entityID) + "\n" + 
                "Holding " + eidTag(holdingEntityID);
        playerChatPacketInfo(0x3A, "", info);
    }
    
    // Entity Velocity 3B
    public static void display_S3B(int entityID, double velX, double velY, double velZ)
    {
        String info = 
                eidTag(entityID) + "\n" +
                "Velocity: " + pos2str(velX,velY,velZ);
        playerChatPacketInfo(0x3B, eidInfo(entityID), info);
    }
    
    // Entity Equipment 3C
    public static void display_S3C(int entityID, String slotName, adq stack)
    {
        String itemName = (stack == null) ? "(null)" : stack.q(); // getDisplayName()
        String info = 
                eidTag(entityID) + "\n" + 
                "Slot: " + slotName + "\n" + 
                "Item: " + itemName;
        playerChatPacketInfo(0x3C, "\"" + itemName + "\" for " + eidInfo(entityID), info);
    }
    
    // Set Experience 3D
    public static void display_S3D(float expBar, int level, int total)
    {
        String info = 
                "Experience bar: " + expBar + "\n" +
                "Level: " + level + "\n" +
                "Total Experience: " + total;
        playerChatPacketInfo(0x3D, "", info);
    }
    
    // Update Health 3E
    public static void display_S3E(float health, int food, float saturation)
    {
        String info = 
                "Health: " + health + "\n" + 
                "Food: " + food + "\n" + 
                "Saturation: " + saturation;
        playerChatPacketInfo(0x3E, "", info);
    }

    // Scoreboard Objective 3F
    public static void display_S3F(String name, String type, int mode, String renderType)
    {
        String info = 
                "Name: " + name + "\n" +
                "Type: " +  type + "\n" +
                "Mode: " + mode + "\n" +
                "Render Type: " + renderType;
        playerChatPacketInfo(0x3F, "", info);
    }
    
    // Set Passengers 40
    public static void display_S40(int entityID, int passengerEntityIDs[])
    {
        String info = eidTag(entityID);
        for(int i = 0; i < passengerEntityIDs.length; i++)
                info += "\nPassenger[" + i + "]: " + eid2str(passengerEntityIDs[i]);
        playerChatPacketInfo(0x40, "", info);
    }
    
    // Teams 41
    public static void display_S41(int mode, String teamName, 
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
                "Mode: " + mode + " §7[" + modeStr + "]\n" +
                "Team Name: " + teamName + "\n" +
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
        
        playerChatPacketInfo(0x41, "", info);
    }
    
    // Update Score 42
    public static void display_S42(String scoreName, String objectiveName, String action, int value)
    {
        String info = 
                "Score Name: " + scoreName + "\n" +
                "Objective Name: " + objectiveName + "\n" +
                "Action: " + action + "\n" +
                "Value: " + value;
        playerChatPacketInfo(0x42, "", info);
    }
    
    // Spawn Position 43
    public static void display_S43(cj position)
    {
        String posStr = pos2str(position);
        String info = "Position: " + posStr;
        playerChatPacketInfo(0x43, posStr, info);
    }
    
    // Time Update 44
    public static void display_S44(long worldAge, long timeOfDay)
    {
        String info = 
                "World Age: " + worldAge + "\n" + 
                "Time of Day: " + timeOfDay;
        playerChatPacketInfo(0x44, "(" + worldAge + ", " + timeOfDay + ")", info);
    }
    
    // Title 45
    public static void display_S45(String action, String title, String subTitle, int fadeIn, int stay, int fadeOut)
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
    
    // Update Sign (clientbound) 46
    public static void display_S46(cj pos, eu lines[])
    {
        String info = 
                "Position: " + pos2str(pos);
        
        for(int i = 0; i < lines.length; i++)
        {
            info += "\nL" + i + ": " + (lines[i] == null ? "(null)" : lines[i].c());
        }
        
        playerChatPacketInfo(0x46, "", info);
    }
    
    // Sound Effect (NEW) TODO: sort out difference between 0x19 and 0x47
    public static void display_S47(double x, double y, double z, String soundName, String soundCategory, float volume, float pitch)
    {
        String info = 
                "Sound Name: " + soundName + "\n" +
                "Sound Category: " + soundCategory + "\n" +
                "Position: " + pos2str(x,y,z) + "\n" +
                "Volume: " + volume + "\n" +
                "Pitch: " + pitch;
        playerChatPacketInfo(0x47, soundName, info);
    }
    
    // Player List Header And Footer 48
    public static void display_S48(eu header, eu footer)
    {
        String info = 
                "Header: " + header.c() + "\n" +
                "Footer: " + footer.c();
        playerChatPacketInfo(0x48, "", info);
    }
    
    // Collect Item 49
    // Called before the collected item is destroyed
    public static void display_S49(int collectedEntityID, int collectorEntityID)
    {
        String info = 
                "Collected " + eidTag(collectedEntityID) + "\n" + 
                "Collector " + eidTag(collectorEntityID);
        playerChatPacketInfo(0x49, "", info);
    }
    
    // Entity Teleport 4A
    public static void display_S4A(int entityID, double x, double y, double z, float yaw, float pitch, boolean onGround)
    {
        String info = 
                eidTag(entityID) + "\n" +
                "Position: " + pos2str(x,y,z) + "\n" +
                "Rotation: " + rot2str(yaw,pitch) + "\n" +
                "On Ground: " + onGround;
        playerChatPacketInfo(0x4A, eidInfo(entityID), info);
    }
    
    // Entity Properties 4B
    public static void display_S4B(int entityID, List attributes)
    {
        String info = 
                eidTag(entityID) + "\n" +
                "<Attributes>";
        
        playerChatPacketInfo(0x4B, eidInfo(entityID), info);
    }
    
    // Entity Effect 4C
    public static void display_S4C(int entityID, String effect, int duration, int amplifier, boolean ambient, boolean particles)
    {
        String info = 
                eidTag(entityID) + "\n" +
                "Effect: " + effect + "\n" +
                "Amplifier: " + amplifier + "\n" +
                "Duration: " + duration + "\n" +
                "Ambient: " + ambient + "\n" +
                "Particles: " + particles;
        playerChatPacketInfo(0x4C, eidInfo(entityID), info);
    }
}
