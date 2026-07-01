package com.discord.stores;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreAccessibility.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAccessibility$observeReducedMotionEnabled$1 extends o implements Function0<Boolean> {
    public final /* synthetic */ StoreAccessibility this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreAccessibility$observeReducedMotionEnabled$1(StoreAccessibility storeAccessibility) {
        super(0);
        this.this$0 = storeAccessibility;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        return StoreAccessibility.access$getReducedMotionEnabled$p(this.this$0);
    }
}
