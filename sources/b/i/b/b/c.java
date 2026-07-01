package b.i.b.b;

import java.util.Collection;
import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: AbstractListMultimap.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c<K, V> extends e<K, V> implements b0 {
    private static final long serialVersionUID = 6588350623831699109L;

    public c(Map<K, Collection<V>> map) {
        super(map);
    }

    @Override // b.i.b.b.g, b.i.b.b.b0
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

    @Override // b.i.b.b.g
    public boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }
}
