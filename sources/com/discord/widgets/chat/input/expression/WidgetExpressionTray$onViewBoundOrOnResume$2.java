package com.discord.widgets.chat.input.expression;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetExpressionTray.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetExpressionTray$onViewBoundOrOnResume$2 extends o implements Function1<ExpressionTrayViewModel$Event, Unit> {
    public final /* synthetic */ WidgetExpressionTray this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetExpressionTray$onViewBoundOrOnResume$2(WidgetExpressionTray widgetExpressionTray) {
        super(1);
        this.this$0 = widgetExpressionTray;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ExpressionTrayViewModel$Event expressionTrayViewModel$Event) {
        invoke2(expressionTrayViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ExpressionTrayViewModel$Event expressionTrayViewModel$Event) {
        m.checkNotNullParameter(expressionTrayViewModel$Event, "event");
        WidgetExpressionTray.access$handleEvent(this.this$0, expressionTrayViewModel$Event);
    }
}
