package com.discord.widgets.debugging;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p018d.C0876m;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetDebugging.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDebugging$Adapter$Item$onConfigure$2 extends AbstractC12240o implements Function1<View, Unit> {
    public final /* synthetic */ WidgetDebugging.Adapter.Item this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDebugging$Adapter$Item$onConfigure$2(WidgetDebugging.Adapter.Item item) {
        super(1);
        this.this$0 = item;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        C12238m.checkNotNullParameter(view, "it");
        Context contextM885x = C1643a.m885x(this.this$0.itemView, "itemView", "itemView.context");
        TextView textView = this.this$0.binding.f16448b;
        C12238m.checkNotNullExpressionValue(textView, "binding.logMessage");
        CharSequence text = textView.getText();
        C12238m.checkNotNullExpressionValue(text, "binding.logMessage.text");
        C0876m.m165c(contextM885x, text, 0, 4);
    }
}
