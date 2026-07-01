package com.discord.widgets.settings;

import com.discord.rtcconnection.mediaengine.MediaEngine$OpenSLESConfig;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsVoice$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        MediaEngine$OpenSLESConfig.values();
        int[] iArr = new int[3];
        $EnumSwitchMapping$0 = iArr;
        iArr[MediaEngine$OpenSLESConfig.DEFAULT.ordinal()] = 1;
        iArr[MediaEngine$OpenSLESConfig.FORCE_ENABLED.ordinal()] = 2;
        iArr[MediaEngine$OpenSLESConfig.FORCE_DISABLED.ordinal()] = 3;
    }
}
