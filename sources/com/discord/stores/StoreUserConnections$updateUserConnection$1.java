package com.discord.stores;

import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserConnectionsUpdate;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.api.connectedaccounts.ConnectedAccount;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreUserConnections.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserConnections$updateUserConnection$1 extends o implements Function1<ConnectedAccount, TrackNetworkMetadataReceiver> {
    public final /* synthetic */ ConnectedAccount $connectedAccount;
    public final /* synthetic */ boolean $syncFriends;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUserConnections$updateUserConnection$1(ConnectedAccount connectedAccount, boolean z2) {
        super(1);
        this.$connectedAccount = connectedAccount;
        this.$syncFriends = z2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ TrackNetworkMetadataReceiver invoke(ConnectedAccount connectedAccount) {
        return invoke2(connectedAccount);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final TrackNetworkMetadataReceiver invoke2(ConnectedAccount connectedAccount) {
        return new TrackNetworkActionUserConnectionsUpdate(this.$connectedAccount.getName(), Boolean.valueOf(this.$syncFriends), null, null, 12);
    }
}
