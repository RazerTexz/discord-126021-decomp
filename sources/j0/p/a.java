package j0.p;

import j0.l.c.b;
import j0.l.c.f;
import j0.l.c.k;
import j0.l.e.j;
import j0.o.o;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import rx.Scheduler;

/* JADX INFO: compiled from: Schedulers.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static final AtomicReference<a> a = new AtomicReference<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Scheduler f3803b;
    public final Scheduler c;
    public final Scheduler d;

    public a() {
        Objects.requireNonNull(o.a.e());
        this.f3803b = new b(new j("RxComputationScheduler-"));
        this.c = new j0.l.c.a(new j("RxIoScheduler-"));
        this.d = new f(new j("RxNewThreadScheduler-"));
    }

    public static Scheduler a() {
        return b().f3803b;
    }

    public static a b() {
        while (true) {
            AtomicReference<a> atomicReference = a;
            a aVar = atomicReference.get();
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            if (atomicReference.compareAndSet(null, aVar2)) {
                return aVar2;
            }
            synchronized (aVar2) {
                Object obj = aVar2.f3803b;
                if (obj instanceof k) {
                    ((k) obj).shutdown();
                }
                Object obj2 = aVar2.c;
                if (obj2 instanceof k) {
                    ((k) obj2).shutdown();
                }
                Object obj3 = aVar2.d;
                if (obj3 instanceof k) {
                    ((k) obj3).shutdown();
                }
            }
        }
    }

    public static Scheduler c() {
        return b().c;
    }
}
