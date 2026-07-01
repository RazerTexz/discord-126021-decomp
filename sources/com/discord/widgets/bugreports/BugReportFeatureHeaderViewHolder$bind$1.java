package com.discord.widgets.bugreports;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.api.bugreport.Feature;

/* JADX INFO: compiled from: WidgetBugReport.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BugReportFeatureHeaderViewHolder$bind$1 implements View$OnClickListener {
    public final /* synthetic */ Feature $feature;
    public final /* synthetic */ BugReportFeatureHeaderViewHolder this$0;

    public BugReportFeatureHeaderViewHolder$bind$1(BugReportFeatureHeaderViewHolder bugReportFeatureHeaderViewHolder, Feature feature) {
        this.this$0 = bugReportFeatureHeaderViewHolder;
        this.$feature = feature;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.getOnClickListener().invoke(this.$feature);
    }
}
