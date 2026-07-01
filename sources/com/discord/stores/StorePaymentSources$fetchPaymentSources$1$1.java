package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelPaymentSource;
import com.discord.models.domain.PaymentSourceRaw;
import d0.z.d.m;
import j0.k.b;
import java.util.List;

/* JADX INFO: compiled from: StorePaymentSources.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StorePaymentSources$fetchPaymentSources$1$1<T, R> implements b<List<? extends PaymentSourceRaw>, List<? extends ModelPaymentSource>> {
    public final /* synthetic */ StorePaymentSources$fetchPaymentSources$1 this$0;

    public StorePaymentSources$fetchPaymentSources$1$1(StorePaymentSources$fetchPaymentSources$1 storePaymentSources$fetchPaymentSources$1) {
        this.this$0 = storePaymentSources$fetchPaymentSources$1;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ List<? extends ModelPaymentSource> call(List<? extends PaymentSourceRaw> list) {
        return call2((List<PaymentSourceRaw>) list);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final List<ModelPaymentSource> call2(List<PaymentSourceRaw> list) {
        StorePaymentSources storePaymentSources = this.this$0.this$0;
        m.checkNotNullExpressionValue(list, "it");
        return StorePaymentSources.access$ensureDefaultPaymentSource(storePaymentSources, list);
    }
}
