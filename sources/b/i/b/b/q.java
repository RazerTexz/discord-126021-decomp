package b.i.b.b;

import com.discord.api.permission.Permission;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;
import java.util.SortedMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: ImmutableMap.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class q<K, V> implements Map<K, V>, Serializable {

    @LazyInit
    public transient r<Map$Entry<K, V>> j;

    @RetainedWith
    @LazyInit
    public transient r<K> k;

    @RetainedWith
    @LazyInit
    public transient n<V> l;

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> q<K, V> a(Map<? extends K, ? extends V> map) {
        if ((map instanceof q) && !(map instanceof SortedMap)) {
            q<K, V> qVar = (q) map;
            if (!qVar.f()) {
                return qVar;
            }
        }
        Set<Map$Entry<? extends K, ? extends V>> setEntrySet = map.entrySet();
        boolean z2 = setEntrySet instanceof Collection;
        q$a q_a = new q$a(z2 ? setEntrySet.size() : 4);
        if (z2) {
            q_a.b(setEntrySet.size() + q_a.f1648b);
        }
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map$Entry map$Entry = (Map$Entry) it.next();
            q_a.c(map$Entry.getKey(), map$Entry.getValue());
        }
        return q_a.a();
    }

    public abstract r<Map$Entry<K, V>> b();

    public abstract r<K> c();

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
        n<V> nVarD = this.l;
        if (nVarD == null) {
            nVarD = d();
            this.l = nVarD;
        }
        return nVarD.contains(obj);
    }

    public abstract n<V> d();

    public r<Map$Entry<K, V>> e() {
        r<Map$Entry<K, V>> rVar = this.j;
        if (rVar != null) {
            return rVar;
        }
        r<Map$Entry<K, V>> rVarB = b();
        this.j = rVarB;
        return rVarB;
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return e();
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
        return h.a(e());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public Set keySet() {
        r<K> rVar = this.k;
        if (rVar != null) {
            return rVar;
        }
        r<K> rVarC = c();
        this.k = rVarC;
        return rVarC;
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
        for (Map$Entry map$Entry : entrySet()) {
            if (!z2) {
                sb.append(", ");
            }
            z2 = false;
            sb.append(map$Entry.getKey());
            sb.append('=');
            sb.append(map$Entry.getValue());
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // java.util.Map
    public Collection values() {
        n<V> nVar = this.l;
        if (nVar != null) {
            return nVar;
        }
        n<V> nVarD = d();
        this.l = nVarD;
        return nVarD;
    }

    public Object writeReplace() {
        return new q$b(this);
    }
}
