package f0.e0.g;

import androidx.core.app.NotificationCompat;
import f0.c0;
import f0.e0.k.h$a;
import java.lang.ref.Reference;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: RealConnectionPool.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k {
    public final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f0.e0.f.c f3621b;
    public final k$a c;
    public final ConcurrentLinkedQueue<j> d;
    public final int e;

    public k(f0.e0.f.d dVar, int i, long j, TimeUnit timeUnit) {
        d0.z.d.m.checkParameterIsNotNull(dVar, "taskRunner");
        d0.z.d.m.checkParameterIsNotNull(timeUnit, "timeUnit");
        this.e = i;
        this.a = timeUnit.toNanos(j);
        this.f3621b = dVar.f();
        this.c = new k$a(this, b.d.b.a.a.J(new StringBuilder(), f0.e0.c.g, " ConnectionPool"));
        this.d = new ConcurrentLinkedQueue<>();
        if (!(j > 0)) {
            throw new IllegalArgumentException(b.d.b.a.a.t("keepAliveDuration <= 0: ", j).toString());
        }
    }

    public final boolean a(f0.a aVar, e eVar, List<c0> list, boolean z2) {
        d0.z.d.m.checkParameterIsNotNull(aVar, "address");
        d0.z.d.m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
        for (j jVar : this.d) {
            d0.z.d.m.checkExpressionValueIsNotNull(jVar, "connection");
            synchronized (jVar) {
                if (z2) {
                    if (!jVar.j()) {
                    }
                }
                if (jVar.h(aVar, list)) {
                    eVar.f(jVar);
                    return true;
                }
            }
        }
        return false;
    }

    public final int b(j jVar, long j) {
        byte[] bArr = f0.e0.c.a;
        List<Reference<e>> list = jVar.o;
        int i = 0;
        while (i < list.size()) {
            Reference<e> reference = list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                StringBuilder sbU = b.d.b.a.a.U("A connection to ");
                sbU.append(jVar.q.a.a);
                sbU.append(" was leaked. ");
                sbU.append("Did you forget to close a response body?");
                String string = sbU.toString();
                h$a h_a = f0.e0.k.h.c;
                f0.e0.k.h.a.k(string, ((e$b) reference).a);
                list.remove(i);
                jVar.i = true;
                if (list.isEmpty()) {
                    jVar.p = j - this.a;
                    return 0;
                }
            }
        }
        return list.size();
    }
}
