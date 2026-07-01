package b.i.a.c.f3;

import androidx.annotation.GuardedBy;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: b.i.a.c.f3.l, reason: use source file name */
/* JADX INFO: compiled from: CopyOnWriteMultiset.java */
/* JADX INFO: loaded from: classes3.dex */
public final class CopyOnWriteMultiset<E> implements Iterable<E> {
    public final Object j = new Object();

    @GuardedBy("lock")
    public final Map<E, Integer> k = new HashMap();

    @GuardedBy("lock")
    public Set<E> l = Collections.emptySet();

    @GuardedBy("lock")
    public List<E> m = Collections.emptyList();

    public int c(E e) {
        int iIntValue;
        synchronized (this.j) {
            iIntValue = this.k.containsKey(e) ? this.k.get(e).intValue() : 0;
        }
        return iIntValue;
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        Iterator<E> it;
        synchronized (this.j) {
            it = this.m.iterator();
        }
        return it;
    }
}
