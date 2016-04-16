// GuiOverlayDebug

/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Strings
 *  com.google.common.collect.ImmutableMap
 *  com.google.common.collect.ImmutableSet
 *  com.google.common.collect.Lists
 *  org.lwjgl.opengl.Display
 */
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import net.minecraft.client.ClientBrandRetriever;
import org.lwjgl.opengl.Display;

public class bcz
extends bcs {
    private final bcc a;
    private final bcq f;

    public bcz(bcc bcc2) {
        this.a = bcc2;
        this.f = bcc2.k;
    }

    public void a(bcu bcu2) {
        this.a.B.a("debug");
        bnf.G();
        this.a();
        this.b(bcu2);
        bnf.H();
        if (this.a.u.at) {
            this.e();
        }
        this.a.B.b();
    }

    private boolean d() {
        return this.a.h.cX() || this.a.u.v;
    }

    protected void a() {
        List<String> list = this.b();
        list.add("");
        list.add("Debug: Pie [shift]: " + (this.a.u.as ? "visible" : "hidden") + " FPS [alt]: " + (this.a.u.at ? "visible" : "hidden"));
        list.add("For help: press F3 + Q");
        for (int i2 = 0; i2 < list.size(); ++i2) {
            String string = list.get(i2);
            if (Strings.isNullOrEmpty((String)string)) continue;
            int n2 = this.f.a;
            int n3 = this.f.a(string);
            int n4 = 2;
            int n5 = 2 + n2 * i2;
            bcz.a(1, n5 - 1, 2 + n3 + 1, n5 + n2 - 1, -1873784752);
            this.f.a(string, 2, n5, 14737632);
        }
    }

    protected void b(bcu bcu2) {
        List<String> list = this.c();
        for (int i2 = 0; i2 < list.size(); ++i2) {
            String string = list.get(i2);
            if (Strings.isNullOrEmpty((String)string)) continue;
            int n2 = this.f.a;
            int n3 = this.f.a(string);
            int n4 = bcu2.a() - 2 - n3;
            int n5 = 2 + n2 * i2;
            bcz.a(n4 - 1, n5 - 1, n4 + n3 + 1, n5 + n2 - 1, -1873784752);
            this.f.a(string, n4, n5, 14737632);
        }
    }

    protected List<String> b() {
        Object object;
        cj cj2 = new cj(this.a.aa().p, this.a.aa().bl().b, this.a.aa().r);
        if (this.d()) {
            return Lists.newArrayList(new String[]{"Minecraft 1.9.2 (" + this.a.c() + "/" + ClientBrandRetriever.getClientModName() + ")", this.a.D, this.a.g.f(), this.a.g.h(), "P: " + this.a.j.b() + ". T: " + this.a.f.F(), this.a.f.G(), "", String.format("Chunk-relative: %d %d %d", cj2.p() & 15, cj2.q() & 15, cj2.r() & 15)});
        }
        rr rr2 = this.a.aa();
        cq cq2 = rr2.bi();
        String string = "Invalid";
        switch (cq2) {
            case c: {
                string = "Towards negative Z";
                break;
            }
            case d: {
                string = "Towards positive Z";
                break;
            }
            case e: {
                string = "Towards negative X";
                break;
            }
            case f: {
                string = "Towards positive X";
            }
        }
        Object[] arrobject = new String[11];
        arrobject[0] = "Minecraft 1.9.2 (" + this.a.c() + "/" + ClientBrandRetriever.getClientModName() + ("release".equalsIgnoreCase(this.a.d()) ? "" : new StringBuilder().append("/").append(this.a.d()).toString()) + ")";
        arrobject[1] = this.a.D;
        arrobject[2] = this.a.g.f();
        arrobject[3] = this.a.g.h();
        arrobject[4] = "P: " + this.a.j.b() + ". T: " + this.a.f.F();
        arrobject[5] = this.a.f.G();
        arrobject[6] = "";
        arrobject[7] = String.format("XYZ: %.3f / %.5f / %.3f", this.a.aa().p, this.a.aa().bl().b, this.a.aa().r);
        arrobject[8] = String.format("Block: %d %d %d", cj2.p(), cj2.q(), cj2.r());
        arrobject[9] = String.format("Chunk: %d %d %d in %d %d %d", cj2.p() & 15, cj2.q() & 15, cj2.r() & 15, cj2.p() >> 4, cj2.q() >> 4, cj2.r() >> 4);
        arrobject[10] = String.format("Facing: %s (%s) (%.1f / %.1f)", cq2, string, Float.valueOf(on.g(rr2.v)), Float.valueOf(on.g(rr2.w)));
        ArrayList arrayList = Lists.newArrayList((Object[])arrobject);
        if (this.a.f != null) {
            ase ase1 = this.a.f.f(cj2);
            if (!this.a.f.e(cj2)) {
                arrayList.add("Outside of world...");
            } else if (!ase1.f()) {
                lr lr2;
                arrayList.add("Biome: " + ase1.a(cj2, this.a.f.A()).l());
                arrayList.add("Light: " + ase1.a(cj2, 0) + " (" + ase1.a(ahz.a, cj2) + " sky, " + ase1.a(ahz.b, cj2) + " block)");
                ql ql2 = this.a.f.D(cj2);
                if (this.a.D() && this.a.F() != null && (lr2 = this.a.F().al().a(this.a.h.bc())) != null) {
                    ql2 = lr2.l.D(new cj(lr2));
                }
                arrayList.add(String.format("Local Difficulty: %.2f // %.2f (Day %d)", Float.valueOf(ql2.b()), Float.valueOf(ql2.c()), this.a.f.Q() / 24000));
            } else {
                arrayList.add("Waiting for chunk...");
            }
        }
        if (this.a.o != null && this.a.o.a()) {
            arrayList.add("Shader: " + this.a.o.f().b());
        }
        if (this.a.t != null && this.a.t.a == Namepipe.bbf_a.b && this.a.t.a() != null) {
            cj object1 = this.a.t.a();
            arrayList.add(String.format("Looking at: %d %d %d", object1.p(), object1.q(), object1.r()));
        }
        return arrayList;
    }

    protected <T extends Comparable<T>> List<String> c() {
        long l2 = Runtime.getRuntime().maxMemory();
        long l3 = Runtime.getRuntime().totalMemory();
        long l4 = Runtime.getRuntime().freeMemory();
        long l5 = l3 - l4;
        Object[] arrobject = new String[12];
        Object[] arrobject2 = new Object[2];
        arrobject2[0] = System.getProperty("java.version");
        arrobject2[1] = this.a.S() ? 64 : 32;
        arrobject[0] = String.format("Java: %s %dbit", arrobject2);
        arrobject[1] = String.format("Mem: % 2d%% %03d/%03dMB", l5 * 100 / l2, bcz.a(l5), bcz.a(l2));
        arrobject[2] = String.format("Allocated: % 2d%% %03dMB", l3 * 100 / l2, bcz.a(l3));
        arrobject[3] = "";
        arrobject[4] = String.format("CPU: %s", bze.k());
        arrobject[5] = "";
        arrobject[6] = String.format("Display: %dx%d (%s)", Display.getWidth(), Display.getHeight(), bnf.u(7936));
        arrobject[7] = bnf.u(7937);
        arrobject[8] = bnf.u(7938);
        
        // Cubitick : add some tick info
        arrobject[ 9] = ("");
        arrobject[10] = ("Server tick : " + (a.D() ? a.F().ap() : "Unreachable"));
        arrobject[11] = ("Client tick : " + a.tickcounter);
        
        ArrayList arrayList = Lists.newArrayList((Object[])arrobject);
        if (this.d()) {
            return arrayList;
        }
        if (this.a.t != null && this.a.t.a == Namepipe.bbf_a.b && this.a.t.a() != null) {
            cj cj2 = this.a.t.a();
            arc arc2 = this.a.f.o(cj2);
            if (this.a.f.L() != ahy.g) {
                arc2 = arc2.b((ahx)this.a.f, cj2);
            }
            arrayList.add("");
            arrayList.add(String.valueOf(ajt.h.b(arc2.t())));
            for (Map.Entry entry : arc2.s().entrySet()) {
                arr arr2 = (arr)entry.getKey();
                Comparable comparable = (Comparable)entry.getValue();
                String string = arr2.a(comparable);
                if (comparable == Boolean.TRUE) {
                    string = (Object)((Object)a.k) + string;
                } else if (comparable == Boolean.FALSE) {
                    string = (Object)((Object)a.m) + string;
                }
                arrayList.add(arr2.a() + ": " + string);
            }
        }
        return arrayList;
    }

    private void e() {
        bnf.j();
        oc oc2 = this.a.ag();
        int n2 = oc2.a();
        int n3 = oc2.b();
        long[] arrl = oc2.c();
        bcu bcu2 = new bcu(this.a);
        int n4 = n2;
        int n5 = 0;
        bcz.a(0, bcu2.b() - 60, 240, bcu2.b(), -1873784752);
        while (n4 != n3) {
            int n6 = oc2.a(arrl[n4], 30);
            int n7 = this.c(on.a(n6, 0, 60), 0, 30, 60);
            this.b(n5, bcu2.b(), bcu2.b() - n6, n7);
            ++n5;
            n4 = oc2.b(n4 + 1);
        }
        bcz.a(1, bcu2.b() - 30 + 1, 14, bcu2.b() - 30 + 10, -1873784752);
        this.f.a("60", 2, bcu2.b() - 30 + 2, 14737632);
        this.a(0, 239, bcu2.b() - 30, -1);
        bcz.a(1, bcu2.b() - 60 + 1, 14, bcu2.b() - 60 + 10, -1873784752);
        this.f.a("30", 2, bcu2.b() - 60 + 2, 14737632);
        this.a(0, 239, bcu2.b() - 60, -1);
        this.a(0, 239, bcu2.b() - 1, -1);
        this.b(0, bcu2.b() - 60, bcu2.b(), -1);
        this.b(239, bcu2.b() - 60, bcu2.b(), -1);
        if (this.a.u.g <= 120) {
            this.a(0, 239, bcu2.b() - 60 + this.a.u.g / 2, -16711681);
        }
        bnf.k();
    }

    private int c(int n2, int n3, int n4, int n5) {
        if (n2 < n4) {
            return this.a(-16711936, -256, (float)n2 / (float)n4);
        }
        return this.a(-256, -65536, (float)(n2 - n4) / (float)(n5 - n4));
    }

    private int a(int n2, int n3, float f2) {
        int n4 = n2 >> 24 & 255;
        int n5 = n2 >> 16 & 255;
        int n6 = n2 >> 8 & 255;
        int n7 = n2 & 255;
        int n8 = n3 >> 24 & 255;
        int n9 = n3 >> 16 & 255;
        int n10 = n3 >> 8 & 255;
        int n11 = n3 & 255;
        int n12 = on.a((int)((float)n4 + (float)(n8 - n4) * f2), 0, 255);
        int n13 = on.a((int)((float)n5 + (float)(n9 - n5) * f2), 0, 255);
        int n14 = on.a((int)((float)n6 + (float)(n10 - n6) * f2), 0, 255);
        int n15 = on.a((int)((float)n7 + (float)(n11 - n7) * f2), 0, 255);
        return n12 << 24 | n13 << 16 | n14 << 8 | n15;
    }

    private static long a(long l2) {
        return l2 / 1024 / 1024;
    }

}
