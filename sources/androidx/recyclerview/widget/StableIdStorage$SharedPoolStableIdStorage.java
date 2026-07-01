package androidx.recyclerview.widget;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class StableIdStorage$SharedPoolStableIdStorage implements StableIdStorage {
    private final StableIdStorage$StableIdLookup mSameIdLookup = new StableIdStorage$SharedPoolStableIdStorage$1(this);

    @Override // androidx.recyclerview.widget.StableIdStorage
    @NonNull
    public StableIdStorage$StableIdLookup createStableIdLookup() {
        return this.mSameIdLookup;
    }
}
