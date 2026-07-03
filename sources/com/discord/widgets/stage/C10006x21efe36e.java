package com.discord.widgets.stage;

import com.discord.api.channel.Channel;
import com.discord.api.voice.state.VoiceState;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.stage.StageChannelJoinHelper$connectToStage$2$channelVoiceStateUserIds$1 */
/* JADX INFO: compiled from: StageChannelJoinHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C10006x21efe36e extends AbstractC12240o implements Function1<VoiceState, Boolean> {
    public final /* synthetic */ Channel $channel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C10006x21efe36e(Channel channel) {
        super(1);
        this.$channel = channel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(VoiceState voiceState) {
        return Boolean.valueOf(invoke2(voiceState));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(VoiceState voiceState) {
        C12238m.checkNotNullParameter(voiceState, "it");
        Long channelId = voiceState.getChannelId();
        return channelId != null && channelId.longValue() == this.$channel.getId();
    }
}
