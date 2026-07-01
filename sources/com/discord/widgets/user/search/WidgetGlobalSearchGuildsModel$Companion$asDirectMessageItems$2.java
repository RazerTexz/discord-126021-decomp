package com.discord.widgets.user.search;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGlobalSearchGuildsModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchGuildsModel$Companion$asDirectMessageItems$2 extends o implements Function1<Channel, WidgetGlobalSearchGuildsModel$Item> {
    public final /* synthetic */ Map $mentionCounts;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchGuildsModel$Companion$asDirectMessageItems$2(Map map) {
        super(1);
        this.$mentionCounts = map;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGlobalSearchGuildsModel$Item invoke(Channel channel) {
        return invoke2(channel);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGlobalSearchGuildsModel$Item invoke2(Channel channel) {
        m.checkNotNullParameter(channel, "it");
        WidgetGlobalSearchGuildsModel$Item$Companion widgetGlobalSearchGuildsModel$Item$Companion = WidgetGlobalSearchGuildsModel$Item.Companion;
        Integer num = (Integer) a.d(channel, this.$mentionCounts);
        return widgetGlobalSearchGuildsModel$Item$Companion.createDirectMessage$app_productionGoogleRelease(channel, num != null ? num.intValue() : 0);
    }
}
