package com.discord.stores;

import com.discord.api.stageinstance.StageInstance;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreStageInstances.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStageInstances$observeStageInstanceForChannel$1 extends o implements Function0<StageInstance> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StoreStageInstances this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreStageInstances$observeStageInstanceForChannel$1(StoreStageInstances storeStageInstances, long j) {
        super(0);
        this.this$0 = storeStageInstances;
        this.$channelId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ StageInstance invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StageInstance invoke() {
        return this.this$0.getStageInstanceForChannel(this.$channelId);
    }
}
