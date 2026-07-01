package com.discord.stores;

import com.discord.models.domain.ModelPayload;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$initGatewaySocketListeners$1 extends k implements Function1<ModelPayload, Unit> {
    public StoreStream$initGatewaySocketListeners$1(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleConnectionOpen", "handleConnectionOpen(Lcom/discord/models/domain/ModelPayload;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelPayload modelPayload) {
        invoke2(modelPayload);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelPayload modelPayload) {
        m.checkNotNullParameter(modelPayload, "p1");
        StoreStream.access$handleConnectionOpen((StoreStream) this.receiver, modelPayload);
    }
}
