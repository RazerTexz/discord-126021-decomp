package com.discord.widgets.channels.list;

import androidx.fragment.app.FragmentManager;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventListBottomSheet;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventListBottomSheet$Companion;
import com.discord.widgets.hubs.events.WidgetHubEventsPage;
import com.discord.widgets.hubs.events.WidgetHubEventsPage$Companion;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsList$onViewBound$8 extends o implements Function1<Guild, Unit> {
    public final /* synthetic */ WidgetChannelsList this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsList$onViewBound$8(WidgetChannelsList widgetChannelsList) {
        super(1);
        this.this$0 = widgetChannelsList;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Guild guild) {
        invoke2(guild);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Guild guild) {
        Object next;
        m.checkNotNullParameter(guild, "guild");
        if (!guild.isHub()) {
            WidgetGuildScheduledEventListBottomSheet$Companion widgetGuildScheduledEventListBottomSheet$Companion = WidgetGuildScheduledEventListBottomSheet.Companion;
            FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetGuildScheduledEventListBottomSheet$Companion.show$default(widgetGuildScheduledEventListBottomSheet$Companion, parentFragmentManager, guild.getId(), null, 4, null);
            return;
        }
        Iterator<T> it = StoreStream.Companion.getChannels().getChannelsForGuild(guild.getId()).values().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!ChannelUtils.o((Channel) next));
        Channel channel = (Channel) next;
        if (channel != null) {
            WidgetHubEventsPage$Companion widgetHubEventsPage$Companion = WidgetHubEventsPage.Companion;
            FragmentManager parentFragmentManager2 = this.this$0.getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
            widgetHubEventsPage$Companion.show(parentFragmentManager2, guild.getId(), channel.getId());
        }
    }
}
