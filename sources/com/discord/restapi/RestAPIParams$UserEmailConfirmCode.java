package com.discord.restapi;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RestAPIParams$UserEmailConfirmCode {
    private final String code;

    public RestAPIParams$UserEmailConfirmCode(String str) {
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_CODE);
        this.code = str;
    }

    public static /* synthetic */ RestAPIParams$UserEmailConfirmCode copy$default(RestAPIParams$UserEmailConfirmCode restAPIParams$UserEmailConfirmCode, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = restAPIParams$UserEmailConfirmCode.code;
        }
        return restAPIParams$UserEmailConfirmCode.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    public final RestAPIParams$UserEmailConfirmCode copy(String code) {
        m.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
        return new RestAPIParams$UserEmailConfirmCode(code);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof RestAPIParams$UserEmailConfirmCode) && m.areEqual(this.code, ((RestAPIParams$UserEmailConfirmCode) other).code);
        }
        return true;
    }

    public final String getCode() {
        return this.code;
    }

    public int hashCode() {
        String str = this.code;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.J(a.U("UserEmailConfirmCode(code="), this.code, ")");
    }
}
