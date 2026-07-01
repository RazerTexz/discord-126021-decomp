package b.f.j.c;

import b.f.d.d.Predicate2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: renamed from: b.f.j.c.l, reason: use source file name */
/* JADX INFO: compiled from: CountingLruMap.java */
/* JADX INFO: loaded from: classes.dex */
public class CountingLruMap<K, V> {
    public final ValueDescriptor<V> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap<K, V> f557b = new LinkedHashMap<>();
    public int c = 0;

    public CountingLruMap(ValueDescriptor<V> valueDescriptor) {
        this.a = valueDescriptor;
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

    public synchronized ArrayList<V> f(Predicate2<K> predicate2) {
        ArrayList<V> arrayList;
        arrayList = new ArrayList<>();
        Iterator<Map.Entry<K, V>> it = this.f557b.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (predicate2 != null) {
            }
            arrayList.add(next.getValue());
            this.c -= c(next.getValue());
            it.remove();
        }
        return arrayList;
    }
}
