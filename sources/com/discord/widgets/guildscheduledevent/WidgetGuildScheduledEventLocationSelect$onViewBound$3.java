package com.discord.widgets.guildscheduledevent;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.channels.WidgetChannelSelector;
import com.discord.widgets.channels.WidgetChannelSelector$Companion;
import com.discord.widgets.channels.WidgetChannelSelector$SetFilterFunction;

/* JADX INFO: compiled from: WidgetGuildScheduledEventLocationSelect.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventLocationSelect$onViewBound$3 implements View$OnClickListener {
    public final /* synthetic */ WidgetGuildScheduledEventLocationSelect this$0;

    public WidgetGuildScheduledEventLocationSelect$onViewBound$3(WidgetGuildScheduledEventLocationSelect widgetGuildScheduledEventLocationSelect) {
        this.this$0 = widgetGuildScheduledEventLocationSelect;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid widgetGuildScheduledEventLocationSelectViewModel$ViewState$ValidAccess$getCurrentViewState$p = WidgetGuildScheduledEventLocationSelect.access$getCurrentViewState$p(this.this$0);
        if (widgetGuildScheduledEventLocationSelectViewModel$ViewState$ValidAccess$getCurrentViewState$p != null) {
            int iOrdinal = widgetGuildScheduledEventLocationSelectViewModel$ViewState$ValidAccess$getCurrentViewState$p.getSelectedLocationOption().ordinal();
            if (iOrdinal == 1) {
                WidgetChannelSelector$Companion widgetChannelSelector$Companion = WidgetChannelSelector.Companion;
                WidgetGuildScheduledEventLocationSelect widgetGuildScheduledEventLocationSelect = this.this$0;
                WidgetChannelSelector$Companion.launch$default(widgetChannelSelector$Companion, widgetGuildScheduledEventLocationSelect, WidgetGuildScheduledEventLocationSelect.access$getGuildId$p(widgetGuildScheduledEventLocationSelect), "GUILD_SCHEDULED_EVENT_LOCATION_SELECT_REQUEST_KEY", false, 0, new WidgetChannelSelector$SetFilterFunction(widgetGuildScheduledEventLocationSelectViewModel$ViewState$ValidAccess$getCurrentViewState$p.getAvailableStageChannelIds()), 24, null);
            } else {
                if (iOrdinal != 2) {
                    return;
                }
                WidgetChannelSelector$Companion widgetChannelSelector$Companion2 = WidgetChannelSelector.Companion;
                WidgetGuildScheduledEventLocationSelect widgetGuildScheduledEventLocationSelect2 = this.this$0;
                WidgetChannelSelector$Companion.launch$default(widgetChannelSelector$Companion2, widgetGuildScheduledEventLocationSelect2, WidgetGuildScheduledEventLocationSelect.access$getGuildId$p(widgetGuildScheduledEventLocationSelect2), "GUILD_SCHEDULED_EVENT_LOCATION_SELECT_REQUEST_KEY", false, 0, new WidgetChannelSelector$SetFilterFunction(widgetGuildScheduledEventLocationSelectViewModel$ViewState$ValidAccess$getCurrentViewState$p.getAvailableVoiceChannelIds()), 24, null);
            }
        }
    }
}
