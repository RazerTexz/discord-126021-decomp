package com.discord.widgets.guildscheduledevent;

import android.app.DatePickerDialog;
import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import android.widget.DatePicker;
import com.discord.utilities.time.ClockFactory;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildScheduledEventSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventSettings$onViewBound$8 implements View$OnClickListener {
    public final /* synthetic */ WidgetGuildScheduledEventSettings this$0;

    public WidgetGuildScheduledEventSettings$onViewBound$8(WidgetGuildScheduledEventSettings widgetGuildScheduledEventSettings) {
        this.this$0 = widgetGuildScheduledEventSettings;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        GuildScheduledEventModel eventModel;
        GuildScheduledEventSettingsViewModel$ViewState$Initialized guildScheduledEventSettingsViewModel$ViewState$InitializedAccess$getCurrentViewState$p = WidgetGuildScheduledEventSettings.access$getCurrentViewState$p(this.this$0);
        if (guildScheduledEventSettingsViewModel$ViewState$InitializedAccess$getCurrentViewState$p == null || (eventModel = guildScheduledEventSettingsViewModel$ViewState$InitializedAccess$getCurrentViewState$p.getEventModel()) == null) {
            return;
        }
        GuildScheduledEventPickerDate first = GuildScheduledEventPickerDateTime.INSTANCE.generateDefaultEndDateTime(eventModel.getStartDate(), eventModel.getStartTime()).getFirst();
        Context contextRequireContext = this.this$0.requireContext();
        WidgetGuildScheduledEventSettings$onViewBound$8$$special$$inlined$let$lambda$1 widgetGuildScheduledEventSettings$onViewBound$8$$special$$inlined$let$lambda$1 = new WidgetGuildScheduledEventSettings$onViewBound$8$$special$$inlined$let$lambda$1(this);
        GuildScheduledEventPickerDate endDate = eventModel.getEndDate();
        int year = endDate != null ? endDate.getYear() : first.getYear();
        GuildScheduledEventPickerDate endDate2 = eventModel.getEndDate();
        int month = endDate2 != null ? endDate2.getMonth() : first.getMonth();
        GuildScheduledEventPickerDate endDate3 = eventModel.getEndDate();
        DatePickerDialog datePickerDialog = new DatePickerDialog(contextRequireContext, widgetGuildScheduledEventSettings$onViewBound$8$$special$$inlined$let$lambda$1, year, month, endDate3 != null ? endDate3.getDayOfMonth() : first.getDayOfMonth());
        DatePicker datePicker = datePickerDialog.getDatePicker();
        m.checkNotNullExpressionValue(datePicker, "datePicker");
        datePicker.setMinDate(Math.max(eventModel.getStartDate().toMillis(), ClockFactory.get().currentTimeMillis()));
        datePickerDialog.show();
    }
}
