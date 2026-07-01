package com.discord.stores;


/* JADX INFO: compiled from: StoreMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum FailedMessageResolutionType {
    RESENT("Resent"),
    DELETED("Deleted");

    private final String analyticsValue;

    FailedMessageResolutionType(String str) {
        this.analyticsValue = str;
    }

    public final String getAnalyticsValue() {
        return this.analyticsValue;
    }
}
