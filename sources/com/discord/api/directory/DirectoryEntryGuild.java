package com.discord.api.directory;

import com.discord.api.guild.preview.GuildPreview;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: DirectoryEntryGuild.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class DirectoryEntryGuild {
    private final long authorId;
    private final UtcDateTime createdAt;
    private final String description;
    private final long directoryChannelId;
    private final long entityId;
    private final GuildPreview guild;
    private final int primaryCategoryId;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final UtcDateTime getCreatedAt() {
        return this.createdAt;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final long getDirectoryChannelId() {
        return this.directoryChannelId;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final long getEntityId() {
        return this.entityId;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final GuildPreview getGuild() {
        return this.guild;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DirectoryEntryGuild)) {
            return false;
        }
        DirectoryEntryGuild directoryEntryGuild = (DirectoryEntryGuild) other;
        return this.directoryChannelId == directoryEntryGuild.directoryChannelId && this.entityId == directoryEntryGuild.entityId && this.authorId == directoryEntryGuild.authorId && C12238m.areEqual(this.description, directoryEntryGuild.description) && this.primaryCategoryId == directoryEntryGuild.primaryCategoryId && C12238m.areEqual(this.guild, directoryEntryGuild.guild) && C12238m.areEqual(this.createdAt, directoryEntryGuild.createdAt);
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final int getPrimaryCategoryId() {
        return this.primaryCategoryId;
    }

    public int hashCode() {
        long j = this.directoryChannelId;
        long j2 = this.entityId;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.authorId;
        int i2 = (i + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        String str = this.description;
        int iHashCode = (((i2 + (str != null ? str.hashCode() : 0)) * 31) + this.primaryCategoryId) * 31;
        GuildPreview guildPreview = this.guild;
        int iHashCode2 = (iHashCode + (guildPreview != null ? guildPreview.hashCode() : 0)) * 31;
        UtcDateTime utcDateTime = this.createdAt;
        return iHashCode2 + (utcDateTime != null ? utcDateTime.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("DirectoryEntryGuild(directoryChannelId=");
        sbM833U.append(this.directoryChannelId);
        sbM833U.append(", entityId=");
        sbM833U.append(this.entityId);
        sbM833U.append(", authorId=");
        sbM833U.append(this.authorId);
        sbM833U.append(", description=");
        sbM833U.append(this.description);
        sbM833U.append(", primaryCategoryId=");
        sbM833U.append(this.primaryCategoryId);
        sbM833U.append(", guild=");
        sbM833U.append(this.guild);
        sbM833U.append(", createdAt=");
        sbM833U.append(this.createdAt);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
