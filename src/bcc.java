// Minecraft

/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 *  com.google.common.collect.Maps
 *  com.google.common.collect.Multimap
 *  com.google.common.collect.Queues
 *  com.google.common.collect.Sets
 *  com.google.common.util.concurrent.Futures
 *  com.google.common.util.concurrent.ListenableFuture
 *  com.google.common.util.concurrent.ListenableFutureTask
 *  com.mojang.authlib.GameProfile
 *  com.mojang.authlib.GameProfileRepository
 *  com.mojang.authlib.minecraft.MinecraftSessionService
 *  com.mojang.authlib.properties.PropertyMap
 *  com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService
 *  org.apache.commons.io.IOUtils
 *  org.apache.commons.lang3.Validate
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 *  org.lwjgl.LWJGLException
 *  org.lwjgl.Sys
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.input.Mouse
 *  org.lwjgl.opengl.ContextCapabilities
 *  org.lwjgl.opengl.Display
 *  org.lwjgl.opengl.DisplayMode
 *  org.lwjgl.opengl.GLContext
 *  org.lwjgl.opengl.OpenGLException
 *  org.lwjgl.opengl.PixelFormat
 *  org.lwjgl.util.glu.GLU
 */
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Queues;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.GameProfileRepository;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import com.mojang.authlib.properties.PropertyMap;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.Proxy;
import java.net.SocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import javax.imageio.ImageIO;
import net.minecraft.client.ClientBrandRetriever;
import net.minecraft.server.MinecraftServer;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.opengl.OpenGLException;
import org.lwjgl.opengl.PixelFormat;
import org.lwjgl.util.glu.GLU;

