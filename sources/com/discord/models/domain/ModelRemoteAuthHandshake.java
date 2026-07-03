package com.discord.models.domain;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ModelRemoteAuthHandshake.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelRemoteAuthHandshake {
    private final String handshakeToken;

    public ModelRemoteAuthHandshake(String str) {
        C12238m.checkNotNullParameter(str, "handshakeToken");
        this.handshakeToken = str;
    }

    public static /* synthetic */ ModelRemoteAuthHandshake copy$default(ModelRemoteAuthHandshake modelRemoteAuthHandshake, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelRemoteAuthHandshake.handshakeToken;
        }
        return modelRemoteAuthHandshake.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getHandshakeToken() {
        return this.handshakeToken;
    }

    public final ModelRemoteAuthHandshake copy(String handshakeToken) {
        C12238m.checkNotNullParameter(handshakeToken, "handshakeToken");
        return new ModelRemoteAuthHandshake(handshakeToken);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ModelRemoteAuthHandshake) && C12238m.areEqual(this.handshakeToken, ((ModelRemoteAuthHandshake) other).handshakeToken);
        }
        return true;
    }

    public final String getHandshakeToken() {
        return this.handshakeToken;
    }

    public int hashCode() {
        String str = this.handshakeToken;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return C1643a.m822J(C1643a.m833U("ModelRemoteAuthHandshake(handshakeToken="), this.handshakeToken, ")");
    }
}
