package com.discord.stores;

import b.d.b.a.a;
import com.discord.models.domain.ModelPaymentSource;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: StorePaymentSources.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StorePaymentSources$PaymentSourcesState$Loaded extends StorePaymentSources$PaymentSourcesState {
    private final List<ModelPaymentSource> paymentSources;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StorePaymentSources$PaymentSourcesState$Loaded(List<? extends ModelPaymentSource> list) {
        super(null);
        m.checkNotNullParameter(list, "paymentSources");
        this.paymentSources = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StorePaymentSources$PaymentSourcesState$Loaded copy$default(StorePaymentSources$PaymentSourcesState$Loaded storePaymentSources$PaymentSourcesState$Loaded, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = storePaymentSources$PaymentSourcesState$Loaded.paymentSources;
        }
        return storePaymentSources$PaymentSourcesState$Loaded.copy(list);
    }

    public final List<ModelPaymentSource> component1() {
        return this.paymentSources;
    }

    public final StorePaymentSources$PaymentSourcesState$Loaded copy(List<? extends ModelPaymentSource> paymentSources) {
        m.checkNotNullParameter(paymentSources, "paymentSources");
        return new StorePaymentSources$PaymentSourcesState$Loaded(paymentSources);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof StorePaymentSources$PaymentSourcesState$Loaded) && m.areEqual(this.paymentSources, ((StorePaymentSources$PaymentSourcesState$Loaded) other).paymentSources);
        }
        return true;
    }

    public final List<ModelPaymentSource> getPaymentSources() {
        return this.paymentSources;
    }

    public int hashCode() {
        List<ModelPaymentSource> list = this.paymentSources;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.L(a.U("Loaded(paymentSources="), this.paymentSources, ")");
    }
}
