package p007b.p225i.p226a.p288f.p313h.p323j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.objectweb.asm.Opcodes;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p291b.C3176b;
import p007b.p225i.p226a.p288f.p291b.C3180f;
import p007b.p225i.p226a.p288f.p299e.p308o.C3401c;
import p007b.p225i.p226a.p288f.p299e.p308o.InterfaceC3400b;

/* JADX INFO: renamed from: b.i.a.f.h.j.g */
/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"StaticFieldLeak"})
public class C3515g {

    /* JADX INFO: renamed from: a */
    public static volatile C3515g f9721a;

    /* JADX INFO: renamed from: b */
    public final Context f9722b;

    /* JADX INFO: renamed from: c */
    public final Context f9723c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC3400b f9724d;

    /* JADX INFO: renamed from: e */
    public final C3554z f9725e;

    /* JADX INFO: renamed from: f */
    public final C3529m0 f9726f;

    /* JADX INFO: renamed from: g */
    public final C3180f f9727g;

    /* JADX INFO: renamed from: h */
    public final C3497a f9728h;

    /* JADX INFO: renamed from: i */
    public final C3504c0 f9729i;

    /* JADX INFO: renamed from: j */
    public final C3499a1 f9730j;

    /* JADX INFO: renamed from: k */
    public final C3535p0 f9731k;

    public C3515g(C3520i c3520i) {
        Context context = c3520i.f9735a;
        C1460d.m595z(context, "Application context can't be null");
        Context context2 = c3520i.f9736b;
        Objects.requireNonNull(context2, "null reference");
        this.f9722b = context;
        this.f9723c = context2;
        C3401c c3401c = C3401c.f9584a;
        this.f9724d = c3401c;
        this.f9725e = new C3554z(this);
        C3529m0 c3529m0 = new C3529m0(this);
        c3529m0.m4443J();
        this.f9726f = c3529m0;
        C3529m0 c3529m0M4451c = m4451c();
        String str = C3512f.f9715a;
        c3529m0M4451c.m4430a(4, C1643a.m859k(C1643a.m841b(str, Opcodes.I2F), "Google Analytics ", str, " is starting up. To enable debug logging on a device run:\n  adb shell setprop log.tag.GAv4 DEBUG\n  adb logcat -s GAv4"), null, null, null);
        C3535p0 c3535p0 = new C3535p0(this);
        c3535p0.m4443J();
        this.f9731k = c3535p0;
        C3499a1 c3499a1 = new C3499a1(this);
        c3499a1.m4443J();
        this.f9730j = c3499a1;
        C3497a c3497a = new C3497a(this, c3520i);
        Objects.requireNonNull(c3401c, "null reference");
        C3536q c3536q = new C3536q(this);
        if (C3180f.f9195a == null) {
            synchronized (C3180f.class) {
                if (C3180f.f9195a == null) {
                    C3180f.f9195a = new C3180f(context);
                }
            }
        }
        C3180f c3180f = C3180f.f9195a;
        c3180f.f9199e = new C3518h(this);
        this.f9727g = c3180f;
        C3176b c3176b = new C3176b(this);
        c3536q.m4443J();
        C3504c0 c3504c0 = new C3504c0(this);
        c3504c0.m4443J();
        this.f9729i = c3504c0;
        c3497a.m4443J();
        this.f9728h = c3497a;
        C3515g c3515g = c3176b.f9194a;
        m4449a(c3515g.f9730j);
        C3499a1 c3499a2 = c3515g.f9730j;
        c3499a2.m4444N();
        c3499a2.m4444N();
        if (c3499a2.f9670p) {
            c3499a2.m4444N();
        }
        c3499a2.m4444N();
        C3538r c3538r = c3497a.f9661l;
        c3538r.m4444N();
        C1460d.m435G(!c3538r.f9782l, "Analytics backend already started");
        c3538r.f9782l = true;
        c3538r.m4435q().m3968a(new RunnableC3544u(c3538r));
    }

    /* JADX INFO: renamed from: a */
    public static void m4449a(AbstractC3509e abstractC3509e) {
        C1460d.m595z(abstractC3509e, "Analytics service not created/initialized");
        C1460d.m551o(abstractC3509e.m4442I(), "Analytics service not initialized");
    }

    /* JADX INFO: renamed from: b */
    public static C3515g m4450b(Context context) {
        Objects.requireNonNull(context, "null reference");
        if (f9721a == null) {
            synchronized (C3515g.class) {
                if (f9721a == null) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    C3515g c3515g = new C3515g(new C3520i(context));
                    f9721a = c3515g;
                    synchronized (C3176b.class) {
                        List<Runnable> list = C3176b.f9193b;
                        if (list != null) {
                            Iterator<Runnable> it = list.iterator();
                            while (it.hasNext()) {
                                it.next().run();
                            }
                            C3176b.f9193b = null;
                        }
                    }
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                    long jLongValue = C3510e0.f9687B.f9716a.longValue();
                    if (jElapsedRealtime2 > jLongValue) {
                        c3515g.m4451c().m4433f("Slow initialization (ms)", Long.valueOf(jElapsedRealtime2), Long.valueOf(jLongValue));
                    }
                }
            }
        }
        return f9721a;
    }

    /* JADX INFO: renamed from: c */
    public final C3529m0 m4451c() {
        m4449a(this.f9726f);
        return this.f9726f;
    }

    /* JADX INFO: renamed from: d */
    public final C3180f m4452d() {
        Objects.requireNonNull(this.f9727g, "null reference");
        return this.f9727g;
    }

    /* JADX INFO: renamed from: e */
    public final C3497a m4453e() {
        m4449a(this.f9728h);
        return this.f9728h;
    }
}
