package d0.e0.p.d.m0.i;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: d0.e0.p.d.m0.i.i, reason: use source file name */
/* JADX INFO: compiled from: LazyField.java */
/* JADX INFO: loaded from: classes3.dex */
public class LazyField extends LazyFieldLite {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.i$b */
    /* JADX INFO: compiled from: LazyField.java */
    public static class b<K> implements Map.Entry<K, Object> {
        public Map.Entry<K, LazyField> j;

        public b(Map.Entry entry, a aVar) {
            this.j = entry;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.j.getKey();
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            LazyField value = this.j.getValue();
            if (value == null) {
                return null;
            }
            return value.getValue();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj instanceof MessageLite) {
                return this.j.getValue().setValue((MessageLite) obj);
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.i$c */
    /* JADX INFO: compiled from: LazyField.java */
    public static class c<K> implements Iterator<Map.Entry<K, Object>> {
        public Iterator<Map.Entry<K, Object>> j;

        public c(Iterator<Map.Entry<K, Object>> it) {
            this.j = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.j.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.j.remove();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, Object> next() {
            Map.Entry<K, Object> next = this.j.next();
            return next.getValue() instanceof LazyField ? new b(next, null) : next;
        }
    }

    public boolean equals(Object obj) {
        return getValue().equals(obj);
    }

    public MessageLite getValue() {
        return getValue(null);
    }

    public int hashCode() {
        return getValue().hashCode();
    }

    public String toString() {
        return getValue().toString();
    }
}
