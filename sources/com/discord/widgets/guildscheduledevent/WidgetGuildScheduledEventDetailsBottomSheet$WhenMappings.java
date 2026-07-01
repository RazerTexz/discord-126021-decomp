package com.discord.widgets.guildscheduledevent;


/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildScheduledEventDetailsBottomSheet$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        EventDetailsRsvpUsersFetchState.values();
        int[] iArr = new int[4];
        $EnumSwitchMapping$0 = iArr;
        iArr[EventDetailsRsvpUsersFetchState.LOADING.ordinal()] = 1;
        iArr[EventDetailsRsvpUsersFetchState.EMPTY.ordinal()] = 2;
        iArr[EventDetailsRsvpUsersFetchState.ERROR.ordinal()] = 3;
        iArr[EventDetailsRsvpUsersFetchState.SUCCESS.ordinal()] = 4;
    }
}
