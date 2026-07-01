package com.discord.widgets.servers.auditlog;

import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilterAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogFilterAdapter$AuditLogActionFilterItem implements MGRecyclerDataPayload {
    private final int actionId;
    private final boolean isChecked;
    private final String key;
    private final String text;
    private final int type;

    public WidgetServerSettingsAuditLogFilterAdapter$AuditLogActionFilterItem(int i, String str, boolean z2) {
        m.checkNotNullParameter(str, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        this.actionId = i;
        this.text = str;
        this.isChecked = z2;
        this.type = 1;
        this.key = String.valueOf(i);
    }

    public final int getActionId() {
        return this.actionId;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final String getText() {
        return this.text;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: isChecked, reason: from getter */
    public final boolean getIsChecked() {
        return this.isChecked;
    }
}
