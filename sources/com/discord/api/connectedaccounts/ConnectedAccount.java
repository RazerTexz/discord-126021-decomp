package com.discord.api.connectedaccounts;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ConnectedAccount.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ConnectedAccount {
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
        C1643a.m872q0("", ModelAuditLogEntry.CHANGE_KEY_ID, "", ModelAuditLogEntry.CHANGE_KEY_NAME, "", "type");
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

    /* JADX INFO: renamed from: c */
    public final List<ConnectedAccountIntegration> m7751c() {
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
        return C12238m.areEqual(this.id, connectedAccount.id) && C12238m.areEqual(this.name, connectedAccount.name) && this.visibility == connectedAccount.visibility && this.friendSync == connectedAccount.friendSync && this.showActivity == connectedAccount.showActivity && this.revoked == connectedAccount.revoked && this.verified == connectedAccount.verified && C12238m.areEqual(this.integrations, connectedAccount.integrations) && C12238m.areEqual(this.type, connectedAccount.type);
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
        StringBuilder sbM833U = C1643a.m833U("ConnectedAccount(id=");
        sbM833U.append(this.id);
        sbM833U.append(", name=");
        sbM833U.append(this.name);
        sbM833U.append(", visibility=");
        sbM833U.append(this.visibility);
        sbM833U.append(", friendSync=");
        sbM833U.append(this.friendSync);
        sbM833U.append(", showActivity=");
        sbM833U.append(this.showActivity);
        sbM833U.append(", revoked=");
        sbM833U.append(this.revoked);
        sbM833U.append(", verified=");
        sbM833U.append(this.verified);
        sbM833U.append(", integrations=");
        sbM833U.append(this.integrations);
        sbM833U.append(", type=");
        return C1643a.m822J(sbM833U, this.type, ")");
    }
}
