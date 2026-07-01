package com.discord.utilities.guildscheduledevent;

import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class GuildScheduledEventUtilitiesKt$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;
    public static final /* synthetic */ int[] $EnumSwitchMapping$2;
    public static final /* synthetic */ int[] $EnumSwitchMapping$3;

    static {
        GuildScheduledEventEntityType.values();
        int[] iArr = new int[5];
        $EnumSwitchMapping$0 = iArr;
        iArr[GuildScheduledEventEntityType.EXTERNAL.ordinal()] = 1;
        GuildScheduledEventTiming.values();
        int[] iArr2 = new int[7];
        $EnumSwitchMapping$1 = iArr2;
        GuildScheduledEventTiming guildScheduledEventTiming = GuildScheduledEventTiming.LIVE;
        iArr2[guildScheduledEventTiming.ordinal()] = 1;
        iArr2[GuildScheduledEventTiming.EXPIRED.ordinal()] = 2;
        iArr2[GuildScheduledEventTiming.NOW.ordinal()] = 3;
        GuildScheduledEventTiming guildScheduledEventTiming2 = GuildScheduledEventTiming.SOON;
        iArr2[guildScheduledEventTiming2.ordinal()] = 4;
        GuildScheduledEventTiming guildScheduledEventTiming3 = GuildScheduledEventTiming.TODAY;
        iArr2[guildScheduledEventTiming3.ordinal()] = 5;
        GuildScheduledEventTiming guildScheduledEventTiming4 = GuildScheduledEventTiming.TOMORROW;
        iArr2[guildScheduledEventTiming4.ordinal()] = 6;
        GuildScheduledEventTiming.values();
        int[] iArr3 = new int[7];
        $EnumSwitchMapping$2 = iArr3;
        iArr3[guildScheduledEventTiming.ordinal()] = 1;
        iArr3[guildScheduledEventTiming2.ordinal()] = 2;
        iArr3[guildScheduledEventTiming3.ordinal()] = 3;
        GuildScheduledEventTiming.values();
        int[] iArr4 = new int[7];
        $EnumSwitchMapping$3 = iArr4;
        iArr4[guildScheduledEventTiming4.ordinal()] = 1;
        iArr4[GuildScheduledEventTiming.LATER.ordinal()] = 2;
    }
}
