package com.discord.utilities.voice;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: CallSoundManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CallSoundManager$subscribeToStoreState$3 extends o implements Function1<CallSoundManager$StoreState, Unit> {
    public final /* synthetic */ long $voiceChannelId;
    public final /* synthetic */ CallSoundManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallSoundManager$subscribeToStoreState$3(CallSoundManager callSoundManager, long j) {
        super(1);
        this.this$0 = callSoundManager;
        this.$voiceChannelId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CallSoundManager$StoreState callSoundManager$StoreState) {
        invoke2(callSoundManager$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(CallSoundManager$StoreState callSoundManager$StoreState) {
        CallSoundManager callSoundManager = this.this$0;
        long j = this.$voiceChannelId;
        m.checkNotNullExpressionValue(callSoundManager$StoreState, "storeState");
        CallSoundManager.access$handleStoreState(callSoundManager, j, callSoundManager$StoreState);
    }
}
