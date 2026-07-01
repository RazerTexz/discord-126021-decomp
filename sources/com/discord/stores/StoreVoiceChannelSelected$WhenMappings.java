package com.discord.stores;

import com.discord.api.guild.GuildVerificationLevel;
import com.discord.utilities.voice.VoiceChannelJoinability;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreVoiceChannelSelected$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;
    public static final /* synthetic */ int[] $EnumSwitchMapping$2;

    static {
        VoiceChannelJoinability.values();
        int[] iArr = new int[5];
        $EnumSwitchMapping$0 = iArr;
        VoiceChannelJoinability voiceChannelJoinability = VoiceChannelJoinability.CAN_JOIN;
        iArr[voiceChannelJoinability.ordinal()] = 1;
        VoiceChannelJoinability voiceChannelJoinability2 = VoiceChannelJoinability.PERMISSIONS_MISSING;
        iArr[voiceChannelJoinability2.ordinal()] = 2;
        VoiceChannelJoinability voiceChannelJoinability3 = VoiceChannelJoinability.CHANNEL_FULL;
        iArr[voiceChannelJoinability3.ordinal()] = 3;
        VoiceChannelJoinability voiceChannelJoinability4 = VoiceChannelJoinability.GUILD_VIDEO_AT_CAPACITY;
        iArr[voiceChannelJoinability4.ordinal()] = 4;
        VoiceChannelJoinability voiceChannelJoinability5 = VoiceChannelJoinability.CHANNEL_DOES_NOT_EXIST;
        iArr[voiceChannelJoinability5.ordinal()] = 5;
        VoiceChannelJoinability.values();
        int[] iArr2 = new int[5];
        $EnumSwitchMapping$1 = iArr2;
        iArr2[voiceChannelJoinability2.ordinal()] = 1;
        iArr2[voiceChannelJoinability4.ordinal()] = 2;
        iArr2[voiceChannelJoinability3.ordinal()] = 3;
        iArr2[voiceChannelJoinability5.ordinal()] = 4;
        iArr2[voiceChannelJoinability.ordinal()] = 5;
        GuildVerificationLevel.values();
        int[] iArr3 = new int[5];
        $EnumSwitchMapping$2 = iArr3;
        iArr3[GuildVerificationLevel.HIGHEST.ordinal()] = 1;
        iArr3[GuildVerificationLevel.HIGH.ordinal()] = 2;
        iArr3[GuildVerificationLevel.MEDIUM.ordinal()] = 3;
        iArr3[GuildVerificationLevel.LOW.ordinal()] = 4;
        iArr3[GuildVerificationLevel.NONE.ordinal()] = 5;
    }
}
