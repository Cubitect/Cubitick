// EntityRenderer

/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Predicate
 *  com.google.common.base.Predicates
 *  com.google.gson.JsonSyntaxException
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 *  org.lwjgl.input.Mouse
 *  org.lwjgl.opengl.ContextCapabilities
 *  org.lwjgl.opengl.Display
 *  org.lwjgl.opengl.GLContext
 *  org.lwjgl.util.glu.Project
 */
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.gson.JsonSyntaxException;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import javax.imageio.ImageIO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.util.glu.Project;

public class bnd
implements bwe {
    private static final Logger e = LogManager.getLogger();
    private static final kk f = new kk("textures/environment/rain.png");
    private static final kk g = new kk("textures/environment/snow.png");
    public static boolean a;
    public static int b;
    private bcc h;
    private final bwd i;
    private Random j = new Random();
    private float k;
    public final bnh c;
    private final bct l;
    private int m;
    private rr n;
    private oq o = new oq();
    private oq p = new oq();
    private float q = 4.0f;
    private float r = 4.0f;
    private float s;
    private float t;
    private float u;
    private float v;
    private float w;
    private float x;
    private float y;
    private float z;
    private float A;
    private boolean B;
    private boolean C = true;
    private boolean D = true;
    private long E;
    private long F = bcc.I();
    private long G;
    private final buu H;
    private final int[] I;
    private final kk J;
    private boolean K;
    private float L;
    private float M;
    private int N;
    private float[] O = new float[1024];
    private float[] P = new float[1024];
    private FloatBuffer Q = bcb.h(16);
    private float R;
    private float S;
    private float T;
    private float U;
    private float V;
    private int W = 0;
    private boolean X = false;
    private double Y = 1.0;
    private double Z;
    private double aa;
    private bum ab;
    private static final kk[] ac;
    public static final int d;
    private int ad = d;
    private boolean ae = false;
    private int af = 0;

    public bnd(bcc bcc2, bwd bwd2) {
        this.h = bcc2;
        this.i = bwd2;
        this.c = bcc2.ae();
        this.l = new bct(bcc2.N());
        this.H = new buu(16, 16);
        this.J = bcc2.N().a("lightMap", this.H);
        this.I = this.H.e();
        this.ab = null;
        for (int i2 = 0; i2 < 32; ++i2) {
            for (int i3 = 0; i3 < 32; ++i3) {
                float f2 = i3 - 16;
                float f3 = i2 - 16;
                float f4 = on.c(f2 * f2 + f3 * f3);
                this.O[i2 << 5 | i3] = (- f3) / f4;
                this.P[i2 << 5 | i3] = f2 / f4;
            }
        }
    }

    public boolean a() {
        return bze.O && this.ab != null;
    }

    public void b() {
        if (this.ab != null) {
            this.ab.a();
        }
        this.ab = null;
        this.ad = d;
    }

    public void c() {
        this.ae = !this.ae;
    }

    public void a(rr rr2) {
        if (!bze.O) {
            return;
        }
        if (this.ab != null) {
            this.ab.a();
        }
        this.ab = null;
        if (rr2 instanceof yi) {
            this.a(new kk("shaders/post/creeper.json"));
        } else if (rr2 instanceof yy) {
            this.a(new kk("shaders/post/spider.json"));
        } else if (rr2 instanceof yj) {
            this.a(new kk("shaders/post/invert.json"));
        }
    }

    private void a(kk kk2) {
        try {
            this.ab = new bum(this.h.N(), this.i, this.h.b(), kk2);
            this.ab.a(this.h.d, this.h.e);
            this.ae = true;
        }
        catch (IOException err) {
            e.warn("Failed to load shader: " + kk2, (Throwable)err);
            this.ad = d;
            this.ae = false;
        }
        catch (JsonSyntaxException err) {
            e.warn("Failed to load shader: " + kk2, (Throwable)err);
            this.ad = d;
            this.ae = false;
        }
    }

    @Override
    public void a(bwd bwd2) {
        if (this.ab != null) {
            this.ab.a();
        }
        this.ab = null;
        if (this.ad != d) {
            this.a(ac[this.ad]);
        } else {
            this.a(this.h.aa());
        }
    }

    public void e() {
        float f2;
        float f3;
        if (bze.O && bup.b() == null) {
            bup.a();
        }
        this.l();
        this.m();
        this.U = this.V;
        this.r = this.q;
        if (this.h.u.av) {
            f2 = this.h.u.a * 0.6f + 0.2f;
            f3 = f2 * f2 * f2 * 8.0f;
            this.u = this.o.a(this.s, 0.05f * f3);
            this.v = this.p.a(this.t, 0.05f * f3);
            this.w = 0.0f;
            this.s = 0.0f;
            this.t = 0.0f;
        } else {
            this.u = 0.0f;
            this.v = 0.0f;
            this.o.a();
            this.p.a();
        }
        if (this.h.aa() == null) {
            this.h.a(this.h.h);
        }
        f2 = this.h.f.n(new cj(this.h.aa()));
        f3 = (float)this.h.u.c / 32.0f;
        float f4 = f2 * (1.0f - f3) + f3;
        this.V += (f4 - this.V) * 0.1f;
        ++this.m;
        this.c.a();
        this.p();
        this.A = this.z;
        if (this.h.r.j().e()) {
            this.z += 0.05f;
            if (this.z > 1.0f) {
                this.z = 1.0f;
            }
        } else if (this.z > 0.0f) {
            this.z -= 0.0125f;
        }
    }

    public bum f() {
        return this.ab;
    }

    public void a(int n2, int n3) {
        if (!bze.O) {
            return;
        }
        if (this.ab != null) {
            this.ab.a(n2, n3);
        }
        this.h.g.a(n2, n3);
    }

    public void a(float f2) {
        rr rr2 = this.h.aa();
        if (rr2 == null) {
            return;
        }
        if (this.h.f == null) {
            return;
        }
        this.h.B.a("pick");
        this.h.i = null;
        double d2 = this.h.c.d();
        this.h.t = rr2.a(d2, f2);
        double d3 = d2;
        bbg bbg2 = rr2.g(f2);
        boolean bl2 = false;
        int n2 = 3;
        if (this.h.c.i()) {
            d2 = 6.0;
            d3 = 6.0;
        } else {
            if (d3 > 3.0) {
                bl2 = true;
            }
            d2 = d3;
        }
        if (this.h.t != null) {
            d3 = this.h.t.c.f(bbg2);
        }
        bbg bbg3 = rr2.f(f2);
        bbg bbg4 = bbg2.b(bbg3.b * d2, bbg3.c * d2, bbg3.d * d2);
        this.n = null;
        bbg bbg5 = null;
        float f3 = 1.0f;
        List<rr> list = this.h.f.a(rr2, rr2.bl().a(bbg3.b * d2, bbg3.c * d2, bbg3.d * d2).b((double)f3, f3, f3), Predicates.and(rv.e, (Predicate)new Predicate<rr>(){

            public boolean a(rr rr2) {
                return rr2 != null && rr2.ap();
            }

            public /* synthetic */ boolean apply(rr object) {
                return this.a((rr)object);
            }
        }));
        double d4 = d3;
        for (int i2 = 0; i2 < list.size(); ++i2) {
            double d5;
            rr rr3 = list.get(i2);
            bbe bbe2 = rr3.bl().g(rr3.aA());
            bbf bbf2 = bbe2.a(bbg2, bbg4);
            if (bbe2.a(bbg2)) {
                if (d4 < 0.0) continue;
                this.n = rr3;
                bbg5 = bbf2 == null ? bbg2 : bbf2.c;
                d4 = 0.0;
                continue;
            }
            if (bbf2 == null || (d5 = bbg2.f(bbf2.c)) >= d4 && d4 != 0.0) continue;
            if (rr3.bw() == rr2.bw()) {
                if (d4 != 0.0) continue;
                this.n = rr3;
                bbg5 = bbf2.c;
                continue;
            }
            this.n = rr3;
            bbg5 = bbf2.c;
            d4 = d5;
        }
        if (this.n != null && bl2 && bbg2.f(bbg5) > 3.0) {
            this.n = null;
            this.h.t = new bbf(Namepipe.bbf_a.a, bbg5, null, new cj(bbg5));
        }
        if (this.n != null && (d4 < d3 || this.h.t == null)) {
            this.h.t = new bbf(this.n, bbg5);
            if (this.n instanceof sa || this.n instanceof xs) {
                this.h.i = this.n;
            }
        }
        this.h.B.b();
    }

    private void l() {
        float f2 = 1.0f;
        if (this.h.aa() instanceof bmn) {
            bmn bmn2 = (bmn)this.h.aa();
            f2 = bmn2.x();
        }
        this.y = this.x;
        this.x += (f2 - this.x) * 0.5f;
        if (this.x > 1.5f) {
            this.x = 1.5f;
        }
        if (this.x < 0.1f) {
            this.x = 0.1f;
        }
    }

    private float a(float f2, boolean bl2) {
        arc arc2;
        if (this.X) {
            return 90.0f;
        }
        rr rr2 = this.h.aa();
        float f3 = 70.0f;
        if (bl2) {
            f3 = this.h.u.ax;
            f3 *= this.y + (this.x - this.y) * f2;
        }
        if (rr2 instanceof sa && ((sa)rr2).bQ() <= 0.0f) {
            float f4 = (float)((sa)rr2).aA + f2;
            f3 /= (1.0f - 500.0f / (f4 + 500.0f)) * 2.0f + 1.0f;
        }
        if ((arc2 = bbx.a(this.h.f, rr2, f2)).a() == axd.h) {
            f3 = f3 * 60.0f / 70.0f;
        }
        return f3;
    }

    private void d(float f2) {
        if (this.h.aa() instanceof sa) {
            float f3;
            sa sa2 = (sa)this.h.aa();
            float f4 = (float)sa2.ax - f2;
            if (sa2.bQ() <= 0.0f) {
                f3 = (float)sa2.aA + f2;
                bnf.b(40.0f - 8000.0f / (f3 + 200.0f), 0.0f, 0.0f, 1.0f);
            }
            if (f4 < 0.0f) {
                return;
            }
            f4 /= (float)sa2.ay;
            f4 = on.a(f4 * f4 * f4 * f4 * 3.1415927f);
            f3 = sa2.az;
            bnf.b(- f3, 0.0f, 1.0f, 0.0f);
            bnf.b((- f4) * 14.0f, 0.0f, 0.0f, 1.0f);
            bnf.b(f3, 0.0f, 1.0f, 0.0f);
        }
    }

    private void e(float f2) {
        if (!(this.h.aa() instanceof zj)) {
            return;
        }
        zj zj2 = (zj)this.h.aa();
        float f3 = zj2.J - zj2.I;
        // Cubitick ! brackets around expression
        float f4 = - (zj2.J + f3 * f2);
        float f5 = zj2.bw + (zj2.bx - zj2.bw) * f2;
        float f6 = zj2.aI + (zj2.aJ - zj2.aI) * f2;
        bnf.c(on.a(f4 * 3.1415927f) * f5 * 0.5f, - Math.abs(on.b(f4 * 3.1415927f) * f5), 0.0f);
        bnf.b(on.a(f4 * 3.1415927f) * f5 * 3.0f, 0.0f, 0.0f, 1.0f);
        bnf.b(Math.abs(on.b(f4 * 3.1415927f - 0.2f) * f5) * 5.0f, 1.0f, 0.0f, 0.0f);
        bnf.b(f6, 1.0f, 0.0f, 0.0f);
    }

    private void f(float f2) {
        Object object;
        rr rr2 = this.h.aa();
        float f3 = rr2.bn();
        double d2 = rr2.m + (rr2.p - rr2.m) * (double)f2;
        double d3 = rr2.n + (rr2.q - rr2.n) * (double)f2 + (double)f3;
        double d4 = rr2.o + (rr2.r - rr2.o) * (double)f2;
        if (rr2 instanceof sa && ((sa)rr2).cl()) {
            f3 = (float)((double)f3 + 1.0);
            bnf.c(0.0f, 0.3f, 0.0f);
            if (!this.h.u.aw) {
                object = new cj(rr2);
                arc arc2 = this.h.f.o((cj)object);
                ajt ajt2 = arc2.t();
                if (ajt2 == aju.C) {
                    int n2 = ((cq)arc2.c(ajr.D)).b();
                    bnf.b((float)(n2 * 90), 0.0f, 1.0f, 0.0f);
                }
                bnf.b(rr2.x + (rr2.v - rr2.x) * f2 + 180.0f, 0.0f, -1.0f, 0.0f);
                bnf.b(rr2.y + (rr2.w - rr2.y) * f2, -1.0f, 0.0f, 0.0f);
            }
        } else if (this.h.u.aq > 0) {
            double d5 = this.r + (this.q - this.r) * f2;
            if (this.h.u.aw) {
                bnf.c(0.0f, 0.0f, (float)(- d5));
            } else {
                float f4 = rr2.v;
                float f5 = rr2.w;
                if (this.h.u.aq == 2) {
                    f5 += 180.0f;
                }
                double d6 = (double)((- on.a(f4 * 0.017453292f)) * on.b(f5 * 0.017453292f)) * d5;
                double d7 = (double)(on.b(f4 * 0.017453292f) * on.b(f5 * 0.017453292f)) * d5;
                double d8 = (double)(- on.a(f5 * 0.017453292f)) * d5;
                for (int i2 = 0; i2 < 8; ++i2) {
                    bbf bbf2;
                    double d9;
                    float f6 = (i2 & 1) * 2 - 1;
                    float f7 = (i2 >> 1 & 1) * 2 - 1;
                    float f8 = (i2 >> 2 & 1) * 2 - 1;
                    if ((bbf2 = this.h.f.a(new bbg(d2 + (double)(f6 *= 0.1f), d3 + (double)(f7 *= 0.1f), d4 + (double)(f8 *= 0.1f)), new bbg(d2 - d6 + (double)f6 + (double)f8, d3 - d8 + (double)f7, d4 - d7 + (double)f8))) == null || (d9 = bbf2.c.f(new bbg(d2, d3, d4))) >= d5) continue;
                    d5 = d9;
                }
                if (this.h.u.aq == 2) {
                    bnf.b(180.0f, 0.0f, 1.0f, 0.0f);
                }
                bnf.b(rr2.w - f5, 1.0f, 0.0f, 0.0f);
                bnf.b(rr2.v - f4, 0.0f, 1.0f, 0.0f);
                bnf.c(0.0f, 0.0f, (float)(- d5));
                bnf.b(f4 - rr2.v, 0.0f, 1.0f, 0.0f);
                bnf.b(f5 - rr2.w, 1.0f, 0.0f, 0.0f);
            }
        } else {
            bnf.c(0.0f, 0.0f, 0.05f);
        }
        if (!this.h.u.aw) {
            bnf.b(rr2.y + (rr2.w - rr2.y) * f2, 1.0f, 0.0f, 0.0f);
            if (rr2 instanceof vw) {
                vw object1 = (vw)rr2;
                bnf.b(object1.aP + (object1.aO - object1.aP) * f2 + 180.0f, 0.0f, 1.0f, 0.0f);
            } else {
                bnf.b(rr2.x + (rr2.v - rr2.x) * f2 + 180.0f, 0.0f, 1.0f, 0.0f);
            }
        }
        bnf.c(0.0f, - f3, 0.0f);
        d2 = rr2.m + (rr2.p - rr2.m) * (double)f2;
        d3 = rr2.n + (rr2.q - rr2.n) * (double)f2 + (double)f3;
        d4 = rr2.o + (rr2.r - rr2.o) * (double)f2;
        this.B = this.h.g.a(d2, d3, d4, f2);
    }

    private void a(float f2, int n2) {
        float f3;
        this.k = this.h.u.c * 16;
        bnf.n(5889);
        bnf.F();
        float f4 = 0.07f;
        if (this.h.u.e) {
            bnf.c((float)(- n2 * 2 - 1) * f4, 0.0f, 0.0f);
        }
        if (this.Y != 1.0) {
            bnf.c((float)this.Z, (float)(- this.aa), 0.0f);
            bnf.a(this.Y, this.Y, 1.0);
        }
        Project.gluPerspective((float)this.a(f2, true), (float)((float)this.h.d / (float)this.h.e), (float)0.05f, (float)(this.k * on.a));
        bnf.n(5888);
        bnf.F();
        if (this.h.u.e) {
            bnf.c((float)(n2 * 2 - 1) * 0.1f, 0.0f, 0.0f);
        }
        this.d(f2);
        if (this.h.u.d) {
            this.e(f2);
        }
        if ((f3 = this.h.h.bV + (this.h.h.bU - this.h.h.bV) * f2) > 0.0f) {
            int n3 = 20;
            if (this.h.h.a(rm.i)) {
                n3 = 7;
            }
            float f5 = 5.0f / (f3 * f3 + 5.0f) - f3 * 0.04f;
            f5 *= f5;
            bnf.b(((float)this.m + f2) * (float)n3, 0.0f, 1.0f, 1.0f);
            bnf.b(1.0f / f5, 1.0f, 1.0f);
            bnf.b((- (float)this.m + f2) * (float)n3, 0.0f, 1.0f, 1.0f);
        }
        this.f(f2);
        if (this.X) {
            switch (this.W) {
                case 0: {
                    bnf.b(90.0f, 0.0f, 1.0f, 0.0f);
                    break;
                }
                case 1: {
                    bnf.b(180.0f, 0.0f, 1.0f, 0.0f);
                    break;
                }
                case 2: {
                    bnf.b(-90.0f, 0.0f, 1.0f, 0.0f);
                    break;
                }
                case 3: {
                    bnf.b(90.0f, 1.0f, 0.0f, 0.0f);
                    break;
                }
                case 4: {
                    bnf.b(-90.0f, 1.0f, 0.0f, 0.0f);
                }
            }
        }
    }

    private void b(float f2, int n2) {
        boolean bl2;
        if (this.X) {
            return;
        }
        bnf.n(5889);
        bnf.F();
        float f3 = 0.07f;
        if (this.h.u.e) {
            bnf.c((float)(- n2 * 2 - 1) * f3, 0.0f, 0.0f);
        }
        Project.gluPerspective((float)this.a(f2, false), (float)((float)this.h.d / (float)this.h.e), (float)0.05f, (float)(this.k * 2.0f));
        bnf.n(5888);
        bnf.F();
        if (this.h.u.e) {
            bnf.c((float)(n2 * 2 - 1) * 0.1f, 0.0f, 0.0f);
        }
        bnf.G();
        this.d(f2);
        if (this.h.u.d) {
            this.e(f2);
        }
        boolean bl3 = bl2 = this.h.aa() instanceof sa && ((sa)this.h.aa()).cl();
        if (!(this.h.u.aq != 0 || bl2 || this.h.u.ap || this.h.c.a())) {
            this.i();
            this.c.a(f2);
            this.h();
        }
        bnf.H();
        if (this.h.u.aq == 0 && !bl2) {
            this.c.b(f2);
            this.d(f2);
        }
        if (this.h.u.d) {
            this.e(f2);
        }
    }

    public void h() {
        bnf.g(bze.r);
        bnf.z();
        bnf.g(bze.q);
    }

    public void i() {
        bnf.g(bze.r);
        bnf.n(5890);
        bnf.F();
        float f2 = 0.00390625f;
        bnf.b(f2, f2, f2);
        bnf.c(8.0f, 8.0f, 8.0f);
        bnf.n(5888);
        this.h.N().a(this.J);
        bnf.b(3553, 10241, 9729);
        bnf.b(3553, 10240, 9729);
        bnf.b(3553, 10242, 10496);
        bnf.b(3553, 10243, 10496);
        bnf.c(1.0f, 1.0f, 1.0f, 1.0f);
        bnf.y();
        bnf.g(bze.q);
    }

    private void m() {
        this.M = (float)((double)this.M + (Math.random() - Math.random()) * Math.random() * Math.random());
        this.M = (float)((double)this.M * 0.9);
        this.L += this.M - this.L;
        this.K = true;
    }

    private void g(float f2) {
        if (!this.K) {
            return;
        }
        this.h.B.a("lightTex");
        bkr bkr2 = this.h.f;
        if (bkr2 == null) {
            return;
        }
        float f3 = bkr2.b(1.0f);
        float f4 = f3 * 0.95f + 0.05f;
        for (int i2 = 0; i2 < 256; ++i2) {
            float f5;
            float f6;
            float f7 = bkr2.s.n()[i2 / 16] * f4;
            float f8 = bkr2.s.n()[i2 % 16] * (this.L * 0.1f + 1.5f);
            if (bkr2.ag() > 0) {
                f7 = bkr2.s.n()[i2 / 16];
            }
            float f9 = f7 * (f3 * 0.65f + 0.35f);
            float f10 = f7 * (f3 * 0.65f + 0.35f);
            float f11 = f7;
            float f12 = f8;
            float f13 = f8 * ((f8 * 0.6f + 0.4f) * 0.6f + 0.4f);
            float f14 = f8 * (f8 * f8 * 0.6f + 0.4f);
            float f15 = f9 + f12;
            float f16 = f10 + f13;
            float f17 = f11 + f14;
            f15 = f15 * 0.96f + 0.03f;
            f16 = f16 * 0.96f + 0.03f;
            f17 = f17 * 0.96f + 0.03f;
            if (this.z > 0.0f) {
                f6 = this.A + (this.z - this.A) * f2;
                f15 = f15 * (1.0f - f6) + f15 * 0.7f * f6;
                f16 = f16 * (1.0f - f6) + f16 * 0.6f * f6;
                f17 = f17 * (1.0f - f6) + f17 * 0.6f * f6;
            }
            if (bkr2.s.p().a() == 1) {
                f15 = 0.22f + f12 * 0.75f;
                f16 = 0.28f + f13 * 0.75f;
                f17 = 0.25f + f14 * 0.75f;
            }
            if (this.h.h.a(rm.p)) {
                f6 = this.a(this.h.h, f2);
                f5 = 1.0f / f15;
                if (f5 > 1.0f / f16) {
                    f5 = 1.0f / f16;
                }
                if (f5 > 1.0f / f17) {
                    f5 = 1.0f / f17;
                }
                f15 = f15 * (1.0f - f6) + f15 * f5 * f6;
                f16 = f16 * (1.0f - f6) + f16 * f5 * f6;
                f17 = f17 * (1.0f - f6) + f17 * f5 * f6;
            }
            if (f15 > 1.0f) {
                f15 = 1.0f;
            }
            if (f16 > 1.0f) {
                f16 = 1.0f;
            }
            if (f17 > 1.0f) {
                f17 = 1.0f;
            }
            f6 = this.h.u.ay;
            f5 = 1.0f - f15;
            float f18 = 1.0f - f16;
            float f19 = 1.0f - f17;
            f5 = 1.0f - f5 * f5 * f5 * f5;
            f18 = 1.0f - f18 * f18 * f18 * f18;
            f19 = 1.0f - f19 * f19 * f19 * f19;
            f15 = f15 * (1.0f - f6) + f5 * f6;
            f16 = f16 * (1.0f - f6) + f18 * f6;
            f17 = f17 * (1.0f - f6) + f19 * f6;
            f15 = f15 * 0.96f + 0.03f;
            f16 = f16 * 0.96f + 0.03f;
            f17 = f17 * 0.96f + 0.03f;
            if (f15 > 1.0f) {
                f15 = 1.0f;
            }
            if (f16 > 1.0f) {
                f16 = 1.0f;
            }
            if (f17 > 1.0f) {
                f17 = 1.0f;
            }
            if (f15 < 0.0f) {
                f15 = 0.0f;
            }
            if (f16 < 0.0f) {
                f16 = 0.0f;
            }
            if (f17 < 0.0f) {
                f17 = 0.0f;
            }
            int n2 = 255;
            int n3 = (int)(f15 * 255.0f);
            int n4 = (int)(f16 * 255.0f);
            int n5 = (int)(f17 * 255.0f);
            this.I[i2] = n2 << 24 | n3 << 16 | n4 << 8 | n5;
        }
        this.H.d();
        this.K = false;
        this.h.B.b();
    }

    private float a(sa sa2, float f2) {
        int n2 = sa2.b(rm.p).b();
        if (n2 > 200) {
            return 1.0f;
        }
        return 0.7f + on.a(((float)n2 - f2) * 3.1415927f * 0.2f) * 0.3f;
    }

    public void a(float f2, long l2) {
        boolean bl2 = Display.isActive();
        if (bl2 || !this.h.u.y || this.h.u.z && Mouse.isButtonDown((int)1)) {
            this.F = bcc.I();
        } else if (bcc.I() - this.F > 500) {
            this.h.q();
        }
        this.h.B.a("mouse");
        if (bl2 && bcc.a && this.h.x && !Mouse.isInsideWindow()) {
            Mouse.setGrabbed((boolean)false);
            Mouse.setCursorPosition((int)(Display.getWidth() / 2), (int)(Display.getHeight() / 2 - 20));
            Mouse.setGrabbed((boolean)true);
        }
        if (this.h.x && bl2) {
            this.h.v.c();
            float f3 = this.h.u.a * 0.6f + 0.2f;
            float f4 = f3 * f3 * f3 * 8.0f;
            float f5 = (float)this.h.v.a * f4;
            float f6 = (float)this.h.v.b * f4;
            byte n21 = 1;
            if (this.h.u.b) {
                n21 = -1;
            }
            if (this.h.u.av) {
                this.s += f5;
                this.t += f6;
                float f7 = f2 - this.w;
                this.w = f2;
                f5 = this.u * f7;
                f6 = this.v * f7;
                this.h.h.c(f5, f6 * (float)n21);
            } else {
                this.s = 0.0f;
                this.t = 0.0f;
                this.h.h.c(f5, f6 * (float)n21);
            }
        }
        this.h.B.b();
        if (this.h.s) {
            return;
        }
        a = this.h.u.e;
        final bcu bcu2 = new bcu(this.h);
        int n3 = bcu2.a();
        int n4 = bcu2.b();
        final int n5 = Mouse.getX() * n3 / this.h.d;
        final int n2 = n4 - Mouse.getY() * n4 / this.h.e - 1;
        int n6 = this.h.u.g;
        if (this.h.f != null) {
            this.h.B.a("level");
            int n7 = Math.min(bcc.af(), n6);
            n7 = Math.max(n7, 60);
            long l3 = System.nanoTime() - l2;
            long l4 = Math.max((long)(1000000000 / n7 / 4) - l3, 0);
            this.b(f2, System.nanoTime() + l4);
            if (this.h.E() && this.E < bcc.I() - 1000) {
                this.E = bcc.I();
                if (!this.h.F().y()) {
                    this.n();
                }
            }
            if (bze.O) {
                this.h.g.c();
                if (this.ab != null && this.ae) {
                    bnf.n(5890);
                    bnf.G();
                    bnf.F();
                    this.ab.a(f2);
                    bnf.H();
                }
                this.h.b().a(true);
            }
            this.G = System.nanoTime();
            this.h.B.c("gui");
            if (!this.h.u.ap || this.h.m != null) {
                bnf.a(516, 0.1f);
                this.h.r.a(f2);
            }
            this.h.B.b();
        } else {
            bnf.b(0, 0, this.h.d, this.h.e);
            bnf.n(5889);
            bnf.F();
            bnf.n(5888);
            bnf.F();
            this.j();
            this.G = System.nanoTime();
        }
        if (this.h.m != null) {
            bnf.m(256);
            try {
                this.h.m.a(n5, n2, f2);
            }
            catch (Throwable err) {
                b b2 = Namepipe.b.a(err, "Rendering screen");
                c c2 = b2.a("Screen render details");
                c2.a("Screen name", new Callable<String>(){

                    public String a() throws Exception {
                        return bnd.a((bnd)bnd.this).m.getClass().getCanonicalName();
                    }

                    @Override
                    public String call() throws Exception {
                        return this.a();
                    }
                });
                c2.a("Mouse location", new Callable<String>(){

                    public String a() throws Exception {
                        return String.format("Scaled: (%d, %d). Absolute: (%d, %d)", n5, n2, Mouse.getX(), Mouse.getY());
                    }

                    @Override
                    public String call() throws Exception {
                        return this.a();
                    }
                });
                c2.a("Screen size", new Callable<String>(){

                    public String a() throws Exception {
                        return String.format("Scaled: (%d, %d). Absolute: (%d, %d). Scale factor of %d", bcu2.a(), bcu2.b(), bnd.a((bnd)bnd.this).d, bnd.a((bnd)bnd.this).e, bcu2.e());
                    }

                    @Override
                    public String call() throws Exception {
                        return this.a();
                    }
                });
                throw new e(b2);
            }
        }
    }

    private void n() {
        if (this.h.g.g() > 10 && this.h.g.n() && !this.h.F().y()) {
            BufferedImage bufferedImage = bcg.a(this.h.d, this.h.e, this.h.b());
            int n2 = bufferedImage.getWidth();
            int n3 = bufferedImage.getHeight();
            int n4 = 0;
            int n5 = 0;
            if (n2 > n3) {
                n4 = (n2 - n3) / 2;
                n2 = n3;
            } else {
                n5 = (n3 - n2) / 2;
                n3 = n2;
            }
            try {
                BufferedImage bufferedImage2 = new BufferedImage(64, 64, 1);
                Graphics2D graphics2D = bufferedImage2.createGraphics();
                graphics2D.drawImage(bufferedImage, 0, 0, 64, 64, n4, n5, n4 + n2, n5 + n2, null);
                graphics2D.dispose();
                ImageIO.write((RenderedImage)bufferedImage2, "png", this.h.F().z());
            }
            catch (IOException err) {
                e.warn("Couldn't save auto screenshot", (Throwable)err);
            }
        }
    }

    public void b(float f2) {
        this.j();
    }

    private boolean o() {
        boolean bl2;
        if (!this.D) {
            return false;
        }
        rr rr2 = this.h.aa();
        boolean bl3 = bl2 = rr2 instanceof zj && !this.h.u.ap;
        if (bl2 && !((zj)rr2).bJ.e) {
            adq adq2 = ((zj)rr2).cb();
            if (this.h.t != null && this.h.t.a == Namepipe.bbf_a.b) {
                cj cj2 = this.h.t.a();
                ajt ajt2 = this.h.f.o(cj2).t();
                bl2 = this.h.c.l() == ahw.a.e ? ajt2.m() && this.h.f.r(cj2) instanceof qg : adq2 != null && (adq2.a(ajt2) || adq2.b(ajt2));
            }
        }
        return bl2;
    }

    public void b(float f2, long l2) {
        this.g(f2);
        if (this.h.aa() == null) {
            this.h.a(this.h.h);
        }
        this.a(f2);
        bnf.k();
        bnf.e();
        bnf.a(516, 0.5f);
        this.h.B.a("center");
        
        // Cubitick
        if(h.timer.c < 0 || h.timer.c >= 1) 
            h.timer.c = 0;
        if(h.timerWorld.c < 0 || h.timerWorld.c >= 1) 
            h.timerWorld.c = 0;
        
        if(this.h.u.e)
        {
            b = 0;
            bnf.a(false, true, true, false);
            if(Cubitick.synctick) this.a(0, f2, l2);
            else this.a_Async(0, h.timer.c, h.timerWorld.c, l2);
            b = 1;
            bnf.a(true, false, false, false);
            if(Cubitick.synctick) this.a(1, f2, l2);
            else this.a_Async(1, h.timer.c, h.timerWorld.c, l2);
            bnf.a(true, true, true, false);
        }
        else
        {
            if(Cubitick.synctick) this.a(2, f2, l2);
            else this.a_Async(2, h.timer.c, h.timerWorld.c, l2);
        }
        
        this.h.B.b();
    }

    
    private void a_Async(int n2, float ptick, float wtick, long l2) 
    {   
        bnl bnl2 = this.h.g;
        blv blv2 = this.h.j;
        boolean bl2 = this.o();
        bnf.q();
        this.h.B.c("clear");
        bnf.b(0, 0, this.h.d, this.h.e);
        this.h(ptick);
        bnf.m(16640);
        this.h.B.c("camera");
        this.a(ptick, n2);
        bbx.a(this.h.h, this.h.u.aq == 2);
        this.h.B.c("frustum");
        bqk.a();
        this.h.B.c("culling");
        bql bql2 = new bql();
        rr rr2 = this.h.aa();
        double d2 = rr2.M + (rr2.p - rr2.M) * (double)ptick;
        double d3 = rr2.N + (rr2.q - rr2.N) * (double)ptick;
        double d4 = rr2.O + (rr2.r - rr2.O) * (double)ptick;
        bql2.a(d2, d3, d4);
        
        // Cubitick: save lastTickPos of the player so that it can be temporarily altered later on
        double lx = rr2.M;
        double ly = rr2.N;
        double lz = rr2.O;
        
        if (this.h.u.c >= 4) {
            this.a(-1, ptick);
            this.h.B.c("sky");
            bnf.n(5889);
            bnf.F();
            Project.gluPerspective((float)this.a(ptick, true), (float)((float)this.h.d / (float)this.h.e), (float)0.05f, (float)(this.k * 2.0f));
            bnf.n(5888);
            bnl2.a(ptick, n2);
            bnf.n(5889);
            bnf.F();
            Project.gluPerspective((float)this.a(ptick, true), (float)((float)this.h.d / (float)this.h.e), (float)0.05f, (float)(this.k * on.a));
            bnf.n(5888);
        }
        this.a(0, ptick);
        bnf.j(7425);
        if (rr2.q + (double)rr2.bn() < 128.0) {
            this.a(bnl2, ptick, n2);
        }
        this.h.B.c("prepareterrain");
        this.a(0, ptick);
        this.h.N().a(bvd.g);
        bca.a();
        this.h.B.c("terrain_setup");
        bnl2.a(rr2, ptick, bql2, this.af++, this.h.h.y());
        if (n2 == 0 || n2 == 2) {
            this.h.B.c("updatechunks");
            this.h.g.a(l2);
        }
        this.h.B.c("terrain");
        bnf.n(5888);
        bnf.G();
        bnf.d();
        bnl2.a(ahm.a, (double)ptick, n2, rr2);
        bnf.e();
        bnl2.a(ahm.b, (double)ptick, n2, rr2);
        this.h.N().b(bvd.g).b(false, false);
        bnl2.a(ahm.c, (double)ptick, n2, rr2);
        this.h.N().b(bvd.g).a();
        bnf.j(7424);
        bnf.a(516, 0.1f);
        if (!this.X) {
            bnf.n(5888);
            bnf.H();
            bnf.G();
            bca.b();
            this.h.B.c("entities");
            
            // Cubitick
            rr2.M = rr2.p - (rr2.p-lx)*(1.0-ptick)/(1.0-wtick);
            rr2.N = rr2.q - (rr2.q-ly)*(1.0-ptick)/(1.0-wtick);
            rr2.O = rr2.r - (rr2.r-lz)*(1.0-ptick)/(1.0-wtick);
            
            bnl2.a(rr2, bql2, wtick);
            
            rr2.M = lx;
            rr2.N = ly;
            rr2.O = lz;
            
            bca.a();
            this.h();
        }
        bnf.n(5888);
        bnf.H();
        if (bl2 && this.h.t != null && !rr2.a(axd.h)) {
            zj zj2 = (zj)rr2;
            bnf.d();
            this.h.B.c("outline");
            bnl2.a(zj2, this.h.t, 0, ptick);
            bnf.e();
        }
        
        // Cubitick
        rr2.M = rr2.p - (rr2.p-lx)*(1.0-ptick)/(1.0-wtick);
        rr2.N = rr2.q - (rr2.q-ly)*(1.0-ptick)/(1.0-wtick);
        rr2.O = rr2.r - (rr2.r-lz)*(1.0-ptick)/(1.0-wtick);
        
        this.h.B.c("destroyProgress");
        bnf.m();
        bnf.a(bnf.r.l, bnf.l.e, bnf.r.e, bnf.l.n);
        this.h.N().b(bvd.g).b(false, false);
        bnl2.a(bnr.a(), bnr.a().c(), rr2, wtick);
        this.h.N().b(bvd.g).a();
        bnf.l();
        if (!this.X) {
            this.i();
            this.h.B.c("litParticles");
            blv2.b(rr2, wtick);
            bca.a();
            this.a(0, wtick);
            this.h.B.c("particles");
            blv2.a(rr2, wtick);
            this.h();
        }
        bnf.a(false);
        bnf.q();
        this.h.B.c("weather");
        this.c(wtick);

        // Cubitick
        rr2.M = lx;
        rr2.N = ly;
        rr2.O = lz;
        
        bnf.a(true);
        bnl2.a(rr2, ptick);
        bnf.l();
        bnf.q();
        bnf.a(bnf.r.l, bnf.l.j, bnf.r.e, bnf.l.n);
        bnf.a(516, 0.1f);
        this.a(0, ptick);
        bnf.m();
        bnf.a(false);
        this.h.N().a(bvd.g);
        bnf.j(7425);
        this.h.B.c("translucent");
        bnl2.a(ahm.d, (double)ptick, n2, rr2);
        bnf.j(7424);
        bnf.a(true);
        bnf.q();
        bnf.l();
        bnf.p();
        if (rr2.q + (double)rr2.bn() >= 128.0) {
            this.h.B.c("aboveClouds");
            this.a(bnl2, ptick, n2);
        }
        this.h.B.c("hand");
        if (this.C) {
            bnf.m(256);
            this.b(ptick, n2);
        }
    }
    
    private void a(int n2, float f2, long l2) {
        bnl bnl2 = this.h.g;
        blv blv2 = this.h.j;
        boolean bl2 = this.o();
        bnf.q();
        this.h.B.c("clear");
        bnf.b(0, 0, this.h.d, this.h.e);
        this.h(f2);
        bnf.m(16640);
        this.h.B.c("camera");
        this.a(f2, n2);
        bbx.a(this.h.h, this.h.u.aq == 2);
        this.h.B.c("frustum");
        bqk.a();
        this.h.B.c("culling");
        bql bql2 = new bql();
        rr rr2 = this.h.aa();
        double d2 = rr2.M + (rr2.p - rr2.M) * (double)f2;
        double d3 = rr2.N + (rr2.q - rr2.N) * (double)f2;
        double d4 = rr2.O + (rr2.r - rr2.O) * (double)f2;
        bql2.a(d2, d3, d4);
        if (this.h.u.c >= 4) {
            this.a(-1, f2);
            this.h.B.c("sky");
            bnf.n(5889);
            bnf.F();
            Project.gluPerspective((float)this.a(f2, true), (float)((float)this.h.d / (float)this.h.e), (float)0.05f, (float)(this.k * 2.0f));
            bnf.n(5888);
            bnl2.a(f2, n2);
            bnf.n(5889);
            bnf.F();
            Project.gluPerspective((float)this.a(f2, true), (float)((float)this.h.d / (float)this.h.e), (float)0.05f, (float)(this.k * on.a));
            bnf.n(5888);
        }
        this.a(0, f2);
        bnf.j(7425);
        if (rr2.q + (double)rr2.bn() < 128.0) {
            this.a(bnl2, f2, n2);
        }
        this.h.B.c("prepareterrain");
        this.a(0, f2);
        this.h.N().a(bvd.g);
        bca.a();
        this.h.B.c("terrain_setup");
        bnl2.a(rr2, f2, bql2, this.af++, this.h.h.y());
        if (n2 == 0 || n2 == 2) {
            this.h.B.c("updatechunks");
            this.h.g.a(l2);
        }
        this.h.B.c("terrain");
        bnf.n(5888);
        bnf.G();
        bnf.d();
        bnl2.a(ahm.a, (double)f2, n2, rr2);
        bnf.e();
        bnl2.a(ahm.b, (double)f2, n2, rr2);
        this.h.N().b(bvd.g).b(false, false);
        bnl2.a(ahm.c, (double)f2, n2, rr2);
        this.h.N().b(bvd.g).a();
        bnf.j(7424);
        bnf.a(516, 0.1f);
        if (!this.X) {
            bnf.n(5888);
            bnf.H();
            bnf.G();
            bca.b();
            this.h.B.c("entities");
            bnl2.a(rr2, bql2, f2);
            bca.a();
            this.h();
        }
        bnf.n(5888);
        bnf.H();
        if (bl2 && this.h.t != null && !rr2.a(axd.h)) {
            zj zj2 = (zj)rr2;
            bnf.d();
            this.h.B.c("outline");
            bnl2.a(zj2, this.h.t, 0, f2);
            bnf.e();
        }
        this.h.B.c("destroyProgress");
        bnf.m();
        bnf.a(bnf.r.l, bnf.l.e, bnf.r.e, bnf.l.n);
        this.h.N().b(bvd.g).b(false, false);
        bnl2.a(bnr.a(), bnr.a().c(), rr2, f2);
        this.h.N().b(bvd.g).a();
        bnf.l();
        if (!this.X) {
            this.i();
            this.h.B.c("litParticles");
            blv2.b(rr2, f2);
            bca.a();
            this.a(0, f2);
            this.h.B.c("particles");
            blv2.a(rr2, f2);
            this.h();
        }
        bnf.a(false);
        bnf.q();
        this.h.B.c("weather");
        this.c(f2);
        bnf.a(true);
        bnl2.a(rr2, f2);
        bnf.l();
        bnf.q();
        bnf.a(bnf.r.l, bnf.l.j, bnf.r.e, bnf.l.n);
        bnf.a(516, 0.1f);
        this.a(0, f2);
        bnf.m();
        bnf.a(false);
        this.h.N().a(bvd.g);
        bnf.j(7425);
        this.h.B.c("translucent");
        bnl2.a(ahm.d, (double)f2, n2, rr2);
        bnf.j(7424);
        bnf.a(true);
        bnf.q();
        bnf.l();
        bnf.p();
        if (rr2.q + (double)rr2.bn() >= 128.0) {
            this.h.B.c("aboveClouds");
            this.a(bnl2, f2, n2);
        }
        this.h.B.c("hand");
        if (this.C) {
            bnf.m(256);
            this.b(f2, n2);
        }
    }

    private void a(bnl bnl2, float f2, int n2) {
        if (this.h.u.e() != 0) {
            this.h.B.c("clouds");
            bnf.n(5889);
            bnf.F();
            Project.gluPerspective((float)this.a(f2, true), (float)((float)this.h.d / (float)this.h.e), (float)0.05f, (float)(this.k * 4.0f));
            bnf.n(5888);
            bnf.G();
            this.a(0, f2);
            bnl2.b(f2, n2);
            bnf.p();
            bnf.H();
            bnf.n(5889);
            bnf.F();
            Project.gluPerspective((float)this.a(f2, true), (float)((float)this.h.d / (float)this.h.e), (float)0.05f, (float)(this.k * on.a));
            bnf.n(5888);
        }
    }

    private void p() {
        float f2 = this.h.f.j(1.0f);
        if (!this.h.u.i) {
            f2 /= 2.0f;
        }
        if (f2 == 0.0f) {
            return;
        }
        this.j.setSeed((long)this.m * 312987231);
        rr rr2 = this.h.aa();
        bkr bkr2 = this.h.f;
        cj cj2 = new cj(rr2);
        int n2 = 10;
        double d2 = 0.0;
        double d3 = 0.0;
        double d4 = 0.0;
        int n3 = 0;
        int n4 = (int)(100.0f * f2 * f2);
        if (this.h.u.aB == 1) {
            n4 >>= 1;
        } else if (this.h.u.aB == 2) {
            n4 = 0;
        }
        for (int i2 = 0; i2 < n4; ++i2) {
            cj cj3 = bkr2.p(cj2.a(this.j.nextInt(n2) - this.j.nextInt(n2), 0, this.j.nextInt(n2) - this.j.nextInt(n2)));
            aig aig2 = bkr2.b(cj3);
            cj cj4 = cj3.b();
            arc arc2 = bkr2.o(cj4);
            if (cj3.q() > cj2.q() + n2 || cj3.q() < cj2.q() - n2 || !aig2.d() || aig2.a(cj3) < 0.15f) continue;
            double d5 = this.j.nextDouble();
            double d6 = this.j.nextDouble();
            bbe bbe2 = arc2.c((ahx)bkr2, cj4);
            if (arc2.a() == axd.i) {
                this.h.f.a(cy.l, (double)cj3.p() + d5, (double)((float)cj3.q() + 0.1f) - bbe2.b, (double)cj3.r() + d6, 0.0, 0.0, 0.0, new int[0]);
                continue;
            }
            if (arc2.a() == axd.a) continue;
            if (this.j.nextInt(++n3) == 0) {
                d2 = (double)cj4.p() + d5;
                d3 = (double)((float)cj4.q() + 0.1f) + bbe2.e - 1.0;
                d4 = (double)cj4.r() + d6;
            }
            this.h.f.a(cy.N, (double)cj4.p() + d5, (double)((float)cj4.q() + 0.1f) + bbe2.e, (double)cj4.r() + d6, 0.0, 0.0, 0.0, new int[0]);
        }
        if (n3 > 0 && this.j.nextInt(3) < this.N++) {
            this.N = 0;
            if (d3 > (double)(cj2.q() + 1) && bkr2.p(cj2).q() > on.d((float)cj2.q())) {
                this.h.f.a(d2, d3, d4, ng.gz, nh.d, 0.1f, 0.5f, false);
            } else {
                this.h.f.a(d2, d3, d4, ng.gy, nh.d, 0.2f, 1.0f, false);
            }
        }
    }

    protected void c(float f2) {
        float f3 = this.h.f.j(f2);
        if (f3 <= 0.0f) {
            return;
        }
        this.i();
        rr rr2 = this.h.aa();
        bkr bkr2 = this.h.f;
        int n2 = on.c(rr2.p);
        int n3 = on.c(rr2.q);
        int n4 = on.c(rr2.r);
        bnr bnr2 = bnr.a();
        bmw bmw2 = bnr2.c();
        bnf.r();
        bnf.a(0.0f, 1.0f, 0.0f);
        bnf.m();
        bnf.a(bnf.r.l, bnf.l.j, bnf.r.e, bnf.l.n);
        bnf.a(516, 0.1f);
        double d2 = rr2.M + (rr2.p - rr2.M) * (double)f2;
        double d3 = rr2.N + (rr2.q - rr2.N) * (double)f2;
        double d4 = rr2.O + (rr2.r - rr2.O) * (double)f2;
        int n5 = on.c(d3);
        int n6 = 5;
        if (this.h.u.i) {
            n6 = 10;
        }
        int n7 = -1;
        float f4 = (float)this.m + f2;
        bmw2.c(- d2, - d3, - d4);
        bnf.c(1.0f, 1.0f, 1.0f, 1.0f);
        cj.a a2 = new cj.a();
        for (int i2 = n4 - n6; i2 <= n4 + n6; ++i2) {
            for (int i3 = n2 - n6; i3 <= n2 + n6; ++i3) {
                double d5;
                double d6;
                double d7;
                int n8;
                int n9 = (i2 - n4 + 16) * 32 + i3 - n2 + 16;
                double d8 = (double)this.O[n9] * 0.5;
                double d9 = (double)this.P[n9] * 0.5;
                a2.c(i3, 0, i2);
                aig aig2 = bkr2.b(a2);
                if (!aig2.d() && !aig2.c()) continue;
                int n10 = bkr2.p(a2).q();
                int n11 = n3 - n6;
                int n12 = n3 + n6;
                if (n11 < n10) {
                    n11 = n10;
                }
                if (n12 < n10) {
                    n12 = n10;
                }
                if ((n8 = n10) < n5) {
                    n8 = n5;
                }
                if (n11 == n12) continue;
                this.j.setSeed(i3 * i3 * 3121 + i3 * 45238971 ^ i2 * i2 * 418711 + i2 * 13761);
                a2.c(i3, n11, i2);
                float f5 = aig2.a(a2);
                if (bkr2.A().a(f5, n10) >= 0.15f) {
                    if (n7 != 0) {
                        if (n7 >= 0) {
                            bnr2.b();
                        }
                        n7 = 0;
                        this.h.N().a(f);
                        bmw2.a(7, bvm.d);
                    }
                    d5 = (- (double)(this.m + i3 * i3 * 3121 + i3 * 45238971 + i2 * i2 * 418711 + i2 * 13761 & 31) + (double)f2) / 32.0 * (3.0 + this.j.nextDouble());
                    d7 = (double)((float)i3 + 0.5f) - rr2.p;
                    d6 = (double)((float)i2 + 0.5f) - rr2.r;
                    float f6 = on.a(d7 * d7 + d6 * d6) / (float)n6;
                    float f7 = ((1.0f - f6 * f6) * 0.5f + 0.5f) * f3;
                    a2.c(i3, n8, i2);
                    int n13 = bkr2.b((cj)a2, 0);
                    int n14 = n13 >> 16 & 65535;
                    int n15 = n13 & 65535;
                    bmw2.b((double)i3 - d8 + 0.5, (double)n12, (double)i2 - d9 + 0.5).a(0.0, (double)n11 * 0.25 + d5).a(1.0f, 1.0f, 1.0f, f7).a(n14, n15).d();
                    bmw2.b((double)i3 + d8 + 0.5, (double)n12, (double)i2 + d9 + 0.5).a(1.0, (double)n11 * 0.25 + d5).a(1.0f, 1.0f, 1.0f, f7).a(n14, n15).d();
                    bmw2.b((double)i3 + d8 + 0.5, (double)n11, (double)i2 + d9 + 0.5).a(1.0, (double)n12 * 0.25 + d5).a(1.0f, 1.0f, 1.0f, f7).a(n14, n15).d();
                    bmw2.b((double)i3 - d8 + 0.5, (double)n11, (double)i2 - d9 + 0.5).a(0.0, (double)n12 * 0.25 + d5).a(1.0f, 1.0f, 1.0f, f7).a(n14, n15).d();
                    continue;
                }
                if (n7 != 1) {
                    if (n7 >= 0) {
                        bnr2.b();
                    }
                    n7 = 1;
                    this.h.N().a(g);
                    bmw2.a(7, bvm.d);
                }
                d5 = (- (float)(this.m & 511) + f2) / 512.0f;
                d7 = this.j.nextDouble() + (double)f4 * 0.01 * (double)((float)this.j.nextGaussian());
                d6 = this.j.nextDouble() + (double)(f4 * (float)this.j.nextGaussian()) * 0.001;
                double d10 = (double)((float)i3 + 0.5f) - rr2.p;
                double d11 = (double)((float)i2 + 0.5f) - rr2.r;
                float f8 = on.a(d10 * d10 + d11 * d11) / (float)n6;
                float f9 = ((1.0f - f8 * f8) * 0.3f + 0.5f) * f3;
                a2.c(i3, n8, i2);
                int n16 = (bkr2.b((cj)a2, 0) * 3 + 15728880) / 4;
                int n17 = n16 >> 16 & 65535;
                int n18 = n16 & 65535;
                bmw2.b((double)i3 - d8 + 0.5, (double)n12, (double)i2 - d9 + 0.5).a(0.0 + d7, (double)n11 * 0.25 + d5 + d6).a(1.0f, 1.0f, 1.0f, f9).a(n17, n18).d();
                bmw2.b((double)i3 + d8 + 0.5, (double)n12, (double)i2 + d9 + 0.5).a(1.0 + d7, (double)n11 * 0.25 + d5 + d6).a(1.0f, 1.0f, 1.0f, f9).a(n17, n18).d();
                bmw2.b((double)i3 + d8 + 0.5, (double)n11, (double)i2 + d9 + 0.5).a(1.0 + d7, (double)n12 * 0.25 + d5 + d6).a(1.0f, 1.0f, 1.0f, f9).a(n17, n18).d();
                bmw2.b((double)i3 - d8 + 0.5, (double)n11, (double)i2 - d9 + 0.5).a(0.0 + d7, (double)n12 * 0.25 + d5 + d6).a(1.0f, 1.0f, 1.0f, f9).a(n17, n18).d();
            }
        }
        if (n7 >= 0) {
            bnr2.b();
        }
        bmw2.c(0.0, 0.0, 0.0);
        bnf.q();
        bnf.l();
        bnf.a(516, 0.1f);
        this.h();
    }

    public void j() {
        bcu bcu2 = new bcu(this.h);
        bnf.m(256);
        bnf.n(5889);
        bnf.F();
        bnf.a(0.0, bcu2.c(), bcu2.d(), 0.0, 1000.0, 3000.0);
        bnf.n(5888);
        bnf.F();
        bnf.c(0.0f, 0.0f, -2000.0f);
    }

    private void h(float f2) {
        float f3;
        Object object;
        float f4;
        float f5;
        bkr bkr2 = this.h.f;
        rr rr2 = this.h.aa();
        float f6 = 0.25f + 0.75f * (float)this.h.u.c / 32.0f;
        f6 = 1.0f - (float)Math.pow(f6, 0.25);
        bbg bbg2 = bkr2.a(this.h.aa(), f2);
        float f7 = (float)bbg2.b;
        float f8 = (float)bbg2.c;
        float f9 = (float)bbg2.d;
        bbg bbg3 = bkr2.f(f2);
        this.R = (float)bbg3.b;
        this.S = (float)bbg3.c;
        this.T = (float)bbg3.d;
        if (this.h.u.c >= 4) {
            float[] arrf;
            double d2 = -1.0;
            object = on.a(bkr2.d(f2)) > 0.0f ? new bbg(d2, 0.0, 0.0) : new bbg(1.0, 0.0, 0.0);
            f5 = (float)rr2.f(f2).b((bbg)object);
            if (f5 < 0.0f) {
                f5 = 0.0f;
            }
            if (f5 > 0.0f && (arrf = bkr2.s.a(bkr2.c(f2), f2)) != null) {
                this.R = this.R * (1.0f - f5) + arrf[0] * (f5 *= arrf[3]);
                this.S = this.S * (1.0f - f5) + arrf[1] * f5;
                this.T = this.T * (1.0f - f5) + arrf[2] * f5;
            }
        }
        this.R += (f7 - this.R) * f6;
        this.S += (f8 - this.S) * f6;
        this.T += (f9 - this.T) * f6;
        float f10 = bkr2.j(f2);
        if (f10 > 0.0f) {
            f3 = 1.0f - f10 * 0.5f;
            float f11 = 1.0f - f10 * 0.4f;
            this.R *= f3;
            this.S *= f3;
            this.T *= f11;
        }
        if ((f3 = bkr2.h(f2)) > 0.0f) {
            float f12 = 1.0f - f3 * 0.5f;
            this.R *= f12;
            this.S *= f12;
            this.T *= f12;
        }
        arc object1 = bbx.a(this.h.f, rr2, f2);
        if (this.B) {
            bbg bbg4 = bkr2.e(f2);
            this.R = (float)bbg4.b;
            this.S = (float)bbg4.c;
            this.T = (float)bbg4.d;
        } else if (object1.a() == axd.h) {
            f5 = 0.0f;
            if (rr2 instanceof sa) {
                f5 = (float)ago.c((sa)rr2) * 0.2f;
                if (((sa)rr2).a(rm.m)) {
                    f5 = f5 * 0.3f + 0.6f;
                }
            }
            this.R = 0.02f + f5;
            this.S = 0.02f + f5;
            this.T = 0.2f + f5;
        } else if (object1.a() == axd.i) {
            this.R = 0.6f;
            this.S = 0.1f;
            this.T = 0.0f;
        }
        float f13 = this.U + (this.V - this.U) * f2;
        this.R *= f13;
        this.S *= f13;
        this.T *= f13;
        double d3 = (rr2.N + (rr2.q - rr2.N) * (double)f2) * bkr2.s.j();
        if (rr2 instanceof sa && ((sa)rr2).a(rm.o)) {
            int n2 = ((sa)rr2).b(rm.o).b();
            d3 = n2 < 20 ? (d3 *= (double)(1.0f - (float)n2 / 20.0f)) : 0.0;
        }
        if (d3 < 1.0) {
            if (d3 < 0.0) {
                d3 = 0.0;
            }
            d3 *= d3;
            this.R = (float)((double)this.R * d3);
            this.S = (float)((double)this.S * d3);
            this.T = (float)((double)this.T * d3);
        }
        if (this.z > 0.0f) {
            float f14 = this.A + (this.z - this.A) * f2;
            this.R = this.R * (1.0f - f14) + this.R * 0.7f * f14;
            this.S = this.S * (1.0f - f14) + this.S * 0.6f * f14;
            this.T = this.T * (1.0f - f14) + this.T * 0.6f * f14;
        }
        if (rr2 instanceof sa && ((sa)rr2).a(rm.p)) {
            float f15 = this.a((sa)rr2, f2);
            f4 = 1.0f / this.R;
            if (f4 > 1.0f / this.S) {
                f4 = 1.0f / this.S;
            }
            if (f4 > 1.0f / this.T) {
                f4 = 1.0f / this.T;
            }
            this.R = this.R * (1.0f - f15) + this.R * f4 * f15;
            this.S = this.S * (1.0f - f15) + this.S * f4 * f15;
            this.T = this.T * (1.0f - f15) + this.T * f4 * f15;
        }
        if (this.h.u.e) {
            float f16 = (this.R * 30.0f + this.S * 59.0f + this.T * 11.0f) / 100.0f;
            f4 = (this.R * 30.0f + this.S * 70.0f) / 100.0f;
            float f17 = (this.R * 30.0f + this.T * 70.0f) / 100.0f;
            this.R = f16;
            this.S = f4;
            this.T = f17;
        }
        bnf.a(this.R, this.S, this.T, 0.0f);
    }

    private void a(int n2, float f2) {
        rr rr2 = this.h.aa();
        bnf.b(2918, this.a(this.R, this.S, this.T, 1.0f));
        bnf.a(0.0f, -1.0f, 0.0f);
        bnf.c(1.0f, 1.0f, 1.0f, 1.0f);
        arc arc2 = bbx.a(this.h.f, rr2, f2);
        if (rr2 instanceof sa && ((sa)rr2).a(rm.o)) {
            float f3 = 5.0f;
            int n3 = ((sa)rr2).b(rm.o).b();
            if (n3 < 20) {
                f3 = 5.0f + (this.k - 5.0f) * (1.0f - (float)n3 / 20.0f);
            }
            bnf.a(bnf.m.a);
            if (n2 == -1) {
                bnf.b(0.0f);
                bnf.c(f3 * 0.8f);
            } else {
                bnf.b(f3 * 0.25f);
                bnf.c(f3);
            }
            if (GLContext.getCapabilities().GL_NV_fog_distance) {
                bnf.c(34138, 34139);
            }
        } else if (this.B) {
            bnf.a(bnf.m.b);
            bnf.a(0.1f);
        } else if (arc2.a() == axd.h) {
            bnf.a(bnf.m.b);
            if (rr2 instanceof sa) {
                if (((sa)rr2).a(rm.m)) {
                    bnf.a(0.01f);
                } else {
                    bnf.a(0.1f - (float)ago.c((sa)rr2) * 0.03f);
                }
            } else {
                bnf.a(0.1f);
            }
        } else if (arc2.a() == axd.i) {
            bnf.a(bnf.m.b);
            bnf.a(2.0f);
        } else {
            float f4 = this.k;
            bnf.a(bnf.m.a);
            if (n2 == -1) {
                bnf.b(0.0f);
                bnf.c(f4);
            } else {
                bnf.b(f4 * 0.75f);
                bnf.c(f4);
            }
            if (GLContext.getCapabilities().GL_NV_fog_distance) {
                bnf.c(34138, 34139);
            }
            if (this.h.f.s.b((int)rr2.p, (int)rr2.r) || this.h.r.j().f()) {
                bnf.b(f4 * 0.05f);
                bnf.c(Math.min(f4, 192.0f) * 0.5f);
            }
        }
        bnf.h();
        bnf.o();
        bnf.a(1028, 4608);
    }

    private FloatBuffer a(float f2, float f3, float f4, float f5) {
        this.Q.clear();
        this.Q.put(f2).put(f3).put(f4).put(f5);
        this.Q.flip();
        return this.Q;
    }

    public bct k() {
        return this.l;
    }

    static /* synthetic */ bcc a(bnd bnd2) {
        return bnd2.h;
    }

    static {
        ac = new kk[]{new kk("shaders/post/notch.json"), new kk("shaders/post/fxaa.json"), new kk("shaders/post/art.json"), new kk("shaders/post/bumpy.json"), new kk("shaders/post/blobs2.json"), new kk("shaders/post/pencil.json"), new kk("shaders/post/color_convolve.json"), new kk("shaders/post/deconverge.json"), new kk("shaders/post/flip.json"), new kk("shaders/post/invert.json"), new kk("shaders/post/ntsc.json"), new kk("shaders/post/outline.json"), new kk("shaders/post/phosphor.json"), new kk("shaders/post/scan_pincushion.json"), new kk("shaders/post/sobel.json"), new kk("shaders/post/bits.json"), new kk("shaders/post/desaturate.json"), new kk("shaders/post/green.json"), new kk("shaders/post/blur.json"), new kk("shaders/post/wobble.json"), new kk("shaders/post/blobs.json"), new kk("shaders/post/antialias.json"), new kk("shaders/post/creeper.json"), new kk("shaders/post/spider.json")};
        d = ac.length;
    }

}
