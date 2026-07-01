package com.discord.widgets.guildscheduledevent;

import android.app.TimePickerDialog;
import android.text.format.DateFormat;
import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetGuildScheduledEventSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventSettings$onViewBound$5 implements View$OnClickListener {
    public final /* synthetic */ WidgetGuildScheduledEventSettings this$0;

    public WidgetGuildScheduledEventSettings$onViewBound$5(WidgetGuildScheduledEventSettings widgetGuildScheduledEventSettings) {
        this.this$0 = widgetGuildScheduledEventSettings;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        GuildScheduledEventModel eventModel;
        GuildScheduledEventPickerTime startTime;
        GuildScheduledEventSettingsViewModel$ViewState$Initialized guildScheduledEventSettingsViewModel$ViewState$InitializedAccess$getCurrentViewState$p = WidgetGuildScheduledEventSettings.access$getCurrentViewState$p(this.this$0);
        if (guildScheduledEventSettingsViewModel$ViewState$InitializedAccess$getCurrentViewState$p == null || (eventModel = guildScheduledEventSettingsViewModel$ViewState$InitializedAccess$getCurrentViewState$p.getEventModel()) == null || (startTime = eventModel.getStartTime()) == null) {
            return;
        }
        new TimePickerDialog(this.this$0.requireContext(), new WidgetGuildScheduledEventSettings$onViewBound$5$$special$$inlined$let$lambda$1(this), startTime.getHourOfDay(), startTime.getMinute(), DateFormat.is24HourFormat(this.this$0.requireContext())).show();
    }
}
