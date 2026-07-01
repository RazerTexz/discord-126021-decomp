package com.discord.widgets.user;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetUserStatusSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserStatusSheet$onViewCreated$5 implements View$OnClickListener {
    public final /* synthetic */ WidgetUserStatusSheet this$0;

    public WidgetUserStatusSheet$onViewCreated$5(WidgetUserStatusSheet widgetUserStatusSheet) {
        this.this$0 = widgetUserStatusSheet;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetUserStatusSheet widgetUserStatusSheet = this.this$0;
        m.checkNotNullExpressionValue(view, "it");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "it.context");
        WidgetUserStatusSheet.access$openCustomStatusAndDismiss(widgetUserStatusSheet, context);
    }
}
