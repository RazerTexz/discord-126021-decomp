package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$5 implements View$OnClickListener {
    public final /* synthetic */ GuildScheduledEventDetailsViewModel$ViewState$Initialized $this_getButtonConfiguration;
    public final /* synthetic */ WidgetGuildScheduledEventDetailsBottomSheet this$0;

    public WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$5(WidgetGuildScheduledEventDetailsBottomSheet widgetGuildScheduledEventDetailsBottomSheet, GuildScheduledEventDetailsViewModel$ViewState$Initialized guildScheduledEventDetailsViewModel$ViewState$Initialized) {
        this.this$0 = widgetGuildScheduledEventDetailsBottomSheet;
        this.$this_getButtonConfiguration = guildScheduledEventDetailsViewModel$ViewState$Initialized;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetPreviewGuildScheduledEvent$Companion widgetPreviewGuildScheduledEvent$Companion = WidgetPreviewGuildScheduledEvent.Companion;
        Context contextRequireContext = this.this$0.requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        WidgetPreviewGuildScheduledEvent$Companion.launch$default(widgetPreviewGuildScheduledEvent$Companion, contextRequireContext, GuildScheduledEventModelKt.toModel(this.$this_getButtonConfiguration.getGuildScheduledEvent()), new WidgetPreviewGuildScheduledEvent$Companion$ExistingEventData(this.$this_getButtonConfiguration.getGuildScheduledEvent().getId(), WidgetPreviewGuildScheduledEvent$Companion$Action.START_EVENT), WidgetGuildScheduledEventDetailsBottomSheet.access$getPreviewLauncher$p(this.this$0), false, 16, null);
    }
}
