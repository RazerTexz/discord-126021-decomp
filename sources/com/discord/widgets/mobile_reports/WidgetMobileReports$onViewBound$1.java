package com.discord.widgets.mobile_reports;

import d0.z.d.k;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetMobileReports.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetMobileReports$onViewBound$1 extends k implements Function0<Boolean> {
    public WidgetMobileReports$onViewBound$1(MobileReportsViewModel mobileReportsViewModel) {
        super(0, mobileReportsViewModel, MobileReportsViewModel.class, "handleBack", "handleBack()Z", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        return ((MobileReportsViewModel) this.receiver).handleBack();
    }
}
