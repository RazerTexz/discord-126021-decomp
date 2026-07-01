package com.discord.stores;

import com.discord.rtcconnection.mediaengine.MediaEngineConnection$InputMode;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreAnalytics.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAnalytics$init$1 extends o implements Function1<MediaEngineConnection$InputMode, Unit> {
    public final /* synthetic */ StoreAnalytics this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreAnalytics$init$1(StoreAnalytics storeAnalytics) {
        super(1);
        this.this$0 = storeAnalytics;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MediaEngineConnection$InputMode mediaEngineConnection$InputMode) {
        invoke2(mediaEngineConnection$InputMode);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MediaEngineConnection$InputMode mediaEngineConnection$InputMode) {
        m.checkNotNullParameter(mediaEngineConnection$InputMode, "it");
        StoreAnalytics.access$setInputMode$p(this.this$0, mediaEngineConnection$InputMode.toString());
    }
}
