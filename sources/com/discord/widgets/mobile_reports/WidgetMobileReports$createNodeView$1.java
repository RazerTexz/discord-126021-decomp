package com.discord.widgets.mobile_reports;

import com.discord.api.report.NodeElementResult;
import com.discord.api.report.ReportNodeChild;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetMobileReports.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMobileReports$createNodeView$1 extends o implements Function2<ReportNodeChild, MobileReportsViewModel$NodeState, Unit> {
    public final /* synthetic */ WidgetMobileReports this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetMobileReports$createNodeView$1(WidgetMobileReports widgetMobileReports) {
        super(2);
        this.this$0 = widgetMobileReports;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(ReportNodeChild reportNodeChild, MobileReportsViewModel$NodeState mobileReportsViewModel$NodeState) {
        invoke2(reportNodeChild, mobileReportsViewModel$NodeState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ReportNodeChild reportNodeChild, MobileReportsViewModel$NodeState mobileReportsViewModel$NodeState) {
        m.checkNotNullParameter(reportNodeChild, "destination");
        m.checkNotNullParameter(mobileReportsViewModel$NodeState, "nodeState");
        MobileReportsViewModel mobileReportsViewModelAccess$getViewModel$p = WidgetMobileReports.access$getViewModel$p(this.this$0);
        MobileReportsViewModel$CheckboxElement checkboxElement = mobileReportsViewModel$NodeState.getCheckboxElement();
        mobileReportsViewModelAccess$getViewModel$p.handleNext(reportNodeChild, checkboxElement != null ? new NodeElementResult(checkboxElement.getName(), u.toList(checkboxElement.getSelections())) : null);
    }
}
