package com.discord.stores;

import com.discord.api.voice.server.VoiceServer;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$initGatewaySocketListeners$41 extends k implements Function1<VoiceServer, Unit> {
    public StoreStream$initGatewaySocketListeners$41(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleVoiceServerUpdate", "handleVoiceServerUpdate(Lcom/discord/api/voice/server/VoiceServer;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(VoiceServer voiceServer) {
        invoke2(voiceServer);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(VoiceServer voiceServer) {
        m.checkNotNullParameter(voiceServer, "p1");
        StoreStream.access$handleVoiceServerUpdate((StoreStream) this.receiver, voiceServer);
    }
}
