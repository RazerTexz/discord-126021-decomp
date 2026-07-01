package com.discord.stores;

import android.content.Context;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: StorePaymentSources.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StorePaymentSources$fetchPaymentSources$1 extends o implements Function0<Unit> {
    public final /* synthetic */ StorePaymentSources this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StorePaymentSources$fetchPaymentSources$1(StorePaymentSources storePaymentSources) {
        super(0);
        this.this$0 = storePaymentSources;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (StorePaymentSources.access$getPaymentSourcesState$p(this.this$0) instanceof StorePaymentSources$PaymentSourcesState$Loading) {
            return;
        }
        StorePaymentSources.access$handlePaymentSourcesFetchStart(this.this$0);
        Observable observableG = ObservableExtensionsKt.restSubscribeOn$default(StorePaymentSources.access$getRestAPI$p(this.this$0).getPaymentSources(), false, 1, null).G(new StorePaymentSources$fetchPaymentSources$1$1(this));
        m.checkNotNullExpressionValue(observableG, "restAPI\n          .getPa…efaultPaymentSource(it) }");
        ObservableExtensionsKt.appSubscribe$default(observableG, this.this$0.getClass(), (Context) null, (Function1) null, new StorePaymentSources$fetchPaymentSources$1$3(this), (Function0) null, (Function0) null, new StorePaymentSources$fetchPaymentSources$1$2(this), 54, (Object) null);
    }
}
