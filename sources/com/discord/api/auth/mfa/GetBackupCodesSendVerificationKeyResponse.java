package com.discord.api.auth.mfa;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: GetBackupCodesSendVerificationKeyResponse.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GetBackupCodesSendVerificationKeyResponse {
    private final String nonce;
    private final String regenerateNonce;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getNonce() {
        return this.nonce;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getRegenerateNonce() {
        return this.regenerateNonce;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GetBackupCodesSendVerificationKeyResponse)) {
            return false;
        }
        GetBackupCodesSendVerificationKeyResponse getBackupCodesSendVerificationKeyResponse = (GetBackupCodesSendVerificationKeyResponse) other;
        return m.areEqual(this.nonce, getBackupCodesSendVerificationKeyResponse.nonce) && m.areEqual(this.regenerateNonce, getBackupCodesSendVerificationKeyResponse.regenerateNonce);
    }

    public int hashCode() {
        String str = this.nonce;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.regenerateNonce;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("GetBackupCodesSendVerificationKeyResponse(nonce=");
        sbU.append(this.nonce);
        sbU.append(", regenerateNonce=");
        return a.J(sbU, this.regenerateNonce, ")");
    }
}
