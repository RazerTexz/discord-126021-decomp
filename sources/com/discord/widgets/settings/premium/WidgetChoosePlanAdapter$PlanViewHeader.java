package com.discord.widgets.settings.premium;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.discord.R$layout;
import com.discord.databinding.WidgetChoosePlanAdapterPlanItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.billing.GooglePlaySku;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.premium.PremiumUtils;
import com.google.android.material.card.MaterialCardView;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChoosePlanAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChoosePlanAdapter$PlanViewHeader extends MGRecyclerViewHolder<WidgetChoosePlanAdapter, WidgetChoosePlanAdapter$Item> {
    private final WidgetChoosePlanAdapterPlanItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChoosePlanAdapter$PlanViewHeader(WidgetChoosePlanAdapter widgetChoosePlanAdapter) {
        super(R$layout.widget_choose_plan_adapter_plan_item, widgetChoosePlanAdapter);
        m.checkNotNullParameter(widgetChoosePlanAdapter, "adapter");
        WidgetChoosePlanAdapterPlanItemBinding widgetChoosePlanAdapterPlanItemBindingA = WidgetChoosePlanAdapterPlanItemBinding.a(this.itemView);
        m.checkNotNullExpressionValue(widgetChoosePlanAdapterPlanItemBindingA, "WidgetChoosePlanAdapterP…temBinding.bind(itemView)");
        this.binding = widgetChoosePlanAdapterPlanItemBindingA;
    }

    public static final /* synthetic */ WidgetChoosePlanAdapter access$getAdapter$p(WidgetChoosePlanAdapter$PlanViewHeader widgetChoosePlanAdapter$PlanViewHeader) {
        return (WidgetChoosePlanAdapter) widgetChoosePlanAdapter$PlanViewHeader.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetChoosePlanAdapter$Item widgetChoosePlanAdapter$Item) {
        onConfigure2(i, widgetChoosePlanAdapter$Item);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, WidgetChoosePlanAdapter$Item data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        WidgetChoosePlanAdapter$Item$Plan widgetChoosePlanAdapter$Item$Plan = (WidgetChoosePlanAdapter$Item$Plan) data;
        TextView textView = this.binding.f;
        m.checkNotNullExpressionValue(textView, "binding.planItemName");
        textView.setText(widgetChoosePlanAdapter$Item$Plan.getSkuDetails().a());
        TextView textView2 = this.binding.g;
        m.checkNotNullExpressionValue(textView2, "binding.planItemPrice");
        PremiumUtils premiumUtils = PremiumUtils.INSTANCE;
        MaterialCardView materialCardView = this.binding.c;
        m.checkNotNullExpressionValue(materialCardView, "binding.planItemContainer");
        Context context = materialCardView.getContext();
        m.checkNotNullExpressionValue(context, "binding.planItemContainer.context");
        textView2.setText(premiumUtils.getPlanPriceText(context, widgetChoosePlanAdapter$Item$Plan.getSkuDetails()));
        this.binding.e.setImageResource(widgetChoosePlanAdapter$Item$Plan.getDisplaySku().getIconDrawableResId());
        TextView textView3 = this.binding.d;
        m.checkNotNullExpressionValue(textView3, "binding.planItemCurrentPlan");
        textView3.setVisibility(widgetChoosePlanAdapter$Item$Plan.isCurrentPlan() ? 0 : 8);
        this.binding.f2348b.setImageResource(widgetChoosePlanAdapter$Item$Plan.isCurrentPlan() ? GooglePlaySku.Companion.getBorderResource(widgetChoosePlanAdapter$Item$Plan.getDisplaySku().getType()) : 0);
        if (widgetChoosePlanAdapter$Item$Plan.getPurchaseSku() == null) {
            TextView textView4 = this.binding.g;
            m.checkNotNullExpressionValue(textView4, "binding.planItemPrice");
            DrawableCompat.setCompoundDrawablesCompat$default(textView4, (Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null, 11, (Object) null);
            return;
        }
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        int themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(view, 2130969516, 0, 2, (Object) null);
        TextView textView5 = this.binding.g;
        m.checkNotNullExpressionValue(textView5, "binding.planItemPrice");
        DrawableCompat.setCompoundDrawablesCompat$default(textView5, 0, 0, themedDrawableRes$default, 0, 11, (Object) null);
        this.binding.c.setOnClickListener(new WidgetChoosePlanAdapter$PlanViewHeader$onConfigure$1(this, data));
    }
}
