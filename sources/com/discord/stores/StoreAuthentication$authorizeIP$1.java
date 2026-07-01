package com.discord.stores;

import com.discord.analytics.generated.events.network_action.TrackNetworkActionAuthorizeIp;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreAuthentication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAuthentication$authorizeIP$1 extends o implements Function1<Void, TrackNetworkMetadataReceiver> {
    public static final StoreAuthentication$authorizeIP$1 INSTANCE = new StoreAuthentication$authorizeIP$1();

    public StoreAuthentication$authorizeIP$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ TrackNetworkMetadataReceiver invoke(Void r1) {
        return invoke2(r1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final TrackNetworkMetadataReceiver invoke2(Void r1) {
        return new TrackNetworkActionAuthorizeIp();
    }
}
