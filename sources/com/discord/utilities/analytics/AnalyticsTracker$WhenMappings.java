package com.discord.utilities.analytics;

import com.discord.rtcconnection.audio.DiscordAudioManager$DeviceTypes;
import com.discord.widgets.user.WidgetUserSetCustomStatusViewModel$FormState$Expiration;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class AnalyticsTracker$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;

    static {
        WidgetUserSetCustomStatusViewModel$FormState$Expiration.values();
        int[] iArr = new int[5];
        $EnumSwitchMapping$0 = iArr;
        iArr[WidgetUserSetCustomStatusViewModel$FormState$Expiration.NEVER.ordinal()] = 1;
        iArr[WidgetUserSetCustomStatusViewModel$FormState$Expiration.IN_30_MINUTES.ordinal()] = 2;
        iArr[WidgetUserSetCustomStatusViewModel$FormState$Expiration.IN_1_HOUR.ordinal()] = 3;
        iArr[WidgetUserSetCustomStatusViewModel$FormState$Expiration.IN_4_HOURS.ordinal()] = 4;
        iArr[WidgetUserSetCustomStatusViewModel$FormState$Expiration.TOMORROW.ordinal()] = 5;
        DiscordAudioManager$DeviceTypes.values();
        int[] iArr2 = new int[6];
        $EnumSwitchMapping$1 = iArr2;
        iArr2[DiscordAudioManager$DeviceTypes.SPEAKERPHONE.ordinal()] = 1;
        iArr2[DiscordAudioManager$DeviceTypes.BLUETOOTH_HEADSET.ordinal()] = 2;
        iArr2[DiscordAudioManager$DeviceTypes.WIRED_HEADSET.ordinal()] = 3;
        iArr2[DiscordAudioManager$DeviceTypes.EARPIECE.ordinal()] = 4;
        iArr2[DiscordAudioManager$DeviceTypes.INVALID.ordinal()] = 5;
        iArr2[DiscordAudioManager$DeviceTypes.DEFAULT.ordinal()] = 6;
    }
}
