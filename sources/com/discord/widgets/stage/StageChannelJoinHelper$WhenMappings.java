package com.discord.widgets.stage;

import com.discord.utilities.voice.VoiceChannelJoinability;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StageChannelJoinHelper$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        VoiceChannelJoinability.values();
        int[] iArr = new int[5];
        $EnumSwitchMapping$0 = iArr;
        iArr[VoiceChannelJoinability.GUILD_VIDEO_AT_CAPACITY.ordinal()] = 1;
        iArr[VoiceChannelJoinability.PERMISSIONS_MISSING.ordinal()] = 2;
        iArr[VoiceChannelJoinability.CHANNEL_FULL.ordinal()] = 3;
        iArr[VoiceChannelJoinability.CHANNEL_DOES_NOT_EXIST.ordinal()] = 4;
        iArr[VoiceChannelJoinability.CAN_JOIN.ordinal()] = 5;
    }
}
