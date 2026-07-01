package com.discord.widgets.chat;

import android.view.View;
import android.view.View$OnClickListener;
import b.a.d.m;
import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetUrlActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetUrlActions$onViewCreated$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetUrlActions this$0;

    public WidgetUrlActions$onViewCreated$1(WidgetUrlActions widgetUrlActions) {
        this.this$0 = widgetUrlActions;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        m.c(a.x(view, "it", "it.context"), WidgetUrlActions.access$getUrl$p(this.this$0), 0, 4);
        this.this$0.dismiss();
    }
}
