package com.discord.widgets.guildscheduledevent;

import android.app.TimePickerDialog;
import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetGuildScheduledEventSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventSettings$onViewBound$7 implements View$OnClickListener {
    public final /* synthetic */ WidgetGuildScheduledEventSettings this$0;

    public WidgetGuildScheduledEventSettings$onViewBound$7(WidgetGuildScheduledEventSettings widgetGuildScheduledEventSettings) {
        this.this$0 = widgetGuildScheduledEventSettings;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        GuildScheduledEventModel eventModel;
        GuildScheduledEventSettingsViewModel$ViewState$Initialized guildScheduledEventSettingsViewModel$ViewState$InitializedAccess$getCurrentViewState$p = WidgetGuildScheduledEventSettings.access$getCurrentViewState$p(this.this$0);
        if (guildScheduledEventSettingsViewModel$ViewState$InitializedAccess$getCurrentViewState$p == null || (eventModel = guildScheduledEventSettingsViewModel$ViewState$InitializedAccess$getCurrentViewState$p.getEventModel()) == null) {
            return;
        }
        GuildScheduledEventPickerTime second = GuildScheduledEventPickerDateTime.INSTANCE.generateDefaultEndDateTime(eventModel.getStartDate(), eventModel.getStartTime()).getSecond();
        Context contextRequireContext = this.this$0.requireContext();
        WidgetGuildScheduledEventSettings$onViewBound$7$$special$$inlined$let$lambda$1 widgetGuildScheduledEventSettings$onViewBound$7$$special$$inlined$let$lambda$1 = new WidgetGuildScheduledEventSettings$onViewBound$7$$special$$inlined$let$lambda$1(this);
        GuildScheduledEventPickerTime endTime = eventModel.getEndTime();
        int hourOfDay = endTime != null ? endTime.getHourOfDay() : second.getHourOfDay();
        GuildScheduledEventPickerTime endTime2 = eventModel.getEndTime();
        new TimePickerDialog(contextRequireContext, widgetGuildScheduledEventSettings$onViewBound$7$$special$$inlined$let$lambda$1, hourOfDay, endTime2 != null ? endTime2.getMinute() : second.getMinute(), false).show();
    }
}
