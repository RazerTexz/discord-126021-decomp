package com.discord.stores;

import b.d.b.a.a;
import com.discord.gateway.GatewaySocket$IdentifyData;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreGatewayConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreGatewayConnection$ClientState {
    public static final StoreGatewayConnection$ClientState$Companion Companion = new StoreGatewayConnection$ClientState$Companion(null);
    private final boolean authed;
    private final StoreClientDataState$ClientDataState clientDataState;
    private final String tokenIfAvailable;

    public StoreGatewayConnection$ClientState(String str, boolean z2, StoreClientDataState$ClientDataState storeClientDataState$ClientDataState) {
        m.checkNotNullParameter(storeClientDataState$ClientDataState, "clientDataState");
        this.tokenIfAvailable = str;
        this.authed = z2;
        this.clientDataState = storeClientDataState$ClientDataState;
    }

    public static /* synthetic */ StoreGatewayConnection$ClientState copy$default(StoreGatewayConnection$ClientState storeGatewayConnection$ClientState, String str, boolean z2, StoreClientDataState$ClientDataState storeClientDataState$ClientDataState, int i, Object obj) {
        if ((i & 1) != 0) {
            str = storeGatewayConnection$ClientState.tokenIfAvailable;
        }
        if ((i & 2) != 0) {
            z2 = storeGatewayConnection$ClientState.authed;
        }
        if ((i & 4) != 0) {
            storeClientDataState$ClientDataState = storeGatewayConnection$ClientState.clientDataState;
        }
        return storeGatewayConnection$ClientState.copy(str, z2, storeClientDataState$ClientDataState);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTokenIfAvailable() {
        return this.tokenIfAvailable;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getAuthed() {
        return this.authed;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final StoreClientDataState$ClientDataState getClientDataState() {
        return this.clientDataState;
    }

    public final StoreGatewayConnection$ClientState copy(String tokenIfAvailable, boolean authed, StoreClientDataState$ClientDataState clientDataState) {
        m.checkNotNullParameter(clientDataState, "clientDataState");
        return new StoreGatewayConnection$ClientState(tokenIfAvailable, authed, clientDataState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreGatewayConnection$ClientState)) {
            return false;
        }
        StoreGatewayConnection$ClientState storeGatewayConnection$ClientState = (StoreGatewayConnection$ClientState) other;
        return m.areEqual(this.tokenIfAvailable, storeGatewayConnection$ClientState.tokenIfAvailable) && this.authed == storeGatewayConnection$ClientState.authed && m.areEqual(this.clientDataState, storeGatewayConnection$ClientState.clientDataState);
    }

    public final boolean getAuthed() {
        return this.authed;
    }

    public final StoreClientDataState$ClientDataState getClientDataState() {
        return this.clientDataState;
    }

    public final GatewaySocket$IdentifyData getIdentifyData() {
        String str = this.tokenIfAvailable;
        if (str != null) {
            return new GatewaySocket$IdentifyData(str, this.clientDataState.toIdentifyData());
        }
        return null;
    }

    public final String getTokenIfAvailable() {
        return this.tokenIfAvailable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        String str = this.tokenIfAvailable;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z2 = this.authed;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode + r2) * 31;
        StoreClientDataState$ClientDataState storeClientDataState$ClientDataState = this.clientDataState;
        return i + (storeClientDataState$ClientDataState != null ? storeClientDataState$ClientDataState.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ClientState(tokenIfAvailable=");
        sbU.append(this.tokenIfAvailable);
        sbU.append(", authed=");
        sbU.append(this.authed);
        sbU.append(", clientDataState=");
        sbU.append(this.clientDataState);
        sbU.append(")");
        return sbU.toString();
    }
}
