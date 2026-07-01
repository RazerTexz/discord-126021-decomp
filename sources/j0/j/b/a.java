package j0.j.b;

import android.os.Looper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import rx.Scheduler;

/* JADX INFO: compiled from: AndroidSchedulers.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static final AtomicReference<a> a = new AtomicReference<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Scheduler f3770b;

    public a() {
        Objects.requireNonNull(j0.j.a.a.a.a());
        this.f3770b = new b(Looper.getMainLooper());
    }

    public static Scheduler a() {
        AtomicReference<a> atomicReference;
        a aVar;
        do {
            atomicReference = a;
            aVar = atomicReference.get();
            if (aVar != null) {
                break;
            }
            aVar = new a();
        } while (!atomicReference.compareAndSet(null, aVar));
        return aVar.f3770b;
    }
}
