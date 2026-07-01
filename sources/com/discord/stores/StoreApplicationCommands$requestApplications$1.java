package com.discord.stores;

import com.discord.models.commands.Application;
import d0.t.n;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreApplicationCommands.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationCommands$requestApplications$1 extends o implements Function0<Unit> {
    public final /* synthetic */ Long $guildId;
    public final /* synthetic */ StoreApplicationCommands this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplicationCommands$requestApplications$1(StoreApplicationCommands storeApplicationCommands, Long l) {
        super(0);
        this.this$0 = storeApplicationCommands;
        this.$guildId = l;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        String strAccess$generateNonce = StoreApplicationCommands.access$generateNonce(this.this$0);
        StoreApplicationCommands.access$setApplicationNonce$p(this.this$0, strAccess$generateNonce);
        StoreApplicationCommands.access$setApplications$p(this.this$0, n.emptyList());
        StoreApplicationCommands.access$getApplicationCommandIndexes$p(this.this$0).clear();
        this.this$0.markChanged(StoreApplicationCommands.Companion.getGuildApplicationsUpdate());
        Long l = this.$guildId;
        if (l != null && l.longValue() > 0) {
            StoreGatewayConnection.requestApplicationCommands$default(StoreApplicationCommands.access$getStoreGatewayConnection$p(this.this$0), this.$guildId.longValue(), strAccess$generateNonce, true, null, null, 0, null, 88, null);
        } else {
            StoreApplicationCommands storeApplicationCommands = this.this$0;
            StoreApplicationCommands.access$handleGuildApplicationsUpdate(storeApplicationCommands, n.listOf((Object[]) new Application[]{StoreApplicationCommands.access$getBuiltInCommandsProvider$p(storeApplicationCommands).getFrecencyApplication(), StoreApplicationCommands.access$getBuiltInCommandsProvider$p(this.this$0).getBuiltInApplication()}));
        }
    }
}
