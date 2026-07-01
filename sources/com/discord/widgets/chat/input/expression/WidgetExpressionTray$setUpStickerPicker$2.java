package com.discord.widgets.chat.input.expression;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetExpressionTray.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetExpressionTray$setUpStickerPicker$2 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetExpressionTray this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetExpressionTray$setUpStickerPicker$2(WidgetExpressionTray widgetExpressionTray) {
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
        WidgetExpressionTray.access$getBinding$p(this.this$0).n.scrollTo(0, 0);
        WidgetExpressionTray.access$getBinding$p(this.this$0).n.setExpanded(true, false);
    }
}