public class bcc
implements qc,
qx {
    private static final Logger L = LogManager.getLogger();
    private static final kk M = new kk("textures/gui/title/mojang.png");
    public static final boolean a = Namepipe.g.a() == Namepipe.g_a.d;
    public static byte[] b = new byte[10485760];
    private static final List<DisplayMode> N = Lists.newArrayList(new DisplayMode[]{new DisplayMode(2560, 1600), new DisplayMode(2880, 1800)});
    private final File O;
    private final PropertyMap P;
    private final PropertyMap Q;
    private bku R;
    private bvf S;
    private static bcc T;
    private final pb U = pc.a();
    public bkq c;
    private boolean V;
    private boolean W = true;
    private boolean X;
    private b Y;
    public int d;
    public int e;
    private boolean Z = false;

    // Cubitick: make timer public
    public bci timerWorld = new bci(Cubitick.tickrateWorld);
    public bci timer = new bci(Cubitick.tickrate);
    public static long tickcounter = 0;
    public boolean scheduledReload = false;
    
    private qw ab;
    public bkr f;
    public bnl g;
    private brj ac;
    private brw ad;
    private bnh ae;
    public bmq h;
    private rr af;
    public rr i;
    public blv j;
    private final bcj ag;
    private boolean ah;
    public bcq k;
    public bcq l;
    public bey m;
    public bcf n;
    public bnd o;
    public bqp p;
    private int ai;
    private int aj;
    private int ak;
    private byl al;
    public bfi q;
    public bcr r;
    public boolean s;
    public bbf t;
    public bce u;
    public bcd v;
    public final File w;
    private final File am;
    private final String an;
    private final String ao;
    private final Proxy ap;
    private azj aq;
    private static int ar;
    private int as;
    private String at;
    private int au;
    public boolean x;
    long y;
    private int av;
    public final oc z;
    long A;
    private final boolean aw;
    private final boolean ax;
    private ek ay;
    private boolean az;
    public final oo B;
    private long aA;
    private bwb aB;
    private final bwt aC;
    private final List<bwf> aD;
    private final bvu aE;
    private bwh aF;
    private bwn aG;
    private bcl aH;
    private bco aI;
    private bnq aJ;
    private bvd aK;
    private byv aL;
    private bys aM;
    private kk aN;
    private final MinecraftSessionService aO;
    private bwk aP;
    private final Queue<FutureTask<?>> aQ;
    private long aR;
    private final Thread aS;
    private bxp aT;
    private bnz aU;
    volatile boolean C;
    public String D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    long I;
    int J;
    private boolean aV;
    long K;
    private String aW;

    public bcc(bhy bhy2) {
        this.ab = new qw("client", this, MinecraftServer.av());
        this.y = bcc.I();
        this.z = new oc();
        this.A = System.nanoTime();
        this.B = new oo();
        this.aA = -1;
        this.aC = new bwt();
        this.aD = Lists.newArrayList();
        this.aQ = Queues.newArrayDeque();
        this.aR = 0;
        this.aS = Thread.currentThread();
        this.C = true;
        this.D = "";
        this.E = false;
        this.F = false;
        this.G = false;
        this.H = true;
        this.I = bcc.I();
        this.K = -1;
        this.aW = "root";
        T = this;
        this.w = bhy2.c.a;
        this.am = bhy2.c.c;
        this.O = bhy2.c.b;
        this.an = bhy2.d.b;
        this.ao = bhy2.d.c;
        this.P = bhy2.a.b;
        this.Q = bhy2.a.c;
        this.aE = new bvu(bhy2.c.a());
        this.ap = bhy2.a.d == null ? Proxy.NO_PROXY : bhy2.a.d;
        this.aO = new YggdrasilAuthenticationService(this.ap, UUID.randomUUID().toString()).createMinecraftSessionService();
        this.ag = bhy2.a.a;
        L.info("Setting user: " + this.ag.c());
        L.debug("(Session ID is " + this.ag.a() + ")");
        this.ax = bhy2.d.a;
        this.d = bhy2.b.a > 0 ? bhy2.b.a : 1;
        this.e = bhy2.b.b > 0 ? bhy2.b.b : 1;
        this.aj = bhy2.b.a;
        this.ak = bhy2.b.b;
        this.V = bhy2.b.c;
        this.aw = bcc.as();
        this.al = null;
        if (bhy2.e.a != null) {
            this.at = bhy2.e.a;
            this.au = bhy2.e.b;
        }
        ImageIO.setUseCache(false);
        kn.c();
    }
    
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    
    /*
    public void a_broken() {
        block17 : {
            this.C = true;
            try {
                this.an();
            }
            catch (Throwable err) {
                b b2 = Namepipe.b.a(err, "Initializing game");
                b2.a("Initialization");
                this.c(this.b(b2));
                return;
            }
            do {
                try {
                    if (this.C) {
                        if (this.X && this.Y != null) {
                            this.c(this.Y);
                            return;
                        }
                        try {
                            this.av();
                        }
                        catch (OutOfMemoryError err) {
                            this.m();
                            this.a(new bet());
                            System.gc();
                        }
                        continue;
                    }
                    break block17;
                }
                catch (bch err) {}
                catch (e err) {
                    this.b(err.a());
                    this.m();
                    L.fatal("Reported exception thrown!", (Throwable)err);
                    this.c(err.a());
                }
                catch (Throwable err) {
                    b b3 = this.b(new b("Unexpected error", err));
                    this.m();
                    L.fatal("Unreported exception thrown!", err);
                    this.c(b3);
                }
            } while (true);
            finally {
                this.h();
            }
        }
    }*/
    
    // fixed bcc.a() = Minecraft.run()
    public void a() {
        this.C = true;
        try {
            this.an();
            
            // Cubitick
            new Cubitick();
        }
        catch (Throwable t) {
            return;
        }
        try {
            while (this.C) {
                if (this.X && this.Y != null) {
                    this.c(this.Y);
                    return;
                }
                try {
                    this.av();
                }
                catch (OutOfMemoryError outOfMemoryError) {
                    this.m();
                    this.a(new bet());
                    System.gc();
                }
            }
        }
        catch (bch err) {}
        catch (e e) {
            this.b(e.a());
            this.m();
            L.fatal("Reported exception thrown!", (Throwable)e);
            this.c(e.a());
        }
        catch (Throwable t) {
            final b b = this.b(new b("Unexpected error", t));
            this.m();
            L.fatal("Unreported exception thrown!", t);
            this.c(b);
        }
        finally {
            this.h();
        }
    }

    private void an() throws LWJGLException, IOException {
        this.u = new bce(this, this.w);
        this.aD.add(this.aE);
        this.at();
        if (this.u.C > 0 && this.u.B > 0) {
            this.d = this.u.B;
            this.e = this.u.C;
        }
        L.info("LWJGL Version: " + Sys.getVersion());
        this.ar();
        this.aq();
        this.ap();
        bze.a();
        this.aJ = new bnq(this.d, this.e, true);
        this.aJ.a(0.0f, 0.0f, 0.0f, 0.0f);
        this.ao();
        this.aF = new bwh(this.O, new File(this.w, "server-resource-packs"), this.aE, this.aC, this.u);
        this.aB = new bwi(this.aC);
        this.aG = new bwn(this.aC, this.u.aC);
        this.aB.a(this.aG);
        this.f();
        this.S = new bvf(this.aB);
        this.aB.a(this.S);
        this.a(this.S);
        this.aP = new bwk(this.S, new File(this.am, "skins"), this.aO);
        this.aq = new azc(new File(this.w, "saves"), this.U);
        this.aL = new byv(this.aB, this.u);
        this.aB.a(this.aL);
        this.aM = new bys(this);
        this.k = new bcq(this.u, new kk("textures/font/ascii.png"), this.S, false);
        if (this.u.aC != null) {
            this.k.a(this.e());
            this.k.b(this.aG.b());
        }
        this.l = new bcq(this.u, new kk("textures/font/ascii_sga.png"), this.S, false);
        this.aB.a(this.k);
        this.aB.a(this.l);
        this.aB.a(new bwa());
        this.aB.a(new bvz());
        nk.f.a(new nl(){

            @Override
            public String a(String string) {
                try {
                    return String.format(string, bce.c(bcc.this.u.X.j()));
                }
                catch (Exception err) {
                    return "Error: " + err.getLocalizedMessage();
                }
            }
        });
        this.v = new bcd();
        this.a("Pre startup");
        bnf.y();
        bnf.j(7425);
        bnf.a(1.0);
        bnf.k();
        bnf.c(515);
        bnf.e();
        bnf.a(516, 0.1f);
        bnf.a(bnf.i.b);
        bnf.n(5889);
        bnf.F();
        bnf.n(5888);
        this.a("Startup");
        this.aK = new bvd("textures");
        this.aK.a(this.u.J);
        this.S.a(bvd.g, this.aK);
        this.S.a(bvd.g);
        this.aK.a(false, this.u.J > 0);
        this.aT = new bxp(this.aK);
        this.aB.a(this.aT);
        this.aH = bcl.a();
        this.aI = bco.a(this.aH);
        this.ad = new brw(this.S, this.aT, this.aI);
        this.ac = new brj(this.S, this.ad);
        this.ae = new bnh(this);
        this.aB.a(this.ad);
        this.o = new bnd(this, this.aB);
        this.aB.a(this.o);
        this.aU = new bnz(this.aT.c(), this.aH);
        this.aB.a(this.aU);
        this.g = new bnl(this);
        this.aB.a(this.g);
        this.q = new bfi(this);
        bnf.b(0, 0, this.d, this.e);
        this.j = new blv(this.f, this.S);
        this.a("Post startup");
        this.r = new bcr(this);
        if (this.at != null) {
            this.a(new bef(new bff(), this, this.at, this.au));
        } else {
            this.a(new bff());
        }
        this.S.c(this.aN);
        this.aN = null;
        this.n = new bcf(this);
        this.p = new bqp(this);
        if (this.u.s && !this.V) {
            this.r();
        }
        try {
            Display.setVSyncEnabled((boolean)this.u.t);
        }
        catch (OpenGLException err) {
            this.u.t = false;
            this.u.b();
        }
        this.g.b();
    }

    private void ao() {
        this.aC.a(new bxj(), bxi.class);
        this.aC.a(new bwz(), bwy.class);
        this.aC.a(new bww(), bwv.class);
        this.aC.a(new bxf(), bxe.class);
        this.aC.a(new bxc(), bxb.class);
    }

    private void ap() throws LWJGLException {
        Display.setResizable((boolean)true);
        Display.setTitle((String)"Minecraft 1.9.2");
        try {
            Display.create((PixelFormat)new PixelFormat().withDepthBits(24));
        }
        catch (LWJGLException err) {
            L.error("Couldn't set pixel format", (Throwable)err);
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException var2_2) {
                // empty catch block
            }
            if (this.V) {
                this.au();
            }
            Display.create();
        }
    }

    private void aq() throws LWJGLException {
        if (this.V) {
            Display.setFullscreen((boolean)true);
            DisplayMode displayMode = Display.getDisplayMode();
            this.d = Math.max(1, displayMode.getWidth());
            this.e = Math.max(1, displayMode.getHeight());
        } else {
            Display.setDisplayMode((DisplayMode)new DisplayMode(this.d, this.e));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void ar() {
        g.a a2 = Namepipe.g.a();
        if (a2 != Namepipe.g_a.d) {
            InputStream inputStream = null;
            InputStream inputStream2 = null;
            try {
                inputStream = this.aE.c(new kk("icons/icon_16x16.png"));
                inputStream2 = this.aE.c(new kk("icons/icon_32x32.png"));
                if (inputStream != null && inputStream2 != null) {
                    Display.setIcon((ByteBuffer[])new ByteBuffer[]{this.a(inputStream), this.a(inputStream2)});
                }
            }
            catch (IOException err) {
                L.error("Couldn't set icon", (Throwable)err);
            }
            finally {
                IOUtils.closeQuietly((InputStream)inputStream);
                IOUtils.closeQuietly((InputStream)inputStream2);
            }
        }
    }

    private static boolean as() {
        String[] arrstring;
        for (String string : arrstring = new String[]{"sun.arch.data.model", "com.ibm.vm.bitmode", "os.arch"}) {
            String string2 = System.getProperty(string);
            if (string2 == null || !string2.contains("64")) continue;
            return true;
        }
        return false;
    }

    public bnq b() {
        return this.aJ;
    }

    public String c() {
        return this.an;
    }

    public String d() {
        return this.ao;
    }

    private void at() {
        Thread thread = new Thread("Timer hack thread"){

            @Override
            public void run() {
                while (bcc.this.C) {
                    try {
                        Thread.sleep(Integer.MAX_VALUE);
                    }
                    catch (InterruptedException var1_1) {}
                }
            }
        };
        thread.setDaemon(true);
        thread.start();
    }

    public void a(b b2) {
        this.X = true;
        this.Y = b2;
    }

    public void c(b b2) {
        File file = new File(bcc.z().w, "crash-reports");
        File file2 = new File(file, "crash-" + new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss").format(new Date()) + "-client.txt");
        kn.a(b2.e());
        if (b2.f() != null) {
            kn.a("#@!@# Game crashed! Crash report saved to: #@!@# " + b2.f());
            System.exit(-1);
        } else if (b2.a(file2)) {
            kn.a("#@!@# Game crashed! Crash report saved to: #@!@# " + file2.getAbsolutePath());
            System.exit(-1);
        } else {
            kn.a("#@?@# Game crashed! Crash report could not be saved. #@?@#");
            System.exit(-2);
        }
    }

    public boolean e() {
        return this.aG.a() || this.u.aD;
    }

    public void f() {
        ArrayList arrayList = Lists.newArrayList(this.aD);
        if (this.al != null) {
            this.al.b();
        }
        for (bwh.a a2 : this.aF.d()) {
            arrayList.add(a2.c());
        }
        if (this.aF.f() != null) {
            arrayList.add(this.aF.f());
        }
        try {
            this.aB.a(arrayList);
        }
        catch (RuntimeException err) {
            L.info("Caught error stitching, removing all assigned resourcepacks", (Throwable)err);
            arrayList.clear();
            arrayList.addAll(this.aD);
            this.aF.a(Collections.<bwh.a>emptyList());
            this.aB.a(arrayList);
            this.u.k.clear();
            this.u.l.clear();
            this.u.b();
        }
        this.aG.a(arrayList);
        if (this.g != null) {
            this.g.a();
        }
    }

    private ByteBuffer a(InputStream inputStream) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(inputStream);
        int[] arrn = bufferedImage.getRGB(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), null, 0, bufferedImage.getWidth());
        ByteBuffer byteBuffer = ByteBuffer.allocate(4 * arrn.length);
        for (int n2 : arrn) {
            byteBuffer.putInt(n2 << 8 | n2 >> 24 & 255);
        }
        byteBuffer.flip();
        return byteBuffer;
    }

    private void au() throws LWJGLException {
        HashSet<DisplayMode> hashSet = Sets.newHashSet();
        Collections.addAll(hashSet, Display.getAvailableDisplayModes());
        DisplayMode displayMode = Display.getDesktopDisplayMode();
        if (!hashSet.contains((Object)displayMode) && Namepipe.g.a() == Namepipe.g_a.d) {
            block0 : for (DisplayMode displayMode2 : N) {
                boolean bl2 = true;
                for (DisplayMode displayMode32 : hashSet) {
                    if (displayMode32.getBitsPerPixel() != 32 || displayMode32.getWidth() != displayMode2.getWidth() || displayMode32.getHeight() != displayMode2.getHeight()) continue;
                    bl2 = false;
                    break;
                }
                if (bl2) continue;
                for (DisplayMode displayMode32 : hashSet) {
                    if (displayMode32.getBitsPerPixel() != 32 || displayMode32.getWidth() != displayMode2.getWidth() / 2 || displayMode32.getHeight() != displayMode2.getHeight() / 2) continue;
                    displayMode = displayMode32;
                    continue block0;
                }
            }
        }
        Display.setDisplayMode((DisplayMode)displayMode);
        this.d = displayMode.getWidth();
        this.e = displayMode.getHeight();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void a(bvf bvf2) throws LWJGLException {
        bcu bcu2 = new bcu(this);
        int n2 = bcu2.e();
        bnq bnq2 = new bnq(bcu2.a() * n2, bcu2.b() * n2, true);
        bnq2.a(false);
        bnf.n(5889);
        bnf.F();
        bnf.a(0.0, bcu2.a(), bcu2.b(), 0.0, 1000.0, 3000.0);
        bnf.n(5888);
        bnf.F();
        bnf.c(0.0f, 0.0f, -2000.0f);
        bnf.g();
        bnf.p();
        bnf.j();
        bnf.y();
        InputStream inputStream = null;
        try {
            inputStream = this.aE.a(M);
            this.aN = bvf2.a("logo", new buu(ImageIO.read(inputStream)));
            bvf2.a(this.aN);
        }
        catch (IOException err) {
            L.error("Unable to load logo: " + M, (Throwable)err);
        }
        finally {
            IOUtils.closeQuietly((InputStream)inputStream);
        }
        bnr bnr2 = bnr.a();
        bmw bmw2 = bnr2.c();
        bmw2.a(7, bvm.i);
        bmw2.b(0.0, (double)this.e, 0.0).a(0.0, 0.0).b(255, 255, 255, 255).d();
        bmw2.b((double)this.d, (double)this.e, 0.0).a(0.0, 0.0).b(255, 255, 255, 255).d();
        bmw2.b((double)this.d, 0.0, 0.0).a(0.0, 0.0).b(255, 255, 255, 255).d();
        bmw2.b(0.0, 0.0, 0.0).a(0.0, 0.0).b(255, 255, 255, 255).d();
        bnr2.b();
        bnf.c(1.0f, 1.0f, 1.0f, 1.0f);
        int n3 = 256;
        int n4 = 256;
        this.a((bcu2.a() - n3) / 2, (bcu2.b() - n4) / 2, 0, 0, n3, n4, 255, 255, 255, 255);
        bnf.g();
        bnf.p();
        bnq2.e();
        bnq2.c(bcu2.a() * n2, bcu2.b() * n2);
        bnf.e();
        bnf.a(516, 0.1f);
        this.i();
    }

    public void a(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11) {
        float f2 = 0.00390625f;
        float f3 = 0.00390625f;
        bmw bmw2 = bnr.a().c();
        bmw2.a(7, bvm.i);
        bmw2.b((double)n2, (double)(n3 + n7), 0.0).a((float)n4 * f2, (float)(n5 + n7) * f3).b(n8, n9, n10, n11).d();
        bmw2.b((double)(n2 + n6), (double)(n3 + n7), 0.0).a((float)(n4 + n6) * f2, (float)(n5 + n7) * f3).b(n8, n9, n10, n11).d();
        bmw2.b((double)(n2 + n6), (double)n3, 0.0).a((float)(n4 + n6) * f2, (float)n5 * f3).b(n8, n9, n10, n11).d();
        bmw2.b((double)n2, (double)n3, 0.0).a((float)n4 * f2, (float)n5 * f3).b(n8, n9, n10, n11).d();
        bnr.a().b();
    }

    public azj g() {
        return this.aq;
    }

    public void a(bey bey2) {
        if (this.m != null) {
            this.m.m();
        }
        if (bey2 == null && this.f == null) {
            bey2 = new bff();
        } else if (bey2 == null && this.h.bQ() <= 0.0f) {
            bey2 = new bej(null);
        }
        if (bey2 instanceof bff || bey2 instanceof bgo) {
            this.u.ar = false;
            this.r.d().a();
        }
        this.m = bey2;
        if (bey2 != null) {
            this.p();
            bbz.b();
            while (Mouse.next()) {
            }
            while (Keyboard.next()) {
            }
            bcu bcu2 = new bcu(this);
            int n2 = bcu2.a();
            int n3 = bcu2.b();
            bey2.a(this, n2, n3);
            this.s = false;
        } else {
            this.aL.e();
            this.o();
        }
    }

    private void a(String string) {
        if (!this.W) {
            return;
        }
        int n2 = bnf.L();
        if (n2 != 0) {
            String string2 = GLU.gluErrorString((int)n2);
            L.error("########## GL ERROR ##########");
            L.error("@ " + string);
            L.error("" + n2 + ": " + string2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void h() {
        try {
            L.info("Stopping!");
            try {
                this.a((bkr)null);
            }
            catch (Throwable var1_1) {
                // empty catch block
            }
            this.aL.d();
        }
        finally {
            Display.destroy();
            if (!this.X) {
                System.exit(0);
            }
        }
        System.gc();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void av() {
        long l2 = System.nanoTime();
        this.B.a("root");
        if (Display.isCreated() && Display.isCloseRequested()) {
            this.n();
        }
        if (this.ah && this.f != null) {
            float f2 = this.timer.c;
            this.timer.a();
            this.timer.c = f2;
            
            // Cubitick
            float rptw = this.timerWorld.c; //renderPartialTicks;
            this.timerWorld.a(); //updateTimer();
            this.timerWorld.c = rptw;
        } else {
            this.timer.a();
            
            // Cubitick
            this.timerWorld.a();
        }
        
        // Cubitick : reset tickrates upon loading a new world
        // theWorld : f
        if(this.f == null && Cubitick.tickrateWorld != Cubitick.tickrate)
        {
            Cubitick.setTickWorld(Cubitick.tickrate);
            Cubitick.synctick = false;
        }
        else if(this.f != null)
        {
            // Cubitick : World init
            if(!Cubitick.initialised && tickcounter > 100) Cubitick.instance.checkVersion();
        }
        
        this.B.a("scheduledExecutables");
        Queue f2 = this.aQ;
        synchronized (f2) {
            while (!this.aQ.isEmpty()) {
                Namepipe.g.a(this.aQ.poll(), L);
            }
        }
        this.B.b();
        long l3 = System.nanoTime();
        this.B.a("tick");

        /*
        for (int i2 = 0; i2 < this.aa.b; ++i2) {
            this.t();
        }
        */
        
        // Cubitick
        if(Cubitick.synctick)
        {
            // original runTick() call (with added tickcounter increment)
            // elapsedTicks : b
            for(int i = 0; i < this.timerWorld.b; ++i)
            {
                // isGamePaused : ah
                if(!this.ah) this.tickcounter++;
                this.t();
            }
        }
        else 
        {
            int worldTicks = this.timerWorld.b;
            int playerTicks = this.timer.b;
            
            while(playerTicks > 0 && worldTicks > 0)
            {
                if(!this.ah) this.tickcounter++;
                this.t();
                playerTicks--; worldTicks--;
            }
            
            while(playerTicks > 0)
            {
                this.runTickPlayer();
                playerTicks--;
            }
            
            while(worldTicks > 0)
            {
                if(!this.ah) this.tickcounter++;
                this.runTickWorld();
                worldTicks--;
            }
        }
        
        this.B.c("preRenderErrors");
        long l4 = System.nanoTime() - l3;
        this.a("Pre render");
        this.B.c("sound");
        this.aL.a(this.h, this.timerWorld.c);
        this.B.b();
        this.B.a("render");
        bnf.G();
        bnf.m(16640);
        this.aJ.a(true);
        this.B.a("display");
        bnf.y();
        this.B.b();
        if (!this.s) {
            this.B.c("gameRenderer");
            this.o.a(this.timerWorld.c, l2);
            this.B.b();
        }
        this.B.b();
        if (this.u.ar && this.u.as && !this.u.ap) {
            if (!this.B.a) {
                this.B.a();
            }
            this.B.a = true;
            this.a(l4);
        } else {
            this.B.a = false;
            this.K = System.nanoTime();
        }
        this.q.a();
        this.aJ.e();
        bnf.H();
        bnf.G();
        this.aJ.c(this.d, this.e);
        bnf.H();
        bnf.G();
        this.o.b(this.timer.c); // entityRenderer
        bnf.H();
        this.B.a("root");
        this.i();
        Thread.yield();
        this.a("Post render");
        ++this.J;
        this.ah = this.E() && this.m != null && this.m.d() && !this.al.a();
        long l5 = System.nanoTime();
        this.z.a(l5 - this.A);
        this.A = l5;
        while (bcc.I() >= this.I + 1000) {
            ar = this.J;
            Object[] arrobject = new Object[8];
            arrobject[0] = ar;
            arrobject[1] = bqc.a;
            arrobject[2] = bqc.a != 1 ? "s" : "";
            arrobject[3] = (float)this.u.g == Namepipe.bce_a.i.f() ? "inf" : Integer.valueOf(this.u.g);
            arrobject[4] = this.u.t ? " vsync" : "";
            arrobject[5] = this.u.i ? "" : " fast";
            arrobject[6] = this.u.h == 0 ? "" : (this.u.h == 1 ? " fast-clouds" : " fancy-clouds");
            arrobject[7] = bze.f() ? " vbo" : "";
            this.D = String.format("%d fps (%d chunk update%s) T: %s%s%s%s%s", arrobject);
            bqc.a = 0;
            this.I += 1000;
            this.J = 0;
            this.ab.b();
            if (this.ab.d()) continue;
            this.ab.a();
        }
        if (this.l()) {
            this.B.a("fpslimit_wait");
            Display.sync((int)this.k());
            this.B.b();
        }
        this.B.b();
    }

    public void i() {
        this.B.a("display_update");
        Display.update();
        this.B.b();
        this.j();
    }

    protected void j() {
        if (!this.V && Display.wasResized()) {
            int n2 = this.d;
            int n3 = this.e;
            this.d = Display.getWidth();
            this.e = Display.getHeight();
            if (this.d != n2 || this.e != n3) {
                if (this.d <= 0) {
                    this.d = 1;
                }
                if (this.e <= 0) {
                    this.e = 1;
                }
                this.a(this.d, this.e);
            }
        }
    }

    public int k() {
        if (this.f == null && this.m != null) {
            return 30;
        }
        return this.u.g;
    }

    public boolean l() {
        return (float)this.k() < Namepipe.bce_a.i.f();
    }

    public void m() {
        try {
            b = new byte[0];
            this.g.l();
        }
        catch (Throwable var1_1) {
            // empty catch block
        }
        try {
            System.gc();
            this.a((bkr)null);
        }
        catch (Throwable var1_2) {
            // empty catch block
        }
        System.gc();
    }

    private void b(int n2) {
        List<oo.a> list = this.B.b(this.aW);
        if (list == null || list.isEmpty()) {
            return;
        }
        oo.a a2 = list.remove(0);
        if (n2 == 0) {
            int n3;
            if (!a2.c.isEmpty() && (n3 = this.aW.lastIndexOf(".")) >= 0) {
                this.aW = this.aW.substring(0, n3);
            }
        } else if (--n2 < list.size() && !list.get((int)n2).c.equals("unspecified")) {
            if (!this.aW.isEmpty()) {
                this.aW = this.aW + ".";
            }
            this.aW = this.aW + list.get((int)n2).c;
        }
    }

    private void a(long l2) {
        int n2;
        if (!this.B.a) {
            return;
        }
        List<oo.a> list = this.B.b(this.aW);
        oo.a a2 = list.remove(0);
        bnf.m(256);
        bnf.n(5889);
        bnf.h();
        bnf.F();
        bnf.a(0.0, this.d, this.e, 0.0, 1000.0, 3000.0);
        bnf.n(5888);
        bnf.F();
        bnf.c(0.0f, 0.0f, -2000.0f);
        bnf.d(1.0f);
        bnf.z();
        bnr bnr2 = bnr.a();
        bmw bmw2 = bnr2.c();
        int n3 = 160;
        int n4 = this.d - n3 - 10;
        int n5 = this.e - n3 * 2;
        bnf.m();
        bmw2.a(7, bvm.f);
        bmw2.b((double)((float)n4 - (float)n3 * 1.1f), (double)((float)n5 - (float)n3 * 0.6f - 16.0f), 0.0).b(200, 0, 0, 0).d();
        bmw2.b((double)((float)n4 - (float)n3 * 1.1f), (double)(n5 + n3 * 2), 0.0).b(200, 0, 0, 0).d();
        bmw2.b((double)((float)n4 + (float)n3 * 1.1f), (double)(n5 + n3 * 2), 0.0).b(200, 0, 0, 0).d();
        bmw2.b((double)((float)n4 + (float)n3 * 1.1f), (double)((float)n5 - (float)n3 * 0.6f - 16.0f), 0.0).b(200, 0, 0, 0).d();
        bnr2.b();
        bnf.l();
        double d2 = 0.0;
        for (int i2 = 0; i2 < list.size(); ++i2) {
            float f2;
            int n6;
            float f3;
            float f4;
            oo.a profilerResult = list.get(i2);
            n2 = on.c(profilerResult.a / 4.0) + 1;
            bmw2.a(6, bvm.f);
            int n7 = profilerResult.a();
            int n8 = n7 >> 16 & 255;
            int n9 = n7 >> 8 & 255;
            int n10 = n7 & 255;
            bmw2.b((double)n4, (double)n5, 0.0).b(n8, n9, n10, 255).d();
            for (n6 = n2; n6 >= 0; --n6) {
                f2 = (float)((d2 + profilerResult.a * (double)n6 / (double)n2) * 6.2831854820251465 / 100.0);
                f4 = on.a(f2) * (float)n3;
                f3 = on.b(f2) * (float)n3 * 0.5f;
                bmw2.b((double)((float)n4 + f4), (double)((float)n5 - f3), 0.0).b(n8, n9, n10, 255).d();
            }
            bnr2.b();
            bmw2.a(5, bvm.f);
            for (n6 = n2; n6 >= 0; --n6) {
                f2 = (float)((d2 + profilerResult.a * (double)n6 / (double)n2) * 6.2831854820251465 / 100.0);
                f4 = on.a(f2) * (float)n3;
                f3 = on.b(f2) * (float)n3 * 0.5f;
                bmw2.b((double)((float)n4 + f4), (double)((float)n5 - f3), 0.0).b(n8 >> 1, n9 >> 1, n10 >> 1, 255).d();
                bmw2.b((double)((float)n4 + f4), (double)((float)n5 - f3 + 10.0f), 0.0).b(n8 >> 1, n9 >> 1, n10 >> 1, 255).d();
            }
            bnr2.b();
            d2 += profilerResult.a;
        }
        DecimalFormat decimalFormat = new DecimalFormat("##0.00");
        bnf.y();
        String object = "";
        if (!a2.c.equals("unspecified")) {
            object = (String)object + "[0] ";
        }
        object = a2.c.isEmpty() ? (String)object + "ROOT " : (String)object + a2.c + " ";
        n2 = 16777215;
        this.k.a((String)object, (float)(n4 - n3), (float)(n5 - n3 / 2 - 16), n2);
        object = decimalFormat.format(a2.b) + "%";
        this.k.a((String)object, (float)(n4 + n3 - this.k.a((String)object)), (float)(n5 - n3 / 2 - 16), n2);
        for (int i3 = 0; i3 < list.size(); ++i3) {
            oo.a a3 = list.get(i3);
            String string = "";
            string = a3.c.equals("unspecified") ? string + "[?] " : string + "[" + (i3 + 1) + "] ";
            string = string + a3.c;
            this.k.a(string, (float)(n4 - n3), (float)(n5 + n3 / 2 + i3 * 8 + 20), a3.a());
            string = decimalFormat.format(a3.a) + "%";
            this.k.a(string, (float)(n4 + n3 - 50 - this.k.a(string)), (float)(n5 + n3 / 2 + i3 * 8 + 20), a3.a());
            string = decimalFormat.format(a3.b) + "%";
            this.k.a(string, (float)(n4 + n3 - this.k.a(string)), (float)(n5 + n3 / 2 + i3 * 8 + 20), a3.a());
        }
    }

    public void n() {
        this.C = false;
    }

    public void o() {
        if (!Display.isActive()) {
            return;
        }
        if (this.x) {
            return;
        }
        if (!a) {
            bbz.a();
        }
        this.x = true;
        this.v.a();
        this.a((bey)null);
        this.ai = 10000;
    }

    public void p() {
        if (!this.x) {
            return;
        }
        this.x = false;
        this.v.b();
    }

    public void q() {
        if (this.m != null) {
            return;
        }
        this.a(new beu());
        if (this.E() && !this.al.a()) {
            this.aL.a();
        }
    }

    private void b(boolean bl2) {
        if (!bl2) {
            this.ai = 0;
        }
        if (this.ai > 0 || this.h.cs()) {
            return;
        }
        if (bl2 && this.t != null && this.t.a == Namepipe.bbf_a.b) {
            cj cj2 = this.t.a();
            if (this.f.o(cj2).a() != axd.a && this.c.b(cj2, this.t.b)) {
                this.j.a(cj2, this.t.b);
                this.h.a(qm.a);
            }
            return;
        }
        this.c.c();
    }

    private void aw() {
        if (this.ai > 0) {
            return;
        }
        if (this.t == null) {
            L.error("Null returned as 'hitResult', this shouldn't happen!");
            if (this.c.g()) {
                this.ai = 10;
            }
            return;
        }
        if (this.h.M()) {
            return;
        }
        switch (this.t.a) {
            case c: {
                this.c.a(this.h, this.t.d);
                break;
            }
            case b: {
                cj cj2 = this.t.a();
                if (this.f.o(cj2).a() != axd.a) {
                    this.c.a(cj2, this.t.b);
                    break;
                }
            }
            default: {
                if (this.c.g()) {
                    this.ai = 10;
                }
                this.h.cZ();
            }
        }
        this.h.a(qm.a);
    }

    private void ax() {
        if (this.c.m()) {
            return;
        }
        this.as = 4;
        if (this.h.M()) {
            return;
        }
        for (qm qm2 : qm.values()) {
            Object object;
            adq adq2 = this.h.b(qm2);
            if (this.t == null) {
                L.warn("Null returned as 'hitResult', this shouldn't happen!");
            } else {
                switch (this.t.a) {
                    case c: {
                        if (this.c.a(this.h, this.t.d, this.t, this.h.b(qm2), qm2) == qo.a) {
                            return;
                        }
                        if (this.c.a((zj)this.h, this.t.d, this.h.b(qm2), qm2) != qo.a) break;
                        return;
                    }
                    case b: {
                        object = this.t.a();
                        if (this.f.o((cj)object).a() == axd.a) break;
                        int n2 = adq2 != null ? adq2.b : 0;
                        qo qo2 = this.c.a(this.h, this.f, adq2, (cj)object, this.t.b, this.t.c, qm2);
                        if (qo2 != qo.a) break;
                        this.h.a(qm2);
                        if (adq2 != null) {
                            if (adq2.b == 0) {
                                this.h.a(qm2, null);
                            } else if (adq2.b != n2 || this.c.h()) {
                                this.o.c.a(qm2);
                            }
                        }
                        return;
                    }
                }
            }
            object = this.h.b(qm2);
            if (object == null || this.c.a((zj)this.h, this.f, (adq)object, qm2) != qo.a) continue;
            this.o.c.a(qm2);
            return;
        }
    }

    public void r() {
        try {
            this.u.s = this.V = !this.V;
            if (this.V) {
                this.au();
                this.d = Display.getDisplayMode().getWidth();
                this.e = Display.getDisplayMode().getHeight();
                if (this.d <= 0) {
                    this.d = 1;
                }
                if (this.e <= 0) {
                    this.e = 1;
                }
            } else {
                Display.setDisplayMode((DisplayMode)new DisplayMode(this.aj, this.ak));
                this.d = this.aj;
                this.e = this.ak;
                if (this.d <= 0) {
                    this.d = 1;
                }
                if (this.e <= 0) {
                    this.e = 1;
                }
            }
            if (this.m != null) {
                this.a(this.d, this.e);
            } else {
                this.ay();
            }
            Display.setFullscreen((boolean)this.V);
            Display.setVSyncEnabled((boolean)this.u.t);
            this.i();
        }
        catch (Exception err) {
            L.error("Couldn't toggle fullscreen", (Throwable)err);
        }
    }

    private void a(int n2, int n3) {
        this.d = Math.max(1, n2);
        this.e = Math.max(1, n3);
        if (this.m != null) {
            bcu bcu2 = new bcu(this);
            this.m.b(this, bcu2.a(), bcu2.b());
        }
        this.n = new bcf(this);
        this.ay();
    }

    private void ay() {
        this.aJ.a(this.d, this.e);
        if (this.o != null) {
            this.o.a(this.d, this.e);
        }
    }

    public bys s() {
        return this.aM;
    }

    
    public void runTickPlayer() {
        if (this.as > 0) {
            --this.as;
        }
        this.B.a("gui");
        if (!this.ah) {
            this.r.c(); // ingameGUI.updateTick();
        }
        this.B.b();
        this.o.a(1.0f); // entityRenderer.getMouseOver(1.0F);
        this.B.a("gameMode");
        if (!this.ah && this.f != null) { 
            this.c.e(); // playerController.updateController();
        }
        this.B.c("textures");
        if (!this.ah) {
            this.S.e(); // renderEngine.tick();
        }
        if (this.m == null && this.h != null) {
            if (this.h.bQ() <= 0.0f && !(this.m instanceof bej)) { // thePlayer.getHealth() <= 0.0F
                this.a((bey)null);
            } else if (this.h.cl() && this.f != null) { // thePlayer.isPlayerSleeping()
                this.a(new bep());
            }
        } else if (this.m != null && this.m instanceof bep && !this.h.cl()) {
            this.a((bey)null); // displayGuiScreen((GuiScreen)null);
        }
        if (this.m != null) {
            this.ai = 10000; 
        }
        if (this.m != null) {
            try {
                this.m.p(); // currentScreen.handleInput();
            }
            catch (Throwable err) {
                b b2 = Namepipe.b.a(err, "Updating screen events");
                c c2 = b2.a("Affected screen");
                c2.a("Screen name", new Callable<String>(){

                    public String a() throws Exception {
                        return bcc.this.m.getClass().getCanonicalName();
                    }

                    @Override
                    public String call() throws Exception {
                        return this.a();
                    }
                });
                throw new e(b2);
            }
            if (this.m != null) {
                try {
                    this.m.e(); // currentScreen.updateScreen();
                }
                catch (Throwable err) {
                    b b3 = Namepipe.b.a(err, "Ticking screen");
                    c c3 = b3.a("Affected screen");
                    c3.a("Screen name", new Callable<String>(){

                        public String a() throws Exception {
                            return bcc.this.m.getClass().getCanonicalName();
                        }

                        @Override
                        public String call() throws Exception {
                            return this.a();
                        }
                    });
                    throw new e(b3);
                }
            }
        }
        if (this.m == null || this.m.p) { 
            this.B.c("mouse");
            this.aB(); // mouse input is now handled in its own method
            if (this.ai > 0) {
                --this.ai;
            }
            this.B.c("keyboard");
            this.az(); // keyboard input is now handled in its own method
        }
        
        if (this.f != null) {
            
            // Cubitick
            // if(!this.isGamePaused) this.theWorld.updateEntity(thePlayer);
            if(!this.ah) this.f.g(this.h);
            
            if (this.h != null) {
                ++this.av; // this.joinPlayerCounter++;
                if (this.av == 30) {
                    this.av = 0;
                    this.f.h(this.h);
                }
            }
            
            this.B.c("gameRenderer");
            if (!this.ah) {
                this.o.e(); // entityRenderer.updateRenderer();
            }
            this.B.c("levelRenderer");
        }
        
        // PacketAnalysis: rerender
        if(scheduledReload){
            this.g.a();
            scheduledReload = false;
        }
        
        if (!this.ah) {
            this.aM.c(); // mcMusicTicker.update();
            this.aL.c(); // mcSoundHandler.update();
        }
    }
    
    public void runTickWorld()
    {
        if (this.f != null) {
            if (this.h != null) {
                ++this.av; // this.joinPlayerCounter++;
                if (this.av == 30) {
                    this.av = 0;
                    this.f.h(this.h);
                }
            }
            this.B.c("gameRenderer");
            if (!this.ah) {
                //this.o.e(); // this.entityRenderer.updateRenderer();
            }
            this.B.c("levelRenderer");
            if (!this.ah) {
                this.g.k(); // renderGlobal.updateClouds();
            }
            this.B.c("level");
            
            if (!this.ah) {
                if (this.f.ag() > 0) {
                    this.f.d(this.f.ag() - 1); // theWorld.setLastLightningBolt(..)
                }
                
                // Cubitick: temporarily remove player from world.loadedEntityList
                this.f.e.remove(this.h);
                this.f.k(); // original updateEntities();
                this.f.e.add(this.h);
            }
        } else if (this.o.a()) {
            this.o.b();
        }
        if (!this.ah) {
            this.aM.c(); // mcMusicTicker.update();
            this.aL.c(); // mcSoundHandler.update();
        }
        if (this.f != null) {
            if (!this.ah) {
                // theWorld.setAllowedSpawnTypes(this.theWorld.getDifficulty() != EnumDifficulty.PEACEFUL, true);
                this.f.a(this.f.ae() != qk.a, true);
                try {
                    this.f.d(); // theWorld.tick();
                }
                catch (Throwable err) {
                    b b4 = Namepipe.b.a(err, "Exception in world tick");
                    if (this.f == null) {
                        c c4 = b4.a("Affected level");
                        c4.a("Problem", "Level is null!");
                    } else {
                        this.f.a(b4);
                    }
                    throw new e(b4);
                }
            }
            this.B.c("animateTick");
            if (!this.ah && this.f != null) {
                this.f.b(on.c(this.h.p), on.c(this.h.q), on.c(this.h.r)); // theWorld.doVoidFogParticles(..)
            }
            this.B.c("particles");
            if (!this.ah) {
                this.j.a(); // effectRenderer.updateEffects();
            }
        } else if (this.ay != null) {
            this.B.c("pendingConnection");
            this.ay.a(); // myNetworkManager.processReceivedPackets();
        }
        this.B.b();
        this.y = bcc.I(); // systemTime = getSystemTime();
    }
    
    
    // runTick()
    public void t() {
        if (this.as > 0) {
            --this.as;
        }
        this.B.a("gui");
        if (!this.ah) {
            this.r.c();
        }
        this.B.b();
        this.o.a(1.0f);
        this.B.a("gameMode");
        if (!this.ah && this.f != null) {
            this.c.e();
        }
        this.B.c("textures");
        if (!this.ah) {
            this.S.e();
        }
        if (this.m == null && this.h != null) {
            if (this.h.bQ() <= 0.0f && !(this.m instanceof bej)) {
                this.a((bey)null);
            } else if (this.h.cl() && this.f != null) {
                this.a(new bep());
            }
        } else if (this.m != null && this.m instanceof bep && !this.h.cl()) {
            this.a((bey)null);
        }
        if (this.m != null) {
            this.ai = 10000;
        }
        if (this.m != null) {
            try {
                this.m.p();
            }
            catch (Throwable err) {
                b b2 = Namepipe.b.a(err, "Updating screen events");
                c c2 = b2.a("Affected screen");
                c2.a("Screen name", new Callable<String>(){

                    public String a() throws Exception {
                        return bcc.this.m.getClass().getCanonicalName();
                    }

                    @Override
                    public String call() throws Exception {
                        return this.a();
                    }
                });
                throw new e(b2);
            }
            if (this.m != null) {
                try {
                    this.m.e();
                }
                catch (Throwable err) {
                    b b3 = Namepipe.b.a(err, "Ticking screen");
                    c c3 = b3.a("Affected screen");
                    c3.a("Screen name", new Callable<String>(){

                        public String a() throws Exception {
                            return bcc.this.m.getClass().getCanonicalName();
                        }

                        @Override
                        public String call() throws Exception {
                            return this.a();
                        }
                    });
                    throw new e(b3);
                }
            }
        }
        if (this.m == null || this.m.p) {
            this.B.c("mouse");
            this.aB();
            if (this.ai > 0) {
                --this.ai;
            }
            this.B.c("keyboard");
            this.az();
        }
        if (this.f != null) {
            if (this.h != null) {
                ++this.av;
                if (this.av == 30) {
                    this.av = 0;
                    this.f.h(this.h);
                }
            }
            this.B.c("gameRenderer");
            if (!this.ah) {
                this.o.e();
            }
            this.B.c("levelRenderer");
            if (!this.ah) {
                this.g.k();
            }
            this.B.c("level");
            if (!this.ah) {
                if (this.f.ag() > 0) {
                    this.f.d(this.f.ag() - 1);
                }
                this.f.k();
            }
        } else if (this.o.a()) {
            this.o.b();
        }
        if (!this.ah) {
            this.aM.c();
            this.aL.c();
        }
        if (this.f != null) {
            if (!this.ah) {
                this.f.a(this.f.ae() != qk.a, true);
                try {
                    this.f.d();
                }
                catch (Throwable err) {
                    b b4 = Namepipe.b.a(err, "Exception in world tick");
                    if (this.f == null) {
                        c c4 = b4.a("Affected level");
                        c4.a("Problem", "Level is null!");
                    } else {
                        this.f.a(b4);
                    }
                    throw new e(b4);
                }
            }
            this.B.c("animateTick");
            if (!this.ah && this.f != null) {
                this.f.b(on.c(this.h.p), on.c(this.h.q), on.c(this.h.r));
            }
            this.B.c("particles");
            if (!this.ah) {
                this.j.a();
            }
        } else if (this.ay != null) {
            this.B.c("pendingConnection");
            this.ay.a();
        }
        this.B.b();
        this.y = bcc.I();
    }

    private void az() {
        while (Keyboard.next()) {
            int n2;
            boolean bl2;
            int n3 = n2 = Keyboard.getEventKey() == 0 ? Keyboard.getEventCharacter() + 256 : Keyboard.getEventKey();
            if (this.aA > 0) {
                if (bcc.I() - this.aA >= 6000) {
                    throw new e(new b("Manually triggered debug crash", new Throwable()));
                }
                if (!Keyboard.isKeyDown((int)46) || !Keyboard.isKeyDown((int)61)) {
                    this.aA = -1;
                }
            } else if (Keyboard.isKeyDown((int)46) && Keyboard.isKeyDown((int)61)) {
                this.aV = true;
                this.aA = bcc.I();
            }
            this.W();
            if (this.m != null) {
                this.m.l();
            }
            if (bl2 = Keyboard.getEventKeyState()) {
                if (n2 == 62 && this.o != null) {
                    this.o.c();
                }
                boolean bl3 = false;
                if (this.m == null) {
                    if (n2 == 1) {
                        this.q();
                    }
                    bl3 = Keyboard.isKeyDown((int)61) && this.c(n2);
                    this.aV |= bl3;
                    if (n2 == 59) {
                        boolean bl4 = this.u.ap = !this.u.ap;
                    }
                }
                if (bl3) {
                    bbz.a(n2, false);
                } else {
                    bbz.a(n2, true);
                    bbz.a(n2);
                }
                if (!this.u.as) continue;
                if (n2 == 11) {
                    this.b(0);
                }
                for (int i2 = 0; i2 < 9; ++i2) {
                    if (n2 != 2 + i2) continue;
                    this.b(i2 + 1);
                }
                continue;
            }
            bbz.a(n2, false);
            if (n2 != 61) continue;
            if (this.aV) {
                this.aV = false;
                continue;
            }
            this.u.ar = !this.u.ar;
            this.u.as = this.u.ar && bey.r();
            this.u.at = this.u.ar && bey.s();
        }
        this.aA();
    }

    private boolean c(int n2) {
        if (n2 == 30) {
            this.g.a();
            this.a("Reloading all chunks", new Object[0]);
            return true;
        }
        if (n2 == 48) {
            boolean bl2 = !this.ac.b();
            this.ac.b(bl2);
            Object[] arrobject = new Object[1];
            arrobject[0] = bl2 ? "shown" : "hidden";
            this.a("Hitboxes: {0}", arrobject);
            return true;
        }
        if (n2 == 32) {
            if (this.r != null) {
                this.r.d().a();
            }
            return true;
        }
        if (n2 == 33) {
            this.u.a(Namepipe.bce_a.f, bey.r() ? -1 : 1);
            this.a("RenderDistance: {0}", this.u.c);
            return true;
        }
        if (n2 == 35) {
            this.u.x = !this.u.x;
            Object[] arrobject = new Object[1];
            arrobject[0] = this.u.x ? "shown" : "hidden";
            this.a("Advanced tooltips: {0}", arrobject);
            this.u.b();
            return true;
        }
        if (n2 == 49) {
            if (!this.h.a(2, "")) {
                this.a("Unable to switch gamemode, no permission", new Object[0]);
            } else if (this.h.l_()) {
                this.h.g("/gamemode spectator");
            } else if (this.h.y()) {
                this.h.g("/gamemode creative");
            }
            return true;
        }
        if (n2 == 25) {
            this.u.y = !this.u.y;
            this.u.b();
            Object[] arrobject = new Object[1];
            arrobject[0] = this.u.y ? "enabled" : "disabled";
            this.a("PauseOnLostFocus: {0}", arrobject);
            return true;
        }
        if (n2 == 16) {
            this.a("Keybindings:", new Object[0]);
            bcx bcx2 = this.r.d();
            bcx2.a(new fa("F3 + A = Reload chunks"));
            bcx2.a(new fa("F3 + B = Show hitboxes"));
            bcx2.a(new fa("F3 + D = Clear chat"));
            bcx2.a(new fa("F3 + F = Cycle renderdistance (Shift to inverse)"));
            bcx2.a(new fa("F3 + H = Advanced tooltips"));
            bcx2.a(new fa("F3 + N = Cycle creative <-> spectator"));
            bcx2.a(new fa("F3 + P = Pause on lost focus"));
            bcx2.a(new fa("F3 + Q = Show this list"));
            bcx2.a(new fa("F3 + T = Reload resourcepacks"));
            return true;
        }
        if (n2 == 20) {
            this.f();
            this.a("Reloaded resourcepacks", new Object[0]);
            return true;
        }
        return false;
    }

    private void aA() {
        int n2;
        while (this.u.ah.g()) {
            ++this.u.aq;
            if (this.u.aq > 2) {
                this.u.aq = 0;
            }
            if (this.u.aq == 0) {
                this.o.a(this.aa());
            } else if (this.u.aq == 1) {
                this.o.a((rr)null);
            }
            this.g.o();
        }
        while (this.u.ai.g()) {
            this.u.av = !this.u.av;
        }
        for (n2 = 0; n2 < 9; ++n2) {
            if (!this.u.al[n2].g()) continue;
            if (this.h.y()) {
                this.r.g().a(n2);
                continue;
            }
            this.h.br.d = n2;
        }
        while (this.u.X.g()) {
            this.v().a(new ik(ik.a.c));
            if (this.c.j()) {
                this.h.D();
                continue;
            }
            this.a(new bgh(this.h));
        }
        while (this.u.Y.g()) {
            if (this.h.y()) continue;
            this.v().a(new ix(ix.a.g, cj.a, cq.a));
        }
        while (this.u.Z.g()) {
            if (this.h.y()) continue;
            this.h.a(bey.q());
        }
        int n3 = n2 = this.u.m != zj.b.c ? 1 : 0;
        if (n2 != 0) {
            while (this.u.ad.g()) {
                this.a(new beb());
            }
            if (this.m == null && this.u.af.g()) {
                this.a(new beb("/"));
            }
        }
        if (this.h.cs()) {
            if (!this.u.aa.e()) {
                this.c.c(this.h);
            }
            while (this.u.ab.g()) {
            }
            while (this.u.aa.g()) {
            }
            while (this.u.ac.g()) {
            }
        } else {
            while (this.u.ab.g()) {
                this.aw();
            }
            while (this.u.aa.g()) {
                this.ax();
            }
            while (this.u.ac.g()) {
                this.aC();
            }
        }
        if (this.u.aa.e() && this.as == 0 && !this.h.cs()) {
            this.ax();
        }
        this.b(this.m == null && this.u.ab.e() && this.x);
    }

    private void aB() {
        while (Mouse.next()) {
            long l2;
            int n2 = Mouse.getEventButton();
            bbz.a(n2 - 100, Mouse.getEventButtonState());
            if (Mouse.getEventButtonState()) {
                if (this.h.y() && n2 == 2) {
                    this.r.g().b();
                } else {
                    bbz.a(n2 - 100);
                }
            }
            
            // Cubitick: adjust timing
            if ((l2 = bcc.I() - this.y) > (long)Math.max(200F*(Cubitick.tickrate/Cubitick.tickrateWorld), 200L)) continue;
            int n3 = Mouse.getEventDWheel();
            if (n3 != 0) {
                if (this.h.y()) {
                    int n4 = n3 = n3 < 0 ? -1 : 1;
                    if (this.r.g().a()) {
                        this.r.g().b(- n3);
                    } else {
                        float f2 = on.a(this.h.bJ.a() + (float)n3 * 0.005f, 0.0f, 0.2f);
                        this.h.bJ.a(f2);
                    }
                } else {
                    this.h.br.f(n3);
                }
            }
            if (this.m == null) {
                if (this.x || !Mouse.getEventButtonState()) continue;
                this.o();
                continue;
            }
            if (this.m == null) continue;
            this.m.k();
        }
    }

    private /* varargs */ void a(String string, Object ... arrobject) {
        this.r.d().a(new fa("").a(new fa("[Debug]: ").a(new ez().a(Namepipe.a.o).a(true))).a(MessageFormat.format(string, arrobject)));
    }

    public void a(String string, String string2, ahw ahw2) {
        this.a((bkr)null);
        System.gc();
        azh azh2 = this.aq.a(string, false);
        azg azg2 = azh2.d();
        if (azg2 == null && ahw2 != null) {
            azg2 = new azg(ahw2, string);
            azh2.a(azg2);
        }
        if (ahw2 == null) {
            ahw2 = new ahw(azg2);
        }
        try {
            YggdrasilAuthenticationService yas = new YggdrasilAuthenticationService(this.ap, UUID.randomUUID().toString());
            MinecraftSessionService mss = yas.createMinecraftSessionService();
            GameProfileRepository gameProfileRepository = yas.createProfileRepository();
            mi mi2 = new mi(gameProfileRepository, new File(this.w, MinecraftServer.a.getName()));
            aqo.a(mi2);
            aqo.a((MinecraftSessionService)mss);
            mi.a(false);
            this.al = new byl(this, string, string2, ahw2, (YggdrasilAuthenticationService)yas, (MinecraftSessionService)mss, gameProfileRepository, mi2);
            this.al.F();
            this.az = true;
        }
        catch (Throwable err) {
            b b2 = Namepipe.b.a(err, "Starting integrated server");
            c c2 = b2.a("Starting integrated server");
            c2.a("Level ID", string);
            c2.a("Level Name", string2);
            throw new e(b2);
        }
        this.n.a(bwl.a("menu.loadingLevel", new Object[0]));
        while (!this.al.an()) {
            String str = this.al.k();
            if (str != null) {
                this.n.c(bwl.a((String)str, new Object[0]));
            } else {
                this.n.c("");
            }
            try {
                Thread.sleep(200);
            }
            catch (InterruptedException b2) {}
        }
        this.a(new bew());
        SocketAddress sa = this.al.am().a();
        ek ek1 = ek.a((SocketAddress)sa);
        ek1.a(new bko((ek)(ek1), this, null));
        ek1.a(new jj(109, sa.toString(), 0, el.d));
        ek1.a(new js(this.K().e()));
        this.ay = ek1;
    }

    public void a(bkr bkr2) {
        this.a(bkr2, "");
    }

    public void a(bkr bkr2, String string) {
        bkp bkp2;
        if (bkr2 == null) {
            bkp2 = this.v();
            if (bkp2 != null) {
                bkp2.b();
            }
            if (this.al != null && this.al.M()) {
                this.al.x();
            }
            this.al = null;
            this.q.b();
            this.o.k().a();
            this.c = null;
        }
        this.af = null;
        this.ay = null;
        if (this.n != null) {
            this.n.b(string);
            this.n.c("");
        }
        if (bkr2 == null && this.f != null) {
            this.aF.g();
            this.r.i();
            this.a((bku)null);
            this.az = false;
        }
        this.aL.b();
        this.f = bkr2;
        if (this.g != null) {
            this.g.a(bkr2);
        }
        if (this.j != null) {
            this.j.a(bkr2);
        }
        bpj.a.a(bkr2);
        if (bkr2 != null) {
            if (!this.az) {
                YggdrasilAuthenticationService yas = new YggdrasilAuthenticationService(this.ap, UUID.randomUUID().toString());
                MinecraftSessionService minecraftSessionService = yas.createMinecraftSessionService();
                GameProfileRepository gameProfileRepository = yas.createProfileRepository();
                mi mi2 = new mi(gameProfileRepository, new File(this.w, MinecraftServer.a.getName()));
                aqo.a(mi2);
                aqo.a(minecraftSessionService);
                mi.a(false);
            }
            if (this.h == null) {
                this.h = this.c.a(bkr2, new nu());
                this.c.b(this.h);
            }
            this.h.S();
            bkr2.a(this.h);
            this.h.e = new bmp(this.u);
            this.c.a(this.h);
            this.af = this.h;
        } else {
            this.aq.d();
            this.h = null;
        }
        System.gc();
        this.y = 0;
    }

    public void a(int n2) {
        this.f.h();
        this.f.c();
        int n3 = 0;
        String string = null;
        if (this.h != null) {
            n3 = this.h.O();
            this.f.e(this.h);
            string = this.h.E();
        }
        this.af = null;
        bmq bmq2 = this.h;
        this.h = this.c.a(this.f, this.h == null ? new nu() : this.h.G());
        this.h.R().a(bmq2.R().c());
        this.h.am = n2;
        this.af = this.h;
        this.h.S();
        this.h.h(string);
        this.f.a(this.h);
        this.c.b(this.h);
        this.h.e = new bmp(this.u);
        this.h.f(n3);
        this.c.a(this.h);
        this.h.m(bmq2.cX());
        if (this.m instanceof bej) {
            this.a((bey)null);
        }
    }

    public final boolean u() {
        return this.ax;
    }

    public bkp v() {
        if (this.h != null) {
            return this.h.d;
        }
        return null;
    }

    public static boolean w() {
        return T == null || !bcc.T.u.ap;
    }

    public static boolean x() {
        return T != null && bcc.T.u.i;
    }

    public static boolean y() {
        return T != null && bcc.T.u.j != 0;
    }

    private void aC() {
        adq adq2;
        if (this.t == null || this.t.a == Namepipe.bbf_a.a) {
            return;
        }
        boolean bl2 = this.h.bJ.d;
        apv apv2 = null;
        if (this.t.a == Namepipe.bbf_a.b) {
            cj cj1 = this.t.a();
            arc arc1 = this.f.o((cj)cj1);
            ajt ajt2 = arc1.t();
            if (arc1.a() == axd.a) {
                return;
            }
            adq2 = ajt2.a((aht)this.f, (cj)cj1, (arc)arc1);
            if (adq2 == null) {
                return;
            }
            if (bl2 && bey.q() && ajt2.m()) {
                apv2 = this.f.r((cj)cj1);
            }
        } else if (this.t.a == Namepipe.bbf_a.c && this.t.d != null && bl2) {
            if (this.t.d instanceof xu) {
                adq2 = new adq(ads.ap);
            } else if (this.t.d instanceof xt) {
                adq2 = new adq(ads.cx);
            } else if (this.t.d instanceof xs) {
                xs object = (xs)this.t.d;
                adq object2 = object.r();
                adq2 = object2 == null ? new adq(ads.bZ) : adq.c((adq)object2);
            } else if (this.t.d instanceof aah) {
                aah object = (aah)this.t.d;
                ado object2;
                switch (object.v()) {
                    case c: {
                        object2 = ads.aV;
                        break;
                    }
                    case b: {
                        object2 = ads.aU;
                        break;
                    }
                    case d: {
                        object2 = ads.cr;
                        break;
                    }
                    case f: {
                        object2 = ads.cs;
                        break;
                    }
                    case g: {
                        object2 = ads.cz;
                        break;
                    }
                    default: {
                        object2 = ads.aB;
                    }
                }
                adq2 = new adq((ado)object2);
            } else if (this.t.d instanceof aag) {
                adq2 = new adq(((aag)this.t.d).j());
            } else if (this.t.d instanceof xq) {
                adq2 = new adq(ads.ct);
            } else if (this.t.d instanceof wt) {
                adq2 = new adq(ads.cP);
            } else {
                String object = rt.b(this.t.d);
                if (!rt.a.containsKey(object)) {
                    return;
                }
                adq2 = new adq(ads.bT);
                aeu.a(adq2, (String)object);
            }
        } else {
            return;
        }
        if (adq2.b() == null) {
            String object = "";
            if (this.t.a == Namepipe.bbf_a.b) {
                object = ajt.h.b(this.f.o(this.t.a()).t()).toString();
            } else if (this.t.a == Namepipe.bbf_a.c) {
                object = rt.b(this.t.d);
            }
            L.warn("Picking on: [{}] {} gave null item", new Object[]{this.t.a, object});
            return;
        }
        zi object = this.h.br;
        if (apv2 != null) {
            this.a(adq2, apv2);
        }
        int n2 = object.b(adq2);
        if (bl2) {
            object.a(adq2);
            this.c.a(this.h.b(qm.a), 36 + object.d);
        } else if (n2 != -1) {
            if (zi.e(n2)) {
                object.d = n2;
            } else {
                this.c.a(n2);
            }
        }
    }

    private adq a(adq adq2, apv apv2) {
        dn dn2 = new dn();
        apv2.b(dn2);
        if (adq2.b() == ads.ch && dn2.e("Owner")) {
            dn dn3 = dn2.o("Owner");
            dn dn4 = new dn();
            dn4.a("SkullOwner", dn3);
            adq2.d(dn4);
            return adq2;
        }
        adq2.a("BlockEntityTag", dn2);
        dn dn5 = new dn();
        du du2 = new du();
        du2.a(new ea("(+NBT)"));
        dn5.a("Lore", du2);
        adq2.a("display", dn5);
        return adq2;
    }

    public b b(b b2) {
        b2.g().a("Launched Version", new Callable<String>(){

            public String a() {
                return bcc.this.an;
            }

            @Override
            public String call() throws Exception {
                return this.a();
            }
        });
        b2.g().a("LWJGL", new Callable<String>(){

            public String a() {
                return Sys.getVersion();
            }

            @Override
            public String call() throws Exception {
                return this.a();
            }
        });
        b2.g().a("OpenGL", new Callable<String>(){

            public String a() {
                return bnf.u(7937) + " GL version " + bnf.u(7938) + ", " + bnf.u(7936);
            }

            @Override
            public String call() throws Exception {
                return this.a();
            }
        });
        b2.g().a("GL Caps", new Callable<String>(){

            public String a() {
                return bze.c();
            }

            @Override
            public String call() throws Exception {
                return this.a();
            }
        });
        b2.g().a("Using VBOs", new Callable<String>(){

            public String a() {
                return bcc.this.u.u ? "Yes" : "No";
            }

            @Override
            public String call() throws Exception {
                return this.a();
            }
        });
        b2.g().a("Is Modded", new Callable<String>(){

            public String a() throws Exception {
                String string = ClientBrandRetriever.getClientModName();
                if (!string.equals("vanilla")) {
                    return "Definitely; Client brand changed to '" + string + "'";
                }
                if (bcc.class.getSigners() == null) {
                    return "Very likely; Jar signature invalidated";
                }
                return "Probably not. Jar signature remains and client brand is untouched.";
            }

            @Override
            public String call() throws Exception {
                return this.a();
            }
        });
        b2.g().a("Type", new Callable<String>(){

            public String a() throws Exception {
                return "Client (map_client.txt)";
            }

            @Override
            public String call() throws Exception {
                return this.a();
            }
        });
        b2.g().a("Resource Packs", new Callable<String>(){

            public String a() throws Exception {
                StringBuilder stringBuilder = new StringBuilder();
                for (String string : bcc.this.u.k) {
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(string);
                    if (!bcc.this.u.l.contains(string)) continue;
                    stringBuilder.append(" (incompatible)");
                }
                return stringBuilder.toString();
            }

            @Override
            public String call() throws Exception {
                return this.a();
            }
        });
        b2.g().a("Current Language", new Callable<String>(){

            public String a() throws Exception {
                return bcc.this.aG.c().toString();
            }

            @Override
            public String call() throws Exception {
                return this.a();
            }
        });
        b2.g().a("Profiler Position", new Callable<String>(){

            public String a() throws Exception {
                return bcc.this.B.a ? bcc.this.B.c() : "N/A (disabled)";
            }

            @Override
            public String call() throws Exception {
                return this.a();
            }
        });
        b2.g().a("CPU", new Callable<String>(){

            public String a() {
                return bze.k();
            }

            @Override
            public String call() throws Exception {
                return this.a();
            }
        });
        if (this.f != null) {
            this.f.a(b2);
        }
        return b2;
    }

    public static bcc z() {
        return T;
    }

    public ListenableFuture<Object> A() {
        return this.a(new Runnable(){

            @Override
            public void run() {
                bcc.this.f();
            }
        });
    }

    @Override
    public void a(qw qw2) {
        qw2.a("fps", ar);
        qw2.a("vsync_enabled", this.u.t);
        qw2.a("display_frequency", Display.getDisplayMode().getFrequency());
        qw2.a("display_type", this.V ? "fullscreen" : "windowed");
        qw2.a("run_time", (MinecraftServer.av() - qw2.g()) / 60 * 1000);
        qw2.a("current_action", this.aD());
        qw2.a("language", this.u.aC == null ? "en_US" : this.u.aC);
        String string = ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN ? "little" : "big";
        qw2.a("endianness", string);
        qw2.a("subtitles", this.u.O);
        qw2.a("resource_packs", this.aF.d().size());
        int n2 = 0;
        for (bwh.a a2 : this.aF.d()) {
            qw2.a("resource_pack[" + n2++ + "]", a2.d());
        }
        if (this.al != null && this.al.ar() != null) {
            qw2.a("snooper_partner", this.al.ar().f());
        }
    }

    private String aD() {
        if (this.al != null) {
            if (this.al.a()) {
                return "hosting_lan";
            }
            return "singleplayer";
        }
        if (this.R != null) {
            if (this.R.d()) {
                return "playing_lan";
            }
            return "multiplayer";
        }
        return "out_of_game";
    }

    @Override
    public void b(qw qw2) {
        qw2.b("opengl_version", bnf.u(7938));
        qw2.b("opengl_vendor", bnf.u(7936));
        qw2.b("client_brand", ClientBrandRetriever.getClientModName());
        qw2.b("launched_version", this.an);
        ContextCapabilities contextCapabilities = GLContext.getCapabilities();
        qw2.b("gl_caps[ARB_arrays_of_arrays]", contextCapabilities.GL_ARB_arrays_of_arrays);
        qw2.b("gl_caps[ARB_base_instance]", contextCapabilities.GL_ARB_base_instance);
        qw2.b("gl_caps[ARB_blend_func_extended]", contextCapabilities.GL_ARB_blend_func_extended);
        qw2.b("gl_caps[ARB_clear_buffer_object]", contextCapabilities.GL_ARB_clear_buffer_object);
        qw2.b("gl_caps[ARB_color_buffer_float]", contextCapabilities.GL_ARB_color_buffer_float);
        qw2.b("gl_caps[ARB_compatibility]", contextCapabilities.GL_ARB_compatibility);
        qw2.b("gl_caps[ARB_compressed_texture_pixel_storage]", contextCapabilities.GL_ARB_compressed_texture_pixel_storage);
        qw2.b("gl_caps[ARB_compute_shader]", contextCapabilities.GL_ARB_compute_shader);
        qw2.b("gl_caps[ARB_copy_buffer]", contextCapabilities.GL_ARB_copy_buffer);
        qw2.b("gl_caps[ARB_copy_image]", contextCapabilities.GL_ARB_copy_image);
        qw2.b("gl_caps[ARB_depth_buffer_float]", contextCapabilities.GL_ARB_depth_buffer_float);
        qw2.b("gl_caps[ARB_compute_shader]", contextCapabilities.GL_ARB_compute_shader);
        qw2.b("gl_caps[ARB_copy_buffer]", contextCapabilities.GL_ARB_copy_buffer);
        qw2.b("gl_caps[ARB_copy_image]", contextCapabilities.GL_ARB_copy_image);
        qw2.b("gl_caps[ARB_depth_buffer_float]", contextCapabilities.GL_ARB_depth_buffer_float);
        qw2.b("gl_caps[ARB_depth_clamp]", contextCapabilities.GL_ARB_depth_clamp);
        qw2.b("gl_caps[ARB_depth_texture]", contextCapabilities.GL_ARB_depth_texture);
        qw2.b("gl_caps[ARB_draw_buffers]", contextCapabilities.GL_ARB_draw_buffers);
        qw2.b("gl_caps[ARB_draw_buffers_blend]", contextCapabilities.GL_ARB_draw_buffers_blend);
        qw2.b("gl_caps[ARB_draw_elements_base_vertex]", contextCapabilities.GL_ARB_draw_elements_base_vertex);
        qw2.b("gl_caps[ARB_draw_indirect]", contextCapabilities.GL_ARB_draw_indirect);
        qw2.b("gl_caps[ARB_draw_instanced]", contextCapabilities.GL_ARB_draw_instanced);
        qw2.b("gl_caps[ARB_explicit_attrib_location]", contextCapabilities.GL_ARB_explicit_attrib_location);
        qw2.b("gl_caps[ARB_explicit_uniform_location]", contextCapabilities.GL_ARB_explicit_uniform_location);
        qw2.b("gl_caps[ARB_fragment_layer_viewport]", contextCapabilities.GL_ARB_fragment_layer_viewport);
        qw2.b("gl_caps[ARB_fragment_program]", contextCapabilities.GL_ARB_fragment_program);
        qw2.b("gl_caps[ARB_fragment_shader]", contextCapabilities.GL_ARB_fragment_shader);
        qw2.b("gl_caps[ARB_fragment_program_shadow]", contextCapabilities.GL_ARB_fragment_program_shadow);
        qw2.b("gl_caps[ARB_framebuffer_object]", contextCapabilities.GL_ARB_framebuffer_object);
        qw2.b("gl_caps[ARB_framebuffer_sRGB]", contextCapabilities.GL_ARB_framebuffer_sRGB);
        qw2.b("gl_caps[ARB_geometry_shader4]", contextCapabilities.GL_ARB_geometry_shader4);
        qw2.b("gl_caps[ARB_gpu_shader5]", contextCapabilities.GL_ARB_gpu_shader5);
        qw2.b("gl_caps[ARB_half_float_pixel]", contextCapabilities.GL_ARB_half_float_pixel);
        qw2.b("gl_caps[ARB_half_float_vertex]", contextCapabilities.GL_ARB_half_float_vertex);
        qw2.b("gl_caps[ARB_instanced_arrays]", contextCapabilities.GL_ARB_instanced_arrays);
        qw2.b("gl_caps[ARB_map_buffer_alignment]", contextCapabilities.GL_ARB_map_buffer_alignment);
        qw2.b("gl_caps[ARB_map_buffer_range]", contextCapabilities.GL_ARB_map_buffer_range);
        qw2.b("gl_caps[ARB_multisample]", contextCapabilities.GL_ARB_multisample);
        qw2.b("gl_caps[ARB_multitexture]", contextCapabilities.GL_ARB_multitexture);
        qw2.b("gl_caps[ARB_occlusion_query2]", contextCapabilities.GL_ARB_occlusion_query2);
        qw2.b("gl_caps[ARB_pixel_buffer_object]", contextCapabilities.GL_ARB_pixel_buffer_object);
        qw2.b("gl_caps[ARB_seamless_cube_map]", contextCapabilities.GL_ARB_seamless_cube_map);
        qw2.b("gl_caps[ARB_shader_objects]", contextCapabilities.GL_ARB_shader_objects);
        qw2.b("gl_caps[ARB_shader_stencil_export]", contextCapabilities.GL_ARB_shader_stencil_export);
        qw2.b("gl_caps[ARB_shader_texture_lod]", contextCapabilities.GL_ARB_shader_texture_lod);
        qw2.b("gl_caps[ARB_shadow]", contextCapabilities.GL_ARB_shadow);
        qw2.b("gl_caps[ARB_shadow_ambient]", contextCapabilities.GL_ARB_shadow_ambient);
        qw2.b("gl_caps[ARB_stencil_texturing]", contextCapabilities.GL_ARB_stencil_texturing);
        qw2.b("gl_caps[ARB_sync]", contextCapabilities.GL_ARB_sync);
        qw2.b("gl_caps[ARB_tessellation_shader]", contextCapabilities.GL_ARB_tessellation_shader);
        qw2.b("gl_caps[ARB_texture_border_clamp]", contextCapabilities.GL_ARB_texture_border_clamp);
        qw2.b("gl_caps[ARB_texture_buffer_object]", contextCapabilities.GL_ARB_texture_buffer_object);
        qw2.b("gl_caps[ARB_texture_cube_map]", contextCapabilities.GL_ARB_texture_cube_map);
        qw2.b("gl_caps[ARB_texture_cube_map_array]", contextCapabilities.GL_ARB_texture_cube_map_array);
        qw2.b("gl_caps[ARB_texture_non_power_of_two]", contextCapabilities.GL_ARB_texture_non_power_of_two);
        qw2.b("gl_caps[ARB_uniform_buffer_object]", contextCapabilities.GL_ARB_uniform_buffer_object);
        qw2.b("gl_caps[ARB_vertex_blend]", contextCapabilities.GL_ARB_vertex_blend);
        qw2.b("gl_caps[ARB_vertex_buffer_object]", contextCapabilities.GL_ARB_vertex_buffer_object);
        qw2.b("gl_caps[ARB_vertex_program]", contextCapabilities.GL_ARB_vertex_program);
        qw2.b("gl_caps[ARB_vertex_shader]", contextCapabilities.GL_ARB_vertex_shader);
        qw2.b("gl_caps[EXT_bindable_uniform]", contextCapabilities.GL_EXT_bindable_uniform);
        qw2.b("gl_caps[EXT_blend_equation_separate]", contextCapabilities.GL_EXT_blend_equation_separate);
        qw2.b("gl_caps[EXT_blend_func_separate]", contextCapabilities.GL_EXT_blend_func_separate);
        qw2.b("gl_caps[EXT_blend_minmax]", contextCapabilities.GL_EXT_blend_minmax);
        qw2.b("gl_caps[EXT_blend_subtract]", contextCapabilities.GL_EXT_blend_subtract);
        qw2.b("gl_caps[EXT_draw_instanced]", contextCapabilities.GL_EXT_draw_instanced);
        qw2.b("gl_caps[EXT_framebuffer_multisample]", contextCapabilities.GL_EXT_framebuffer_multisample);
        qw2.b("gl_caps[EXT_framebuffer_object]", contextCapabilities.GL_EXT_framebuffer_object);
        qw2.b("gl_caps[EXT_framebuffer_sRGB]", contextCapabilities.GL_EXT_framebuffer_sRGB);
        qw2.b("gl_caps[EXT_geometry_shader4]", contextCapabilities.GL_EXT_geometry_shader4);
        qw2.b("gl_caps[EXT_gpu_program_parameters]", contextCapabilities.GL_EXT_gpu_program_parameters);
        qw2.b("gl_caps[EXT_gpu_shader4]", contextCapabilities.GL_EXT_gpu_shader4);
        qw2.b("gl_caps[EXT_multi_draw_arrays]", contextCapabilities.GL_EXT_multi_draw_arrays);
        qw2.b("gl_caps[EXT_packed_depth_stencil]", contextCapabilities.GL_EXT_packed_depth_stencil);
        qw2.b("gl_caps[EXT_paletted_texture]", contextCapabilities.GL_EXT_paletted_texture);
        qw2.b("gl_caps[EXT_rescale_normal]", contextCapabilities.GL_EXT_rescale_normal);
        qw2.b("gl_caps[EXT_separate_shader_objects]", contextCapabilities.GL_EXT_separate_shader_objects);
        qw2.b("gl_caps[EXT_shader_image_load_store]", contextCapabilities.GL_EXT_shader_image_load_store);
        qw2.b("gl_caps[EXT_shadow_funcs]", contextCapabilities.GL_EXT_shadow_funcs);
        qw2.b("gl_caps[EXT_shared_texture_palette]", contextCapabilities.GL_EXT_shared_texture_palette);
        qw2.b("gl_caps[EXT_stencil_clear_tag]", contextCapabilities.GL_EXT_stencil_clear_tag);
        qw2.b("gl_caps[EXT_stencil_two_side]", contextCapabilities.GL_EXT_stencil_two_side);
        qw2.b("gl_caps[EXT_stencil_wrap]", contextCapabilities.GL_EXT_stencil_wrap);
        qw2.b("gl_caps[EXT_texture_3d]", contextCapabilities.GL_EXT_texture_3d);
        qw2.b("gl_caps[EXT_texture_array]", contextCapabilities.GL_EXT_texture_array);
        qw2.b("gl_caps[EXT_texture_buffer_object]", contextCapabilities.GL_EXT_texture_buffer_object);
        qw2.b("gl_caps[EXT_texture_integer]", contextCapabilities.GL_EXT_texture_integer);
        qw2.b("gl_caps[EXT_texture_lod_bias]", contextCapabilities.GL_EXT_texture_lod_bias);
        qw2.b("gl_caps[EXT_texture_sRGB]", contextCapabilities.GL_EXT_texture_sRGB);
        qw2.b("gl_caps[EXT_vertex_shader]", contextCapabilities.GL_EXT_vertex_shader);
        qw2.b("gl_caps[EXT_vertex_weighting]", contextCapabilities.GL_EXT_vertex_weighting);
        qw2.b("gl_caps[gl_max_vertex_uniforms]", bnf.v(35658));
        bnf.L();
        qw2.b("gl_caps[gl_max_fragment_uniforms]", bnf.v(35657));
        bnf.L();
        qw2.b("gl_caps[gl_max_vertex_attribs]", bnf.v(34921));
        bnf.L();
        qw2.b("gl_caps[gl_max_vertex_texture_image_units]", bnf.v(35660));
        bnf.L();
        qw2.b("gl_caps[gl_max_texture_image_units]", bnf.v(34930));
        bnf.L();
        qw2.b("gl_caps[gl_max_array_texture_layers]", bnf.v(35071));
        bnf.L();
        qw2.b("gl_max_texture_size", bcc.B());
    }

    public static int B() {
        for (int i2 = 16384; i2 > 0; i2 >>= 1) {
            bnf.a(32868, 0, 6408, i2, i2, 0, 6408, 5121, null);
            int n2 = bnf.c(32868, 0, 4096);
            if (n2 == 0) continue;
            return i2;
        }
        return -1;
    }

    @Override
    public boolean Z() {
        return this.u.r;
    }

    public void a(bku bku2) {
        this.R = bku2;
    }

    public bku C() {
        return this.R;
    }

    public boolean D() {
        return this.az;
    }

    public boolean E() {
        return this.az && this.al != null;
    }

    public byl F() {
        return this.al;
    }

    public static void G() {
        if (T == null) {
            return;
        }
        byl byl2 = T.F();
        if (byl2 != null) {
            byl2.u();
        }
    }

    public qw H() {
        return this.ab;
    }

    public static long I() {
        return Sys.getTime() * 1000 / Sys.getTimerResolution();
    }

    public boolean J() {
        return this.V;
    }

    public bcj K() {
        return this.ag;
    }

    public PropertyMap L() {
        if (this.Q.isEmpty()) {
            GameProfile gameProfile = this.X().fillProfileProperties(this.ag.e(), false);
            this.Q.putAll((Multimap)gameProfile.getProperties());
        }
        return this.Q;
    }

    public Proxy M() {
        return this.ap;
    }

    public bvf N() {
        return this.S;
    }

    public bwd O() {
        return this.aB;
    }

    public bwh P() {
        return this.aF;
    }

    public bwn Q() {
        return this.aG;
    }

    public bvd R() {
        return this.aK;
    }

    public boolean S() {
        return this.aw;
    }

    public boolean T() {
        return this.ah;
    }

    public byv U() {
        return this.aL;
    }

    public bys.a V() {
        if (this.h != null) {
            if (this.h.l.s instanceof asw) {
                return bys.a.e;
            }
            if (this.h.l.s instanceof ata) {
                if (this.r.j().d()) {
                    return bys.a.f;
                }
                return bys.a.g;
            }
            if (this.h.bJ.d && this.h.bJ.c) {
                return bys.a.c;
            }
            return bys.a.b;
        }
        return bys.a.a;
    }

    public void W() {
        int n2;
        int n3 = n2 = Keyboard.getEventKey() == 0 ? Keyboard.getEventCharacter() + 256 : Keyboard.getEventKey();
        if (n2 == 0 || Keyboard.isRepeatEvent()) {
            return;
        }
        if (this.m instanceof bfo && ((bfo)this.m).g > bcc.I() - 20) {
            return;
        }
        if (Keyboard.getEventKeyState()) {
            if (n2 == this.u.aj.j()) {
                this.r();
            } else if (n2 == this.u.ag.j()) {
                this.r.d().a(bcg.a(this.w, this.d, this.e, this.aJ));
            }
        }
    }

    public MinecraftSessionService X() {
        return this.aO;
    }

    public bwk Y() {
        return this.aP;
    }

    public rr aa() {
        return this.af;
    }

    public void a(rr rr2) {
        this.af = rr2;
        this.o.a(rr2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public <V> ListenableFuture<V> a(Callable<V> callable) {
        Validate.notNull(callable);
        if (!this.aE()) {
            ListenableFutureTask listenableFutureTask = ListenableFutureTask.create(callable);
            Queue queue = this.aQ;
            synchronized (queue) {
                this.aQ.add((ListenableFutureTask)listenableFutureTask);
            }
            return listenableFutureTask;
        }
        try {
            return Futures.immediateFuture(callable.call());
        }
        catch (Exception err) {
            return Futures.immediateFailedCheckedFuture((Exception)err);
        }
    }

    @Override
    public ListenableFuture<Object> a(Runnable runnable) {
        Validate.notNull((Object)runnable);
        return this.a(Executors.callable(runnable));
    }

    @Override
    public boolean aE() {
        return Thread.currentThread() == this.aS;
    }

    public bnz ab() {
        return this.aU;
    }

    public brj ac() {
        return this.ac;
    }

    public brw ad() {
        return this.ad;
    }

    public bnh ae() {
        return this.ae;
    }

    public static int af() {
        return ar;
    }

    public oc ag() {
        return this.z;
    }

    public static Map<String, String> ah() {
        HashMap hashMap = Maps.newHashMap();
        hashMap.put("X-Minecraft-Username", bcc.z().K().c());
        hashMap.put("X-Minecraft-UUID", bcc.z().K().b());
        hashMap.put("X-Minecraft-Version", "1.9.2");
        return hashMap;
    }

    public boolean ai() {
        return this.Z;
    }

    public void a(boolean bl2) {
        this.Z = bl2;
    }

    public pb aj() {
        return this.U;
    }

    public float ak() {
        return this.timer.c;
    }

    public bcl al() {
        return this.aH;
    }

}
