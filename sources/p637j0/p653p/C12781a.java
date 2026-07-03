package p637j0.p653p;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import p637j0.p642l.p645c.C12696a;
import p637j0.p642l.p645c.C12697b;
import p637j0.p642l.p645c.C12701f;
import p637j0.p642l.p645c.InterfaceC12706k;
import p637j0.p642l.p647e.ThreadFactoryC12720j;
import p637j0.p652o.C12777o;
import p658rx.Scheduler;

/* JADX INFO: renamed from: j0.p.a */
/* JADX INFO: compiled from: Schedulers.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12781a {

    /* JADX INFO: renamed from: a */
    public static final AtomicReference<C12781a> f27393a = new AtomicReference<>();

    /* JADX INFO: renamed from: b */
    public final Scheduler f27394b;

    /* JADX INFO: renamed from: c */
    public final Scheduler f27395c;

    /* JADX INFO: renamed from: d */
    public final Scheduler f27396d;

    public C12781a() {
        Objects.requireNonNull(C12777o.f27384a.m10871e());
        this.f27394b = new C12697b(new ThreadFactoryC12720j("RxComputationScheduler-"));
        this.f27395c = new C12696a(new ThreadFactoryC12720j("RxIoScheduler-"));
        this.f27396d = new C12701f(new ThreadFactoryC12720j("RxNewThreadScheduler-"));
    }

    /* JADX INFO: renamed from: a */
    public static Scheduler m10873a() {
        return m10874b().f27394b;
    }

    /* JADX INFO: renamed from: b */
    public static C12781a m10874b() {
        while (true) {
            AtomicReference<C12781a> atomicReference = f27393a;
            C12781a c12781a = atomicReference.get();
            if (c12781a != null) {
                return c12781a;
            }
            C12781a c12781a2 = new C12781a();
            if (atomicReference.compareAndSet(null, c12781a2)) {
                return c12781a2;
            }
            synchronized (c12781a2) {
                Object obj = c12781a2.f27394b;
                if (obj instanceof InterfaceC12706k) {
                    ((InterfaceC12706k) obj).shutdown();
                }
                Object obj2 = c12781a2.f27395c;
                if (obj2 instanceof InterfaceC12706k) {
                    ((InterfaceC12706k) obj2).shutdown();
                }
                Object obj3 = c12781a2.f27396d;
                if (obj3 instanceof InterfaceC12706k) {
                    ((InterfaceC12706k) obj3).shutdown();
                }
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public static Scheduler m10875c() {
        return m10874b().f27395c;
    }
}
