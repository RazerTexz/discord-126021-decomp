package p007b.p225i.p355b.p357b;

import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.google.j2objc.annotations.Weak;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p355b.p356a.AbstractC4484d;
import p007b.p225i.p355b.p357b.ConcurrentMapC4533v.i;
import p007b.p225i.p355b.p357b.ConcurrentMapC4533v.n;
import p637j0.p642l.p647e.p648n.C12727d;

/* JADX INFO: renamed from: b.i.b.b.v */
/* JADX INFO: compiled from: MapMakerInternalMap.java */
/* JADX INFO: loaded from: classes3.dex */
public class ConcurrentMapC4533v<K, V, E extends i<K, V, E>, S extends n<K, V, E, S>> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {

    /* JADX INFO: renamed from: j */
    public static final b0<Object, Object, e> f12070j = new a();
    private static final long serialVersionUID = 5;
    public final int concurrencyLevel;

    /* JADX INFO: renamed from: k */
    public final transient int f12071k;
    public final AbstractC4484d<Object> keyEquivalence;

    /* JADX INFO: renamed from: l */
    public final transient int f12072l;

    /* JADX INFO: renamed from: m */
    public final transient n<K, V, E, S>[] f12073m;

    /* JADX INFO: renamed from: n */
    public final transient j<K, V, E, S> f12074n;

    /* JADX INFO: renamed from: o */
    @MonotonicNonNullDecl
    public transient Set<K> f12075o;

    /* JADX INFO: renamed from: p */
    @MonotonicNonNullDecl
    public transient Collection<V> f12076p;

    /* JADX INFO: renamed from: q */
    @MonotonicNonNullDecl
    public transient Set<Map.Entry<K, V>> f12077q;

