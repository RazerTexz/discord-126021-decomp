package b.f.j.c;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map$Entry;

/* JADX INFO: compiled from: CountingLruMap.java */
/* JADX INFO: loaded from: classes.dex */
public class l<K, V> {
    public final b0<V> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap<K, V> f557b = new LinkedHashMap<>();
    public int c = 0;

    public l(b0<V> b0Var) {
        this.a = b0Var;
    }

    public synchronized int a() {
        return this.f557b.size();
    }

    public synchronized int b() {
        return this.c;
    }

    public final int c(V v) {
        if (v == null) {
            return 0;
        }
        return this.a.a(v);
    }

    public synchronized V d(K k, V v) {
        V vRemove;
        vRemove = this.f557b.remove(k);
        this.c -= c(vRemove);
        this.f557b.put(k, v);
        this.c += c(v);
        return vRemove;
    }

    public synchronized V e(K k) {
        V vRemove;
        vRemove = this.f557b.remove(k);
        this.c -= c(vRemove);
        return vRemove;
    }

    public synchronized ArrayList<V> f(b.f.d.d.j<K> jVar) {
        ArrayList<V> arrayList;
        arrayList = new ArrayList<>();
        Iterator<Map$Entry<K, V>> it = this.f557b.entrySet().iterator();
        while (it.hasNext()) {
            Map$Entry<K, V> next = it.next();
            if (jVar != null) {
            }
            arrayList.add(next.getValue());
            this.c -= c(next.getValue());
            it.remove();
        }
        return arrayList;
    }
}
