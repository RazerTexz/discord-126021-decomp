package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildScheduledEventListBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventListBottomSheet$onViewCreated$7 implements View$OnClickListener {
    public final /* synthetic */ WidgetGuildScheduledEventListBottomSheet this$0;

    public WidgetGuildScheduledEventListBottomSheet$onViewCreated$7(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet) {
        this.this$0 = widgetGuildScheduledEventListBottomSheet;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetGuildScheduledEventLocationSelect$Companion widgetGuildScheduledEventLocationSelect$Companion = WidgetGuildScheduledEventLocationSelect.Companion;
        Context contextRequireContext = this.this$0.requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        widgetGuildScheduledEventLocationSelect$Companion.launch(contextRequireContext, WidgetGuildScheduledEventListBottomSheet.access$getGuildId$p(this.this$0), WidgetGuildScheduledEventListBottomSheet.access$getChannelId$p(this.this$0));
    }
}
