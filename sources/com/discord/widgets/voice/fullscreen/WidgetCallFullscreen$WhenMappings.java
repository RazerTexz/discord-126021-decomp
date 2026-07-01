package com.discord.widgets.voice.fullscreen;


/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetCallFullscreen$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;

    static {
        WidgetCallFullscreenViewModel$DisplayMode.values();
        int[] iArr = new int[3];
        $EnumSwitchMapping$0 = iArr;
        WidgetCallFullscreenViewModel$DisplayMode widgetCallFullscreenViewModel$DisplayMode = WidgetCallFullscreenViewModel$DisplayMode.STAGE;
        iArr[widgetCallFullscreenViewModel$DisplayMode.ordinal()] = 1;
        WidgetCallFullscreenViewModel$DisplayMode widgetCallFullscreenViewModel$DisplayMode2 = WidgetCallFullscreenViewModel$DisplayMode.GRID;
        iArr[widgetCallFullscreenViewModel$DisplayMode2.ordinal()] = 2;
        WidgetCallFullscreenViewModel$DisplayMode.values();
        int[] iArr2 = new int[3];
        $EnumSwitchMapping$1 = iArr2;
        iArr2[widgetCallFullscreenViewModel$DisplayMode.ordinal()] = 1;
        iArr2[widgetCallFullscreenViewModel$DisplayMode2.ordinal()] = 2;
        iArr2[WidgetCallFullscreenViewModel$DisplayMode.PRIVATE_CALL_PARTICIPANTS.ordinal()] = 3;
    }
}
