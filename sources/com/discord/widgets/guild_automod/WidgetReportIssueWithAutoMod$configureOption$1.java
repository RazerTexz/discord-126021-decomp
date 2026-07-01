package com.discord.widgets.guild_automod;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetReportIssueWithAutoMod.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetReportIssueWithAutoMod$configureOption$1 implements View$OnClickListener {
    public final /* synthetic */ FeedbackType $settingValue;
    public final /* synthetic */ WidgetReportIssueWithAutoMod this$0;

    public WidgetReportIssueWithAutoMod$configureOption$1(WidgetReportIssueWithAutoMod widgetReportIssueWithAutoMod, FeedbackType feedbackType) {
        this.this$0 = widgetReportIssueWithAutoMod;
        this.$settingValue = feedbackType;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetReportIssueWithAutoMod.access$getViewModel$p(this.this$0).onFeedbackTypeSelected(this.$settingValue);
    }
}