    /* JADX INFO: renamed from: b.i.b.b.v$a */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public static class a implements b0<Object, Object, e> {
        @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.b0
        /* JADX INFO: renamed from: a */
        public /* bridge */ /* synthetic */ i mo6292a() {
            return null;
        }

        @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.b0
        /* JADX INFO: renamed from: b */
        public b0 mo6293b(ReferenceQueue<Object> referenceQueue, i iVar) {
            return this;
        }

        @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.b0
        public void clear() {
        }

        @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.b0
        public Object get() {
            return null;
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.v$a0 */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public interface a0<K, V, E extends i<K, V, E>> extends i<K, V, E> {
        /* JADX INFO: renamed from: b */
        b0<K, V, E> mo6294b();
    }

    /* JADX INFO: renamed from: b.i.b.b.v$b */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public static abstract class b<K, V> extends AbstractConcurrentMapC4513k<K, V> implements Serializable {
        private static final long serialVersionUID = 3;
        public final int concurrencyLevel;

        /* JADX INFO: renamed from: j */
        public transient ConcurrentMap<K, V> f12078j;
        public final AbstractC4484d<Object> keyEquivalence;
        public final p keyStrength;
        public final AbstractC4484d<Object> valueEquivalence;
        public final p valueStrength;

        public b(p pVar, p pVar2, AbstractC4484d<Object> abstractC4484d, AbstractC4484d<Object> abstractC4484d2, int i, ConcurrentMap<K, V> concurrentMap) {
            this.keyStrength = pVar;
            this.valueStrength = pVar2;
            this.keyEquivalence = abstractC4484d;
            this.valueEquivalence = abstractC4484d2;
            this.concurrencyLevel = i;
            this.f12078j = concurrentMap;
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.v$b0 */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public interface b0<K, V, E extends i<K, V, E>> {
        /* JADX INFO: renamed from: a */
        E mo6292a();

        /* JADX INFO: renamed from: b */
        b0<K, V, E> mo6293b(ReferenceQueue<V> referenceQueue, E e);

        void clear();

        @NullableDecl
        V get();
    }

    /* JADX INFO: renamed from: b.i.b.b.v$c */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public static abstract class c<K, V, E extends i<K, V, E>> implements i<K, V, E> {

        /* JADX INFO: renamed from: a */
        public final K f12079a;

        /* JADX INFO: renamed from: b */
        public final int f12080b;

        /* JADX INFO: renamed from: c */
        @NullableDecl
        public final E f12081c;

        public c(K k, int i, @NullableDecl E e) {
            this.f12079a = k;
            this.f12080b = i;
            this.f12081c = e;
        }

        @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.i
        /* JADX INFO: renamed from: a */
        public E mo6295a() {
            return this.f12081c;
        }

        @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.i
        /* JADX INFO: renamed from: c */
        public int mo6296c() {
            return this.f12080b;
        }

        @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.i
        public K getKey() {
            return this.f12079a;
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.v$c0 */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public static final class c0<K, V, E extends i<K, V, E>> extends WeakReference<V> implements b0<K, V, E> {

        /* JADX INFO: renamed from: a */
        @Weak
        public final E f12082a;

        public c0(ReferenceQueue<V> referenceQueue, V v, E e) {
            super(v, referenceQueue);
            this.f12082a = e;
        }

        @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.b0
        /* JADX INFO: renamed from: a */
        public E mo6292a() {
            return this.f12082a;
        }

        @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.b0
        /* JADX INFO: renamed from: b */
        public b0<K, V, E> mo6293b(ReferenceQueue<V> referenceQueue, E e) {
            return new c0(referenceQueue, get(), e);
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.v$d */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public static abstract class d<K, V, E extends i<K, V, E>> extends WeakReference<K> implements i<K, V, E> {

        /* JADX INFO: renamed from: a */
        public final int f12083a;

        /* JADX INFO: renamed from: b */
        @NullableDecl
        public final E f12084b;

        public d(ReferenceQueue<K> referenceQueue, K k, int i, @NullableDecl E e) {
            super(k, referenceQueue);
            this.f12083a = i;
            this.f12084b = e;
        }

        @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.i
        /* JADX INFO: renamed from: a */
        public E mo6295a() {
            return this.f12084b;
        }

        @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.i
        /* JADX INFO: renamed from: c */
        public int mo6296c() {
            return this.f12083a;
        }

        @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.i
        public K getKey() {
            return get();
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.v$d0 */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public final class d0 extends AbstractC4503f<K, V> {

        /* JADX INFO: renamed from: j */
        public final K f12085j;

        /* JADX INFO: renamed from: k */
        public V f12086k;

        public d0(K k, V v) {
            this.f12085j = k;
            this.f12086k = v;
        }

        @Override // p007b.p225i.p355b.p357b.AbstractC4503f, java.util.Map.Entry
        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.f12085j.equals(entry.getKey()) && this.f12086k.equals(entry.getValue());
        }

        @Override // p007b.p225i.p355b.p357b.AbstractC4503f, java.util.Map.Entry
        public K getKey() {
            return this.f12085j;
        }

        @Override // p007b.p225i.p355b.p357b.AbstractC4503f, java.util.Map.Entry
        public V getValue() {
            return this.f12086k;
        }

        @Override // p007b.p225i.p355b.p357b.AbstractC4503f, java.util.Map.Entry
        public int hashCode() {
            return this.f12085j.hashCode() ^ this.f12086k.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = (V) ConcurrentMapC4533v.this.put(this.f12085j, v);
            this.f12086k = v;
            return v2;
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.v$e */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public static final class e implements i<Object, Object, e> {
        public e() {
            throw new AssertionError();
        }

        @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.i
        /* JADX INFO: renamed from: a */
        public i mo6295a() {
            throw new AssertionError();
        }

        @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.i
        /* JADX INFO: renamed from: c */
        public int mo6296c() {
            throw new AssertionError();
        }

        @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.i
        public Object getKey() {
            throw new AssertionError();
        }

        @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.i
        public Object getValue() {
            throw new AssertionError();
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.v$f */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public final class f extends ConcurrentMapC4533v<K, V, E, S>.h<Map.Entry<K, V>> {
        public f(ConcurrentMapC4533v concurrentMapC4533v) {
            super();
        }

        @Override // java.util.Iterator
        public Object next() {
            return m6299c();
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.v$g */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public final class g extends m<Map.Entry<K, V>> {
        public g() {
            super(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            ConcurrentMapC4533v.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = ConcurrentMapC4533v.this.get(key)) != null && ConcurrentMapC4533v.this.m6291d().m6213c(entry.getValue(), obj2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return ConcurrentMapC4533v.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new f(ConcurrentMapC4533v.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && ConcurrentMapC4533v.this.remove(key, entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ConcurrentMapC4533v.this.size();
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.v$h */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public abstract class h<T> implements Iterator<T> {

        /* JADX INFO: renamed from: j */
        public int f12089j;

        /* JADX INFO: renamed from: k */
        public int f12090k = -1;

        /* JADX INFO: renamed from: l */
        @MonotonicNonNullDecl
        public n<K, V, E, S> f12091l;

        /* JADX INFO: renamed from: m */
        @MonotonicNonNullDecl
        public AtomicReferenceArray<E> f12092m;

        /* JADX INFO: renamed from: n */
        @NullableDecl
        public E f12093n;

        /* JADX INFO: renamed from: o */
        @NullableDecl
        public ConcurrentMapC4533v<K, V, E, S>.d0 f12094o;

        /* JADX INFO: renamed from: p */
        @NullableDecl
        public ConcurrentMapC4533v<K, V, E, S>.d0 f12095p;

        public h() {
            this.f12089j = ConcurrentMapC4533v.this.f12073m.length - 1;
            m6297a();
        }

        /* JADX INFO: renamed from: a */
        public final void m6297a() {
            this.f12094o = null;
            if (m6300d() || m6301e()) {
                return;
            }
            while (true) {
                int i = this.f12089j;
                if (i < 0) {
                    return;
                }
                n<K, V, E, S>[] nVarArr = ConcurrentMapC4533v.this.f12073m;
                this.f12089j = i - 1;
                n<K, V, E, S> nVar = nVarArr[i];
                this.f12091l = nVar;
                if (nVar.count != 0) {
                    AtomicReferenceArray<E> atomicReferenceArray = this.f12091l.table;
                    this.f12092m = atomicReferenceArray;
                    this.f12090k = atomicReferenceArray.length() - 1;
                    if (m6301e()) {
                        return;
                    }
                }
            }
        }

        /* JADX INFO: renamed from: b */
        public boolean m6298b(E e) {
            Object value;
            boolean z2;
            try {
                Object key = e.getKey();
                Objects.requireNonNull(ConcurrentMapC4533v.this);
                Object obj = null;
                if (e.getKey() != null && (value = e.getValue()) != null) {
                    obj = value;
                }
                if (obj != null) {
                    this.f12094o = new d0(key, obj);
                    z2 = true;
                } else {
                    z2 = false;
                }
                return z2;
            } finally {
                this.f12091l.m6315h();
            }
        }

        /* JADX INFO: renamed from: c */
        public ConcurrentMapC4533v<K, V, E, S>.d0 m6299c() {
            ConcurrentMapC4533v<K, V, E, S>.d0 d0Var = this.f12094o;
            if (d0Var == null) {
                throw new NoSuchElementException();
            }
            this.f12095p = d0Var;
            m6297a();
            return this.f12095p;
        }

        /* JADX INFO: renamed from: d */
        public boolean m6300d() {
            E e = this.f12093n;
            if (e == null) {
                return false;
            }
            while (true) {
                this.f12093n = (E) e.mo6295a();
                E e2 = this.f12093n;
                if (e2 == null) {
                    return false;
                }
                if (m6298b(e2)) {
                    return true;
                }
                e = this.f12093n;
            }
        }

        /* JADX INFO: renamed from: e */
        public boolean m6301e() {
            while (true) {
                int i = this.f12090k;
                if (i < 0) {
                    return false;
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.f12092m;
                this.f12090k = i - 1;
                E e = atomicReferenceArray.get(i);
                this.f12093n = e;
                if (e != null && (m6298b(e) || m6300d())) {
                    return true;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f12094o != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            C3404f.m4201E(this.f12095p != null);
            ConcurrentMapC4533v.this.remove(this.f12095p.f12085j);
            this.f12095p = null;
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.v$i */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public interface i<K, V, E extends i<K, V, E>> {
        /* JADX INFO: renamed from: a */
        E mo6295a();

        /* JADX INFO: renamed from: c */
        int mo6296c();

        K getKey();

        V getValue();
    }

    /* JADX INFO: renamed from: b.i.b.b.v$j */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public interface j<K, V, E extends i<K, V, E>, S extends n<K, V, E, S>> {
        /* JADX INFO: renamed from: a */
        E mo6302a(S s2, E e, @NullableDecl E e2);

        /* JADX INFO: renamed from: b */
        p mo6303b();

        /* JADX INFO: renamed from: c */
        p mo6304c();

        /* JADX INFO: renamed from: d */
        void mo6305d(S s2, E e, V v);

        /* JADX INFO: renamed from: e */
        S mo6306e(ConcurrentMapC4533v<K, V, E, S> concurrentMapC4533v, int i, int i2);

        /* JADX INFO: renamed from: f */
        E mo6307f(S s2, K k, int i, @NullableDecl E e);
    }

    /* JADX INFO: renamed from: b.i.b.b.v$k */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public final class k extends ConcurrentMapC4533v<K, V, E, S>.h<K> {
        public k(ConcurrentMapC4533v concurrentMapC4533v) {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            return m6299c().f12085j;
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.v$l */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public final class l extends m<K> {
        public l() {
            super(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            ConcurrentMapC4533v.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return ConcurrentMapC4533v.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return ConcurrentMapC4533v.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new k(ConcurrentMapC4533v.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return ConcurrentMapC4533v.this.remove(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ConcurrentMapC4533v.this.size();
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.v$m */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public static abstract class m<E> extends AbstractSet<E> {
        public m(a aVar) {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return ConcurrentMapC4533v.m6288a(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) ConcurrentMapC4533v.m6288a(this).toArray(tArr);
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.v$n */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public static abstract class n<K, V, E extends i<K, V, E>, S extends n<K, V, E, S>> extends ReentrantLock {

        /* JADX INFO: renamed from: j */
        public static final /* synthetic */ int f12098j = 0;
        public volatile int count;

        @Weak
        public final ConcurrentMapC4533v<K, V, E, S> map;
        public final int maxSegmentSize;
        public int modCount;
        public final AtomicInteger readCount = new AtomicInteger();

        @MonotonicNonNullDecl
        public volatile AtomicReferenceArray<E> table;
        public int threshold;

        public n(ConcurrentMapC4533v<K, V, E, S> concurrentMapC4533v, int i, int i2) {
            this.map = concurrentMapC4533v;
            this.maxSegmentSize = i2;
            AtomicReferenceArray<E> atomicReferenceArray = new AtomicReferenceArray<>(i);
            int length = (atomicReferenceArray.length() * 3) / 4;
            this.threshold = length;
            if (length == i2) {
                this.threshold = length + 1;
            }
            this.table = atomicReferenceArray;
        }

        /* JADX INFO: renamed from: a */
        public <T> void m6308a(ReferenceQueue<T> referenceQueue) {
            while (referenceQueue.poll() != null) {
            }
        }

        @GuardedBy("this")
        /* JADX INFO: renamed from: b */
        public void m6309b(ReferenceQueue<K> referenceQueue) {
            int i = 0;
            do {
                Reference<? extends K> referencePoll = referenceQueue.poll();
                if (referencePoll == null) {
                    return;
                }
                i iVar = (i) referencePoll;
                ConcurrentMapC4533v<K, V, E, S> concurrentMapC4533v = this.map;
                Objects.requireNonNull(concurrentMapC4533v);
                int iMo6296c = iVar.mo6296c();
                n<K, V, E, S> nVarM6290c = concurrentMapC4533v.m6290c(iMo6296c);
                nVarM6290c.lock();
                try {
                    AtomicReferenceArray<E> atomicReferenceArray = nVarM6290c.table;
                    int length = iMo6296c & (atomicReferenceArray.length() - 1);
                    E e = atomicReferenceArray.get(length);
                    for (i iVarMo6295a = e; iVarMo6295a != null; iVarMo6295a = iVarMo6295a.mo6295a()) {
                        if (iVarMo6295a == iVar) {
                            nVarM6290c.modCount++;
                            i iVarM6317j = nVarM6290c.m6317j(e, iVarMo6295a);
                            int i2 = nVarM6290c.count - 1;
                            atomicReferenceArray.set(length, (E) iVarM6317j);
                            nVarM6290c.count = i2;
                            break;
                        }
                    }
                    nVarM6290c.unlock();
                    i++;
                } catch (Throwable th) {
                    nVarM6290c.unlock();
                    throw th;
                }
            } while (i != 16);
        }

        @GuardedBy("this")
        /* JADX INFO: renamed from: c */
        public void m6310c(ReferenceQueue<V> referenceQueue) {
            int i = 0;
            do {
                Reference<? extends V> referencePoll = referenceQueue.poll();
                if (referencePoll == null) {
                    return;
                }
                b0<K, V, E> b0Var = (b0) referencePoll;
                ConcurrentMapC4533v<K, V, E, S> concurrentMapC4533v = this.map;
                Objects.requireNonNull(concurrentMapC4533v);
                i iVarMo6292a = b0Var.mo6292a();
                int iMo6296c = iVarMo6292a.mo6296c();
                n<K, V, E, S> nVarM6290c = concurrentMapC4533v.m6290c(iMo6296c);
                Object key = iVarMo6292a.getKey();
                nVarM6290c.lock();
                try {
                    AtomicReferenceArray<E> atomicReferenceArray = nVarM6290c.table;
                    int length = (atomicReferenceArray.length() - 1) & iMo6296c;
                    E e = atomicReferenceArray.get(length);
                    for (i iVarMo6295a = e; iVarMo6295a != null; iVarMo6295a = iVarMo6295a.mo6295a()) {
                        Object key2 = iVarMo6295a.getKey();
                        if (iVarMo6295a.mo6296c() == iMo6296c && key2 != null && nVarM6290c.map.keyEquivalence.m6213c(key, key2)) {
                            if (((a0) iVarMo6295a).mo6294b() != b0Var) {
                                break;
                            }
                            nVarM6290c.modCount++;
                            i iVarM6317j = nVarM6290c.m6317j(e, iVarMo6295a);
                            int i2 = nVarM6290c.count - 1;
                            atomicReferenceArray.set(length, (E) iVarM6317j);
                            nVarM6290c.count = i2;
                            break;
                        }
                    }
                    nVarM6290c.unlock();
                    i++;
                } catch (Throwable th) {
                    nVarM6290c.unlock();
                    throw th;
                }
            } while (i != 16);
        }

        @GuardedBy("this")
        /* JADX INFO: renamed from: d */
        public void m6311d() {
            AtomicReferenceArray<E> atomicReferenceArray = this.table;
            int length = atomicReferenceArray.length();
            if (length >= 1073741824) {
                return;
            }
            int i = this.count;
            C12727d c12727d = (AtomicReferenceArray<E>) new AtomicReferenceArray(length << 1);
            this.threshold = (c12727d.length() * 3) / 4;
            int length2 = c12727d.length() - 1;
            for (int i2 = 0; i2 < length; i2++) {
                E eMo6295a = atomicReferenceArray.get(i2);
                if (eMo6295a != null) {
                    i iVarMo6295a = eMo6295a.mo6295a();
                    int iMo6296c = eMo6295a.mo6296c() & length2;
                    if (iVarMo6295a == null) {
                        c12727d.set(iMo6296c, eMo6295a);
                    } else {
                        i iVar = eMo6295a;
                        while (iVarMo6295a != null) {
                            int iMo6296c2 = iVarMo6295a.mo6296c() & length2;
                            if (iMo6296c2 != iMo6296c) {
                                iVar = iVarMo6295a;
                                iMo6296c = iMo6296c2;
                            }
                            iVarMo6295a = iVarMo6295a.mo6295a();
                        }
                        c12727d.set(iMo6296c, iVar);
                        while (eMo6295a != iVar) {
                            int iMo6296c3 = eMo6295a.mo6296c() & length2;
                            i iVarMo6302a = this.map.f12074n.mo6302a(mo6319l(), eMo6295a, (i) c12727d.get(iMo6296c3));
                            if (iVarMo6302a != null) {
                                c12727d.set(iMo6296c3, iVarMo6302a);
                            } else {
                                i--;
                            }
                            eMo6295a = eMo6295a.mo6295a();
                        }
                    }
                }
            }
            this.table = c12727d;
            this.count = i;
        }

        /* JADX INFO: renamed from: e */
        public E m6312e(Object obj, int i) {
            if (this.count != 0) {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                for (E e = atomicReferenceArray.get((atomicReferenceArray.length() - 1) & i); e != null; e = (E) e.mo6295a()) {
                    if (e.mo6296c() == i) {
                        Object key = e.getKey();
                        if (key == null) {
                            m6321n();
                        } else if (this.map.keyEquivalence.m6213c(obj, key)) {
                            return e;
                        }
                    }
                }
            }
            return null;
        }

        /* JADX INFO: renamed from: f */
        public void mo6313f() {
        }

        @GuardedBy("this")
        /* JADX INFO: renamed from: g */
        public void mo6314g() {
        }

        /* JADX INFO: renamed from: h */
        public void m6315h() {
            if ((this.readCount.incrementAndGet() & 63) == 0) {
                m6318k();
            }
        }

        /* JADX INFO: renamed from: i */
        public V m6316i(K k, int i, V v, boolean z2) {
            lock();
            try {
                m6318k();
                int i2 = this.count + 1;
                if (i2 > this.threshold) {
                    m6311d();
                    i2 = this.count + 1;
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                E e = atomicReferenceArray.get(length);
                for (i iVarMo6295a = e; iVarMo6295a != null; iVarMo6295a = iVarMo6295a.mo6295a()) {
                    Object key = iVarMo6295a.getKey();
                    if (iVarMo6295a.mo6296c() == i && key != null && this.map.keyEquivalence.m6213c(k, key)) {
                        V v2 = (V) iVarMo6295a.getValue();
                        if (v2 == null) {
                            this.modCount++;
                            this.map.f12074n.mo6305d(mo6319l(), iVarMo6295a, v);
                            this.count = this.count;
                            return null;
                        }
                        if (z2) {
                            return v2;
                        }
                        this.modCount++;
                        this.map.f12074n.mo6305d(mo6319l(), iVarMo6295a, v);
                        return v2;
                    }
                }
                this.modCount++;
                i iVarMo6307f = this.map.f12074n.mo6307f(mo6319l(), k, i, e);
                m6320m(iVarMo6307f, v);
                atomicReferenceArray.set(length, (E) iVarMo6307f);
                this.count = i2;
                return null;
            } finally {
                unlock();
            }
        }

        @GuardedBy("this")
        /* JADX INFO: renamed from: j */
        public E m6317j(E e, E e2) {
            int i = this.count;
            E e3 = (E) e2.mo6295a();
            while (e != e2) {
                i iVarMo6302a = this.map.f12074n.mo6302a(mo6319l(), e, e3);
                if (iVarMo6302a != null) {
                    e3 = (E) iVarMo6302a;
                } else {
                    i--;
                }
                e = (E) e.mo6295a();
            }
            this.count = i;
            return e3;
        }

        /* JADX INFO: renamed from: k */
        public void m6318k() {
            if (tryLock()) {
                try {
                    mo6314g();
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }

        /* JADX INFO: renamed from: l */
        public abstract S mo6319l();

        /* JADX INFO: renamed from: m */
        public void m6320m(E e, V v) {
            this.map.f12074n.mo6305d(mo6319l(), e, v);
        }

        /* JADX INFO: renamed from: n */
        public void m6321n() {
            if (tryLock()) {
                try {
                    mo6314g();
                } finally {
                    unlock();
                }
            }
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.v$o */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public static final class o<K, V> extends b<K, V> {
        private static final long serialVersionUID = 3;

        public o(p pVar, p pVar2, AbstractC4484d<Object> abstractC4484d, AbstractC4484d<Object> abstractC4484d2, int i, ConcurrentMap<K, V> concurrentMap) {
            super(pVar, pVar2, abstractC4484d, abstractC4484d2, i, concurrentMap);
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            int i = objectInputStream.readInt();
            C4532u c4532u = new C4532u();
            int i2 = c4532u.f12065b;
            C3404f.m4204F(i2 == -1, "initial capacity was already set to %s", i2);
            C3404f.m4351v(i >= 0);
            c4532u.f12065b = i;
            c4532u.m6287d(this.keyStrength);
            p pVar = this.valueStrength;
            p pVar2 = c4532u.f12068e;
            C3404f.m4207G(pVar2 == null, "Value strength was already set to %s", pVar2);
            Objects.requireNonNull(pVar);
            c4532u.f12068e = pVar;
            if (pVar != p.f12099j) {
                c4532u.f12064a = true;
            }
            AbstractC4484d<Object> abstractC4484d = this.keyEquivalence;
            AbstractC4484d<Object> abstractC4484d2 = c4532u.f12069f;
            C3404f.m4207G(abstractC4484d2 == null, "key equivalence was already set to %s", abstractC4484d2);
            Objects.requireNonNull(abstractC4484d);
            c4532u.f12069f = abstractC4484d;
            c4532u.f12064a = true;
            int i3 = this.concurrencyLevel;
            int i4 = c4532u.f12066c;
            C3404f.m4204F(i4 == -1, "concurrency level was already set to %s", i4);
            C3404f.m4351v(i3 > 0);
            c4532u.f12066c = i3;
            this.f12078j = c4532u.m6286c();
            while (true) {
                Object object = objectInputStream.readObject();
                if (object == null) {
                    return;
                } else {
                    this.f12078j.put((K) object, (V) objectInputStream.readObject());
                }
            }
        }

        private Object readResolve() {
            return this.f12078j;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeInt(this.f12078j.size());
            for (Map.Entry<K, V> entry : this.f12078j.entrySet()) {
                objectOutputStream.writeObject(entry.getKey());
                objectOutputStream.writeObject(entry.getValue());
            }
            objectOutputStream.writeObject(null);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: renamed from: b.i.b.b.v$p */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public static abstract class p {

        /* JADX INFO: renamed from: j */
        public static final p f12099j;

        /* JADX INFO: renamed from: k */
        public static final p f12100k;

        /* JADX INFO: renamed from: l */
        public static final /* synthetic */ p[] f12101l;

        /* JADX INFO: renamed from: b.i.b.b.v$p$a */
        /* JADX INFO: compiled from: MapMakerInternalMap.java */
        public static enum a extends p {
            public a(String str, int i) {
                super(str, i, null);
            }

            @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.p
            /* JADX INFO: renamed from: f */
            public AbstractC4484d<Object> mo6322f() {
                return AbstractC4484d.a.f11948j;
            }
        }

        /* JADX INFO: renamed from: b.i.b.b.v$p$b */
        /* JADX INFO: compiled from: MapMakerInternalMap.java */
        public static enum b extends p {
            public b(String str, int i) {
                super(str, i, null);
            }

            @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.p
            /* JADX INFO: renamed from: f */
            public AbstractC4484d<Object> mo6322f() {
                return AbstractC4484d.b.f11949j;
            }
        }

        static {
            a aVar = new a("STRONG", 0);
            f12099j = aVar;
            b bVar = new b("WEAK", 1);
            f12100k = bVar;
            f12101l = new p[]{aVar, bVar};
        }

        public p(String str, int i, a aVar) {
            super(str, i);
        }

        public static p valueOf(String str) {
            return (p) Enum.valueOf(p.class, str);
        }

        public static p[] values() {
            return (p[]) f12101l.clone();
        }

        /* JADX INFO: renamed from: f */
        public abstract AbstractC4484d<Object> mo6322f();
    }

    /* JADX INFO: renamed from: b.i.b.b.v$q */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public static final class q<K, V> extends c<K, V, q<K, V>> implements i {

        /* JADX INFO: renamed from: d */
        @NullableDecl
        public volatile V f12102d;

        /* JADX INFO: renamed from: b.i.b.b.v$q$a */
        /* JADX INFO: compiled from: MapMakerInternalMap.java */
        public static final class a<K, V> implements j<K, V, q<K, V>, r<K, V>> {

            /* JADX INFO: renamed from: a */
            public static final a<?, ?> f12103a = new a<>();

            @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.j
            /* JADX INFO: renamed from: a */
            public i mo6302a(n nVar, i iVar, @NullableDecl i iVar2) {
                q qVar = (q) iVar;
                q qVar2 = new q(qVar.f12079a, qVar.f12080b, (q) iVar2);
                qVar2.f12102d = qVar.f12102d;
                return qVar2;
            }

            @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.j
            /* JADX INFO: renamed from: b */
            public p mo6303b() {
                return p.f12099j;
            }

            @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.j
            /* JADX INFO: renamed from: c */
            public p mo6304c() {
                return p.f12099j;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.j
            /* JADX INFO: renamed from: d */
            public void mo6305d(n nVar, i iVar, Object obj) {
                ((q) iVar).f12102d = obj;
            }

            @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.j
            /* JADX INFO: renamed from: e */
            public n mo6306e(ConcurrentMapC4533v concurrentMapC4533v, int i, int i2) {
                return new r(concurrentMapC4533v, i, i2);
            }

            @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.j
            /* JADX INFO: renamed from: f */
            public i mo6307f(n nVar, Object obj, int i, @NullableDecl i iVar) {
                return new q(obj, i, (q) iVar);
            }
        }

        public q(K k, int i, @NullableDecl q<K, V> qVar) {
            super(k, i, qVar);
            this.f12102d = null;
        }

        @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.i
        @NullableDecl
        public V getValue() {
            return this.f12102d;
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.v$r */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public static final class r<K, V> extends n<K, V, q<K, V>, r<K, V>> {
        public r(ConcurrentMapC4533v<K, V, q<K, V>, r<K, V>> concurrentMapC4533v, int i, int i2) {
            super(concurrentMapC4533v, i, i2);
        }

        @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.n
        /* JADX INFO: renamed from: l */
        public n mo6319l() {
            return this;
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.v$s */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public static final class s<K, V> extends c<K, V, s<K, V>> implements a0<K, V, s<K, V>> {

        /* JADX INFO: renamed from: d */
        public volatile b0<K, V, s<K, V>> f12104d;

        /* JADX INFO: renamed from: b.i.b.b.v$s$a */
        /* JADX INFO: compiled from: MapMakerInternalMap.java */
        public static final class a<K, V> implements j<K, V, s<K, V>, t<K, V>> {

            /* JADX INFO: renamed from: a */
            public static final a<?, ?> f12105a = new a<>();

            @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.j
            /* JADX INFO: renamed from: a */
            public i mo6302a(n nVar, i iVar, @NullableDecl i iVar2) {
                t tVar = (t) nVar;
                s sVar = (s) iVar;
                s sVar2 = (s) iVar2;
                int i = n.f12098j;
                if (sVar.getValue() == null) {
                    return null;
                }
                ReferenceQueue<V> referenceQueue = tVar.queueForValues;
                s sVar3 = new s(sVar.f12079a, sVar.f12080b, sVar2);
                sVar3.f12104d = sVar.f12104d.mo6293b(referenceQueue, sVar3);
                return sVar3;
            }

            @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.j
            /* JADX INFO: renamed from: b */
            public p mo6303b() {
                return p.f12099j;
            }

            @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.j
            /* JADX INFO: renamed from: c */
            public p mo6304c() {
                return p.f12100k;
            }

            @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.j
            /* JADX INFO: renamed from: d */
            public void mo6305d(n nVar, i iVar, Object obj) {
                s sVar = (s) iVar;
                ReferenceQueue referenceQueue = ((t) nVar).queueForValues;
                b0<K, V, s<K, V>> b0Var = sVar.f12104d;
                sVar.f12104d = new c0(referenceQueue, obj, sVar);
                b0Var.clear();
            }

            @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.j
            /* JADX INFO: renamed from: e */
            public n mo6306e(ConcurrentMapC4533v concurrentMapC4533v, int i, int i2) {
                return new t(concurrentMapC4533v, i, i2);
            }

            @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.j
            /* JADX INFO: renamed from: f */
            public i mo6307f(n nVar, Object obj, int i, @NullableDecl i iVar) {
                return new s(obj, i, (s) iVar);
            }
        }

        public s(K k, int i, @NullableDecl s<K, V> sVar) {
            super(k, i, sVar);
            b0<Object, Object, e> b0Var = ConcurrentMapC4533v.f12070j;
            this.f12104d = (b0<K, V, s<K, V>>) ConcurrentMapC4533v.f12070j;
        }

        @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.a0
        /* JADX INFO: renamed from: b */
        public b0<K, V, s<K, V>> mo6294b() {
            return this.f12104d;
        }

        @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.i
        public V getValue() {
            return this.f12104d.get();
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.v$t */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public static final class t<K, V> extends n<K, V, s<K, V>, t<K, V>> {
        private final ReferenceQueue<V> queueForValues;

        public t(ConcurrentMapC4533v<K, V, s<K, V>, t<K, V>> concurrentMapC4533v, int i, int i2) {
            super(concurrentMapC4533v, i, i2);
            this.queueForValues = new ReferenceQueue<>();
        }

        @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.n
        /* JADX INFO: renamed from: f */
        public void mo6313f() {
            m6308a(this.queueForValues);
        }

        @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.n
        /* JADX INFO: renamed from: g */
        public void mo6314g() {
            m6310c(this.queueForValues);
        }

        @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.n
        /* JADX INFO: renamed from: l */
        public n mo6319l() {
            return this;
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.v$u */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public final class u extends ConcurrentMapC4533v<K, V, E, S>.h<V> {
        public u(ConcurrentMapC4533v concurrentMapC4533v) {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            return m6299c().f12086k;
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.v$v */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public final class v extends AbstractCollection<V> {
        public v() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            ConcurrentMapC4533v.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return ConcurrentMapC4533v.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return ConcurrentMapC4533v.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new u(ConcurrentMapC4533v.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return ConcurrentMapC4533v.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return ConcurrentMapC4533v.m6288a(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) ConcurrentMapC4533v.m6288a(this).toArray(tArr);
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.v$w */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public static final class w<K, V> extends d<K, V, w<K, V>> implements i {

        /* JADX INFO: renamed from: c */
        @NullableDecl
        public volatile V f12107c;

        /* JADX INFO: renamed from: b.i.b.b.v$w$a */
        /* JADX INFO: compiled from: MapMakerInternalMap.java */
        public static final class a<K, V> implements j<K, V, w<K, V>, x<K, V>> {

            /* JADX INFO: renamed from: a */
            public static final a<?, ?> f12108a = new a<>();

            @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.j
            /* JADX INFO: renamed from: a */
            public i mo6302a(n nVar, i iVar, @NullableDecl i iVar2) {
                x xVar = (x) nVar;
                w wVar = (w) iVar;
                w wVar2 = (w) iVar2;
                if (wVar.get() == null) {
                    return null;
                }
                w wVar3 = new w(xVar.queueForKeys, wVar.get(), wVar.f12083a, wVar2);
                wVar3.f12107c = wVar.f12107c;
                return wVar3;
            }

            @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.j
            /* JADX INFO: renamed from: b */
            public p mo6303b() {
                return p.f12100k;
            }

            @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.j
            /* JADX INFO: renamed from: c */
            public p mo6304c() {
                return p.f12099j;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.j
            /* JADX INFO: renamed from: d */
            public void mo6305d(n nVar, i iVar, Object obj) {
                ((w) iVar).f12107c = obj;
            }

            @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.j
            /* JADX INFO: renamed from: e */
            public n mo6306e(ConcurrentMapC4533v concurrentMapC4533v, int i, int i2) {
                return new x(concurrentMapC4533v, i, i2);
            }

            @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.j
            /* JADX INFO: renamed from: f */
            public i mo6307f(n nVar, Object obj, int i, @NullableDecl i iVar) {
                return new w(((x) nVar).queueForKeys, obj, i, (w) iVar);
            }
        }

        public w(ReferenceQueue<K> referenceQueue, K k, int i, @NullableDecl w<K, V> wVar) {
            super(referenceQueue, k, i, wVar);
            this.f12107c = null;
        }

        @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.i
        @NullableDecl
        public V getValue() {
            return this.f12107c;
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.v$x */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public static final class x<K, V> extends n<K, V, w<K, V>, x<K, V>> {
        private final ReferenceQueue<K> queueForKeys;

        public x(ConcurrentMapC4533v<K, V, w<K, V>, x<K, V>> concurrentMapC4533v, int i, int i2) {
            super(concurrentMapC4533v, i, i2);
            this.queueForKeys = new ReferenceQueue<>();
        }

        @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.n
        /* JADX INFO: renamed from: f */
        public void mo6313f() {
            m6308a(this.queueForKeys);
        }

        @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.n
        /* JADX INFO: renamed from: g */
        public void mo6314g() {
            m6309b(this.queueForKeys);
        }

        @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.n
        /* JADX INFO: renamed from: l */
        public n mo6319l() {
            return this;
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.v$y */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public static final class y<K, V> extends d<K, V, y<K, V>> implements a0<K, V, y<K, V>> {

        /* JADX INFO: renamed from: c */
        public volatile b0<K, V, y<K, V>> f12109c;

        /* JADX INFO: renamed from: b.i.b.b.v$y$a */
        /* JADX INFO: compiled from: MapMakerInternalMap.java */
        public static final class a<K, V> implements j<K, V, y<K, V>, z<K, V>> {

            /* JADX INFO: renamed from: a */
            public static final a<?, ?> f12110a = new a<>();

            @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.j
            /* JADX INFO: renamed from: a */
            public i mo6302a(n nVar, i iVar, @NullableDecl i iVar2) {
                z zVar = (z) nVar;
                y yVar = (y) iVar;
                y yVar2 = (y) iVar2;
                if (yVar.get() == null) {
                    return null;
                }
                int i = n.f12098j;
                if (yVar.getValue() == null) {
                    return null;
                }
                ReferenceQueue referenceQueue = zVar.queueForKeys;
                ReferenceQueue<V> referenceQueue2 = zVar.queueForValues;
                y yVar3 = new y(referenceQueue, yVar.get(), yVar.f12083a, yVar2);
                yVar3.f12109c = yVar.f12109c.mo6293b(referenceQueue2, yVar3);
                return yVar3;
            }

            @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.j
            /* JADX INFO: renamed from: b */
            public p mo6303b() {
                return p.f12100k;
            }

            @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.j
            /* JADX INFO: renamed from: c */
            public p mo6304c() {
                return p.f12100k;
            }

            @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.j
            /* JADX INFO: renamed from: d */
            public void mo6305d(n nVar, i iVar, Object obj) {
                y yVar = (y) iVar;
                ReferenceQueue referenceQueue = ((z) nVar).queueForValues;
                b0<K, V, y<K, V>> b0Var = yVar.f12109c;
                yVar.f12109c = new c0(referenceQueue, obj, yVar);
                b0Var.clear();
            }

            @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.j
            /* JADX INFO: renamed from: e */
            public n mo6306e(ConcurrentMapC4533v concurrentMapC4533v, int i, int i2) {
                return new z(concurrentMapC4533v, i, i2);
            }

            @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.j
            /* JADX INFO: renamed from: f */
            public i mo6307f(n nVar, Object obj, int i, @NullableDecl i iVar) {
                return new y(((z) nVar).queueForKeys, obj, i, (y) iVar);
            }
        }

        public y(ReferenceQueue<K> referenceQueue, K k, int i, @NullableDecl y<K, V> yVar) {
            super(referenceQueue, k, i, yVar);
            b0<Object, Object, e> b0Var = ConcurrentMapC4533v.f12070j;
            this.f12109c = (b0<K, V, y<K, V>>) ConcurrentMapC4533v.f12070j;
        }

        @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.a0
        /* JADX INFO: renamed from: b */
        public b0<K, V, y<K, V>> mo6294b() {
            return this.f12109c;
        }

        @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.i
        public V getValue() {
            return this.f12109c.get();
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.v$z */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public static final class z<K, V> extends n<K, V, y<K, V>, z<K, V>> {
        private final ReferenceQueue<K> queueForKeys;
        private final ReferenceQueue<V> queueForValues;

        public z(ConcurrentMapC4533v<K, V, y<K, V>, z<K, V>> concurrentMapC4533v, int i, int i2) {
            super(concurrentMapC4533v, i, i2);
            this.queueForKeys = new ReferenceQueue<>();
            this.queueForValues = new ReferenceQueue<>();
        }

        @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.n
        /* JADX INFO: renamed from: f */
        public void mo6313f() {
            m6308a(this.queueForKeys);
        }

        @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.n
        /* JADX INFO: renamed from: g */
        public void mo6314g() {
            m6309b(this.queueForKeys);
            m6310c(this.queueForValues);
        }

        @Override // p007b.p225i.p355b.p357b.ConcurrentMapC4533v.n
        /* JADX INFO: renamed from: l */
        public n mo6319l() {
            return this;
        }
    }

    public ConcurrentMapC4533v(C4532u c4532u, j<K, V, E, S> jVar) {
        int i2 = c4532u.f12066c;
        this.concurrencyLevel = Math.min(i2 == -1 ? 4 : i2, 65536);
        this.keyEquivalence = (AbstractC4484d) C3404f.m4255W(c4532u.f12069f, c4532u.m6284a().mo6322f());
        this.f12074n = jVar;
        int i3 = c4532u.f12065b;
        int iMin = Math.min(i3 == -1 ? 16 : i3, BasicMeasure.EXACTLY);
        int i4 = 0;
        int i5 = 1;
        int i6 = 1;
        int i7 = 0;
        while (i6 < this.concurrencyLevel) {
            i7++;
            i6 <<= 1;
        }
        this.f12072l = 32 - i7;
        this.f12071k = i6 - 1;
        this.f12073m = new n[i6];
        int i8 = iMin / i6;
        while (i5 < (i6 * i8 < iMin ? i8 + 1 : i8)) {
            i5 <<= 1;
        }
        while (true) {
            n<K, V, E, S>[] nVarArr = this.f12073m;
            if (i4 >= nVarArr.length) {
                return;
            }
            nVarArr[i4] = this.f12074n.mo6306e(this, i5, -1);
            i4++;
        }
    }

    /* JADX INFO: renamed from: a */
    public static ArrayList m6288a(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        Objects.requireNonNull(it);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: b */
    public int m6289b(Object obj) {
        AbstractC4484d<Object> abstractC4484d = this.keyEquivalence;
        Objects.requireNonNull(abstractC4484d);
        int iMo6212b = abstractC4484d.mo6212b(obj);
        int i2 = iMo6212b + ((iMo6212b << 15) ^ (-12931));
        int i3 = i2 ^ (i2 >>> 10);
        int i4 = i3 + (i3 << 3);
        int i5 = i4 ^ (i4 >>> 6);
        int i6 = (i5 << 2) + (i5 << 14) + i5;
        return (i6 >>> 16) ^ i6;
    }

    /* JADX INFO: renamed from: c */
    public n<K, V, E, S> m6290c(int i2) {
        return this.f12073m[(i2 >>> this.f12072l) & this.f12071k];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (n<K, V, E, S> nVar : this.f12073m) {
            if (nVar.count != 0) {
                nVar.lock();
                try {
                    AtomicReferenceArray<E> atomicReferenceArray = nVar.table;
                    for (int i2 = 0; i2 < atomicReferenceArray.length(); i2++) {
                        atomicReferenceArray.set(i2, null);
                    }
                    nVar.mo6313f();
                    nVar.readCount.set(0);
                    nVar.modCount++;
                    nVar.count = 0;
                    nVar.unlock();
                } catch (Throwable th) {
                    nVar.unlock();
                    throw th;
                }
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        i iVarM6312e;
        boolean z2 = false;
        if (obj == null) {
            return false;
        }
        int iM6289b = m6289b(obj);
        n<K, V, E, S> nVarM6290c = m6290c(iM6289b);
        Objects.requireNonNull(nVarM6290c);
        try {
            if (nVarM6290c.count != 0 && (iVarM6312e = nVarM6290c.m6312e(obj, iM6289b)) != null && iVarM6312e.getValue() != null) {
                z2 = true;
            }
            return z2;
        } finally {
            nVarM6290c.m6315h();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        Object value;
        if (obj == null) {
            return false;
        }
        n<K, V, E, S>[] nVarArr = this.f12073m;
        long j2 = -1;
        int i2 = 0;
        while (i2 < 3) {
            long j3 = 0;
            int length = nVarArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                n<K, V, E, S> nVar = nVarArr[i3];
                int i4 = nVar.count;
                AtomicReferenceArray<E> atomicReferenceArray = nVar.table;
                for (int i5 = 0; i5 < atomicReferenceArray.length(); i5++) {
                    for (E eMo6295a = atomicReferenceArray.get(i5); eMo6295a != null; eMo6295a = eMo6295a.mo6295a()) {
                        if (eMo6295a.getKey() == null || (value = eMo6295a.getValue()) == null) {
                            nVar.m6321n();
                            value = null;
                        }
                        if (value != null && m6291d().m6213c(obj, value)) {
                            return true;
                        }
                    }
                }
                j3 += (long) nVar.modCount;
            }
            if (j3 == j2) {
                return false;
            }
            i2++;
            j2 = j3;
        }
        return false;
    }

    /* JADX INFO: renamed from: d */
    public AbstractC4484d<Object> m6291d() {
        return this.f12074n.mo6304c().mo6322f();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.f12077q;
        if (set != null) {
            return set;
        }
        g gVar = new g();
        this.f12077q = gVar;
        return gVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(@NullableDecl Object obj) {
        V v2 = null;
        if (obj == null) {
            return null;
        }
        int iM6289b = m6289b(obj);
        n<K, V, E, S> nVarM6290c = m6290c(iM6289b);
        Objects.requireNonNull(nVarM6290c);
        try {
            i iVarM6312e = nVarM6290c.m6312e(obj, iM6289b);
            if (iVarM6312e != null && (v2 = (V) iVarM6312e.getValue()) == null) {
                nVarM6290c.m6321n();
            }
            return v2;
        } finally {
            nVarM6290c.m6315h();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        n<K, V, E, S>[] nVarArr = this.f12073m;
        long j2 = 0;
        for (int i2 = 0; i2 < nVarArr.length; i2++) {
            if (nVarArr[i2].count != 0) {
                return false;
            }
            j2 += (long) nVarArr[i2].modCount;
        }
        if (j2 == 0) {
            return true;
        }
        for (int i3 = 0; i3 < nVarArr.length; i3++) {
            if (nVarArr[i3].count != 0) {
                return false;
            }
            j2 -= (long) nVarArr[i3].modCount;
        }
        return j2 == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.f12075o;
        if (set != null) {
            return set;
        }
        l lVar = new l();
        this.f12075o = lVar;
        return lVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    public V put(K k2, V v2) {
        Objects.requireNonNull(k2);
        Objects.requireNonNull(v2);
        int iM6289b = m6289b(k2);
        return m6290c(iM6289b).m6316i(k2, iM6289b, v2, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public V putIfAbsent(K k2, V v2) {
        Objects.requireNonNull(k2);
        Objects.requireNonNull(v2);
        int iM6289b = m6289b(k2);
        return m6290c(iM6289b).m6316i(k2, iM6289b, v2, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004a, code lost:
    
        if ((r7.getValue() == null) != false) goto L21;
     */
    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public V remove(@NullableDecl Object obj) {
        if (obj == null) {
            return null;
        }
        int iM6289b = m6289b(obj);
        n<K, V, E, S> nVarM6290c = m6290c(iM6289b);
        nVarM6290c.lock();
        try {
            nVarM6290c.m6318k();
            AtomicReferenceArray<E> atomicReferenceArray = nVarM6290c.table;
            int length = (atomicReferenceArray.length() - 1) & iM6289b;
            E e2 = atomicReferenceArray.get(length);
            i iVarMo6295a = e2;
            while (iVarMo6295a != null) {
                Object key = iVarMo6295a.getKey();
                if (iVarMo6295a.mo6296c() == iM6289b && key != null && nVarM6290c.map.keyEquivalence.m6213c(obj, key)) {
                    V v2 = (V) iVarMo6295a.getValue();
                    if (v2 == null) {
                    }
                    nVarM6290c.modCount++;
                    i iVarM6317j = nVarM6290c.m6317j(e2, iVarMo6295a);
                    int i2 = nVarM6290c.count - 1;
                    atomicReferenceArray.set(length, (E) iVarM6317j);
                    nVarM6290c.count = i2;
                    return v2;
                }
                iVarMo6295a = iVarMo6295a.mo6295a();
            }
            return null;
        } finally {
            nVarM6290c.unlock();
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public V replace(K k2, V v2) {
        Objects.requireNonNull(k2);
        Objects.requireNonNull(v2);
        int iM6289b = m6289b(k2);
        n<K, V, E, S> nVarM6290c = m6290c(iM6289b);
        nVarM6290c.lock();
        try {
            nVarM6290c.m6318k();
            AtomicReferenceArray<E> atomicReferenceArray = nVarM6290c.table;
            int length = (atomicReferenceArray.length() - 1) & iM6289b;
            E e2 = atomicReferenceArray.get(length);
            for (i iVarMo6295a = e2; iVarMo6295a != null; iVarMo6295a = iVarMo6295a.mo6295a()) {
                Object key = iVarMo6295a.getKey();
                if (iVarMo6295a.mo6296c() == iM6289b && key != null && nVarM6290c.map.keyEquivalence.m6213c(k2, key)) {
                    V v3 = (V) iVarMo6295a.getValue();
                    if (v3 != null) {
                        nVarM6290c.modCount++;
                        nVarM6290c.map.f12074n.mo6305d(nVarM6290c.mo6319l(), iVarMo6295a, v2);
                        return v3;
                    }
                    if (!(iVarMo6295a.getValue() == null)) {
                        break;
                    }
                    nVarM6290c.modCount++;
                    i iVarM6317j = nVarM6290c.m6317j(e2, iVarMo6295a);
                    int i2 = nVarM6290c.count - 1;
                    atomicReferenceArray.set(length, (E) iVarM6317j);
                    nVarM6290c.count = i2;
                    break;
                }
            }
            return null;
        } finally {
            nVarM6290c.unlock();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        long j2 = 0;
        for (n<K, V, E, S> nVar : this.f12073m) {
            j2 += (long) nVar.count;
        }
        if (j2 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j2 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.f12076p;
        if (collection != null) {
            return collection;
        }
        v vVar = new v();
        this.f12076p = vVar;
        return vVar;
    }

    public Object writeReplace() {
        return new o(this.f12074n.mo6303b(), this.f12074n.mo6304c(), this.keyEquivalence, this.f12074n.mo6304c().mo6322f(), this.concurrencyLevel, this);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public boolean remove(@NullableDecl Object obj, @NullableDecl Object obj2) {
        boolean z2 = false;
        if (obj == null || obj2 == null) {
            return false;
        }
        int iM6289b = m6289b(obj);
        n<K, V, E, S> nVarM6290c = m6290c(iM6289b);
        nVarM6290c.lock();
        try {
            nVarM6290c.m6318k();
            AtomicReferenceArray<E> atomicReferenceArray = nVarM6290c.table;
            int length = (atomicReferenceArray.length() - 1) & iM6289b;
            E e2 = atomicReferenceArray.get(length);
            for (i iVarMo6295a = e2; iVarMo6295a != null; iVarMo6295a = iVarMo6295a.mo6295a()) {
                Object key = iVarMo6295a.getKey();
                if (iVarMo6295a.mo6296c() == iM6289b && key != null && nVarM6290c.map.keyEquivalence.m6213c(obj, key)) {
                    if (!nVarM6290c.map.m6291d().m6213c(obj2, iVarMo6295a.getValue())) {
                        if (!(iVarMo6295a.getValue() == null)) {
                            break;
                        }
                        break;
                    }
                    z2 = true;
                    nVarM6290c.modCount++;
                    i iVarM6317j = nVarM6290c.m6317j(e2, iVarMo6295a);
                    int i2 = nVarM6290c.count - 1;
                    atomicReferenceArray.set(length, (E) iVarM6317j);
                    nVarM6290c.count = i2;
                    break;
                }
            }
            return z2;
        } finally {
            nVarM6290c.unlock();
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public boolean replace(K k2, @NullableDecl V v2, V v3) {
        Objects.requireNonNull(k2);
        Objects.requireNonNull(v3);
        if (v2 == null) {
            return false;
        }
        int iM6289b = m6289b(k2);
        n<K, V, E, S> nVarM6290c = m6290c(iM6289b);
        nVarM6290c.lock();
        try {
            nVarM6290c.m6318k();
            AtomicReferenceArray<E> atomicReferenceArray = nVarM6290c.table;
            int length = (atomicReferenceArray.length() - 1) & iM6289b;
            E e2 = atomicReferenceArray.get(length);
            for (i iVarMo6295a = e2; iVarMo6295a != null; iVarMo6295a = iVarMo6295a.mo6295a()) {
                Object key = iVarMo6295a.getKey();
                if (iVarMo6295a.mo6296c() == iM6289b && key != null && nVarM6290c.map.keyEquivalence.m6213c(k2, key)) {
                    Object value = iVarMo6295a.getValue();
                    if (value == null) {
                        if (!(iVarMo6295a.getValue() == null)) {
                            break;
                        }
                        nVarM6290c.modCount++;
                        i iVarM6317j = nVarM6290c.m6317j(e2, iVarMo6295a);
                        int i2 = nVarM6290c.count - 1;
                        atomicReferenceArray.set(length, (E) iVarM6317j);
                        nVarM6290c.count = i2;
                        break;
                    }
                    if (!nVarM6290c.map.m6291d().m6213c(v2, value)) {
                        break;
                    }
                    nVarM6290c.modCount++;
                    nVarM6290c.map.f12074n.mo6305d(nVarM6290c.mo6319l(), iVarMo6295a, v3);
                    return true;
                }
            }
            return false;
        } finally {
            nVarM6290c.unlock();
        }
    }
}
