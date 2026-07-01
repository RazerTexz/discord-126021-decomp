package com.discord.stores;

import com.discord.models.commands.Application;
import com.discord.models.user.User;
import com.discord.utilities.user.UserUtils;
import d0.t.n;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreApplicationCommands.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationCommands$handleDmUserApplication$1 extends o implements Function0<Unit> {
    public final /* synthetic */ User $botUser;
    public final /* synthetic */ StoreApplicationCommands this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplicationCommands$handleDmUserApplication$1(StoreApplicationCommands storeApplicationCommands, User user) {
        super(0);
        this.this$0 = storeApplicationCommands;
        this.$botUser = user;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreApplicationCommands.access$getFrecencyCommands$p(this.this$0).put(0L, n.emptyList());
        StoreApplicationCommands.access$setPendingGatewayGuildId$p(this.this$0, null);
        StoreApplicationCommands.access$setApplications$p(this.this$0, n.emptyList());
        StoreApplicationCommands.access$getApplicationCommandIndexes$p(this.this$0).clear();
        StoreApplicationCommands storeApplicationCommands = this.this$0;
        StoreApplicationCommands.access$handleGuildApplicationsUpdate(storeApplicationCommands, n.listOf((Object[]) new Application[]{StoreApplicationCommands.access$getBuiltInCommandsProvider$p(storeApplicationCommands).getFrecencyApplication(), new Application(this.$botUser.getId(), this.$botUser.getUsername(), null, null, 0, UserUtils.INSTANCE.synthesizeApiUser(this.$botUser), false, 8, null), StoreApplicationCommands.access$getBuiltInCommandsProvider$p(this.this$0).getBuiltInApplication()}));
        this.this$0.markChanged(StoreApplicationCommands.Companion.getFrecencyCommandsUpdate());
    }
}
