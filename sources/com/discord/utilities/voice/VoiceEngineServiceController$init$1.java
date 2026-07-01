package com.discord.utilities.voice;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: VoiceEngineServiceController.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VoiceEngineServiceController$init$1 extends o implements Function0<Unit> {
    public final /* synthetic */ VoiceEngineServiceController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceEngineServiceController$init$1(VoiceEngineServiceController voiceEngineServiceController) {
        super(0);
        this.this$0 = voiceEngineServiceController;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        VoiceEngineServiceController.access$getVoiceChannelSelectedStore$p(this.this$0).clear();
    }
}
