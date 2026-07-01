package b.i.b.b;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map$Entry;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

/* JADX INFO: compiled from: Maps.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a0<K, V> extends AbstractMap<K, V> {

    @MonotonicNonNullDecl
    public transient Set<Map$Entry<K, V>> j;

    @MonotonicNonNullDecl
    public transient Collection<V> k;

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map$Entry<K, V>> entrySet() {
        Set<Map$Entry<K, V>> set = this.j;
        if (set != null) {
            return set;
        }
        e$a$a e_a_a = new e$a$a((e$a) this);
        this.j = e_a_a;
        return e_a_a;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.k;
        if (collection != null) {
            return collection;
        }
        z zVar = new z(this);
        this.k = zVar;
        return zVar;
    }
}
