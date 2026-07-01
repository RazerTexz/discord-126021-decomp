package com.discord.widgets.settings.billing;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: PaymentSourceAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PaymentSourceAdapter$PaymentSourceAddViewHolder$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ PaymentSourceAdapter$PaymentSourceAddViewHolder this$0;

    public PaymentSourceAdapter$PaymentSourceAddViewHolder$onConfigure$1(PaymentSourceAdapter$PaymentSourceAddViewHolder paymentSourceAdapter$PaymentSourceAddViewHolder) {
        this.this$0 = paymentSourceAdapter$PaymentSourceAddViewHolder;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        PaymentSourceAdapter.access$getOnAddClick$p(PaymentSourceAdapter$PaymentSourceAddViewHolder.access$getAdapter$p(this.this$0)).invoke();
    }
}
