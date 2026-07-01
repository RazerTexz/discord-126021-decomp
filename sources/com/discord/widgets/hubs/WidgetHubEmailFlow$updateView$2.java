package com.discord.widgets.hubs;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: compiled from: WidgetHubEmailFlow.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubEmailFlow$updateView$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetHubEmailFlow this$0;

    public WidgetHubEmailFlow$updateView$2(WidgetHubEmailFlow widgetHubEmailFlow) {
        this.this$0 = widgetHubEmailFlow;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
