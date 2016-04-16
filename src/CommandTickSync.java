public class CommandTickSync extends i
{
    public String c()
    {
        return "ticksync";
    }

    public int a()
    {
        return 2;
    }

    public String b(m sender)
    {
        return "/ticksync [true/false]";
    }

    public void a(MinecraftServer server, m sender, String[] args) throws bz
    {
        if(args.length < 1) {
            a(sender, this, (Cubitick.synctick) ? "Tickrate is currently synchronised" : "Tickrate is currently desynchronised");
            return;
        } else {
            if(args[0].equals("true") || args[0].equals("on")) {
                Cubitick.synctick = true;
                a(sender, this, "Tickrate is now synchronised");
            } else if(args[0].equals("false") || args[0].equals("off")) {
                Cubitick.synctick = false;
                a(sender, this, "Tickrate is now desynchronised");
            } else {
                a(sender, this, "Tickrate synchronisation can only be true/on or false/off");
            }
        }
    }
    
    @Override
    public int compareTo(k o) {
        // TODO Auto-generated method stub
        return 0;
    }
}
