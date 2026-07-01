package com.discord.stores;

import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserConnectionsUpdate;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreUserConnections.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserConnections$deleteUserConnection$1 extends o implements Function1<Void, TrackNetworkMetadataReceiver> {
    public static final StoreUserConnections$deleteUserConnection$1 INSTANCE = new StoreUserConnections$deleteUserConnection$1();

    public StoreUserConnections$deleteUserConnection$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ TrackNetworkMetadataReceiver invoke(Void r1) {
        return invoke2(r1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final TrackNetworkMetadataReceiver invoke2(Void r7) {
        return new TrackNetworkActionUserConnectionsUpdate(null, null, null, null, 15);
    }
}
