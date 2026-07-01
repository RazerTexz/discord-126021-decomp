package com.discord.stores;

import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGooglePlaySkuDetails.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGooglePlaySkuDetails$updateSkuDetails$1 extends o implements Function0<Unit> {
    public final /* synthetic */ List $skuDetails;
    public final /* synthetic */ StoreGooglePlaySkuDetails this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGooglePlaySkuDetails$updateSkuDetails$1(StoreGooglePlaySkuDetails storeGooglePlaySkuDetails, List list) {
        super(0);
        this.this$0 = storeGooglePlaySkuDetails;
        this.$skuDetails = list;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.handleFetchSuccess(this.$skuDetails);
    }
}
