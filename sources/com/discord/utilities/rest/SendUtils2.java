package com.discord.utilities.rest;


/* JADX INFO: renamed from: com.discord.utilities.rest.FileUploadAlertType, reason: use source file name */
/* JADX INFO: compiled from: SendUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum SendUtils2 {
    NITRO_UPSELL("Nitro Upsell"),
    OVER_MAX_SIZE("Over Max Size");

    private final String analyticsValue;

    SendUtils2(String str) {
        this.analyticsValue = str;
    }

    public final String getAnalyticsValue() {
        return this.analyticsValue;
    }
}
