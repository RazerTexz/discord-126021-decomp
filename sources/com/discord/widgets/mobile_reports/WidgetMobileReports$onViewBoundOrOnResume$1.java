package com.discord.widgets.mobile_reports;

import com.discord.app.AppActivity;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetMobileReports.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMobileReports$onViewBoundOrOnResume$1 extends o implements Function1<MobileReportsViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetMobileReports this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetMobileReports$onViewBoundOrOnResume$1(WidgetMobileReports widgetMobileReports) {
        super(1);
        this.this$0 = widgetMobileReports;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MobileReportsViewModel$ViewState mobileReportsViewModel$ViewState) {
        invoke2(mobileReportsViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MobileReportsViewModel$ViewState mobileReportsViewModel$ViewState) {
        AppActivity appActivity;
        m.checkNotNullParameter(mobileReportsViewModel$ViewState, "viewState");
        if (mobileReportsViewModel$ViewState instanceof MobileReportsViewModel$ViewState$Menu) {
            WidgetMobileReports.access$configureUI(this.this$0, (MobileReportsViewModel$ViewState$Menu) mobileReportsViewModel$ViewState);
        } else {
            if (!(mobileReportsViewModel$ViewState instanceof MobileReportsViewModel$ViewState$Invalid) || (appActivity = this.this$0.getAppActivity()) == null) {
                return;
            }
            appActivity.finish();
        }
    }
}
