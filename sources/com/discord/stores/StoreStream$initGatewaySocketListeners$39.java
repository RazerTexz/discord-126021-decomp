package com.discord.stores;

import com.discord.models.domain.ModelReadState;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$initGatewaySocketListeners$39 extends k implements Function1<ModelReadState, Unit> {
    public StoreStream$initGatewaySocketListeners$39(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleMessageAck", "handleMessageAck(Lcom/discord/models/domain/ModelReadState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelReadState modelReadState) {
        invoke2(modelReadState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelReadState modelReadState) {
        m.checkNotNullParameter(modelReadState, "p1");
        StoreStream.access$handleMessageAck((StoreStream) this.receiver, modelReadState);
    }
}
