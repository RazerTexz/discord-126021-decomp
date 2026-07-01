package com.facebook.imagepipeline.memory;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.annotation.VisibleForTesting;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.f.d.d.Throwables;
import b.f.d.e.FLog;
import b.f.d.g.MemoryTrimmableRegistry;
import b.f.d.g.Pool2;
import b.f.j.l.Bucket2;
import b.f.j.l.PoolParams;
import b.f.j.l.PoolStatsTracker;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BasePool<V> implements Pool2<V> {
    public final Class<?> a = getClass();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MemoryTrimmableRegistry f2896b;
    public final PoolParams c;

    @VisibleForTesting
    public final SparseArray<Bucket2<V>> d;

    @VisibleForTesting
    public final Set<V> e;
    public boolean f;

    @VisibleForTesting
    public final a g;

    @VisibleForTesting
    public final a h;
    public final PoolStatsTracker i;
    public boolean j;

    public static class InvalidSizeException extends RuntimeException {
        /* JADX WARN: Illegal instructions before constructor call */
        public InvalidSizeException(Object obj) {
            StringBuilder sbU = outline.U("Invalid size: ");
            sbU.append(obj.toString());
            super(sbU.toString());
        }
    }

    public static class InvalidValueException extends RuntimeException {
    }

    public static class PoolSizeViolationException extends RuntimeException {
        /* JADX WARN: Illegal instructions before constructor call */
        public PoolSizeViolationException(int i, int i2, int i3, int i4) {
            StringBuilder sbW = outline.W("Pool hard cap violation? Hard cap = ", i, " Used size = ", i2, " Free size = ");
            sbW.append(i3);
            sbW.append(" Request size = ");
            sbW.append(i4);
            super(sbW.toString());
        }
    }

    public static class SizeTooLargeException extends InvalidSizeException {
    }

    @VisibleForTesting
    public static class a {
        public int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2897b;

        public void a(int i) {
            int i2;
            int i3 = this.f2897b;
            if (i3 < i || (i2 = this.a) <= 0) {
                FLog.p("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.f2897b), Integer.valueOf(this.a));
            } else {
                this.a = i2 - 1;
                this.f2897b = i3 - i;
            }
        }

        public void b(int i) {
            this.a++;
            this.f2897b += i;
        }
    }

    public BasePool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
        Objects.requireNonNull(memoryTrimmableRegistry);
        this.f2896b = memoryTrimmableRegistry;
        Objects.requireNonNull(poolParams);
        this.c = poolParams;
        Objects.requireNonNull(poolStatsTracker);
        this.i = poolStatsTracker;
        SparseArray<Bucket2<V>> sparseArray = new SparseArray<>();
        this.d = sparseArray;
        SparseIntArray sparseIntArray = new SparseIntArray(0);
        synchronized (this) {
            sparseArray.clear();
            SparseIntArray sparseIntArray2 = poolParams.c;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int iKeyAt = sparseIntArray2.keyAt(i);
                    int iValueAt = sparseIntArray2.valueAt(i);
                    int i2 = sparseIntArray.get(iKeyAt, 0);
                    SparseArray<Bucket2<V>> sparseArray2 = this.d;
                    int iK = k(iKeyAt);
                    Objects.requireNonNull(this.c);
                    sparseArray2.put(iKeyAt, new Bucket2<>(iK, iValueAt, i2, false));
                }
                this.f = false;
            } else {
                this.f = true;
            }
        }
        this.e = Collections.newSetFromMap(new IdentityHashMap());
        this.h = new a();
        this.g = new a();
    }

    public abstract V e(int i);

    @VisibleForTesting
    public synchronized boolean f(int i) {
        if (this.j) {
            return true;
        }
        PoolParams poolParams = this.c;
        int i2 = poolParams.a;
        int i3 = this.g.f2897b;
        if (i > i2 - i3) {
            this.i.f();
            return false;
        }
        int i4 = poolParams.f602b;
        if (i > i4 - (i3 + this.h.f2897b)) {
            r(i4 - i);
        }
        if (i <= i2 - (this.g.f2897b + this.h.f2897b)) {
            return true;
        }
        this.i.f();
        return false;
    }

    @VisibleForTesting
    public abstract void g(V v);

    @Override // b.f.d.g.Pool2
    public V get(int i) throws Throwable {
        V vL;
        synchronized (this) {
            AnimatableValueParser.B(!n() || this.h.f2897b == 0);
        }
        int i2 = i(i);
        synchronized (this) {
            Bucket2<V> bucket2H = h(i2);
            if (bucket2H != null && (vL = l(bucket2H)) != null) {
                AnimatableValueParser.B(this.e.add(vL));
                int iK = k(j(vL));
                this.g.b(iK);
                this.h.a(iK);
                this.i.b(iK);
                p();
                if (FLog.h(2)) {
                    System.identityHashCode(vL);
                }
                return vL;
            }
            int iK2 = k(i2);
            if (!f(iK2)) {
                throw new PoolSizeViolationException(this.c.a, this.g.f2897b, this.h.f2897b, iK2);
            }
            this.g.b(iK2);
            if (bucket2H != null) {
                bucket2H.e++;
            }
            V vE = null;
            try {
                vE = e(i2);
            } catch (Throwable th) {
                synchronized (this) {
                    this.g.a(iK2);
                    Bucket2<V> bucket2H2 = h(i2);
                    if (bucket2H2 != null) {
                        bucket2H2.b();
                    }
                    Throwables.a(th);
                }
            }
            synchronized (this) {
                AnimatableValueParser.B(this.e.add(vE));
                synchronized (this) {
                    if (n()) {
                        r(this.c.f602b);
                    }
                }
                return vE;
            }
            this.i.a(iK2);
            p();
            if (FLog.h(2)) {
                System.identityHashCode(vE);
            }
            return vE;
        }
    }

    @VisibleForTesting
    public synchronized Bucket2<V> h(int i) {
        Bucket2<V> bucket2 = this.d.get(i);
        if (bucket2 == null && this.f) {
            FLog.h(2);
            Bucket2<V> bucket2Q = q(i);
            this.d.put(i, bucket2Q);
            return bucket2Q;
        }
        return bucket2;
    }

    public abstract int i(int i);

    public abstract int j(V v);

    public abstract int k(int i);

    public synchronized V l(Bucket2<V> bucket2) {
        V vC;
        vC = bucket2.c();
        if (vC != null) {
            bucket2.e++;
        }
        return vC;
    }

    public void m() {
        this.f2896b.a(this);
        this.i.c(this);
    }

    @VisibleForTesting
    public synchronized boolean n() {
        boolean z2;
        z2 = this.g.f2897b + this.h.f2897b > this.c.f602b;
        if (z2) {
            this.i.d();
        }
        return z2;
    }

    public boolean o(V v) {
        return true;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    public final void p() {
        if (FLog.h(2)) {
            a aVar = this.g;
            int i = aVar.a;
            int i2 = aVar.f2897b;
            a aVar2 = this.h;
            int i3 = aVar2.a;
            int i4 = aVar2.f2897b;
        }
    }

    public Bucket2<V> q(int i) {
        int iK = k(i);
        Objects.requireNonNull(this.c);
        return new Bucket2<>(iK, Integer.MAX_VALUE, 0, false);
    }

    @VisibleForTesting
    public synchronized void r(int i) {
        int i2 = this.g.f2897b;
        int i3 = this.h.f2897b;
        int iMin = Math.min((i2 + i3) - i, i3);
        if (iMin <= 0) {
            return;
        }
        if (FLog.h(2)) {
            FLog.j(this.a, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.g.f2897b + this.h.f2897b), Integer.valueOf(iMin));
        }
        p();
        for (int i4 = 0; i4 < this.d.size() && iMin > 0; i4++) {
            Bucket2<V> bucket2ValueAt = this.d.valueAt(i4);
            Objects.requireNonNull(bucket2ValueAt);
            Bucket2<V> bucket2 = bucket2ValueAt;
            while (iMin > 0) {
                V vC = bucket2.c();
                if (vC == null) {
                    break;
                }
                g(vC);
                int i5 = bucket2.a;
                iMin -= i5;
                this.h.a(i5);
            }
        }
        p();
        if (FLog.h(2)) {
            int i6 = this.g.f2897b;
            int i7 = this.h.f2897b;
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x007f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x0081 A[Catch: all -> 0x009f, TryCatch #1 {all -> 0x009f, blocks: (B:4:0x000c, B:6:0x0015, B:7:0x0016, B:9:0x0021, B:30:0x009a, B:31:0x009d, B:11:0x0045, B:16:0x0056, B:18:0x005c, B:21:0x0063, B:23:0x007b, B:25:0x0081, B:26:0x0084, B:28:0x008a, B:29:0x008d, B:36:0x00a2, B:37:0x00a3, B:5:0x000d), top: B:42:0x000c, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x008a A[Catch: all -> 0x009f, TryCatch #1 {all -> 0x009f, blocks: (B:4:0x000c, B:6:0x0015, B:7:0x0016, B:9:0x0021, B:30:0x009a, B:31:0x009d, B:11:0x0045, B:16:0x0056, B:18:0x005c, B:21:0x0063, B:23:0x007b, B:25:0x0081, B:26:0x0084, B:28:0x008a, B:29:0x008d, B:36:0x00a2, B:37:0x00a3, B:5:0x000d), top: B:42:0x000c, inners: #0 }] */
    @Override // b.f.d.g.Pool2, b.f.d.h.ResourceReleaser
    public void release(V v) {
        Bucket2<V> bucket2;
        Objects.requireNonNull(v);
        int iJ = j(v);
        int iK = k(iJ);
        synchronized (this) {
            try {
                synchronized (this) {
                    bucket2 = this.d.get(iJ);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        boolean z2 = true;
        if (!this.e.remove(v)) {
            FLog.c(this.a, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(iJ));
            g(v);
            this.i.e(iK);
        } else if (bucket2 == null) {
            if (bucket2 != null) {
                bucket2.b();
            }
            if (FLog.h(2)) {
                System.identityHashCode(v);
            }
            g(v);
            this.g.a(iK);
            this.i.e(iK);
        } else {
            if (bucket2.e + bucket2.c.size() <= bucket2.f594b) {
                z2 = false;
            }
            if (z2 || n() || !o(v)) {
                if (bucket2 != null) {
                    bucket2.b();
                }
                if (FLog.h(2)) {
                    System.identityHashCode(v);
                }
                g(v);
                this.g.a(iK);
                this.i.e(iK);
            } else {
                bucket2.d(v);
                this.h.b(iK);
                this.g.a(iK);
                this.i.g(iK);
                if (FLog.h(2)) {
                    System.identityHashCode(v);
                }
            }
        }
        p();
    }
}
