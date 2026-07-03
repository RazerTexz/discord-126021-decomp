package p007b.p225i.p355b.p357b;

import java.util.Collection;
import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import p007b.p225i.p355b.p357b.AbstractC4501e;

/* JADX INFO: renamed from: b.i.b.b.c */
/* JADX INFO: compiled from: AbstractListMultimap.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4497c<K, V> extends AbstractC4501e<K, V> implements InterfaceC4496b0 {
    private static final long serialVersionUID = 6588350623831699109L;

    public AbstractC4497c(Map<K, Collection<V>> map) {
        super(map);
    }

    @Override // p007b.p225i.p355b.p357b.AbstractC4505g, p007b.p225i.p355b.p357b.InterfaceC4496b0
    /* JADX INFO: renamed from: a */
    public Map<K, Collection<V>> mo6216a() {
        Map<K, Collection<V>> gVar;
        Map<K, Collection<V>> map = this.f12008l;
        if (map == null) {
            C4500d0 c4500d0 = (C4500d0) this;
            Map<K, Collection<V>> map2 = c4500d0.f11973m;
            if (map2 instanceof NavigableMap) {
                gVar = new AbstractC4501e.d((NavigableMap) c4500d0.f11973m);
            } else {
                gVar = map2 instanceof SortedMap ? new AbstractC4501e.g((SortedMap) c4500d0.f11973m) : new AbstractC4501e.a(c4500d0.f11973m);
            }
            map = gVar;
            this.f12008l = map;
        }
        return map;
    }

    @Override // p007b.p225i.p355b.p357b.AbstractC4505g
    public boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }
}
