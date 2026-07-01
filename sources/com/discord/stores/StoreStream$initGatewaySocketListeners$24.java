package com.discord.stores;

import com.discord.models.thread.dto.ModelThreadListSync;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$initGatewaySocketListeners$24 extends k implements Function1<ModelThreadListSync, Unit> {
    public StoreStream$initGatewaySocketListeners$24(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleThreadListSync", "handleThreadListSync(Lcom/discord/models/thread/dto/ModelThreadListSync;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelThreadListSync modelThreadListSync) {
        invoke2(modelThreadListSync);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelThreadListSync modelThreadListSync) {
        m.checkNotNullParameter(modelThreadListSync, "p1");
        StoreStream.access$handleThreadListSync((StoreStream) this.receiver, modelThreadListSync);
    }
}
