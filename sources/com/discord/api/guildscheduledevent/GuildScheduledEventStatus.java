package com.discord.api.guildscheduledevent;

import d0.t.n0;
import java.util.Set;

/* JADX INFO: compiled from: GuildScheduledEventStatus.kt */
/* JADX INFO: loaded from: classes.dex */
public enum GuildScheduledEventStatus {
    SCHEDULED(1),
    ACTIVE(2),
    COMPLETED(3),
    CANCELED(4),
    UNKNOWN(0);

    public static final GuildScheduledEventStatus$Companion Companion;
    private static final Set<GuildScheduledEventStatus> DONE;
    private final int apiValue;

    static {
        GuildScheduledEventStatus guildScheduledEventStatus = COMPLETED;
        GuildScheduledEventStatus guildScheduledEventStatus2 = CANCELED;
        Companion = new GuildScheduledEventStatus$Companion(null);
        DONE = n0.setOf((Object[]) new GuildScheduledEventStatus[]{guildScheduledEventStatus, guildScheduledEventStatus2});
    }

    GuildScheduledEventStatus(int i) {
        this.apiValue = i;
    }

    public static final /* synthetic */ Set access$getDONE$cp() {
        return DONE;
    }

    public final int getApiValue() {
        return this.apiValue;
    }
}
