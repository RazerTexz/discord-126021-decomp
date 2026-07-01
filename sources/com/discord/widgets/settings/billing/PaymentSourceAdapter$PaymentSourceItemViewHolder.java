package com.discord.widgets.settings.billing;

import android.view.View;
import android.widget.RelativeLayout;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.PaymentMethodListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelPaymentSource;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.google.android.material.button.MaterialButton;
import d0.z.d.m;

/* JADX INFO: compiled from: PaymentSourceAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PaymentSourceAdapter$PaymentSourceItemViewHolder extends MGRecyclerViewHolder<PaymentSourceAdapter, PaymentSourceAdapter$Item> {
    private final PaymentMethodListItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaymentSourceAdapter$PaymentSourceItemViewHolder(PaymentSourceAdapter paymentSourceAdapter) {
        super(R$layout.payment_method_list_item, paymentSourceAdapter);
        m.checkNotNullParameter(paymentSourceAdapter, "adapter");
        View view = this.itemView;
        int i = R$id.payment_method_edit;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.payment_method_edit);
        if (materialButton != null) {
            i = R$id.payment_method_summary;
            PaymentSourceView paymentSourceView = (PaymentSourceView) view.findViewById(R$id.payment_method_summary);
            if (paymentSourceView != null) {
                PaymentMethodListItemBinding paymentMethodListItemBinding = new PaymentMethodListItemBinding((RelativeLayout) view, materialButton, paymentSourceView);
                m.checkNotNullExpressionValue(paymentMethodListItemBinding, "PaymentMethodListItemBinding.bind(itemView)");
                this.binding = paymentMethodListItemBinding;
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ PaymentSourceAdapter access$getAdapter$p(PaymentSourceAdapter$PaymentSourceItemViewHolder paymentSourceAdapter$PaymentSourceItemViewHolder) {
        return (PaymentSourceAdapter) paymentSourceAdapter$PaymentSourceItemViewHolder.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, PaymentSourceAdapter$Item paymentSourceAdapter$Item) {
        onConfigure2(i, paymentSourceAdapter$Item);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, PaymentSourceAdapter$Item data) {
        m.checkNotNullParameter(data, "data");
        PaymentSourceAdapter$PaymentSourceItem paymentSourceAdapter$PaymentSourceItem = (PaymentSourceAdapter$PaymentSourceItem) data;
        ModelPaymentSource paymentSource = paymentSourceAdapter$PaymentSourceItem.getPaymentSource();
        this.binding.c.bind(paymentSource, paymentSourceAdapter$PaymentSourceItem.isPremium());
        this.binding.f2134b.setOnClickListener(new PaymentSourceAdapter$PaymentSourceItemViewHolder$onConfigure$1(this, paymentSource));
    }
}
