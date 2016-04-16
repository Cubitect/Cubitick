import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

public class Cubitick 
{
    public static Cubitick instance;
    public static boolean initialised = false; 
    
    private String author = "Cubitect";
    private String name = "Cubitick";
    private String versionName = "[1.9.2]v1.5.1";
    private String versionType = "main";
    private String mcVersion   = "1.9";
    private String mcType      = "release";
    
    public static final float tickrate = 20F;
    public static float tickrateWorld = 20F;
    public static boolean synctick = false;
    
    
    public Cubitick()
    {
        System.out.println("[" + name + "] Initializing...");
        
        instance = this;
        ServerPacketData.init();
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
        bcc mc = bcc.z();
        float elapsedPartialTicks = mc.timerWorld.e;
        int elapsedTicks = mc.timerWorld.b;
        float renderPartialTicks = mc.timerWorld.c;
        
        mc.timerWorld = new bci(rate);
        
        mc.timerWorld.e = elapsedPartialTicks;
        mc.timerWorld.b = elapsedTicks;
        mc.timerWorld.c = renderPartialTicks;
        
        mc.timer = new bci(tickrate);
    }
    
    public static float getTickms()
    {
        if(Cubitick.tickrateWorld <= 0) return Float.MAX_VALUE;
        return 1000F/Cubitick.tickrateWorld;
    }
    
    public static void playerChat(String str)
    {
        if(bcc.z().h == null) return;
        bcc.z().h.b(new fa(str));
    }
}
