package com.discord.widgets.settings.premium;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import b.a.k.b;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.WidgetChoosePlanAdapterHeaderItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChoosePlanAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChoosePlanAdapter$HeaderViewHolder extends MGRecyclerViewHolder<WidgetChoosePlanAdapter, WidgetChoosePlanAdapter$Item> {
    private final WidgetChoosePlanAdapterHeaderItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChoosePlanAdapter$HeaderViewHolder(WidgetChoosePlanAdapter widgetChoosePlanAdapter) {
        super(R$layout.widget_choose_plan_adapter_header_item, widgetChoosePlanAdapter);
        m.checkNotNullParameter(widgetChoosePlanAdapter, "adapter");
        View view = this.itemView;
        TextView textView = (TextView) view.findViewById(R$id.select_subscription_header_text);
        if (textView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R$id.select_subscription_header_text)));
        }
        WidgetChoosePlanAdapterHeaderItemBinding widgetChoosePlanAdapterHeaderItemBinding = new WidgetChoosePlanAdapterHeaderItemBinding((FrameLayout) view, textView);
        m.checkNotNullExpressionValue(widgetChoosePlanAdapterHeaderItemBinding, "WidgetChoosePlanAdapterH…temBinding.bind(itemView)");
        this.binding = widgetChoosePlanAdapterHeaderItemBinding;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetChoosePlanAdapter$Item widgetChoosePlanAdapter$Item) {
        onConfigure2(i, widgetChoosePlanAdapter$Item);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, WidgetChoosePlanAdapter$Item data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        TextView textView = this.binding.f2347b;
        m.checkNotNullExpressionValue(textView, "binding.selectSubscriptionHeaderText");
        b.n(textView, ((WidgetChoosePlanAdapter$Item$Header) data).getTitleStringResId(), new Object[0], null, 4);
    }
}
