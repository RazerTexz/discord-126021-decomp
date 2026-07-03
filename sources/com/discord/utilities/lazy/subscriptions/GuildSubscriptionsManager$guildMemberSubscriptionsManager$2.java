package com.discord.utilities.lazy.subscriptions;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildSubscriptionsManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class GuildSubscriptionsManager$guildMemberSubscriptionsManager$2 extends C12236k implements Function1<Function0<? extends Unit>, Unit> {
    public GuildSubscriptionsManager$guildMemberSubscriptionsManager$2(GuildSubscriptionsManager guildSubscriptionsManager) {
        super(1, guildSubscriptionsManager, GuildSubscriptionsManager.class, "requestFlushUnsubscriptions", "requestFlushUnsubscriptions(Lkotlin/jvm/functions/Function0;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Function0<? extends Unit> function0) {
        invoke2((Function0<Unit>) function0);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Function0<Unit> function0) {
        C12238m.checkNotNullParameter(function0, "p1");
        ((GuildSubscriptionsManager) this.receiver).requestFlushUnsubscriptions(function0);
    }
}
