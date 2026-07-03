package p637j0.p638j.p640b;

import android.os.Looper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import p637j0.p638j.p639a.C12584a;
import p658rx.Scheduler;

/* JADX INFO: renamed from: j0.j.b.a */
/* JADX INFO: compiled from: AndroidSchedulers.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12586a {

    /* JADX INFO: renamed from: a */
    public static final AtomicReference<C12586a> f26701a = new AtomicReference<>();

    /* JADX INFO: renamed from: b */
    public final Scheduler f26702b;

    public C12586a() {
        Objects.requireNonNull(C12584a.f26698a.m10737a());
        this.f26702b = new C12587b(Looper.getMainLooper());
    }

    /* JADX INFO: renamed from: a */
    public static Scheduler m10738a() {
        AtomicReference<C12586a> atomicReference;
        C12586a c12586a;
        do {
            atomicReference = f26701a;
            c12586a = atomicReference.get();
            if (c12586a != null) {
                break;
            }
            c12586a = new C12586a();
        } while (!atomicReference.compareAndSet(null, c12586a));
        return c12586a.f26702b;
    }
}
