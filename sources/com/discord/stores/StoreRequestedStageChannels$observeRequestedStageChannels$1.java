package com.discord.stores;

import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreRequestedStageChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreRequestedStageChannels$observeRequestedStageChannels$1 extends o implements Function0<Map<Long, ? extends StoreRequestedStageChannels$StageInstanceState>> {
    public final /* synthetic */ StoreRequestedStageChannels this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreRequestedStageChannels$observeRequestedStageChannels$1(StoreRequestedStageChannels storeRequestedStageChannels) {
        super(0);
        this.this$0 = storeRequestedStageChannels;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<Long, ? extends StoreRequestedStageChannels$StageInstanceState> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<Long, ? extends StoreRequestedStageChannels$StageInstanceState> invoke2() {
        return this.this$0.getRequestedInstanceStatesByChannel();
    }
}
