package com.discord.stores;

import com.discord.models.domain.StreamServerUpdate;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$initGatewaySocketListeners$61 extends k implements Function1<StreamServerUpdate, Unit> {
    public StoreStream$initGatewaySocketListeners$61(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleStreamServerUpdate", "handleStreamServerUpdate(Lcom/discord/models/domain/StreamServerUpdate;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StreamServerUpdate streamServerUpdate) {
        invoke2(streamServerUpdate);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StreamServerUpdate streamServerUpdate) {
        m.checkNotNullParameter(streamServerUpdate, "p1");
        StoreStream.access$handleStreamServerUpdate((StoreStream) this.receiver, streamServerUpdate);
    }
}
