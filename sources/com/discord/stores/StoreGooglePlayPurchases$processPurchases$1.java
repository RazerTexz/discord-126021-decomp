package com.discord.stores;

import android.content.Context;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGooglePlayPurchases.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGooglePlayPurchases$processPurchases$1 extends o implements Function0<Unit> {
    public final /* synthetic */ List $purchases;
    public final /* synthetic */ String $skuType;
    public final /* synthetic */ StoreGooglePlayPurchases this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGooglePlayPurchases$processPurchases$1(StoreGooglePlayPurchases storeGooglePlayPurchases, List list, String str) {
        super(0);
        this.this$0 = storeGooglePlayPurchases;
        this.$purchases = list;
        this.$skuType = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreGooglePlayPurchases.access$handlePurchases(this.this$0, this.$purchases, this.$skuType);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(this.this$0.observeQueryState(), 0L, false, 3, null), this.this$0.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreGooglePlayPurchases$processPurchases$1$1(this), 62, (Object) null);
    }
}
