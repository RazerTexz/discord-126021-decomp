package com.discord.widgets.stage;

import com.discord.api.voice.state.VoiceState;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.stage.StageChannelJoinHelper$connectToStage$2$channelVoiceStateUserIds$2 */
/* JADX INFO: compiled from: StageChannelJoinHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C10007x21efe36f extends AbstractC12240o implements Function1<VoiceState, Long> {
    public static final C10007x21efe36f INSTANCE = new C10007x21efe36f();

    public C10007x21efe36f() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Long invoke(VoiceState voiceState) {
        return Long.valueOf(invoke2(voiceState));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2(VoiceState voiceState) {
        C12238m.checkNotNullParameter(voiceState, "it");
        return voiceState.getUserId();
    }
}
