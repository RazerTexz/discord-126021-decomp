package androidx.arch.core.internal;

import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.Map$Entry;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: loaded from: classes.dex */
public class SafeIterableMap$IteratorWithAdditions<K, V> implements Iterator<Map$Entry<K, V>>, SafeIterableMap$SupportRemove<K, V> {
    private boolean mBeforeStart = true;
    private SafeIterableMap$Entry<K, V> mCurrent;
    public final /* synthetic */ SafeIterableMap this$0;

    public SafeIterableMap$IteratorWithAdditions(SafeIterableMap safeIterableMap) {
        this.this$0 = safeIterableMap;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.mBeforeStart) {
            return this.this$0.mStart != null;
        }
        SafeIterableMap$Entry<K, V> safeIterableMap$Entry = this.mCurrent;
        return (safeIterableMap$Entry == null || safeIterableMap$Entry.mNext == null) ? false : true;
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Object next() {
        return next();
    }

    @Override // androidx.arch.core.internal.SafeIterableMap$SupportRemove
    public void supportRemove(@NonNull SafeIterableMap$Entry<K, V> safeIterableMap$Entry) {
        SafeIterableMap$Entry<K, V> safeIterableMap$Entry2 = this.mCurrent;
        if (safeIterableMap$Entry == safeIterableMap$Entry2) {
            SafeIterableMap$Entry<K, V> safeIterableMap$Entry3 = safeIterableMap$Entry2.mPrevious;
            this.mCurrent = safeIterableMap$Entry3;
            this.mBeforeStart = safeIterableMap$Entry3 == null;
        }
    }

    @Override // java.util.Iterator
    public Map$Entry<K, V> next() {
        if (this.mBeforeStart) {
            this.mBeforeStart = false;
            this.mCurrent = this.this$0.mStart;
        } else {
            SafeIterableMap$Entry<K, V> safeIterableMap$Entry = this.mCurrent;
            this.mCurrent = safeIterableMap$Entry != null ? safeIterableMap$Entry.mNext : null;
        }
        return this.mCurrent;
    }
}
