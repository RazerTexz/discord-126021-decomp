package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetGuildScheduledEventSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventSettings$onViewBound$9 implements View$OnClickListener {
    public final /* synthetic */ WidgetGuildScheduledEventSettings this$0;

    public WidgetGuildScheduledEventSettings$onViewBound$9(WidgetGuildScheduledEventSettings widgetGuildScheduledEventSettings) {
        this.this$0 = widgetGuildScheduledEventSettings;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        GuildScheduledEventSettingsViewModel$ViewState$Initialized guildScheduledEventSettingsViewModel$ViewState$InitializedAccess$getCurrentViewState$p = WidgetGuildScheduledEventSettings.access$getCurrentViewState$p(this.this$0);
        if (guildScheduledEventSettingsViewModel$ViewState$InitializedAccess$getCurrentViewState$p != null) {
            if (WidgetGuildScheduledEventSettings.access$getViewModel$p(this.this$0).hasStartTimeChanged(guildScheduledEventSettingsViewModel$ViewState$InitializedAccess$getCurrentViewState$p) && !WidgetGuildScheduledEventSettings.access$getViewModel$p(this.this$0).isDateInFuture(guildScheduledEventSettingsViewModel$ViewState$InitializedAccess$getCurrentViewState$p.getEventModel().getStartDate(), guildScheduledEventSettingsViewModel$ViewState$InitializedAccess$getCurrentViewState$p.getEventModel().getStartTime())) {
                WidgetGuildScheduledEventSettings.access$showDateErrorToast(this.this$0, GuildScheduledEventSettingsViewModel$DateError.START_DATE_IN_PAST);
                return;
            }
            if (WidgetGuildScheduledEventSettings.access$getViewModel$p(this.this$0).hasEndTimeChanged(guildScheduledEventSettingsViewModel$ViewState$InitializedAccess$getCurrentViewState$p) && !WidgetGuildScheduledEventSettings.access$getViewModel$p(this.this$0).isDateInFuture(guildScheduledEventSettingsViewModel$ViewState$InitializedAccess$getCurrentViewState$p.getEventModel().getEndDate(), guildScheduledEventSettingsViewModel$ViewState$InitializedAccess$getCurrentViewState$p.getEventModel().getEndTime())) {
                WidgetGuildScheduledEventSettings.access$showDateErrorToast(this.this$0, GuildScheduledEventSettingsViewModel$DateError.END_DATE_IN_PAST);
                return;
            }
            if (!WidgetGuildScheduledEventSettings.access$getViewModel$p(this.this$0).isStartDateBeforeEndDate(guildScheduledEventSettingsViewModel$ViewState$InitializedAccess$getCurrentViewState$p)) {
                WidgetGuildScheduledEventSettings.access$showDateErrorToast(this.this$0, GuildScheduledEventSettingsViewModel$DateError.END_DATE_BEFORE_START_DATE);
                return;
            }
            WidgetPreviewGuildScheduledEvent$Companion widgetPreviewGuildScheduledEvent$Companion = WidgetPreviewGuildScheduledEvent.Companion;
            Context contextRequireContext = this.this$0.requireContext();
            GuildScheduledEventModel eventModel = guildScheduledEventSettingsViewModel$ViewState$InitializedAccess$getCurrentViewState$p.getEventModel();
            Long lAccess$getExistingGuildScheduledEventId$p = WidgetGuildScheduledEventSettings.access$getExistingGuildScheduledEventId$p(this.this$0);
            widgetPreviewGuildScheduledEvent$Companion.launch(contextRequireContext, eventModel, lAccess$getExistingGuildScheduledEventId$p != null ? new WidgetPreviewGuildScheduledEvent$Companion$ExistingEventData(lAccess$getExistingGuildScheduledEventId$p.longValue(), WidgetPreviewGuildScheduledEvent$Companion$Action.EDIT_EVENT) : null, WidgetGuildScheduledEventSettings.access$getPreviewLauncher$p(this.this$0), true);
        }
    }
}
