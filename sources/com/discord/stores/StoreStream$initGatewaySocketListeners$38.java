package com.discord.stores;

import com.discord.models.domain.ModelMessageDelete;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$initGatewaySocketListeners$38 extends k implements Function1<ModelMessageDelete, Unit> {
    public StoreStream$initGatewaySocketListeners$38(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleMessageDelete", "handleMessageDelete(Lcom/discord/models/domain/ModelMessageDelete;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelMessageDelete modelMessageDelete) {
        invoke2(modelMessageDelete);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelMessageDelete modelMessageDelete) {
        m.checkNotNullParameter(modelMessageDelete, "p1");
        StoreStream.access$handleMessageDelete((StoreStream) this.receiver, modelMessageDelete);
    }
}
