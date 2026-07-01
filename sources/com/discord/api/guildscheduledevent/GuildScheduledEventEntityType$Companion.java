package com.discord.api.guildscheduledevent;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildScheduledEventEntityType.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildScheduledEventEntityType$Companion {
    public GuildScheduledEventEntityType$Companion() {
    }

    public final GuildScheduledEventEntityType a(int type) {
        if (type == 0) {
            return GuildScheduledEventEntityType.NONE;
        }
        if (type == 1) {
            return GuildScheduledEventEntityType.STAGE_INSTANCE;
        }
        if (type != 2) {
            return type != 3 ? GuildScheduledEventEntityType.UNKNOWN : GuildScheduledEventEntityType.EXTERNAL;
        }
        return GuildScheduledEventEntityType.VOICE;
    }

    public GuildScheduledEventEntityType$Companion(DefaultConstructorMarker defaultConstructorMarker) {
    }
}
