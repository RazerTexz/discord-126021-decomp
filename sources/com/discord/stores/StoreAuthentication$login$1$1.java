package com.discord.stores;

import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserLogin;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.models.domain.ModelInvite;
import com.discord.models.domain.auth.ModelLoginResult;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.o;
import j0.m.a;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: StoreAuthentication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAuthentication$login$1$1 extends o implements Function1<ModelLoginResult, TrackNetworkMetadataReceiver> {
    public static final StoreAuthentication$login$1$1 INSTANCE = new StoreAuthentication$login$1$1();

    public StoreAuthentication$login$1$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ TrackNetworkMetadataReceiver invoke(ModelLoginResult modelLoginResult) {
        return invoke2(modelLoginResult);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final TrackNetworkMetadataReceiver invoke2(ModelLoginResult modelLoginResult) {
        Observable observableM = ObservableExtensionsKt.takeSingleUntilTimeout$default(StoreStream.Companion.getInviteSettings().getInvite(), 250L, false, 2, null).M(StoreAuthentication$login$1$1$invite$1.INSTANCE);
        ModelInvite modelInvite = (ModelInvite) new a(observableM).a(observableM.z());
        return new TrackNetworkActionUserLogin(modelInvite != null ? modelInvite.code : null, null, 2);
    }
}
