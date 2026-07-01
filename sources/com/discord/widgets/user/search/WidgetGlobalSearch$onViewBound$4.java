package com.discord.widgets.user.search;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetGlobalSearch.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearch$onViewBound$4 implements View$OnClickListener {
    public final /* synthetic */ WidgetGlobalSearch this$0;

    public WidgetGlobalSearch$onViewBound$4(WidgetGlobalSearch widgetGlobalSearch) {
        this.this$0 = widgetGlobalSearch;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetGlobalSearch widgetGlobalSearch = this.this$0;
        widgetGlobalSearch.hideKeyboard(WidgetGlobalSearch.access$getBinding$p(widgetGlobalSearch).c);
        WidgetGlobalSearch.access$getDismissViewModel$p(this.this$0).dismiss();
    }
}
