package com.discord.utilities.guildscheduledevent;


/* JADX INFO: renamed from: com.discord.utilities.guildscheduledevent.GuildScheduledEventTiming, reason: use source file name */
/* JADX INFO: compiled from: GuildScheduledEventUtilities.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum GuildScheduledEventUtilities2 {
    LATER,
    TOMORROW,
    TODAY,
    SOON,
    NOW,
    LIVE,
    EXPIRED;

    /* JADX INFO: renamed from: com.discord.utilities.guildscheduledevent.GuildScheduledEventTiming$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            GuildScheduledEventUtilities2.values();
            int[] iArr = new int[7];
            $EnumSwitchMapping$0 = iArr;
            iArr[GuildScheduledEventUtilities2.LATER.ordinal()] = 1;
            iArr[GuildScheduledEventUtilities2.TOMORROW.ordinal()] = 2;
            iArr[GuildScheduledEventUtilities2.TODAY.ordinal()] = 3;
            GuildScheduledEventUtilities2.values();
            int[] iArr2 = new int[7];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[GuildScheduledEventUtilities2.SOON.ordinal()] = 1;
            iArr2[GuildScheduledEventUtilities2.NOW.ordinal()] = 2;
            iArr2[GuildScheduledEventUtilities2.EXPIRED.ordinal()] = 3;
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
