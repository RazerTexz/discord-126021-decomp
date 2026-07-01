package com.discord.widgets.guildscheduledevent;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventTiming;

/* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsExtrasBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventDetailsExtrasBottomSheet$configureUi$$inlined$apply$lambda$1 implements View$OnClickListener {
    public final /* synthetic */ boolean $canManageEvent$inlined;
    public final /* synthetic */ GuildScheduledEventTiming $eventTiming$inlined;
    public final /* synthetic */ GuildScheduledEventDetailsViewModel$ViewState $viewState$inlined;
    public final /* synthetic */ WidgetGuildScheduledEventDetailsExtrasBottomSheet this$0;

    public WidgetGuildScheduledEventDetailsExtrasBottomSheet$configureUi$$inlined$apply$lambda$1(WidgetGuildScheduledEventDetailsExtrasBottomSheet widgetGuildScheduledEventDetailsExtrasBottomSheet, boolean z2, GuildScheduledEventTiming guildScheduledEventTiming, GuildScheduledEventDetailsViewModel$ViewState guildScheduledEventDetailsViewModel$ViewState) {
        this.this$0 = widgetGuildScheduledEventDetailsExtrasBottomSheet;
        this.$canManageEvent$inlined = z2;
        this.$eventTiming$inlined = guildScheduledEventTiming;
        this.$viewState$inlined = guildScheduledEventDetailsViewModel$ViewState;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetGuildScheduledEventDetailsExtrasBottomSheet.access$getViewModel$p(this.this$0).onRsvpButtonClicked();
    }
}
