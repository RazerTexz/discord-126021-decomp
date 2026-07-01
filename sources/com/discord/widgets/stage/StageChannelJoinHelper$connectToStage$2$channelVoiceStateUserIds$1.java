package com.discord.widgets.stage;

import com.discord.api.channel.Channel;
import com.discord.api.voice.state.VoiceState;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StageChannelJoinHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageChannelJoinHelper$connectToStage$2$channelVoiceStateUserIds$1 extends o implements Function1<VoiceState, Boolean> {
    public final /* synthetic */ Channel $channel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageChannelJoinHelper$connectToStage$2$channelVoiceStateUserIds$1(Channel channel) {
        super(1);
        this.$channel = channel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(VoiceState voiceState) {
        return Boolean.valueOf(invoke2(voiceState));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(VoiceState voiceState) {
        m.checkNotNullParameter(voiceState, "it");
        Long channelId = voiceState.getChannelId();
        return channelId != null && channelId.longValue() == this.$channel.getId();
    }
}
