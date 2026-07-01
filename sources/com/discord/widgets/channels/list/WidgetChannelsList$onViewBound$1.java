package com.discord.widgets.channels.list;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.stores.SelectedChannelAnalyticsLocation;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreNavigation$PanelAction;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.widgets.channels.threads.browser.WidgetThreadBrowser;
import com.discord.widgets.forums.ForumUtils;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsList$onViewBound$1 extends o implements Function1<Channel, Unit> {
    public final /* synthetic */ WidgetChannelsList this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsList$onViewBound$1(WidgetChannelsList widgetChannelsList) {
        super(1);
        this.this$0 = widgetChannelsList;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
        invoke2(channel);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Channel channel) {
        if (channel == null) {
            ChannelSelector.selectChannel$default(ChannelSelector.Companion.getInstance(), 0L, 0L, null, null, 12, null);
            return;
        }
        ChannelSelector.selectChannel$default(ChannelSelector.Companion.getInstance(), channel, null, SelectedChannelAnalyticsLocation.CHANNEL_LIST, 2, null);
        if (!ForumUtils.canAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, channel.getGuildId(), null, 2, null) && ChannelUtils.q(channel)) {
            WidgetThreadBrowser.Companion.show(this.this$0.getContext(), channel.getGuildId(), channel.getId(), "Forum");
        }
        StoreNavigation.setNavigationPanelAction$default(WidgetChannelsList.access$getStoreNavigation$p(this.this$0), StoreNavigation$PanelAction.UNLOCK_LEFT, null, 2, null);
        StoreNavigation.setNavigationPanelAction$default(WidgetChannelsList.access$getStoreNavigation$p(this.this$0), StoreNavigation$PanelAction.CLOSE, null, 2, null);
    }
}
