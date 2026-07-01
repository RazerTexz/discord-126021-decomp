package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsExtrasBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventDetailsExtrasBottomSheet$configureUi$3 implements View$OnClickListener {
    public final /* synthetic */ GuildScheduledEventDetailsViewModel$ViewState $viewState;
    public final /* synthetic */ WidgetGuildScheduledEventDetailsExtrasBottomSheet this$0;

    public WidgetGuildScheduledEventDetailsExtrasBottomSheet$configureUi$3(WidgetGuildScheduledEventDetailsExtrasBottomSheet widgetGuildScheduledEventDetailsExtrasBottomSheet, GuildScheduledEventDetailsViewModel$ViewState guildScheduledEventDetailsViewModel$ViewState) {
        this.this$0 = widgetGuildScheduledEventDetailsExtrasBottomSheet;
        this.$viewState = guildScheduledEventDetailsViewModel$ViewState;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetGuildScheduledEventDetailsExtrasBottomSheet.access$dismissWithActionTaken(this.this$0);
        WidgetGuildScheduledEventLocationSelect$Companion widgetGuildScheduledEventLocationSelect$Companion = WidgetGuildScheduledEventLocationSelect.Companion;
        Context contextRequireContext = this.this$0.requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        widgetGuildScheduledEventLocationSelect$Companion.launchForEdit(contextRequireContext, ((GuildScheduledEventDetailsViewModel$ViewState$Initialized) this.$viewState).getGuildScheduledEvent().getGuildId(), ((GuildScheduledEventDetailsViewModel$ViewState$Initialized) this.$viewState).getGuildScheduledEvent().getId());
    }
}
