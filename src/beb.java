// GuiChat

/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.input.Mouse
 */
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class beb
extends bey
implements bfd {
    private static final Logger f = LogManager.getLogger();
    private String g = "";
    private int h = -1;
    private bfe i;
    protected bda a;
    private String r = "";

    public beb() {
    }

    public beb(String string) {
        this.r = string;
    }

    @Override
    public void b() {
        Keyboard.enableRepeatEvents((boolean)true);
        this.h = this.j.r.d().c().size();
        this.a = new bda(0, this.q, 4, this.m - 12, this.l - 4, 12);
        this.a.f(100);
        this.a.a(false);
        this.a.b(true);
        this.a.a(this.r);
        this.a.d(false);
        this.i = new a(this.a);
    }

    @Override
    public void m() {
        Keyboard.enableRepeatEvents((boolean)false);
        this.j.r.d().d();
    }

    @Override
    public void e() {
        this.a.a();
    }

    @Override
    protected void a(char c2, int n2) {
        this.i.d();
        if (n2 == 15) {
            this.i.a();
        } else {
            this.i.c();
        }
        if (n2 == 1) {
            this.j.a((bey)null);
        } else if (n2 == 28 || n2 == 156) {
            String string = this.a.b().trim();
            if (!string.isEmpty()) {
                this.f(string);
                
                // Cubitick: interrupt the server's sleep so it can process the chat
                if(!Cubitick.synctick)
                {
                    MinecraftServer.interruptTickSleep();
                }
            }
            this.j.a((bey)null);
        } else if (n2 == 200) {
            this.b(-1);
        } else if (n2 == 208) {
            this.b(1);
        } else if (n2 == 201) {
            this.j.r.d().b(this.j.r.d().i() - 1);
        } else if (n2 == 209) {
            this.j.r.d().b(- this.j.r.d().i() + 1);
        } else {
            this.a.a(c2, n2);
        }
    }

    @Override
    public void k() {
        super.k();
        int n2 = Mouse.getEventDWheel();
        if (n2 != 0) {
            if (n2 > 1) {
                n2 = 1;
            }
            if (n2 < -1) {
                n2 = -1;
            }
            if (!beb.r()) {
                n2 *= 7;
            }
            this.j.r.d().b(n2);
        }
    }

    @Override
    protected void a(int n2, int n3, int n4) {
        eu eu2;
        if (n4 == 0 && this.a(eu2 = this.j.r.d().a(Mouse.getX(), Mouse.getY()))) {
            return;
        }
        this.a.a(n2, n3, n4);
        super.a(n2, n3, n4);
    }

    @Override
    protected void a(String string, boolean bl2) {
        if (bl2) {
            this.a.a(string);
        } else {
            this.a.b(string);
        }
    }

    public void b(int n2) {
        int n3 = this.h + n2;
        int n4 = this.j.r.d().c().size();
        if ((n3 = on.a(n3, 0, n4)) == this.h) {
            return;
        }
        if (n3 == n4) {
            this.h = n4;
            this.a.a(this.g);
            return;
        }
        if (this.h == n4) {
            this.g = this.a.b();
        }
        this.a.a(this.j.r.d().c().get(n3));
        this.h = n3;
    }

    @Override
    public void a(int n2, int n3, float f2) {
        beb.a(2, this.m - 14, this.l - 2, this.m - 2, Integer.MIN_VALUE);
        this.a.g();
        eu eu2 = this.j.r.d().a(Mouse.getX(), Mouse.getY());
        if (eu2 != null && eu2.b().i() != null) {
            this.a(eu2, n2, n3);
        }
        super.a(n2, n3, f2);
    }

    @Override
    public boolean d() {
        return false;
    }

    @Override
    public /* varargs */ void a(String ... arrstring) {
        this.i.a(arrstring);
    }

    public static class a
    extends bfe {
        private bcc g = bcc.z();

        public a(bda bda2) {
            super(bda2, false);
        }

        @Override
        public void a() {
            super.a();
            if (this.f.size() > 1) {
                StringBuilder stringBuilder = new StringBuilder();
                for (String string : this.f) {
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(string);
                }
                this.g.r.d().a(new fa(stringBuilder.toString()), 1);
            }
        }

        @Override
        public cj b() {
            cj cj2 = null;
            if (this.g.t != null && this.g.t.a == Namepipe.bbf_a.b) {
                cj2 = this.g.t.a();
            }
            return cj2;
        }
    }
}
