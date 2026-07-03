package com.facebook.imagepipeline.memory;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.annotation.VisibleForTesting;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Objects;
import java.util.Set;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p109f.p115d.p119d.C1690m;
import p007b.p109f.p115d.p120e.C1691a;
import p007b.p109f.p115d.p122g.InterfaceC1696c;
import p007b.p109f.p115d.p122g.InterfaceC1698e;
import p007b.p109f.p161j.p177l.C1934f;
import p007b.p109f.p161j.p177l.C1953y;
import p007b.p109f.p161j.p177l.InterfaceC1954z;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BasePool<V> implements InterfaceC1698e<V> {

    /* JADX INFO: renamed from: a */
    public final Class<?> f19548a = getClass();

    /* JADX INFO: renamed from: b */
    public final InterfaceC1696c f19549b;

    /* JADX INFO: renamed from: c */
    public final C1953y f19550c;

    /* JADX INFO: renamed from: d */
    @VisibleForTesting
    public final SparseArray<C1934f<V>> f19551d;

    /* JADX INFO: renamed from: e */
    @VisibleForTesting
    public final Set<V> f19552e;

    /* JADX INFO: renamed from: f */
    public boolean f19553f;

    /* JADX INFO: renamed from: g */
    @VisibleForTesting
    public final C10661a f19554g;

    /* JADX INFO: renamed from: h */
    @VisibleForTesting
    public final C10661a f19555h;

    /* JADX INFO: renamed from: i */
    public final InterfaceC1954z f19556i;

    /* JADX INFO: renamed from: j */
    public boolean f19557j;

    public static class InvalidSizeException extends RuntimeException {
        /* JADX WARN: Illegal instructions before constructor call */
        public InvalidSizeException(Object obj) {
            StringBuilder sbM833U = C1643a.m833U("Invalid size: ");
            sbM833U.append(obj.toString());
            super(sbM833U.toString());
        }
    }

    public static class InvalidValueException extends RuntimeException {
    }

    public static class PoolSizeViolationException extends RuntimeException {
        /* JADX WARN: Illegal instructions before constructor call */
        public PoolSizeViolationException(int i, int i2, int i3, int i4) {
            StringBuilder sbM835W = C1643a.m835W("Pool hard cap violation? Hard cap = ", i, " Used size = ", i2, " Free size = ");
            sbM835W.append(i3);
            sbM835W.append(" Request size = ");
            sbM835W.append(i4);
            super(sbM835W.toString());
        }
    }

    public static class SizeTooLargeException extends InvalidSizeException {
    }

    /* JADX INFO: renamed from: com.facebook.imagepipeline.memory.BasePool$a */
    @VisibleForTesting
    public static class C10661a {

        /* JADX INFO: renamed from: a */
        public int f19558a;

        /* JADX INFO: renamed from: b */
        public int f19559b;

        /* JADX INFO: renamed from: a */
        public void m8704a(int i) {
            int i2;
            int i3 = this.f19559b;
            if (i3 < i || (i2 = this.f19558a) <= 0) {
                C1691a.m988p("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.f19559b), Integer.valueOf(this.f19558a));
            } else {
                this.f19558a = i2 - 1;
                this.f19559b = i3 - i;
            }
        }

        /* JADX INFO: renamed from: b */
        public void m8705b(int i) {
            this.f19558a++;
            this.f19559b += i;
        }
    }

    public BasePool(InterfaceC1696c interfaceC1696c, C1953y c1953y, InterfaceC1954z interfaceC1954z) {
        Objects.requireNonNull(interfaceC1696c);
        this.f19549b = interfaceC1696c;
        Objects.requireNonNull(c1953y);
        this.f19550c = c1953y;
        Objects.requireNonNull(interfaceC1954z);
        this.f19556i = interfaceC1954z;
        SparseArray<C1934f<V>> sparseArray = new SparseArray<>();
        this.f19551d = sparseArray;
        SparseIntArray sparseIntArray = new SparseIntArray(0);
        synchronized (this) {
            sparseArray.clear();
            SparseIntArray sparseIntArray2 = c1953y.f3978c;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int iKeyAt = sparseIntArray2.keyAt(i);
                    int iValueAt = sparseIntArray2.valueAt(i);
                    int i2 = sparseIntArray.get(iKeyAt, 0);
                    SparseArray<C1934f<V>> sparseArray2 = this.f19551d;
                    int iMo1386k = mo1386k(iKeyAt);
                    Objects.requireNonNull(this.f19550c);
                    sparseArray2.put(iKeyAt, new C1934f<>(iMo1386k, iValueAt, i2, false));
                }
                this.f19553f = false;
            } else {
                this.f19553f = true;
            }
        }
        this.f19552e = Collections.newSetFromMap(new IdentityHashMap());
        this.f19555h = new C10661a();
        this.f19554g = new C10661a();
    }

    /* JADX INFO: renamed from: e */
    public abstract V mo1382e(int i);

    @VisibleForTesting
    /* JADX INFO: renamed from: f */
    public synchronized boolean m8697f(int i) {
        if (this.f19557j) {
            return true;
        }
        C1953y c1953y = this.f19550c;
        int i2 = c1953y.f3976a;
        int i3 = this.f19554g.f19559b;
        if (i > i2 - i3) {
            this.f19556i.mo1404f();
            return false;
        }
        int i4 = c1953y.f3977b;
        if (i > i4 - (i3 + this.f19555h.f19559b)) {
            m8703r(i4 - i);
        }
        if (i <= i2 - (this.f19554g.f19559b + this.f19555h.f19559b)) {
            return true;
        }
        this.f19556i.mo1404f();
        return false;
    }

    @VisibleForTesting
    /* JADX INFO: renamed from: g */
    public abstract void mo1383g(V v);

    @Override // p007b.p109f.p115d.p122g.InterfaceC1698e
    public V get(int i) throws Throwable {
        V vMo1387l;
        synchronized (this) {
            C1460d.m419B(!m8700n() || this.f19555h.f19559b == 0);
        }
        int iMo1384i = mo1384i(i);
        synchronized (this) {
            C1934f<V> c1934fM8698h = m8698h(iMo1384i);
            if (c1934fM8698h != null && (vMo1387l = mo1387l(c1934fM8698h)) != null) {
                C1460d.m419B(this.f19552e.add(vMo1387l));
                int iMo1386k = mo1386k(mo1385j(vMo1387l));
                this.f19554g.m8705b(iMo1386k);
                this.f19555h.m8704a(iMo1386k);
                this.f19556i.mo1400b(iMo1386k);
                m8701p();
                if (C1691a.m980h(2)) {
                    System.identityHashCode(vMo1387l);
                }
                return vMo1387l;
            }
            int iMo1386k2 = mo1386k(iMo1384i);
            if (!m8697f(iMo1386k2)) {
                throw new PoolSizeViolationException(this.f19550c.f3976a, this.f19554g.f19559b, this.f19555h.f19559b, iMo1386k2);
            }
            this.f19554g.m8705b(iMo1386k2);
            if (c1934fM8698h != null) {
                c1934fM8698h.f3930e++;
            }
            V vMo1382e = null;
            try {
                vMo1382e = mo1382e(iMo1384i);
            } catch (Throwable th) {
                synchronized (this) {
                    this.f19554g.m8704a(iMo1386k2);
                    C1934f<V> c1934fM8698h2 = m8698h(iMo1384i);
                    if (c1934fM8698h2 != null) {
                        c1934fM8698h2.m1377b();
                    }
                    C1690m.m972a(th);
                }
            }
            synchronized (this) {
                C1460d.m419B(this.f19552e.add(vMo1382e));
                synchronized (this) {
                    if (m8700n()) {
                        m8703r(this.f19550c.f3977b);
                    }
                }
                return vMo1382e;
            }
            this.f19556i.mo1399a(iMo1386k2);
            m8701p();
            if (C1691a.m980h(2)) {
                System.identityHashCode(vMo1382e);
            }
            return vMo1382e;
        }
    }

    @VisibleForTesting
    /* JADX INFO: renamed from: h */
    public synchronized C1934f<V> m8698h(int i) {
        C1934f<V> c1934f = this.f19551d.get(i);
        if (c1934f == null && this.f19553f) {
            C1691a.m980h(2);
            C1934f<V> c1934fM8702q = m8702q(i);
            this.f19551d.put(i, c1934fM8702q);
            return c1934fM8702q;
        }
        return c1934f;
    }

    /* JADX INFO: renamed from: i */
    public abstract int mo1384i(int i);

    /* JADX INFO: renamed from: j */
    public abstract int mo1385j(V v);

    /* JADX INFO: renamed from: k */
    public abstract int mo1386k(int i);

    /* JADX INFO: renamed from: l */
    public synchronized V mo1387l(C1934f<V> c1934f) {
        V vM1378c;
        vM1378c = c1934f.m1378c();
        if (vM1378c != null) {
            c1934f.f3930e++;
        }
        return vM1378c;
    }

    /* JADX INFO: renamed from: m */
    public void m8699m() {
        this.f19549b.mo989a(this);
        this.f19556i.mo1401c(this);
    }

    @VisibleForTesting
    /* JADX INFO: renamed from: n */
    public synchronized boolean m8700n() {
        boolean z2;
        z2 = this.f19554g.f19559b + this.f19555h.f19559b > this.f19550c.f3977b;
        if (z2) {
            this.f19556i.mo1402d();
        }
        return z2;
    }

    /* JADX INFO: renamed from: o */
    public boolean mo1388o(V v) {
        return true;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    /* JADX INFO: renamed from: p */
    public final void m8701p() {
        if (C1691a.m980h(2)) {
            C10661a c10661a = this.f19554g;
            int i = c10661a.f19558a;
            int i2 = c10661a.f19559b;
            C10661a c10661a2 = this.f19555h;
            int i3 = c10661a2.f19558a;
            int i4 = c10661a2.f19559b;
        }
    }

    /* JADX INFO: renamed from: q */
    public C1934f<V> m8702q(int i) {
        int iMo1386k = mo1386k(i);
        Objects.requireNonNull(this.f19550c);
        return new C1934f<>(iMo1386k, Integer.MAX_VALUE, 0, false);
    }

    @VisibleForTesting
    /* JADX INFO: renamed from: r */
    public synchronized void m8703r(int i) {
        int i2 = this.f19554g.f19559b;
        int i3 = this.f19555h.f19559b;
        int iMin = Math.min((i2 + i3) - i, i3);
        if (iMin <= 0) {
            return;
        }
        if (C1691a.m980h(2)) {
            C1691a.m982j(this.f19548a, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.f19554g.f19559b + this.f19555h.f19559b), Integer.valueOf(iMin));
        }
        m8701p();
        for (int i4 = 0; i4 < this.f19551d.size() && iMin > 0; i4++) {
            C1934f<V> c1934fValueAt = this.f19551d.valueAt(i4);
            Objects.requireNonNull(c1934fValueAt);
            C1934f<V> c1934f = c1934fValueAt;
            while (iMin > 0) {
                V vM1378c = c1934f.m1378c();
                if (vM1378c == null) {
                    break;
                }
                mo1383g(vM1378c);
                int i5 = c1934f.f3926a;
                iMin -= i5;
                this.f19555h.m8704a(i5);
            }
        }
        m8701p();
        if (C1691a.m980h(2)) {
            int i6 = this.f19554g.f19559b;
            int i7 = this.f19555h.f19559b;
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x007f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x0081 A[Catch: all -> 0x009f, TryCatch #1 {all -> 0x009f, blocks: (B:4:0x000c, B:6:0x0015, B:7:0x0016, B:9:0x0021, B:30:0x009a, B:31:0x009d, B:11:0x0045, B:16:0x0056, B:18:0x005c, B:21:0x0063, B:23:0x007b, B:25:0x0081, B:26:0x0084, B:28:0x008a, B:29:0x008d, B:36:0x00a2, B:37:0x00a3, B:5:0x000d), top: B:42:0x000c, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x008a A[Catch: all -> 0x009f, TryCatch #1 {all -> 0x009f, blocks: (B:4:0x000c, B:6:0x0015, B:7:0x0016, B:9:0x0021, B:30:0x009a, B:31:0x009d, B:11:0x0045, B:16:0x0056, B:18:0x005c, B:21:0x0063, B:23:0x007b, B:25:0x0081, B:26:0x0084, B:28:0x008a, B:29:0x008d, B:36:0x00a2, B:37:0x00a3, B:5:0x000d), top: B:42:0x000c, inners: #0 }] */
    @Override // p007b.p109f.p115d.p122g.InterfaceC1698e, p007b.p109f.p115d.p123h.InterfaceC1709f
    public void release(V v) {
        C1934f<V> c1934f;
        Objects.requireNonNull(v);
        int iMo1385j = mo1385j(v);
        int iMo1386k = mo1386k(iMo1385j);
        synchronized (this) {
            try {
                synchronized (this) {
                    c1934f = this.f19551d.get(iMo1385j);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        boolean z2 = true;
        if (!this.f19552e.remove(v)) {
            C1691a.m975c(this.f19548a, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(iMo1385j));
            mo1383g(v);
            this.f19556i.mo1403e(iMo1386k);
        } else if (c1934f == null) {
            if (c1934f != null) {
                c1934f.m1377b();
            }
            if (C1691a.m980h(2)) {
                System.identityHashCode(v);
            }
            mo1383g(v);
            this.f19554g.m8704a(iMo1386k);
            this.f19556i.mo1403e(iMo1386k);
        } else {
            if (c1934f.f3930e + c1934f.f3928c.size() <= c1934f.f3927b) {
                z2 = false;
            }
            if (z2 || m8700n() || !mo1388o(v)) {
                if (c1934f != null) {
                    c1934f.m1377b();
                }
                if (C1691a.m980h(2)) {
                    System.identityHashCode(v);
                }
                mo1383g(v);
                this.f19554g.m8704a(iMo1386k);
                this.f19556i.mo1403e(iMo1386k);
            } else {
                c1934f.m1379d(v);
                this.f19555h.m8705b(iMo1386k);
                this.f19554g.m8704a(iMo1386k);
                this.f19556i.mo1405g(iMo1386k);
                if (C1691a.m980h(2)) {
                    System.identityHashCode(v);
                }
            }
        }
        m8701p();
    }
}
