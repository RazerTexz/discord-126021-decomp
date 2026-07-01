package j0.j.b;

import android.os.Looper;
import j0.j.a.RxAndroidPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import rx.Scheduler;

/* JADX INFO: renamed from: j0.j.b.a, reason: use source file name */
/* JADX INFO: compiled from: AndroidSchedulers.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AndroidSchedulers {
    public static final AtomicReference<AndroidSchedulers> a = new AtomicReference<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Scheduler f3770b;

    public AndroidSchedulers() {
        Objects.requireNonNull(RxAndroidPlugins.a.a());
        this.f3770b = new LooperScheduler(Looper.getMainLooper());
    }

    public static Scheduler a() {
        AtomicReference<AndroidSchedulers> atomicReference;
        AndroidSchedulers androidSchedulers;
        do {
            atomicReference = a;
            androidSchedulers = atomicReference.get();
            if (androidSchedulers != null) {
                break;
            }
            androidSchedulers = new AndroidSchedulers();
        } while (!atomicReference.compareAndSet(null, androidSchedulers));
        return androidSchedulers.f3770b;
    }
}
