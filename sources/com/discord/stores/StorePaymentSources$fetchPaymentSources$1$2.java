package com.discord.stores;

import com.discord.models.domain.ModelPaymentSource;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StorePaymentSources.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StorePaymentSources$fetchPaymentSources$1$2 extends o implements Function1<List<? extends ModelPaymentSource>, Unit> {
    public final /* synthetic */ StorePaymentSources$fetchPaymentSources$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StorePaymentSources$fetchPaymentSources$1$2(StorePaymentSources$fetchPaymentSources$1 storePaymentSources$fetchPaymentSources$1) {
        super(1);
        this.this$0 = storePaymentSources$fetchPaymentSources$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelPaymentSource> list) {
        invoke2(list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends ModelPaymentSource> list) {
        StorePaymentSources.access$getDispatcher$p(this.this$0.this$0).schedule(new StorePaymentSources$fetchPaymentSources$1$2$1(this, list));
    }
}
