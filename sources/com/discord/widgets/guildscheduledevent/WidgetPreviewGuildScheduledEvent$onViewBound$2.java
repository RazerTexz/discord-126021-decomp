package com.discord.widgets.guildscheduledevent;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: compiled from: WidgetPreviewGuildScheduledEvent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPreviewGuildScheduledEvent$onViewBound$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetPreviewGuildScheduledEvent this$0;

    public WidgetPreviewGuildScheduledEvent$onViewBound$2(WidgetPreviewGuildScheduledEvent widgetPreviewGuildScheduledEvent) {
        this.this$0 = widgetPreviewGuildScheduledEvent;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.setResult(2);
            activity.finish();
        }
    }
}
