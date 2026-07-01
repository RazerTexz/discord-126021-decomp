package com.discord.widgets.settings.premium;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.android.billingclient.api.SkuDetails;
import com.discord.utilities.billing.GooglePlaySku;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: WidgetChoosePlanAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChoosePlanAdapter extends MGRecyclerAdapterSimple<WidgetChoosePlanAdapter$Item> {
    private Function3<? super GooglePlaySku, ? super String, ? super SkuDetails, Unit> onClickPlan;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChoosePlanAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
        this.onClickPlan = WidgetChoosePlanAdapter$onClickPlan$1.INSTANCE;
    }

    public static final /* synthetic */ Function3 access$getOnClickPlan$p(WidgetChoosePlanAdapter widgetChoosePlanAdapter) {
        return widgetChoosePlanAdapter.onClickPlan;
    }

    public static final /* synthetic */ void access$setOnClickPlan$p(WidgetChoosePlanAdapter widgetChoosePlanAdapter, Function3 function3) {
        widgetChoosePlanAdapter.onClickPlan = function3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setOnClickPlan(Function3<? super GooglePlaySku, ? super String, ? super SkuDetails, Unit> onClickPlan) {
        m.checkNotNullParameter(onClickPlan, "onClickPlan");
        this.onClickPlan = onClickPlan;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public MGRecyclerViewHolder<WidgetChoosePlanAdapter, WidgetChoosePlanAdapter$Item> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new WidgetChoosePlanAdapter$HeaderViewHolder(this);
        }
        if (viewType == 1) {
            return new WidgetChoosePlanAdapter$PlanViewHeader(this);
        }
        if (viewType == 2) {
            return new WidgetChoosePlanAdapter$DividerViewHolder(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
