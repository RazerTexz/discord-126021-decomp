package com.discord.api.connectedaccounts;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: ConnectedAccount.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ConnectedAccount {
    public static final ConnectedAccount$Companion Companion = new ConnectedAccount$Companion(null);
    public static final int HIDDEN = 0;
    public static final int VISIBLE = 1;
    private final boolean friendSync;
    private final String id;
    private final List<ConnectedAccountIntegration> integrations;
    private final String name;
    private final boolean revoked;
    private final boolean showActivity;
    private final String type;
    private final boolean verified;
    private final int visibility;

    public ConnectedAccount() {
        a.q0("", ModelAuditLogEntry.CHANGE_KEY_ID, "", ModelAuditLogEntry.CHANGE_KEY_NAME, "", "type");
        this.id = "";
        this.name = "";
        this.visibility = 0;
        this.friendSync = false;
        this.showActivity = false;
        this.revoked = false;
        this.verified = false;
        this.integrations = null;
        this.type = "";
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final boolean getFriendSync() {
        return this.friendSync;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final List<ConnectedAccountIntegration> c() {
        return this.integrations;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final boolean getRevoked() {
        return this.revoked;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConnectedAccount)) {
            return false;
        }
        ConnectedAccount connectedAccount = (ConnectedAccount) other;
        return m.areEqual(this.id, connectedAccount.id) && m.areEqual(this.name, connectedAccount.name) && this.visibility == connectedAccount.visibility && this.friendSync == connectedAccount.friendSync && this.showActivity == connectedAccount.showActivity && this.revoked == connectedAccount.revoked && this.verified == connectedAccount.verified && m.areEqual(this.integrations, connectedAccount.integrations) && m.areEqual(this.type, connectedAccount.type);
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final boolean getShowActivity() {
        return this.showActivity;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final boolean getVerified() {
        return this.verified;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        String str = this.id;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int iHashCode2 = (((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.visibility) * 31;
        boolean z2 = this.friendSync;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode2 + r2) * 31;
        boolean z3 = this.showActivity;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i2 = (i + r3) * 31;
        boolean z4 = this.revoked;
        ?? r4 = z4;
        if (z4) {
            r4 = 1;
        }
        int i3 = (i2 + r4) * 31;
        boolean z5 = this.verified;
        int i4 = (i3 + (z5 ? 1 : z5)) * 31;
        List<ConnectedAccountIntegration> list = this.integrations;
        int iHashCode3 = (i4 + (list != null ? list.hashCode() : 0)) * 31;
        String str3 = this.type;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final int getVisibility() {
        return this.visibility;
    }

    public String toString() {
        StringBuilder sbU = a.U("ConnectedAccount(id=");
        sbU.append(this.id);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", visibility=");
        sbU.append(this.visibility);
        sbU.append(", friendSync=");
        sbU.append(this.friendSync);
        sbU.append(", showActivity=");
        sbU.append(this.showActivity);
        sbU.append(", revoked=");
        sbU.append(this.revoked);
        sbU.append(", verified=");
        sbU.append(this.verified);
        sbU.append(", integrations=");
        sbU.append(this.integrations);
        sbU.append(", type=");
        return a.J(sbU, this.type, ")");
    }
}
