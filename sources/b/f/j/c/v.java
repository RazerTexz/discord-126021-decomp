package b.f.j.c;

import android.os.SystemClock;
import androidx.annotation.VisibleForTesting;
import b.f.j.a.c.c$a;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: LruCountingMemoryCache.java */
/* JADX INFO: loaded from: classes.dex */
public class v<K, V> implements m<K, V>, w<K, V> {
    public final m$b<K> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    public final l<K, m$a<K, V>> f561b;

    @VisibleForTesting
    public final l<K, m$a<K, V>> c;
    public final b0<V> d;
    public final Supplier<MemoryCacheParams> e;
    public MemoryCacheParams f;
    public long g;
    public final boolean h;
    public final boolean i;

    public v(b0<V> b0Var, w$a w_a, Supplier<MemoryCacheParams> supplier, m$b<K> m_b, boolean z2, boolean z3) {
        new WeakHashMap();
        this.d = b0Var;
        this.f561b = new l<>(new u(this, b0Var));
        this.c = new l<>(new u(this, b0Var));
        this.e = supplier;
        MemoryCacheParams memoryCacheParams = supplier.get();
        b.c.a.a0.d.y(memoryCacheParams, "mMemoryCacheParamsSupplier returned null");
        this.f = memoryCacheParams;
        this.g = SystemClock.uptimeMillis();
        this.a = m_b;
        this.h = z2;
        this.i = z3;
    }

    public static <K, V> void k(m$a<K, V> m_a) {
        m$b<K> m_b;
        if (m_a == null || (m_b = m_a.e) == null) {
            return;
        }
        ((c$a) m_b).a(m_a.a, false);
    }

    @Override // b.f.j.c.w
    public CloseableReference<V> a(K k, CloseableReference<V> closeableReference) {
        return c(k, closeableReference, this.a);
    }

