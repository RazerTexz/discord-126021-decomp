package com.discord.utilities.lazy.subscriptions;

import d0.z.d.k;
import d0.z.d.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: GuildSubscriptionsManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class GuildSubscriptionsManager$guildThreadSubscriptionManager$1 extends k implements Function2<Long, List<? extends Long>, Unit> {
    public GuildSubscriptionsManager$guildThreadSubscriptionManager$1(GuildSubscriptionsManager guildSubscriptionsManager) {
        super(2, guildSubscriptionsManager, GuildSubscriptionsManager.class, "handleThreadSubscriptionsChange", "handleThreadSubscriptionsChange(JLjava/util/List;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Long l, List<? extends Long> list) {
        invoke(l.longValue(), (List<Long>) list);
        return Unit.a;
    }

    public final void invoke(long j, List<Long> list) {
        m.checkNotNullParameter(list, "p2");
        GuildSubscriptionsManager.access$handleThreadSubscriptionsChange((GuildSubscriptionsManager) this.receiver, j, list);
    }
}
