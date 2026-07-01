package com.discord.widgets.chat.input.expression;

import d0.z.d.FunctionReferenceImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$configureDetailPage$gifCategoryFragment$1$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetExpressionTray.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetExpressionTray3 extends FunctionReferenceImpl implements Function0<Unit> {
    public WidgetExpressionTray3(WidgetExpressionTray widgetExpressionTray) {
        super(0, widgetExpressionTray, WidgetExpressionTray.class, "onGifSelected", "onGifSelected()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((WidgetExpressionTray) this.receiver).onGifSelected();
    }
}
