package s.a;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: Await.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d<T> {
    public static final AtomicIntegerFieldUpdater a = AtomicIntegerFieldUpdater.newUpdater(d.class, "notCompletedCount");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f0<T>[] f3836b;
    public volatile int notCompletedCount;

    /* JADX WARN: Multi-variable type inference failed */
    public d(f0<? extends T>[] f0VarArr) {
        this.f3836b = f0VarArr;
        this.notCompletedCount = f0VarArr.length;
    }
}
