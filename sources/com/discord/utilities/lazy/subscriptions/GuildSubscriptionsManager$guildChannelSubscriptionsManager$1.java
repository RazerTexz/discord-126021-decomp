package com.discord.utilities.lazy.subscriptions;

import d0.z.d.k;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: GuildSubscriptionsManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class GuildSubscriptionsManager$guildChannelSubscriptionsManager$1 extends k implements Function2<Long, Map<Long, ? extends List<? extends IntRange>>, Unit> {
    public GuildSubscriptionsManager$guildChannelSubscriptionsManager$1(GuildSubscriptionsManager guildSubscriptionsManager) {
        super(2, guildSubscriptionsManager, GuildSubscriptionsManager.class, "handleChannelSubscriptionsChange", "handleChannelSubscriptionsChange(JLjava/util/Map;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Long l, Map<Long, ? extends List<? extends IntRange>> map) {
        invoke(l.longValue(), (Map<Long, ? extends List<IntRange>>) map);
        return Unit.a;
    }

    public final void invoke(long j, Map<Long, ? extends List<IntRange>> map) {
        m.checkNotNullParameter(map, "p2");
        GuildSubscriptionsManager.access$handleChannelSubscriptionsChange((GuildSubscriptionsManager) this.receiver, j, map);
    }
}
