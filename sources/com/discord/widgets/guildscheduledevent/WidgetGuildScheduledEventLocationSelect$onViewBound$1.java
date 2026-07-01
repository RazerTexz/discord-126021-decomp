package com.discord.widgets.guildscheduledevent;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: compiled from: WidgetGuildScheduledEventLocationSelect.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventLocationSelect$onViewBound$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetGuildScheduledEventLocationSelect this$0;

    public WidgetGuildScheduledEventLocationSelect$onViewBound$1(WidgetGuildScheduledEventLocationSelect widgetGuildScheduledEventLocationSelect) {
        this.this$0 = widgetGuildScheduledEventLocationSelect;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
