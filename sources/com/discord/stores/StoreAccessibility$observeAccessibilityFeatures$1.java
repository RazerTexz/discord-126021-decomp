package com.discord.stores;

import com.discord.utilities.accessibility.AccessibilityFeatureFlags;
import d0.z.d.o;
import java.util.EnumSet;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreAccessibility.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAccessibility$observeAccessibilityFeatures$1 extends o implements Function0<EnumSet<AccessibilityFeatureFlags>> {
    public final /* synthetic */ StoreAccessibility this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreAccessibility$observeAccessibilityFeatures$1(StoreAccessibility storeAccessibility) {
        super(0);
        this.this$0 = storeAccessibility;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ EnumSet<AccessibilityFeatureFlags> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final EnumSet<AccessibilityFeatureFlags> invoke2() {
        return this.this$0.getAccessibilityFeatures();
    }
}
