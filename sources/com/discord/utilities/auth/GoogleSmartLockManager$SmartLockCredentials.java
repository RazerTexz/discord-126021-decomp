package com.discord.utilities.auth;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import d0.z.d.m;

/* JADX INFO: compiled from: GoogleSmartLockManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GoogleSmartLockManager$SmartLockCredentials {
    private final String id;
    private final String password;

    public GoogleSmartLockManager$SmartLockCredentials(String str, String str2) {
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_ID);
        m.checkNotNullParameter(str2, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
        this.id = str;
        this.password = str2;
    }

    public static /* synthetic */ GoogleSmartLockManager$SmartLockCredentials copy$default(GoogleSmartLockManager$SmartLockCredentials googleSmartLockManager$SmartLockCredentials, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = googleSmartLockManager$SmartLockCredentials.id;
        }
        if ((i & 2) != 0) {
            str2 = googleSmartLockManager$SmartLockCredentials.password;
        }
        return googleSmartLockManager$SmartLockCredentials.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPassword() {
        return this.password;
    }

    public final GoogleSmartLockManager$SmartLockCredentials copy(String id2, String password) {
        m.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
        m.checkNotNullParameter(password, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
        return new GoogleSmartLockManager$SmartLockCredentials(id2, password);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GoogleSmartLockManager$SmartLockCredentials)) {
            return false;
        }
        GoogleSmartLockManager$SmartLockCredentials googleSmartLockManager$SmartLockCredentials = (GoogleSmartLockManager$SmartLockCredentials) other;
        return m.areEqual(this.id, googleSmartLockManager$SmartLockCredentials.id) && m.areEqual(this.password, googleSmartLockManager$SmartLockCredentials.password);
    }

    public final String getId() {
        return this.id;
    }

    public final String getPassword() {
        return this.password;
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.password;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("SmartLockCredentials(id=");
        sbU.append(this.id);
        sbU.append(", password=");
        return a.J(sbU, this.password, ")");
    }
}
