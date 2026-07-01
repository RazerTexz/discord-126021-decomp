package com.discord.widgets.mobile_reports;

import com.discord.utilities.view.extensions.ViewExtensions;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetMobileReports.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMobileReports$configureUI$2 extends o implements Function0<Unit> {
    public final /* synthetic */ ReportsMenuNode $nextNodeView;
    public final /* synthetic */ MobileReportsViewModel$ViewState$Menu $viewState;
    public final /* synthetic */ WidgetMobileReports this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetMobileReports$configureUI$2(WidgetMobileReports widgetMobileReports, ReportsMenuNode reportsMenuNode, MobileReportsViewModel$ViewState$Menu mobileReportsViewModel$ViewState$Menu) {
        super(0);
        this.this$0 = widgetMobileReports;
        this.$nextNodeView = reportsMenuNode;
        this.$viewState = mobileReportsViewModel$ViewState$Menu;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetMobileReports.access$getBinding$p(this.this$0).f2496b.removeAllViewsInLayout();
        WidgetMobileReports.access$getBinding$p(this.this$0).f2496b.addView(this.$nextNodeView);
        ViewExtensions.fadeIn$default(this.$nextNodeView, 0L, null, null, new WidgetMobileReports$configureUI$2$1(this), 7, null);
    }
}
