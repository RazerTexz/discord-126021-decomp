package com.discord.stores;

import com.discord.models.domain.ModelBan;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$initGatewaySocketListeners$11 extends k implements Function1<ModelBan, Unit> {
    public StoreStream$initGatewaySocketListeners$11(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleBanAdd", "handleBanAdd(Lcom/discord/models/domain/ModelBan;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelBan modelBan) {
        invoke2(modelBan);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelBan modelBan) {
        m.checkNotNullParameter(modelBan, "p1");
        StoreStream.access$handleBanAdd((StoreStream) this.receiver, modelBan);
    }
}
