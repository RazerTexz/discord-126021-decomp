package com.discord.widgets.chat.input.expression;

import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$handleEvent$pickerSheet$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetExpressionTray.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetExpressionTray6 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ WidgetExpressionTray this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetExpressionTray6(WidgetExpressionTray widgetExpressionTray) {
        super(0);
        this.this$0 = widgetExpressionTray;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.getFlexInputViewModel().hideKeyboard();
    }
}
