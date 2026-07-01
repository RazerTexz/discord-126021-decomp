package com.discord.stores;

import com.discord.api.voice.state.VoiceState;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$initGatewaySocketListeners$40 extends k implements Function1<VoiceState, Unit> {
    public StoreStream$initGatewaySocketListeners$40(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleVoiceStateUpdate", "handleVoiceStateUpdate(Lcom/discord/api/voice/state/VoiceState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(VoiceState voiceState) {
        invoke2(voiceState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(VoiceState voiceState) {
        m.checkNotNullParameter(voiceState, "p1");
        StoreStream.access$handleVoiceStateUpdate((StoreStream) this.receiver, voiceState);
    }
}
