package com.discord.widgets.tos;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetTosReportViolationViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetTosReportViolationViewModel$1 extends k implements Function1<WidgetTosReportViolationViewModel$StoreState, Unit> {
    public WidgetTosReportViolationViewModel$1(WidgetTosReportViolationViewModel widgetTosReportViolationViewModel) {
        super(1, widgetTosReportViolationViewModel, WidgetTosReportViolationViewModel.class, "generateViewState", "generateViewState(Lcom/discord/widgets/tos/WidgetTosReportViolationViewModel$StoreState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetTosReportViolationViewModel$StoreState widgetTosReportViolationViewModel$StoreState) {
        invoke2(widgetTosReportViolationViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetTosReportViolationViewModel$StoreState widgetTosReportViolationViewModel$StoreState) {
        m.checkNotNullParameter(widgetTosReportViolationViewModel$StoreState, "p1");
        WidgetTosReportViolationViewModel.access$generateViewState((WidgetTosReportViolationViewModel) this.receiver, widgetTosReportViolationViewModel$StoreState);
    }
}
