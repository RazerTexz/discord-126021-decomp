package com.facebook.imagepipeline.memory;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.annotation.VisibleForTesting;
import b.c.a.a0.d;
import b.f.d.d.m;
import b.f.d.e.a;
import b.f.d.g.c;
import b.f.d.g.e;
import b.f.j.l.f;
import b.f.j.l.y;
import b.f.j.l.z;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BasePool<V> implements e<V> {
    public final Class<?> a = getClass();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f2896b;
    public final y c;

    @VisibleForTesting
    public final SparseArray<f<V>> d;

    @VisibleForTesting
    public final Set<V> e;
    public boolean f;

    @VisibleForTesting
    public final BasePool$a g;

    @VisibleForTesting
    public final BasePool$a h;
    public final z i;
    public boolean j;

    public BasePool(c cVar, y yVar, z zVar) {
        Objects.requireNonNull(cVar);
        this.f2896b = cVar;
        Objects.requireNonNull(yVar);
        this.c = yVar;
        Objects.requireNonNull(zVar);
        this.i = zVar;
        SparseArray<f<V>> sparseArray = new SparseArray<>();
        this.d = sparseArray;
        SparseIntArray sparseIntArray = new SparseIntArray(0);
        synchronized (this) {
            sparseArray.clear();
            SparseIntArray sparseIntArray2 = yVar.c;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int iKeyAt = sparseIntArray2.keyAt(i);
                    int iValueAt = sparseIntArray2.valueAt(i);
                    int i2 = sparseIntArray.get(iKeyAt, 0);
                    SparseArray<f<V>> sparseArray2 = this.d;
                    int iK = k(iKeyAt);
                    Objects.requireNonNull(this.c);
                    sparseArray2.put(iKeyAt, new f<>(iK, iValueAt, i2, false));
                }
                this.f = false;
            } else {
                this.f = true;
            }
        }
        this.e = Collections.newSetFromMap(new IdentityHashMap());
        this.h = new BasePool$a();
        this.g = new BasePool$a();
    }

    public abstract V e(int i);

    @VisibleForTesting
    public synchronized boolean f(int i) {
        if (this.j) {
            return true;
        }
        y yVar = this.c;
        int i2 = yVar.a;
        int i3 = this.g.f2897b;
        if (i > i2 - i3) {
            this.i.f();
            return false;
        }
        int i4 = yVar.f602b;
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

    @Override // b.f.d.g.e
    public V get(int i) throws Throwable {
        V vL;
        synchronized (this) {
            d.B(!n() || this.h.f2897b == 0);
        }
        int i2 = i(i);
        synchronized (this) {
            f<V> fVarH = h(i2);
            if (fVarH != null && (vL = l(fVarH)) != null) {
                d.B(this.e.add(vL));
                int iK = k(j(vL));
                this.g.b(iK);
                this.h.a(iK);
                this.i.b(iK);
                p();
                if (a.h(2)) {
                    System.identityHashCode(vL);
                }
                return vL;
            }
            int iK2 = k(i2);
            if (!f(iK2)) {
                throw new BasePool$PoolSizeViolationException(this.c.a, this.g.f2897b, this.h.f2897b, iK2);
            }
            this.g.b(iK2);
            if (fVarH != null) {
                fVarH.e++;
            }
            V vE = null;
            try {
                vE = e(i2);
            } catch (Throwable th) {
                synchronized (this) {
                    this.g.a(iK2);
                    f<V> fVarH2 = h(i2);
                    if (fVarH2 != null) {
                        fVarH2.b();
                    }
                    m.a(th);
                }
            }
            synchronized (this) {
                d.B(this.e.add(vE));
                synchronized (this) {
                    if (n()) {
                        r(this.c.f602b);
                    }
                }
                return vE;
            }
            this.i.a(iK2);
            p();
            if (a.h(2)) {
                System.identityHashCode(vE);
            }
            return vE;
        }
    }

    @VisibleForTesting
    public synchronized f<V> h(int i) {
        f<V> fVar = this.d.get(i);
        if (fVar == null && this.f) {
            a.h(2);
            f<V> fVarQ = q(i);
            this.d.put(i, fVarQ);
            return fVarQ;
        }
        return fVar;
    }

    public abstract int i(int i);

    public abstract int j(V v);

    public abstract int k(int i);

    public synchronized V l(f<V> fVar) {
        V vC;
        vC = fVar.c();
        if (vC != null) {
            fVar.e++;
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
        if (a.h(2)) {
            BasePool$a basePool$a = this.g;
            int i = basePool$a.a;
            int i2 = basePool$a.f2897b;
            BasePool$a basePool$a2 = this.h;
            int i3 = basePool$a2.a;
            int i4 = basePool$a2.f2897b;
        }
    }

    public f<V> q(int i) {
        int iK = k(i);
        Objects.requireNonNull(this.c);
        return new f<>(iK, Integer.MAX_VALUE, 0, false);
    }

    @VisibleForTesting
    public synchronized void r(int i) {
        int i2 = this.g.f2897b;
        int i3 = this.h.f2897b;
        int iMin = Math.min((i2 + i3) - i, i3);
        if (iMin <= 0) {
            return;
        }
        if (a.h(2)) {
            a.j(this.a, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.g.f2897b + this.h.f2897b), Integer.valueOf(iMin));
        }
        p();
        for (int i4 = 0; i4 < this.d.size() && iMin > 0; i4++) {
            f<V> fVarValueAt = this.d.valueAt(i4);
            Objects.requireNonNull(fVarValueAt);
            f<V> fVar = fVarValueAt;
            while (iMin > 0) {
                V vC = fVar.c();
                if (vC == null) {
                    break;
                }
                g(vC);
                int i5 = fVar.a;
                iMin -= i5;
                this.h.a(i5);
            }
        }
        p();
        if (a.h(2)) {
            int i6 = this.g.f2897b;
            int i7 = this.h.f2897b;
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x007f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x0081 A[Catch: all -> 0x009f, TryCatch #1 {all -> 0x009f, blocks: (B:4:0x000c, B:6:0x0015, B:7:0x0016, B:9:0x0021, B:30:0x009a, B:31:0x009d, B:11:0x0045, B:16:0x0056, B:18:0x005c, B:21:0x0063, B:23:0x007b, B:25:0x0081, B:26:0x0084, B:28:0x008a, B:29:0x008d, B:36:0x00a2, B:37:0x00a3, B:5:0x000d), top: B:42:0x000c, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x008a A[Catch: all -> 0x009f, TryCatch #1 {all -> 0x009f, blocks: (B:4:0x000c, B:6:0x0015, B:7:0x0016, B:9:0x0021, B:30:0x009a, B:31:0x009d, B:11:0x0045, B:16:0x0056, B:18:0x005c, B:21:0x0063, B:23:0x007b, B:25:0x0081, B:26:0x0084, B:28:0x008a, B:29:0x008d, B:36:0x00a2, B:37:0x00a3, B:5:0x000d), top: B:42:0x000c, inners: #0 }] */
    @Override // b.f.d.g.e, b.f.d.h.f
    public void release(V v) {
        f<V> fVar;
        Objects.requireNonNull(v);
        int iJ = j(v);
        int iK = k(iJ);
        synchronized (this) {
            try {
                synchronized (this) {
                    fVar = this.d.get(iJ);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        boolean z2 = true;
        if (!this.e.remove(v)) {
            a.c(this.a, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(iJ));
            g(v);
            this.i.e(iK);
        } else if (fVar == null) {
            if (fVar != null) {
                fVar.b();
            }
            if (a.h(2)) {
                System.identityHashCode(v);
            }
            g(v);
            this.g.a(iK);
            this.i.e(iK);
        } else {
            if (fVar.e + fVar.c.size() <= fVar.f594b) {
                z2 = false;
            }
            if (z2 || n() || !o(v)) {
                if (fVar != null) {
                    fVar.b();
                }
                if (a.h(2)) {
                    System.identityHashCode(v);
                }
                g(v);
                this.g.a(iK);
                this.i.e(iK);
            } else {
                fVar.d(v);
                this.h.b(iK);
                this.g.a(iK);
                this.i.g(iK);
                if (a.h(2)) {
                    System.identityHashCode(v);
                }
            }
        }
        p();
    }
}
