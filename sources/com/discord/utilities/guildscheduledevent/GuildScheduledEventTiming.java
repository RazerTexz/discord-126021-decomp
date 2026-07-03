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

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            GuildScheduledEventTiming.values();
            int[] iArr = new int[7];
            $EnumSwitchMapping$0 = iArr;
            iArr[GuildScheduledEventTiming.LATER.ordinal()] = 1;
            iArr[GuildScheduledEventTiming.TOMORROW.ordinal()] = 2;
            iArr[GuildScheduledEventTiming.TODAY.ordinal()] = 3;
            GuildScheduledEventTiming.values();
            int[] iArr2 = new int[7];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[GuildScheduledEventTiming.SOON.ordinal()] = 1;
            iArr2[GuildScheduledEventTiming.NOW.ordinal()] = 2;
            iArr2[GuildScheduledEventTiming.EXPIRED.ordinal()] = 3;
        }
    }

    public final boolean isLongStartable() {
        int iOrdinal = ordinal();
        return iOrdinal == 0 || iOrdinal == 1 || iOrdinal == 2;
    }

    public final boolean isStartable() {
        int iOrdinal = ordinal();
        return iOrdinal == 3 || iOrdinal == 4 || iOrdinal == 6;
    }
}
