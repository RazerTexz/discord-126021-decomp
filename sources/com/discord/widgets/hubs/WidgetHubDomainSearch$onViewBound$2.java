package com.discord.widgets.hubs;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: compiled from: WidgetHubDomainSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDomainSearch$onViewBound$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetHubDomainSearch this$0;

    public WidgetHubDomainSearch$onViewBound$2(WidgetHubDomainSearch widgetHubDomainSearch) {
        this.this$0 = widgetHubDomainSearch;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
        WidgetHubDomainSearch widgetHubDomainSearch = this.this$0;
        widgetHubDomainSearch.hideKeyboard(widgetHubDomainSearch.getView());
    }
}
