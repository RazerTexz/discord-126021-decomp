package com.discord.widgets.forums;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreExperiments;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ForumUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ForumUtils$observeSelectedPostChannel$1 extends o implements Function0<Channel> {
    public final /* synthetic */ StoreChannels $storeChannels;
    public final /* synthetic */ StoreChannelsSelected $storeChannelsSelected;
    public final /* synthetic */ StoreExperiments $storeExperiments;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumUtils$observeSelectedPostChannel$1(StoreChannelsSelected storeChannelsSelected, StoreExperiments storeExperiments, StoreChannels storeChannels) {
        super(0);
        this.$storeChannelsSelected = storeChannelsSelected;
        this.$storeExperiments = storeExperiments;
        this.$storeChannels = storeChannels;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Channel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Channel invoke() {
        Channel selectedChannel = this.$storeChannelsSelected.getSelectedChannel();
        if (selectedChannel == null) {
            return null;
        }
        boolean zCanAccessRedesignedForumChannels = ForumUtils.INSTANCE.canAccessRedesignedForumChannels(selectedChannel.getGuildId(), this.$storeExperiments);
        Channel channel = this.$storeChannels.getChannel(selectedChannel.getParentId());
        if (zCanAccessRedesignedForumChannels && channel != null && ChannelUtils.q(channel)) {
            return selectedChannel;
        }
        return null;
    }
}
