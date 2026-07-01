package com.discord.stores;

import d0.t.n;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: StoreApplicationCommands.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationCommands$requestApplicationCommands$1 extends o implements Function0<Unit> {
    public final /* synthetic */ Long $applicationId;
    public final /* synthetic */ Long $guildId;
    public final /* synthetic */ int $limit;
    public final /* synthetic */ int $offset;
    public final /* synthetic */ StoreApplicationCommands this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplicationCommands$requestApplicationCommands$1(StoreApplicationCommands storeApplicationCommands, Long l, int i, int i2, Long l2) {
        super(0);
        this.this$0 = storeApplicationCommands;
        this.$guildId = l;
        this.$offset = i;
        this.$limit = i2;
        this.$applicationId = l2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (StoreApplicationCommands.access$isLoadingDiscoveryCommands$p(this.this$0)) {
            return;
        }
        String strAccess$generateNonce = StoreApplicationCommands.access$generateNonce(this.this$0);
        StoreApplicationCommands.access$setDiscoverCommandsNonce$p(this.this$0, strAccess$generateNonce);
        LoadState loadState = (StoreApplicationCommands.access$getLoadDirectionDown$p(this.this$0) || StoreApplicationCommands.access$getLoadDirectionUp$p(this.this$0)) ? StoreApplicationCommands.access$getDiscoverCommands$p(this.this$0).getLoadState() : LoadState$Loading.INSTANCE;
        if (!m.areEqual(StoreApplicationCommands.access$getDiscoverGuildId$p(this.this$0), this.$guildId)) {
            StoreApplicationCommands storeApplicationCommands = this.this$0;
            StoreApplicationCommands.access$setDiscoverCommands$p(storeApplicationCommands, DiscoverCommands.copy$default(StoreApplicationCommands.access$getDiscoverCommands$p(storeApplicationCommands), n.emptyList(), 0, 0, false, false, 0, null, loadState, 126, null));
            this.this$0.markChanged(StoreApplicationCommands.Companion.getDiscoverCommandsUpdate());
        } else {
            StoreApplicationCommands storeApplicationCommands2 = this.this$0;
            StoreApplicationCommands.access$setDiscoverCommands$p(storeApplicationCommands2, DiscoverCommands.copy$default(StoreApplicationCommands.access$getDiscoverCommands$p(storeApplicationCommands2), null, 0, 0, false, false, 0, null, loadState, Opcodes.LAND, null));
            this.this$0.markChanged(StoreApplicationCommands.Companion.getDiscoverCommandsUpdate());
        }
        StoreApplicationCommands.access$setDiscoverGuildId$p(this.this$0, this.$guildId);
        Long l = this.$guildId;
        if (l == null || l.longValue() <= 0) {
            Long l2 = this.$applicationId;
            if (l2 == null) {
                StoreApplicationCommands storeApplicationCommands3 = this.this$0;
                StoreApplicationCommands.access$handleDiscoverCommandsUpdate(storeApplicationCommands3, StoreApplicationCommands.access$getBuiltInCommandsProvider$p(storeApplicationCommands3).getBuiltInCommands());
            } else if (!m.areEqual(l2, StoreApplicationCommands.access$getDiscoverApplicationId$p(this.this$0))) {
                StoreApplicationCommands.access$setLoadingDiscoveryCommands$p(this.this$0, true);
                StoreApplicationCommands.access$getApplicationCommandsViaRest(this.this$0, this.$applicationId.longValue());
            }
        } else {
            boolean zRequestApplicationCommands$default = StoreGatewayConnection.requestApplicationCommands$default(StoreApplicationCommands.access$getStoreGatewayConnection$p(this.this$0), this.$guildId.longValue(), strAccess$generateNonce, false, null, Integer.valueOf(this.$offset), this.$limit, null, 72, null);
            StoreApplicationCommands.access$setLoadingDiscoveryCommands$p(this.this$0, zRequestApplicationCommands$default);
            if (!zRequestApplicationCommands$default) {
                StoreApplicationCommands storeApplicationCommands4 = this.this$0;
                StoreApplicationCommands.access$handleDiscoverCommandsUpdate(storeApplicationCommands4, StoreApplicationCommands.access$getBuiltInCommandsProvider$p(storeApplicationCommands4).getBuiltInCommands());
            }
        }
        StoreApplicationCommands.access$setDiscoverApplicationId$p(this.this$0, this.$applicationId);
    }
}
