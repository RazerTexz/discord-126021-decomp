package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGuildIntegrations.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildIntegrations$onIntegrationScreenClosed$1 extends o implements Function1<Long, Unit> {
    public final /* synthetic */ StoreGuildIntegrations this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildIntegrations$onIntegrationScreenClosed$1(StoreGuildIntegrations storeGuildIntegrations) {
        super(1);
        this.this$0 = storeGuildIntegrations;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke2(l);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Long l) {
        StoreGuildIntegrations.access$getDispatcher$p(this.this$0).schedule(new StoreGuildIntegrations$onIntegrationScreenClosed$1$1(this.this$0));
    }
}
