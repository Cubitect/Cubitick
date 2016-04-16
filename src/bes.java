// GuiOptions

/*
 * Decompiled with CFR 0_115.
 */
import java.util.List;

public class bes
extends bey
implements bed {
    private static final bce.a[] f = new bce.a[]{Namepipe.bce_a.c};
    private final bey g;
    private final bce h;
    private bcw i;
    private bdh r;
    protected String a = "Options";

    public bes(bey bey2, bce bce2) {
        this.g = bey2;
        this.h = bce2;
    }

    @Override
    public void b() {
        int n2 = 0;
        this.a = bwl.a("options.title", new Object[0]);
        for (bce.a a2 : f) {
            if (a2.a()) {
                this.n.add(new bdo(a2.c(), this.l / 2 - 155 + n2 % 2 * 160, this.m / 6 - 12 + 24 * (n2 >> 1), a2));
            } else {
                bdj bdj2 = new bdj(a2.c(), this.l / 2 - 155 + n2 % 2 * 160, this.m / 6 - 12 + 24 * (n2 >> 1), a2, this.h.c(a2));
                this.n.add(bdj2);
            }
            ++n2;
        }
        if (this.j.f != null) {
            qk qk2 = this.j.f.ae();
            this.i = new bcw(108, this.l / 2 - 155 + n2 % 2 * 160, this.m / 6 - 12 + 24 * (n2 >> 1), 150, 20, this.a(qk2));
            this.n.add(this.i);
            if (this.j.E() && !this.j.f.T().s()) {
                this.i.a(this.i.b() - 20);
                this.r = new bdh(109, this.i.h + this.i.b(), this.i.i);
                this.n.add(this.r);
                this.r.b(this.j.f.T().y());
                this.r.l = !this.r.c();
                this.i.l = !this.r.c();
            } else {
                this.i.l = false;
            }
        } else {
            this.n.add(new bdj(Namepipe.bce_a.L.c(), this.l / 2 - 155 + n2 % 2 * 160, this.m / 6 - 12 + 24 * (n2 >> 1), Namepipe.bce_a.L, this.h.c(Namepipe.bce_a.L)));
        }
        this.n.add(new bcw(110, this.l / 2 - 155, this.m / 6 + 48 - 6, 150, 20, bwl.a("options.skinCustomisation", new Object[0])));
        this.n.add(new bcw(106, this.l / 2 + 5, this.m / 6 + 48 - 6, 150, 20, bwl.a("options.sounds", new Object[0])));
        this.n.add(new bcw(101, this.l / 2 - 155, this.m / 6 + 72 - 6, 150, 20, bwl.a("options.video", new Object[0])));
        this.n.add(new bcw(100, this.l / 2 + 5, this.m / 6 + 72 - 6, 150, 20, bwl.a("options.controls", new Object[0])));
        this.n.add(new bcw(102, this.l / 2 - 155, this.m / 6 + 96 - 6, 150, 20, bwl.a("options.language", new Object[0])));
        this.n.add(new bcw(103, this.l / 2 + 5, this.m / 6 + 96 - 6, 150, 20, bwl.a("options.chat.title", new Object[0])));
        this.n.add(new bcw(105, this.l / 2 - 155, this.m / 6 + 120 - 6, 150, 20, bwl.a("options.resourcepack", new Object[0])));
        this.n.add(new bcw(104, this.l / 2 + 5, this.m / 6 + 120 - 6, 150, 20, bwl.a("options.snooper.view", new Object[0])));
        this.n.add(new bcw(200, this.l / 2 - 100, this.m / 6 + 168, bwl.a("gui.done", new Object[0])));
        
        // PacketAnalysis
        bcw serverPacketButton = new bcw(136, this.l / 2 - 155, this.m / 6 + 24 - 6, 150, 20, bwl.a("Server Packet Options...", new Object[0]));
        this.n.add(serverPacketButton);
    }

    public String a(qk qk2) {
        fa fa2 = new fa("");
        fa2.a(new fb("options.difficulty", new Object[0]));
        fa2.a(": ");
        fa2.a(new fb(qk2.b(), new Object[0]));
        return fa2.d();
    }

    @Override
    public void a(boolean bl2, int n2) {
        this.j.a(this);
        if (n2 == 109 && bl2 && this.j.f != null) {
            this.j.f.T().e(true);
            this.r.b(true);
            this.r.l = false;
            this.i.l = false;
        }
    }

    @Override
    protected void a(bcw bcw2) {
        if (!bcw2.l) {
            return;
        }
        if (bcw2.k < 100 && bcw2 instanceof bdj) {
            bce.a a2 = ((bdj)bcw2).c();
            this.h.a(a2, 1);
            bcw2.j = this.h.c(Namepipe.bce_a.a(bcw2.k));
        }
        if (bcw2.k == 108) {
            this.j.f.T().a(qk.a(this.j.f.ae().a() + 1));
            this.i.j = this.a(this.j.f.ae());
        }
        if (bcw2.k == 109) {
            this.j.a(new bee(this, new fb("difficulty.lock.title", new Object[0]).d(), new fb("difficulty.lock.question", new fb(this.j.f.T().x().b(), new Object[0])).d(), 109));
        }
        if (bcw2.k == 110) {
            this.j.u.b();
            this.j.a(new bfa(this));
        }
        if (bcw2.k == 101) {
            this.j.u.b();
            this.j.a(new bfg(this, this.h));
        }
        if (bcw2.k == 100) {
            this.j.u.b();
            this.j.a(new bfo(this, this.h));
        }
        if (bcw2.k == 102) {
            this.j.u.b();
            this.j.a(new beq(this, this.h, this.j.Q()));
        }
        if (bcw2.k == 103) {
            this.j.u.b();
            this.j.a(new bea(this, this.h));
        }
        if (bcw2.k == 104) {
            this.j.u.b();
            this.j.a(new bfb(this, this.h));
        }
        if (bcw2.k == 200) {
            this.j.u.b();
            this.j.a(this.g);
        }
        if (bcw2.k == 105) {
            this.j.u.b();
            this.j.a(new bgv(this));
        }
        if (bcw2.k == 106) {
            this.j.u.b();
            this.j.a(new bfc(this, this.h));
        }
        
        // PacketAnalysis
        if(bcw2.k == 136)
        {
            this.j.u.b();
            this.j.a(new GuiServerPackets(this, this.h));
        }
    }

    @Override
    public void a(int n2, int n3, float f2) {
        this.c();
        this.a(this.q, this.a, this.l / 2, 15, 16777215);
        super.a(n2, n3, f2);
    }
}
