package com.discord.widgets.settings.account.mfa;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetEnableMFAKey.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEnableMFAKey$onViewBound$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetEnableMFAKey this$0;

    public WidgetEnableMFAKey$onViewBound$1(WidgetEnableMFAKey widgetEnableMFAKey) {
        this.this$0 = widgetEnableMFAKey;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetEnableMFAKey widgetEnableMFAKey = this.this$0;
        m.checkNotNullExpressionValue(view, "it");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "it.context");
        WidgetEnableMFAKey.access$copyCodeToClipboard(widgetEnableMFAKey, context);
    }
}
