package d0.e0.p.d.m0.i;

import java.util.Iterator;
import java.util.Map$Entry;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: compiled from: SmallSortedMap.java */
/* JADX INFO: loaded from: classes3.dex */
public class t$c<K, V> implements Iterator<Map$Entry<K, V>> {
    public int j = -1;
    public boolean k;
    public Iterator<Map$Entry<K, V>> l;
    public final /* synthetic */ t m;

    public t$c(t tVar, s sVar) {
        this.m = tVar;
    }

    public final Iterator<Map$Entry<K, V>> a() {
        if (this.l == null) {
            this.l = this.m.m.entrySet().iterator();
        }
        return this.l;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.j + 1 < this.m.l.size() || a().hasNext();
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Object next() {
        return next();
    }

    @Override // java.util.Iterator
    public void remove() {
        if (!this.k) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.k = false;
        t tVar = this.m;
        int i = t.j;
        tVar.b();
        if (this.j >= this.m.l.size()) {
            a().remove();
            return;
        }
        t tVar2 = this.m;
        int i2 = this.j;
        this.j = i2 - 1;
        tVar2.d(i2);
    }

    @Override // java.util.Iterator
    public Map$Entry<K, V> next() {
        this.k = true;
        int i = this.j + 1;
        this.j = i;
        return i < this.m.l.size() ? this.m.l.get(this.j) : a().next();
    }
}
