package com.discord.api.guildscheduledevent;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildScheduledEventEntityType.kt */
/* JADX INFO: loaded from: classes.dex */
public enum GuildScheduledEventEntityType {
    NONE(0),
    STAGE_INSTANCE(1),
    VOICE(2),
    EXTERNAL(3),
    UNKNOWN(-1);


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int apiValue;

    /* JADX INFO: compiled from: GuildScheduledEventEntityType.kt */
    public static final class Companion {
        public Companion() {
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

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    GuildScheduledEventEntityType(int i) {
        this.apiValue = i;
    }

    public final int getApiValue() {
        return this.apiValue;
    }
}
