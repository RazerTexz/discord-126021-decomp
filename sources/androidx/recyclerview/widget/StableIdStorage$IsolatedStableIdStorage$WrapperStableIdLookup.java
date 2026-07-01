package androidx.recyclerview.widget;

import androidx.collection.LongSparseArray;

/* JADX INFO: loaded from: classes.dex */
public class StableIdStorage$IsolatedStableIdStorage$WrapperStableIdLookup implements StableIdStorage$StableIdLookup {
    private final LongSparseArray<Long> mLocalToGlobalLookup = new LongSparseArray<>();
    public final /* synthetic */ StableIdStorage$IsolatedStableIdStorage this$0;

    public StableIdStorage$IsolatedStableIdStorage$WrapperStableIdLookup(StableIdStorage$IsolatedStableIdStorage stableIdStorage$IsolatedStableIdStorage) {
        this.this$0 = stableIdStorage$IsolatedStableIdStorage;
    }

    @Override // androidx.recyclerview.widget.StableIdStorage$StableIdLookup
    public long localToGlobal(long j) {
        Long lValueOf = this.mLocalToGlobalLookup.get(j);
        if (lValueOf == null) {
            lValueOf = Long.valueOf(this.this$0.obtainId());
            this.mLocalToGlobalLookup.put(j, lValueOf);
        }
        return lValueOf.longValue();
    }
}
