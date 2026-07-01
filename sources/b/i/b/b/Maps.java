package b.i.b.b;

import b.i.b.b.AbstractMapBasedMultimap2;
import b.i.b.b.AbstractMapBasedMultimap2.a.C0044a;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

/* JADX INFO: renamed from: b.i.b.b.a0, reason: use source file name */
/* JADX INFO: compiled from: Maps.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Maps<K, V> extends AbstractMap<K, V> {

    @MonotonicNonNullDecl
    public transient Set<Map.Entry<K, V>> j;

    @MonotonicNonNullDecl
    public transient Collection<V> k;

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.j;
        if (set != null) {
            return set;
        }
        AbstractMapBasedMultimap2.a.C0044a c0044a = ((AbstractMapBasedMultimap2.a) this).new C0044a();
        this.j = c0044a;
        return c0044a;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.k;
        if (collection != null) {
            return collection;
        }
        Maps5 maps5 = new Maps5(this);
        this.k = maps5;
        return maps5;
    }
}
