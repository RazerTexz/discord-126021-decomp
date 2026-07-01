package com.discord.models.domain;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: ModelRemoteAuthHandshake.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelRemoteAuthHandshake {
    private final String handshakeToken;

    public ModelRemoteAuthHandshake(String str) {
        Intrinsics3.checkNotNullParameter(str, "handshakeToken");
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
        Intrinsics3.checkNotNullParameter(handshakeToken, "handshakeToken");
        return new ModelRemoteAuthHandshake(handshakeToken);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ModelRemoteAuthHandshake) && Intrinsics3.areEqual(this.handshakeToken, ((ModelRemoteAuthHandshake) other).handshakeToken);
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
        return outline.J(outline.U("ModelRemoteAuthHandshake(handshakeToken="), this.handshakeToken, ")");
    }
}
