package androidx.core.view;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class ContentInfoCompat$Builder {

    @NonNull
    public ClipData mClip;

    @Nullable
    public Bundle mExtras;
    public int mFlags;

    @Nullable
    public Uri mLinkUri;
    public int mSource;

    public ContentInfoCompat$Builder(@NonNull ContentInfoCompat contentInfoCompat) {
        this.mClip = contentInfoCompat.mClip;
        this.mSource = contentInfoCompat.mSource;
        this.mFlags = contentInfoCompat.mFlags;
        this.mLinkUri = contentInfoCompat.mLinkUri;
        this.mExtras = contentInfoCompat.mExtras;
    }

    @NonNull
    public ContentInfoCompat build() {
        return new ContentInfoCompat(this);
    }

    @NonNull
    public ContentInfoCompat$Builder setClip(@NonNull ClipData clipData) {
        this.mClip = clipData;
        return this;
    }

    @NonNull
    public ContentInfoCompat$Builder setExtras(@Nullable Bundle bundle) {
        this.mExtras = bundle;
        return this;
    }

    @NonNull
    public ContentInfoCompat$Builder setFlags(int i) {
        this.mFlags = i;
        return this;
    }

    @NonNull
    public ContentInfoCompat$Builder setLinkUri(@Nullable Uri uri) {
        this.mLinkUri = uri;
        return this;
    }

    @NonNull
    public ContentInfoCompat$Builder setSource(int i) {
        this.mSource = i;
        return this;
    }

    public ContentInfoCompat$Builder(@NonNull ClipData clipData, int i) {
        this.mClip = clipData;
        this.mSource = i;
    }
}
