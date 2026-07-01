package b.i.a.f.h.l;

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

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class r6<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    public static final /* synthetic */ int j = 0;
    public final int k;
    public boolean n;
    public volatile a7 o;
    public List<y6> l = Collections.emptyList();
    public Map<K, V> m = Collections.emptyMap();
    public Map<K, V> p = Collections.emptyMap();

    public r6(int i, t6 t6Var) {
        this.k = i;
    }

    public final int a(K k) {
        int size = this.l.size() - 1;
        if (size >= 0) {
            int iCompareTo = k.compareTo(this.l.get(size).j);
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
            int iCompareTo2 = k.compareTo(this.l.get(i2).j);
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
        h();
        int iA = a(k);
        if (iA >= 0) {
            y6 y6Var = this.l.get(iA);
            y6Var.l.h();
            V v2 = y6Var.k;
            y6Var.k = v;
            return v2;
        }
        h();
        if (this.l.isEmpty() && !(this.l instanceof ArrayList)) {
            this.l = new ArrayList(this.k);
        }
        int i = -(iA + 1);
        if (i >= this.k) {
            return i().put(k, v);
        }
        int size = this.l.size();
        int i2 = this.k;
        if (size == i2) {
            y6 y6VarRemove = this.l.remove(i2 - 1);
            i().put(y6VarRemove.j, y6VarRemove.k);
        }
        this.l.add(i, new y6(this, k, v));
        return null;
    }

    public void c() {
        if (this.n) {
            return;
        }
        this.m = this.m.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.m);
        this.p = this.p.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.p);
        this.n = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        h();
        if (!this.l.isEmpty()) {
            this.l.clear();
        }
        if (this.m.isEmpty()) {
            return;
        }
        this.m.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.m.containsKey(comparable);
    }

    public final Map.Entry<K, V> d(int i) {
        return this.l.get(i);
    }

    public final int e() {
        return this.l.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.o == null) {
            this.o = new a7(this, null);
        }
        return this.o;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r6)) {
            return super.equals(obj);
        }
        r6 r6Var = (r6) obj;
        int size = size();
        if (size != r6Var.size()) {
            return false;
        }
        int iE = e();
        if (iE != r6Var.e()) {
            return entrySet().equals(r6Var.entrySet());
        }
        for (int i = 0; i < iE; i++) {
            if (!d(i).equals(r6Var.d(i))) {
                return false;
            }
        }
        if (iE != size) {
            return this.m.equals(r6Var.m);
        }
        return true;
    }

    public final V f(int i) {
        h();
        V v = this.l.remove(i).k;
        if (!this.m.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = i().entrySet().iterator();
            this.l.add(new y6(this, it.next()));
            it.remove();
        }
        return v;
    }

    public final Iterable<Map.Entry<K, V>> g() {
        return this.m.isEmpty() ? (Iterable<Map.Entry<K, V>>) u6.f1497b : this.m.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        return iA >= 0 ? this.l.get(iA).k : this.m.get(comparable);
    }

    public final void h() {
        if (this.n) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int iE = e();
        int iHashCode = 0;
        for (int i = 0; i < iE; i++) {
            iHashCode += this.l.get(i).hashCode();
        }
        return this.m.size() > 0 ? iHashCode + this.m.hashCode() : iHashCode;
    }

    public final SortedMap<K, V> i() {
        h();
        if (this.m.isEmpty() && !(this.m instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.m = treeMap;
            this.p = treeMap.descendingMap();
        }
        return (SortedMap) this.m;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        h();
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        if (iA >= 0) {
            return f(iA);
        }
        if (this.m.isEmpty()) {
            return null;
        }
        return this.m.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.m.size() + this.l.size();
    }
}
