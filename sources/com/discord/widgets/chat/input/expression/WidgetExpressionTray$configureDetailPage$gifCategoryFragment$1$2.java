package com.discord.widgets.chat.input.expression;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.C12236k;

/* JADX INFO: compiled from: WidgetExpressionTray.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetExpressionTray$configureDetailPage$gifCategoryFragment$1$2 extends C12236k implements Function0<Unit> {
    public WidgetExpressionTray$configureDetailPage$gifCategoryFragment$1$2(WidgetExpressionTray widgetExpressionTray) {
        super(0, widgetExpressionTray, WidgetExpressionTray.class, "onGifSelected", "onGifSelected()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((WidgetExpressionTray) this.receiver).onGifSelected();
    }
}
