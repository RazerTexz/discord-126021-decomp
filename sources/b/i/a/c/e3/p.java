package b.i.a.c.e3;

import android.content.Context;
import android.os.Handler;
import androidx.annotation.Nullable;
import b.i.a.c.f3.v$b;
import com.discord.api.permission.Permission;
import com.discord.stores.StoreGuildScheduledEvents;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: DefaultBandwidthMeter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class p implements f, a0 {
    public static final b.i.b.b.p<Long> a = b.i.b.b.p.v(5400000L, 3300000L, 2000000L, 1300000L, 760000L);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b.i.b.b.p<Long> f945b = b.i.b.b.p.v(1700000L, 820000L, 450000L, 180000L, 130000L);
    public static final b.i.b.b.p<Long> c = b.i.b.b.p.v(2300000L, 1300000L, 1000000L, 820000L, 570000L);
    public static final b.i.b.b.p<Long> d = b.i.b.b.p.v(3400000L, 2000000L, 1400000L, 1000000L, 620000L);
    public static final b.i.b.b.p<Long> e = b.i.b.b.p.v(7500000L, 5200000L, 3700000L, Long.valueOf(StoreGuildScheduledEvents.FETCH_GUILD_EVENTS_THRESHOLD), 1100000L);
    public static final b.i.b.b.p<Long> f = b.i.b.b.p.v(3300000L, 1900000L, 1700000L, 1500000L, 1200000L);

    @Nullable
    public static p g;
    public final b.i.b.b.q<Integer, Long> h;
    public final f$a$a i = new f$a$a();
    public final x j;
    public final b.i.a.c.f3.g k;
    public final boolean l;
    public int m;
    public long n;
    public long o;
    public int p;
    public long q;
    public long r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f946s;
    public long t;

    public p(Context context, Map map, int i, b.i.a.c.f3.g gVar, boolean z2, p$a p_a) {
        b.i.a.c.f3.v vVar;
        int i2;
        this.h = b.i.b.b.q.a(map);
        this.j = new x(i);
        this.k = gVar;
        this.l = z2;
        if (context == null) {
            this.p = 0;
            this.f946s = h(0);
            return;
        }
        synchronized (b.i.a.c.f3.v.class) {
            if (b.i.a.c.f3.v.a == null) {
                b.i.a.c.f3.v.a = new b.i.a.c.f3.v(context);
            }
            vVar = b.i.a.c.f3.v.a;
        }
        synchronized (vVar.d) {
            i2 = vVar.e;
        }
        this.p = i2;
        this.f946s = h(i2);
        b bVar = new b(this);
        for (WeakReference<v$b> weakReference : vVar.c) {
            if (weakReference.get() == null) {
                vVar.c.remove(weakReference);
            }
        }
        vVar.c.add(new WeakReference<>(bVar));
        vVar.f982b.post(new b.i.a.c.f3.c(vVar, bVar));
    }

    public static boolean i(n nVar, boolean z2) {
        return z2 && !nVar.c(8);
    }

    @Override // b.i.a.c.e3.a0
    public synchronized void a(l lVar, n nVar, boolean z2) {
        if (i(nVar, z2)) {
            b.c.a.a0.d.D(this.m > 0);
            long jD = this.k.d();
            int i = (int) (jD - this.n);
            this.q += (long) i;
            long j = this.r;
            long j2 = this.o;
            this.r = j + j2;
            if (i > 0) {
                this.j.a((int) Math.sqrt(j2), (j2 * 8000.0f) / i);
                if (this.q >= 2000 || this.r >= Permission.VIEW_GUILD_ANALYTICS) {
                    this.f946s = (long) this.j.b(0.5f);
                }
                j(i, this.o, this.f946s);
                this.n = jD;
                this.o = 0L;
            }
            this.m--;
        }
    }

    @Override // b.i.a.c.e3.a0
    public synchronized void b(l lVar, n nVar, boolean z2) {
        if (i(nVar, z2)) {
            if (this.m == 0) {
                this.n = this.k.d();
            }
            this.m++;
        }
    }

    @Override // b.i.a.c.e3.f
    public a0 c() {
        return this;
    }

    @Override // b.i.a.c.e3.f
    public void d(f$a f_a) {
        this.i.a(f_a);
    }

    @Override // b.i.a.c.e3.a0
    public synchronized void e(l lVar, n nVar, boolean z2, int i) {
        if (i(nVar, z2)) {
            this.o += (long) i;
        }
    }

    @Override // b.i.a.c.e3.f
    public void f(Handler handler, f$a f_a) {
        f$a$a f_a_a = this.i;
        Objects.requireNonNull(f_a_a);
        f_a_a.a(f_a);
        f_a_a.a.add(new f$a$a$a(handler, f_a));
    }

    @Override // b.i.a.c.e3.a0
    public void g(l lVar, n nVar, boolean z2) {
    }

    public final long h(int i) {
        Long l = this.h.get(Integer.valueOf(i));
        if (l == null) {
            l = this.h.get(0);
        }
        if (l == null) {
            l = 1000000L;
        }
        return l.longValue();
    }

    public final void j(int i, long j, long j2) {
        if (i == 0 && j == 0 && j2 == this.t) {
            return;
        }
        this.t = j2;
        for (f$a$a$a f_a_a_a : this.i.a) {
            if (!f_a_a_a.c) {
                f_a_a_a.a.post(new a(f_a_a_a, i, j, j2));
            }
        }
    }
}
