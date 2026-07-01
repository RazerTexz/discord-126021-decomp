package com.discord.widgets.chat.input.expression;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetExpressionTray.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetExpressionTray$onViewBoundOrOnResume$1 extends o implements Function1<ExpressionTrayViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetExpressionTray this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetExpressionTray$onViewBoundOrOnResume$1(WidgetExpressionTray widgetExpressionTray) {
        super(1);
        this.this$0 = widgetExpressionTray;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ExpressionTrayViewModel$ViewState expressionTrayViewModel$ViewState) {
        invoke2(expressionTrayViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ExpressionTrayViewModel$ViewState expressionTrayViewModel$ViewState) {
        m.checkNotNullParameter(expressionTrayViewModel$ViewState, "viewState");
        WidgetExpressionTray.access$handleViewState(this.this$0, expressionTrayViewModel$ViewState);
    }
}
