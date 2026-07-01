package d0.e0.p.d.m0.i;

import java.util.Iterator;
import java.util.Map$Entry;

/* JADX INFO: compiled from: LazyField.java */
/* JADX INFO: loaded from: classes3.dex */
public class i$c<K> implements Iterator<Map$Entry<K, Object>> {
    public Iterator<Map$Entry<K, Object>> j;

    public i$c(Iterator<Map$Entry<K, Object>> it) {
        this.j = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.j.hasNext();
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Object next() {
        return next();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.j.remove();
    }

    @Override // java.util.Iterator
    public Map$Entry<K, Object> next() {
        Map$Entry<K, Object> next = this.j.next();
        return next.getValue() instanceof i ? new i$b(next, null) : next;
    }
}
