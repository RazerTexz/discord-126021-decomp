package com.discord.stores;

import com.discord.api.stageinstance.StageInstance;
import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreStageInstances.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStageInstances$observeStageInstances$1 extends o implements Function0<Map<Long, ? extends StageInstance>> {
    public final /* synthetic */ StoreStageInstances this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreStageInstances$observeStageInstances$1(StoreStageInstances storeStageInstances) {
        super(0);
        this.this$0 = storeStageInstances;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<Long, ? extends StageInstance> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<Long, ? extends StageInstance> invoke2() {
        return this.this$0.getStageInstances();
    }
}
