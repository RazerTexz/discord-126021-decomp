package com.discord.widgets.debugging;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import b.a.d.AppToast;
import b.d.b.a.outline;
import com.discord.widgets.debugging.WidgetDebugging;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.debugging.WidgetDebugging$Adapter$Item$onConfigure$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetDebugging.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDebugging2 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ WidgetDebugging.Adapter.Item this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDebugging2(WidgetDebugging.Adapter.Item item) {
        super(1);
        this.this$0 = item;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "it");
        Context contextX = outline.x(this.this$0.itemView, "itemView", "itemView.context");
        TextView textView = this.this$0.binding.f2361b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.logMessage");
        CharSequence text = textView.getText();
        Intrinsics3.checkNotNullExpressionValue(text, "binding.logMessage.text");
        AppToast.c(contextX, text, 0, 4);
    }
}
