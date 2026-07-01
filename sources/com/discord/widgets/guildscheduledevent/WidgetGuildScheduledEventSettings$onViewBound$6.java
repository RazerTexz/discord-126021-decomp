package com.discord.widgets.guildscheduledevent;

import android.app.DatePickerDialog;
import android.view.View;
import android.view.View$OnClickListener;
import android.widget.DatePicker;
import com.discord.utilities.time.ClockFactory;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildScheduledEventSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventSettings$onViewBound$6 implements View$OnClickListener {
    public final /* synthetic */ WidgetGuildScheduledEventSettings this$0;

    public WidgetGuildScheduledEventSettings$onViewBound$6(WidgetGuildScheduledEventSettings widgetGuildScheduledEventSettings) {
        this.this$0 = widgetGuildScheduledEventSettings;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        GuildScheduledEventModel eventModel;
        GuildScheduledEventPickerDate startDate;
        GuildScheduledEventSettingsViewModel$ViewState$Initialized guildScheduledEventSettingsViewModel$ViewState$InitializedAccess$getCurrentViewState$p = WidgetGuildScheduledEventSettings.access$getCurrentViewState$p(this.this$0);
        if (guildScheduledEventSettingsViewModel$ViewState$InitializedAccess$getCurrentViewState$p == null || (eventModel = guildScheduledEventSettingsViewModel$ViewState$InitializedAccess$getCurrentViewState$p.getEventModel()) == null || (startDate = eventModel.getStartDate()) == null) {
            return;
        }
        DatePickerDialog datePickerDialog = new DatePickerDialog(this.this$0.requireContext(), new WidgetGuildScheduledEventSettings$onViewBound$6$$special$$inlined$let$lambda$1(this), startDate.getYear(), startDate.getMonth(), startDate.getDayOfMonth());
        DatePicker datePicker = datePickerDialog.getDatePicker();
        m.checkNotNullExpressionValue(datePicker, "datePicker");
        datePicker.setMinDate(ClockFactory.get().currentTimeMillis());
        datePickerDialog.show();
    }
}
