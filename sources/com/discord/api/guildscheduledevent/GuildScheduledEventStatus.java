package com.discord.api.guildscheduledevent;

import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p580t.C12148n0;

/* JADX INFO: compiled from: GuildScheduledEventStatus.kt */
/* JADX INFO: loaded from: classes.dex */
public enum GuildScheduledEventStatus {
    SCHEDULED(1),
    ACTIVE(2),
    COMPLETED(3),
    CANCELED(4),
    UNKNOWN(0);


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final Set<GuildScheduledEventStatus> DONE;
    private final int apiValue;

    /* JADX INFO: compiled from: GuildScheduledEventStatus.kt */
    public static final class Companion {
        public Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        GuildScheduledEventStatus guildScheduledEventStatus = COMPLETED;
        GuildScheduledEventStatus guildScheduledEventStatus2 = CANCELED;
        INSTANCE = new Companion(null);
        DONE = C12148n0.setOf((Object[]) new GuildScheduledEventStatus[]{guildScheduledEventStatus, guildScheduledEventStatus2});
    }

    GuildScheduledEventStatus(int i) {
        this.apiValue = i;
    }

    public final int getApiValue() {
        return this.apiValue;
    }
}
