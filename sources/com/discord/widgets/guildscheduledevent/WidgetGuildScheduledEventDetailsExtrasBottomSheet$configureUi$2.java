package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsExtrasBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventDetailsExtrasBottomSheet$configureUi$2 implements View$OnClickListener {
    public final /* synthetic */ GuildScheduledEventDetailsViewModel$ViewState $viewState;
    public final /* synthetic */ WidgetGuildScheduledEventDetailsExtrasBottomSheet this$0;

    public WidgetGuildScheduledEventDetailsExtrasBottomSheet$configureUi$2(WidgetGuildScheduledEventDetailsExtrasBottomSheet widgetGuildScheduledEventDetailsExtrasBottomSheet, GuildScheduledEventDetailsViewModel$ViewState guildScheduledEventDetailsViewModel$ViewState) {
        this.this$0 = widgetGuildScheduledEventDetailsExtrasBottomSheet;
        this.$viewState = guildScheduledEventDetailsViewModel$ViewState;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetPreviewGuildScheduledEvent$Companion widgetPreviewGuildScheduledEvent$Companion = WidgetPreviewGuildScheduledEvent.Companion;
        Context contextRequireContext = this.this$0.requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        WidgetPreviewGuildScheduledEvent$Companion.launch$default(widgetPreviewGuildScheduledEvent$Companion, contextRequireContext, GuildScheduledEventModelKt.toModel(((GuildScheduledEventDetailsViewModel$ViewState$Initialized) this.$viewState).getGuildScheduledEvent()), new WidgetPreviewGuildScheduledEvent$Companion$ExistingEventData(((GuildScheduledEventDetailsViewModel$ViewState$Initialized) this.$viewState).getGuildScheduledEvent().getId(), WidgetPreviewGuildScheduledEvent$Companion$Action.START_EVENT), WidgetGuildScheduledEventDetailsExtrasBottomSheet.access$getPreviewLauncher$p(this.this$0), false, 16, null);
    }
}
