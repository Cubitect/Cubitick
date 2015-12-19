package cubimod;

import net.minecraft.client.Minecraft;
import net.minecraft.util.Timer;

public class Cubitick 
{
    private static Cubitick instance;
    
    private String author = "Cubitect";
    private String name = "Cubitick";
    private String versionName = "[1.8]v1.4.0";

    public static final float tickrate = 20F;
    public static float tickrateWorld = 20F;
    public static boolean synctick = false;
    
    
    public Cubitick()
    {
        System.out.println(name + " " + versionName + " by " + author);
    }
    
    public static void setTickWorld(float rate)
    {
        tickrateWorld = rate;
        setTimerWorld(rate);
    }
    
    public static void setTimerWorld(float rate)
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
}
