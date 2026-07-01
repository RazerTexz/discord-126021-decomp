package com.discord.widgets.hubs;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetHubDomainSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDomainSearch$onViewBound$3 implements View$OnClickListener {
    public final /* synthetic */ WidgetHubDomainSearch this$0;

    public WidgetHubDomainSearch$onViewBound$3(WidgetHubDomainSearch widgetHubDomainSearch) {
        this.this$0 = widgetHubDomainSearch;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetHubDomainSearch.access$searchForGuild(this.this$0);
    }
}
