package com.discord.api.activity;


/* JADX INFO: compiled from: ActivityType.kt */
/* JADX INFO: loaded from: classes.dex */
public enum ActivityType {
    PLAYING(0),
    STREAMING(1),
    LISTENING(2),
    WATCHING(3),
    CUSTOM_STATUS(4),
    COMPETING(5),
    UNKNOWN(-1);

    public static final ActivityType$Companion Companion = new ActivityType$Companion(null);
    private final int apiInt;

    ActivityType(int i) {
        this.apiInt = i;
    }

    /* JADX INFO: renamed from: getApiInt$discord_api, reason: from getter */
    public final int getApiInt() {
        return this.apiInt;
    }
}
