package b.f.j.c;

import android.os.SystemClock;
import androidx.annotation.VisibleForTesting;
import b.c.a.a0.AnimatableValueParser;
import b.f.d.d.Predicate2;
import b.f.d.h.ResourceReleaser;
import b.f.j.a.c.AnimatedFrameCache;
import b.f.j.c.CountingMemoryCache;
import b.f.j.c.MemoryCache;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: b.f.j.c.v, reason: use source file name */
/* JADX INFO: compiled from: LruCountingMemoryCache.java */
/* JADX INFO: loaded from: classes.dex */
public class LruCountingMemoryCache2<K, V> implements CountingMemoryCache<K, V>, MemoryCache<K, V> {
    public final CountingMemoryCache.b<K> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    public final CountingLruMap<K, CountingMemoryCache.a<K, V>> f561b;

    @VisibleForTesting
    public final CountingLruMap<K, CountingMemoryCache.a<K, V>> c;
    public final ValueDescriptor<V> d;
    public final Supplier<MemoryCacheParams> e;
    public MemoryCacheParams f;
    public long g;
    public final boolean h;
    public final boolean i;

    /* JADX INFO: renamed from: b.f.j.c.v$a */
    /* JADX INFO: compiled from: LruCountingMemoryCache.java */
    public class a implements ResourceReleaser<V> {
        public final /* synthetic */ CountingMemoryCache.a a;

        public a(CountingMemoryCache.a aVar) {
            this.a = aVar;
        }

        /* JADX WARN: Code duplicated, block: B:25:0x003d  */
        @Override // b.f.d.h.ResourceReleaser
        public void release(V v) {
            boolean z2;
            CountingMemoryCache.b<K> bVar;
            LruCountingMemoryCache2 lruCountingMemoryCache2 = LruCountingMemoryCache2.this;
            CountingMemoryCache.a<K, V> aVar = this.a;
            Objects.requireNonNull(lruCountingMemoryCache2);
            Objects.requireNonNull(aVar);
            synchronized (lruCountingMemoryCache2) {
                synchronized (lruCountingMemoryCache2) {
                    z2 = false;
                    AnimatableValueParser.B(aVar.c > 0);
                    aVar.c--;
                }
                CloseableReference.s(lruCountingMemoryCache2.o(aVar));
                if (!z2) {
                    aVar = null;
                }
                if (aVar != null && (bVar = aVar.e) != null) {
                    ((AnimatedFrameCache.a) bVar).a(aVar.a, true);
                }
                lruCountingMemoryCache2.m();
                lruCountingMemoryCache2.j();
            }
            synchronized (lruCountingMemoryCache2) {
                if (!aVar.d && aVar.c == 0) {
                    lruCountingMemoryCache2.f561b.d(aVar.a, aVar);
                    z2 = true;
                }
            }
            CloseableReference.s(lruCountingMemoryCache2.o(aVar));
            if (!z2) {
                aVar = null;
            }
            if (aVar != null) {
                ((AnimatedFrameCache.a) bVar).a(aVar.a, true);
            }
            lruCountingMemoryCache2.m();
            lruCountingMemoryCache2.j();
        }
    }

    public LruCountingMemoryCache2(ValueDescriptor<V> valueDescriptor, MemoryCache.a aVar, Supplier<MemoryCacheParams> supplier, CountingMemoryCache.b<K> bVar, boolean z2, boolean z3) {
        new WeakHashMap();
        this.d = valueDescriptor;
        this.f561b = new CountingLruMap<>(new LruCountingMemoryCache(this, valueDescriptor));
        this.c = new CountingLruMap<>(new LruCountingMemoryCache(this, valueDescriptor));
        this.e = supplier;
        MemoryCacheParams memoryCacheParams = supplier.get();
        AnimatableValueParser.y(memoryCacheParams, "mMemoryCacheParamsSupplier returned null");
        this.f = memoryCacheParams;
        this.g = SystemClock.uptimeMillis();
        this.a = bVar;
        this.h = z2;
        this.i = z3;
    }

    public static <K, V> void k(CountingMemoryCache.a<K, V> aVar) {
        CountingMemoryCache.b<K> bVar;
        if (aVar == null || (bVar = aVar.e) == null) {
            return;
        }
        ((AnimatedFrameCache.a) bVar).a(aVar.a, false);
    }

    @Override // b.f.j.c.MemoryCache
    public CloseableReference<V> a(K k, CloseableReference<V> closeableReference) {
        return c(k, closeableReference, this.a);
    }

