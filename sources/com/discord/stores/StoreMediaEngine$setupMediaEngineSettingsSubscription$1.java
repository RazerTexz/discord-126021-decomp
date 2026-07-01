package com.discord.stores;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreMediaEngine.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMediaEngine$setupMediaEngineSettingsSubscription$1 extends o implements Function1<StoreMediaSettings$VoiceConfiguration, Unit> {
    public final /* synthetic */ StoreMediaEngine this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMediaEngine$setupMediaEngineSettingsSubscription$1(StoreMediaEngine storeMediaEngine) {
        super(1);
        this.this$0 = storeMediaEngine;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration) {
        invoke2(storeMediaSettings$VoiceConfiguration);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration) {
        m.checkNotNullParameter(storeMediaSettings$VoiceConfiguration, "voiceConfig");
        StoreMediaEngine.access$getDispatcher$p(this.this$0).schedule(new StoreMediaEngine$setupMediaEngineSettingsSubscription$1$1(this, storeMediaSettings$VoiceConfiguration));
    }
}
