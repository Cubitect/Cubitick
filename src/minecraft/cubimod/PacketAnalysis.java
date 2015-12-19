package cubimod;

import java.util.Arrays;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

public class PacketAnalysis 
{
    private static PacketAnalysis instance;
    
    private String author = "Cubitect";
    private String name = "PacketAnalysis";
    private String versionName = "[1.8]v1.0.0";
    
    public static boolean packetS[] = new boolean[0x49];
    
    
    public PacketAnalysis()
    {
        System.out.println(name + " " + versionName + " by " + author);
        Arrays.fill(packetS, false);
    }
    
    public static void playerChat(String str)
    {
        if(Minecraft.getMinecraft().thePlayer == null) return;
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(str));
    }
}
