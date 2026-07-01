package com.discord.widgets.settings.billing;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: SettingsBillingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SettingsBillingViewModel$ViewState$Loaded extends SettingsBillingViewModel$ViewState {
    private final List<PaymentSourceAdapter$Item> paymentSourceItems;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SettingsBillingViewModel$ViewState$Loaded(List<? extends PaymentSourceAdapter$Item> list) {
        super(null);
        m.checkNotNullParameter(list, "paymentSourceItems");
        this.paymentSourceItems = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SettingsBillingViewModel$ViewState$Loaded copy$default(SettingsBillingViewModel$ViewState$Loaded settingsBillingViewModel$ViewState$Loaded, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = settingsBillingViewModel$ViewState$Loaded.paymentSourceItems;
        }
        return settingsBillingViewModel$ViewState$Loaded.copy(list);
    }

    public final List<PaymentSourceAdapter$Item> component1() {
        return this.paymentSourceItems;
    }

    public final SettingsBillingViewModel$ViewState$Loaded copy(List<? extends PaymentSourceAdapter$Item> paymentSourceItems) {
        m.checkNotNullParameter(paymentSourceItems, "paymentSourceItems");
        return new SettingsBillingViewModel$ViewState$Loaded(paymentSourceItems);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof SettingsBillingViewModel$ViewState$Loaded) && m.areEqual(this.paymentSourceItems, ((SettingsBillingViewModel$ViewState$Loaded) other).paymentSourceItems);
        }
        return true;
    }

    public final List<PaymentSourceAdapter$Item> getPaymentSourceItems() {
        return this.paymentSourceItems;
    }

    public int hashCode() {
        List<PaymentSourceAdapter$Item> list = this.paymentSourceItems;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.L(a.U("Loaded(paymentSourceItems="), this.paymentSourceItems, ")");
    }
}
