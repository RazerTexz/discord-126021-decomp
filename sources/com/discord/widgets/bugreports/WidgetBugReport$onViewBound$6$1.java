package com.discord.widgets.bugreports;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetBugReport.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetBugReport$onViewBound$6$1 extends o implements Function1<Integer, Unit> {
    public final /* synthetic */ WidgetBugReport$onViewBound$6 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetBugReport$onViewBound$6$1(WidgetBugReport$onViewBound$6 widgetBugReport$onViewBound$6) {
        super(1);
        this.this$0 = widgetBugReport$onViewBound$6;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.a;
    }

    public final void invoke(int i) {
        WidgetBugReport.access$getViewModel$p(this.this$0.this$0).updatePriority(i);
    }
}
