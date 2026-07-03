package com.google.android.gms.common.api;

import androidx.annotation.RecentlyNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public class ApiException extends Exception {

    @RecentlyNonNull
    @Deprecated
    public final Status mStatus;

    public ApiException(@RecentlyNonNull Status status) {
        int i = status.f20495p;
        String str = status.f20496q;
        str = str == null ? "" : str;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13);
        sb.append(i);
        sb.append(": ");
        sb.append(str);
        super(sb.toString());
        this.mStatus = status;
    }
}
