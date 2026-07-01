package com.discord.utilities.lazy.subscriptions;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: GuildMemberSubscriptionsManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class GuildMemberSubscriptionsManager$triggerUnsubscribe$2$1 extends k implements Function0<Unit> {
    public GuildMemberSubscriptionsManager$triggerUnsubscribe$2$1(GuildMemberSubscriptionsManager guildMemberSubscriptionsManager) {
        super(0, guildMemberSubscriptionsManager, GuildMemberSubscriptionsManager.class, "flushUnsubscriptions", "flushUnsubscriptions()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        GuildMemberSubscriptionsManager.access$flushUnsubscriptions((GuildMemberSubscriptionsManager) this.receiver);
    }
}
