package com.discord.widgets.stage;

import com.discord.api.voice.state.VoiceState;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.stage.StageChannelJoinHelper$connectToStage$2$channelVoiceStateUserIds$2, reason: use source file name */
/* JADX INFO: compiled from: StageChannelJoinHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageChannelJoinHelper3 extends Lambda implements Function1<VoiceState, Long> {
    public static final StageChannelJoinHelper3 INSTANCE = new StageChannelJoinHelper3();

    public StageChannelJoinHelper3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Long invoke(VoiceState voiceState) {
        return Long.valueOf(invoke2(voiceState));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2(VoiceState voiceState) {
        Intrinsics3.checkNotNullParameter(voiceState, "it");
        return voiceState.getUserId();
    }
}
