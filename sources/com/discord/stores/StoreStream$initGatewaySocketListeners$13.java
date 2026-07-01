package com.discord.stores;

import com.discord.models.domain.ModelGuildIntegration$Update;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$initGatewaySocketListeners$13 extends k implements Function1<ModelGuildIntegration$Update, Unit> {
    public StoreStream$initGatewaySocketListeners$13(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleGuildIntegrationUpdate", "handleGuildIntegrationUpdate(Lcom/discord/models/domain/ModelGuildIntegration$Update;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelGuildIntegration$Update modelGuildIntegration$Update) {
        invoke2(modelGuildIntegration$Update);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelGuildIntegration$Update modelGuildIntegration$Update) {
        m.checkNotNullParameter(modelGuildIntegration$Update, "p1");
        StoreStream.access$handleGuildIntegrationUpdate((StoreStream) this.receiver, modelGuildIntegration$Update);
    }
}
