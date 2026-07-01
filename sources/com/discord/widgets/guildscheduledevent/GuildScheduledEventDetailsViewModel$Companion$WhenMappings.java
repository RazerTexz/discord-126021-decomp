package com.discord.widgets.guildscheduledevent;


/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class GuildScheduledEventDetailsViewModel$Companion$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;

    static {
        GuildScheduledEventDetailsSource.values();
        int[] iArr = new int[2];
        $EnumSwitchMapping$0 = iArr;
        GuildScheduledEventDetailsSource guildScheduledEventDetailsSource = GuildScheduledEventDetailsSource.Directory;
        iArr[guildScheduledEventDetailsSource.ordinal()] = 1;
        GuildScheduledEventDetailsSource guildScheduledEventDetailsSource2 = GuildScheduledEventDetailsSource.Guild;
        iArr[guildScheduledEventDetailsSource2.ordinal()] = 2;
        GuildScheduledEventDetailsSource.values();
        int[] iArr2 = new int[2];
        $EnumSwitchMapping$1 = iArr2;
        iArr2[guildScheduledEventDetailsSource.ordinal()] = 1;
        iArr2[guildScheduledEventDetailsSource2.ordinal()] = 2;
    }
}
