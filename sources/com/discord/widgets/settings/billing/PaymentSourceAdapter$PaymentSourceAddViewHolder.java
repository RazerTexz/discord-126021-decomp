package com.discord.widgets.settings.billing;

import com.discord.R$layout;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;

/* JADX INFO: compiled from: PaymentSourceAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PaymentSourceAdapter$PaymentSourceAddViewHolder extends MGRecyclerViewHolder<PaymentSourceAdapter, PaymentSourceAdapter$Item> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaymentSourceAdapter$PaymentSourceAddViewHolder(PaymentSourceAdapter paymentSourceAdapter) {
        super(R$layout.payment_method_list_add_item, paymentSourceAdapter);
        m.checkNotNullParameter(paymentSourceAdapter, "adapter");
    }

    public static final /* synthetic */ PaymentSourceAdapter access$getAdapter$p(PaymentSourceAdapter$PaymentSourceAddViewHolder paymentSourceAdapter$PaymentSourceAddViewHolder) {
        return (PaymentSourceAdapter) paymentSourceAdapter$PaymentSourceAddViewHolder.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, PaymentSourceAdapter$Item paymentSourceAdapter$Item) {
        onConfigure2(i, paymentSourceAdapter$Item);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, PaymentSourceAdapter$Item data) {
        m.checkNotNullParameter(data, "data");
        this.itemView.setOnClickListener(new PaymentSourceAdapter$PaymentSourceAddViewHolder$onConfigure$1(this));
    }
}
