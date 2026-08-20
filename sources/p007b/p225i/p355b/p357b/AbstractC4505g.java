package p007b.p225i.p355b.p357b;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: renamed from: b.i.b.b.g */
/* JADX INFO: compiled from: AbstractMultimap.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4505g<K, V> implements InterfaceC4496b0<K, V> {

    /* JADX INFO: renamed from: j */
    @MonotonicNonNullDecl
    public transient Set<K> f12006j;

    /* JADX INFO: renamed from: k */
    @MonotonicNonNullDecl
    public transient Collection<V> f12007k;

    /* JADX INFO: renamed from: l */
    @MonotonicNonNullDecl
    public transient Map<K, Collection<V>> f12008l;

    /* JADX INFO: renamed from: b.i.b.b.g$a */
    /* JADX INFO: compiled from: AbstractMultimap.java */
    public class a extends AbstractCollection<V> {
        public a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            ((AbstractC4501e) AbstractC4505g.this).m6220d();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@NullableDecl Object obj) {
            Iterator<Collection<V>> it = AbstractC4505g.this.mo6216a().values().iterator();
            while (it.hasNext()) {
                if (it.next().contains(obj)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            AbstractC4501e abstractC4501e = (AbstractC4501e) AbstractC4505g.this;
            Objects.requireNonNull(abstractC4501e);
            return new C4499d(abstractC4501e);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return ((AbstractC4501e) AbstractC4505g.this).f11974n;
        }
    }

    @Override // p007b.p225i.p355b.p357b.InterfaceC4496b0
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

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof InterfaceC4496b0) {
            return ((AbstractC4497c) this).mo6216a().equals(((InterfaceC4496b0) obj).mo6216a());
        }
        return false;
    }

    public int hashCode() {
        return mo6216a().hashCode();
    }

    public String toString() {
        return mo6216a().toString();
    }
}
