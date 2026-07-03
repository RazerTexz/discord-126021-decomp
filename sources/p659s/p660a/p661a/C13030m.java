package p659s.p660a.p661a;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: s.a.a.m */
/* JADX INFO: compiled from: LockFreeTaskQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C13030m<E> {
    public volatile Object _next = null;
    public volatile long _state = 0;

    /* JADX INFO: renamed from: e */
    public final int f27694e;

    /* JADX INFO: renamed from: f */
    public AtomicReferenceArray f27695f;

    /* JADX INFO: renamed from: g */
    public final int f27696g;

    /* JADX INFO: renamed from: h */
    public final boolean f27697h;

    /* JADX INFO: renamed from: d */
    public static final a f27693d = new a(null);

    /* JADX INFO: renamed from: c */
    public static final C13037t f27692c = new C13037t("REMOVE_FROZEN");

    /* JADX INFO: renamed from: a */
    public static final AtomicReferenceFieldUpdater f27690a = AtomicReferenceFieldUpdater.newUpdater(C13030m.class, Object.class, "_next");

    /* JADX INFO: renamed from: b */
    public static final AtomicLongFieldUpdater f27691b = AtomicLongFieldUpdater.newUpdater(C13030m.class, "_state");

    /* JADX INFO: renamed from: s.a.a.m$a */
    /* JADX INFO: compiled from: LockFreeTaskQueue.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: s.a.a.m$b */
    /* JADX INFO: compiled from: LockFreeTaskQueue.kt */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public final int f27698a;

        public b(int i) {
            this.f27698a = i;
        }
    }

    public C13030m(int i, boolean z2) {
        this.f27696g = i;
        this.f27697h = z2;
        int i2 = i - 1;
        this.f27694e = i2;
        this.f27695f = new AtomicReferenceArray(i);
        if (!(i2 <= 1073741823)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!((i & i2) == 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    /* JADX INFO: renamed from: a */
    public final int m11165a(E e) {
        while (true) {
            long j = this._state;
            if ((3458764513820540928L & j) != 0) {
                return (2305843009213693952L & j) != 0 ? 2 : 1;
            }
            int i = (int) ((1073741823 & j) >> 0);
            int i2 = (int) ((1152921503533105152L & j) >> 30);
            int i3 = this.f27694e;
            if (((i2 + 2) & i3) == (i & i3)) {
                return 1;
            }
            if (!this.f27697h && this.f27695f.get(i2 & i3) != null) {
                int i4 = this.f27696g;
                if (i4 < 1024 || ((i2 - i) & 1073741823) > (i4 >> 1)) {
                    return 1;
                }
            } else if (f27691b.compareAndSet(this, j, ((-1152921503533105153L) & j) | (((long) ((i2 + 1) & 1073741823)) << 30))) {
                this.f27695f.set(i2 & i3, e);
                C13030m<E> c13030mM11168d = this;
                while ((c13030mM11168d._state & 1152921504606846976L) != 0) {
                    c13030mM11168d = c13030mM11168d.m11168d();
                    Object obj = c13030mM11168d.f27695f.get(c13030mM11168d.f27694e & i2);
                    if ((obj instanceof b) && ((b) obj).f27698a == i2) {
                        c13030mM11168d.f27695f.set(c13030mM11168d.f27694e & i2, e);
                    } else {
                        c13030mM11168d = null;
                    }
                    if (c13030mM11168d == null) {
                        break;
                    }
                }
                return 0;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public final boolean m11166b() {
        long j;
        do {
            j = this._state;
            if ((j & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j) != 0) {
                return false;
            }
        } while (!f27691b.compareAndSet(this, j, j | 2305843009213693952L));
        return true;
    }

    /* JADX INFO: renamed from: c */
    public final boolean m11167c() {
        long j = this._state;
        return ((int) ((1073741823 & j) >> 0)) == ((int) ((j & 1152921503533105152L) >> 30));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: d */
    public final C13030m<E> m11168d() {
        long j;
        while (true) {
            j = this._state;
            if ((j & 1152921504606846976L) != 0) {
                break;
            }
            long j2 = j | 1152921504606846976L;
            if (f27691b.compareAndSet(this, j, j2)) {
                j = j2;
                break;
            }
        }
        while (true) {
            C13030m<E> c13030m = (C13030m) this._next;
            if (c13030m != null) {
                return c13030m;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f27690a;
            C13030m c13030m2 = new C13030m(this.f27696g * 2, this.f27697h);
            int i = (int) ((1073741823 & j) >> 0);
            int i2 = (int) ((1152921503533105152L & j) >> 30);
            while (true) {
                int i3 = this.f27694e;
                int i4 = i & i3;
                if (i4 != (i3 & i2)) {
                    Object bVar = this.f27695f.get(i4);
                    if (bVar == null) {
                        bVar = new b(i);
                    }
                    c13030m2.f27695f.set(c13030m2.f27694e & i, bVar);
                    i++;
                }
            }
            c13030m2._state = (-1152921504606846977L) & j;
            atomicReferenceFieldUpdater.compareAndSet(this, null, c13030m2);
        }
    }

    /* JADX INFO: renamed from: e */
    public final Object m11169e() {
        while (true) {
            long j = this._state;
            if ((j & 1152921504606846976L) != 0) {
                return f27692c;
            }
            int i = (int) ((j & 1073741823) >> 0);
            int i2 = this.f27694e;
            int i3 = ((int) ((1152921503533105152L & j) >> 30)) & i2;
            int i4 = i2 & i;
            if (i3 == i4) {
                return null;
            }
            Object obj = this.f27695f.get(i4);
            if (obj == null) {
                if (this.f27697h) {
                    return null;
                }
            } else {
                if (obj instanceof b) {
                    return null;
                }
                long j2 = ((long) ((i + 1) & 1073741823)) << 0;
                if (f27691b.compareAndSet(this, j, (j & (-1073741824)) | j2)) {
                    this.f27695f.set(this.f27694e & i, null);
                    return obj;
                }
                if (this.f27697h) {
                    C13030m<E> c13030mM11168d = this;
                    while (true) {
                        long j3 = c13030mM11168d._state;
                        int i5 = (int) ((j3 & 1073741823) >> 0);
                        if ((j3 & 1152921504606846976L) != 0) {
                            c13030mM11168d = c13030mM11168d.m11168d();
                        } else {
                            if (f27691b.compareAndSet(c13030mM11168d, j3, (j3 & (-1073741824)) | j2)) {
                                c13030mM11168d.f27695f.set(c13030mM11168d.f27694e & i5, null);
                                c13030mM11168d = null;
                            } else {
                                continue;
                            }
                        }
                        if (c13030mM11168d == null) {
                            return obj;
                        }
                    }
                }
            }
        }
    }
}
