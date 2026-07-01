package com.discord.widgets.chat.input.expression;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ExpressionTrayViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ExpressionTrayViewModel$1 extends k implements Function1<ExpressionTrayViewModel$StoreState, Unit> {
    public ExpressionTrayViewModel$1(ExpressionTrayViewModel expressionTrayViewModel) {
        super(1, expressionTrayViewModel, ExpressionTrayViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/chat/input/expression/ExpressionTrayViewModel$StoreState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ExpressionTrayViewModel$StoreState expressionTrayViewModel$StoreState) {
        invoke2(expressionTrayViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ExpressionTrayViewModel$StoreState expressionTrayViewModel$StoreState) {
        m.checkNotNullParameter(expressionTrayViewModel$StoreState, "p1");
        ExpressionTrayViewModel.access$handleStoreState((ExpressionTrayViewModel) this.receiver, expressionTrayViewModel$StoreState);
    }
}
