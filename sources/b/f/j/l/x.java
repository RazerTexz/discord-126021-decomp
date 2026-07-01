package b.f.j.l;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

/* JADX INFO: compiled from: PoolFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class x {
    public final w a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public s f601b;
    public d c;
    public s d;
    public s e;
    public b.f.d.g.g f;
    public b.f.d.g.j g;
    public b.f.d.g.a h;

    public x(w wVar) {
        this.a = wVar;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public d a() {
        if (this.c == null) {
            String str = this.a.i;
            byte b2 = -1;
            switch (str.hashCode()) {
                case -1868884870:
                    if (str.equals("legacy_default_params")) {
                        b2 = 3;
                    }
                    break;
                case -1106578487:
                    if (str.equals("legacy")) {
                        b2 = 4;
                    }
                    break;
                case -404562712:
                    if (str.equals("experimental")) {
                        b2 = 2;
                    }
                    break;
                case -402149703:
                    if (str.equals("dummy_with_tracking")) {
                        b2 = 1;
                    }
                    break;
                case 95945896:
                    if (str.equals("dummy")) {
                        b2 = 0;
                    }
                    break;
            }
            if (b2 == 0) {
                this.c = new l();
            } else if (b2 == 1) {
                this.c = new m();
            } else if (b2 == 2) {
                Objects.requireNonNull(this.a);
                int i = this.a.j;
                v vVarH = v.h();
                Objects.requireNonNull(this.a);
                this.c = new p(0, i, vVarH, null);
            } else if (b2 != 3) {
                w wVar = this.a;
                this.c = new h(wVar.d, wVar.a, wVar.f600b, false);
            } else {
                this.c = new h(this.a.d, j.a(), this.a.f600b, false);
            }
        }
        return this.c;
    }

    public int b() {
        return this.a.c.d;
    }

    public b.f.d.g.g c(int i) {
        s sVar;
        if (this.f == null) {
            if (i == 0) {
                if (this.e == null) {
                    try {
                        Constructor<?> constructor = Class.forName("com.facebook.imagepipeline.memory.NativeMemoryChunkPool").getConstructor(b.f.d.g.c.class, y.class, z.class);
                        w wVar = this.a;
                        this.e = (s) constructor.newInstance(wVar.d, wVar.e, wVar.f);
                    } catch (ClassNotFoundException e) {
                        b.f.d.e.a.f("PoolFactory", "", e);
                        this.e = null;
                    } catch (IllegalAccessException e2) {
                        b.f.d.e.a.f("PoolFactory", "", e2);
                        this.e = null;
                    } catch (InstantiationException e3) {
                        b.f.d.e.a.f("PoolFactory", "", e3);
                        this.e = null;
                    } catch (NoSuchMethodException e4) {
                        b.f.d.e.a.f("PoolFactory", "", e4);
                        this.e = null;
                    } catch (InvocationTargetException e5) {
                        b.f.d.e.a.f("PoolFactory", "", e5);
                        this.e = null;
                    }
                }
                sVar = this.e;
            } else if (i == 1) {
                if (this.d == null) {
                    try {
                        Constructor<?> constructor2 = Class.forName("com.facebook.imagepipeline.memory.BufferMemoryChunkPool").getConstructor(b.f.d.g.c.class, y.class, z.class);
                        w wVar2 = this.a;
                        this.d = (s) constructor2.newInstance(wVar2.d, wVar2.e, wVar2.f);
                    } catch (ClassNotFoundException unused) {
                        this.d = null;
                    } catch (IllegalAccessException unused2) {
                        this.d = null;
                    } catch (InstantiationException unused3) {
                        this.d = null;
                    } catch (NoSuchMethodException unused4) {
                        this.d = null;
                    } catch (InvocationTargetException unused5) {
                        this.d = null;
                    }
                }
                sVar = this.d;
            } else {
                if (i != 2) {
                    throw new IllegalArgumentException("Invalid MemoryChunkType");
                }
                if (this.f601b == null) {
                    try {
                        Constructor<?> constructor3 = Class.forName("com.facebook.imagepipeline.memory.AshmemMemoryChunkPool").getConstructor(b.f.d.g.c.class, y.class, z.class);
                        w wVar3 = this.a;
                        this.f601b = (s) constructor3.newInstance(wVar3.d, wVar3.e, wVar3.f);
                    } catch (ClassNotFoundException unused6) {
                        this.f601b = null;
                    } catch (IllegalAccessException unused7) {
                        this.f601b = null;
                    } catch (InstantiationException unused8) {
                        this.f601b = null;
                    } catch (NoSuchMethodException unused9) {
                        this.f601b = null;
                    } catch (InvocationTargetException unused10) {
                        this.f601b = null;
                    }
                }
                sVar = this.f601b;
            }
            b.c.a.a0.d.y(sVar, "failed to get pool for chunk type: " + i);
            this.f = new u(sVar, d());
        }
        return this.f;
    }

    public b.f.d.g.j d() {
        if (this.g == null) {
            this.g = new b.f.d.g.j(e());
        }
        return this.g;
    }

    public b.f.d.g.a e() {
        if (this.h == null) {
            w wVar = this.a;
            this.h = new o(wVar.d, wVar.g, wVar.h);
        }
        return this.h;
    }
}
