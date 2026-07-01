package d0.e0.p.d.m0.i;

import java.util.Map$Entry;

/* JADX INFO: compiled from: LazyField.java */
/* JADX INFO: loaded from: classes3.dex */
public class i$b<K> implements Map$Entry<K, Object> {
    public Map$Entry<K, i> j;

    public i$b(Map$Entry map$Entry, i$a i_a) {
        this.j = map$Entry;
    }

    @Override // java.util.Map$Entry
    public K getKey() {
        return this.j.getKey();
    }

    @Override // java.util.Map$Entry
    public Object getValue() {
        i value = this.j.getValue();
        if (value == null) {
            return null;
        }
        return value.getValue();
    }

    @Override // java.util.Map$Entry
    public Object setValue(Object obj) {
        if (obj instanceof n) {
            return this.j.getValue().setValue((n) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
