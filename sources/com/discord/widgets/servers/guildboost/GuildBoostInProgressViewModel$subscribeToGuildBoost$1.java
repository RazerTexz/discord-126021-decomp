package com.discord.widgets.servers.guildboost;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.Subscription;

/* JADX INFO: compiled from: GuildBoostInProgressViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildBoostInProgressViewModel$subscribeToGuildBoost$1 extends o implements Function1<Subscription, Unit> {
    public final /* synthetic */ GuildBoostInProgressViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBoostInProgressViewModel$subscribeToGuildBoost$1(GuildBoostInProgressViewModel guildBoostInProgressViewModel) {
        super(1);
        this.this$0 = guildBoostInProgressViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
        invoke2(subscription);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Subscription subscription) {
        m.checkNotNullParameter(subscription, "it");
        GuildBoostInProgressViewModel.access$setGuildBoostSubscription$p(this.this$0, subscription);
    }
}
