package j0.j.a;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: j0.j.a.a, reason: use source file name */
/* JADX INFO: compiled from: RxAndroidPlugins.java */
/* JADX INFO: loaded from: classes3.dex */
public final class RxAndroidPlugins {
    public static final RxAndroidPlugins a = new RxAndroidPlugins();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<RxAndroidSchedulersHook> f3769b = new AtomicReference<>();

    public RxAndroidSchedulersHook a() {
        if (this.f3769b.get() == null) {
            this.f3769b.compareAndSet(null, RxAndroidSchedulersHook.a);
        }
        return this.f3769b.get();
    }
}
