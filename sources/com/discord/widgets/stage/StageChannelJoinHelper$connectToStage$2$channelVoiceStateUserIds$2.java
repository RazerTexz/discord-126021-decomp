package com.discord.widgets.stage;

import com.discord.api.voice.state.VoiceState;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StageChannelJoinHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageChannelJoinHelper$connectToStage$2$channelVoiceStateUserIds$2 extends o implements Function1<VoiceState, Long> {
    public static final StageChannelJoinHelper$connectToStage$2$channelVoiceStateUserIds$2 INSTANCE = new StageChannelJoinHelper$connectToStage$2$channelVoiceStateUserIds$2();

    public StageChannelJoinHelper$connectToStage$2$channelVoiceStateUserIds$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Long invoke(VoiceState voiceState) {
        return Long.valueOf(invoke2(voiceState));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2(VoiceState voiceState) {
        m.checkNotNullParameter(voiceState, "it");
        return voiceState.getUserId();
    }
}
