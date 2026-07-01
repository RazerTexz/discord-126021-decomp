package com.discord.utilities.guildscheduledevent;


/* JADX INFO: compiled from: GuildScheduledEventUtilities.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum GuildScheduledEventTiming {
    LATER,
    TOMORROW,
    TODAY,
    SOON,
    NOW,
    LIVE,
    EXPIRED;

    public final boolean isLongStartable() {
        int iOrdinal = ordinal();
        return iOrdinal == 0 || iOrdinal == 1 || iOrdinal == 2;
    }

    public final boolean isStartable() {
        int iOrdinal = ordinal();
        return iOrdinal == 3 || iOrdinal == 4 || iOrdinal == 6;
    }
}
