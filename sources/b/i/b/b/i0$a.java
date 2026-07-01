package b.i.b.b;

import java.util.Iterator;
import java.util.Map$Entry;

/* JADX INFO: compiled from: RegularImmutableMap.java */
/* JADX INFO: loaded from: classes3.dex */
public class i0$a<K, V> extends r<Map$Entry<K, V>> {
    public final transient q<K, V> m;
    public final transient Object[] n;
    public final transient int o;
    public final transient int p;

    public i0$a(q<K, V> qVar, Object[] objArr, int i, int i2) {
        this.m = qVar;
        this.n = objArr;
        this.o = i;
        this.p = i2;
    }

    @Override // b.i.b.b.n, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (!(obj instanceof Map$Entry)) {
            return false;
        }
        Map$Entry map$Entry = (Map$Entry) obj;
        Object key = map$Entry.getKey();
        Object value = map$Entry.getValue();
        return value != null && value.equals(this.m.get(key));
    }

    @Override // b.i.b.b.n
    public int d(Object[] objArr, int i) {
        return c().d(objArr, i);
    }

    @Override // b.i.b.b.n
    public boolean i() {
        return true;
    }

    @Override // b.i.b.b.r, b.i.b.b.n, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return j();
    }

    @Override // b.i.b.b.n
    public s0<Map$Entry<K, V>> j() {
        return c().p();
    }

    @Override // b.i.b.b.r
    public p<Map$Entry<K, V>> o() {
        return new i0$a$a(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.p;
    }
}
