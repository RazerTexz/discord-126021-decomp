package com.discord.stores;

import com.discord.utilities.accessibility.AccessibilityState;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreAccessibility.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAccessibility$init$1 extends o implements Function1<AccessibilityState, Unit> {
    public final /* synthetic */ StoreAccessibility this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreAccessibility$init$1(StoreAccessibility storeAccessibility) {
        super(1);
        this.this$0 = storeAccessibility;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AccessibilityState accessibilityState) {
        invoke2(accessibilityState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(AccessibilityState accessibilityState) {
        m.checkNotNullParameter(accessibilityState, "it");
        StoreAccessibility.access$getDispatcher$p(this.this$0).schedule(new StoreAccessibility$init$1$1(this, accessibilityState));
    }
}
