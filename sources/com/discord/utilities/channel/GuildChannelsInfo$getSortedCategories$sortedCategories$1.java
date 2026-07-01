package com.discord.utilities.channel;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.channel.ChannelUtils$getSortByNameAndType$1;
import java.util.Comparator;
import java.util.Map;

/* JADX INFO: compiled from: GuildChannelsInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildChannelsInfo$getSortedCategories$sortedCategories$1<T> implements Comparator<Long> {
    public final /* synthetic */ Map $guildChannels;

    public GuildChannelsInfo$getSortedCategories$sortedCategories$1(Map map) {
        this.$guildChannels = map;
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(Long l, Long l2) {
        return compare2(l, l2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public final int compare2(Long l, Long l2) {
        return ((ChannelUtils$getSortByNameAndType$1) ChannelUtils.h(Channel.Companion)).compare(this.$guildChannels.get(l), this.$guildChannels.get(l2));
    }
}
