package com.discord.stores;

import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserLoginMfa;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.models.domain.auth.ModelLoginResult;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreAuthentication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAuthentication$authMFA$1 extends o implements Function1<ModelLoginResult, TrackNetworkMetadataReceiver> {
    public static final StoreAuthentication$authMFA$1 INSTANCE = new StoreAuthentication$authMFA$1();

    public StoreAuthentication$authMFA$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ TrackNetworkMetadataReceiver invoke(ModelLoginResult modelLoginResult) {
        return invoke2(modelLoginResult);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final TrackNetworkMetadataReceiver invoke2(ModelLoginResult modelLoginResult) {
        return new TrackNetworkActionUserLoginMfa();
    }
}
