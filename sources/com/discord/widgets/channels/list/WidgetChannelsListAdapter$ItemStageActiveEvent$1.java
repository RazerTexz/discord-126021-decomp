package com.discord.widgets.channels.list;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.widgets.channels.list.items.ChannelListItem;
import com.discord.widgets.channels.list.items.ChannelListItemActiveEvent;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventLocationInfo;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventLocationInfo$ChannelLocation;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventLocationInfo$ExternalLocation;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet;

/* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemStageActiveEvent$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetChannelsListAdapter $adapter;
    public final /* synthetic */ WidgetChannelsListAdapter$ItemStageActiveEvent this$0;

    public WidgetChannelsListAdapter$ItemStageActiveEvent$1(WidgetChannelsListAdapter$ItemStageActiveEvent widgetChannelsListAdapter$ItemStageActiveEvent, WidgetChannelsListAdapter widgetChannelsListAdapter) {
        this.this$0 = widgetChannelsListAdapter$ItemStageActiveEvent;
        this.$adapter = widgetChannelsListAdapter;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        GuildScheduledEventLocationInfo$ChannelLocation guildScheduledEventLocationInfo$ChannelLocation;
        Channel channel;
        if (this.this$0.getAdapterPosition() != -1) {
            ChannelListItem item = this.$adapter.getItem(this.this$0.getAdapterPosition());
            if (!(item instanceof ChannelListItemActiveEvent)) {
                item = null;
            }
            ChannelListItemActiveEvent channelListItemActiveEvent = (ChannelListItemActiveEvent) item;
            if (channelListItemActiveEvent != null) {
                GuildScheduledEventLocationInfo locationInfo = channelListItemActiveEvent.getData().getLocationInfo();
                if ((locationInfo instanceof GuildScheduledEventLocationInfo$ChannelLocation) && (channel = (guildScheduledEventLocationInfo$ChannelLocation = (GuildScheduledEventLocationInfo$ChannelLocation) locationInfo).getChannel()) != null && ChannelUtils.w(channel)) {
                    this.$adapter.getOnCallChannel().invoke(guildScheduledEventLocationInfo$ChannelLocation.getChannel());
                } else {
                    if (!(locationInfo instanceof GuildScheduledEventLocationInfo$ExternalLocation) || channelListItemActiveEvent.getData().getEventId() == null) {
                        return;
                    }
                    WidgetGuildScheduledEventDetailsBottomSheet.Companion.showForGuild(WidgetChannelsListAdapter.access$getFragmentManager$p(this.$adapter), channelListItemActiveEvent.getData().getEventId().longValue());
                }
            }
        }
    }
}
