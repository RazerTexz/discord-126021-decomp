package com.discord.widgets.servers.auditlog;

import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;

/* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilterAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogFilterAdapter$AuditLogUserFilterItem implements MGRecyclerDataPayload {
    private final Integer discriminator;
    private final GuildMember guildMember;
    private final long id;
    private final boolean isChecked;
    private final String key;
    private final CharSequence text;
    private final int type;
    private final User user;

    public WidgetServerSettingsAuditLogFilterAdapter$AuditLogUserFilterItem(User user, GuildMember guildMember, long j, CharSequence charSequence, Integer num, boolean z2) {
        this.user = user;
        this.guildMember = guildMember;
        this.id = j;
        this.text = charSequence;
        this.discriminator = num;
        this.isChecked = z2;
        this.key = String.valueOf(j);
    }

    public final Integer getDiscriminator() {
        return this.discriminator;
    }

    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    public final long getId() {
        return this.id;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final CharSequence getText() {
        return this.text;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public final User getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: isChecked, reason: from getter */
    public final boolean getIsChecked() {
        return this.isChecked;
    }
}
