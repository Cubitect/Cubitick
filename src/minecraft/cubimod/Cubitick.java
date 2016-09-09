package cubimod;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import net.minecraft.client.Minecraft;
import net.minecraft.util.Timer;
import net.minecraft.util.text.TextComponentString;

public class Cubitick 
{
    public static Cubitick instance = new Cubitick();
    public static boolean initialised = false; 
    
    private String author = "Cubitect";
    private String name = "Cubitick";
    private String versionName = "[1.10]v1.5.2";
    private String versionType = "main";
    private String mcVersion   = "1.10";
    private String mcType      = "release";
    
    public static final float tickrate = 20F;
    public static float tickrateWorld = 20F;
    public static boolean synctick = false;
    
    
    public Cubitick()
    {
        initialised = false;
    }
    
    public void checkVersion()
    {
        if(initialised) return;
        initialised = true;
        
        try {
            URL url = new URL("https://raw.githubusercontent.com/Cubitect/Cubitick/master/versions.txt");
            Scanner s = new Scanner(url.openStream());
            
            while (s.hasNextLine()) {
                if(!s.hasNext()) break;
                String versionType = s.next();
                //System.out.println(versionType);
                if(!s.hasNext()) break;
                String mcVersion   = s.next();
                //System.out.println(mcVersion);
                if(!s.hasNext()) break;
                String mcType      = s.next();
                //System.out.println(mcType);
                if(!s.hasNext()) break;
                String versionName = s.next();
                //System.out.println(versionName);
                
                if(this.versionType.equals("dev") || versionType.equals("main")){
                    if(this.mcVersion.equals(mcVersion)){
                        if(this.mcType.equals("snapshot") || mcType.equals("release")){
                            // Notify available update
                            if(!this.versionName.equals(versionName)){
                                playerChat("§eNew version available: §f" + name + " " + versionName);
                            }
                            break;
                        }
                    }
                }
            }
            s.close();
        }
        catch(IOException ex) {
           ex.printStackTrace();
           return;
        }
    }
    
    public static void setTickWorld(float rate)
    {
        tickrateWorld = rate;
        setTimerWorld(rate);
    }
    
    private static void setTimerWorld(float rate)
    {
        Minecraft mc = Minecraft.getMinecraft();
        float elapsedPartialTicks = mc.timerWorld.elapsedPartialTicks;
        int elapsedTicks = mc.timerWorld.elapsedTicks;
        float renderPartialTicks = mc.timerWorld.renderPartialTicks;
        
        mc.timerWorld = new Timer(rate);
        
        mc.timerWorld.elapsedPartialTicks = elapsedPartialTicks;
        mc.timerWorld.elapsedTicks = elapsedTicks;
        mc.timerWorld.renderPartialTicks = renderPartialTicks;
        
        mc.timer = new Timer(tickrate);
    }
    
    public static float getTickms()
    {
        if(Cubitick.tickrateWorld <= 0) return Float.MAX_VALUE;
        return 1000F/Cubitick.tickrateWorld;
    }
    
    public static void playerChat(String str)
    {
        if(Minecraft.getMinecraft().thePlayer == null) return;
        Minecraft.getMinecraft().thePlayer.addChatMessage(new TextComponentString(str));
    }
}
