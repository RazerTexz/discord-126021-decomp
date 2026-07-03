package p507d0.p513e0.p514p.p515d.p517m0.p550i;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: d0.e0.p.d.m0.i.i */
/* JADX INFO: compiled from: LazyField.java */
/* JADX INFO: loaded from: classes3.dex */
public class C11729i extends C11730j {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.i$b */
    /* JADX INFO: compiled from: LazyField.java */
    public static class b<K> implements Map.Entry<K, Object> {

        /* JADX INFO: renamed from: j */
        public Map.Entry<K, C11729i> f24143j;

        public b(Map.Entry entry, a aVar) {
            this.f24143j = entry;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f24143j.getKey();
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            C11729i value = this.f24143j.getValue();
            if (value == null) {
                return null;
            }
            return value.getValue();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj instanceof InterfaceC11734n) {
                return this.f24143j.getValue().setValue((InterfaceC11734n) obj);
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.i$c */
    /* JADX INFO: compiled from: LazyField.java */
    public static class c<K> implements Iterator<Map.Entry<K, Object>> {

        /* JADX INFO: renamed from: j */
        public Iterator<Map.Entry<K, Object>> f24144j;

        public c(Iterator<Map.Entry<K, Object>> it) {
            this.f24144j = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f24144j.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f24144j.remove();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, Object> next() {
            Map.Entry<K, Object> next = this.f24144j.next();
            return next.getValue() instanceof C11729i ? new b(next, null) : next;
        }
    }

    public boolean equals(Object obj) {
        return getValue().equals(obj);
    }

    public InterfaceC11734n getValue() {
        return getValue(null);
    }

    public int hashCode() {
        return getValue().hashCode();
    }

    public String toString() {
        return getValue().toString();
    }
}
