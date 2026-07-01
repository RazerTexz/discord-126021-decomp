package androidx.arch.core.internal;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import b.d.b.a.a;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
public class SafeIterableMap<K, V> implements Iterable<Map$Entry<K, V>> {
    private SafeIterableMap$Entry<K, V> mEnd;
    private WeakHashMap<SafeIterableMap$SupportRemove<K, V>, Boolean> mIterators = new WeakHashMap<>();
    private int mSize = 0;
    public SafeIterableMap$Entry<K, V> mStart;

    public Iterator<Map$Entry<K, V>> descendingIterator() {
        SafeIterableMap$DescendingIterator safeIterableMap$DescendingIterator = new SafeIterableMap$DescendingIterator(this.mEnd, this.mStart);
        this.mIterators.put(safeIterableMap$DescendingIterator, Boolean.FALSE);
        return safeIterableMap$DescendingIterator;
    }

    public Map$Entry<K, V> eldest() {
        return this.mStart;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SafeIterableMap)) {
            return false;
        }
        SafeIterableMap safeIterableMap = (SafeIterableMap) obj;
        if (size() != safeIterableMap.size()) {
            return false;
        }
        Iterator<Map$Entry<K, V>> it = iterator();
        Iterator<Map$Entry<K, V>> it2 = safeIterableMap.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map$Entry<K, V> next = it.next();
            Map$Entry<K, V> next2 = it2.next();
            if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    public SafeIterableMap$Entry<K, V> get(K k) {
        SafeIterableMap$Entry<K, V> safeIterableMap$Entry = this.mStart;
        while (safeIterableMap$Entry != null && !safeIterableMap$Entry.mKey.equals(k)) {
            safeIterableMap$Entry = safeIterableMap$Entry.mNext;
        }
        return safeIterableMap$Entry;
    }

    public int hashCode() {
        Iterator<Map$Entry<K, V>> it = iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            iHashCode += it.next().hashCode();
        }
        return iHashCode;
    }

    @Override // java.lang.Iterable
    @NonNull
    public Iterator<Map$Entry<K, V>> iterator() {
        SafeIterableMap$AscendingIterator safeIterableMap$AscendingIterator = new SafeIterableMap$AscendingIterator(this.mStart, this.mEnd);
        this.mIterators.put(safeIterableMap$AscendingIterator, Boolean.FALSE);
        return safeIterableMap$AscendingIterator;
    }

    /* JADX WARN: Incorrect inner types in method signature: ()Landroidx/arch/core/internal/SafeIterableMap<TK;TV;>.IteratorWithAdditions; */
    public SafeIterableMap$IteratorWithAdditions iteratorWithAdditions() {
        SafeIterableMap$IteratorWithAdditions safeIterableMap$IteratorWithAdditions = new SafeIterableMap$IteratorWithAdditions(this);
        this.mIterators.put(safeIterableMap$IteratorWithAdditions, Boolean.FALSE);
        return safeIterableMap$IteratorWithAdditions;
    }

    public Map$Entry<K, V> newest() {
        return this.mEnd;
    }

    public SafeIterableMap$Entry<K, V> put(@NonNull K k, @NonNull V v) {
        SafeIterableMap$Entry<K, V> safeIterableMap$Entry = new SafeIterableMap$Entry<>(k, v);
        this.mSize++;
        SafeIterableMap$Entry<K, V> safeIterableMap$Entry2 = this.mEnd;
        if (safeIterableMap$Entry2 == null) {
            this.mStart = safeIterableMap$Entry;
            this.mEnd = safeIterableMap$Entry;
            return safeIterableMap$Entry;
        }
        safeIterableMap$Entry2.mNext = safeIterableMap$Entry;
        safeIterableMap$Entry.mPrevious = safeIterableMap$Entry2;
        this.mEnd = safeIterableMap$Entry;
        return safeIterableMap$Entry;
    }

    public V putIfAbsent(@NonNull K k, @NonNull V v) {
        SafeIterableMap$Entry<K, V> safeIterableMap$Entry = get(k);
        if (safeIterableMap$Entry != null) {
            return safeIterableMap$Entry.mValue;
        }
        put(k, v);
        return null;
    }

    public V remove(@NonNull K k) {
        SafeIterableMap$Entry<K, V> safeIterableMap$Entry = get(k);
        if (safeIterableMap$Entry == null) {
            return null;
        }
        this.mSize--;
        if (!this.mIterators.isEmpty()) {
            Iterator<SafeIterableMap$SupportRemove<K, V>> it = this.mIterators.keySet().iterator();
            while (it.hasNext()) {
                it.next().supportRemove(safeIterableMap$Entry);
            }
        }
        SafeIterableMap$Entry<K, V> safeIterableMap$Entry2 = safeIterableMap$Entry.mPrevious;
        if (safeIterableMap$Entry2 != null) {
            safeIterableMap$Entry2.mNext = safeIterableMap$Entry.mNext;
        } else {
            this.mStart = safeIterableMap$Entry.mNext;
        }
        SafeIterableMap$Entry<K, V> safeIterableMap$Entry3 = safeIterableMap$Entry.mNext;
        if (safeIterableMap$Entry3 != null) {
            safeIterableMap$Entry3.mPrevious = safeIterableMap$Entry2;
        } else {
            this.mEnd = safeIterableMap$Entry2;
        }
        safeIterableMap$Entry.mNext = null;
        safeIterableMap$Entry.mPrevious = null;
        return safeIterableMap$Entry.mValue;
    }

    public int size() {
        return this.mSize;
    }

    public String toString() {
        StringBuilder sbU = a.U("[");
        Iterator<Map$Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sbU.append(it.next().toString());
            if (it.hasNext()) {
                sbU.append(", ");
            }
        }
        sbU.append("]");
        return sbU.toString();
    }
}
