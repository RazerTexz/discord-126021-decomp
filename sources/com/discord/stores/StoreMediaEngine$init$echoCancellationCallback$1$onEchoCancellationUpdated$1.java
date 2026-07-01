package com.discord.stores;

import com.discord.rtcconnection.mediaengine.MediaEngine;
import com.discord.utilities.analytics.AnalyticsTracker;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreMediaEngine.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMediaEngine$init$echoCancellationCallback$1$onEchoCancellationUpdated$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ MediaEngine.EchoCancellationInfo $info;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMediaEngine$init$echoCancellationCallback$1$onEchoCancellationUpdated$1(MediaEngine.EchoCancellationInfo echoCancellationInfo) {
        super(0);
        this.$info = echoCancellationInfo;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        AnalyticsTracker.INSTANCE.echoCancellationConfigured(this.$info);
    }
}
