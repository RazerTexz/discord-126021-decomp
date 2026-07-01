package com.discord.stores;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreExperiments.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreExperiments$getExperimentalAlpha$1 extends o implements Function0<Boolean> {
    public final /* synthetic */ StoreExperiments this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreExperiments$getExperimentalAlpha$1(StoreExperiments storeExperiments) {
        super(0);
        this.this$0 = storeExperiments;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        return StoreExperiments.Companion.isExperimentalAlpha(StoreExperiments.access$getStoreGuilds$p(this.this$0), StoreExperiments.access$getStoreUser$p(this.this$0));
    }
}
