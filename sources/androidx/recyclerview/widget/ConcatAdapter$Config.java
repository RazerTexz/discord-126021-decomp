package androidx.recyclerview.widget;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public final class ConcatAdapter$Config {

    @NonNull
    public static final ConcatAdapter$Config DEFAULT = new ConcatAdapter$Config(true, ConcatAdapter$Config$StableIdMode.NO_STABLE_IDS);
    public final boolean isolateViewTypes;

    @NonNull
    public final ConcatAdapter$Config$StableIdMode stableIdMode;

    public ConcatAdapter$Config(boolean z2, @NonNull ConcatAdapter$Config$StableIdMode concatAdapter$Config$StableIdMode) {
        this.isolateViewTypes = z2;
        this.stableIdMode = concatAdapter$Config$StableIdMode;
    }
}
