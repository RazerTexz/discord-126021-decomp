package com.discord.stores;

import com.discord.rtcconnection.mediaengine.MediaEngine;
import com.discord.utilities.analytics.AnalyticsTracker;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: com.discord.stores.StoreMediaEngine$init$echoCancellationCallback$1$onEchoCancellationUpdated$1 */
/* JADX INFO: compiled from: StoreMediaEngine.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C6174x527da00c extends AbstractC12240o implements Function0<Unit> {
    public final /* synthetic */ MediaEngine.EchoCancellationInfo $info;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C6174x527da00c(MediaEngine.EchoCancellationInfo echoCancellationInfo) {
        super(0);
        this.$info = echoCancellationInfo;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        AnalyticsTracker.INSTANCE.echoCancellationConfigured(this.$info);
    }
}
