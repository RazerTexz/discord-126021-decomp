package com.discord.stores;

import com.discord.models.domain.ModelChannelUnreadUpdate;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$initGatewaySocketListeners$21 extends k implements Function1<ModelChannelUnreadUpdate, Unit> {
    public StoreStream$initGatewaySocketListeners$21(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleChannelUnreadUpdate", "handleChannelUnreadUpdate(Lcom/discord/models/domain/ModelChannelUnreadUpdate;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelChannelUnreadUpdate modelChannelUnreadUpdate) {
        invoke2(modelChannelUnreadUpdate);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelChannelUnreadUpdate modelChannelUnreadUpdate) {
        m.checkNotNullParameter(modelChannelUnreadUpdate, "p1");
        StoreStream.access$handleChannelUnreadUpdate((StoreStream) this.receiver, modelChannelUnreadUpdate);
    }
}
