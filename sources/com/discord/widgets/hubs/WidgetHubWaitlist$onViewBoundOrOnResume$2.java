package com.discord.widgets.hubs;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetHubWaitlist.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubWaitlist$onViewBoundOrOnResume$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetHubWaitlist this$0;

    public WidgetHubWaitlist$onViewBoundOrOnResume$2(WidgetHubWaitlist widgetHubWaitlist) {
        this.this$0 = widgetHubWaitlist;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetHubWaitlist.access$maybeSubmitSchoolName(this.this$0);
    }
}
