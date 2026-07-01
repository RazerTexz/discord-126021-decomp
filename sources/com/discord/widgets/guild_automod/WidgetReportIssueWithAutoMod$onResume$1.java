package com.discord.widgets.guild_automod;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetReportIssueWithAutoMod.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetReportIssueWithAutoMod$onResume$1 extends o implements Function1<ReportIssueWithAutoModViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetReportIssueWithAutoMod this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetReportIssueWithAutoMod$onResume$1(WidgetReportIssueWithAutoMod widgetReportIssueWithAutoMod) {
        super(1);
        this.this$0 = widgetReportIssueWithAutoMod;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ReportIssueWithAutoModViewModel$ViewState reportIssueWithAutoModViewModel$ViewState) {
        invoke2(reportIssueWithAutoModViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ReportIssueWithAutoModViewModel$ViewState reportIssueWithAutoModViewModel$ViewState) {
        m.checkNotNullParameter(reportIssueWithAutoModViewModel$ViewState, "viewState");
        this.this$0.configureUI(reportIssueWithAutoModViewModel$ViewState);
    }
}
