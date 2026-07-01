package com.discord.widgets.guildscheduledevent;

import android.app.DatePickerDialog$OnDateSetListener;
import android.widget.DatePicker;

/* JADX INFO: compiled from: WidgetGuildScheduledEventSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventSettings$onViewBound$8$$special$$inlined$let$lambda$1 implements DatePickerDialog$OnDateSetListener {
    public final /* synthetic */ WidgetGuildScheduledEventSettings$onViewBound$8 this$0;

    public WidgetGuildScheduledEventSettings$onViewBound$8$$special$$inlined$let$lambda$1(WidgetGuildScheduledEventSettings$onViewBound$8 widgetGuildScheduledEventSettings$onViewBound$8) {
        this.this$0 = widgetGuildScheduledEventSettings$onViewBound$8;
    }

    @Override // android.app.DatePickerDialog$OnDateSetListener
    public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        GuildScheduledEventSettingsViewModel$DateError endDate = WidgetGuildScheduledEventSettings.access$getViewModel$p(this.this$0.this$0).setEndDate(i, i2, i3);
        if (endDate != null) {
            WidgetGuildScheduledEventSettings.access$showDateErrorToast(this.this$0.this$0, endDate);
        }
    }
}
