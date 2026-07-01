package com.discord.widgets.settings.billing;

import android.view.View;
import android.widget.TextView;
import com.discord.R$layout;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: PaymentSourceAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PaymentSourceAdapter$PaymentSourceHeaderViewHolder extends MGRecyclerViewHolder<PaymentSourceAdapter, PaymentSourceAdapter$Item> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaymentSourceAdapter$PaymentSourceHeaderViewHolder(PaymentSourceAdapter paymentSourceAdapter) {
        super(R$layout.payment_method_list_header, paymentSourceAdapter);
        m.checkNotNullParameter(paymentSourceAdapter, "adapter");
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, PaymentSourceAdapter$Item paymentSourceAdapter$Item) {
        onConfigure2(i, paymentSourceAdapter$Item);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, PaymentSourceAdapter$Item data) {
        int i;
        m.checkNotNullParameter(data, "data");
        View view = this.itemView;
        Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) view;
        int iOrdinal = ((PaymentSourceAdapter$PaymentSourceHeader) data).getHeaderType().ordinal();
        if (iOrdinal == 0) {
            i = 2131886086;
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            i = 2131893538;
        }
        textView.setText(i);
    }
}
