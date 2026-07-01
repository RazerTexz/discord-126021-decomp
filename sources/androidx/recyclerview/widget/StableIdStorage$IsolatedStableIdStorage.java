package androidx.recyclerview.widget;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class StableIdStorage$IsolatedStableIdStorage implements StableIdStorage {
    public long mNextStableId = 0;

    @Override // androidx.recyclerview.widget.StableIdStorage
    @NonNull
    public StableIdStorage$StableIdLookup createStableIdLookup() {
        return new StableIdStorage$IsolatedStableIdStorage$WrapperStableIdLookup(this);
    }

    public long obtainId() {
        long j = this.mNextStableId;
        this.mNextStableId = 1 + j;
        return j;
    }
}
