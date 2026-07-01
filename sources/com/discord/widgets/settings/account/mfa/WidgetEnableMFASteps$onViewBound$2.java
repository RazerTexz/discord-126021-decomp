package com.discord.widgets.settings.account.mfa;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetEnableMFASteps.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEnableMFASteps$onViewBound$2 extends o implements Function1<Integer, Unit> {
    public final /* synthetic */ WidgetEnableMFASteps this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEnableMFASteps$onViewBound$2(WidgetEnableMFASteps widgetEnableMFASteps) {
        super(1);
        this.this$0 = widgetEnableMFASteps;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.a;
    }

    public final void invoke(int i) {
        WidgetEnableMFASteps.access$getViewModel$p(this.this$0).updateScreenIndex(i);
    }
}
