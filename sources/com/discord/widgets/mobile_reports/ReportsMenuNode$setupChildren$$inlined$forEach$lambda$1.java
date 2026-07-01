package com.discord.widgets.mobile_reports;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.api.report.ReportNodeChild;

/* JADX INFO: compiled from: ReportsMenuNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ReportsMenuNode$setupChildren$$inlined$forEach$lambda$1 implements View$OnClickListener {
    public final /* synthetic */ ReportNodeChild $child$inlined;
    public final /* synthetic */ ReportsMenuNode this$0;

    public ReportsMenuNode$setupChildren$$inlined$forEach$lambda$1(ReportNodeChild reportNodeChild, ReportsMenuNode reportsMenuNode) {
        this.$child$inlined = reportNodeChild;
        this.this$0 = reportsMenuNode;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ReportsMenuNode.access$childClickListener(this.this$0, this.$child$inlined);
    }
}
