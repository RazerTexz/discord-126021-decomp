package androidx.recyclerview.widget;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public final class ConcatAdapter$Config$Builder {
    private boolean mIsolateViewTypes;
    private ConcatAdapter$Config$StableIdMode mStableIdMode;

    public ConcatAdapter$Config$Builder() {
        ConcatAdapter$Config concatAdapter$Config = ConcatAdapter$Config.DEFAULT;
        this.mIsolateViewTypes = concatAdapter$Config.isolateViewTypes;
        this.mStableIdMode = concatAdapter$Config.stableIdMode;
    }

    @NonNull
    public ConcatAdapter$Config build() {
        return new ConcatAdapter$Config(this.mIsolateViewTypes, this.mStableIdMode);
    }

    @NonNull
    public ConcatAdapter$Config$Builder setIsolateViewTypes(boolean z2) {
        this.mIsolateViewTypes = z2;
        return this;
    }

    @NonNull
    public ConcatAdapter$Config$Builder setStableIdMode(@NonNull ConcatAdapter$Config$StableIdMode concatAdapter$Config$StableIdMode) {
        this.mStableIdMode = concatAdapter$Config$StableIdMode;
        return this;
    }
}
