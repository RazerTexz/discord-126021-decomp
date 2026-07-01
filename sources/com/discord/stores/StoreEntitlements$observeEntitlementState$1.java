package com.discord.stores;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreEntitlements.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreEntitlements$observeEntitlementState$1 extends o implements Function0<StoreEntitlements$State> {
    public final /* synthetic */ StoreEntitlements this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreEntitlements$observeEntitlementState$1(StoreEntitlements storeEntitlements) {
        super(0);
        this.this$0 = storeEntitlements;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ StoreEntitlements$State invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StoreEntitlements$State invoke() {
        return StoreEntitlements.access$getStateSnapshot$p(this.this$0);
    }
}
