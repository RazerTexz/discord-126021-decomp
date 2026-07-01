package com.google.android.gms.common.api;

import androidx.annotation.RecentlyNonNull;
import b.d.b.a.outline;
import com.google.android.gms.common.Feature;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class UnsupportedApiCallException extends UnsupportedOperationException {
    private final Feature zza;

    public UnsupportedApiCallException(@RecentlyNonNull Feature feature) {
        this.zza = feature;
    }

    @Override // java.lang.Throwable
    @RecentlyNonNull
    public String getMessage() {
        String strValueOf = String.valueOf(this.zza);
        return outline.J(new StringBuilder(strValueOf.length() + 8), "Missing ", strValueOf);
    }
}
