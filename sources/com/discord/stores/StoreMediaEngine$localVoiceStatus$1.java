package com.discord.stores;

import d0.z.d.FunctionReferenceImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreMediaEngine.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreMediaEngine$localVoiceStatus$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public StoreMediaEngine$localVoiceStatus$1(StoreMediaEngine storeMediaEngine) {
        super(0, storeMediaEngine, StoreMediaEngine.class, "enableLocalVoiceStatusListening", "enableLocalVoiceStatusListening()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((StoreMediaEngine) this.receiver).enableLocalVoiceStatusListening();
    }
}
