package com.discord.widgets.settings.premium;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetChoosePlanAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChoosePlanAdapter$PlanViewHeader$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetChoosePlanAdapter$Item $data;
    public final /* synthetic */ WidgetChoosePlanAdapter$PlanViewHeader this$0;

    public WidgetChoosePlanAdapter$PlanViewHeader$onConfigure$1(WidgetChoosePlanAdapter$PlanViewHeader widgetChoosePlanAdapter$PlanViewHeader, WidgetChoosePlanAdapter$Item widgetChoosePlanAdapter$Item) {
        this.this$0 = widgetChoosePlanAdapter$PlanViewHeader;
        this.$data = widgetChoosePlanAdapter$Item;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChoosePlanAdapter.access$getOnClickPlan$p(WidgetChoosePlanAdapter$PlanViewHeader.access$getAdapter$p(this.this$0)).invoke(((WidgetChoosePlanAdapter$Item$Plan) this.$data).getPurchaseSku(), ((WidgetChoosePlanAdapter$Item$Plan) this.$data).getOldSkuName(), ((WidgetChoosePlanAdapter$Item$Plan) this.$data).getUpgradeSkuDetails());
    }
}
