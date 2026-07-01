package com.discord.widgets.guildscheduledevent;

import android.app.TimePickerDialog$OnTimeSetListener;
import android.widget.TimePicker;

/* JADX INFO: compiled from: WidgetGuildScheduledEventSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventSettings$onViewBound$7$$special$$inlined$let$lambda$1 implements TimePickerDialog$OnTimeSetListener {
    public final /* synthetic */ WidgetGuildScheduledEventSettings$onViewBound$7 this$0;

    public WidgetGuildScheduledEventSettings$onViewBound$7$$special$$inlined$let$lambda$1(WidgetGuildScheduledEventSettings$onViewBound$7 widgetGuildScheduledEventSettings$onViewBound$7) {
        this.this$0 = widgetGuildScheduledEventSettings$onViewBound$7;
    }

    @Override // android.app.TimePickerDialog$OnTimeSetListener
    public final void onTimeSet(TimePicker timePicker, int i, int i2) {
        GuildScheduledEventSettingsViewModel$DateError endTime = WidgetGuildScheduledEventSettings.access$getViewModel$p(this.this$0.this$0).setEndTime(i, i2);
        if (endTime != null) {
            WidgetGuildScheduledEventSettings.access$showDateErrorToast(this.this$0.this$0, endTime);
        }
    }
}
