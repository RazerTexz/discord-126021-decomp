package androidx.collection;

import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: loaded from: classes.dex */
public class ArraySet$1<E> extends MapCollections<E, E> {
    public final /* synthetic */ ArraySet this$0;

    public ArraySet$1(ArraySet arraySet) {
        this.this$0 = arraySet;
    }

    @Override // androidx.collection.MapCollections
    public void colClear() {
        this.this$0.clear();
    }

    @Override // androidx.collection.MapCollections
    public Object colGetEntry(int i, int i2) {
        return this.this$0.mArray[i];
    }

    @Override // androidx.collection.MapCollections
    public Map<E, E> colGetMap() {
        throw new UnsupportedOperationException("not a map");
    }

    @Override // androidx.collection.MapCollections
    public int colGetSize() {
        return this.this$0.mSize;
    }

    @Override // androidx.collection.MapCollections
    public int colIndexOfKey(Object obj) {
        return this.this$0.indexOf(obj);
    }

    @Override // androidx.collection.MapCollections
    public int colIndexOfValue(Object obj) {
        return this.this$0.indexOf(obj);
    }

    @Override // androidx.collection.MapCollections
    public void colPut(E e, E e2) {
        this.this$0.add(e);
    }

    @Override // androidx.collection.MapCollections
    public void colRemoveAt(int i) {
        this.this$0.removeAt(i);
    }

    @Override // androidx.collection.MapCollections
    public E colSetValue(int i, E e) {
        throw new UnsupportedOperationException("not a map");
    }
}
