package com.discord.utilities.lazy.subscriptions;

import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.discord.utilities.lazy.subscriptions.GuildSubscriptionsManager$guildThreadSubscriptionManager$1, reason: use source file name */
/* JADX INFO: compiled from: GuildSubscriptionsManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class GuildSubscriptionsManager5 extends FunctionReferenceImpl implements Function2<Long, List<? extends Long>, Unit> {
    public GuildSubscriptionsManager5(GuildSubscriptionsManager guildSubscriptionsManager) {
        super(2, guildSubscriptionsManager, GuildSubscriptionsManager.class, "handleThreadSubscriptionsChange", "handleThreadSubscriptionsChange(JLjava/util/List;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Long l, List<? extends Long> list) {
        invoke(l.longValue(), (List<Long>) list);
        return Unit.a;
    }

    public final void invoke(long j, List<Long> list) {
        Intrinsics3.checkNotNullParameter(list, "p2");
        ((GuildSubscriptionsManager) this.receiver).handleThreadSubscriptionsChange(j, list);
    }
}
