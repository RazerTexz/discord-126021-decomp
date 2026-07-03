package com.discord.utilities.rest;


/* JADX INFO: compiled from: SendUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum FileUploadAlertType {
    NITRO_UPSELL("Nitro Upsell"),
    OVER_MAX_SIZE("Over Max Size");

    private final String analyticsValue;

    FileUploadAlertType(String str) {
        this.analyticsValue = str;
    }

    public final String getAnalyticsValue() {
        return this.analyticsValue;
    }
}
