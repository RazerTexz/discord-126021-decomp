package com.discord.api.guild;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: VanityUrlResponse.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class VanityUrlResponse {
    private final String code;
    private final int uses;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final int getUses() {
        return this.uses;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VanityUrlResponse)) {
            return false;
        }
        VanityUrlResponse vanityUrlResponse = (VanityUrlResponse) other;
        return m.areEqual(this.code, vanityUrlResponse.code) && this.uses == vanityUrlResponse.uses;
    }

    public int hashCode() {
        String str = this.code;
        return ((str != null ? str.hashCode() : 0) * 31) + this.uses;
    }

    public String toString() {
        StringBuilder sbU = a.U("VanityUrlResponse(code=");
        sbU.append(this.code);
        sbU.append(", uses=");
        return a.B(sbU, this.uses, ")");
    }
}
