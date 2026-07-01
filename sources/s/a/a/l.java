package s.a.a;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: LockFreeTaskQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
public class l<E> {
    public static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "_cur");
    public volatile Object _cur;

    public l(boolean z2) {
        this._cur = new m(8, z2);
    }

    public final boolean a(E e) {
        while (true) {
            m mVar = (m) this._cur;
            int iA = mVar.a(e);
            if (iA == 0) {
                return true;
            }
            if (iA == 1) {
                a.compareAndSet(this, mVar, mVar.d());
            } else if (iA == 2) {
                return false;
            }
        }
    }

    public final void b() {
        while (true) {
            m mVar = (m) this._cur;
            if (mVar.b()) {
                return;
            } else {
                a.compareAndSet(this, mVar, mVar.d());
            }
        }
    }

    public final int c() {
        long j = ((m) this._cur)._state;
        return 1073741823 & (((int) ((j & 1152921503533105152L) >> 30)) - ((int) ((1073741823 & j) >> 0)));
    }

    public final E d() {
        while (true) {
            m mVar = (m) this._cur;
            E e = (E) mVar.e();
            if (e != m.c) {
                return e;
            }
            a.compareAndSet(this, mVar, mVar.d());
        }
    }
}
