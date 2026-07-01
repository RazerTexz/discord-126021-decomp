package com.discord.widgets.donut;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: compiled from: WidgetDonutBetaPopup.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDonutBetaPopup$onViewBound$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetDonutBetaPopup this$0;

    public WidgetDonutBetaPopup$onViewBound$2(WidgetDonutBetaPopup widgetDonutBetaPopup) {
        this.this$0 = widgetDonutBetaPopup;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
