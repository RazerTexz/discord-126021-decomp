package com.discord.widgets.mobile_reports;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: ReportsMenuNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ReportsMenuNode$setupBlockUser$1 implements View$OnClickListener {
    public final /* synthetic */ ReportsMenuNode this$0;

    public ReportsMenuNode$setupBlockUser$1(ReportsMenuNode reportsMenuNode) {
        this.this$0 = reportsMenuNode;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ReportsMenuNode.access$blockUserClickListener(this.this$0);
    }
}