    @Override // b.f.j.c.CountingMemoryCache
    public CloseableReference<V> b(K k) {
        CountingMemoryCache.a<K, V> aVarE;
        boolean z2;
        CloseableReference<V> closeableReference;
        Objects.requireNonNull(k);
        synchronized (this) {
            aVarE = this.f561b.e(k);
            z2 = false;
            if (aVarE != null) {
                CountingMemoryCache.a<K, V> aVarE2 = this.c.e(k);
                Objects.requireNonNull(aVarE2);
                AnimatableValueParser.B(aVarE2.c == 0);
                closeableReference = aVarE2.f558b;
                z2 = true;
            } else {
                closeableReference = null;
            }
        }
        if (z2) {
            k(aVarE);
        }
        return closeableReference;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x006f  */
    @Override // b.f.j.c.CountingMemoryCache
    public CloseableReference<V> c(K k, CloseableReference<V> closeableReference, CountingMemoryCache.b<K> bVar) {
        CloseableReference<V> closeableReferenceN;
        CloseableReference<V> closeableReferenceO;
        int iA;
        boolean z2;
        Objects.requireNonNull(k);
        Objects.requireNonNull(closeableReference);
        m();
        synchronized (this) {
            CountingMemoryCache.a<K, V> aVarE = this.f561b.e(k);
            CountingMemoryCache.a<K, V> aVarE2 = this.c.e(k);
            closeableReferenceN = null;
            if (aVarE2 != null) {
                g(aVarE2);
                closeableReferenceO = o(aVarE2);
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
            k(aVarE);
            j();
            return closeableReferenceN;
        }
        if (z2) {
            CountingMemoryCache.a<K, V> aVar = this.h ? new CountingMemoryCache.a<>(k, closeableReference, bVar, iA) : new CountingMemoryCache.a<>(k, closeableReference, bVar, -1);
            this.c.d(k, aVar);
            closeableReferenceN = n(aVar);
        }
        if (closeableReferenceO != null) {
            closeableReferenceO.close();
        }
        k(aVarE);
        j();
        return closeableReferenceN;
    }

    @Override // b.f.j.c.MemoryCache
    public synchronized boolean contains(K k) {
        boolean zContainsKey;
        CountingLruMap<K, CountingMemoryCache.a<K, V>> countingLruMap = this.c;
        synchronized (countingLruMap) {
            zContainsKey = countingLruMap.f557b.containsKey(k);
        }
        return zContainsKey;
    }

    @Override // b.f.j.c.MemoryCache
    public int d(Predicate2<K> predicate2) {
        ArrayList<CountingMemoryCache.a<K, V>> arrayListF;
        ArrayList<CountingMemoryCache.a<K, V>> arrayListF2;
        synchronized (this) {
            arrayListF = this.f561b.f(predicate2);
            arrayListF2 = this.c.f(predicate2);
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

    public final synchronized void g(CountingMemoryCache.a<K, V> aVar) {
        Objects.requireNonNull(aVar);
        AnimatableValueParser.B(!aVar.d);
        aVar.d = true;
    }

    @Override // b.f.j.c.MemoryCache
    public CloseableReference<V> get(K k) {
        CountingMemoryCache.a<K, V> aVarE;
        CountingMemoryCache.a<K, V> aVar;
        CloseableReference<V> closeableReferenceN;
        Objects.requireNonNull(k);
        synchronized (this) {
            aVarE = this.f561b.e(k);
            CountingLruMap<K, CountingMemoryCache.a<K, V>> countingLruMap = this.c;
            synchronized (countingLruMap) {
                aVar = countingLruMap.f557b.get(k);
            }
            CountingMemoryCache.a<K, V> aVar2 = aVar;
            closeableReferenceN = aVar2 != null ? n(aVar2) : null;
        }
        k(aVarE);
        m();
        j();
        return closeableReferenceN;
    }

    public final synchronized void h(ArrayList<CountingMemoryCache.a<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<CountingMemoryCache.a<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                g(it.next());
            }
        }
    }

    public final void i(ArrayList<CountingMemoryCache.a<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<CountingMemoryCache.a<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                CloseableReference.s(o(it.next()));
            }
        }
    }

    public void j() {
        ArrayList<CountingMemoryCache.a<K, V>> arrayListP;
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

    public final void l(ArrayList<CountingMemoryCache.a<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<CountingMemoryCache.a<K, V>> it = arrayList.iterator();
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
        AnimatableValueParser.y(memoryCacheParams, "mMemoryCacheParamsSupplier returned null");
        this.f = memoryCacheParams;
    }

    public final synchronized CloseableReference<V> n(CountingMemoryCache.a<K, V> aVar) {
        synchronized (this) {
            AnimatableValueParser.B(!aVar.d);
            aVar.c++;
        }
        return CloseableReference.D(aVar.f558b.u(), new a(aVar));
        return CloseableReference.D(aVar.f558b.u(), new a(aVar));
    }

    public final synchronized CloseableReference<V> o(CountingMemoryCache.a<K, V> aVar) {
        Objects.requireNonNull(aVar);
        return (aVar.d && aVar.c == 0) ? aVar.f558b : null;
    }

    public final synchronized ArrayList<CountingMemoryCache.a<K, V>> p(int i, int i2) {
        K next;
        int iMax = Math.max(i, 0);
        int iMax2 = Math.max(i2, 0);
        if (this.f561b.a() <= iMax && this.f561b.b() <= iMax2) {
            return null;
        }
        ArrayList<CountingMemoryCache.a<K, V>> arrayList = new ArrayList<>();
        while (true) {
            if (this.f561b.a() <= iMax && this.f561b.b() <= iMax2) {
                break;
            }
            CountingLruMap<K, CountingMemoryCache.a<K, V>> countingLruMap = this.f561b;
            synchronized (countingLruMap) {
                next = countingLruMap.f557b.isEmpty() ? null : countingLruMap.f557b.keySet().iterator().next();
            }
            if (next == null) {
                if (!this.i) {
                    throw new IllegalStateException(String.format("key is null, but exclusiveEntries count: %d, size: %d", Integer.valueOf(this.f561b.a()), Integer.valueOf(this.f561b.b())));
                }
                CountingLruMap<K, CountingMemoryCache.a<K, V>> countingLruMap2 = this.f561b;
                synchronized (countingLruMap2) {
                    if (countingLruMap2.f557b.isEmpty()) {
                        countingLruMap2.c = 0;
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
