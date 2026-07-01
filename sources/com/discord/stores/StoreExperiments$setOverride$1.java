package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreExperiments.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreExperiments$setOverride$1 extends o implements Function0<Unit> {
    public final /* synthetic */ int $bucket;
    public final /* synthetic */ String $experimentName;
    public final /* synthetic */ StoreExperiments this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreExperiments$setOverride$1(StoreExperiments storeExperiments, int i, String str) {
        super(0);
        this.this$0 = storeExperiments;
        this.$bucket = i;
        this.$experimentName = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Integer num = (Integer) StoreExperiments.access$getExperimentOverrides$p(this.this$0).get(this.$experimentName);
        if (num != null && num.intValue() == this.$bucket) {
            return;
        }
        StoreExperiments.access$handleSetOverride(this.this$0, this.$experimentName, this.$bucket);
    }
}
