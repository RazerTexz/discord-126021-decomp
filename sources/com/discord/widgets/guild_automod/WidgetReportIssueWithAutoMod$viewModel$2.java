package com.discord.widgets.guild_automod;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetReportIssueWithAutoMod.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetReportIssueWithAutoMod$viewModel$2 extends AbstractC12240o implements Function0<ReportIssueWithAutoModViewModel> {
    public final /* synthetic */ WidgetReportIssueWithAutoMod this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetReportIssueWithAutoMod$viewModel$2(WidgetReportIssueWithAutoMod widgetReportIssueWithAutoMod) {
        super(0);
        this.this$0 = widgetReportIssueWithAutoMod;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ReportIssueWithAutoModViewModel invoke() {
        return new ReportIssueWithAutoModViewModel(this.this$0.getChannelId(), this.this$0.getMessageId(), null, null, 12, null);
    }
}
