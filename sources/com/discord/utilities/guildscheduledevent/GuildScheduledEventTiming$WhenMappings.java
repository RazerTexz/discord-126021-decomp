package com.discord.utilities.guildscheduledevent;


/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class GuildScheduledEventTiming$WhenMappings {
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
