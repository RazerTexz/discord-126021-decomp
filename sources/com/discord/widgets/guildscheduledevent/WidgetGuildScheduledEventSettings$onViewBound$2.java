package com.discord.widgets.guildscheduledevent;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: compiled from: WidgetGuildScheduledEventSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventSettings$onViewBound$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetGuildScheduledEventSettings this$0;

    public WidgetGuildScheduledEventSettings$onViewBound$2(WidgetGuildScheduledEventSettings widgetGuildScheduledEventSettings) {
        this.this$0 = widgetGuildScheduledEventSettings;
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
