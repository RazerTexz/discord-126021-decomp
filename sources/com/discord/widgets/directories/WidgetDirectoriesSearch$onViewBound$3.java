package com.discord.widgets.directories;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetDirectoriesSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoriesSearch$onViewBound$3 implements View$OnClickListener {
    public final /* synthetic */ WidgetDirectoriesSearch this$0;

    public WidgetDirectoriesSearch$onViewBound$3(WidgetDirectoriesSearch widgetDirectoriesSearch) {
        this.this$0 = widgetDirectoriesSearch;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetDirectoriesSearch.access$searchForDirectories(this.this$0);
    }
}
