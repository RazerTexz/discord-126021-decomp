package b.i.b.b;

import java.util.Collection;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.SortedMap;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: AbstractMultimap.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g<K, V> implements b0<K, V> {

    @MonotonicNonNullDecl
    public transient Set<K> j;

    @MonotonicNonNullDecl
    public transient Collection<V> k;

    @MonotonicNonNullDecl
    public transient Map<K, Collection<V>> l;

    @Override // b.i.b.b.b0
    public Map<K, Collection<V>> a() {
        Map<K, Collection<V>> e_g;
        Map<K, Collection<V>> map = this.l;
        if (map == null) {
            d0 d0Var = (d0) this;
            Map<K, Collection<V>> map2 = d0Var.m;
            if (map2 instanceof NavigableMap) {
                e_g = new e$d<>(d0Var, (NavigableMap) d0Var.m);
            } else {
                e_g = map2 instanceof SortedMap ? new e$g<>(d0Var, (SortedMap) d0Var.m) : new e$a<>(d0Var, d0Var.m);
            }
            map = e_g;
            this.l = map;
        }
        return map;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0) {
            return ((c) this).a().equals(((b0) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return a().toString();
    }
}
