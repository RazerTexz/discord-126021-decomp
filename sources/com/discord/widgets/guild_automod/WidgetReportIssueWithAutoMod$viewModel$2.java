package com.discord.widgets.guild_automod;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetReportIssueWithAutoMod.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetReportIssueWithAutoMod$viewModel$2 extends o implements Function0<ReportIssueWithAutoModViewModel> {
    public final /* synthetic */ WidgetReportIssueWithAutoMod this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetReportIssueWithAutoMod$viewModel$2(WidgetReportIssueWithAutoMod widgetReportIssueWithAutoMod) {
        super(0);
        this.this$0 = widgetReportIssueWithAutoMod;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ReportIssueWithAutoModViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ReportIssueWithAutoModViewModel invoke() {
        return new ReportIssueWithAutoModViewModel(WidgetReportIssueWithAutoMod.access$getChannelId$p(this.this$0), WidgetReportIssueWithAutoMod.access$getMessageId$p(this.this$0), null, null, 12, null);
    }
}
