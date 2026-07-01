package com.discord.widgets.settings;

import android.widget.TextView;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettings$onViewBound$$inlined$with$lambda$6$1 extends o implements Function1<Boolean, Unit> {
    public final /* synthetic */ WidgetSettings$onViewBound$$inlined$with$lambda$6 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettings$onViewBound$$inlined$with$lambda$6$1(WidgetSettings$onViewBound$$inlined$with$lambda$6 widgetSettings$onViewBound$$inlined$with$lambda$6) {
        super(1);
        this.this$0 = widgetSettings$onViewBound$$inlined$with$lambda$6;
    }

    public static /* synthetic */ void invoke$default(WidgetSettings$onViewBound$$inlined$with$lambda$6$1 widgetSettings$onViewBound$$inlined$with$lambda$6$1, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        widgetSettings$onViewBound$$inlined$with$lambda$6$1.invoke(z2);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(boolean z2) {
        WidgetSettings widgetSettings;
        int i;
        TextView textView = this.this$0.$this_with.J;
        m.checkNotNullExpressionValue(textView, "uploadDebugLogs");
        textView.setEnabled(z2);
        TextView textView2 = this.this$0.$this_with.J;
        m.checkNotNullExpressionValue(textView2, "uploadDebugLogs");
        if (z2) {
            widgetSettings = this.this$0.this$0;
            i = 2131896665;
        } else {
            widgetSettings = this.this$0.this$0;
            i = 2131897263;
        }
        textView2.setText(widgetSettings.getString(i));
    }
}
