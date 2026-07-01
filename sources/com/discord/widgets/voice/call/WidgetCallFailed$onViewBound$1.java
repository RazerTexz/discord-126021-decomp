package com.discord.widgets.voice.call;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetCallFailed.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFailed$onViewBound$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetCallFailed this$0;

    public WidgetCallFailed$onViewBound$1(WidgetCallFailed widgetCallFailed) {
        this.this$0 = widgetCallFailed;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.dismiss();
    }
}
