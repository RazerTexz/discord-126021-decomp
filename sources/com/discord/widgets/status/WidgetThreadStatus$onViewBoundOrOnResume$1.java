package com.discord.widgets.status;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetThreadStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadStatus$onViewBoundOrOnResume$1 extends o implements Function1<WidgetThreadStatusViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetThreadStatus this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadStatus$onViewBoundOrOnResume$1(WidgetThreadStatus widgetThreadStatus) {
        super(1);
        this.this$0 = widgetThreadStatus;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetThreadStatusViewModel$ViewState widgetThreadStatusViewModel$ViewState) {
        invoke2(widgetThreadStatusViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetThreadStatusViewModel$ViewState widgetThreadStatusViewModel$ViewState) {
        m.checkNotNullParameter(widgetThreadStatusViewModel$ViewState, "viewState");
        WidgetThreadStatus.access$updateView(this.this$0, widgetThreadStatusViewModel$ViewState);
    }
}
