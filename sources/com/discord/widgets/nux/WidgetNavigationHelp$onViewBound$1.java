package com.discord.widgets.nux;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetNavigationHelp.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNavigationHelp$onViewBound$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetNavigationHelp this$0;

    public WidgetNavigationHelp$onViewBound$1(WidgetNavigationHelp widgetNavigationHelp) {
        this.this$0 = widgetNavigationHelp;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.dismissAllowingStateLoss();
    }
}
