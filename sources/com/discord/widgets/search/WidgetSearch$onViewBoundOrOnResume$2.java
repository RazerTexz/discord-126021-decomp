package com.discord.widgets.search;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearch$onViewBoundOrOnResume$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetSearch this$0;

    public WidgetSearch$onViewBoundOrOnResume$2(WidgetSearch widgetSearch) {
        this.this$0 = widgetSearch;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetSearch widgetSearch = this.this$0;
        m.checkNotNullExpressionValue(view, "v");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "v.context");
        WidgetSearch.access$sendQuery(widgetSearch, context);
    }
}
