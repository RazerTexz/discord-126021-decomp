package com.android.installreferrer.api;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class InstallReferrerClient$Builder {
    private final Context mContext;

    private InstallReferrerClient$Builder(Context context) {
        this.mContext = context;
    }

    public /* synthetic */ InstallReferrerClient$Builder(Context context, InstallReferrerClient$a installReferrerClient$a) {
        this(context);
    }

    public InstallReferrerClient build() {
        Context context = this.mContext;
        if (context != null) {
            return new InstallReferrerClientImpl(context);
        }
        throw new IllegalArgumentException("Please provide a valid Context.");
    }
}
