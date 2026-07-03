package com.discord.api.auth.mfa;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: DisableMfaRequestBody.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class DisableMfaRequestBody {
    private final String code;

    public DisableMfaRequestBody(String str) {
        C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_CODE);
        this.code = str;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof DisableMfaRequestBody) && C12238m.areEqual(this.code, ((DisableMfaRequestBody) other).code);
        }
        return true;
    }

    public int hashCode() {
        String str = this.code;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return C1643a.m822J(C1643a.m833U("DisableMfaRequestBody(code="), this.code, ")");
    }
}
