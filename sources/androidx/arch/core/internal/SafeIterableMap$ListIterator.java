package androidx.arch.core.internal;

import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.Map$Entry;

/* JADX INFO: loaded from: classes.dex */
public abstract class SafeIterableMap$ListIterator<K, V> implements Iterator<Map$Entry<K, V>>, SafeIterableMap$SupportRemove<K, V> {
    public SafeIterableMap$Entry<K, V> mExpectedEnd;
    public SafeIterableMap$Entry<K, V> mNext;

    public SafeIterableMap$ListIterator(SafeIterableMap$Entry<K, V> safeIterableMap$Entry, SafeIterableMap$Entry<K, V> safeIterableMap$Entry2) {
        this.mExpectedEnd = safeIterableMap$Entry2;
        this.mNext = safeIterableMap$Entry;
    }

    private SafeIterableMap$Entry<K, V> nextNode() {
        SafeIterableMap$Entry<K, V> safeIterableMap$Entry = this.mNext;
        SafeIterableMap$Entry<K, V> safeIterableMap$Entry2 = this.mExpectedEnd;
        if (safeIterableMap$Entry == safeIterableMap$Entry2 || safeIterableMap$Entry2 == null) {
            return null;
        }
        return forward(safeIterableMap$Entry);
    }

    public abstract SafeIterableMap$Entry<K, V> backward(SafeIterableMap$Entry<K, V> safeIterableMap$Entry);

    public abstract SafeIterableMap$Entry<K, V> forward(SafeIterableMap$Entry<K, V> safeIterableMap$Entry);

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.mNext != null;
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Object next() {
        return next();
    }

    @Override // androidx.arch.core.internal.SafeIterableMap$SupportRemove
    public void supportRemove(@NonNull SafeIterableMap$Entry<K, V> safeIterableMap$Entry) {
        if (this.mExpectedEnd == safeIterableMap$Entry && safeIterableMap$Entry == this.mNext) {
            this.mNext = null;
            this.mExpectedEnd = null;
        }
        SafeIterableMap$Entry<K, V> safeIterableMap$Entry2 = this.mExpectedEnd;
        if (safeIterableMap$Entry2 == safeIterableMap$Entry) {
            this.mExpectedEnd = backward(safeIterableMap$Entry2);
        }
        if (this.mNext == safeIterableMap$Entry) {
            this.mNext = nextNode();
        }
    }

    @Override // java.util.Iterator
    public Map$Entry<K, V> next() {
        SafeIterableMap$Entry<K, V> safeIterableMap$Entry = this.mNext;
        this.mNext = nextNode();
        return safeIterableMap$Entry;
    }
}
