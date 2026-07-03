package p007b.p225i.p355b.p357b;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p355b.p357b.AbstractC4501e;

/* JADX INFO: renamed from: b.i.b.b.x */
/* JADX INFO: compiled from: Maps.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4535x<K, V> extends AbstractC4522o0<Map.Entry<K, V>> {
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        AbstractC4501e.a.this.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean contains(Object obj);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return AbstractC4501e.a.this.isEmpty();
    }

    @Override // p007b.p225i.p355b.p357b.AbstractC4522o0, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        try {
            Objects.requireNonNull(collection);
            return super.removeAll(collection);
        } catch (UnsupportedOperationException unused) {
            return C4507h.m6241d(this, collection.iterator());
        }
    }

    @Override // p007b.p225i.p355b.p357b.AbstractC4522o0, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        int i;
        try {
            Objects.requireNonNull(collection);
            return super.retainAll(collection);
        } catch (UnsupportedOperationException unused) {
            int size = collection.size();
            if (size < 3) {
                C3404f.m4189A(size, "expectedSize");
                i = size + 1;
            } else {
                i = size < 1073741824 ? (int) ((size / 0.75f) + 1.0f) : Integer.MAX_VALUE;
            }
            HashSet hashSet = new HashSet(i);
            for (Object obj : collection) {
                if (contains(obj)) {
                    hashSet.add(((Map.Entry) obj).getKey());
                }
            }
            return AbstractC4501e.a.this.keySet().retainAll(hashSet);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return AbstractC4501e.a.this.size();
    }
}
