package com.discord.widgets.user.search;

import android.view.View;
import com.discord.R$layout;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.view.extensions.ViewExtensions;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: WidgetGlobalSearchAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class WidgetGlobalSearchAdapter$SearchViewHolder extends MGRecyclerViewHolder<WidgetGlobalSearchAdapter, WidgetGlobalSearchModel$ItemDataPayload> {
    private final ViewGlobalSearchItem viewGlobalSearchItem;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchAdapter$SearchViewHolder(WidgetGlobalSearchAdapter widgetGlobalSearchAdapter) {
        super(R$layout.widget_channel_search_item, widgetGlobalSearchAdapter);
        m.checkNotNullParameter(widgetGlobalSearchAdapter, "adapter");
        View view = this.itemView;
        Objects.requireNonNull(view, "null cannot be cast to non-null type com.discord.widgets.user.search.ViewGlobalSearchItem");
        ViewGlobalSearchItem viewGlobalSearchItem = (ViewGlobalSearchItem) view;
        viewGlobalSearchItem.setSelected(true);
        this.viewGlobalSearchItem = viewGlobalSearchItem;
    }

    public static final /* synthetic */ WidgetGlobalSearchAdapter access$getAdapter$p(WidgetGlobalSearchAdapter$SearchViewHolder widgetGlobalSearchAdapter$SearchViewHolder) {
        return (WidgetGlobalSearchAdapter) widgetGlobalSearchAdapter$SearchViewHolder.adapter;
    }

    public final ViewGlobalSearchItem getViewGlobalSearchItem() {
        return this.viewGlobalSearchItem;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetGlobalSearchModel$ItemDataPayload widgetGlobalSearchModel$ItemDataPayload) {
        onConfigure(i, widgetGlobalSearchModel$ItemDataPayload);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    public void onConfigure(int position, WidgetGlobalSearchModel$ItemDataPayload data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        this.itemView.setOnClickListener(new WidgetGlobalSearchAdapter$SearchViewHolder$onConfigure$1(this, position, data));
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        ViewExtensions.setOnLongClickListenerConsumeClick(view, new WidgetGlobalSearchAdapter$SearchViewHolder$onConfigure$2(this, position, data));
    }
}
