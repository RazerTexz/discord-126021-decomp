package com.discord.api.application;


/* JADX INFO: compiled from: ApplicationType.kt */
/* JADX INFO: loaded from: classes.dex */
public enum ApplicationType {
    UNKNOWN(0),
    GAME(1),
    MUSIC(2),
    TICKETED_EVENTS(3),
    GUILD_ROLE_SUBSCRIPTIONS(4);

    public static final ApplicationType$Companion Companion = new ApplicationType$Companion(null);
    private final int apiValue;

    ApplicationType(int i) {
        this.apiValue = i;
    }

    public final int getApiValue() {
        return this.apiValue;
    }
}
