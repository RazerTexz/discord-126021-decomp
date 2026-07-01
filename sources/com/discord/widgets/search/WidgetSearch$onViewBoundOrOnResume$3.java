package com.discord.widgets.search;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearch$onViewBoundOrOnResume$3 implements View$OnClickListener {
    public final /* synthetic */ WidgetSearch this$0;

    public WidgetSearch$onViewBoundOrOnResume$3(WidgetSearch widgetSearch) {
        this.this$0 = widgetSearch;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.hideKeyboard(view);
        this.this$0.requireActivity().onBackPressed();
    }
}
