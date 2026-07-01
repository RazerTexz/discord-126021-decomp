package com.discord.restapi;

import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RestAPIParams$VerifyEmail {
    private final boolean allowMultipleGuilds;
    private final String email;
    private final Long guildId;
    private final boolean useVerificationCode;

    public RestAPIParams$VerifyEmail(String str, Long l, boolean z2, boolean z3) {
        m.checkNotNullParameter(str, NotificationCompat.CATEGORY_EMAIL);
        this.email = str;
        this.guildId = l;
        this.allowMultipleGuilds = z2;
        this.useVerificationCode = z3;
    }

    public static /* synthetic */ RestAPIParams$VerifyEmail copy$default(RestAPIParams$VerifyEmail restAPIParams$VerifyEmail, String str, Long l, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = restAPIParams$VerifyEmail.email;
        }
        if ((i & 2) != 0) {
            l = restAPIParams$VerifyEmail.guildId;
        }
        if ((i & 4) != 0) {
            z2 = restAPIParams$VerifyEmail.allowMultipleGuilds;
        }
        if ((i & 8) != 0) {
            z3 = restAPIParams$VerifyEmail.useVerificationCode;
        }
        return restAPIParams$VerifyEmail.copy(str, l, z2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getAllowMultipleGuilds() {
        return this.allowMultipleGuilds;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getUseVerificationCode() {
        return this.useVerificationCode;
    }

    public final RestAPIParams$VerifyEmail copy(String email, Long guildId, boolean allowMultipleGuilds, boolean useVerificationCode) {
        m.checkNotNullParameter(email, NotificationCompat.CATEGORY_EMAIL);
        return new RestAPIParams$VerifyEmail(email, guildId, allowMultipleGuilds, useVerificationCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RestAPIParams$VerifyEmail)) {
            return false;
        }
        RestAPIParams$VerifyEmail restAPIParams$VerifyEmail = (RestAPIParams$VerifyEmail) other;
        return m.areEqual(this.email, restAPIParams$VerifyEmail.email) && m.areEqual(this.guildId, restAPIParams$VerifyEmail.guildId) && this.allowMultipleGuilds == restAPIParams$VerifyEmail.allowMultipleGuilds && this.useVerificationCode == restAPIParams$VerifyEmail.useVerificationCode;
    }

    public final boolean getAllowMultipleGuilds() {
        return this.allowMultipleGuilds;
    }

    public final String getEmail() {
        return this.email;
    }

    public final Long getGuildId() {
        return this.guildId;
    }

    public final boolean getUseVerificationCode() {
        return this.useVerificationCode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public int hashCode() {
        String str = this.email;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Long l = this.guildId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        boolean z2 = this.allowMultipleGuilds;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode2 + r1) * 31;
        boolean z3 = this.useVerificationCode;
        return i + (z3 ? 1 : z3);
    }

    public String toString() {
        StringBuilder sbU = a.U("VerifyEmail(email=");
        sbU.append(this.email);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", allowMultipleGuilds=");
        sbU.append(this.allowMultipleGuilds);
        sbU.append(", useVerificationCode=");
        return a.O(sbU, this.useVerificationCode, ")");
    }

    public /* synthetic */ RestAPIParams$VerifyEmail(String str, Long l, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? true : z3);
    }
}
