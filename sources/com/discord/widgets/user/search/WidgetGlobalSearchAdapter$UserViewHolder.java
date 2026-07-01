package com.discord.widgets.user.search;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGlobalSearchAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchAdapter$UserViewHolder extends WidgetGlobalSearchAdapter$SearchViewHolder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchAdapter$UserViewHolder(WidgetGlobalSearchAdapter widgetGlobalSearchAdapter) {
        super(widgetGlobalSearchAdapter);
        m.checkNotNullParameter(widgetGlobalSearchAdapter, "adapter");
    }

    @Override // com.discord.widgets.user.search.WidgetGlobalSearchAdapter$SearchViewHolder, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetGlobalSearchModel$ItemDataPayload widgetGlobalSearchModel$ItemDataPayload) {
        onConfigure(i, widgetGlobalSearchModel$ItemDataPayload);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.user.search.WidgetGlobalSearchAdapter$SearchViewHolder
    public void onConfigure(int position, WidgetGlobalSearchModel$ItemDataPayload data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        getViewGlobalSearchItem().onConfigure((WidgetGlobalSearchModel$ItemUser) data);
    }
}
