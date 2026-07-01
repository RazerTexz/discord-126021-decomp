package com.discord.widgets.guild_automod;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetReportIssueWithAutoMod.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetReportIssueWithAutoMod$configureUI$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetReportIssueWithAutoMod this$0;

    public WidgetReportIssueWithAutoMod$configureUI$2(WidgetReportIssueWithAutoMod widgetReportIssueWithAutoMod) {
        this.this$0 = widgetReportIssueWithAutoMod;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetReportIssueWithAutoMod.access$getViewModel$p(this.this$0).onSubmit(new WidgetReportIssueWithAutoMod$configureUI$2$1(this));
    }
}
