package p600f0.p601e0.p605g;

import androidx.core.app.NotificationCompat;
import java.lang.ref.Reference;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;
import p600f0.C12261a;
import p600f0.C12266c0;
import p600f0.p601e0.C12272c;
import p600f0.p601e0.p604f.AbstractC12277a;
import p600f0.p601e0.p604f.C12279c;
import p600f0.p601e0.p604f.C12280d;
import p600f0.p601e0.p609k.C12333h;

/* JADX INFO: renamed from: f0.e0.g.k */
/* JADX INFO: compiled from: RealConnectionPool.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12291k {

    /* JADX INFO: renamed from: a */
    public final long f25507a;

    /* JADX INFO: renamed from: b */
    public final C12279c f25508b;

    /* JADX INFO: renamed from: c */
    public final a f25509c;

    /* JADX INFO: renamed from: d */
    public final ConcurrentLinkedQueue<C12290j> f25510d;

    /* JADX INFO: renamed from: e */
    public final int f25511e;

    /* JADX INFO: renamed from: f0.e0.g.k$a */
    /* JADX INFO: compiled from: RealConnectionPool.kt */
    public static final class a extends AbstractC12277a {
        public a(String str) {
            super(str, true);
        }

        @Override // p600f0.p601e0.p604f.AbstractC12277a
        /* JADX INFO: renamed from: a */
        public long mo10150a() {
            C12291k c12291k = C12291k.this;
            long jNanoTime = System.nanoTime();
            C12290j c12290j = null;
            long j = Long.MIN_VALUE;
            int i = 0;
            int i2 = 0;
            for (C12290j c12290j2 : c12291k.f25510d) {
                C12238m.checkExpressionValueIsNotNull(c12290j2, "connection");
                synchronized (c12290j2) {
                    if (c12291k.m10208b(c12290j2, jNanoTime) > 0) {
                        i2++;
                    } else {
                        i++;
                        long j2 = jNanoTime - c12290j2.f25505p;
                        if (j2 > j) {
                            c12290j = c12290j2;
                            j = j2;
                        }
                    }
                }
            }
            long j3 = c12291k.f25507a;
            if (j < j3 && i <= c12291k.f25511e) {
                if (i > 0) {
                    return j3 - j;
                }
                if (i2 > 0) {
                    return j3;
                }
                return -1L;
            }
            if (c12290j == null) {
                C12238m.throwNpe();
            }
            synchronized (c12290j) {
                if (!c12290j.f25504o.isEmpty()) {
                    return 0L;
                }
                if (c12290j.f25505p + j != jNanoTime) {
                    return 0L;
                }
                c12290j.f25498i = true;
                c12291k.f25510d.remove(c12290j);
                C12272c.m10124e(c12290j.m10205n());
                if (!c12291k.f25510d.isEmpty()) {
                    return 0L;
                }
                c12291k.f25508b.m10152a();
                return 0L;
            }
        }
    }

    public C12291k(C12280d c12280d, int i, long j, TimeUnit timeUnit) {
        C12238m.checkParameterIsNotNull(c12280d, "taskRunner");
        C12238m.checkParameterIsNotNull(timeUnit, "timeUnit");
        this.f25511e = i;
        this.f25507a = timeUnit.toNanos(j);
        this.f25508b = c12280d.m10162f();
        this.f25509c = new a(C1643a.m822J(new StringBuilder(), C12272c.f25403g, " ConnectionPool"));
        this.f25510d = new ConcurrentLinkedQueue<>();
        if (!(j > 0)) {
            throw new IllegalArgumentException(C1643a.m877t("keepAliveDuration <= 0: ", j).toString());
        }
    }

    /* JADX INFO: renamed from: a */
    public final boolean m10207a(C12261a c12261a, C12285e c12285e, List<C12266c0> list, boolean z2) {
        C12238m.checkParameterIsNotNull(c12261a, "address");
        C12238m.checkParameterIsNotNull(c12285e, NotificationCompat.CATEGORY_CALL);
        for (C12290j c12290j : this.f25510d) {
            C12238m.checkExpressionValueIsNotNull(c12290j, "connection");
            synchronized (c12290j) {
                if (z2) {
                    if (!c12290j.m10201j()) {
                    }
                }
                if (c12290j.m10199h(c12261a, list)) {
                    c12285e.m10181f(c12290j);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    public final int m10208b(C12290j c12290j, long j) {
        byte[] bArr = C12272c.f25397a;
        List<Reference<C12285e>> list = c12290j.f25504o;
        int i = 0;
        while (i < list.size()) {
            Reference<C12285e> reference = list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                StringBuilder sbM833U = C1643a.m833U("A connection to ");
                sbM833U.append(c12290j.f25506q.f25370a.f25353a);
                sbM833U.append(" was leaked. ");
                sbM833U.append("Did you forget to close a response body?");
                String string = sbM833U.toString();
                C12333h.a aVar = C12333h.f25785c;
                C12333h.f25783a.mo10322k(string, ((C12285e.b) reference).f25485a);
                list.remove(i);
                c12290j.f25498i = true;
                if (list.isEmpty()) {
                    c12290j.f25505p = j - this.f25507a;
                    return 0;
                }
            }
        }
        return list.size();
    }
}
