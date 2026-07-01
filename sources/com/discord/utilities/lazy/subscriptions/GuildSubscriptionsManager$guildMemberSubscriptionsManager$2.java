package com.discord.utilities.lazy.subscriptions;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildSubscriptionsManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class GuildSubscriptionsManager$guildMemberSubscriptionsManager$2 extends k implements Function1<Function0<? extends Unit>, Unit> {
    public GuildSubscriptionsManager$guildMemberSubscriptionsManager$2(GuildSubscriptionsManager guildSubscriptionsManager) {
        super(1, guildSubscriptionsManager, GuildSubscriptionsManager.class, "requestFlushUnsubscriptions", "requestFlushUnsubscriptions(Lkotlin/jvm/functions/Function0;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Function0<? extends Unit> function0) {
        invoke2((Function0<Unit>) function0);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Function0<Unit> function0) {
        m.checkNotNullParameter(function0, "p1");
        GuildSubscriptionsManager.access$requestFlushUnsubscriptions((GuildSubscriptionsManager) this.receiver, function0);
    }
}
