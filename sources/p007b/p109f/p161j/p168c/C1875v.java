package p007b.p109f.p161j.p168c;

import android.os.SystemClock;
import androidx.annotation.VisibleForTesting;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.WeakHashMap;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p115d.p119d.InterfaceC1687j;
import p007b.p109f.p115d.p123h.InterfaceC1709f;
import p007b.p109f.p161j.p162a.p165c.C1847c;

/* JADX INFO: renamed from: b.f.j.c.v */
/* JADX INFO: compiled from: LruCountingMemoryCache.java */
/* JADX INFO: loaded from: classes.dex */
public class C1875v<K, V> implements InterfaceC1866m<K, V>, InterfaceC1876w<K, V> {

    /* JADX INFO: renamed from: a */
    public final InterfaceC1866m.b<K> f3692a;

    /* JADX INFO: renamed from: b */
    @VisibleForTesting
    public final C1865l<K, InterfaceC1866m.a<K, V>> f3693b;

    /* JADX INFO: renamed from: c */
    @VisibleForTesting
    public final C1865l<K, InterfaceC1866m.a<K, V>> f3694c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC1855b0<V> f3695d;

    /* JADX INFO: renamed from: e */
    public final Supplier<MemoryCacheParams> f3696e;

    /* JADX INFO: renamed from: f */
    public MemoryCacheParams f3697f;

    /* JADX INFO: renamed from: g */
    public long f3698g;

    /* JADX INFO: renamed from: h */
    public final boolean f3699h;

    /* JADX INFO: renamed from: i */
    public final boolean f3700i;

    /* JADX INFO: renamed from: b.f.j.c.v$a */
    /* JADX INFO: compiled from: LruCountingMemoryCache.java */
    public class a implements InterfaceC1709f<V> {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ InterfaceC1866m.a f3701a;

        public a(InterfaceC1866m.a aVar) {
            this.f3701a = aVar;
        }

        /* JADX WARN: Code duplicated, block: B:25:0x003d  */
        @Override // p007b.p109f.p115d.p123h.InterfaceC1709f
        public void release(V v) {
            boolean z2;
            InterfaceC1866m.b<K> bVar;
            C1875v c1875v = C1875v.this;
            InterfaceC1866m.a<K, V> aVar = this.f3701a;
            Objects.requireNonNull(c1875v);
            Objects.requireNonNull(aVar);
            synchronized (c1875v) {
                synchronized (c1875v) {
                    z2 = false;
                    C1460d.m419B(aVar.f3680c > 0);
                    aVar.f3680c--;
                }
                CloseableReference.m8638s(c1875v.m1247o(aVar));
                if (!z2) {
                    aVar = null;
                }
                if (aVar != null && (bVar = aVar.f3682e) != null) {
                    ((C1847c.a) bVar).m1201a(aVar.f3678a, true);
                }
                c1875v.m1245m();
                c1875v.m1243j();
            }
            synchronized (c1875v) {
                if (!aVar.f3681d && aVar.f3680c == 0) {
                    c1875v.f3693b.m1224d(aVar.f3678a, aVar);
                    z2 = true;
                }
            }
            CloseableReference.m8638s(c1875v.m1247o(aVar));
            if (!z2) {
                aVar = null;
            }
            if (aVar != null) {
                ((C1847c.a) bVar).m1201a(aVar.f3678a, true);
            }
            c1875v.m1245m();
            c1875v.m1243j();
        }
    }

    public C1875v(InterfaceC1855b0<V> interfaceC1855b0, InterfaceC1876w.a aVar, Supplier<MemoryCacheParams> supplier, InterfaceC1866m.b<K> bVar, boolean z2, boolean z3) {
        new WeakHashMap();
        this.f3695d = interfaceC1855b0;
        this.f3693b = new C1865l<>(new C1874u(this, interfaceC1855b0));
        this.f3694c = new C1865l<>(new C1874u(this, interfaceC1855b0));
        this.f3696e = supplier;
        MemoryCacheParams memoryCacheParams = supplier.get();
        C1460d.m591y(memoryCacheParams, "mMemoryCacheParamsSupplier returned null");
        this.f3697f = memoryCacheParams;
        this.f3698g = SystemClock.uptimeMillis();
        this.f3692a = bVar;
        this.f3699h = z2;
        this.f3700i = z3;
    }

    /* JADX INFO: renamed from: k */
    public static <K, V> void m1237k(InterfaceC1866m.a<K, V> aVar) {
        InterfaceC1866m.b<K> bVar;
        if (aVar == null || (bVar = aVar.f3682e) == null) {
            return;
        }
        ((C1847c.a) bVar).m1201a(aVar.f3678a, false);
    }

    @Override // p007b.p109f.p161j.p168c.InterfaceC1876w
    /* JADX INFO: renamed from: a */
    public CloseableReference<V> mo1235a(K k, CloseableReference<V> closeableReference) {
        return mo1228c(k, closeableReference, this.f3692a);
    }

