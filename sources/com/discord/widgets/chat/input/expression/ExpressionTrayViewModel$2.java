package com.discord.widgets.chat.input.expression;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ExpressionTrayViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ExpressionTrayViewModel$2 extends k implements Function1<ExpressionPickerEvent, Unit> {
    public ExpressionTrayViewModel$2(ExpressionTrayViewModel expressionTrayViewModel) {
        super(1, expressionTrayViewModel, ExpressionTrayViewModel.class, "handleExpressionPickerEvents", "handleExpressionPickerEvents(Lcom/discord/widgets/chat/input/expression/ExpressionPickerEvent;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ExpressionPickerEvent expressionPickerEvent) {
        invoke2(expressionPickerEvent);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ExpressionPickerEvent expressionPickerEvent) {
        m.checkNotNullParameter(expressionPickerEvent, "p1");
        ExpressionTrayViewModel.access$handleExpressionPickerEvents((ExpressionTrayViewModel) this.receiver, expressionPickerEvent);
    }
}
