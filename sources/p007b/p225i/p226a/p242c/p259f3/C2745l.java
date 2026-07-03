package p007b.p225i.p226a.p242c.p259f3;

import androidx.annotation.GuardedBy;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: b.i.a.c.f3.l */
/* JADX INFO: compiled from: CopyOnWriteMultiset.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2745l<E> implements Iterable<E> {

    /* JADX INFO: renamed from: j */
    public final Object f6729j = new Object();

    /* JADX INFO: renamed from: k */
    @GuardedBy("lock")
    public final Map<E, Integer> f6730k = new HashMap();

    /* JADX INFO: renamed from: l */
    @GuardedBy("lock")
    public Set<E> f6731l = Collections.emptySet();

    /* JADX INFO: renamed from: m */
    @GuardedBy("lock")
    public List<E> f6732m = Collections.emptyList();

    /* JADX INFO: renamed from: c */
    public int m3027c(E e) {
        int iIntValue;
        synchronized (this.f6729j) {
            iIntValue = this.f6730k.containsKey(e) ? this.f6730k.get(e).intValue() : 0;
        }
        return iIntValue;
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        Iterator<E> it;
        synchronized (this.f6729j) {
            it = this.f6732m.iterator();
        }
        return it;
    }
}
