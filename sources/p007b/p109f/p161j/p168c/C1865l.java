package p007b.p109f.p161j.p168c;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import p007b.p109f.p115d.p119d.InterfaceC1687j;

/* JADX INFO: renamed from: b.f.j.c.l */
/* JADX INFO: compiled from: CountingLruMap.java */
/* JADX INFO: loaded from: classes.dex */
public class C1865l<K, V> {

    /* JADX INFO: renamed from: a */
    public final InterfaceC1855b0<V> f3675a;

    /* JADX INFO: renamed from: b */
    public final LinkedHashMap<K, V> f3676b = new LinkedHashMap<>();

    /* JADX INFO: renamed from: c */
    public int f3677c = 0;

    public C1865l(InterfaceC1855b0<V> interfaceC1855b0) {
        this.f3675a = interfaceC1855b0;
    }

    /* JADX INFO: renamed from: a */
    public synchronized int m1221a() {
        return this.f3676b.size();
    }

    /* JADX INFO: renamed from: b */
    public synchronized int m1222b() {
        return this.f3677c;
    }

    /* JADX INFO: renamed from: c */
    public final int m1223c(V v) {
        if (v == null) {
            return 0;
        }
        return this.f3675a.mo1212a(v);
    }

    /* JADX INFO: renamed from: d */
    public synchronized V m1224d(K k, V v) {
        V vRemove;
        vRemove = this.f3676b.remove(k);
        this.f3677c -= m1223c(vRemove);
        this.f3676b.put(k, v);
        this.f3677c += m1223c(v);
        return vRemove;
    }

    /* JADX INFO: renamed from: e */
    public synchronized V m1225e(K k) {
        V vRemove;
        vRemove = this.f3676b.remove(k);
        this.f3677c -= m1223c(vRemove);
        return vRemove;
    }

    /* JADX INFO: renamed from: f */
    public synchronized ArrayList<V> m1226f(InterfaceC1687j<K> interfaceC1687j) {
        ArrayList<V> arrayList;
        arrayList = new ArrayList<>();
        Iterator<Map.Entry<K, V>> it = this.f3676b.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (interfaceC1687j != null) {
            }
            arrayList.add(next.getValue());
            this.f3677c -= m1223c(next.getValue());
            it.remove();
        }
        return arrayList;
    }
}
