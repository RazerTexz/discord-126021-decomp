package rx;

import j0.l.c.h;
import j0.l.c.i;
import j0.l.d.a;
import java.util.concurrent.TimeUnit;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Scheduler$Worker implements Subscription {
    public abstract Subscription a(Action0 action0);

    public abstract Subscription b(Action0 action0, long j, TimeUnit timeUnit);

    public Subscription c(Action0 action0, long j, long j2, TimeUnit timeUnit) {
        int i = i.f3791b;
        long nanos = timeUnit.toNanos(j2);
        long nanos2 = TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
        long nanos3 = timeUnit.toNanos(j) + nanos2;
        a aVar = new a();
        a aVar2 = new a(aVar);
        aVar.a(b(new h(nanos2, nanos3, action0, aVar2, null, this, nanos), j, timeUnit));
        return aVar2;
    }
}
