import java.util.List;

public class CommandRerender extends i
{
    @Override
    public String c()
    {
        return "rerender";
    }

    @Override
    public int a()
    {
        return 0;
    }

    @Override
    public String b(m sender)
    {
        return "/rerender [fromX fromY fromZ toX toY toZ]\n§7Marks a region to be rendered again (without reloading)\n§7Specifying no arguments will also reload and do the same as F3+A";
    }

    @Override
    public void a(MinecraftServer server, m sender, String[] args) throws bz
    {
        if(args.length == 0) {
            bcc.z().scheduledReload = true;
        }
        else if(args.length <= 5) {
            a(sender, this, "§cUsage:\n§c"+b(sender));
            return;
        } else {
            cj pos1 = a(sender, args, 0, false);
            cj pos2 = a(sender, args, 3, false); 

            cj from = new cj(Math.min(pos1.p(), pos2.p()), Math.min(pos1.q(), pos2.q()), Math.min(pos1.r(), pos2.r()));
            cj to   = new cj(Math.max(pos1.p(), pos2.p()), Math.max(pos1.q(), pos2.q()), Math.max(pos1.r(), pos2.r()));
            sender.e().b(from, to);
        }
    }

    @Override
    public List<String> a(MinecraftServer server, m sender, String[] args, cj pos)
    {
        return null;
    }

    @Override
    public boolean b(String[] args, int index)
    {
        return index == 0;
    }

    @Override
    public int compareTo(k o) {
        // TODO Auto-generated method stub
        return 0;
    }
}