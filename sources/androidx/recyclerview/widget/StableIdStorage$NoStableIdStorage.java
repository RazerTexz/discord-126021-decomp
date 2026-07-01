package androidx.recyclerview.widget;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class StableIdStorage$NoStableIdStorage implements StableIdStorage {
    private final StableIdStorage$StableIdLookup mNoIdLookup = new StableIdStorage$NoStableIdStorage$1(this);

    @Override // androidx.recyclerview.widget.StableIdStorage
    @NonNull
    public StableIdStorage$StableIdLookup createStableIdLookup() {
        return this.mNoIdLookup;
    }
}
