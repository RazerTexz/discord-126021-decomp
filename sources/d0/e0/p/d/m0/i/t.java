package d0.e0.p.d.m0.i;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: SmallSortedMap.java */
/* JADX INFO: loaded from: classes3.dex */
public class t<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    public static final /* synthetic */ int j = 0;
    public final int k;
    public List<t<K, V>.t$b> l = Collections.emptyList();
    public Map<K, V> m = Collections.emptyMap();
    public boolean n;

    /* JADX WARN: Incorrect inner types in field signature: Ld0/e0/p/d/m0/i/t<TK;TV;>.d; */
    public volatile t$d o;

    public t(int i, s sVar) {
        this.k = i;
    }

    public final int a(K k) {
        int size = this.l.size() - 1;
        if (size >= 0) {
            int iCompareTo = k.compareTo(this.l.get(size).getKey());
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
            int iCompareTo2 = k.compareTo(this.l.get(i2).getKey());
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

    public final void b() {
        if (this.n) {
            throw new UnsupportedOperationException();
        }
    }

    public final SortedMap<K, V> c() {
        b();
        if (this.m.isEmpty() && !(this.m instanceof TreeMap)) {
            this.m = new TreeMap();
        }
        return (SortedMap) this.m;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        b();
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

    public final V d(int i) {
        b();
        V value = this.l.remove(i).getValue();
        if (!this.m.isEmpty()) {
            Iterator<Map$Entry<K, V>> it = c().entrySet().iterator();
            this.l.add(new t$b(this, it.next()));
            it.remove();
        }
        return value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map$Entry<K, V>> entrySet() {
        if (this.o == null) {
            this.o = new t$d(this, null);
        }
        return this.o;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        return iA >= 0 ? this.l.get(iA).getValue() : this.m.get(comparable);
    }

    public Map$Entry<K, V> getArrayEntryAt(int i) {
        return this.l.get(i);
    }

    public int getNumArrayEntries() {
        return this.l.size();
    }

    public Iterable<Map$Entry<K, V>> getOverflowEntries() {
        return this.m.isEmpty() ? (Iterable<Map$Entry<K, V>>) t$a.f3433b : this.m.entrySet();
    }

    public boolean isImmutable() {
        return this.n;
    }

    public void makeImmutable() {
        if (this.n) {
            return;
        }
        this.m = this.m.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.m);
        this.n = true;
    }

    public V put(K k, V v) {
        b();
        int iA = a(k);
        if (iA >= 0) {
            return this.l.get(iA).setValue(v);
        }
        b();
        if (this.l.isEmpty() && !(this.l instanceof ArrayList)) {
            this.l = new ArrayList(this.k);
        }
        int i = -(iA + 1);
        if (i >= this.k) {
            return c().put(k, v);
        }
        int size = this.l.size();
        int i2 = this.k;
        if (size == i2) {
            t<K, V>.t$b t_bRemove = this.l.remove(i2 - 1);
            c().put(t_bRemove.getKey(), t_bRemove.getValue());
        }
        this.l.add(i, new t$b(this, k, v));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        b();
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        if (iA >= 0) {
            return d(iA);
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
