package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGooglePlayPurchases.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGooglePlayPurchases$doDowngrade$2 extends o implements Function1<Object, Unit> {
    public final /* synthetic */ String $newSkuName;
    public final /* synthetic */ StoreGooglePlayPurchases this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGooglePlayPurchases$doDowngrade$2(StoreGooglePlayPurchases storeGooglePlayPurchases, String str) {
        super(1);
        this.this$0 = storeGooglePlayPurchases;
        this.$newSkuName = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
        invoke2(obj);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Object obj) {
        StoreGooglePlayPurchases.access$getDispatcher$p(this.this$0).schedule(new StoreGooglePlayPurchases$doDowngrade$2$1(this));
    }
}
