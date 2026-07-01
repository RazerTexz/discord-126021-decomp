package com.discord.widgets.guild_automod;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: compiled from: WidgetReportIssueWithAutoMod.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetReportIssueWithAutoMod$configureUI$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetReportIssueWithAutoMod this$0;

    public WidgetReportIssueWithAutoMod$configureUI$1(WidgetReportIssueWithAutoMod widgetReportIssueWithAutoMod) {
        this.this$0 = widgetReportIssueWithAutoMod;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
