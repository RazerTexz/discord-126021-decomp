package com.discord.views.premium;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.discord.R;
import com.discord.databinding.WidgetChoosePlanAdapterPlanItemBinding;
import com.discord.utilities.billing.GooglePlayInAppSku;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GiftSelectView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GiftSelectView extends FrameLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final WidgetChoosePlanAdapterPlanItemBinding binding;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public Function1<? super GooglePlayInAppSku, Unit> onClickPlan;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public GooglePlayInAppSku inAppSku;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GiftSelectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.widget_choose_plan_adapter_plan_item, (ViewGroup) this, false);
        addView(viewInflate);
        WidgetChoosePlanAdapterPlanItemBinding widgetChoosePlanAdapterPlanItemBindingA = WidgetChoosePlanAdapterPlanItemBinding.a(viewInflate);
        Intrinsics3.checkNotNullExpressionValue(widgetChoosePlanAdapterPlanItemBindingA, "WidgetChoosePlanAdapterP…rom(context), this, true)");
        this.binding = widgetChoosePlanAdapterPlanItemBindingA;
    }
}
