package com.discord.stores;

import com.discord.utilities.accessibility.AccessibilityState;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreAccessibility.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAccessibility$init$1$1 extends o implements Function0<Unit> {
    public final /* synthetic */ AccessibilityState $it;
    public final /* synthetic */ StoreAccessibility$init$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreAccessibility$init$1$1(StoreAccessibility$init$1 storeAccessibility$init$1, AccessibilityState accessibilityState) {
        super(0);
        this.this$0 = storeAccessibility$init$1;
        this.$it = accessibilityState;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreAccessibility.access$updateMonitoredAccessibilityState(this.this$0.this$0, this.$it);
    }
}
