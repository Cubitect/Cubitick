/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Charsets
 *  com.google.common.collect.Lists
 *  com.google.common.collect.Queues
 *  com.google.common.util.concurrent.Futures
 *  com.google.common.util.concurrent.ListenableFuture
 *  com.google.common.util.concurrent.ListenableFutureTask
 *  com.mojang.authlib.GameProfile
 *  com.mojang.authlib.GameProfileRepository
 *  com.mojang.authlib.minecraft.MinecraftSessionService
 *  com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService
 *  io.netty.buffer.ByteBuf
 *  io.netty.buffer.ByteBufOutputStream
 *  io.netty.buffer.Unpooled
 *  io.netty.handler.codec.base64.Base64
 *  org.apache.commons.lang3.Validate
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.collect.Queues;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.GameProfileRepository;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.base64.Base64;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Proxy;
import java.nio.charset.Charset;
import java.security.KeyPair;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import javax.imageio.ImageIO;
import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class MinecraftServer
implements Runnable,
m,
qc,
qx {
    // Cubitick: msToTick = milliseconds until server ticks     
    public static long msToTick;
    
    private static final Logger logger = LogManager.getLogger();
    public static final File a = new File("usercache.json");
    private final azj l;
    private final qw m;
    private final File n;
    private final List<ky> o;
    protected final l b;
    public final oo c;
    private final ma p;
    private final jz q;
    private final Random r;
    private final pb s;
    private int u;
    public lp[] d;
    private mm v;
    private boolean w;
    private boolean x;
    private int y;
    protected final Proxy e;
    public String f;
    public int g;
    private boolean z;
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private String E;
    private int F;
    private int G;
    public final long[] h;
    public long[][] i;
    private KeyPair H;
    private String I;
    private String J;
    private String K;
    private boolean L;
    private boolean M;
    private String N;
    private String O;
    private boolean P;
    private long Q;
    private String R;
    private boolean S;
    private boolean T;
    private final YggdrasilAuthenticationService U;
    private final MinecraftSessionService V;
    private final GameProfileRepository W;
    private final mi X;
    private long Y;
    protected final Queue<FutureTask<?>> j;
    private Thread Z;
    
    // Cubitick : made static
    private static long aa;
    
    private boolean ab;

    public MinecraftServer(File file, Proxy proxy, pb pb2, YggdrasilAuthenticationService yggdrasilAuthenticationService, MinecraftSessionService minecraftSessionService, GameProfileRepository gameProfileRepository, mi mi2) {
        this.m = new qw("server", this, MinecraftServer.av());
        this.o = Lists.newArrayList();
        this.c = new oo();
        this.q = new jz();
        this.r = new Random();
        this.u = -1;
        this.w = true;
        this.G = 0;
        this.h = new long[100];
        this.N = "";
        this.O = "";
        this.Y = 0;
        this.j = Queues.newArrayDeque();
        this.aa = MinecraftServer.av();
        this.e = proxy;
        this.U = yggdrasilAuthenticationService;
        this.V = minecraftSessionService;
        this.W = gameProfileRepository;
        this.X = mi2;
        this.n = file;
        this.p = new ma(this);
        this.b = this.i();
        this.l = new azc(file, pb2);
        this.s = pb2;
    }
    
    // Cubitick: used in the GuiChat class to interrupt the server's sleep
    public static void interruptTickSleep()
    {
        /*MinecraftServer mcs = this;
        if(mcs == null) {
            logger.warn("[Cubitick] Warning: Tried to interrupt server tick sleep, but server is null.");
            return;
        }*/
        MinecraftServer.aa = MinecraftServer.av();
        MinecraftServer.msToTick = -1;
    }

    protected bc i() {
        return new bc(this);
    }

    protected abstract boolean j() throws IOException;

    protected void a(String string) {
        if (this.W().b(string)) {
            logger.info("Converting map!");
            this.b("menu.convertingLevel");
            this.W().a(string, new op(){
                private long b;

                @Override
                public void a(String string) {
                }

                @Override
                public void b(String string) {
                }

                @Override
                public void a(int n2) {
                    if (MinecraftServer.av() - this.b >= 1000) {
                        this.b = MinecraftServer.av();
                        logger.info("Converting... " + n2 + "%");
                    }
                }

                @Override
                public void a() {
                }

                @Override
                public void c(String string) {
                }
            });
        }
    }

    protected synchronized void b(String string) {
        this.R = string;
    }

    public synchronized String k() {
        return this.R;
    }

    protected void a(String string, String string2, long l2, ahy ahy2, String string3) {
        ahw ahw2;
        this.a(string);
        this.b("menu.loadingLevel");
        this.d = new lp[3];
        this.i = new long[this.d.length][100];
        azh azh2 = this.l.a(string, true);
        this.a(this.S(), azh2);
        azg azg2 = azh2.d();
        if (azg2 == null) {
            if (this.V()) {
                ahw2 = lj.a;
            } else {
                ahw2 = new ahw(l2, this.n(), this.m(), this.p(), ahy2);
                ahw2.a(string3);
                if (this.M) {
                    ahw2.a();
                }
            }
            azg2 = new azg(ahw2, string2);
        } else {
            azg2.a(string2);
            ahw2 = new ahw(azg2);
        }
        for (int i2 = 0; i2 < this.d.length; ++i2) {
            int n2 = 0;
            if (i2 == 1) {
                n2 = -1;
            }
            if (i2 == 2) {
                n2 = 1;
            }
            if (i2 == 0) {
                this.d[i2] = this.V() ? (lp)new lj(this, azh2, azg2, n2, this.c).b() : (lp)new lp(this, azh2, azg2, n2, this.c).b();
                this.d[i2].a(ahw2);
            } else {
                this.d[i2] = (lp)new ll(this, azh2, n2, this.d[0], this.c).b();
            }
            this.d[i2].a(new lq(this, this.d[i2]));
            if (this.R()) continue;
            this.d[i2].T().a(this.n());
        }
        this.v.a(this.d);
        this.a(this.o());
        this.l();
    }

    protected void l() {
        int n2 = 16;
        int n3 = 4;
        int n4 = 192;
        int n5 = 625;
        int n6 = 0;
        this.b("menu.generatingTerrain");
        int n7 = 0;
        logger.info("Preparing start region for level " + n7);
        lp lp2 = this.d[n7];
        cj cj2 = lp2.R();
        long l2 = MinecraftServer.av();
        for (int i2 = -192; i2 <= 192 && this.w(); i2 += 16) {
            for (int i3 = -192; i3 <= 192 && this.w(); i3 += 16) {
                long l3 = MinecraftServer.av();
                if (l3 - l2 > 1000) {
                    this.a_("Preparing spawn area", n6 * 100 / 625);
                    l2 = l3;
                }
                ++n6;
                lp2.r().d(cj2.p() + i2 >> 4, cj2.r() + i3 >> 4);
            }
        }
        this.t();
    }

    protected void a(String string, azh azh2) {
        File file = new File(azh2.b(), "resources.zip");
        if (file.isFile()) {
            this.a_("level://" + string + "/" + "resources.zip", "");
        }
    }

    public abstract boolean m();

    public abstract ahw.a n();

    public abstract qk o();

    public abstract boolean p();

    public abstract int q();

    public abstract boolean r();

    public abstract boolean s();

    protected void a_(String string, int n2) {
        this.f = string;
        this.g = n2;
        logger.info(string + ": " + n2 + "%");
    }

    protected void t() {
        this.f = null;
        this.g = 0;
    }

    public void a(boolean bl2) {
        for (lp lp2 : this.d) {
            if (lp2 == null) continue;
            if (!bl2) {
                logger.info("Saving chunks for level '" + lp2.T().j() + "'/" + lp2.s.p().b());
            }
            try {
                lp2.a(true, null);
                continue;
            }
            catch (ahu err) {
                logger.warn(err.getMessage());
            }
        }
    }

    public void u() {
        logger.info("Stopping server");
        if (this.am() != null) {
            this.am().b();
        }
        if (this.v != null) {
            logger.info("Saving players");
            this.v.j();
            this.v.u();
        }
        if (this.d != null) {
            int n2;
            logger.info("Saving worlds");
            for (n2 = 0; n2 < this.d.length; ++n2) {
                if (this.d[n2] == null) continue;
                this.d[n2].b = false;
            }
            this.a(false);
            for (n2 = 0; n2 < this.d.length; ++n2) {
                if (this.d[n2] == null) continue;
                this.d[n2].s();
            }
        }
        if (this.m.d()) {
            this.m.e();
        }
    }

    public boolean w() {
        return this.w;
    }

    public void x() {
        this.w = false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        block27 : {
            try {
                if (this.j()) {
                    this.aa = MinecraftServer.av();
                    long l2 = 0;
                    this.q.a(new fa(this.E));
                    this.q.a(new jz.c("1.9.2", 109));
                    this.a(this.q);
                    while (this.w) {
                        long l3 = MinecraftServer.av();
                        long l4 = l3 - this.aa;
                        
                        // Cubitick
                        if (l4 > 100*Cubitick.getTickms() && this.aa - this.Q >= 15000) {
                            logger.warn("Can't keep up! Did the system time change, or is the server overloaded? Running {}ms behind, skipping {} tick(s)", new Object[]{l4, l4 / 50});
                            l4 = (long)(100*Cubitick.getTickms());
                            this.Q = this.aa;
                        }
                        if (l4 < 0) {
                            logger.warn("Time ran backwards! Did the system time change?");
                            l4 = 0;
                        }
                        l2 += l4;
                        this.aa = l3;
                        if (this.d[0].g()) { // if(this.worldServers[0].areAllPlayersAsleep())
                            this.C();
                            l2 = 0;
                        } else {
                            while (l2 >= Cubitick.getTickms()) {
                                l2 -= Cubitick.getTickms();
                                this.C();
                            }
                        }
                        // Thread.sleep(Math.max(1, 50 - l2));
                        
                        msToTick = (long)(Cubitick.getTickms() - l2);
                        if(msToTick <= 0L) {
                            if(Cubitick.tickrateWorld > 20.0 && !Cubitick.synctick) msToTick = 0L;
                            else msToTick = 1L;
                        }
                        for(long i = 0; i < msToTick; i++) {
                            Thread.sleep(1L);
                            if(!Cubitick.synctick) {    
                            }
                        }
                        
                        
                        // Cubitick: process the chat (for low tickrates where we can't wait for the tick to finish)
                        if(!Cubitick.synctick && msToTick < 0)
                        {
                            synchronized (this.j)
                            {
                                while (!this.j.isEmpty())
                                {
                                    try
                                    {
                                        ((FutureTask)this.j.poll()).run();
                                    }
                                    catch (Throwable var9)
                                    {
                                        logger.fatal(var9);
                                    }
                                }
                            }
                        }
                        
                        this.P = true;
                    }
                    break block27;
                }
                this.a((b)null);
            }
            catch (Throwable err) {
                logger.error("Encountered an unexpected exception", err);
                b b2 = null;
                b2 = err instanceof e ? this.b(((e)err).a()) : this.b(new b("Exception in server tick loop", err));
                File file = new File(new File(this.A(), "crash-reports"), "crash-" + new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss").format(new Date()) + "-server.txt");
                if (b2.a(file)) {
                    logger.error("This crash report has been saved to: " + file.getAbsolutePath());
                } else {
                    logger.error("We were unable to save this crash report to disk.");
                }
                this.a(b2);
            }
            finally {
                try {
                    this.x = true;
                    this.u();
                }
                catch (Throwable err) {
                    logger.error("Exception stopping the server", err);
                }
                finally {
                    this.B();
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void a(jz jz2) {
        File file = this.d("server-icon.png");
        if (!file.exists()) {
            file = this.W().b(this.S(), "icon.png");
        }
        if (file.isFile()) {
            ByteBuf byteBuf = Unpooled.buffer();
            try {
                BufferedImage bufferedImage = ImageIO.read(file);
                Validate.validState((boolean)(bufferedImage.getWidth() == 64), (String)"Must be 64 pixels wide", (Object[])new Object[0]);
                Validate.validState((boolean)(bufferedImage.getHeight() == 64), (String)"Must be 64 pixels high", (Object[])new Object[0]);
                ImageIO.write((RenderedImage)bufferedImage, "PNG", (OutputStream)new ByteBufOutputStream(byteBuf));
                ByteBuf byteBuf2 = Base64.encode((ByteBuf)byteBuf);
                jz2.a("data:image/png;base64," + byteBuf2.toString(Charsets.UTF_8));
            }
            catch (Exception err) {
                logger.error("Couldn't load server icon", (Throwable)err);
            }
            finally {
                byteBuf.release();
            }
        }
    }

    public boolean y() {
        this.ab = this.ab || this.z().isFile();
        return this.ab;
    }

    public File z() {
        return this.W().b(this.S(), "icon.png");
    }

    public File A() {
        return new File(".");
    }

    protected void a(b b2) {
    }

    protected void B() {
    }

    public void C() {
        long l2 = System.nanoTime();
        ++this.y;
        if (this.S) {
            this.S = false;
            this.c.a = true;
            this.c.a();
        }
        this.c.a("root");
        this.D();
        if (l2 - this.Y >= 5000000000L) {
            this.Y = l2;
            this.q.a(new jz.a(this.I(), this.H()));
            GameProfile[] arrgameProfile = new GameProfile[Math.min(this.H(), 12)];
            int n2 = on.a(this.r, 0, this.H() - arrgameProfile.length);
            for (int i2 = 0; i2 < arrgameProfile.length; ++i2) {
                arrgameProfile[i2] = this.v.v().get(n2 + i2).cK();
            }
            Collections.shuffle(Arrays.asList(arrgameProfile));
            this.q.b().a(arrgameProfile);
        }
        if (this.y % 900 == 0) {
            this.c.a("save");
            this.v.j();
            this.a(true);
            this.c.b();
        }
        this.c.a("tallying");
        this.h[this.y % 100] = System.nanoTime() - l2;
        this.c.b();
        this.c.a("snooper");
        if (!this.m.d() && this.y > 100) {
            this.m.a();
        }
        if (this.y % 6000 == 0) {
            this.m.b();
        }
        this.c.b();
        this.c.b();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void D() {
        int n2;
        this.c.a("jobs");
        Queue<FutureTask<?>> queue = this.j;
        synchronized (queue) {
            while (!this.j.isEmpty()) {
                Namepipe.g.a(this.j.poll(), logger);
            }
        }
        this.c.c("levels");
        for (n2 = 0; n2 < this.d.length; ++n2) {
            long l2 = System.nanoTime();
            if (n2 == 0 || this.E()) {
                lp lp2 = this.d[n2];
                this.c.a(lp2.T().j());
                if (this.y % 20 == 0) {
                    this.c.a("timeSync");
                    this.v.a(new hw(lp2.P(), lp2.Q(), lp2.U().b("doDaylightCycle")), lp2.s.p().a());
                    this.c.b();
                }
                this.c.a("tick");
                try {
                    lp2.d();
                }
                catch (Throwable err) {
                    b b2 = Namepipe.b.a(err, "Exception ticking world");
                    lp2.a(b2);
                    throw new e(b2);
                }
                try {
                    lp2.k();
                }
                catch (Throwable err) {
                    b b3 = Namepipe.b.a(err, "Exception ticking world entities");
                    lp2.a(b3);
                    throw new e(b3);
                }
                this.c.b();
                this.c.a("tracker");
                lp2.v().a();
                this.c.b();
                this.c.b();
            }
            this.i[n2][this.y % 100] = System.nanoTime() - l2;
        }
        this.c.c("connection");
        this.am().c();
        this.c.c("players");
        this.v.e();
        this.c.c("tickables");
        for (n2 = 0; n2 < this.o.size(); ++n2) {
            this.o.get(n2).c();
        }
        this.c.b();
    }

    public boolean E() {
        return true;
    }

    public void F() {
        this.Z = new Thread((Runnable)this, "Server thread");
        this.Z.start();
    }

    public File d(String string) {
        return new File(this.A(), string);
    }

    public void f(String string) {
        logger.warn(string);
    }

    public lp a(int n2) {
        if (n2 == -1) {
            return this.d[1];
        }
        if (n2 == 1) {
            return this.d[2];
        }
        return this.d[0];
    }

    public String G() {
        return "1.9.2";
    }

    public int H() {
        return this.v.o();
    }

    public int I() {
        return this.v.p();
    }

    public String[] J() {
        return this.v.f();
    }

    public GameProfile[] K() {
        return this.v.g();
    }

    public String getServerModName() {
        return "vanilla";
    }

    public b b(b b2) {
        b2.g().a("Profiler Position", new Callable<String>(){

            public String a() throws Exception {
                return MinecraftServer.this.c.a ? MinecraftServer.this.c.c() : "N/A (disabled)";
            }

            @Override
            public String call() throws Exception {
                return this.a();
            }
        });
        if (this.v != null) {
            b2.g().a("Player Count", new Callable<String>(){

                public String a() {
                    return "" + MinecraftServer.this.v.o() + " / " + MinecraftServer.this.v.p() + "; " + MinecraftServer.this.v.v();
                }

                @Override
                public String call() throws Exception {
                    return this.a();
                }
            });
        }
        return b2;
    }

    public List<String> a(m m2, String string, cj cj2, boolean bl2) {
        ArrayList arrayList = Lists.newArrayList();
        boolean bl3 = string.startsWith("/");
        if (bl3) {
            string = string.substring(1);
        }
        if (bl3 || bl2) {
            boolean bl4 = !string.contains(" ");
            List<String> list = this.b.a(m2, string, cj2);
            if (!list.isEmpty()) {
                for (String string2 : list) {
                    if (bl4) {
                        arrayList.add("/" + string2);
                        continue;
                    }
                    arrayList.add(string2);
                }
            }
            return arrayList;
        }
        String[] arrstring = string.split(" ", -1);
        String string3 = arrstring[arrstring.length - 1];
        for (String string4 : this.v.f()) {
            if (!Namepipe.i.a(string3, string4)) continue;
            arrayList.add(string4);
        }
        return arrayList;
    }

    public boolean M() {
        return this.n != null;
    }

    @Override
    public String h_() {
        return "Server";
    }

    @Override
    public void a(eu eu2) {
        logger.info(eu2.c());
    }

    @Override
    public boolean a(int n2, String string) {
        return true;
    }

    public l N() {
        return this.b;
    }

    public KeyPair O() {
        return this.H;
    }

    public String Q() {
        return this.I;
    }

    public void i(String string) {
        this.I = string;
    }

    public boolean R() {
        return this.I != null;
    }

    public String S() {
        return this.J;
    }

    public void j(String string) {
        this.J = string;
    }

    public void k(String string) {
        this.K = string;
    }

    public String T() {
        return this.K;
    }

    public void a(KeyPair keyPair) {
        this.H = keyPair;
    }

    public void a(qk qk2) {
        for (int i2 = 0; i2 < this.d.length; ++i2) {
            lp lp2 = this.d[i2];
            if (lp2 == null) continue;
            if (lp2.T().s()) {
                lp2.T().a(qk.d);
                lp2.a(true, true);
                continue;
            }
            if (this.R()) {
                lp2.T().a(qk2);
                lp2.a(lp2.ae() != qk.a, true);
                continue;
            }
            lp2.T().a(qk2);
            lp2.a(this.U(), this.A);
        }
    }

    protected boolean U() {
        return true;
    }

    public boolean V() {
        return this.L;
    }

    public void b(boolean bl2) {
        this.L = bl2;
    }

    public void c(boolean bl2) {
        this.M = bl2;
    }

    public azj W() {
        return this.l;
    }

    public String X() {
        return this.N;
    }

    public String Y() {
        return this.O;
    }

    public void a_(String string, String string2) {
        this.N = string;
        this.O = string2;
    }

    @Override
    public void a(qw qw2) {
        qw2.a("whitelist_enabled", false);
        qw2.a("whitelist_count", 0);
        if (this.v != null) {
            qw2.a("players_current", this.H());
            qw2.a("players_max", this.I());
            qw2.a("players_seen", this.v.q().length);
        }
        qw2.a("uses_auth", this.z);
        qw2.a("gui_state", this.ao() ? "enabled" : "disabled");
        qw2.a("run_time", (MinecraftServer.av() - qw2.g()) / 60 * 1000);
        qw2.a("avg_tick_ms", (int)(on.a(this.h) * 1.0E-6));
        int n2 = 0;
        if (this.d != null) {
            for (int i2 = 0; i2 < this.d.length; ++i2) {
                if (this.d[i2] == null) continue;
                lp lp2 = this.d[i2];
                azg azg2 = lp2.T();
                qw2.a("world[" + n2 + "][dimension]", lp2.s.p().a());
                qw2.a("world[" + n2 + "][mode]", (Object)((Object)azg2.q()));
                qw2.a("world[" + n2 + "][difficulty]", (Object)((Object)lp2.ae()));
                qw2.a("world[" + n2 + "][hardcore]", azg2.s());
                qw2.a("world[" + n2 + "][generator_name]", azg2.t().a());
                qw2.a("world[" + n2 + "][generator_version]", azg2.t().d());
                qw2.a("world[" + n2 + "][height]", this.F);
                qw2.a("world[" + n2 + "][chunks_loaded]", lp2.r().g());
                ++n2;
            }
        }
        qw2.a("worlds", n2);
    }

    @Override
    public void b(qw qw2) {
        qw2.b("singleplayer", this.R());
        qw2.b("server_brand", this.getServerModName());
        qw2.b("gui_supported", GraphicsEnvironment.isHeadless() ? "headless" : "supported");
        qw2.b("dedicated", this.aa());
    }

    @Override
    public boolean Z() {
        return true;
    }

    public abstract boolean aa();

    public boolean ab() {
        return this.z;
    }

    public void d(boolean bl2) {
        this.z = bl2;
    }

    public boolean ac() {
        return this.A;
    }

    public void e(boolean bl2) {
        this.A = bl2;
    }

    public boolean ad() {
        return this.B;
    }

    public abstract boolean ae();

    public void f(boolean bl2) {
        this.B = bl2;
    }

    public boolean af() {
        return this.C;
    }

    public void g(boolean bl2) {
        this.C = bl2;
    }

    public boolean ag() {
        return this.D;
    }

    public void h(boolean bl2) {
        this.D = bl2;
    }

    public abstract boolean ah();

    public String ai() {
        return this.E;
    }

    public void l(String string) {
        this.E = string;
    }

    public int aj() {
        return this.F;
    }

    public void c(int n2) {
        this.F = n2;
    }

    public boolean ak() {
        return this.x;
    }

    public mm al() {
        return this.v;
    }

    public void a(mm mm2) {
        this.v = mm2;
    }

    public void a(ahw.a a2) {
        for (int i2 = 0; i2 < this.d.length; ++i2) {
            this.d[i2].T().a(a2);
        }
    }

    public ma am() {
        return this.p;
    }

    public boolean an() {
        return this.P;
    }

    public boolean ao() {
        return false;
    }

    public abstract String a(ahw.a var1, boolean var2);

    public int ap() {
        return this.y;
    }

    public void aq() {
        this.S = true;
    }

    public qw ar() {
        return this.m;
    }

    @Override
    public cj c() {
        return cj.a;
    }

    @Override
    public bbg d() {
        return bbg.a;
    }

    @Override
    public aht e() {
        return this.d[0];
    }

    @Override
    public rr f() {
        return null;
    }

    public boolean a(aht aht2, cj cj2, zj zj2) {
        return false;
    }

    public boolean at() {
        return this.T;
    }

    public Proxy au() {
        return this.e;
    }

    public static long av() {
        return System.currentTimeMillis();
    }

    public int aw() {
        return this.G;
    }

    public void d(int n2) {
        this.G = n2;
    }

    @Override
    public eu i_() {
        return new fa(this.h_());
    }

    public boolean ax() {
        return true;
    }

    public MinecraftSessionService ay() {
        return this.V;
    }

    public GameProfileRepository az() {
        return this.W;
    }

    public mi aA() {
        return this.X;
    }

    public jz aB() {
        return this.q;
    }

    public void aC() {
        this.Y = 0;
    }

    public rr a(UUID uUID) {
        for (lp lp2 : this.d) {
            rr rr2;
            if (lp2 == null || (rr2 = lp2.a(uUID)) == null) continue;
            return rr2;
        }
        return null;
    }

    @Override
    public boolean z_() {
        return this.d[0].U().b("sendCommandFeedback");
    }

    @Override
    public void a(n.a a2, int n2) {
    }

    @Override
    public MinecraftServer h() {
        return this;
    }

    public int aD() {
        return 29999984;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public <V> ListenableFuture<V> a(Callable<V> callable) {
        Validate.notNull(callable);
        if (!this.aE() && !this.ak()) {
            ListenableFutureTask listenableFutureTask = ListenableFutureTask.create(callable);
            Queue<FutureTask<?>> queue = this.j;
            synchronized (queue) {
                this.j.add((ListenableFutureTask)listenableFutureTask);
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
        return Thread.currentThread() == this.Z;
    }

    public int aF() {
        return 256;
    }

    public pb aI() {
        return this.s;
    }

    public int a(lp lp2) {
        if (lp2 != null) {
            return lp2.U().c("spawnRadius");
        }
        return 10;
    }

}
