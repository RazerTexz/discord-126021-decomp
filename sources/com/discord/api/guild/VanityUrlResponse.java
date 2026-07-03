package com.discord.api.guild;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.code, vanityUrlResponse.code) && this.uses == vanityUrlResponse.uses;
    }

    public int hashCode() {
        String str = this.code;
        return ((str != null ? str.hashCode() : 0) * 31) + this.uses;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("VanityUrlResponse(code=");
        sbM833U.append(this.code);
        sbM833U.append(", uses=");
        return C1643a.m814B(sbM833U, this.uses, ")");
    }
}
