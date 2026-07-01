package com.discord.utilities.lazy.subscriptions;

import d0.z.d.k;
import d0.z.d.m;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: GuildSubscriptionsManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class GuildSubscriptionsManager$guildMemberSubscriptionsManager$1 extends k implements Function3<Long, Set<? extends Long>, Boolean, Unit> {
    public GuildSubscriptionsManager$guildMemberSubscriptionsManager$1(GuildSubscriptionsManager guildSubscriptionsManager) {
        super(3, guildSubscriptionsManager, GuildSubscriptionsManager.class, "handleMemberSubscriptionsChange", "handleMemberSubscriptionsChange(JLjava/util/Set;Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Long l, Set<? extends Long> set, Boolean bool) {
        invoke(l.longValue(), (Set<Long>) set, bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(long j, Set<Long> set, boolean z2) {
        m.checkNotNullParameter(set, "p2");
        GuildSubscriptionsManager.access$handleMemberSubscriptionsChange((GuildSubscriptionsManager) this.receiver, j, set, z2);
    }
}
