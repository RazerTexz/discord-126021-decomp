package d0.e0.p.d.m0.m;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: locks.kt */
/* JADX INFO: loaded from: classes3.dex */
public class d implements l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lock f3512b;

    public d(Lock lock) {
        d0.z.d.m.checkNotNullParameter(lock, "lock");
        this.f3512b = lock;
    }

    @Override // d0.e0.p.d.m0.m.l
    public void lock() {
        this.f3512b.lock();
    }

    @Override // d0.e0.p.d.m0.m.l
    public void unlock() {
        this.f3512b.unlock();
    }

    public /* synthetic */ d(Lock lock, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ReentrantLock() : lock);
    }
}
