package com.discord.stores;


/* JADX INFO: compiled from: StoreChannelsSelected.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum ChannelAnalyticsViewType {
    FULL_VIEW("Full View"),
    PEEK_VIEW("Peek View");

    private final String analyticsValue;

    ChannelAnalyticsViewType(String str) {
        this.analyticsValue = str;
    }

    public final String getAnalyticsValue() {
        return this.analyticsValue;
    }
}
