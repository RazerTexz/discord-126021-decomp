package com.discord.widgets.chat.input.expression;

import android.view.View;
import android.view.View$OnClickListener;
import android.widget.TextView;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetExpressionTray.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetExpressionTray$onViewBound$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetExpressionTray this$0;

    public WidgetExpressionTray$onViewBound$1(WidgetExpressionTray widgetExpressionTray) {
        this.this$0 = widgetExpressionTray;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ExpressionTrayViewModel expressionTrayViewModelAccess$getExpressionTrayViewModel$p = WidgetExpressionTray.access$getExpressionTrayViewModel$p(this.this$0);
        TextView textView = WidgetExpressionTray.access$getBinding$p(this.this$0).j;
        m.checkNotNullExpressionValue(textView, "binding.expressionTraySearchButton");
        expressionTrayViewModelAccess$getExpressionTrayViewModel$p.clickSearch(textView.getText().toString());
    }
}
