package s.a.a;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: s.a.a.m, reason: use source file name */
/* JADX INFO: compiled from: LockFreeTaskQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class LockFreeTaskQueue2<E> {
    public volatile Object _next = null;
    public volatile long _state = 0;
    public final int e;
    public AtomicReferenceArray f;
    public final int g;
    public final boolean h;
    public static final a d = new a(null);
    public static final Symbol3 c = new Symbol3("REMOVE_FROZEN");
    public static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueue2.class, Object.class, "_next");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f3829b = AtomicLongFieldUpdater.newUpdater(LockFreeTaskQueue2.class, "_state");

    /* JADX INFO: renamed from: s.a.a.m$a */
    /* JADX INFO: compiled from: LockFreeTaskQueue.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: s.a.a.m$b */
    /* JADX INFO: compiled from: LockFreeTaskQueue.kt */
    public static final class b {
        public final int a;

        public b(int i) {
            this.a = i;
        }
    }

    public LockFreeTaskQueue2(int i, boolean z2) {
        this.g = i;
        this.h = z2;
        int i2 = i - 1;
        this.e = i2;
        this.f = new AtomicReferenceArray(i);
        if (!(i2 <= 1073741823)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!((i & i2) == 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    public final int a(E e) {
        while (true) {
            long j = this._state;
            if ((3458764513820540928L & j) != 0) {
                return (2305843009213693952L & j) != 0 ? 2 : 1;
            }
            int i = (int) ((1073741823 & j) >> 0);
            int i2 = (int) ((1152921503533105152L & j) >> 30);
            int i3 = this.e;
            if (((i2 + 2) & i3) == (i & i3)) {
                return 1;
            }
            if (!this.h && this.f.get(i2 & i3) != null) {
                int i4 = this.g;
                if (i4 < 1024 || ((i2 - i) & 1073741823) > (i4 >> 1)) {
                    return 1;
                }
            } else if (f3829b.compareAndSet(this, j, ((-1152921503533105153L) & j) | (((long) ((i2 + 1) & 1073741823)) << 30))) {
                this.f.set(i2 & i3, e);
                LockFreeTaskQueue2<E> lockFreeTaskQueue2D = this;
                while ((lockFreeTaskQueue2D._state & 1152921504606846976L) != 0) {
                    lockFreeTaskQueue2D = lockFreeTaskQueue2D.d();
                    Object obj = lockFreeTaskQueue2D.f.get(lockFreeTaskQueue2D.e & i2);
                    if ((obj instanceof b) && ((b) obj).a == i2) {
                        lockFreeTaskQueue2D.f.set(lockFreeTaskQueue2D.e & i2, e);
                    } else {
                        lockFreeTaskQueue2D = null;
                    }
                    if (lockFreeTaskQueue2D == null) {
                        break;
                    }
                }
                return 0;
            }
        }
    }

    public final boolean b() {
        long j;
        do {
            j = this._state;
            if ((j & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j) != 0) {
                return false;
            }
        } while (!f3829b.compareAndSet(this, j, j | 2305843009213693952L));
        return true;
    }

    public final boolean c() {
        long j = this._state;
        return ((int) ((1073741823 & j) >> 0)) == ((int) ((j & 1152921503533105152L) >> 30));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final LockFreeTaskQueue2<E> d() {
        long j;
        while (true) {
            j = this._state;
            if ((j & 1152921504606846976L) != 0) {
                break;
            }
            long j2 = j | 1152921504606846976L;
            if (f3829b.compareAndSet(this, j, j2)) {
                j = j2;
                break;
            }
        }
        while (true) {
            LockFreeTaskQueue2<E> lockFreeTaskQueue2 = (LockFreeTaskQueue2) this._next;
            if (lockFreeTaskQueue2 != null) {
                return lockFreeTaskQueue2;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
            LockFreeTaskQueue2 lockFreeTaskQueue3 = new LockFreeTaskQueue2(this.g * 2, this.h);
            int i = (int) ((1073741823 & j) >> 0);
            int i2 = (int) ((1152921503533105152L & j) >> 30);
            while (true) {
                int i3 = this.e;
                int i4 = i & i3;
                if (i4 != (i3 & i2)) {
                    Object bVar = this.f.get(i4);
                    if (bVar == null) {
                        bVar = new b(i);
                    }
                    lockFreeTaskQueue3.f.set(lockFreeTaskQueue3.e & i, bVar);
                    i++;
                }
            }
            lockFreeTaskQueue3._state = (-1152921504606846977L) & j;
            atomicReferenceFieldUpdater.compareAndSet(this, null, lockFreeTaskQueue3);
        }
    }

    public final Object e() {
        while (true) {
            long j = this._state;
            if ((j & 1152921504606846976L) != 0) {
                return c;
            }
            int i = (int) ((j & 1073741823) >> 0);
            int i2 = this.e;
            int i3 = ((int) ((1152921503533105152L & j) >> 30)) & i2;
            int i4 = i2 & i;
            if (i3 == i4) {
                return null;
            }
            Object obj = this.f.get(i4);
            if (obj == null) {
                if (this.h) {
                    return null;
                }
            } else {
                if (obj instanceof b) {
                    return null;
                }
                long j2 = ((long) ((i + 1) & 1073741823)) << 0;
                if (f3829b.compareAndSet(this, j, (j & (-1073741824)) | j2)) {
                    this.f.set(this.e & i, null);
                    return obj;
                }
                if (this.h) {
                    LockFreeTaskQueue2<E> lockFreeTaskQueue2D = this;
                    while (true) {
                        long j3 = lockFreeTaskQueue2D._state;
                        int i5 = (int) ((j3 & 1073741823) >> 0);
                        if ((j3 & 1152921504606846976L) != 0) {
                            lockFreeTaskQueue2D = lockFreeTaskQueue2D.d();
                        } else {
                            if (f3829b.compareAndSet(lockFreeTaskQueue2D, j3, (j3 & (-1073741824)) | j2)) {
                                lockFreeTaskQueue2D.f.set(lockFreeTaskQueue2D.e & i5, null);
                                lockFreeTaskQueue2D = null;
                            } else {
                                continue;
                            }
                        }
                        if (lockFreeTaskQueue2D == null) {
                            return obj;
                        }
                    }
                }
            }
        }
    }
}
