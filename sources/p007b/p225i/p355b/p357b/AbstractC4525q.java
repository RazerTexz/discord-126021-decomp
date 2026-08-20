package p007b.p225i.p355b.p357b;

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
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: b.i.b.b.q */
/* JADX INFO: compiled from: ImmutableMap.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4525q<K, V> implements Map<K, V>, Serializable {

    /* JADX INFO: renamed from: j */
    @LazyInit
    public transient AbstractC4527r<Map.Entry<K, V>> f12049j;

    /* JADX INFO: renamed from: k */
    @RetainedWith
    @LazyInit
    public transient AbstractC4527r<K> f12050k;

    /* JADX INFO: renamed from: l */
    @RetainedWith
    @LazyInit
    public transient AbstractC4519n<V> f12051l;

    /* JADX INFO: renamed from: b.i.b.b.q$a */
    /* JADX INFO: compiled from: ImmutableMap.java */
    public static class a<K, V> {

        /* JADX INFO: renamed from: a */
        public Object[] f12052a;

        /* JADX INFO: renamed from: b */
        public int f12053b = 0;

        /* JADX INFO: renamed from: c */
        public boolean f12054c = false;

        public a(int i) {
            this.f12052a = new Object[i * 2];
        }

        /* JADX INFO: renamed from: a */
        public AbstractC4525q<K, V> m6275a() {
            int i;
            this.f12054c = true;
            int i2 = this.f12053b;
            Object[] objArr = this.f12052a;
            if (i2 == 0) {
                return (C4510i0) C4510i0.f12015m;
            }
            int[] iArr = null;
            if (i2 == 1) {
                C3404f.m4366z(objArr[0], objArr[1]);
                return new C4510i0(null, objArr, 1);
            }
            C3404f.m4195C(i2, objArr.length >> 1);
            int iM6279k = AbstractC4527r.m6279k(i2);
            if (i2 == 1) {
                C3404f.m4366z(objArr[0], objArr[1]);
            } else {
                int i3 = iM6279k - 1;
                int[] iArr2 = new int[iM6279k];
                Arrays.fill(iArr2, -1);
                for (int i4 = 0; i4 < i2; i4++) {
                    int i5 = i4 * 2;
                    int i6 = i5 + 0;
                    Object obj = objArr[i6];
                    Object obj2 = objArr[i5 + 1];
                    C3404f.m4366z(obj, obj2);
                    int iM4277c1 = C3404f.m4277c1(obj.hashCode());
                    while (true) {
                        i = iM4277c1 & i3;
                        int i7 = iArr2[i];
                        if (i7 == -1) {
                            break;
                        }
                        if (objArr[i7].equals(obj)) {
                            throw new IllegalArgumentException("Multiple entries with same key: " + obj + "=" + obj2 + " and " + objArr[i7] + "=" + objArr[1 ^ i7]);
                        }
                        iM4277c1 = i + 1;
                    }
                    iArr2[i] = i6;
                }
                iArr = iArr2;
            }
            return new C4510i0(iArr, objArr, i2);
        }

        /* JADX INFO: renamed from: b */
        public final void m6276b(int i) {
            int i2 = i * 2;
            Object[] objArr = this.f12052a;
            if (i2 > objArr.length) {
                this.f12052a = Arrays.copyOf(objArr, AbstractC4519n.b.m6260a(objArr.length, i2));
                this.f12054c = false;
            }
        }

        @CanIgnoreReturnValue
        /* JADX INFO: renamed from: c */
        public a<K, V> m6277c(K k, V v) {
            m6276b(this.f12053b + 1);
            C3404f.m4366z(k, v);
            Object[] objArr = this.f12052a;
            int i = this.f12053b;
            objArr[i * 2] = k;
            objArr[(i * 2) + 1] = v;
            this.f12053b = i + 1;
            return this;
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.q$b */
    /* JADX INFO: compiled from: ImmutableMap.java */
    public static class b implements Serializable {
        private static final long serialVersionUID = 0;
        private final Object[] keys;
        private final Object[] values;

        public b(AbstractC4525q<?, ?> abstractC4525q) {
            this.keys = new Object[abstractC4525q.size()];
            this.values = new Object[abstractC4525q.size()];
            AbstractC4530s0<Map.Entry<?, ?>> it = abstractC4525q.entrySet().iterator();
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
                    return aVar.m6275a();
                }
                aVar.m6277c(objArr[i], this.values[i]);
                i++;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public static <K, V> AbstractC4525q<K, V> m6273a(Map<? extends K, ? extends V> map) {
        if ((map instanceof AbstractC4525q) && !(map instanceof SortedMap)) {
            AbstractC4525q<K, V> abstractC4525q = (AbstractC4525q) map;
            if (!abstractC4525q.mo6250f()) {
                return abstractC4525q;
            }
        }
        Set<Map.Entry<? extends K, ? extends V>> setEntrySet = map.entrySet();
        boolean z2 = setEntrySet instanceof Collection;
        a aVar = new a(z2 ? setEntrySet.size() : 4);
        if (z2) {
            aVar.m6276b(setEntrySet.size() + aVar.f12053b);
        }
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            aVar.m6277c(entry.getKey(), entry.getValue());
        }
        return aVar.m6275a();
    }

    /* JADX INFO: renamed from: b */
    public abstract AbstractC4527r<Map.Entry<K, V>> mo6247b();

    /* JADX INFO: renamed from: c */
    public abstract AbstractC4527r<K> mo6248c();

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
        AbstractC4519n<V> abstractC4519nMo6249d = this.f12051l;
        if (abstractC4519nMo6249d == null) {
            abstractC4519nMo6249d = mo6249d();
            this.f12051l = abstractC4519nMo6249d;
        }
        return abstractC4519nMo6249d.contains(obj);
    }

    /* JADX INFO: renamed from: d */
    public abstract AbstractC4519n<V> mo6249d();

    @Override // java.util.Map
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public AbstractC4527r<Map.Entry<K, V>> entrySet() {
        AbstractC4527r<Map.Entry<K, V>> abstractC4527r = this.f12049j;
        if (abstractC4527r != null) {
            return abstractC4527r;
        }
        AbstractC4527r<Map.Entry<K, V>> abstractC4527rMo6247b = mo6247b();
        this.f12049j = abstractC4527rMo6247b;
        return abstractC4527rMo6247b;
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

    /* JADX INFO: renamed from: f */
    public abstract boolean mo6250f();

    @Override // java.util.Map
    public abstract V get(@NullableDecl Object obj);

    @Override // java.util.Map
    public final V getOrDefault(@NullableDecl Object obj, @NullableDecl V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    @Override // java.util.Map
    public int hashCode() {
        return C4507h.m6238a(entrySet());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public Set keySet() {
        AbstractC4527r<K> abstractC4527r = this.f12050k;
        if (abstractC4527r != null) {
            return abstractC4527r;
        }
        AbstractC4527r<K> abstractC4527rMo6248c = mo6248c();
        this.f12050k = abstractC4527rMo6248c;
        return abstractC4527rMo6248c;
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
        C3404f.m4189A(size, "size");
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
        AbstractC4519n<V> abstractC4519n = this.f12051l;
        if (abstractC4519n != null) {
            return abstractC4519n;
        }
        AbstractC4519n<V> abstractC4519nMo6249d = mo6249d();
        this.f12051l = abstractC4519nMo6249d;
        return abstractC4519nMo6249d;
    }

    public Object writeReplace() {
        return new b(this);
    }
}
