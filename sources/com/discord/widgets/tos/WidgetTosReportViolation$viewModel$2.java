package com.discord.widgets.tos;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetTosReportViolation.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetTosReportViolation$viewModel$2 extends AbstractC12240o implements Function0<WidgetTosReportViolationViewModel> {
    public final /* synthetic */ WidgetTosReportViolation this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetTosReportViolation$viewModel$2(WidgetTosReportViolation widgetTosReportViolation) {
        super(0);
        this.this$0 = widgetTosReportViolation;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetTosReportViolationViewModel invoke() {
        return new WidgetTosReportViolationViewModel(this.this$0.getArgs().getChannelId(), this.this$0.getArgs().getMessageId());
    }
}
