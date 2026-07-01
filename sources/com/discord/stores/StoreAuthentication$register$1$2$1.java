package com.discord.stores;

import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserRegister;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.api.auth.RegisterResponse;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreAuthentication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAuthentication$register$1$2$1 extends o implements Function1<RegisterResponse, TrackNetworkMetadataReceiver> {
    public final /* synthetic */ String $inviteCode;
    public final /* synthetic */ StoreAuthentication$register$1$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreAuthentication$register$1$2$1(StoreAuthentication$register$1$2 storeAuthentication$register$1$2, String str) {
        super(1);
        this.this$0 = storeAuthentication$register$1$2;
        this.$inviteCode = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ TrackNetworkMetadataReceiver invoke(RegisterResponse registerResponse) {
        return invoke2(registerResponse);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final TrackNetworkMetadataReceiver invoke2(RegisterResponse registerResponse) {
        return new TrackNetworkActionUserRegister(this.$inviteCode, Boolean.valueOf(this.this$0.this$0.$consent), Boolean.FALSE);
    }
}
