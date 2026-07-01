package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$10 implements View$OnClickListener {
    public final /* synthetic */ WidgetGuildScheduledEventDetailsBottomSheet this$0;

    public WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$10(WidgetGuildScheduledEventDetailsBottomSheet widgetGuildScheduledEventDetailsBottomSheet) {
        this.this$0 = widgetGuildScheduledEventDetailsBottomSheet;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        GuildScheduledEventDetailsViewModel guildScheduledEventDetailsViewModelAccess$getViewModel$p = WidgetGuildScheduledEventDetailsBottomSheet.access$getViewModel$p(this.this$0);
        Context contextRequireContext = this.this$0.requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        guildScheduledEventDetailsViewModelAccess$getViewModel$p.endEventClicked(contextRequireContext, new WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$10$1(this));
    }
}
