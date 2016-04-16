// NetHandlerPlayClient

/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Maps
 *  com.google.common.util.concurrent.FutureCallback
 *  com.google.common.util.concurrent.Futures
 *  com.google.common.util.concurrent.ListenableFuture
 *  com.mojang.authlib.GameProfile
 *  io.netty.buffer.ByteBuf
 *  io.netty.buffer.Unpooled
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.mojang.authlib.GameProfile;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import net.minecraft.client.ClientBrandRetriever;
import net.minecraft.realms.DisconnectedRealmsScreen;
import net.minecraft.realms.RealmsScreen;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class bkp
implements fi {
    private static final Logger b = LogManager.getLogger();
    private final ek c;
    private final GameProfile d;
    private final bey e;
    private bcc f;
    private bkr g;
    private boolean h;
    private final Map<UUID, bks> i = Maps.newHashMap();
    public int a = 20;
    private boolean j = false;
    private final Random k = new Random();

    public bkp(bcc bcc2, bey bey2, ek ek2, GameProfile gameProfile) {
        this.f = bcc2;
        this.e = bey2;
        this.c = ek2;
        this.d = gameProfile;
    }

    public void b() {
        this.g = null;
    }

    @Override
    public void a(gs packetIn) {
        fh.a(packetIn, this, this.f);
        this.f.c = new bkq(this.f, this);
        this.g = new bkr(this, new ahw(0, packetIn.c(), false, packetIn.b(), packetIn.g()), packetIn.d(), packetIn.e(), this.f.B);
        this.f.u.ao = packetIn.e();
        this.f.a(this.g);
        this.f.h.am = packetIn.d();
        this.f.a(new bex(this));
        this.f.h.f(packetIn.a());
        this.a = packetIn.f();
        this.f.h.m(packetIn.h());
        this.f.c.a(packetIn.c());
        this.f.u.c();
        this.c.a(new iq("MC|Brand", new em(Unpooled.buffer()).a(ClientBrandRetriever.getClientModName())));
        
        // Packet Analysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S23(
                packetIn.a(),
                packetIn.c().a(), 
                packetIn.d(), 
                packetIn.e().ordinal(),
                packetIn.f(), 
                packetIn.g().c(), // getWorldTypeName()?
                packetIn.h());
    }

    @Override
    public void a(fj packetIn) {
        rr[] arrrr;
        fh.a(packetIn, this, this.f);
        double d2 = packetIn.c();
        double d3 = packetIn.d();
        double d4 = packetIn.e();
        rr rr2 = null;
        if (packetIn.k() == 10) {
            rr2 = aah.a(this.g, d2, d3, d4, aah.a.a(packetIn.l()));
        } else if (packetIn.k() == 90) {
            rr rr1 = this.g.a(packetIn.l());
            if (rr1 instanceof zj) {
                rr2 = new xw(this.g, d2, d3, d4, (zj)rr1);
            }
            packetIn.d(0);
        } else if (packetIn.k() == 60) {
            rr2 = new aad(this.g, d2, d3, d4);
        } else if (packetIn.k() == 91) {
            rr2 = new zx(this.g, d2, d3, d4);
        } else if (packetIn.k() == 61) {
            rr2 = new zw(this.g, d2, d3, d4);
        } else if (packetIn.k() == 71) {
            rr2 = new xs(this.g, new cj(d2, d3, d4), cq.b(packetIn.l()));
            packetIn.d(0);
        } else if (packetIn.k() == 77) {
            rr2 = new xt(this.g, new cj(on.c(d2), on.c(d3), on.c(d4)));
            packetIn.d(0);
        } else if (packetIn.k() == 65) {
            rr2 = new aaa(this.g, d2, d3, d4);
        } else if (packetIn.k() == 72) {
            rr2 = new zo(this.g, d2, d3, d4);
        } else if (packetIn.k() == 76) {
            rr2 = new zq(this.g, d2, d3, d4, null);
        } else if (packetIn.k() == 63) {
            rr2 = new zr(this.g, d2, d3, d4, (double)packetIn.f() / 8000.0, (double)packetIn.g() / 8000.0, (double)packetIn.h() / 8000.0);
            packetIn.d(0);
        } else if (packetIn.k() == 93) {
            rr2 = new zn(this.g, d2, d3, d4, (double)packetIn.f() / 8000.0, (double)packetIn.g() / 8000.0, (double)packetIn.h() / 8000.0);
            packetIn.d(0);
        } else if (packetIn.k() == 64) {
            rr2 = new zv(this.g, d2, d3, d4, (double)packetIn.f() / 8000.0, (double)packetIn.g() / 8000.0, (double)packetIn.h() / 8000.0);
            packetIn.d(0);
        } else if (packetIn.k() == 66) {
            rr2 = new aae(this.g, d2, d3, d4, (double)packetIn.f() / 8000.0, (double)packetIn.g() / 8000.0, (double)packetIn.h() / 8000.0);
            packetIn.d(0);
        } else if (packetIn.k() == 67) {
            rr2 = new zu(this.g, d2, d3, d4, (double)packetIn.f() / 8000.0, (double)packetIn.g() / 8000.0, (double)packetIn.h() / 8000.0);
            packetIn.d(0);
        } else if (packetIn.k() == 62) {
            rr2 = new zz(this.g, d2, d3, d4);
        } else if (packetIn.k() == 73) {
            rr2 = new aac(this.g, d2, d3, d4, null);
            packetIn.d(0);
        } else if (packetIn.k() == 75) {
            rr2 = new aab(this.g, d2, d3, d4);
            packetIn.d(0);
        } else if (packetIn.k() == 1) {
            rr2 = new aag(this.g, d2, d3, d4);
        } else if (packetIn.k() == 50) {
            rr2 = new ye(this.g, d2, d3, d4, null);
        } else if (packetIn.k() == 78) {
            rr2 = new xq(this.g, d2, d3, d4);
        } else if (packetIn.k() == 51) {
            rr2 = new wt(this.g, d2, d3, d4);
        } else if (packetIn.k() == 2) {
            rr2 = new yd(this.g, d2, d3, d4);
        } else if (packetIn.k() == 70) {
            rr2 = new yc(this.g, d2, d3, d4, ajt.c(packetIn.l() & 65535));
            packetIn.d(0);
        } else if (packetIn.k() == 3) {
            rr2 = new rp(this.g, d2, d3, d4);
        }
        if (rr2 != null) {
            lm.a(rr2, d2, d3, d4);
            rr2.w = (float)(packetIn.i() * 360) / 256.0f;
            rr2.v = (float)(packetIn.j() * 360) / 256.0f;
            arrrr = rr2.aR();
            if (arrrr != null) {
                int n2 = packetIn.a() - rr2.O();
                for (int i2 = 0; i2 < arrrr.length; ++i2) {
                    arrrr[i2].f(arrrr[i2].O() + n2);
                }
            }
            rr2.f(packetIn.a());
            rr2.a(packetIn.b());
            this.g.a(packetIn.a(), rr2);
            if (packetIn.l() > 0) {
                rr rr3;
                if ((packetIn.k() == 60 || packetIn.k() == 91) && (rr3 = this.g.a(packetIn.l() - 1)) instanceof sa && rr2 instanceof zm) {
                    ((zm)rr2).e = rr3;
                }
                rr2.i((double)packetIn.f() / 8000.0, (double)packetIn.g() / 8000.0, (double)packetIn.h() / 8000.0);
            }
        }
        
        if(ServerPacketData.enabled)
        {
            float rotationPitch = (float)(packetIn.i() * 360) / 256.0F;
            float rotationYaw = (float)(packetIn.j() * 360) / 256.0F;
            double velX = (double)packetIn.f() / 8000.0D;
            double velY = (double)packetIn.g() / 8000.0D;
            double velZ = (double)packetIn.h() / 8000.0D;
            ServerPacketData.display_S00(packetIn.a(), null, packetIn.k(), d2, d3, d4, rotationYaw, rotationPitch, packetIn.l(), velX, velY, velZ);
        }
    }

    @Override
    public void a(fk packetIn) {
        fh.a(packetIn, this, this.f);
        double d2 = packetIn.b();
        double d3 = packetIn.c();
        double d4 = packetIn.d();
        rx rx2 = new rx(this.g, d2, d3, d4, packetIn.e());
        lm.a(rx2, d2, d3, d4);
        rx2.v = 0.0f;
        rx2.w = 0.0f;
        rx2.f(packetIn.a());
        this.g.a(packetIn.a(), rx2);
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S01(
                packetIn.a(), 
                packetIn.b()/32.0D,
                packetIn.c()/32.0D,
                packetIn.d()/32.0D, 
                packetIn.e());
    }

    @Override
    public void a(fl packetIn) {
        fh.a(packetIn, this, this.f);
        double d2 = packetIn.b();
        double d3 = packetIn.c();
        double d4 = packetIn.d();
        ya ya2 = null;
        if (packetIn.e() == 1) {
            ya2 = new ya(this.g, d2, d3, d4, false);
        }
        if (ya2 != null) {
            lm.a(ya2, d2, d3, d4);
            ya2.v = 0.0f;
            ya2.w = 0.0f;
            ya2.f(packetIn.a());
            this.g.d(ya2);
        }
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.displayS02(packetIn.a(), packetIn.e(), d2, d3, d4);
    }

    @Override
    public void a(fn packetIn) {
        fh.a(packetIn, this, this.f);
        xu xu2 = new xu(this.g, packetIn.c(), packetIn.d(), packetIn.e());
        xu2.a(packetIn.b());
        this.g.a(packetIn.a(), xu2);
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S04(packetIn.a(), null, packetIn.e(), packetIn.c(), packetIn.d().name());
    }

    @Override
    public void a(hn packetIn) {
        fh.a(packetIn, this, this.f);
        rr rr2 = this.g.a(packetIn.a());
        if (rr2 == null) {
            return;
        }
        rr2.i((double)packetIn.b() / 8000.0, (double)packetIn.c() / 8000.0, (double)packetIn.d() / 8000.0);
    
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S3B(
                packetIn.a(),
                (double)packetIn.b() / 8000.0D,
                (double)packetIn.c() / 8000.0D,
                (double)packetIn.d() / 8000.0D);
    }

    @Override
    public void a(hl packetIn) {
        fh.a(packetIn, this, this.f);
        rr rr2 = this.g.a(packetIn.b());
        if (rr2 != null && packetIn.a() != null) {
            rr2.R().a(packetIn.a());
        }
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S39(packetIn.b(), null);
    }

    @Override
    public void a(fo packetIn) {
        fh.a(packetIn, this, this.f);
        double d2 = packetIn.d();
        double d3 = packetIn.e();
        double d4 = packetIn.f();
        float f2 = (float)(packetIn.g() * 360) / 256.0f;
        float f3 = (float)(packetIn.h() * 360) / 256.0f;
        bmr bmr2 = new bmr(this.f.f, this.a(packetIn.c()).a());
        bmr2.m = bmr2.M = d2;
        bmr2.n = bmr2.N = d3;
        bmr2.o = bmr2.O = d4;
        lm.a(bmr2, d2, d3, d4);
        bmr2.a(d2, d3, d4, f2, f3);
        this.g.a(packetIn.b(), bmr2);
        List list = packetIn.a();
        if (list != null) {
            bmr2.R().a(list);
        }

        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S05(packetIn.b(), packetIn.c(), d2, d3, d4, f2, f3, packetIn.a());
    }

    @Override
    public void a(ic packetIn) {
        fh.a(packetIn, this, this.f);
        rr rr2 = this.g.a(packetIn.a());
        if (rr2 == null) {
            return;
        }
        double d2 = packetIn.b();
        double d3 = packetIn.c();
        double d4 = packetIn.d();
        lm.a(rr2, d2, d3, d4);
        if (!rr2.bx()) {
            float f2 = (float)(packetIn.e() * 360) / 256.0f;
            float f3 = (float)(packetIn.f() * 360) / 256.0f;
            if (Math.abs(rr2.p - d2) >= 0.03125 || Math.abs(rr2.q - d3) >= 0.015625 || Math.abs(rr2.r - d4) >= 0.03125) {
                rr2.a(d2, d3, d4, f2, f3, 3, true);
            } else {
                rr2.a(rr2.p, rr2.q, rr2.r, f2, f3, 0, true);
            }
            rr2.z = packetIn.g();
            
            // PacketAnalysis
            if(ServerPacketData.enabled)
            ServerPacketData.display_S4A(packetIn.a(), d2, d3, d4, f2, f3, rr2.z);
        } 
        else if(ServerPacketData.enabled)
        {
            ServerPacketData.display_S4A(-1, 0, 0, 0, 0F, 0F, false);
        }
    }

    @Override
    public void a(hj packetIn) {
        fh.a(packetIn, this, this.f);
        if (zi.e(packetIn.a())) {
            this.f.h.br.d = packetIn.a();
        }
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S37(packetIn.a());
    }

    @Override
    public void a(gu packetIn) {
        fh.a(packetIn, this, this.f);
        rr rr2 = packetIn.a(this.g);
        if (rr2 == null) {
            return;
        }
        rr2.ae += (long)packetIn.a();
        rr2.af += (long)packetIn.b();
        rr2.ag += (long)packetIn.c();
        double d2 = (double)rr2.ae / 4096.0;
        double d3 = (double)rr2.af / 4096.0;
        double d4 = (double)rr2.ag / 4096.0;
        
        float f2 = 0F, f3 = 0F; 
        if (!rr2.bx()) {
            f2 = packetIn.f() ? (float)(packetIn.d() * 360) / 256.0f : rr2.v;
            f3 = packetIn.f() ? (float)(packetIn.e() * 360) / 256.0f : rr2.w;
            rr2.a(d2, d3, d4, f2, f3, 3, false);
            rr2.z = packetIn.g();
        }
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        {
            if(packetIn instanceof gu.c) // Rotation
                ServerPacketData.display_S26(
                        rr2.O(), 
                        f2, f3,
                        ((gu.c)packetIn).g);
            else if(packetIn instanceof gu.a) // Movement
                ServerPacketData.display_S25(
                        rr2.O(),
                        d2, d3, d4, ((gu.a)packetIn).g);
            else if(packetIn instanceof gu.b) // Both
                ServerPacketData.display_S27(
                        rr2.O(), 
                        d2, d3, d4,
                        f2, f3, ((gu.b)packetIn).g);
            else
                ServerPacketData.display_S28(rr2.O());
        }
    }

    @Override
    public void a(hg packetIn) {
        fh.a(packetIn, this, this.f);
        rr rr2 = packetIn.a(this.g);
        if (rr2 == null) {
            return;
        }
        float f2 = (float)(packetIn.a() * 360) / 256.0f;
        rr2.h(f2);
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S34(rr2.O(), f2);
    }

    @Override
    public void a(hc packetIn) {
        fh.a(packetIn, this, this.f);
        
        // PacketAnalysis
        // Display the content before destroying the entities
        if(ServerPacketData.enabled)
        ServerPacketData.display_S30(packetIn.a().length, packetIn.a());
        
        for (int i2 = 0; i2 < packetIn.a().length; ++i2) {
            this.g.e(packetIn.a()[i2]);
        }
    }

    @Override
    public void a(ha packetIn) {
        fh.a(packetIn, this, this.f);
        bmq bmq2 = this.f.h;
        double d2 = packetIn.a();
        double d3 = packetIn.b();
        double d4 = packetIn.c();
        float f2 = packetIn.d();
        float f3 = packetIn.e();
        if (packetIn.g().contains((Object)ha.a.a)) {
            d2 += bmq2.p;
        } else {
            bmq2.s = 0.0;
        }
        if (packetIn.g().contains((Object)ha.a.b)) {
            d3 += bmq2.q;
        } else {
            bmq2.t = 0.0;
        }
        if (packetIn.g().contains((Object)ha.a.c)) {
            d4 += bmq2.r;
        } else {
            bmq2.u = 0.0;
        }
        if (packetIn.g().contains((Object)ha.a.e)) {
            f3 += bmq2.w;
        }
        if (packetIn.g().contains((Object)ha.a.d)) {
            f2 += bmq2.v;
        }
        bmq2.a(d2, d3, d4, f2, f3);
        this.c.a(new ih(packetIn.f()));
        this.c.a(new it.b(bmq2.p, bmq2.bl().b, bmq2.r, bmq2.v, bmq2.w, false));
        if (!this.h) {
            this.f.h.m = this.f.h.p;
            this.f.h.n = this.f.h.q;
            this.f.h.o = this.f.h.r;
            this.h = true;
            this.f.a((bey)null);
        }
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S2E(
                d2, d3, d4, f2, f3,
                packetIn.g().toString(), null
                );
    }

    @Override
    public void a(fz packetIn) {
        fh.a(packetIn, this, this.f);
        for (fz.a a2 : packetIn.a()) {
            this.g.b(a2.a(), a2.c());
        }
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S10(packetIn.a());
    }

    @Override
    public void a(gp packetIn) {
        fh.a(packetIn, this, this.f);
        if (packetIn.e()) {
            this.g.b(packetIn.b(), packetIn.c(), true);
        }
        this.g.a(packetIn.b() << 4, 0, packetIn.c() << 4, (packetIn.b() << 4) + 15, 256, (packetIn.c() << 4) + 15);
        ase ase2 = this.g.a(packetIn.b(), packetIn.c());
        ase2.a(packetIn.a(), packetIn.d(), packetIn.e());
        this.g.b(packetIn.b() << 4, 0, packetIn.c() << 4, (packetIn.b() << 4) + 15, 256, (packetIn.c() << 4) + 15);
        if (!packetIn.e() || !(this.g.s instanceof asx)) {
            ase2.m();
        }
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S20(
                packetIn.b(), packetIn.c(),
                packetIn.e(), packetIn.d(),
                0, null, null);
    }

    @Override
    public void a(gm packetIn) {
        fh.a(packetIn, this, this.f);
        this.g.b(packetIn.a(), packetIn.b(), false);
        
        // UNLISTED PACKET: Unload Chunk
        // PacketAnalysis
        
    }

    @Override
    public void a(fu packetIn) {
        fh.a(packetIn, this, this.f);
        this.g.b(packetIn.b(), packetIn.a());
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S0B(packetIn.b(), packetIn.a());
    }

    @Override
    public void a(gj packetIn) {
        this.c.a(packetIn.a());
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S1A(packetIn.a());
    }

    @Override
    public void a(eu eu2) { // onDisconnect(IChatComponent reason)
        this.f.a((bkr)null);
        if (this.e != null) {
            if (this.e instanceof bdw) {
                this.f.a(new DisconnectedRealmsScreen(((bdw)this.e).a(), "disconnect.lost", eu2).getProxy());
            } else {
                this.f.a(new bem(this.e, "disconnect.lost", eu2));
            }
        } else {
            this.f.a(new bem(new bgo(new bff()), "disconnect.lost", eu2));
        }
    }

    public void a(ff<?> ff2) { // addToSendQueue(Packet p_147297_1_)
        this.c.a(ff2);
    }

    @Override
    public void a(ib packetIn) {
        fh.a(packetIn, this, this.f);
        rr rr2 = this.g.a(packetIn.a());
        sa sa2 = (sa)this.g.a(packetIn.b());
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S49(packetIn.b(), packetIn.a());
        
        if (sa2 == null) {
            sa2 = this.f.h;
        }
        if (rr2 != null) {
            if (rr2 instanceof rx) {
                this.g.a(rr2.p, rr2.q, rr2.r, ng.bi, nh.h, 0.2f, ((this.k.nextFloat() - this.k.nextFloat()) * 0.7f + 1.0f) * 2.0f, false);
            } else {
                this.g.a(rr2.p, rr2.q, rr2.r, ng.cV, nh.h, 0.2f, ((this.k.nextFloat() - this.k.nextFloat()) * 0.7f + 1.0f) * 2.0f, false);
            }
            this.f.j.a(new blp(this.g, rr2, sa2, 0.5f));
            this.g.e(packetIn.a());
        }
    }

    @Override
    public void a(fy packetIn) {
        fh.a(packetIn, this, this.f);
        if (packetIn.c() == 2) {
            this.f.r.a(packetIn.a(), false);
        } else {
            this.f.r.d().a(packetIn.a());
        }
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S0F(packetIn.a(), packetIn.c());
    }

    @Override
    public void a(fp packetIn) {
        fh.a(packetIn, this, this.f);
        rr rr2 = this.g.a(packetIn.a());
        if (rr2 == null) {
            return;
        }
        if (packetIn.b() == 0) {
            sa sa2 = (sa)rr2;
            sa2.a(qm.a);
        } else if (packetIn.b() == 3) {
            sa sa3 = (sa)rr2;
            sa3.a(qm.b);
        } else if (packetIn.b() == 1) {
            rr2.aD();
        } else if (packetIn.b() == 2) {
            zj zj2 = (zj)rr2;
            zj2.a(false, false, false);
        } else if (packetIn.b() == 4) {
            this.f.j.a(rr2, cy.j);
        } else if (packetIn.b() == 5) {
            this.f.j.a(rr2, cy.k);
        }
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S06(packetIn.a(), packetIn.b());
    }

    @Override
    public void a(hb packetIn) {
        fh.a(packetIn, this, this.f);
        packetIn.a(this.g).a(packetIn.a());
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S2F(packetIn.a(this.g), packetIn.a());
    }

    @Override
    public void a(fm packetIn) {
        fh.a(packetIn, this, this.f);
        double d2 = packetIn.e();
        double d3 = packetIn.f();
        double d4 = packetIn.g();
        float f2 = (float)(packetIn.k() * 360) / 256.0f;
        float f3 = (float)(packetIn.l() * 360) / 256.0f;
        sa sa2 = (sa)rt.a(packetIn.d(), (aht)this.f.f);
        lm.a(sa2, d2, d3, d4);
        sa2.aM = sa2.aO = (float)(packetIn.m() * 360) / 256.0f;
        rr[] arrrr = sa2.aR();
        if (arrrr != null) {
            int n2 = packetIn.b() - sa2.O();
            for (int i2 = 0; i2 < arrrr.length; ++i2) {
                arrrr[i2].f(arrrr[i2].O() + n2);
            }
        }
        sa2.f(packetIn.b());
        sa2.a(packetIn.c());
        sa2.a(d2, d3, d4, f2, f3);
        sa2.s = (float)packetIn.h() / 8000.0f;
        sa2.t = (float)packetIn.i() / 8000.0f;
        sa2.u = (float)packetIn.j() / 8000.0f;
        this.g.a(packetIn.b(), sa2);
        List list = packetIn.a();
        if (list != null) {
            sa2.R().a(list);
        }
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        {
            float velX = (float)packetIn.h() / 8000.0f;
            float velY = (float)packetIn.i() / 8000.0f;
            float velZ = (float)packetIn.j() / 8000.0f;
            float headRot = (float)(packetIn.m() * 360) / 256.0f;
            
            ServerPacketData.display_S03(
                    packetIn.b(), packetIn.c(), packetIn.d(),
                    d2, d3, d4, f2, f3, headRot, velX, velY, velZ, packetIn.a());
        }
    }

    @Override
    public void a(hw packetIn) {
        fh.a(packetIn, this, this.f);
        this.f.f.a(packetIn.a());
        this.f.f.b(packetIn.b());
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S44(packetIn.a(), packetIn.b());
    }

    @Override
    public void a(hv packetIn) {
        fh.a(packetIn, this, this.f);
        this.f.h.a(packetIn.a(), true);
        this.f.f.T().a(packetIn.a());
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S43(packetIn.a());
    }

    @Override
    public void a(hs packetIn) {
        fh.a(packetIn, this, this.f);
        rr rr2 = this.g.a(packetIn.b());
        if (rr2 == null) {
            b.warn("Received passengers for unknown entity");
            return;
        }
        boolean bl2 = rr2.y(this.f.h);
        rr2.az();
        for (int n2 : packetIn.a()) {
            rr rr3 = this.g.a(n2);
            if (rr3 == null) {
                b.warn("Received unknown passenger for " + rr2);
                continue;
            }
            rr3.a(rr2, true);
            if (rr3 != this.f.h || bl2) continue;
            this.f.r.a(bwl.a("mount.onboard", bce.c(this.f.u.V.j())), false);
        }
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S40(packetIn.b(), packetIn.a());
    }

    @Override
    public void a(hm packetIn) {
        fh.a(packetIn, this, this.f);
        rr rr2 = this.g.a(packetIn.a());
        rr rr3 = this.g.a(packetIn.b());
        if (rr2 instanceof sb) {
            if (rr3 != null) {
                ((sb)rr2).b(rr3, false);
            } else {
                ((sb)rr2).a(false, false); // leashing
            }
        }
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S3A(packetIn.a(), packetIn.b());
    }

    @Override
    public void a(gk packetIn) {
        fh.a(packetIn, this, this.f);
        rr rr2 = packetIn.a(this.g);
        if (rr2 != null) {
            if (packetIn.a() == 21) {
                this.f.U().a(new bxz((yo)rr2));
            } else {
                rr2.a(packetIn.a());
            }
            
            // PacketAnalysis
            if(ServerPacketData.enabled)
            ServerPacketData.display_S1B(rr2.O(), packetIn.a());
        }
        else if(ServerPacketData.enabled)
        {
            ServerPacketData.display_S1B(-1, -1);
        }
    }

    @Override
    public void a(hq packetIn) {
        fh.a(packetIn, this, this.f);
        this.f.h.p(packetIn.a());
        this.f.h.cS().a(packetIn.b());
        this.f.h.cS().b(packetIn.c());
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S3E(
                packetIn.a(),
                packetIn.b(),
                packetIn.c());
    }

    @Override
    public void a(hp packetIn) {
        fh.a(packetIn, this, this.f);
        this.f.h.a(packetIn.a(), packetIn.b(), packetIn.c());
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S3D(packetIn.a(), packetIn.b(), packetIn.c());
    }

    @Override
    public void a(hf packetIn) {
        fh.a(packetIn, this, this.f);
        if (packetIn.a() != this.f.h.am) {
            this.h = false;
            bbm bbm2 = this.g.ad();
            this.g = new bkr(this, new ahw(0, packetIn.c(), false, this.f.f.T().s(), packetIn.d()), packetIn.a(), packetIn.b(), this.f.B);
            this.g.a(bbm2);
            this.f.a(this.g);
            this.f.h.am = packetIn.a();
            this.f.a(new bex(this));
        }
        this.f.a(packetIn.a());
        this.f.c.a(packetIn.c());
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S33(
                packetIn.a(),
                packetIn.b().ordinal(),
                packetIn.c().a(),
                packetIn.d().a());
    }

    @Override
    public void a(gl packetIn) {
        fh.a(packetIn, this, this.f);
        ahp ahp2 = new ahp(this.f.f, null, packetIn.d(), packetIn.e(), packetIn.f(), packetIn.g(), packetIn.h());
        ahp2.a(true);
        this.f.h.s += (double)packetIn.a();
        this.f.h.t += (double)packetIn.b();
        this.f.h.u += (double)packetIn.c();
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S1C(
                packetIn.d(), packetIn.e(), packetIn.f(), 
                packetIn.g(), packetIn.h(),
                packetIn.a(), packetIn.b(), packetIn.c());
    }

    @Override
    public void a(gc packetIn) {
        fh.a(packetIn, this, this.f);
        bmq bmq2 = this.f.h;
        if ("minecraft:container".equals(packetIn.b())) {
            bmq2.a(new qv(packetIn.c(), packetIn.d()));
            bmq2.bt.d = packetIn.a();
        } else if ("minecraft:villager".equals(packetIn.b())) {
            bmq2.a(new zc(bmq2, packetIn.c()));
            bmq2.bt.d = packetIn.a();
        } else if ("EntityHorse".equals(packetIn.b())) {
            rr rr2 = this.g.a(packetIn.e());
            if (rr2 instanceof wk) {
                bmq2.a((wk)rr2, new aav(packetIn.c(), packetIn.d()));
                bmq2.bt.d = packetIn.a();
            }
        } else if (!packetIn.f()) {
            bmq2.a(new bms(packetIn.b(), packetIn.c()));
            bmq2.bt.d = packetIn.a();
        } else {
            bmt bmt2 = new bmt(packetIn.b(), packetIn.c(), packetIn.d());
            bmq2.a((qg)bmt2);
            bmq2.bt.d = packetIn.a();
        }
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S13(
                packetIn.a(), // id
                packetIn.b(), // type
                packetIn.c(), // title
                packetIn.d(), // slotNum
                packetIn.e()  // entityID
                );
    }

    @Override
    public void a(gf packetIn) {
        fh.a(packetIn, this, this.f);
        bmq bmq2 = this.f.h;
        if (packetIn.a() == -1) {
            bmq2.br.e(packetIn.c());
        } else if (packetIn.a() == -2) {
            bmq2.br.a(packetIn.b(), packetIn.c());
        } else {
            Object object;
            boolean bl2 = false;
            if (this.f.m instanceof bfz) {
                bfz object1 = (bfz)this.f.m;
                boolean bl3 = bl2 = object1.f() != acq.m.a();
            }
            if (packetIn.a() == 0 && packetIn.b() >= 36 && packetIn.b() < 45) {
                adq object1 = bmq2.bs.a(packetIn.b()).d();
                if (packetIn.c() != null && (object1 == null || object1.b < packetIn.c().b)) {
                    packetIn.c().c = 5;
                }
                bmq2.bs.a(packetIn.b(), packetIn.c());
            } else if (!(packetIn.a() != bmq2.bt.d || packetIn.a() == 0 && bl2)) {
                bmq2.bt.a(packetIn.b(), packetIn.c());
            }
        }
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S16(packetIn.a(), packetIn.b(), packetIn.c());
    }

    @Override
    public void a(ga packetIn) {
        fh.a(packetIn, this, this.f);
        aau aau2 = null;
        bmq bmq2 = this.f.h;
        if (packetIn.a() == 0) {
            aau2 = bmq2.bs;
        } else if (packetIn.a() == bmq2.bt.d) {
            aau2 = bmq2.bt;
        }
        if (aau2 != null && !packetIn.c()) {
            this.a(new im(packetIn.a(), packetIn.b(), true));
        }

        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S11(packetIn.a(), packetIn.b(), packetIn.c());
    }

    @Override
    public void a(gd packetIn) {
        fh.a(packetIn, this, this.f);
        bmq bmq2 = this.f.h;
        if (packetIn.a() == 0) {
            bmq2.bs.a(packetIn.b());
        } else if (packetIn.a() == bmq2.bt.d) {
            bmq2.bt.a(packetIn.b());
        }

        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S14(packetIn.a(), packetIn.b());
    }

    @Override
    public void a(gw packetIn) {
        fh.a(packetIn, this, this.f);
        apv apv2 = this.g.r(packetIn.a());
        if (!(apv2 instanceof aqn)) {
            apv2 = new aqn();
            apv2.a(this.g);
            apv2.a(packetIn.a());
        }
        this.f.h.a((aqn)apv2);
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S2A(packetIn.a());
    }

    @Override
    public void a(hy packetIn) {
        apv apv2;
        fh.a(packetIn, this, this.f);
        boolean bl2 = false;
        if (this.f.f.e(packetIn.a()) && (apv2 = this.f.f.r(packetIn.a())) instanceof aqn) {
            aqn aqn2 = (aqn)apv2;
            if (aqn2.b()) {
                System.arraycopy(packetIn.b(), 0, aqn2.a, 0, 4);
                aqn2.v_();
            }
            bl2 = true;
        }
        if (!bl2 && this.f.h != null) {
            b.debug("Unable to locate sign at " + packetIn.a().p() + ", " + packetIn.a().q() + ", " + packetIn.a().r());
        }

        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S46(packetIn.a(), packetIn.b());
    }

    @Override
    public void a(fs packetIn) {
        fh.a(packetIn, this, this.f);
        if (this.f.f.e(packetIn.a())) {
            boolean bl2;
            apv apv2 = this.f.f.r(packetIn.a());
            int n2 = packetIn.b();
            boolean bl3 = bl2 = n2 == 2 && apv2 instanceof apy;
            if (n2 == 1 && apv2 instanceof aqk || bl2 || n2 == 3 && apv2 instanceof apu || n2 == 4 && apv2 instanceof aqo || n2 == 5 && apv2 instanceof aqf || n2 == 6 && apv2 instanceof apt || n2 == 7 && apv2 instanceof aqp || n2 == 8 && apv2 instanceof aqq) {
                apv2.a(packetIn.c());
            }
            if (bl2 && this.f.m instanceof bfv) {
                ((bfv)this.f.m).a();
            }
        }

        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S09(packetIn.a(), packetIn.b(), packetIn.c());
    }

    @Override
    public void a(ge packetIn) {
        fh.a(packetIn, this, this.f);
        bmq bmq2 = this.f.h;
        if (bmq2.bt != null && bmq2.bt.d == packetIn.a()) {
            bmq2.bt.b(packetIn.b(), packetIn.c());
        }
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S15(packetIn.a(), packetIn.b(), packetIn.c());
    }

    @Override
    public void a(ho packetIn) {
        fh.a(packetIn, this, this.f);
        rr rr2 = this.g.a(packetIn.b());
        if (rr2 != null) {
            rr2.a(packetIn.c(), packetIn.a());
        }
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S3C(
                packetIn.b(), 
                packetIn.c().name(), 
                packetIn.a());
    }

    @Override
    public void a(gb packetIn) {
        fh.a(packetIn, this, this.f);
        this.f.h.B();
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S12();
    }

    @Override
    public void a(ft packetIn) {
        fh.a(packetIn, this, this.f);
        this.f.f.c(packetIn.a(), packetIn.d(), packetIn.b(), packetIn.c());
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S0A(packetIn.a(), packetIn.d(), packetIn.b(), packetIn.c());
    }

    @Override
    public void a(fr packetIn) {
        fh.a(packetIn, this, this.f);
        this.f.f.c(packetIn.a(), packetIn.b(), packetIn.c());
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S08(packetIn.a(), packetIn.b(), packetIn.c());
    }
    
    @Override
    public void a(gn packetIn) {
        fh.a(packetIn, this, this.f);
        bmq bmq2 = this.f.h;
        int n2 = packetIn.a();
        float f2 = packetIn.b();
        int n3 = on.d(f2 + 0.5f);
        if (n2 >= 0 && n2 < gn.a.length && gn.a[n2] != null) {
            bmq2.b(new fb(gn.a[n2], new Object[0]));
        }
        if (n2 == 1) {
            this.g.T().b(true);
            this.g.k(0.0f);
        } else if (n2 == 2) {
            this.g.T().b(false);
            this.g.k(1.0f);
        } else if (n2 == 3) {
            this.f.c.a(ahw.a.a(n3));
        } else if (n2 == 4) {
            if (n3 == 0) {
                this.f.h.d.a(new ik(ik.a.a));
                this.f.a(new bex(this));
            } else if (n3 == 1) {
                this.f.a(new bfh());
            }
        } else if (n2 == 5) {
            bce bce2 = this.f.u;
            if (f2 == 0.0f) {
                this.f.a(new bek());
            } else if (f2 == 101.0f) {
                this.f.r.d().a(new fb("demo.help.movement", bce.c(bce2.Q.j()), bce.c(bce2.R.j()), bce.c(bce2.S.j()), bce.c(bce2.T.j())));
            } else if (f2 == 102.0f) {
                this.f.r.d().a(new fb("demo.help.jump", bce.c(bce2.U.j())));
            } else if (f2 == 103.0f) {
                this.f.r.d().a(new fb("demo.help.inventory", bce.c(bce2.X.j())));
            }
        } else if (n2 == 6) {
            this.g.a(bmq2, bmq2.p, bmq2.q + (double)bmq2.bn(), bmq2.r, ng.u, nh.h, 0.18f, 0.45f);
        } else if (n2 == 7) {
            this.g.k(f2);
        } else if (n2 == 8) {
            this.g.i(f2);
        } else if (n2 == 10) {
            this.g.a(cy.P, bmq2.p, bmq2.q, bmq2.r, 0.0, 0.0, 0.0, new int[0]);
            this.g.a(bmq2, bmq2.p, bmq2.q, bmq2.r, ng.aF, nh.f, 1.0f, 1.0f);
        }
    
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S1E(n2, f2);
    }

    @Override
    public void a(gt packetIn) {
        fh.a(packetIn, this, this.f);
        ayy ayy2 = adw.a(packetIn.a(), this.f.f);
        packetIn.a(ayy2);
        this.f.o.k().a(ayy2);
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S24(packetIn.a());
    }

    @Override
    public void a(gq packetIn) {
        fh.a(packetIn, this, this.f);
        if (packetIn.a()) {
            this.f.f.a(packetIn.b(), packetIn.d(), packetIn.c());
        } else {
            this.f.f.b(packetIn.b(), packetIn.d(), packetIn.c());
        }
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S21(packetIn.b(), packetIn.d(), packetIn.c(), packetIn.a());
    }

    @Override
    public void a(fq packetIn) {
        fh.a(packetIn, this, this.f);
        boolean bl2 = false;
        for (Map.Entry<np, Integer> entry : packetIn.a().entrySet()) {
            np np2 = entry.getKey();
            int n2 = entry.getValue();
            if (np2.d() && n2 > 0) {
                if (this.j && this.f.h.G().a(np2) == 0) {
                    nj nj2 = (nj)np2;
                    this.f.q.a(nj2);
                    if (np2 == nk.f) {
                        this.f.u.I = false;
                        this.f.u.b();
                    }
                }
                bl2 = true;
            }
            this.f.h.G().a(this.f.h, np2, n2);
        }
        if (!this.j && !bl2 && this.f.u.I) {
            this.f.q.b(nk.f);
        }
        this.j = true;
        if (this.f.m instanceof bfl) {
            ((bfl)((Object)this.f.m)).a();
        }
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S07();
    }

    @Override
    public void a(ie packetIn) {
        fh.a(packetIn, this, this.f);
        rr rr2 = this.g.a(packetIn.b());
        if (!(rr2 instanceof sa)) {
            return;
        }
        rk rk2 = rk.a(packetIn.c());
        if (rk2 == null) {
            return;
        }
        rl rl2 = new rl(rk2, packetIn.e(), packetIn.d(), packetIn.g(), packetIn.f());
        rl2.b(packetIn.a());
        ((sa)rr2).c(rl2);
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S4C(
                packetIn.b(), rk2.a(),
                packetIn.e(), packetIn.d(), packetIn.g(),
                packetIn.f());
    }

    // CombatEvent is only used for "deathScreen.title"
    @Override
    public void a(gy packetIn) {
        rr rr2;
        fh.a(packetIn, this, this.f);
        if (packetIn.a == Namepipe.gy_a.c && (rr2 = this.g.a(packetIn.b)) == this.f.h) {
            this.f.a(new bej(packetIn.e)); // bej : - GuiDeathScreen -
        }
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S2C(
                packetIn.a.name(), // event
                packetIn.b, // entityID 
                packetIn.e  // message
                );
    }

    @Override
    public void a(fw packetIn) {
        fh.a(packetIn, this, this.f);
        this.f.f.T().a(packetIn.b());
        this.f.f.T().e(packetIn.a());
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S0D(packetIn.b().ordinal(), packetIn.a());
    }

    @Override
    public void a(hi packetIn) {
        fh.a(packetIn, this, this.f);
        rr rr2 = packetIn.a(this.g);
        if (rr2 != null) {
            this.f.a(rr2);
        }
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S36(rr2.O());
    }

    @Override
    public void a(hh packetIn) {
        fh.a(packetIn, this, this.f);
        packetIn.a(this.g.aj());
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S35();
    }

    @Override
    public void a(hx packetIn) {
        fh.a(packetIn, this, this.f);
        hx.a a2 = packetIn.a();
        String string = null;
        String string2 = null;
        String string3 = packetIn.b() != null ? packetIn.b().d() : "";
        switch (a2) {
            case a: {
                string = string3;
                break;
            }
            case b: {
                string2 = string3;
                break;
            }
            case e: {
                this.f.r.a("", "", -1, -1, -1);
                this.f.r.a();
                return;
            }
        }
        this.f.r.a(string, string2, packetIn.c(), packetIn.d(), packetIn.e());
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S45(a2.name(), string, string2, packetIn.c(), packetIn.d(), packetIn.e());
    }
    
    @Override
    public void a(ia packetIn) {
        this.f.r.h().b(packetIn.a().d().isEmpty() ? null : packetIn.a());
        this.f.r.h().a(packetIn.b().d().isEmpty() ? null : packetIn.b());
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S48(packetIn.a(), packetIn.b());
    }

    @Override
    public void a(hd packetIn) {
        fh.a(packetIn, this, this.f);
        rr rr2 = packetIn.a(this.g);
        if (rr2 instanceof sa) {
            ((sa)rr2).c(packetIn.a());
        
            // PacketAnalysis
            if(ServerPacketData.enabled)
            ServerPacketData.display_S31(rr2.O(), packetIn.a().a());
        }
    }

    @Override
    public void a(gz packetIn) {
        fh.a(packetIn, this, this.f);
        
        // PacketAnalysis
        String actions = "";
        String uuids = "";
        
        for (gz.b b2 : packetIn.a()) {
            
            // PacketAnalysis
            actions += packetIn.b().name() + "\n";
            uuids += b2.a().getId() + "\n";
            
            if (packetIn.b() == gz.a.e) {
                this.i.remove(b2.a().getId());
                continue;
            }
            bks bks2 = this.i.get(b2.a().getId());
            if (packetIn.b() == gz.a.a) {
                bks2 = new bks(b2);
                this.i.put(bks2.a().getId(), bks2);
            }
            if (bks2 == null) continue;
            switch (packetIn.b()) {
                case a: {
                    bks2.a(b2.c());
                    bks2.a(b2.b());
                    break;
                }
                case b: {
                    bks2.a(b2.c());
                    break;
                }
                case c: {
                    bks2.a(b2.b());
                    break;
                }
                case d: {
                    bks2.a(b2.d());
                }
            }
        }
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S2D(uuids.split("\n"), actions.split("\n")); 
    }

    @Override
    public void a(go packetIn) {
        this.a(new is(packetIn.a()));
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.displayS1F(packetIn.a());
    }

    @Override
    public void a(gx packetIn) {
        fh.a(packetIn, this, this.f);
        bmq bmq2 = this.f.h;
        bmq2.bJ.b = packetIn.b();
        bmq2.bJ.d = packetIn.d();
        bmq2.bJ.a = packetIn.a();
        bmq2.bJ.c = packetIn.c();
        bmq2.bJ.a(packetIn.e());
        bmq2.bJ.b(packetIn.f());
    
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S2B(
                packetIn.b(), packetIn.d(),
                packetIn.a(), packetIn.c(),
                packetIn.e(), packetIn.f()
                );
    }

    @Override
    public void a(fx packetIn) {
        fh.a(packetIn, this, this.f);
        String[] arrstring = packetIn.a();
        if (this.f.m instanceof bfd) {
            ((bfd)((Object)this.f.m)).a(arrstring);
        }
        
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S0E(packetIn.a());
    }

    @Override
    public void a(hz packetIn) {
        fh.a(packetIn, this, this.f);
        this.f.f.a(this.f.h, packetIn.c(), packetIn.d(), packetIn.e(), packetIn.a(), packetIn.b(), packetIn.f(), packetIn.g());
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S19(packetIn.c(), packetIn.d(), packetIn.e(), packetIn.a().a().toString(), packetIn.b().name(), packetIn.f(), packetIn.g());
    }

    @Override
    public void a(gi packetIn) {
        fh.a(packetIn, this, this.f);
        this.f.U().a(new byc(new kk(packetIn.a()), packetIn.b(), packetIn.f(), packetIn.g(), false, 0, byg.a.b, (float)packetIn.c(), (float)packetIn.d(), (float)packetIn.e()));
    
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S47(
                packetIn.c(), packetIn.d(), packetIn.e(), 
                packetIn.a(), packetIn.b().name(), 
                packetIn.f(), packetIn.g());
    }

    @Override
    public void a(he packetIn) {
        String string;
        final String string2 = packetIn.a();
        if (!this.a(string2, string = packetIn.b())) {
            return;
        }
        if (string2.startsWith("level://")) {
            File file = new File(this.f.w, "saves");
            String string3 = string2.substring("level://".length());
            File file2 = new File(file, string3);
            if (file2.isFile()) {
                this.c.a(new ja(string, ja.a.d));
                Futures.addCallback(this.f.P().a(file2), this.b(string));
            } else {
                this.c.a(new ja(string, ja.a.c));
            }
            return;
        }
        if (this.f.C() != null && this.f.C().b() == Namepipe.bku_a.a) {
            this.c.a(new ja(string, ja.a.d));
            Futures.addCallback(this.f.P().a(string2, string), this.b(string));
        } else if (this.f.C() == null || this.f.C().b() == Namepipe.bku_a.c) {
            this.f.a(new Runnable(){

                @Override
                public void run() {
                    bkp.this.f.a(new bee(new bed(){

                        @Override
                        public void a(boolean bl2, int n2) {
                            bkp.this.f = bcc.z();
                            if (bl2) {
                                if (bkp.this.f.C() != null) {
                                    bkp.this.f.C().a(Namepipe.bku_a.a);
                                }
                                bkp.this.c.a(new ja(string, ja.a.d));
                                Futures.addCallback(bkp.this.f.P().a(string2, string), (FutureCallback)bkp.this.b(string));
                            } else {
                                if (bkp.this.f.C() != null) {
                                    bkp.this.f.C().a(Namepipe.bku_a.b);
                                }
                                bkp.this.c.a(new ja(string, ja.a.b));
                            }
                            bkv.b(bkp.this.f.C());
                            bkp.this.f.a((bey)null);
                        }
                    }, bwl.a("multiplayer.texturePrompt.line1", new Object[0]), bwl.a("multiplayer.texturePrompt.line2", new Object[0]), 0));
                }

            });
        } else {
            this.c.a(new ja(string, ja.a.b));
        }     
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S32(packetIn.a(), packetIn.b());
    }

    private boolean a(String string, String string2) {
        try {
            URI uRI = new URI(string.replace(' ', '+'));
            String string3 = uRI.getScheme();
            boolean bl2 = "level".equals(string3);
            if (!("http".equals(string3) || "https".equals(string3) || bl2)) {
                throw new URISyntaxException(string, "Wrong protocol");
            }
            if (bl2 && (string.contains("..") || !string.endsWith("/resources.zip"))) {
                throw new URISyntaxException(string, "Invalid levelstorage resourcepack path");
            }
        }
        catch (URISyntaxException err) {
            this.c.a(new ja(string2, ja.a.c));
            return false;
        }
        return true;
    }

    private FutureCallback<Object> b(final String string) {
        return new FutureCallback<Object>(){

            public void onSuccess(Object object) {
                bkp.this.c.a(new ja(string, ja.a.a));
            }

            public void onFailure(Throwable throwable) {
                bkp.this.c.a(new ja(string, ja.a.c));
            }
        };
    }
    
    @Override
    public void a(fv packetIn) {
        fh.a(packetIn, this, this.f);
        this.f.r.j().a(packetIn);
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S0C(
                packetIn.a(), packetIn.b().name(), 
                packetIn.c(), packetIn.d(), 
                packetIn.e().name(), packetIn.f().name(),
                packetIn.g(), packetIn.h(), packetIn.i()
                );
    }
    
    @Override
    public void a(gg packetIn) {
        fh.a(packetIn, this, this.f);
        if (packetIn.b() == 0) {
            this.f.h.da().b(packetIn.a());
        } else {
            this.f.h.da().a(packetIn.a(), packetIn.b());
        }
        
        // Set Cooldown
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S17(packetIn.a().a(), packetIn.b());
    }
    
    @Override
    public void a(gv packetIn) {
        fh.a(packetIn, this, this.f);
        rr rr2 = this.f.h.bw();
        if (rr2 != this.f.h && rr2.bx()) {
            rr2.a(packetIn.a(), packetIn.b(), packetIn.c(), packetIn.d(), packetIn.e());
            this.c.a(new iu(rr2));
        }
        
        // Vehicle Move (clientbound)
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S29(packetIn.a(), packetIn.b(), packetIn.c(), packetIn.d(), packetIn.e());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void a(gh packetIn) {
        block13 : {
            fh.a(packetIn, this, this.f);
            if ("MC|TrList".equals(packetIn.a())) {
                em em2 = packetIn.b();
                try {
                    int n2 = em2.readInt();
                    bey bey2 = this.f.m;
                    if (bey2 != null && bey2 instanceof bgi && n2 == this.f.h.bt.d) {
                        ahf ahf2 = ((bgi)bey2).a();
                        ahh ahh2 = ahh.b(em2);
                        ahf2.a(ahh2);
                    }
                    break block13;
                }
                catch (IOException err) {
                    b.error("Couldn't load trade info", (Throwable)err);
                }
                finally {
                    em2.release();
                }
            }
            if ("MC|Brand".equals(packetIn.a())) {
                this.f.h.h(packetIn.b().e(32767));
            } else if ("MC|BOpen".equals(packetIn.a())) {
                adq adq2;
                qm qm2 = (qm)((Object)packetIn.b().a(qm.class));
                adq adq3 = adq2 = qm2 == qm.b ? this.f.h.cc() : this.f.h.cb();
                if (adq2 != null && adq2.b() == ads.bX) {
                    this.f.a(new bft(this.f.h, adq2, false));
                }
            } else if ("MC|DebugPath".equals(packetIn.a())) {
                em em3 = packetIn.b();
                int n3 = em3.readInt();
                float f2 = em3.readFloat();
                ayo ayo2 = ayo.b(em3);
                this.f.p.a.a(n3, ayo2, f2);
            }
        }
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S18(packetIn.a());
    }

    @Override
    public void a(hr packetIn) {
        fh.a(packetIn, this, this.f);
        bbm bbm2 = this.g.ad();
        if (packetIn.c() == 0) {
            bbi bbi2 = bbm2.a(packetIn.a(), bbs.b);
            bbi2.a(packetIn.b());
            bbi2.a(packetIn.d());
        } else {
            bbi bbi3 = bbm2.b(packetIn.a());
            if (packetIn.c() == 1) {
                bbm2.k(bbi3);
            } else if (packetIn.c() == 2) {
                bbi3.a(packetIn.b());
                bbi3.a(packetIn.d());
            }
        }
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S3F(
                packetIn.b(), // name
                packetIn.a(), // type
                packetIn.c(), // mode
                packetIn.d().name() // renderType
                );
    }

    @Override
    public void a(hu packetIn) {
        fh.a(packetIn, this, this.f);
        bbm bbm2 = this.g.ad();
        bbi bbi2 = bbm2.b(packetIn.b());
        if (packetIn.d() == hu.a.a) {
            bbk bbk2 = bbm2.c(packetIn.a(), bbi2);
            bbk2.c(packetIn.c());
        } else if (packetIn.d() == hu.a.b) {
            if (os.b(packetIn.b())) {
                bbm2.d(packetIn.a(), null);
            } else if (bbi2 != null) {
                bbm2.d(packetIn.a(), bbi2);
            }
        }
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S42(
                packetIn.a(), // score name
                packetIn.b(), // objective name
                packetIn.d().name(), // action
                packetIn.c()  // score value
                );
    }
    
    @Override
    public void a(hk packetIn) {
        fh.a(packetIn, this, this.f);
        bbm bbm2 = this.g.ad();
        if (packetIn.b().isEmpty()) {
            bbm2.a(packetIn.a(), null);
        } else {
            bbi bbi2 = bbm2.b(packetIn.b());
            bbm2.a(packetIn.a(), bbi2);
        }
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S38(packetIn.a(), packetIn.b());
    }

    @Override
    public void a(ht packetIn) {
        bbj bbj2;
        fh.a(packetIn, this, this.f);
        bbm bbm2 = this.g.ad();
        if (packetIn.f() == 0) {
            bbj2 = bbm2.e(packetIn.a());
        } else {
            bbj2 = bbm2.d(packetIn.a());
        }
        
        if (packetIn.f() == 0 || packetIn.f() == 2) {
            bbo.a a2;
            bbj2.a(packetIn.b());
            bbj2.b(packetIn.c());
            bbj2.c(packetIn.d());
            bbj2.a(Namepipe.a.a(packetIn.h()));
            bbj2.a(packetIn.g());
            bbo.b b2 = bbo.b.a(packetIn.i());
            if (b2 != null) {
                bbj2.a(b2);
            }
            if ((a2 = bbo.a.a(packetIn.j())) != null) {
                bbj2.a(a2);
            }
        }
        if (packetIn.f() == 0 || packetIn.f() == 3) {
            for (String object : packetIn.e()) {
                bbm2.a(object, packetIn.a());
            }
        }
        if (packetIn.f() == 4) {
            for (String string : packetIn.e()) {
                bbm2.a(string, bbj2);
            }
        }
        if (packetIn.f() == 1) {
            bbm2.d(bbj2);
        }
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S41(
                packetIn.f(), // mode
                packetIn.j(), // team name
                
                packetIn.b(), // team display name
                packetIn.c(), // prefix
                packetIn.d(), // suffix
                packetIn.h(), // chat formatting
                packetIn.g(), // friendly fire
                packetIn.i(), // name tag visibility
                
                packetIn.e()  // player names
                );
    }

    @Override
    public void a(gr packetIn) {
        fh.a(packetIn, this, this.f);
        if (packetIn.j() == 0) {
            double d2 = packetIn.i() * packetIn.f();
            double d3 = packetIn.i() * packetIn.g();
            double d4 = packetIn.i() * packetIn.h();
            try {
                this.g.a(packetIn.a(), packetIn.b(), packetIn.c(), packetIn.d(), packetIn.e(), d2, d3, d4, packetIn.k());
            }
            catch (Throwable err) {
                b.warn("Could not spawn particle effect " + (Object)((Object)packetIn.a()));
            }
        } else {
            for (int i2 = 0; i2 < packetIn.j(); ++i2) {
                double d5 = this.k.nextGaussian() * (double)packetIn.f();
                double d6 = this.k.nextGaussian() * (double)packetIn.g();
                double d7 = this.k.nextGaussian() * (double)packetIn.h();
                double d8 = this.k.nextGaussian() * (double)packetIn.i();
                double d9 = this.k.nextGaussian() * (double)packetIn.i();
                double d10 = this.k.nextGaussian() * (double)packetIn.i();
                try {
                    this.g.a(packetIn.a(), packetIn.b(), packetIn.c() + d5, packetIn.d() + d6, packetIn.e() + d7, d8, d9, d10, packetIn.k());
                    continue;
                }
                catch (Throwable err) {
                    b.warn("Could not spawn particle effect " + (Object)((Object)packetIn.a()));
                    return;
                }
            }
        }
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S22(
                packetIn.a().name(), // type
                packetIn.j(), // count
                packetIn.b(), // long distance
                packetIn.c(), packetIn.d(), packetIn.e(), // position
                packetIn.f(), packetIn.g(), packetIn.h(), // offset
                packetIn.i()  // offset scale
                );
    }

    @Override
    public void a(id packetIn) {
        fh.a(packetIn, this, this.f);
        rr rr2 = this.g.a(packetIn.a());
        if (rr2 == null) {
            return;
        }
        if (!(rr2 instanceof sa)) {
            throw new IllegalStateException("Server tried to update attributes of a non-living entity (actually: " + rr2 + ")");
        }
        sp sp2 = ((sa)rr2).bZ();
        for (id.a a2 : packetIn.b()) {
            sm sm2 = sp2.a(a2.a());
            if (sm2 == null) {
                sm2 = sp2.b(new ss(null, a2.a(), 0.0, Double.MIN_NORMAL, Double.MAX_VALUE));
            }
            sm2.a(a2.b());
            sm2.d();
            for (sn sn2 : a2.c()) {
                sm2.b(sn2);
            }
        }
        
        // PacketAnalysis
        if(ServerPacketData.enabled)
        ServerPacketData.display_S4B(packetIn.a(), packetIn.b());
    }

    public ek a() {
        return this.c;
    }

    public Collection<bks> d() {
        return this.i.values();
    }

    public bks a(UUID uUID) {
        return this.i.get(uUID);
    }

    public bks a(String string) {
        for (bks bks2 : this.i.values()) {
            if (!bks2.a().getName().equals(string)) continue;
            return bks2;
        }
        return null;
    }

    public GameProfile e() {
        return this.d;
    }

}
