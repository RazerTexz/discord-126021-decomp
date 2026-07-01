package com.discord.restapi;

import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RestAPIParams$VerifyEmailCode {
    private final String code;
    private final String email;
    private final Long guildId;

    public RestAPIParams$VerifyEmailCode(String str, String str2, Long l) {
        m.checkNotNullParameter(str, NotificationCompat.CATEGORY_EMAIL);
        m.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_CODE);
        this.email = str;
        this.code = str2;
        this.guildId = l;
    }

    public static /* synthetic */ RestAPIParams$VerifyEmailCode copy$default(RestAPIParams$VerifyEmailCode restAPIParams$VerifyEmailCode, String str, String str2, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = restAPIParams$VerifyEmailCode.email;
        }
        if ((i & 2) != 0) {
            str2 = restAPIParams$VerifyEmailCode.code;
        }
        if ((i & 4) != 0) {
            l = restAPIParams$VerifyEmailCode.guildId;
        }
        return restAPIParams$VerifyEmailCode.copy(str, str2, l);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Long getGuildId() {
        return this.guildId;
    }

    public final RestAPIParams$VerifyEmailCode copy(String email, String code, Long guildId) {
        m.checkNotNullParameter(email, NotificationCompat.CATEGORY_EMAIL);
        m.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
        return new RestAPIParams$VerifyEmailCode(email, code, guildId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RestAPIParams$VerifyEmailCode)) {
            return false;
        }
        RestAPIParams$VerifyEmailCode restAPIParams$VerifyEmailCode = (RestAPIParams$VerifyEmailCode) other;
        return m.areEqual(this.email, restAPIParams$VerifyEmailCode.email) && m.areEqual(this.code, restAPIParams$VerifyEmailCode.code) && m.areEqual(this.guildId, restAPIParams$VerifyEmailCode.guildId);
    }

    public final String getCode() {
        return this.code;
    }

    public final String getEmail() {
        return this.email;
    }

    public final Long getGuildId() {
        return this.guildId;
    }

    public int hashCode() {
        String str = this.email;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.code;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Long l = this.guildId;
        return iHashCode2 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("VerifyEmailCode(email=");
        sbU.append(this.email);
        sbU.append(", code=");
        sbU.append(this.code);
        sbU.append(", guildId=");
        return a.G(sbU, this.guildId, ")");
    }
}
