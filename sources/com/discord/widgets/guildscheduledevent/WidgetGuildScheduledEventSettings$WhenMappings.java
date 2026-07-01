package com.discord.widgets.guildscheduledevent;


/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildScheduledEventSettings$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        GuildScheduledEventSettingsViewModel$DateError.values();
        int[] iArr = new int[4];
        $EnumSwitchMapping$0 = iArr;
        iArr[GuildScheduledEventSettingsViewModel$DateError.INVALID_VIEW_STATE.ordinal()] = 1;
        iArr[GuildScheduledEventSettingsViewModel$DateError.START_DATE_IN_PAST.ordinal()] = 2;
        iArr[GuildScheduledEventSettingsViewModel$DateError.END_DATE_IN_PAST.ordinal()] = 3;
        iArr[GuildScheduledEventSettingsViewModel$DateError.END_DATE_BEFORE_START_DATE.ordinal()] = 4;
    }
}
