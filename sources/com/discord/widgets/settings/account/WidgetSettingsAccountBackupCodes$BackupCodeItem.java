package com.discord.widgets.settings.account;

import b.d.b.a.a;
import com.discord.api.auth.mfa.BackupCode;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettingsAccountBackupCodes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetSettingsAccountBackupCodes$BackupCodeItem implements MGRecyclerDataPayload {
    private final BackupCode backupCode;
    private final String key;
    private final int type;

    public WidgetSettingsAccountBackupCodes$BackupCodeItem(BackupCode backupCode) {
        m.checkNotNullParameter(backupCode, "backupCode");
        this.backupCode = backupCode;
        this.type = 1;
        this.key = backupCode.getCode();
    }

    public static /* synthetic */ WidgetSettingsAccountBackupCodes$BackupCodeItem copy$default(WidgetSettingsAccountBackupCodes$BackupCodeItem widgetSettingsAccountBackupCodes$BackupCodeItem, BackupCode backupCode, int i, Object obj) {
        if ((i & 1) != 0) {
            backupCode = widgetSettingsAccountBackupCodes$BackupCodeItem.backupCode;
        }
        return widgetSettingsAccountBackupCodes$BackupCodeItem.copy(backupCode);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final BackupCode getBackupCode() {
        return this.backupCode;
    }

    public final WidgetSettingsAccountBackupCodes$BackupCodeItem copy(BackupCode backupCode) {
        m.checkNotNullParameter(backupCode, "backupCode");
        return new WidgetSettingsAccountBackupCodes$BackupCodeItem(backupCode);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetSettingsAccountBackupCodes$BackupCodeItem) && m.areEqual(this.backupCode, ((WidgetSettingsAccountBackupCodes$BackupCodeItem) other).backupCode);
        }
        return true;
    }

    public final BackupCode getBackupCode() {
        return this.backupCode;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        BackupCode backupCode = this.backupCode;
        if (backupCode != null) {
            return backupCode.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("BackupCodeItem(backupCode=");
        sbU.append(this.backupCode);
        sbU.append(")");
        return sbU.toString();
    }
}
