package com.discord.api.auth.mfa;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: DisableMfaRequestBody.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class DisableMfaRequestBody {
    private final String code;

    public DisableMfaRequestBody(String str) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_CODE);
        this.code = str;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof DisableMfaRequestBody) && Intrinsics3.areEqual(this.code, ((DisableMfaRequestBody) other).code);
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
        return outline.J(outline.U("DisableMfaRequestBody(code="), this.code, ")");
    }
}
