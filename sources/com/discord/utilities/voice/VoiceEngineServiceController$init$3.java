package com.discord.utilities.voice;

import android.content.Context;
import b.a.d.m;
import com.discord.stores.StoreMediaSettings$SelfMuteFailure;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: VoiceEngineServiceController.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VoiceEngineServiceController$init$3 extends o implements Function0<Unit> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ VoiceEngineServiceController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceEngineServiceController$init$3(VoiceEngineServiceController voiceEngineServiceController, Context context) {
        super(0);
        this.this$0 = voiceEngineServiceController;
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreMediaSettings$SelfMuteFailure storeMediaSettings$SelfMuteFailure = VoiceEngineServiceController.access$getMediaSettingsStore$p(this.this$0).toggleSelfMuted();
        if (storeMediaSettings$SelfMuteFailure == null || storeMediaSettings$SelfMuteFailure.ordinal() != 0) {
            return;
        }
        m.g(this.$context, 2131897019, 0, null, 12);
    }
}
