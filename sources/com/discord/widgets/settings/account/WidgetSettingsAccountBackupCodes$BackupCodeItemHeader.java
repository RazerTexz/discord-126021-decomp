package com.discord.widgets.settings.account;

import b.d.b.a.a;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettingsAccountBackupCodes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetSettingsAccountBackupCodes$BackupCodeItemHeader implements MGRecyclerDataPayload {
    private final CharSequence headerText;
    private final String key;
    private final int type;

    public WidgetSettingsAccountBackupCodes$BackupCodeItemHeader(CharSequence charSequence) {
        m.checkNotNullParameter(charSequence, "headerText");
        this.headerText = charSequence;
        this.key = charSequence.toString();
    }

    public static /* synthetic */ WidgetSettingsAccountBackupCodes$BackupCodeItemHeader copy$default(WidgetSettingsAccountBackupCodes$BackupCodeItemHeader widgetSettingsAccountBackupCodes$BackupCodeItemHeader, CharSequence charSequence, int i, Object obj) {
        if ((i & 1) != 0) {
            charSequence = widgetSettingsAccountBackupCodes$BackupCodeItemHeader.headerText;
        }
        return widgetSettingsAccountBackupCodes$BackupCodeItemHeader.copy(charSequence);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CharSequence getHeaderText() {
        return this.headerText;
    }

    public final WidgetSettingsAccountBackupCodes$BackupCodeItemHeader copy(CharSequence headerText) {
        m.checkNotNullParameter(headerText, "headerText");
        return new WidgetSettingsAccountBackupCodes$BackupCodeItemHeader(headerText);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetSettingsAccountBackupCodes$BackupCodeItemHeader) && m.areEqual(this.headerText, ((WidgetSettingsAccountBackupCodes$BackupCodeItemHeader) other).headerText);
        }
        return true;
    }

    public final CharSequence getHeaderText() {
        return this.headerText;
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
        CharSequence charSequence = this.headerText;
        if (charSequence != null) {
            return charSequence.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.E(a.U("BackupCodeItemHeader(headerText="), this.headerText, ")");
    }
}
