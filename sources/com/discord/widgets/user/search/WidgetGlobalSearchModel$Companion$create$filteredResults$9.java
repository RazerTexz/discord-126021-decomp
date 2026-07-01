package com.discord.widgets.user.search;

import com.discord.api.channel.Channel;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$create$filteredResults$9 extends o implements Function1<Long, Channel> {
    public final /* synthetic */ WidgetGlobalSearchModel$ChannelContext $channelContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchModel$Companion$create$filteredResults$9(WidgetGlobalSearchModel$ChannelContext widgetGlobalSearchModel$ChannelContext) {
        super(1);
        this.$channelContext = widgetGlobalSearchModel$ChannelContext;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Channel invoke(Long l) {
        return invoke(l.longValue());
    }

    public final Channel invoke(long j) {
        return this.$channelContext.getChannels().get(Long.valueOf(j));
    }
}