    @Override // p007b.p109f.p161j.p168c.InterfaceC1866m
    /* JADX INFO: renamed from: b */
    public CloseableReference<V> mo1227b(K k) {
        InterfaceC1866m.a<K, V> aVarM1225e;
        boolean z2;
        CloseableReference<V> closeableReference;
        Objects.requireNonNull(k);
        synchronized (this) {
            aVarM1225e = this.f3693b.m1225e(k);
            z2 = false;
            if (aVarM1225e != null) {
                InterfaceC1866m.a<K, V> aVarM1225e2 = this.f3694c.m1225e(k);
                Objects.requireNonNull(aVarM1225e2);
                C1460d.m419B(aVarM1225e2.f3680c == 0);
                closeableReference = aVarM1225e2.f3679b;
                z2 = true;
            } else {
                closeableReference = null;
            }
        }
        if (z2) {
            m1237k(aVarM1225e);
        }
        return closeableReference;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x006f  */
    @Override // p007b.p109f.p161j.p168c.InterfaceC1866m
    /* JADX INFO: renamed from: c */
    public CloseableReference<V> mo1228c(K k, CloseableReference<V> closeableReference, InterfaceC1866m.b<K> bVar) {
        CloseableReference<V> closeableReferenceM1246n;
        CloseableReference<V> closeableReferenceM1247o;
        int iMo1212a;
        boolean z2;
        Objects.requireNonNull(k);
        Objects.requireNonNull(closeableReference);
        m1245m();
        synchronized (this) {
            InterfaceC1866m.a<K, V> aVarM1225e = this.f3693b.m1225e(k);
            InterfaceC1866m.a<K, V> aVarM1225e2 = this.f3694c.m1225e(k);
            closeableReferenceM1246n = null;
            if (aVarM1225e2 != null) {
                m1240g(aVarM1225e2);
                closeableReferenceM1247o = m1247o(aVarM1225e2);
            } else {
                closeableReferenceM1247o = null;
            }
            iMo1212a = this.f3695d.mo1212a(closeableReference.m8642u());
            synchronized (this) {
                z2 = iMo1212a <= this.f3697f.f19546e && m1238e() <= this.f3697f.f19543b - 1 && m1239f() <= this.f3697f.f19542a - iMo1212a;
            }
            if (closeableReferenceM1247o != null) {
                closeableReferenceM1247o.close();
            }
            m1237k(aVarM1225e);
            m1243j();
            return closeableReferenceM1246n;
        }
        if (z2) {
            InterfaceC1866m.a<K, V> aVar = this.f3699h ? new InterfaceC1866m.a<>(k, closeableReference, bVar, iMo1212a) : new InterfaceC1866m.a<>(k, closeableReference, bVar, -1);
            this.f3694c.m1224d(k, aVar);
            closeableReferenceM1246n = m1246n(aVar);
        }
        if (closeableReferenceM1247o != null) {
            closeableReferenceM1247o.close();
        }
        m1237k(aVarM1225e);
        m1243j();
        return closeableReferenceM1246n;
    }

    @Override // p007b.p109f.p161j.p168c.InterfaceC1876w
    public synchronized boolean contains(K k) {
        boolean zContainsKey;
        C1865l<K, InterfaceC1866m.a<K, V>> c1865l = this.f3694c;
        synchronized (c1865l) {
            zContainsKey = c1865l.f3676b.containsKey(k);
        }
        return zContainsKey;
    }

    @Override // p007b.p109f.p161j.p168c.InterfaceC1876w
    /* JADX INFO: renamed from: d */
    public int mo1236d(InterfaceC1687j<K> interfaceC1687j) {
        ArrayList<InterfaceC1866m.a<K, V>> arrayListM1226f;
        ArrayList<InterfaceC1866m.a<K, V>> arrayListM1226f2;
        synchronized (this) {
            arrayListM1226f = this.f3693b.m1226f(interfaceC1687j);
            arrayListM1226f2 = this.f3694c.m1226f(interfaceC1687j);
            m1241h(arrayListM1226f2);
        }
        m1242i(arrayListM1226f2);
        m1244l(arrayListM1226f);
        m1245m();
        m1243j();
        return arrayListM1226f2.size();
    }

    /* JADX INFO: renamed from: e */
    public synchronized int m1238e() {
        return this.f3694c.m1221a() - this.f3693b.m1221a();
    }

    /* JADX INFO: renamed from: f */
    public synchronized int m1239f() {
        return this.f3694c.m1222b() - this.f3693b.m1222b();
    }

    /* JADX INFO: renamed from: g */
    public final synchronized void m1240g(InterfaceC1866m.a<K, V> aVar) {
        Objects.requireNonNull(aVar);
        C1460d.m419B(!aVar.f3681d);
        aVar.f3681d = true;
    }

    @Override // p007b.p109f.p161j.p168c.InterfaceC1876w
    public CloseableReference<V> get(K k) {
        InterfaceC1866m.a<K, V> aVarM1225e;
        InterfaceC1866m.a<K, V> aVar;
        CloseableReference<V> closeableReferenceM1246n;
        Objects.requireNonNull(k);
        synchronized (this) {
            aVarM1225e = this.f3693b.m1225e(k);
            C1865l<K, InterfaceC1866m.a<K, V>> c1865l = this.f3694c;
            synchronized (c1865l) {
                aVar = c1865l.f3676b.get(k);
            }
            InterfaceC1866m.a<K, V> aVar2 = aVar;
            closeableReferenceM1246n = aVar2 != null ? m1246n(aVar2) : null;
        }
        m1237k(aVarM1225e);
        m1245m();
        m1243j();
        return closeableReferenceM1246n;
    }

    /* JADX INFO: renamed from: h */
    public final synchronized void m1241h(ArrayList<InterfaceC1866m.a<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<InterfaceC1866m.a<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                m1240g(it.next());
            }
        }
    }

    /* JADX INFO: renamed from: i */
    public final void m1242i(ArrayList<InterfaceC1866m.a<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<InterfaceC1866m.a<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                CloseableReference.m8638s(m1247o(it.next()));
            }
        }
    }

    /* JADX INFO: renamed from: j */
    public void m1243j() {
        ArrayList<InterfaceC1866m.a<K, V>> arrayListM1248p;
        synchronized (this) {
            MemoryCacheParams memoryCacheParams = this.f3697f;
            int iMin = Math.min(memoryCacheParams.f19545d, memoryCacheParams.f19543b - m1238e());
            MemoryCacheParams memoryCacheParams2 = this.f3697f;
            arrayListM1248p = m1248p(iMin, Math.min(memoryCacheParams2.f19544c, memoryCacheParams2.f19542a - m1239f()));
            m1241h(arrayListM1248p);
        }
        m1242i(arrayListM1248p);
        m1244l(arrayListM1248p);
    }

    /* JADX INFO: renamed from: l */
    public final void m1244l(ArrayList<InterfaceC1866m.a<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<InterfaceC1866m.a<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                m1237k(it.next());
            }
        }
    }

    /* JADX INFO: renamed from: m */
    public final synchronized void m1245m() {
        if (this.f3698g + this.f3697f.f19547f > SystemClock.uptimeMillis()) {
            return;
        }
        this.f3698g = SystemClock.uptimeMillis();
        MemoryCacheParams memoryCacheParams = this.f3696e.get();
        C1460d.m591y(memoryCacheParams, "mMemoryCacheParamsSupplier returned null");
        this.f3697f = memoryCacheParams;
    }

    /* JADX INFO: renamed from: n */
    public final synchronized CloseableReference<V> m1246n(InterfaceC1866m.a<K, V> aVar) {
        synchronized (this) {
            C1460d.m419B(!aVar.f3681d);
            aVar.f3680c++;
        }
        return CloseableReference.m8633D(aVar.f3679b.m8642u(), new a(aVar));
        return CloseableReference.m8633D(aVar.f3679b.m8642u(), new a(aVar));
    }

    /* JADX INFO: renamed from: o */
    public final synchronized CloseableReference<V> m1247o(InterfaceC1866m.a<K, V> aVar) {
        Objects.requireNonNull(aVar);
        return (aVar.f3681d && aVar.f3680c == 0) ? aVar.f3679b : null;
    }

    /* JADX INFO: renamed from: p */
    public final synchronized ArrayList<InterfaceC1866m.a<K, V>> m1248p(int i, int i2) {
        K next;
        int iMax = Math.max(i, 0);
        int iMax2 = Math.max(i2, 0);
        if (this.f3693b.m1221a() <= iMax && this.f3693b.m1222b() <= iMax2) {
            return null;
        }
        ArrayList<InterfaceC1866m.a<K, V>> arrayList = new ArrayList<>();
        while (true) {
            if (this.f3693b.m1221a() <= iMax && this.f3693b.m1222b() <= iMax2) {
                break;
            }
            C1865l<K, InterfaceC1866m.a<K, V>> c1865l = this.f3693b;
            synchronized (c1865l) {
                next = c1865l.f3676b.isEmpty() ? null : c1865l.f3676b.keySet().iterator().next();
            }
            if (next == null) {
                if (!this.f3700i) {
                    throw new IllegalStateException(String.format("key is null, but exclusiveEntries count: %d, size: %d", Integer.valueOf(this.f3693b.m1221a()), Integer.valueOf(this.f3693b.m1222b())));
                }
                C1865l<K, InterfaceC1866m.a<K, V>> c1865l2 = this.f3693b;
                synchronized (c1865l2) {
                    if (c1865l2.f3676b.isEmpty()) {
                        c1865l2.f3677c = 0;
                    }
                    break;
                }
            }
            this.f3693b.m1225e(next);
            arrayList.add(this.f3694c.m1225e(next));
        }
        return arrayList;
    }
}
