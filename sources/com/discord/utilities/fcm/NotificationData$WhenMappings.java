package com.discord.utilities.fcm;

import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class NotificationData$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;
    public static final /* synthetic */ int[] $EnumSwitchMapping$2;
    public static final /* synthetic */ int[] $EnumSwitchMapping$3;
    public static final /* synthetic */ int[] $EnumSwitchMapping$4;
    public static final /* synthetic */ int[] $EnumSwitchMapping$5;
    public static final /* synthetic */ int[] $EnumSwitchMapping$6;

    static {
        GuildScheduledEventEntityType.values();
        int[] iArr = new int[5];
        $EnumSwitchMapping$0 = iArr;
        GuildScheduledEventEntityType guildScheduledEventEntityType = GuildScheduledEventEntityType.STAGE_INSTANCE;
        iArr[guildScheduledEventEntityType.ordinal()] = 1;
        GuildScheduledEventEntityType guildScheduledEventEntityType2 = GuildScheduledEventEntityType.VOICE;
        iArr[guildScheduledEventEntityType2.ordinal()] = 2;
        GuildScheduledEventEntityType guildScheduledEventEntityType3 = GuildScheduledEventEntityType.EXTERNAL;
        iArr[guildScheduledEventEntityType3.ordinal()] = 3;
        GuildScheduledEventEntityType.values();
        int[] iArr2 = new int[5];
        $EnumSwitchMapping$1 = iArr2;
        iArr2[guildScheduledEventEntityType.ordinal()] = 1;
        iArr2[guildScheduledEventEntityType2.ordinal()] = 2;
        iArr2[guildScheduledEventEntityType3.ordinal()] = 3;
        GuildScheduledEventEntityType.values();
        int[] iArr3 = new int[5];
        $EnumSwitchMapping$2 = iArr3;
        iArr3[guildScheduledEventEntityType.ordinal()] = 1;
        iArr3[guildScheduledEventEntityType2.ordinal()] = 2;
        iArr3[guildScheduledEventEntityType3.ordinal()] = 3;
        GuildScheduledEventEntityType.values();
        int[] iArr4 = new int[5];
        $EnumSwitchMapping$3 = iArr4;
        iArr4[guildScheduledEventEntityType.ordinal()] = 1;
        iArr4[guildScheduledEventEntityType2.ordinal()] = 2;
        iArr4[guildScheduledEventEntityType3.ordinal()] = 3;
        NotificationType.values();
        int[] iArr5 = new int[1];
        $EnumSwitchMapping$4 = iArr5;
        iArr5[NotificationType.Reminder.ordinal()] = 1;
        GuildScheduledEventEntityType.values();
        int[] iArr6 = new int[5];
        $EnumSwitchMapping$5 = iArr6;
        iArr6[guildScheduledEventEntityType.ordinal()] = 1;
        iArr6[guildScheduledEventEntityType2.ordinal()] = 2;
        iArr6[guildScheduledEventEntityType3.ordinal()] = 3;
        GuildScheduledEventEntityType.values();
        int[] iArr7 = new int[5];
        $EnumSwitchMapping$6 = iArr7;
        iArr7[guildScheduledEventEntityType.ordinal()] = 1;
        iArr7[guildScheduledEventEntityType2.ordinal()] = 2;
        iArr7[guildScheduledEventEntityType3.ordinal()] = 3;
    }
}
