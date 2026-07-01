package com.discord.widgets.bugreports;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetBugReport.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetBugReport$onViewBoundOrOnResume$2 extends k implements Function1<BugReportViewModel$Event, Unit> {
    public WidgetBugReport$onViewBoundOrOnResume$2(WidgetBugReport widgetBugReport) {
        super(1, widgetBugReport, WidgetBugReport.class, "handleEvent", "handleEvent(Lcom/discord/widgets/bugreports/BugReportViewModel$Event;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(BugReportViewModel$Event bugReportViewModel$Event) {
        invoke2(bugReportViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(BugReportViewModel$Event bugReportViewModel$Event) {
        m.checkNotNullParameter(bugReportViewModel$Event, "p1");
        WidgetBugReport.access$handleEvent((WidgetBugReport) this.receiver, bugReportViewModel$Event);
    }
}
