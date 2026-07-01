package com.discord.widgets.user.search;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.stores.StoreNavigation$PanelAction;
import com.discord.widgets.guilds.join.WidgetGuildJoin;
import com.discord.widgets.guilds.join.WidgetGuildJoin$Companion;
import com.discord.widgets.tabs.NavigationTab;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGlobalSearch.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearch$onViewBound$7 implements View$OnClickListener {
    public final /* synthetic */ WidgetGlobalSearch this$0;

    public WidgetGlobalSearch$onViewBound$7(WidgetGlobalSearch widgetGlobalSearch) {
        this.this$0 = widgetGlobalSearch;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetGuildJoin$Companion widgetGuildJoin$Companion = WidgetGuildJoin.Companion;
        m.checkNotNullExpressionValue(view, "it");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "it.context");
        widgetGuildJoin$Companion.show(context, "QuickSwitcher");
        WidgetGlobalSearch.access$onSelected(this.this$0, NavigationTab.HOME, StoreNavigation$PanelAction.OPEN);
    }
}
