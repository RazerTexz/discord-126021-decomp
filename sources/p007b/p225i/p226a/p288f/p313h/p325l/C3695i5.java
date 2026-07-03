package p007b.p225i.p226a.p288f.p313h.p325l;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: b.i.a.f.h.l.i5 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3695i5<K> implements Iterator<Map.Entry<K, Object>> {

    /* JADX INFO: renamed from: j */
    public Iterator<Map.Entry<K, Object>> f10009j;

    public C3695i5(Iterator<Map.Entry<K, Object>> it) {
        this.f10009j = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f10009j.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Map.Entry<K, Object> next = this.f10009j.next();
        return next.getValue() instanceof C3625d5 ? new C3653f5(next, null) : next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f10009j.remove();
    }
}
