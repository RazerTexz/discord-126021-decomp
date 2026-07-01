package b.i.b.b;

import java.util.AbstractMap;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: renamed from: b.i.b.b.i0, reason: use source file name */
/* JADX INFO: compiled from: RegularImmutableMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class RegularImmutableMap<K, V> extends ImmutableMap2<K, V> {
    public static final ImmutableMap2<Object, Object> m = new RegularImmutableMap(null, new Object[0], 0);
    private static final long serialVersionUID = 0;
    public final transient int[] n;
    public final transient Object[] o;
    public final transient int p;

    /* JADX INFO: renamed from: b.i.b.b.i0$a */
    /* JADX INFO: compiled from: RegularImmutableMap.java */
    public static class a<K, V> extends ImmutableSet2<Map.Entry<K, V>> {
        public final transient ImmutableMap2<K, V> m;
        public final transient Object[] n;
        public final transient int o;
        public final transient int p;

        /* JADX INFO: renamed from: b.i.b.b.i0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: RegularImmutableMap.java */
        public class C0045a extends ImmutableList2<Map.Entry<K, V>> {
            public C0045a() {
            }

            @Override // java.util.List
            public Object get(int i) {
                b.i.a.f.e.o.f.x(i, a.this.p);
                a aVar = a.this;
                Object[] objArr = aVar.n;
                int i2 = i * 2;
                int i3 = aVar.o;
                return new AbstractMap.SimpleImmutableEntry(objArr[i2 + i3], objArr[i2 + (i3 ^ 1)]);
            }

            @Override // b.i.b.b.ImmutableCollection
            public boolean i() {
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return a.this.p;
            }
        }

        public a(ImmutableMap2<K, V> immutableMap2, Object[] objArr, int i, int i2) {
            this.m = immutableMap2;
            this.n = objArr;
            this.o = i;
            this.p = i2;
        }

        @Override // b.i.b.b.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            return value != null && value.equals(this.m.get(key));
        }

        @Override // b.i.b.b.ImmutableCollection
        public int d(Object[] objArr, int i) {
            return c().d(objArr, i);
        }

        @Override // b.i.b.b.ImmutableCollection
        public boolean i() {
            return true;
        }

        @Override // b.i.b.b.ImmutableSet2, b.i.b.b.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: j */
        public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
            return c().listIterator();
        }

        @Override // b.i.b.b.ImmutableSet2
        public ImmutableList2<Map.Entry<K, V>> o() {
            return new C0045a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.p;
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.i0$b */
    /* JADX INFO: compiled from: RegularImmutableMap.java */
    public static final class b<K> extends ImmutableSet2<K> {
        public final transient ImmutableMap2<K, ?> m;
        public final transient ImmutableList2<K> n;

        public b(ImmutableMap2<K, ?> immutableMap2, ImmutableList2<K> immutableList2) {
            this.m = immutableMap2;
            this.n = immutableList2;
        }

        @Override // b.i.b.b.ImmutableSet2, b.i.b.b.ImmutableCollection
        public ImmutableList2<K> c() {
            return this.n;
        }

        @Override // b.i.b.b.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            return this.m.get(obj) != null;
        }

        @Override // b.i.b.b.ImmutableCollection
        public int d(Object[] objArr, int i) {
            return this.n.d(objArr, i);
        }

        @Override // b.i.b.b.ImmutableCollection
        public boolean i() {
            return true;
        }

        @Override // b.i.b.b.ImmutableSet2, b.i.b.b.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: j */
        public UnmodifiableIterator<K> iterator() {
            return this.n.listIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.m.size();
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.i0$c */
    /* JADX INFO: compiled from: RegularImmutableMap.java */
    public static final class c extends ImmutableList2<Object> {
        public final transient Object[] l;
        public final transient int m;
        public final transient int n;

        public c(Object[] objArr, int i, int i2) {
            this.l = objArr;
            this.m = i;
            this.n = i2;
        }

        @Override // java.util.List
        public Object get(int i) {
            b.i.a.f.e.o.f.x(i, this.n);
            return this.l[(i * 2) + this.m];
        }

        @Override // b.i.b.b.ImmutableCollection
        public boolean i() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.n;
        }
    }

    public RegularImmutableMap(int[] iArr, Object[] objArr, int i) {
        this.n = iArr;
        this.o = objArr;
        this.p = i;
    }

    @Override // b.i.b.b.ImmutableMap2
    public ImmutableSet2<Map.Entry<K, V>> b() {
        return new a(this, this.o, 0, this.p);
    }

    @Override // b.i.b.b.ImmutableMap2
    public ImmutableSet2<K> c() {
        return new b(this, new c(this.o, 0, this.p));
    }

    @Override // b.i.b.b.ImmutableMap2
    public ImmutableCollection<V> d() {
        return new c(this.o, 1, this.p);
    }

    @Override // b.i.b.b.ImmutableMap2
    public boolean f() {
        return false;
    }

    @Override // b.i.b.b.ImmutableMap2, java.util.Map
    @NullableDecl
    public V get(@NullableDecl Object obj) {
        int[] iArr = this.n;
        Object[] objArr = this.o;
        int i = this.p;
        if (obj == null) {
            return null;
        }
        if (i == 1) {
            if (objArr[0].equals(obj)) {
                return (V) objArr[1];
            }
            return null;
        }
        if (iArr == null) {
            return null;
        }
        int length = iArr.length - 1;
        int iC1 = b.i.a.f.e.o.f.c1(obj.hashCode());
        while (true) {
            int i2 = iC1 & length;
            int i3 = iArr[i2];
            if (i3 == -1) {
                return null;
            }
            if (objArr[i3].equals(obj)) {
                return (V) objArr[i3 ^ 1];
            }
            iC1 = i2 + 1;
        }
    }

    @Override // java.util.Map
    public int size() {
        return this.p;
    }
}
