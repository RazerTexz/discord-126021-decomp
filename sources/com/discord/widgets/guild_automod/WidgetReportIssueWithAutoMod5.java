package com.discord.widgets.guild_automod;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.guild_automod.WidgetReportIssueWithAutoMod$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetReportIssueWithAutoMod.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetReportIssueWithAutoMod5 extends Lambda implements Function0<ReportIssueWithAutoModViewModel> {
    public final /* synthetic */ WidgetReportIssueWithAutoMod this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetReportIssueWithAutoMod5(WidgetReportIssueWithAutoMod widgetReportIssueWithAutoMod) {
        super(0);
        this.this$0 = widgetReportIssueWithAutoMod;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ReportIssueWithAutoModViewModel invoke() {
        return new ReportIssueWithAutoModViewModel(this.this$0.getChannelId(), this.this$0.getMessageId(), null, null, 12, null);
    }
}
