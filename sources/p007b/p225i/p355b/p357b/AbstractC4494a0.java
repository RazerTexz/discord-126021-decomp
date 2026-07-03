package p007b.p225i.p355b.p357b;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import p007b.p225i.p355b.p357b.AbstractC4501e;
import p007b.p225i.p355b.p357b.AbstractC4501e.a.C13230a;

/* JADX INFO: renamed from: b.i.b.b.a0 */
/* JADX INFO: compiled from: Maps.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4494a0<K, V> extends AbstractMap<K, V> {

    /* JADX INFO: renamed from: j */
    @MonotonicNonNullDecl
    public transient Set<Map.Entry<K, V>> f11968j;

    /* JADX INFO: renamed from: k */
    @MonotonicNonNullDecl
    public transient Collection<V> f11969k;

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.f11968j;
        if (set != null) {
            return set;
        }
        AbstractC4501e.a.C13230a c13230a = ((AbstractC4501e.a) this).new C13230a();
        this.f11968j = c13230a;
        return c13230a;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.f11969k;
        if (collection != null) {
            return collection;
        }
        C4537z c4537z = new C4537z(this);
        this.f11969k = c4537z;
        return c4537z;
    }
}
