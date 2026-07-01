package com.discord.widgets.notice;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetNoticeDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNoticeDialog$onViewBound$4 implements View$OnClickListener {
    public final /* synthetic */ WidgetNoticeDialog this$0;

    public WidgetNoticeDialog$onViewBound$4(WidgetNoticeDialog widgetNoticeDialog) {
        this.this$0 = widgetNoticeDialog;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.dismiss();
    }
}
