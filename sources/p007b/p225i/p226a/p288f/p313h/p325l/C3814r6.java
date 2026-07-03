package p007b.p225i.p226a.p288f.p313h.p325l;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: renamed from: b.i.a.f.h.l.r6 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C3814r6<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ int f10288j = 0;

    /* JADX INFO: renamed from: k */
    public final int f10289k;

    /* JADX INFO: renamed from: n */
    public boolean f10292n;

    /* JADX INFO: renamed from: o */
    public volatile C3585a7 f10293o;

    /* JADX INFO: renamed from: l */
    public List<C3905y6> f10290l = Collections.emptyList();

    /* JADX INFO: renamed from: m */
    public Map<K, V> f10291m = Collections.emptyMap();

    /* JADX INFO: renamed from: p */
    public Map<K, V> f10294p = Collections.emptyMap();

    public C3814r6(int i, C3840t6 c3840t6) {
        this.f10289k = i;
    }

    /* JADX INFO: renamed from: a */
    public final int m5203a(K k) {
        int size = this.f10290l.size() - 1;
        if (size >= 0) {
            int iCompareTo = k.compareTo(this.f10290l.get(size).f10425j);
            if (iCompareTo > 0) {
                return -(size + 2);
            }
            if (iCompareTo == 0) {
                return size;
            }
        }
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) / 2;
            int iCompareTo2 = k.compareTo(this.f10290l.get(i2).f10425j);
            if (iCompareTo2 < 0) {
                size = i2 - 1;
            } else {
                if (iCompareTo2 <= 0) {
                    return i2;
                }
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final V put(K k, V v) {
        m5210h();
        int iM5203a = m5203a(k);
        if (iM5203a >= 0) {
            C3905y6 c3905y6 = this.f10290l.get(iM5203a);
            c3905y6.f10427l.m5210h();
            V v2 = c3905y6.f10426k;
            c3905y6.f10426k = v;
            return v2;
        }
        m5210h();
        if (this.f10290l.isEmpty() && !(this.f10290l instanceof ArrayList)) {
            this.f10290l = new ArrayList(this.f10289k);
        }
        int i = -(iM5203a + 1);
        if (i >= this.f10289k) {
            return m5211i().put(k, v);
        }
        int size = this.f10290l.size();
        int i2 = this.f10289k;
        if (size == i2) {
            C3905y6 c3905y6Remove = this.f10290l.remove(i2 - 1);
            m5211i().put(c3905y6Remove.f10425j, c3905y6Remove.f10426k);
        }
        this.f10290l.add(i, new C3905y6(this, k, v));
        return null;
    }

    /* JADX INFO: renamed from: c */
    public void mo5205c() {
        if (this.f10292n) {
            return;
        }
        this.f10291m = this.f10291m.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f10291m);
        this.f10294p = this.f10294p.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f10294p);
        this.f10292n = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        m5210h();
        if (!this.f10290l.isEmpty()) {
            this.f10290l.clear();
        }
        if (this.f10291m.isEmpty()) {
            return;
        }
        this.f10291m.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return m5203a(comparable) >= 0 || this.f10291m.containsKey(comparable);
    }

    /* JADX INFO: renamed from: d */
    public final Map.Entry<K, V> m5206d(int i) {
        return this.f10290l.get(i);
    }

    /* JADX INFO: renamed from: e */
    public final int m5207e() {
        return this.f10290l.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f10293o == null) {
            this.f10293o = new C3585a7(this, null);
        }
        return this.f10293o;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3814r6)) {
            return super.equals(obj);
        }
        C3814r6 c3814r6 = (C3814r6) obj;
        int size = size();
        if (size != c3814r6.size()) {
            return false;
        }
        int iM5207e = m5207e();
        if (iM5207e != c3814r6.m5207e()) {
            return entrySet().equals(c3814r6.entrySet());
        }
        for (int i = 0; i < iM5207e; i++) {
            if (!m5206d(i).equals(c3814r6.m5206d(i))) {
                return false;
            }
        }
        if (iM5207e != size) {
            return this.f10291m.equals(c3814r6.f10291m);
        }
        return true;
    }

    /* JADX INFO: renamed from: f */
    public final V m5208f(int i) {
        m5210h();
        V v = this.f10290l.remove(i).f10426k;
        if (!this.f10291m.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = m5211i().entrySet().iterator();
            this.f10290l.add(new C3905y6(this, it.next()));
            it.remove();
        }
        return v;
    }

    /* JADX INFO: renamed from: g */
    public final Iterable<Map.Entry<K, V>> m5209g() {
        return this.f10291m.isEmpty() ? (Iterable<Map.Entry<K, V>>) C3853u6.f10351b : this.f10291m.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iM5203a = m5203a(comparable);
        return iM5203a >= 0 ? this.f10290l.get(iM5203a).f10426k : this.f10291m.get(comparable);
    }

    /* JADX INFO: renamed from: h */
    public final void m5210h() {
        if (this.f10292n) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int iM5207e = m5207e();
        int iHashCode = 0;
        for (int i = 0; i < iM5207e; i++) {
            iHashCode += this.f10290l.get(i).hashCode();
        }
        return this.f10291m.size() > 0 ? iHashCode + this.f10291m.hashCode() : iHashCode;
    }

    /* JADX INFO: renamed from: i */
    public final SortedMap<K, V> m5211i() {
        m5210h();
        if (this.f10291m.isEmpty() && !(this.f10291m instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f10291m = treeMap;
            this.f10294p = treeMap.descendingMap();
        }
        return (SortedMap) this.f10291m;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        m5210h();
        Comparable comparable = (Comparable) obj;
        int iM5203a = m5203a(comparable);
        if (iM5203a >= 0) {
            return m5208f(iM5203a);
        }
        if (this.f10291m.isEmpty()) {
            return null;
        }
        return this.f10291m.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f10291m.size() + this.f10290l.size();
    }
}
