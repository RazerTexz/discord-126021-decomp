package p658rx;

import java.util.concurrent.TimeUnit;
import p637j0.p642l.p645c.C12703h;
import p637j0.p642l.p645c.C12704i;
import p637j0.p642l.p646d.C12709a;
import p658rx.functions.Action0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Scheduler {

    public static abstract class Worker implements Subscription {
        /* JADX INFO: renamed from: a */
        public abstract Subscription mo10740a(Action0 action0);

        /* JADX INFO: renamed from: b */
        public abstract Subscription mo10741b(Action0 action0, long j, TimeUnit timeUnit);

        /* JADX INFO: renamed from: c */
        public Subscription m11120c(Action0 action0, long j, long j2, TimeUnit timeUnit) {
            int i = C12704i.f27242b;
            long nanos = timeUnit.toNanos(j2);
            long nanos2 = TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
            long nanos3 = timeUnit.toNanos(j) + nanos2;
            C12709a c12709a = new C12709a();
            C12709a c12709a2 = new C12709a(c12709a);
            c12709a.m10809a(mo10741b(new C12703h(nanos2, nanos3, action0, c12709a2, null, this, nanos), j, timeUnit));
            return c12709a2;
        }
    }

    /* JADX INFO: renamed from: a */
    public abstract Worker mo10739a();
}
