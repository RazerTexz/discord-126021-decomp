package com.discord.widgets.user.search;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.user.User;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: com.discord.widgets.user.search.WidgetGlobalSearchModel$Companion$getDefaultUserSearch$recentDmUserIds$1 */
/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C10336x3304ae52 extends AbstractC12240o implements Function1<Long, Long> {
    public final /* synthetic */ WidgetGlobalSearchModel.ChannelContext $channelContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C10336x3304ae52(WidgetGlobalSearchModel.ChannelContext channelContext) {
        super(1);
        this.$channelContext = channelContext;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Long invoke(Long l) {
        return invoke(l.longValue());
    }

    public final Long invoke(long j) {
        User userM7677a;
        Channel channel = this.$channelContext.getChannels().get(Long.valueOf(j));
        if (channel == null || (userM7677a = ChannelUtils.m7677a(channel)) == null) {
            return null;
        }
        return Long.valueOf(userM7677a.getId());
    }
}
