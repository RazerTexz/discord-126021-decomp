package com.discord.utilities.lazy.subscriptions;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildMemberSubscriptionsManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildMemberSubscriptionsManager$triggerUnsubscribe$2 extends o implements Function1<Long, Unit> {
    public final /* synthetic */ GuildMemberSubscriptionsManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMemberSubscriptionsManager$triggerUnsubscribe$2(GuildMemberSubscriptionsManager guildMemberSubscriptionsManager) {
        super(1);
        this.this$0 = guildMemberSubscriptionsManager;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke2(l);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Long l) {
        GuildMemberSubscriptionsManager.access$getRequestFlushUnsubscriptions$p(this.this$0).invoke(new GuildMemberSubscriptionsManager$triggerUnsubscribe$2$1(this.this$0));
    }
}
