package p507d0.p513e0.p514p.p515d.p517m0.p566m;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.m.d */
/* JADX INFO: compiled from: locks.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C11894d implements InterfaceC11902l {

    /* JADX INFO: renamed from: b */
    public final Lock f24707b;

    public C11894d(Lock lock) {
        C12238m.checkNotNullParameter(lock, "lock");
        this.f24707b = lock;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11902l
    public void lock() {
        this.f24707b.lock();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11902l
    public void unlock() {
        this.f24707b.unlock();
    }

    public /* synthetic */ C11894d(Lock lock, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ReentrantLock() : lock);
    }
}
