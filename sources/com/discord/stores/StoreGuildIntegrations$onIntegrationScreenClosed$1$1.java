package com.discord.stores;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGuildIntegrations.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreGuildIntegrations$onIntegrationScreenClosed$1$1 extends k implements Function0<Unit> {
    public StoreGuildIntegrations$onIntegrationScreenClosed$1$1(StoreGuildIntegrations storeGuildIntegrations) {
        super(0, storeGuildIntegrations, StoreGuildIntegrations.class, "handleIntegrationScreenClosed", "handleIntegrationScreenClosed()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreGuildIntegrations.access$handleIntegrationScreenClosed((StoreGuildIntegrations) this.receiver);
    }
}
