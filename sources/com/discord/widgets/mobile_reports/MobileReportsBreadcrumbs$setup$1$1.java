package com.discord.widgets.mobile_reports;

import com.discord.api.report.ReportNodeElementData;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MobileReportsBreadcrumbs.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MobileReportsBreadcrumbs$setup$1$1 extends o implements Function1<ReportNodeElementData, CharSequence> {
    public static final MobileReportsBreadcrumbs$setup$1$1 INSTANCE = new MobileReportsBreadcrumbs$setup$1$1();

    public MobileReportsBreadcrumbs$setup$1$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(ReportNodeElementData reportNodeElementData) {
        return invoke2(reportNodeElementData);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(ReportNodeElementData reportNodeElementData) {
        m.checkNotNullParameter(reportNodeElementData, "data");
        return reportNodeElementData.getElementValue();
    }
}
