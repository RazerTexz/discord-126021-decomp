package com.discord.widgets.debugging;

import android.view.View;
import android.view.View$OnClickListener;
import android.widget.TextView;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetDebugging.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDebugging$Adapter$Item$onConfigure$3 implements View$OnClickListener {
    public final /* synthetic */ WidgetDebugging$Adapter$Item this$0;

    public WidgetDebugging$Adapter$Item$onConfigure$3(WidgetDebugging$Adapter$Item widgetDebugging$Adapter$Item) {
        this.this$0 = widgetDebugging$Adapter$Item;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        TextView textView = WidgetDebugging$Adapter$Item.access$getBinding$p(this.this$0).f2361b;
        m.checkNotNullExpressionValue(textView, "binding.logMessage");
        TextView textView2 = WidgetDebugging$Adapter$Item.access$getBinding$p(this.this$0).f2361b;
        m.checkNotNullExpressionValue(textView2, "binding.logMessage");
        textView.setMaxLines(textView2.getMaxLines() == Integer.MAX_VALUE ? 2 : Integer.MAX_VALUE);
        this.this$0.itemView.requestLayout();
    }
}
