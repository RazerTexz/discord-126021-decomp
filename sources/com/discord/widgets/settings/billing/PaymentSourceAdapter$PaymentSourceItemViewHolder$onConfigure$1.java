package com.discord.widgets.settings.billing;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.models.domain.ModelPaymentSource;

/* JADX INFO: compiled from: PaymentSourceAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PaymentSourceAdapter$PaymentSourceItemViewHolder$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ ModelPaymentSource $paymentSource;
    public final /* synthetic */ PaymentSourceAdapter$PaymentSourceItemViewHolder this$0;

    public PaymentSourceAdapter$PaymentSourceItemViewHolder$onConfigure$1(PaymentSourceAdapter$PaymentSourceItemViewHolder paymentSourceAdapter$PaymentSourceItemViewHolder, ModelPaymentSource modelPaymentSource) {
        this.this$0 = paymentSourceAdapter$PaymentSourceItemViewHolder;
        this.$paymentSource = modelPaymentSource;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        PaymentSourceAdapter.access$getOnEditPaymentSource$p(PaymentSourceAdapter$PaymentSourceItemViewHolder.access$getAdapter$p(this.this$0)).invoke(this.$paymentSource);
    }
}
