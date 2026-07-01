package com.discord.widgets.auth;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetAuthLanding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthLanding$configureRegisterButton$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetAuthLanding this$0;

    public WidgetAuthLanding$configureRegisterButton$2(WidgetAuthLanding widgetAuthLanding) {
        this.this$0 = widgetAuthLanding;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetAuthLanding widgetAuthLanding = this.this$0;
        m.checkNotNullExpressionValue(view, "it");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "it.context");
        WidgetAuthLanding.access$onRegisterPressed(widgetAuthLanding, context);
    }
}
