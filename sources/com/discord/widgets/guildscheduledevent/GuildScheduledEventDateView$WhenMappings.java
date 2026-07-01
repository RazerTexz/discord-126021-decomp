package com.discord.widgets.guildscheduledevent;

import com.discord.utilities.guildscheduledevent.GuildScheduledEventTiming;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class GuildScheduledEventDateView$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;

    static {
        GuildScheduledEventTiming.values();
        int[] iArr = new int[7];
        $EnumSwitchMapping$0 = iArr;
        GuildScheduledEventTiming guildScheduledEventTiming = GuildScheduledEventTiming.LIVE;
        iArr[guildScheduledEventTiming.ordinal()] = 1;
        GuildScheduledEventTiming guildScheduledEventTiming2 = GuildScheduledEventTiming.SOON;
        iArr[guildScheduledEventTiming2.ordinal()] = 2;
        GuildScheduledEventTiming guildScheduledEventTiming3 = GuildScheduledEventTiming.NOW;
        iArr[guildScheduledEventTiming3.ordinal()] = 3;
        GuildScheduledEventTiming guildScheduledEventTiming4 = GuildScheduledEventTiming.EXPIRED;
        iArr[guildScheduledEventTiming4.ordinal()] = 4;
        GuildScheduledEventTiming.values();
        int[] iArr2 = new int[7];
        $EnumSwitchMapping$1 = iArr2;
        iArr2[guildScheduledEventTiming.ordinal()] = 1;
        iArr2[guildScheduledEventTiming2.ordinal()] = 2;
        iArr2[guildScheduledEventTiming3.ordinal()] = 3;
        iArr2[guildScheduledEventTiming4.ordinal()] = 4;
    }
}
