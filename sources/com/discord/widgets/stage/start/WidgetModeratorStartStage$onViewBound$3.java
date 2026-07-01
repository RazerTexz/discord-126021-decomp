package com.discord.widgets.stage.start;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: compiled from: WidgetModeratorStartStage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetModeratorStartStage$onViewBound$3 implements View$OnClickListener {
    public final /* synthetic */ WidgetModeratorStartStage this$0;

    public WidgetModeratorStartStage$onViewBound$3(WidgetModeratorStartStage widgetModeratorStartStage) {
        this.this$0 = widgetModeratorStartStage;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetModeratorStartStage.access$getViewModel$p(this.this$0).disconnectFromStage();
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
