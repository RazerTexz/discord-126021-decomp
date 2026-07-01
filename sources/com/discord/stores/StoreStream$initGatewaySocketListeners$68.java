package com.discord.stores;

import com.discord.api.stageinstance.StageInstance;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$initGatewaySocketListeners$68 extends k implements Function1<StageInstance, Unit> {
    public StoreStream$initGatewaySocketListeners$68(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleStageInstanceUpdate", "handleStageInstanceUpdate(Lcom/discord/api/stageinstance/StageInstance;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StageInstance stageInstance) {
        invoke2(stageInstance);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StageInstance stageInstance) {
        m.checkNotNullParameter(stageInstance, "p1");
        ((StoreStream) this.receiver).handleStageInstanceUpdate(stageInstance);
    }
}
