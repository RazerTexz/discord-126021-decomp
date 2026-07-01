package com.discord.widgets.debugging;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import b.d.b.a.a;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetDebugging.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDebugging$Adapter$Item$onConfigure$2 extends o implements Function1<View, Unit> {
    public final /* synthetic */ WidgetDebugging$Adapter$Item this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDebugging$Adapter$Item$onConfigure$2(WidgetDebugging$Adapter$Item widgetDebugging$Adapter$Item) {
        super(1);
        this.this$0 = widgetDebugging$Adapter$Item;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        Context contextX = a.x(this.this$0.itemView, "itemView", "itemView.context");
        TextView textView = WidgetDebugging$Adapter$Item.access$getBinding$p(this.this$0).f2361b;
        m.checkNotNullExpressionValue(textView, "binding.logMessage");
        CharSequence text = textView.getText();
        m.checkNotNullExpressionValue(text, "binding.logMessage.text");
        b.a.d.m.c(contextX, text, 0, 4);
    }
}
