package com.discord.widgets.guildscheduledevent;

import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildScheduledEventLocationSelect$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;
    public static final /* synthetic */ int[] $EnumSwitchMapping$2;

    static {
        GuildScheduledEventEntityType.values();
        int[] iArr = new int[5];
        $EnumSwitchMapping$0 = iArr;
        GuildScheduledEventEntityType guildScheduledEventEntityType = GuildScheduledEventEntityType.VOICE;
        iArr[guildScheduledEventEntityType.ordinal()] = 1;
        GuildScheduledEventEntityType guildScheduledEventEntityType2 = GuildScheduledEventEntityType.STAGE_INSTANCE;
        iArr[guildScheduledEventEntityType2.ordinal()] = 2;
        GuildScheduledEventEntityType.values();
        int[] iArr2 = new int[5];
        $EnumSwitchMapping$1 = iArr2;
        iArr2[guildScheduledEventEntityType2.ordinal()] = 1;
        iArr2[guildScheduledEventEntityType.ordinal()] = 2;
        GuildScheduledEventEntityType guildScheduledEventEntityType3 = GuildScheduledEventEntityType.EXTERNAL;
        iArr2[guildScheduledEventEntityType3.ordinal()] = 3;
        GuildScheduledEventEntityType.values();
        int[] iArr3 = new int[5];
        $EnumSwitchMapping$2 = iArr3;
        iArr3[guildScheduledEventEntityType2.ordinal()] = 1;
        iArr3[guildScheduledEventEntityType.ordinal()] = 2;
        iArr3[guildScheduledEventEntityType3.ordinal()] = 3;
    }
}
