package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.mobile_reports.WidgetMobileReports;
import com.discord.widgets.mobile_reports.WidgetMobileReports$Companion;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsExtrasBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventDetailsExtrasBottomSheet$configureUi$6 implements View$OnClickListener {
    public final /* synthetic */ GuildScheduledEventDetailsViewModel$ViewState $viewState;
    public final /* synthetic */ WidgetGuildScheduledEventDetailsExtrasBottomSheet this$0;

    public WidgetGuildScheduledEventDetailsExtrasBottomSheet$configureUi$6(WidgetGuildScheduledEventDetailsExtrasBottomSheet widgetGuildScheduledEventDetailsExtrasBottomSheet, GuildScheduledEventDetailsViewModel$ViewState guildScheduledEventDetailsViewModel$ViewState) {
        this.this$0 = widgetGuildScheduledEventDetailsExtrasBottomSheet;
        this.$viewState = guildScheduledEventDetailsViewModel$ViewState;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetGuildScheduledEventDetailsExtrasBottomSheet.access$dismissWithActionTaken(this.this$0);
        WidgetMobileReports$Companion widgetMobileReports$Companion = WidgetMobileReports.Companion;
        Context contextRequireContext = this.this$0.requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        widgetMobileReports$Companion.launchGuildScheduledEventReport(contextRequireContext, ((GuildScheduledEventDetailsViewModel$ViewState$Initialized) this.$viewState).getGuildScheduledEvent().getGuildId(), ((GuildScheduledEventDetailsViewModel$ViewState$Initialized) this.$viewState).getGuildScheduledEvent().getId());
    }
}
