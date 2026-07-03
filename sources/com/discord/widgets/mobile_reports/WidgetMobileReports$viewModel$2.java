package com.discord.widgets.mobile_reports;

import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetMobileReports.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMobileReports$viewModel$2 extends AbstractC12240o implements Function0<MobileReportsViewModel> {
    public final /* synthetic */ WidgetMobileReports this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetMobileReports$viewModel$2(WidgetMobileReports widgetMobileReports) {
        super(0);
        this.this$0 = widgetMobileReports;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final MobileReportsViewModel invoke() {
        return new MobileReportsViewModel(new WeakReference(this.this$0.requireContext()), this.this$0.getArgs(), null, null, null, 28, null);
    }
}
