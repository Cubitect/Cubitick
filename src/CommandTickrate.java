public class CommandTickrate extends i
{
    public String c()
    {
        return "tickrate";
    }
    
    public int a()
    {
        return 2;
    }

    public String b(m sender)
    {
        return "/tickrate [rate]";
    }

    public void a(MinecraftServer server, m sender, String[] args) throws bz
    {
        if(args.length < 1) {
            a(sender, this, "Tickrate is " + Cubitick.tickrateWorld + " ticks per second");
            return;
        } else {
            float tickspeed = (float)a(args[0], 0F);
            if(tickspeed >= 0) {
                Cubitick.setTickWorld(tickspeed);
                a(sender, this, "Tickrate set to " + tickspeed);
            } else {
                a(sender, this, "Tickrate should be a non-negative floating point number");
                return;
            }
        }
    }

    @Override
    public int compareTo(k o) {
        // TODO Auto-generated method stub
        return 0;
    }
}

