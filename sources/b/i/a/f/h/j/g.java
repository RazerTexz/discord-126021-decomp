package b.i.a.f.h.j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"StaticFieldLeak"})
public class g {
    public static volatile g a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f1417b;
    public final Context c;
    public final b.i.a.f.e.o.b d;
    public final z e;
    public final m0 f;
    public final b.i.a.f.b.f g;
    public final a h;
    public final c0 i;
    public final a1 j;
    public final p0 k;

    public g(i iVar) {
        Context context = iVar.a;
        AnimatableValueParser.z(context, "Application context can't be null");
        Context context2 = iVar.f1419b;
        Objects.requireNonNull(context2, "null reference");
        this.f1417b = context;
        this.c = context2;
        b.i.a.f.e.o.c cVar = b.i.a.f.e.o.c.a;
        this.d = cVar;
        this.e = new z(this);
        m0 m0Var = new m0(this);
        m0Var.J();
        this.f = m0Var;
        m0 m0VarC = c();
        String str = f.a;
        m0VarC.a(4, outline.k(outline.b(str, Opcodes.I2F), "Google Analytics ", str, " is starting up. To enable debug logging on a device run:\n  adb shell setprop log.tag.GAv4 DEBUG\n  adb logcat -s GAv4"), null, null, null);
        p0 p0Var = new p0(this);
        p0Var.J();
        this.k = p0Var;
        a1 a1Var = new a1(this);
        a1Var.J();
        this.j = a1Var;
        a aVar = new a(this, iVar);
        Objects.requireNonNull(cVar, "null reference");
        q qVar = new q(this);
        if (b.i.a.f.b.f.a == null) {
            synchronized (b.i.a.f.b.f.class) {
                if (b.i.a.f.b.f.a == null) {
                    b.i.a.f.b.f.a = new b.i.a.f.b.f(context);
                }
            }
        }
        b.i.a.f.b.f fVar = b.i.a.f.b.f.a;
        fVar.e = new h(this);
        this.g = fVar;
        b.i.a.f.b.b bVar = new b.i.a.f.b.b(this);
        qVar.J();
        c0 c0Var = new c0(this);
        c0Var.J();
        this.i = c0Var;
        aVar.J();
        this.h = aVar;
        g gVar = bVar.a;
        a(gVar.j);
        a1 a1Var2 = gVar.j;
        a1Var2.N();
        a1Var2.N();
        if (a1Var2.p) {
            a1Var2.N();
        }
        a1Var2.N();
        r rVar = aVar.l;
        rVar.N();
        AnimatableValueParser.G(!rVar.l, "Analytics backend already started");
        rVar.l = true;
        rVar.q().a(new u(rVar));
    }

    public static void a(e eVar) {
        AnimatableValueParser.z(eVar, "Analytics service not created/initialized");
        AnimatableValueParser.o(eVar.I(), "Analytics service not initialized");
    }

    public static g b(Context context) {
        Objects.requireNonNull(context, "null reference");
        if (a == null) {
            synchronized (g.class) {
                if (a == null) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    g gVar = new g(new i(context));
                    a = gVar;
                    synchronized (b.i.a.f.b.b.class) {
                        List<Runnable> list = b.i.a.f.b.b.f1330b;
                        if (list != null) {
                            Iterator<Runnable> it = list.iterator();
                            while (it.hasNext()) {
                                it.next().run();
                            }
                            b.i.a.f.b.b.f1330b = null;
                        }
                    }
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                    long jLongValue = e0.B.a.longValue();
                    if (jElapsedRealtime2 > jLongValue) {
                        gVar.c().f("Slow initialization (ms)", Long.valueOf(jElapsedRealtime2), Long.valueOf(jLongValue));
                    }
                }
            }
        }
        return a;
    }

    public final m0 c() {
        a(this.f);
        return this.f;
    }

    public final b.i.a.f.b.f d() {
        Objects.requireNonNull(this.g, "null reference");
        return this.g;
    }

    public final a e() {
        a(this.h);
        return this.h;
    }
}
