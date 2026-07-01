package d0.e0.p.d.m0.m;

import d0.z.d.Intrinsics3;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.m.d, reason: use source file name */
/* JADX INFO: compiled from: locks.kt */
/* JADX INFO: loaded from: classes3.dex */
public class locks2 implements locks4 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lock f3512b;

    public locks2(Lock lock) {
        Intrinsics3.checkNotNullParameter(lock, "lock");
        this.f3512b = lock;
    }

    @Override // d0.e0.p.d.m0.m.locks4
    public void lock() {
        this.f3512b.lock();
    }

    @Override // d0.e0.p.d.m0.m.locks4
    public void unlock() {
        this.f3512b.unlock();
    }

    public /* synthetic */ locks2(Lock lock, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ReentrantLock() : lock);
    }
}
