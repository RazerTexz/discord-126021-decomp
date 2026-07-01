package com.discord.widgets.tos;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.tos.WidgetTosReportViolation$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetTosReportViolation.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetTosReportViolation5 extends Lambda implements Function0<WidgetTosReportViolationViewModel> {
    public final /* synthetic */ WidgetTosReportViolation this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetTosReportViolation5(WidgetTosReportViolation widgetTosReportViolation) {
        super(0);
        this.this$0 = widgetTosReportViolation;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetTosReportViolationViewModel invoke() {
        return new WidgetTosReportViolationViewModel(this.this$0.getArgs().getChannelId(), this.this$0.getArgs().getMessageId());
    }
}
