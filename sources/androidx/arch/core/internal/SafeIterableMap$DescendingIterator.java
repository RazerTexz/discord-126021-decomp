package androidx.arch.core.internal;

/* JADX INFO: loaded from: classes.dex */
public class SafeIterableMap$DescendingIterator<K, V> extends SafeIterableMap$ListIterator<K, V> {
    public SafeIterableMap$DescendingIterator(SafeIterableMap$Entry<K, V> safeIterableMap$Entry, SafeIterableMap$Entry<K, V> safeIterableMap$Entry2) {
        super(safeIterableMap$Entry, safeIterableMap$Entry2);
    }

    @Override // androidx.arch.core.internal.SafeIterableMap$ListIterator
    public SafeIterableMap$Entry<K, V> backward(SafeIterableMap$Entry<K, V> safeIterableMap$Entry) {
        return safeIterableMap$Entry.mNext;
    }

    @Override // androidx.arch.core.internal.SafeIterableMap$ListIterator
    public SafeIterableMap$Entry<K, V> forward(SafeIterableMap$Entry<K, V> safeIterableMap$Entry) {
        return safeIterableMap$Entry.mPrevious;
    }
}
