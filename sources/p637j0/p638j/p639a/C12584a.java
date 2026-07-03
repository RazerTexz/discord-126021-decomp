package p637j0.p638j.p639a;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: j0.j.a.a */
/* JADX INFO: compiled from: RxAndroidPlugins.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12584a {

    /* JADX INFO: renamed from: a */
    public static final C12584a f26698a = new C12584a();

    /* JADX INFO: renamed from: b */
    public final AtomicReference<C12585b> f26699b = new AtomicReference<>();

    /* JADX INFO: renamed from: a */
    public C12585b m10737a() {
        if (this.f26699b.get() == null) {
            this.f26699b.compareAndSet(null, C12585b.f26700a);
        }
        return this.f26699b.get();
    }
}
