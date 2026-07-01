package com.discord.widgets.user.search;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.user.User;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$getDefaultUserSearch$recentDmUserIds$1 extends o implements Function1<Long, Long> {
    public final /* synthetic */ WidgetGlobalSearchModel$ChannelContext $channelContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchModel$Companion$getDefaultUserSearch$recentDmUserIds$1(WidgetGlobalSearchModel$ChannelContext widgetGlobalSearchModel$ChannelContext) {
        super(1);
        this.$channelContext = widgetGlobalSearchModel$ChannelContext;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Long invoke(Long l) {
        return invoke(l.longValue());
    }

    public final Long invoke(long j) {
        User userA;
        Channel channel = this.$channelContext.getChannels().get(Long.valueOf(j));
        if (channel == null || (userA = ChannelUtils.a(channel)) == null) {
            return null;
        }
        return Long.valueOf(userA.getId());
    }
}
