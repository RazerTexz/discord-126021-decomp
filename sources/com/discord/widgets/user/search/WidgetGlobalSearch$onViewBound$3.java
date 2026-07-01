package com.discord.widgets.user.search;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetGlobalSearch.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearch$onViewBound$3 implements View$OnClickListener {
    public final /* synthetic */ WidgetGlobalSearch this$0;

    public WidgetGlobalSearch$onViewBound$3(WidgetGlobalSearch widgetGlobalSearch) {
        this.this$0 = widgetGlobalSearch;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetGlobalSearch.access$showFilterPickerDialog(this.this$0);
    }
}