    @Override // b.f.j.c.m
    public CloseableReference<V> b(K k) {
        m$a<K, V> m_aE;
        boolean z2;
        CloseableReference<V> closeableReference;
        Objects.requireNonNull(k);
        synchronized (this) {
            m_aE = this.f561b.e(k);
            z2 = false;
            if (m_aE != null) {
                m$a<K, V> m_aE2 = this.c.e(k);
                Objects.requireNonNull(m_aE2);
                b.c.a.a0.d.B(m_aE2.c == 0);
                closeableReference = m_aE2.f558b;
                z2 = true;
            } else {
                closeableReference = null;
            }
        }
        if (z2) {
            k(m_aE);
        }
        return closeableReference;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x006f  */
    @Override // b.f.j.c.m
    public CloseableReference<V> c(K k, CloseableReference<V> closeableReference, m$b<K> m_b) {
        CloseableReference<V> closeableReferenceN;
        CloseableReference<V> closeableReferenceO;
        int iA;
        boolean z2;
        Objects.requireNonNull(k);
        Objects.requireNonNull(closeableReference);
        m();
        synchronized (this) {
            m$a<K, V> m_aE = this.f561b.e(k);
            m$a<K, V> m_aE2 = this.c.e(k);
            closeableReferenceN = null;
            if (m_aE2 != null) {
                g(m_aE2);
                closeableReferenceO = o(m_aE2);
            } else {
                closeableReferenceO = null;
            }
            iA = this.d.a(closeableReference.u());
            synchronized (this) {
                z2 = iA <= this.f.e && e() <= this.f.f2895b - 1 && f() <= this.f.a - iA;
            }
            if (closeableReferenceO != null) {
                closeableReferenceO.close();
            }
            k(m_aE);
            j();
            return closeableReferenceN;
        }
        if (z2) {
            m$a<K, V> m_a = this.h ? new m$a<>(k, closeableReference, m_b, iA) : new m$a<>(k, closeableReference, m_b, -1);
            this.c.d(k, m_a);
            closeableReferenceN = n(m_a);
        }
        if (closeableReferenceO != null) {
            closeableReferenceO.close();
        }
        k(m_aE);
        j();
        return closeableReferenceN;
    }

    @Override // b.f.j.c.w
    public synchronized boolean contains(K k) {
        boolean zContainsKey;
        l<K, m$a<K, V>> lVar = this.c;
        synchronized (lVar) {
            zContainsKey = lVar.f557b.containsKey(k);
        }
        return zContainsKey;
    }

    @Override // b.f.j.c.w
    public int d(b.f.d.d.j<K> jVar) {
        ArrayList<m$a<K, V>> arrayListF;
        ArrayList<m$a<K, V>> arrayListF2;
        synchronized (this) {
            arrayListF = this.f561b.f(jVar);
            arrayListF2 = this.c.f(jVar);
            h(arrayListF2);
        }
        i(arrayListF2);
        l(arrayListF);
        m();
        j();
        return arrayListF2.size();
    }

    public synchronized int e() {
        return this.c.a() - this.f561b.a();
    }

    public synchronized int f() {
        return this.c.b() - this.f561b.b();
    }

    public final synchronized void g(m$a<K, V> m_a) {
        Objects.requireNonNull(m_a);
        b.c.a.a0.d.B(!m_a.d);
        m_a.d = true;
    }

    @Override // b.f.j.c.w
    public CloseableReference<V> get(K k) {
        m$a<K, V> m_aE;
        m$a<K, V> m_a;
        CloseableReference<V> closeableReferenceN;
        Objects.requireNonNull(k);
        synchronized (this) {
            m_aE = this.f561b.e(k);
            l<K, m$a<K, V>> lVar = this.c;
            synchronized (lVar) {
                m_a = lVar.f557b.get(k);
            }
            m$a<K, V> m_a2 = m_a;
            closeableReferenceN = m_a2 != null ? n(m_a2) : null;
        }
        k(m_aE);
        m();
        j();
        return closeableReferenceN;
    }

    public final synchronized void h(ArrayList<m$a<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<m$a<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                g(it.next());
            }
        }
    }

    public final void i(ArrayList<m$a<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<m$a<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                CloseableReference.s(o(it.next()));
            }
        }
    }

    public void j() {
        ArrayList<m$a<K, V>> arrayListP;
        synchronized (this) {
            MemoryCacheParams memoryCacheParams = this.f;
            int iMin = Math.min(memoryCacheParams.d, memoryCacheParams.f2895b - e());
            MemoryCacheParams memoryCacheParams2 = this.f;
            arrayListP = p(iMin, Math.min(memoryCacheParams2.c, memoryCacheParams2.a - f()));
            h(arrayListP);
        }
        i(arrayListP);
        l(arrayListP);
    }

    public final void l(ArrayList<m$a<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<m$a<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                k(it.next());
            }
        }
    }

    public final synchronized void m() {
        if (this.g + this.f.f > SystemClock.uptimeMillis()) {
            return;
        }
        this.g = SystemClock.uptimeMillis();
        MemoryCacheParams memoryCacheParams = this.e.get();
        b.c.a.a0.d.y(memoryCacheParams, "mMemoryCacheParamsSupplier returned null");
        this.f = memoryCacheParams;
    }

    public final synchronized CloseableReference<V> n(m$a<K, V> m_a) {
        synchronized (this) {
            b.c.a.a0.d.B(!m_a.d);
            m_a.c++;
        }
        return CloseableReference.D(m_a.f558b.u(), new v$a(this, m_a));
        return CloseableReference.D(m_a.f558b.u(), new v$a(this, m_a));
    }

    public final synchronized CloseableReference<V> o(m$a<K, V> m_a) {
        Objects.requireNonNull(m_a);
        return (m_a.d && m_a.c == 0) ? m_a.f558b : null;
    }

    public final synchronized ArrayList<m$a<K, V>> p(int i, int i2) {
        K next;
        int iMax = Math.max(i, 0);
        int iMax2 = Math.max(i2, 0);
        if (this.f561b.a() <= iMax && this.f561b.b() <= iMax2) {
            return null;
        }
        ArrayList<m$a<K, V>> arrayList = new ArrayList<>();
        while (true) {
            if (this.f561b.a() <= iMax && this.f561b.b() <= iMax2) {
                break;
            }
            l<K, m$a<K, V>> lVar = this.f561b;
            synchronized (lVar) {
                next = lVar.f557b.isEmpty() ? null : lVar.f557b.keySet().iterator().next();
            }
            if (next == null) {
                if (!this.i) {
                    throw new IllegalStateException(String.format("key is null, but exclusiveEntries count: %d, size: %d", Integer.valueOf(this.f561b.a()), Integer.valueOf(this.f561b.b())));
                }
                l<K, m$a<K, V>> lVar2 = this.f561b;
                synchronized (lVar2) {
                    if (lVar2.f557b.isEmpty()) {
                        lVar2.c = 0;
                    }
                    break;
                }
            }
            this.f561b.e(next);
            arrayList.add(this.c.e(next));
        }
        return arrayList;
    }
}
