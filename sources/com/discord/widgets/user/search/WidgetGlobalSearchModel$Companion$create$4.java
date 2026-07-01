package com.discord.widgets.user.search;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.guild.Guild;
import com.discord.models.user.User;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$create$4 extends o implements Function2<Channel, String, WidgetGlobalSearchModel$ItemDataPayload> {
    public final /* synthetic */ WidgetGlobalSearchModel$ChannelContext $channelContext;
    public final /* synthetic */ WidgetGlobalSearchModel$SearchContext $searchContext;
    public final /* synthetic */ WidgetGlobalSearchModel$Companion$create$2 $toItemUser$2;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchModel$Companion$create$4(WidgetGlobalSearchModel$ChannelContext widgetGlobalSearchModel$ChannelContext, WidgetGlobalSearchModel$Companion$create$2 widgetGlobalSearchModel$Companion$create$2, WidgetGlobalSearchModel$SearchContext widgetGlobalSearchModel$SearchContext) {
        super(2);
        this.$channelContext = widgetGlobalSearchModel$ChannelContext;
        this.$toItemUser$2 = widgetGlobalSearchModel$Companion$create$2;
        this.$searchContext = widgetGlobalSearchModel$SearchContext;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ WidgetGlobalSearchModel$ItemDataPayload invoke(Channel channel, String str) {
        return invoke2(channel, str);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGlobalSearchModel$ItemDataPayload invoke2(Channel channel, String str) {
        m.checkNotNullParameter(channel, "$this$toItemChannel");
        m.checkNotNullParameter(str, "channelFilter");
        WidgetGlobalSearchModel$Companion$create$4$1 widgetGlobalSearchModel$Companion$create$4$1 = new WidgetGlobalSearchModel$Companion$create$4$1(this, channel, str);
        if (channel.getType() == 1) {
            User userA = ChannelUtils.a(channel);
            if (userA != null) {
                return this.$toItemUser$2.invoke2(userA, str, channel);
            }
            return null;
        }
        WidgetGlobalSearchModel$MatchedResult matchedResult = WidgetGlobalSearchModel.Companion.toMatchedResult(ChannelUtils.c(channel), str);
        if (matchedResult == null) {
            matchedResult = widgetGlobalSearchModel$Companion$create$4$1.invoke();
        }
        WidgetGlobalSearchModel$MatchedResult widgetGlobalSearchModel$MatchedResult = matchedResult;
        if (widgetGlobalSearchModel$MatchedResult == null) {
            return null;
        }
        Channel channel2 = this.$channelContext.getChannels().get(Long.valueOf(channel.getParentId()));
        Guild guild = (Guild) a.c(channel, this.$channelContext.getGuilds());
        Integer num = (Integer) a.d(channel, this.$searchContext.getMentionCounts());
        return new WidgetGlobalSearchModel$ItemChannel(widgetGlobalSearchModel$MatchedResult, channel, channel2, guild, num != null ? num.intValue() : 0, this.$channelContext.getUnreadChannelIds().contains(Long.valueOf(channel.getId())));
    }
}
