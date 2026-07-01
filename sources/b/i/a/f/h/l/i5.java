package b.i.a.f.h.l;

import java.util.Iterator;
import java.util.Map$Entry;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class i5<K> implements Iterator<Map$Entry<K, Object>> {
    public Iterator<Map$Entry<K, Object>> j;

    public i5(Iterator<Map$Entry<K, Object>> it) {
        this.j = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.j.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Map$Entry<K, Object> next = this.j.next();
        return next.getValue() instanceof d5 ? new f5(next, null) : next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.j.remove();
    }
}
