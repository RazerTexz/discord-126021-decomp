package com.discord.widgets.mobile_reports;

import com.discord.api.report.ReportNodeBottomButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ReportsMenuNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ReportsMenuNode$setupBottomButton$1 extends k implements Function1<ReportNodeBottomButton, Unit> {
    public ReportsMenuNode$setupBottomButton$1(ReportsMenuNode reportsMenuNode) {
        super(1, reportsMenuNode, ReportsMenuNode.class, "bottomButtonClickListener", "bottomButtonClickListener(Lcom/discord/api/report/ReportNodeBottomButton;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ReportNodeBottomButton reportNodeBottomButton) {
        invoke2(reportNodeBottomButton);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ReportNodeBottomButton reportNodeBottomButton) {
        m.checkNotNullParameter(reportNodeBottomButton, "p1");
        ReportsMenuNode.access$bottomButtonClickListener((ReportsMenuNode) this.receiver, reportNodeBottomButton);
    }
}
