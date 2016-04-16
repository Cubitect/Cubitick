// ServerCommandManager

/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 */
import com.mojang.authlib.GameProfile;
import java.util.List;

public class bc
extends j
implements h {
    private final MinecraftServer a;

    public bc(MinecraftServer minecraftServer) {
        this.a = minecraftServer;
        this.a(new br());
        this.a(new ah());
        this.a(new ag());
        this.a(new y());
        this.a(new am());
        this.a(new bt());
        this.a(new bv());
        this.a(new ae());
        this.a(new bm());
        this.a(new aj());
        this.a(new aw());
        this.a(new bj());
        this.a(new z());
        this.a(new ab());
        this.a(new at());
        this.a(new aa());
        this.a(new bh());
        this.a(new ak());
        this.a(new x());
        this.a(new ap());
        this.a(new ba());
        this.a(new bg());
        this.a(new be());
        this.a(new ai());
        this.a(new t());
        this.a(new bq());
        this.a(new bi());
        this.a(new au());
        this.a(new bb());
        this.a(new ad());
        this.a(new bu());
        this.a(new p());
        this.a(new bl());
        this.a(new bd());
        this.a(new af());
        this.a(new u());
        this.a(new v());
        this.a(new s());
        this.a(new bp());
        this.a(new bn());
        this.a(new bx());
        this.a(new bs());
        this.a(new ac());
        
        // Cubitick
        this.a(new CommandRerender());
        this.a(new CommandTickSync());
        this.a(new CommandTickrate());
        
        if (minecraftServer.aa()) {
            this.a(new aq());
            this.a(new w());
            this.a(new bk());
            this.a(new ax());
            this.a(new ay());
            this.a(new az());
            this.a(new q());
            this.a(new ar());
            this.a(new r());
            this.a(new an());
            this.a(new as());
            this.a(new al());
            this.a(new ao());
            this.a(new bw());
            this.a(new bf());
        } else {
            this.a(new av());
        }
        i.a(this);
    }

    @Override
    public /* varargs */ void a(m m2, k k2, int n2, String string, Object ... arrobject) {
        boolean bl2 = true;
        MinecraftServer minecraftServer = this.a;
        if (!m2.z_()) {
            bl2 = false;
        }
        fb fb2 = new fb("chat.type.admin", m2.h_(), new fb(string, arrobject));
        fb2.b().a(Namepipe.a.h);
        fb2.b().b(true);
        if (bl2) {
            for (zj zj2 : minecraftServer.al().v()) {
                boolean bl3;
                if (zj2 == m2 || !minecraftServer.al().h(zj2.cK()) || !k2.a(this.a, m2)) continue;
                boolean bl4 = m2 instanceof MinecraftServer && this.a.s();
                boolean bl5 = bl3 = m2 instanceof my && this.a.r();
                if (!bl4 && !bl3 && (m2 instanceof my || m2 instanceof MinecraftServer)) continue;
                zj2.a(fb2);
            }
        }
        if (m2 != minecraftServer && minecraftServer.d[0].U().b("logAdminCommands")) {
            minecraftServer.a(fb2);
        }
        boolean bl6 = minecraftServer.d[0].U().b("sendCommandFeedback");
        if (m2 instanceof ahj) {
            bl6 = ((ahj)m2).n();
        }
        if ((n2 & 1) != 1 && bl6 || m2 instanceof MinecraftServer) {
            m2.a(new fb(string, arrobject));
        }
    }

    @Override
    protected MinecraftServer a() {
        return this.a;
    }
}
