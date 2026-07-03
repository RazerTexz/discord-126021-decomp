package com.discord.stores;

import com.discord.stores.StoreClientDataState;
import com.discord.stores.StoreGatewayConnection;
import kotlin.jvm.functions.Function5;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StoreGatewayConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreGatewayConnection$ClientState$Companion$initialize$1 extends C12236k implements Function5<Boolean, String, Long, Boolean, StoreClientDataState.ClientDataState, StoreGatewayConnection.ClientState> {
    public StoreGatewayConnection$ClientState$Companion$initialize$1(StoreGatewayConnection.ClientState.Companion companion) {
        super(5, companion, StoreGatewayConnection.ClientState.Companion.class, "create", "create(ZLjava/lang/String;JZLcom/discord/stores/StoreClientDataState$ClientDataState;)Lcom/discord/stores/StoreGatewayConnection$ClientState;", 0);
    }

    @Override // kotlin.jvm.functions.Function5
    public /* bridge */ /* synthetic */ StoreGatewayConnection.ClientState invoke(Boolean bool, String str, Long l, Boolean bool2, StoreClientDataState.ClientDataState clientDataState) {
        return invoke(bool.booleanValue(), str, l.longValue(), bool2.booleanValue(), clientDataState);
    }

    public final StoreGatewayConnection.ClientState invoke(boolean z2, String str, long j, boolean z3, StoreClientDataState.ClientDataState clientDataState) {
        C12238m.checkNotNullParameter(clientDataState, "p5");
        return ((StoreGatewayConnection.ClientState.Companion) this.receiver).create(z2, str, j, z3, clientDataState);
    }
}
