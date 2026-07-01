package com.discord.stores;

import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreRequestedStageChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreRequestedStageChannels$fetchStageChannels$1$2$1 extends o implements Function0<Unit> {
    public final /* synthetic */ List $stageInstances;
    public final /* synthetic */ StoreRequestedStageChannels$fetchStageChannels$1$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreRequestedStageChannels$fetchStageChannels$1$2$1(StoreRequestedStageChannels$fetchStageChannels$1$2 storeRequestedStageChannels$fetchStageChannels$1$2, List list) {
        super(0);
        this.this$0 = storeRequestedStageChannels$fetchStageChannels$1$2;
        this.$stageInstances = list;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreRequestedStageChannels$fetchStageChannels$1$2 storeRequestedStageChannels$fetchStageChannels$1$2 = this.this$0;
        StoreRequestedStageChannels.access$onLoaded(storeRequestedStageChannels$fetchStageChannels$1$2.this$0.this$0, storeRequestedStageChannels$fetchStageChannels$1$2.$channelIdsToRequest, this.$stageInstances);
    }
}
