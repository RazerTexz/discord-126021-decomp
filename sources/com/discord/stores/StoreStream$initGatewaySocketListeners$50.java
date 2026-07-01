package com.discord.stores;

import com.discord.models.domain.ModelCall;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$initGatewaySocketListeners$50 extends k implements Function1<ModelCall, Unit> {
    public StoreStream$initGatewaySocketListeners$50(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleCallCreateOrUpdate", "handleCallCreateOrUpdate(Lcom/discord/models/domain/ModelCall;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelCall modelCall) {
        invoke2(modelCall);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelCall modelCall) {
        m.checkNotNullParameter(modelCall, "p1");
        StoreStream.access$handleCallCreateOrUpdate((StoreStream) this.receiver, modelCall);
    }
}
