package com.discord.utilities.lazy.subscriptions;

import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.utilities.lazy.subscriptions.GuildSubscriptionsManager$guildMemberSubscriptionsManager$2, reason: use source file name */
/* JADX INFO: compiled from: GuildSubscriptionsManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class GuildSubscriptionsManager4 extends FunctionReferenceImpl implements Function1<Function0<? extends Unit>, Unit> {
    public GuildSubscriptionsManager4(GuildSubscriptionsManager guildSubscriptionsManager) {
        super(1, guildSubscriptionsManager, GuildSubscriptionsManager.class, "requestFlushUnsubscriptions", "requestFlushUnsubscriptions(Lkotlin/jvm/functions/Function0;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Function0<? extends Unit> function0) {
        invoke2((Function0<Unit>) function0);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(function0, "p1");
        ((GuildSubscriptionsManager) this.receiver).requestFlushUnsubscriptions(function0);
    }
}
