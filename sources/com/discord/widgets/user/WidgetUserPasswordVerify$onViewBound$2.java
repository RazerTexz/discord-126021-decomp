package com.discord.widgets.user;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetUserPasswordVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserPasswordVerify$onViewBound$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetUserPasswordVerify this$0;

    public WidgetUserPasswordVerify$onViewBound$2(WidgetUserPasswordVerify widgetUserPasswordVerify) {
        this.this$0 = widgetUserPasswordVerify;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetUserPasswordVerify.access$saveInfo(this.this$0);
    }
}
