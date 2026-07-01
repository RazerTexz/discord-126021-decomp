package androidx.arch.core.internal;

import androidx.annotation.NonNull;
import java.util.Map$Entry;

/* JADX INFO: loaded from: classes.dex */
public class SafeIterableMap$Entry<K, V> implements Map$Entry<K, V> {

    @NonNull
    public final K mKey;
    public SafeIterableMap$Entry<K, V> mNext;
    public SafeIterableMap$Entry<K, V> mPrevious;

    @NonNull
    public final V mValue;

    public SafeIterableMap$Entry(@NonNull K k, @NonNull V v) {
        this.mKey = k;
        this.mValue = v;
    }

    @Override // java.util.Map$Entry
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SafeIterableMap$Entry)) {
            return false;
        }
        SafeIterableMap$Entry safeIterableMap$Entry = (SafeIterableMap$Entry) obj;
        return this.mKey.equals(safeIterableMap$Entry.mKey) && this.mValue.equals(safeIterableMap$Entry.mValue);
    }

    @Override // java.util.Map$Entry
    @NonNull
    public K getKey() {
        return this.mKey;
    }

    @Override // java.util.Map$Entry
    @NonNull
    public V getValue() {
        return this.mValue;
    }

    @Override // java.util.Map$Entry
    public int hashCode() {
        return this.mKey.hashCode() ^ this.mValue.hashCode();
    }

    @Override // java.util.Map$Entry
    public V setValue(V v) {
        throw new UnsupportedOperationException("An entry modification is not supported");
    }

    public String toString() {
        return this.mKey + "=" + this.mValue;
    }
}
