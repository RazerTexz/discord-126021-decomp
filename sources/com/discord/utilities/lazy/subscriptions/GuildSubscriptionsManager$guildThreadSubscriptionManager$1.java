package com.discord.utilities.lazy.subscriptions;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildSubscriptionsManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class GuildSubscriptionsManager$guildThreadSubscriptionManager$1 extends C12236k implements Function2<Long, List<? extends Long>, Unit> {
    public GuildSubscriptionsManager$guildThreadSubscriptionManager$1(GuildSubscriptionsManager guildSubscriptionsManager) {
        super(2, guildSubscriptionsManager, GuildSubscriptionsManager.class, "handleThreadSubscriptionsChange", "handleThreadSubscriptionsChange(JLjava/util/List;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Long l, List<? extends Long> list) {
        invoke(l.longValue(), (List<Long>) list);
        return Unit.f27425a;
    }

    public final void invoke(long j, List<Long> list) {
        C12238m.checkNotNullParameter(list, "p2");
        ((GuildSubscriptionsManager) this.receiver).handleThreadSubscriptionsChange(j, list);
    }
}
