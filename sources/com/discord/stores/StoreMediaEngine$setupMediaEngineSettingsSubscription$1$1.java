package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreMediaEngine.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMediaEngine$setupMediaEngineSettingsSubscription$1$1 extends o implements Function0<Unit> {
    public final /* synthetic */ StoreMediaSettings$VoiceConfiguration $voiceConfig;
    public final /* synthetic */ StoreMediaEngine$setupMediaEngineSettingsSubscription$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMediaEngine$setupMediaEngineSettingsSubscription$1$1(StoreMediaEngine$setupMediaEngineSettingsSubscription$1 storeMediaEngine$setupMediaEngineSettingsSubscription$1, StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration) {
        super(0);
        this.this$0 = storeMediaEngine$setupMediaEngineSettingsSubscription$1;
        this.$voiceConfig = storeMediaSettings$VoiceConfiguration;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreMediaEngine.access$handleVoiceConfigChanged(this.this$0.this$0, this.$voiceConfig);
    }
}
