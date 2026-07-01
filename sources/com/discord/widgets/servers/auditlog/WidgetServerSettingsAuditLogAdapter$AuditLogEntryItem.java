package com.discord.widgets.servers.auditlog;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsAuditLogAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogAdapter$AuditLogEntryItem implements MGRecyclerDataPayload {
    private final ModelAuditLogEntry auditLogEntry;
    private final CharSequence changeText;
    private final GuildMember guildMember;
    private final boolean hasChangesToRender;
    private final CharSequence headerText;
    private final boolean isSelected;
    private final String key;
    private final CharSequence timeStampText;
    private final int type;
    private final User user;

    public WidgetServerSettingsAuditLogAdapter$AuditLogEntryItem(ModelAuditLogEntry modelAuditLogEntry, boolean z2, User user, GuildMember guildMember, CharSequence charSequence, CharSequence charSequence2, boolean z3, CharSequence charSequence3) {
        m.checkNotNullParameter(modelAuditLogEntry, "auditLogEntry");
        m.checkNotNullParameter(charSequence3, "timeStampText");
        this.auditLogEntry = modelAuditLogEntry;
        this.isSelected = z2;
        this.user = user;
        this.guildMember = guildMember;
        this.headerText = charSequence;
        this.changeText = charSequence2;
        this.hasChangesToRender = z3;
        this.timeStampText = charSequence3;
        this.key = String.valueOf(modelAuditLogEntry.getId());
    }

    public final ModelAuditLogEntry getAuditLogEntry() {
        return this.auditLogEntry;
    }

    public final CharSequence getChangeText() {
        return this.changeText;
    }

    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    public final boolean getHasChangesToRender() {
        return this.hasChangesToRender;
    }

    public final CharSequence getHeaderText() {
        return this.headerText;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final CharSequence getTimeStampText() {
        return this.timeStampText;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public final User getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: isSelected, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }
}
