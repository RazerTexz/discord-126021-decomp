package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsExtrasBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventDetailsExtrasBottomSheet$configureUi$4 implements View$OnClickListener {
    public final /* synthetic */ WidgetGuildScheduledEventDetailsExtrasBottomSheet this$0;

    public WidgetGuildScheduledEventDetailsExtrasBottomSheet$configureUi$4(WidgetGuildScheduledEventDetailsExtrasBottomSheet widgetGuildScheduledEventDetailsExtrasBottomSheet) {
        this.this$0 = widgetGuildScheduledEventDetailsExtrasBottomSheet;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        GuildScheduledEventDetailsViewModel guildScheduledEventDetailsViewModelAccess$getViewModel$p = WidgetGuildScheduledEventDetailsExtrasBottomSheet.access$getViewModel$p(this.this$0);
        Context contextRequireContext = this.this$0.requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        guildScheduledEventDetailsViewModelAccess$getViewModel$p.endEventClicked(contextRequireContext, new WidgetGuildScheduledEventDetailsExtrasBottomSheet$configureUi$4$1(this));
    }
}
