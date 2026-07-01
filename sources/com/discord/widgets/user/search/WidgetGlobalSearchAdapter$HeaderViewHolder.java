package com.discord.widgets.user.search;

import android.view.View;
import android.widget.TextView;
import com.discord.R$layout;
import com.discord.databinding.WidgetChannelSearchItemHeaderBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.view.extensions.ViewExtensions;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: WidgetGlobalSearchAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchAdapter$HeaderViewHolder extends MGRecyclerViewHolder<WidgetGlobalSearchAdapter, WidgetGlobalSearchModel$ItemDataPayload> {
    private final WidgetChannelSearchItemHeaderBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchAdapter$HeaderViewHolder(WidgetGlobalSearchAdapter widgetGlobalSearchAdapter) {
        super(R$layout.widget_channel_search_item_header, widgetGlobalSearchAdapter);
        m.checkNotNullParameter(widgetGlobalSearchAdapter, "adapter");
        View view = this.itemView;
        Objects.requireNonNull(view, "rootView");
        TextView textView = (TextView) view;
        WidgetChannelSearchItemHeaderBinding widgetChannelSearchItemHeaderBinding = new WidgetChannelSearchItemHeaderBinding(textView, textView);
        m.checkNotNullExpressionValue(widgetChannelSearchItemHeaderBinding, "WidgetChannelSearchItemH…derBinding.bind(itemView)");
        this.binding = widgetChannelSearchItemHeaderBinding;
    }

    public static final /* synthetic */ WidgetGlobalSearchAdapter access$getAdapter$p(WidgetGlobalSearchAdapter$HeaderViewHolder widgetGlobalSearchAdapter$HeaderViewHolder) {
        return (WidgetGlobalSearchAdapter) widgetGlobalSearchAdapter$HeaderViewHolder.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetGlobalSearchModel$ItemDataPayload widgetGlobalSearchModel$ItemDataPayload) {
        onConfigure2(i, widgetGlobalSearchModel$ItemDataPayload);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, WidgetGlobalSearchModel$ItemDataPayload data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        this.binding.f2266b.setText(((WidgetGlobalSearchModel$ItemHeader) data).getName());
        this.binding.a.setOnClickListener(new WidgetGlobalSearchAdapter$HeaderViewHolder$onConfigure$1(this, position, data));
        TextView textView = this.binding.a;
        m.checkNotNullExpressionValue(textView, "binding.root");
        ViewExtensions.setOnLongClickListenerConsumeClick(textView, new WidgetGlobalSearchAdapter$HeaderViewHolder$onConfigure$2(this, position, data));
    }
}
