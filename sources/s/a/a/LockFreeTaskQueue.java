package s.a.a;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: renamed from: s.a.a.l, reason: use source file name */
/* JADX INFO: compiled from: LockFreeTaskQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
public class LockFreeTaskQueue<E> {
    public static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueue.class, Object.class, "_cur");
    public volatile Object _cur;

    public LockFreeTaskQueue(boolean z2) {
        this._cur = new LockFreeTaskQueue2(8, z2);
    }

    public final boolean a(E e) {
        while (true) {
            LockFreeTaskQueue2 lockFreeTaskQueue2 = (LockFreeTaskQueue2) this._cur;
            int iA = lockFreeTaskQueue2.a(e);
            if (iA == 0) {
                return true;
            }
            if (iA == 1) {
                a.compareAndSet(this, lockFreeTaskQueue2, lockFreeTaskQueue2.d());
            } else if (iA == 2) {
                return false;
            }
        }
    }

    public final void b() {
        while (true) {
            LockFreeTaskQueue2 lockFreeTaskQueue2 = (LockFreeTaskQueue2) this._cur;
            if (lockFreeTaskQueue2.b()) {
                return;
            } else {
                a.compareAndSet(this, lockFreeTaskQueue2, lockFreeTaskQueue2.d());
            }
        }
    }

    public final int c() {
        long j = ((LockFreeTaskQueue2) this._cur)._state;
        return 1073741823 & (((int) ((j & 1152921503533105152L) >> 30)) - ((int) ((1073741823 & j) >> 0)));
    }

    public final E d() {
        while (true) {
            LockFreeTaskQueue2 lockFreeTaskQueue2 = (LockFreeTaskQueue2) this._cur;
            E e = (E) lockFreeTaskQueue2.e();
            if (e != LockFreeTaskQueue2.c) {
                return e;
            }
            a.compareAndSet(this, lockFreeTaskQueue2, lockFreeTaskQueue2.d());
        }
    }
}
