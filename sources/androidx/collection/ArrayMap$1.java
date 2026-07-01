package androidx.collection;

import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: loaded from: classes.dex */
public class ArrayMap$1<K, V> extends MapCollections<K, V> {
    public final /* synthetic */ ArrayMap this$0;

    public ArrayMap$1(ArrayMap arrayMap) {
        this.this$0 = arrayMap;
    }

    @Override // androidx.collection.MapCollections
    public void colClear() {
        this.this$0.clear();
    }

    @Override // androidx.collection.MapCollections
    public Object colGetEntry(int i, int i2) {
        return this.this$0.mArray[(i << 1) + i2];
    }

    @Override // androidx.collection.MapCollections
    public Map<K, V> colGetMap() {
        return this.this$0;
    }

    @Override // androidx.collection.MapCollections
    public int colGetSize() {
        return this.this$0.mSize;
    }

    @Override // androidx.collection.MapCollections
    public int colIndexOfKey(Object obj) {
        return this.this$0.indexOfKey(obj);
    }

    @Override // androidx.collection.MapCollections
    public int colIndexOfValue(Object obj) {
        return this.this$0.indexOfValue(obj);
    }

    @Override // androidx.collection.MapCollections
    public void colPut(K k, V v) {
        this.this$0.put(k, v);
    }

    @Override // androidx.collection.MapCollections
    public void colRemoveAt(int i) {
        this.this$0.removeAt(i);
    }

    @Override // androidx.collection.MapCollections
    public V colSetValue(int i, V v) {
        return this.this$0.setValueAt(i, v);
    }
}
