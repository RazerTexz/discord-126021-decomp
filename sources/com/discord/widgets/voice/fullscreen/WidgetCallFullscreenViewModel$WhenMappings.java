package com.discord.widgets.voice.fullscreen;

import com.discord.rtcconnection.audio.DiscordAudioManager$DeviceTypes;
import com.discord.stores.StoreApplicationStreaming$ActiveApplicationStream$State;
import com.discord.stores.StoreMediaSettings$SelfMuteFailure;
import com.discord.views.calls.VideoCallParticipantView$ParticipantData$Type;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetCallFullscreenViewModel$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;
    public static final /* synthetic */ int[] $EnumSwitchMapping$2;
    public static final /* synthetic */ int[] $EnumSwitchMapping$3;
    public static final /* synthetic */ int[] $EnumSwitchMapping$4;
    public static final /* synthetic */ int[] $EnumSwitchMapping$5;
    public static final /* synthetic */ int[] $EnumSwitchMapping$6;

    static {
        WidgetCallFullscreenViewModel$DisplayMode.values();
        int[] iArr = new int[3];
        $EnumSwitchMapping$0 = iArr;
        iArr[WidgetCallFullscreenViewModel$DisplayMode.GRID.ordinal()] = 1;
        iArr[WidgetCallFullscreenViewModel$DisplayMode.PRIVATE_CALL_PARTICIPANTS.ordinal()] = 2;
        VideoCallParticipantView$ParticipantData$Type.values();
        int[] iArr2 = new int[2];
        $EnumSwitchMapping$1 = iArr2;
        VideoCallParticipantView$ParticipantData$Type videoCallParticipantView$ParticipantData$Type = VideoCallParticipantView$ParticipantData$Type.DEFAULT;
        iArr2[videoCallParticipantView$ParticipantData$Type.ordinal()] = 1;
        VideoCallParticipantView$ParticipantData$Type videoCallParticipantView$ParticipantData$Type2 = VideoCallParticipantView$ParticipantData$Type.APPLICATION_STREAMING;
        iArr2[videoCallParticipantView$ParticipantData$Type2.ordinal()] = 2;
        DiscordAudioManager$DeviceTypes.values();
        int[] iArr3 = new int[6];
        $EnumSwitchMapping$2 = iArr3;
        iArr3[DiscordAudioManager$DeviceTypes.BLUETOOTH_HEADSET.ordinal()] = 1;
        iArr3[DiscordAudioManager$DeviceTypes.SPEAKERPHONE.ordinal()] = 2;
        VideoCallParticipantView$ParticipantData$Type.values();
        int[] iArr4 = new int[2];
        $EnumSwitchMapping$3 = iArr4;
        iArr4[videoCallParticipantView$ParticipantData$Type2.ordinal()] = 1;
        iArr4[videoCallParticipantView$ParticipantData$Type.ordinal()] = 2;
        VideoCallParticipantView$ParticipantData$Type.values();
        int[] iArr5 = new int[2];
        $EnumSwitchMapping$4 = iArr5;
        iArr5[videoCallParticipantView$ParticipantData$Type2.ordinal()] = 1;
        iArr5[videoCallParticipantView$ParticipantData$Type.ordinal()] = 2;
        StoreApplicationStreaming$ActiveApplicationStream$State.values();
        int[] iArr6 = new int[6];
        $EnumSwitchMapping$5 = iArr6;
        iArr6[StoreApplicationStreaming$ActiveApplicationStream$State.CONNECTING.ordinal()] = 1;
        iArr6[StoreApplicationStreaming$ActiveApplicationStream$State.RECONNECTING.ordinal()] = 2;
        iArr6[StoreApplicationStreaming$ActiveApplicationStream$State.ACTIVE.ordinal()] = 3;
        iArr6[StoreApplicationStreaming$ActiveApplicationStream$State.PAUSED.ordinal()] = 4;
        iArr6[StoreApplicationStreaming$ActiveApplicationStream$State.DENIED_FULL.ordinal()] = 5;
        iArr6[StoreApplicationStreaming$ActiveApplicationStream$State.ENDED.ordinal()] = 6;
        StoreMediaSettings$SelfMuteFailure.values();
        int[] iArr7 = new int[1];
        $EnumSwitchMapping$6 = iArr7;
        iArr7[StoreMediaSettings$SelfMuteFailure.CANNOT_USE_VAD.ordinal()] = 1;
    }
}
