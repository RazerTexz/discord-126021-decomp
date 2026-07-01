package com.discord.api.auth.mfa;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: DisableMfaRequestBody.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class DisableMfaRequestBody {
    private final String code;

    public DisableMfaRequestBody(String str) {
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_CODE);
        this.code = str;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof DisableMfaRequestBody) && m.areEqual(this.code, ((DisableMfaRequestBody) other).code);
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
        return a.J(a.U("DisableMfaRequestBody(code="), this.code, ")");
    }
}
