package com.discord.widgets.mobile_reports;

import com.discord.api.report.ReportNodeElementData;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: MobileReportsBreadcrumbs.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MobileReportsBreadcrumbs$setup$1$1 extends AbstractC12240o implements Function1<ReportNodeElementData, CharSequence> {
    public static final MobileReportsBreadcrumbs$setup$1$1 INSTANCE = new MobileReportsBreadcrumbs$setup$1$1();

    public MobileReportsBreadcrumbs$setup$1$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final CharSequence invoke(ReportNodeElementData reportNodeElementData) {
        C12238m.checkNotNullParameter(reportNodeElementData, "data");
        return reportNodeElementData.getElementValue();
    }
}
