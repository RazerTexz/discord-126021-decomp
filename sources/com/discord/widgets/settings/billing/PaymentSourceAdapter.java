package com.discord.widgets.settings.billing;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import b.d.b.a.a;
import com.discord.models.domain.ModelPaymentSource;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: PaymentSourceAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PaymentSourceAdapter extends MGRecyclerAdapterSimple<PaymentSourceAdapter$Item> {
    public static final PaymentSourceAdapter$Companion Companion = new PaymentSourceAdapter$Companion(null);
    private static final int VIEW_TYPE_HEADER = 2;
    private static final int VIEW_TYPE_PAYMENT_ADD = 1;
    private static final int VIEW_TYPE_PAYMENT_SOURCE = 0;
    private final Function0<Unit> onAddClick;
    private final Function1<ModelPaymentSource, Unit> onEditPaymentSource;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PaymentSourceAdapter(RecyclerView recyclerView, Function0<Unit> function0, Function1<? super ModelPaymentSource, Unit> function1) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
        m.checkNotNullParameter(function0, "onAddClick");
        m.checkNotNullParameter(function1, "onEditPaymentSource");
        this.onAddClick = function0;
        this.onEditPaymentSource = function1;
    }

    public static final /* synthetic */ Function0 access$getOnAddClick$p(PaymentSourceAdapter paymentSourceAdapter) {
        return paymentSourceAdapter.onAddClick;
    }

    public static final /* synthetic */ Function1 access$getOnEditPaymentSource$p(PaymentSourceAdapter paymentSourceAdapter) {
        return paymentSourceAdapter.onEditPaymentSource;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public MGRecyclerViewHolder<?, PaymentSourceAdapter$Item> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new PaymentSourceAdapter$PaymentSourceItemViewHolder(this);
        }
        if (viewType == 1) {
            return new PaymentSourceAdapter$PaymentSourceAddViewHolder(this);
        }
        if (viewType == 2) {
            return new PaymentSourceAdapter$PaymentSourceHeaderViewHolder(this);
        }
        throw new IllegalArgumentException(a.q("unknown type ", viewType));
    }
}
