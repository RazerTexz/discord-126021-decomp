package b.i.b.b;

import b.i.b.b.ImmutableCollection;
import com.discord.api.permission.Permission;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: renamed from: b.i.b.b.q, reason: use source file name */
/* JADX INFO: compiled from: ImmutableMap.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ImmutableMap2<K, V> implements Map<K, V>, Serializable {

    @LazyInit
    public transient ImmutableSet2<Map.Entry<K, V>> j;

    @RetainedWith
    @LazyInit
    public transient ImmutableSet2<K> k;

    @RetainedWith
    @LazyInit
    public transient ImmutableCollection<V> l;

    /* JADX INFO: renamed from: b.i.b.b.q$a */
    /* JADX INFO: compiled from: ImmutableMap.java */
    public static class a<K, V> {
        public Object[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1648b = 0;
        public boolean c = false;

        public a(int i) {
            this.a = new Object[i * 2];
        }

        public ImmutableMap2<K, V> a() {
            int i;
            this.c = true;
            int i2 = this.f1648b;
            Object[] objArr = this.a;
            if (i2 == 0) {
                return (RegularImmutableMap) RegularImmutableMap.m;
            }
            int[] iArr = null;
            if (i2 == 1) {
                b.i.a.f.e.o.f.z(objArr[0], objArr[1]);
                return new RegularImmutableMap(null, objArr, 1);
            }
            b.i.a.f.e.o.f.C(i2, objArr.length >> 1);
            int iK = ImmutableSet2.k(i2);
            if (i2 == 1) {
                b.i.a.f.e.o.f.z(objArr[0], objArr[1]);
            } else {
                int i3 = iK - 1;
                int[] iArr2 = new int[iK];
                Arrays.fill(iArr2, -1);
                for (int i4 = 0; i4 < i2; i4++) {
                    int i5 = i4 * 2;
                    int i6 = i5 + 0;
                    Object obj = objArr[i6];
                    Object obj2 = objArr[i5 + 1];
                    b.i.a.f.e.o.f.z(obj, obj2);
                    int iC1 = b.i.a.f.e.o.f.c1(obj.hashCode());
                    while (true) {
                        i = iC1 & i3;
                        int i7 = iArr2[i];
                        if (i7 == -1) {
                            break;
                        }
                        if (objArr[i7].equals(obj)) {
                            throw new IllegalArgumentException("Multiple entries with same key: " + obj + "=" + obj2 + " and " + objArr[i7] + "=" + objArr[1 ^ i7]);
                        }
                        iC1 = i + 1;
                    }
                    iArr2[i] = i6;
                }
                iArr = iArr2;
            }
            return new RegularImmutableMap(iArr, objArr, i2);
        }

        public final void b(int i) {
            int i2 = i * 2;
            Object[] objArr = this.a;
            if (i2 > objArr.length) {
                this.a = Arrays.copyOf(objArr, ImmutableCollection.b.a(objArr.length, i2));
                this.c = false;
            }
        }

        @CanIgnoreReturnValue
        public a<K, V> c(K k, V v) {
            b(this.f1648b + 1);
            b.i.a.f.e.o.f.z(k, v);
            Object[] objArr = this.a;
            int i = this.f1648b;
            objArr[i * 2] = k;
            objArr[(i * 2) + 1] = v;
            this.f1648b = i + 1;
            return this;
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.q$b */
    /* JADX INFO: compiled from: ImmutableMap.java */
    public static class b implements Serializable {
        private static final long serialVersionUID = 0;
        private final Object[] keys;
        private final Object[] values;

        public b(ImmutableMap2<?, ?> immutableMap2) {
            this.keys = new Object[immutableMap2.size()];
            this.values = new Object[immutableMap2.size()];
            UnmodifiableIterator<Map.Entry<?, ?>> it = immutableMap2.entrySet().iterator();
            int i = 0;
            while (it.hasNext()) {
                Map.Entry<?, ?> next = it.next();
                this.keys[i] = next.getKey();
                this.values[i] = next.getValue();
                i++;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Object readResolve() {
            a aVar = new a(this.keys.length);
            int i = 0;
            while (true) {
                Object[] objArr = this.keys;
                if (i >= objArr.length) {
                    return aVar.a();
                }
                aVar.c(objArr[i], this.values[i]);
                i++;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> ImmutableMap2<K, V> a(Map<? extends K, ? extends V> map) {
        if ((map instanceof ImmutableMap2) && !(map instanceof SortedMap)) {
            ImmutableMap2<K, V> immutableMap2 = (ImmutableMap2) map;
            if (!immutableMap2.f()) {
                return immutableMap2;
            }
        }
        Set<Map.Entry<? extends K, ? extends V>> setEntrySet = map.entrySet();
        boolean z2 = setEntrySet instanceof Collection;
        a aVar = new a(z2 ? setEntrySet.size() : 4);
        if (z2) {
            aVar.b(setEntrySet.size() + aVar.f1648b);
        }
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            aVar.c(entry.getKey(), entry.getValue());
        }
        return aVar.a();
    }

    public abstract ImmutableSet2<Map.Entry<K, V>> b();

    public abstract ImmutableSet2<K> c();

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        ImmutableCollection<V> immutableCollectionD = this.l;
        if (immutableCollectionD == null) {
            immutableCollectionD = d();
            this.l = immutableCollectionD;
        }
        return immutableCollectionD.contains(obj);
    }

    public abstract ImmutableCollection<V> d();

    @Override // java.util.Map
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public ImmutableSet2<Map.Entry<K, V>> entrySet() {
        ImmutableSet2<Map.Entry<K, V>> immutableSet2 = this.j;
        if (immutableSet2 != null) {
            return immutableSet2;
        }
        ImmutableSet2<Map.Entry<K, V>> immutableSet2B = b();
        this.j = immutableSet2B;
        return immutableSet2B;
    }

    @Override // java.util.Map
    public boolean equals(@NullableDecl Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public abstract boolean f();

    @Override // java.util.Map
    public abstract V get(@NullableDecl Object obj);

    @Override // java.util.Map
    public final V getOrDefault(@NullableDecl Object obj, @NullableDecl V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    @Override // java.util.Map
    public int hashCode() {
        return Collections2.a(entrySet());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public Set keySet() {
        ImmutableSet2<K> immutableSet2 = this.k;
        if (immutableSet2 != null) {
            return immutableSet2;
        }
        ImmutableSet2<K> immutableSet2C = c();
        this.k = immutableSet2C;
        return immutableSet2C;
    }

    @Override // java.util.Map
    @CanIgnoreReturnValue
    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @CanIgnoreReturnValue
    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        int size = size();
        b.i.a.f.e.o.f.A(size, "size");
        StringBuilder sb = new StringBuilder((int) Math.min(((long) size) * 8, Permission.MANAGE_EMOJIS_AND_STICKERS));
        sb.append('{');
        boolean z2 = true;
        for (Map.Entry entry : entrySet()) {
            if (!z2) {
                sb.append(", ");
            }
            z2 = false;
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // java.util.Map
    public Collection values() {
        ImmutableCollection<V> immutableCollection = this.l;
        if (immutableCollection != null) {
            return immutableCollection;
        }
        ImmutableCollection<V> immutableCollectionD = d();
        this.l = immutableCollectionD;
        return immutableCollectionD;
    }

    public Object writeReplace() {
        return new b(this);
    }
}
