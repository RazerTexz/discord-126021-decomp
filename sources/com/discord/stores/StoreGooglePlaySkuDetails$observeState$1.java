package com.discord.stores;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGooglePlaySkuDetails.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGooglePlaySkuDetails$observeState$1 extends o implements Function0<StoreGooglePlaySkuDetails$State> {
    public final /* synthetic */ StoreGooglePlaySkuDetails this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGooglePlaySkuDetails$observeState$1(StoreGooglePlaySkuDetails storeGooglePlaySkuDetails) {
        super(0);
        this.this$0 = storeGooglePlaySkuDetails;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ StoreGooglePlaySkuDetails$State invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StoreGooglePlaySkuDetails$State invoke() {
        return this.this$0.getSkuStateSnapshot();
    }
}
