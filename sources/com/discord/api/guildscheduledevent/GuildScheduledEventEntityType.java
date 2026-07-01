package com.discord.api.guildscheduledevent;


/* JADX INFO: compiled from: GuildScheduledEventEntityType.kt */
/* JADX INFO: loaded from: classes.dex */
public enum GuildScheduledEventEntityType {
    NONE(0),
    STAGE_INSTANCE(1),
    VOICE(2),
    EXTERNAL(3),
    UNKNOWN(-1);

    public static final GuildScheduledEventEntityType$Companion Companion = new GuildScheduledEventEntityType$Companion(null);
    private final int apiValue;

    GuildScheduledEventEntityType(int i) {
        this.apiValue = i;
    }

    public final int getApiValue() {
        return this.apiValue;
    }
}
