package com.discord.widgets.bugreports;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.api.bugreport.Feature;

/* JADX INFO: compiled from: WidgetBugReport.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BugReportFeatureViewHolder$bind$1 implements View$OnClickListener {
    public final /* synthetic */ Feature $data;
    public final /* synthetic */ BugReportFeatureViewHolder this$0;

    public BugReportFeatureViewHolder$bind$1(BugReportFeatureViewHolder bugReportFeatureViewHolder, Feature feature) {
        this.this$0 = bugReportFeatureViewHolder;
        this.$data = feature;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.getOnClickListener().invoke(this.$data);
    }
}
