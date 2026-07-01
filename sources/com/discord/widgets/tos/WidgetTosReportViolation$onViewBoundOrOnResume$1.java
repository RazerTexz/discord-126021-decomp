package com.discord.widgets.tos;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetTosReportViolation.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetTosReportViolation$onViewBoundOrOnResume$1 extends k implements Function1<WidgetTosReportViolationViewModel$ViewState, Unit> {
    public WidgetTosReportViolation$onViewBoundOrOnResume$1(WidgetTosReportViolation widgetTosReportViolation) {
        super(1, widgetTosReportViolation, WidgetTosReportViolation.class, "configureUI", "configureUI(Lcom/discord/widgets/tos/WidgetTosReportViolationViewModel$ViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetTosReportViolationViewModel$ViewState widgetTosReportViolationViewModel$ViewState) {
        invoke2(widgetTosReportViolationViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetTosReportViolationViewModel$ViewState widgetTosReportViolationViewModel$ViewState) {
        m.checkNotNullParameter(widgetTosReportViolationViewModel$ViewState, "p1");
        WidgetTosReportViolation.access$configureUI((WidgetTosReportViolation) this.receiver, widgetTosReportViolationViewModel$ViewState);
    }
}
