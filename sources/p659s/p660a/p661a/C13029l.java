package p659s.p660a.p661a;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: renamed from: s.a.a.l */
/* JADX INFO: compiled from: LockFreeTaskQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C13029l<E> {

    /* JADX INFO: renamed from: a */
    public static final AtomicReferenceFieldUpdater f27689a = AtomicReferenceFieldUpdater.newUpdater(C13029l.class, Object.class, "_cur");
    public volatile Object _cur;

    public C13029l(boolean z2) {
        this._cur = new C13030m(8, z2);
    }

    /* JADX INFO: renamed from: a */
    public final boolean m11161a(E e) {
        while (true) {
            C13030m c13030m = (C13030m) this._cur;
            int iM11165a = c13030m.m11165a(e);
            if (iM11165a == 0) {
                return true;
            }
            if (iM11165a == 1) {
                f27689a.compareAndSet(this, c13030m, c13030m.m11168d());
            } else if (iM11165a == 2) {
                return false;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m11162b() {
        while (true) {
            C13030m c13030m = (C13030m) this._cur;
            if (c13030m.m11166b()) {
                return;
            } else {
                f27689a.compareAndSet(this, c13030m, c13030m.m11168d());
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public final int m11163c() {
        long j = ((C13030m) this._cur)._state;
        return 1073741823 & (((int) ((j & 1152921503533105152L) >> 30)) - ((int) ((1073741823 & j) >> 0)));
    }

    /* JADX INFO: renamed from: d */
    public final E m11164d() {
        while (true) {
            C13030m c13030m = (C13030m) this._cur;
            E e = (E) c13030m.m11169e();
            if (e != C13030m.f27692c) {
                return e;
            }
            f27689a.compareAndSet(this, c13030m, c13030m.m11168d());
        }
    }
}
