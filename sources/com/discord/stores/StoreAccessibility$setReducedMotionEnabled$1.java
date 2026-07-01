package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreAccessibility.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAccessibility$setReducedMotionEnabled$1 extends o implements Function0<Unit> {
    public final /* synthetic */ boolean $enabled;
    public final /* synthetic */ StoreAccessibility this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreAccessibility$setReducedMotionEnabled$1(StoreAccessibility storeAccessibility, boolean z2) {
        super(0);
        this.this$0 = storeAccessibility;
        this.$enabled = z2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreAccessibility.access$setReducedMotionEnabled$p(this.this$0, this.$enabled);
        this.this$0.markChanged();
    }
}
