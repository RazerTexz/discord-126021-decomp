package com.discord.widgets.guildscheduledevent;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: compiled from: WidgetGuildScheduledEventCreateSuccess.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventCreateSuccess$configureUI$3 implements View$OnClickListener {
    public final /* synthetic */ WidgetGuildScheduledEventCreateSuccess this$0;

    public WidgetGuildScheduledEventCreateSuccess$configureUI$3(WidgetGuildScheduledEventCreateSuccess widgetGuildScheduledEventCreateSuccess) {
        this.this$0 = widgetGuildScheduledEventCreateSuccess;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
