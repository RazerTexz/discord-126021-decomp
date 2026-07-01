package com.discord.stores;


/* JADX INFO: renamed from: com.discord.stores.SelectedChannelAnalyticsLocation, reason: use source file name */
/* JADX INFO: compiled from: StoreChannelsSelected.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum StoreChannelsSelected3 {
    EMBED("Embed"),
    CHANNEL_LIST("Channel List"),
    THREAD_BROWSER("Thread Browser"),
    TEXT_IN_VOICE("Text In Voice");

    private final String analyticsValue;

    StoreChannelsSelected3(String str) {
        this.analyticsValue = str;
    }

    public final String getAnalyticsValue() {
        return this.analyticsValue;
    }
}
