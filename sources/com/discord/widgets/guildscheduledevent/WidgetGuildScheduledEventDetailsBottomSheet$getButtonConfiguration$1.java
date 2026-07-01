package com.discord.widgets.guildscheduledevent;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.utilities.directories.DirectoryUtils;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilitiesKt;

/* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$1 implements View$OnClickListener {
    public final /* synthetic */ GuildScheduledEventDetailsViewModel$ViewState$Initialized $this_getButtonConfiguration;
    public final /* synthetic */ WidgetGuildScheduledEventDetailsBottomSheet this$0;

    public WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$1(WidgetGuildScheduledEventDetailsBottomSheet widgetGuildScheduledEventDetailsBottomSheet, GuildScheduledEventDetailsViewModel$ViewState$Initialized guildScheduledEventDetailsViewModel$ViewState$Initialized) {
        this.this$0 = widgetGuildScheduledEventDetailsBottomSheet;
        this.$this_getButtonConfiguration = guildScheduledEventDetailsViewModel$ViewState$Initialized;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        DirectoryUtils directoryUtils = DirectoryUtils.INSTANCE;
        WidgetGuildScheduledEventDetailsBottomSheet widgetGuildScheduledEventDetailsBottomSheet = this.this$0;
        GuildScheduledEvent guildScheduledEvent = this.$this_getButtonConfiguration.getGuildScheduledEvent();
        boolean zIsInGuild = this.$this_getButtonConfiguration.isInGuild();
        Long guildId = WidgetGuildScheduledEventDetailsBottomSheet.access$getArgs$p(this.this$0).getGuildId();
        long jLongValue = guildId != null ? guildId.longValue() : 0L;
        Long channelId = WidgetGuildScheduledEventDetailsBottomSheet.access$getArgs$p(this.this$0).getChannelId();
        directoryUtils.maybeJoinAndGoToGuild(widgetGuildScheduledEventDetailsBottomSheet, guildScheduledEvent, zIsInGuild, jLongValue, channelId != null ? channelId.longValue() : 0L, !this.$this_getButtonConfiguration.isRsvped() && GuildScheduledEventUtilitiesKt.canRsvp(this.$this_getButtonConfiguration.getGuildScheduledEvent()), new WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$1$1(this));
    }
}
