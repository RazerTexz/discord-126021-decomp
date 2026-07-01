package com.discord.stores;


/* JADX INFO: compiled from: StoreChannelsSelected.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum SelectedChannelAnalyticsLocation {
    EMBED("Embed"),
    CHANNEL_LIST("Channel List"),
    THREAD_BROWSER("Thread Browser"),
    TEXT_IN_VOICE("Text In Voice");

    private final String analyticsValue;

    SelectedChannelAnalyticsLocation(String str) {
        this.analyticsValue = str;
    }

    public final String getAnalyticsValue() {
        return this.analyticsValue;
    }
}
