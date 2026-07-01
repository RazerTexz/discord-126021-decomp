package j0.j.a;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: RxAndroidPlugins.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static final a a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<b> f3769b = new AtomicReference<>();

    public b a() {
        if (this.f3769b.get() == null) {
            this.f3769b.compareAndSet(null, b.a);
        }
        return this.f3769b.get();
    }
}
