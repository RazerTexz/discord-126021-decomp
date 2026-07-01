package com.discord.widgets.user;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetPruneUsers.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetPruneUsers$onViewBound$4 implements View$OnClickListener {
    public final /* synthetic */ WidgetPruneUsers this$0;

    public WidgetPruneUsers$onViewBound$4(WidgetPruneUsers widgetPruneUsers) {
        this.this$0 = widgetPruneUsers;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.dismiss();
    }
}
