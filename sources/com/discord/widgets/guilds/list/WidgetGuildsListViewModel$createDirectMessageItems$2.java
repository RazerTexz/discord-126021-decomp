package com.discord.widgets.guilds.list;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildsListViewModel$createDirectMessageItems$2 extends o implements Function1<Channel, GuildListItem$PrivateChannelItem> {
    public final /* synthetic */ Map $mentionCounts;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildsListViewModel$createDirectMessageItems$2(Map map) {
        super(1);
        this.$mentionCounts = map;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ GuildListItem$PrivateChannelItem invoke(Channel channel) {
        return invoke2(channel);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final GuildListItem$PrivateChannelItem invoke2(Channel channel) {
        m.checkNotNullParameter(channel, "it");
        Integer num = (Integer) a.d(channel, this.$mentionCounts);
        return new GuildListItem$PrivateChannelItem(channel, num != null ? num.intValue() : 0);
    }
}
