package com.discord.widgets.chat.input.expression;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetExpressionTray.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetExpressionTray$handleEvent$2 extends k implements Function0<Unit> {
    public WidgetExpressionTray$handleEvent$2(WidgetExpressionTray widgetExpressionTray) {
        super(0, widgetExpressionTray, WidgetExpressionTray.class, "onGifSearchSheetCanceled", "onGifSearchSheetCanceled()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetExpressionTray.access$onGifSearchSheetCanceled((WidgetExpressionTray) this.receiver);
    }
}
