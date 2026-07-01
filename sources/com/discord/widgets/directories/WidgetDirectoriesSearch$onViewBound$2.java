package com.discord.widgets.directories;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: compiled from: WidgetDirectoriesSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoriesSearch$onViewBound$2 implements View$OnClickListener {
    public final /* synthetic */ View $view;
    public final /* synthetic */ WidgetDirectoriesSearch this$0;

    public WidgetDirectoriesSearch$onViewBound$2(WidgetDirectoriesSearch widgetDirectoriesSearch, View view) {
        this.this$0 = widgetDirectoriesSearch;
        this.$view = view;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
        this.this$0.hideKeyboard(this.$view);
    }
}
