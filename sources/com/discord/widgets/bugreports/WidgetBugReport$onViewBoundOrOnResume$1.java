package com.discord.widgets.bugreports;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetBugReport.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetBugReport$onViewBoundOrOnResume$1 extends o implements Function1<BugReportViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetBugReport this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetBugReport$onViewBoundOrOnResume$1(WidgetBugReport widgetBugReport) {
        super(1);
        this.this$0 = widgetBugReport;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(BugReportViewModel$ViewState bugReportViewModel$ViewState) {
        invoke2(bugReportViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(BugReportViewModel$ViewState bugReportViewModel$ViewState) {
        m.checkNotNullParameter(bugReportViewModel$ViewState, "viewState");
        this.this$0.updateView(bugReportViewModel$ViewState);
    }
}
