package com.discord.models.domain;

import b.d.b.a.outline;
import com.discord.api.guild.Guild;
import com.discord.api.user.User;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: ModelGuildTemplate.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelGuildTemplate {
    private final String code;
    private final String createdAt;
    private final User creator;
    private final long creatorId;
    private final String description;
    private final String name;
    private final Guild serializedSourceGuild;
    private final long sourceGuildId;
    private final String updatedAt;
    private final int usageCount;

    public ModelGuildTemplate(long j, User user, long j2, Guild guild, String str, String str2, int i, String str3, String str4, String str5) {
        Intrinsics3.checkNotNullParameter(str, "createdAt");
        Intrinsics3.checkNotNullParameter(str2, "updatedAt");
        Intrinsics3.checkNotNullParameter(str3, ModelAuditLogEntry.CHANGE_KEY_CODE);
        Intrinsics3.checkNotNullParameter(str4, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(str5, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
        this.creatorId = j;
        this.creator = user;
        this.sourceGuildId = j2;
        this.serializedSourceGuild = guild;
        this.createdAt = str;
        this.updatedAt = str2;
        this.usageCount = i;
        this.code = str3;
        this.name = str4;
        this.description = str5;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getCreatorId() {
        return this.creatorId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final User getCreator() {
        return this.creator;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getSourceGuildId() {
        return this.sourceGuildId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Guild getSerializedSourceGuild() {
        return this.serializedSourceGuild;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getUsageCount() {
        return this.usageCount;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final ModelGuildTemplate copy(long creatorId, User creator, long sourceGuildId, Guild serializedSourceGuild, String createdAt, String updatedAt, int usageCount, String code, String name, String description) {
        Intrinsics3.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics3.checkNotNullParameter(updatedAt, "updatedAt");
        Intrinsics3.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(description, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
        return new ModelGuildTemplate(creatorId, creator, sourceGuildId, serializedSourceGuild, createdAt, updatedAt, usageCount, code, name, description);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelGuildTemplate)) {
            return false;
        }
        ModelGuildTemplate modelGuildTemplate = (ModelGuildTemplate) other;
        return this.creatorId == modelGuildTemplate.creatorId && Intrinsics3.areEqual(this.creator, modelGuildTemplate.creator) && this.sourceGuildId == modelGuildTemplate.sourceGuildId && Intrinsics3.areEqual(this.serializedSourceGuild, modelGuildTemplate.serializedSourceGuild) && Intrinsics3.areEqual(this.createdAt, modelGuildTemplate.createdAt) && Intrinsics3.areEqual(this.updatedAt, modelGuildTemplate.updatedAt) && this.usageCount == modelGuildTemplate.usageCount && Intrinsics3.areEqual(this.code, modelGuildTemplate.code) && Intrinsics3.areEqual(this.name, modelGuildTemplate.name) && Intrinsics3.areEqual(this.description, modelGuildTemplate.description);
    }

    public final String getCode() {
        return this.code;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final User getCreator() {
        return this.creator;
    }

    public final long getCreatorId() {
        return this.creatorId;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getName() {
        return this.name;
    }

    public final Guild getSerializedSourceGuild() {
        return this.serializedSourceGuild;
    }

    public final long getSourceGuildId() {
        return this.sourceGuildId;
    }

    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    public final int getUsageCount() {
        return this.usageCount;
    }

    public int hashCode() {
        long j = this.creatorId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        User user = this.creator;
        int iHashCode = user != null ? user.hashCode() : 0;
        long j2 = this.sourceGuildId;
        int i2 = (((i + iHashCode) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        Guild guild = this.serializedSourceGuild;
        int iHashCode2 = (i2 + (guild != null ? guild.hashCode() : 0)) * 31;
        String str = this.createdAt;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.updatedAt;
        int iHashCode4 = (((iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.usageCount) * 31;
        String str3 = this.code;
        int iHashCode5 = (iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.name;
        int iHashCode6 = (iHashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.description;
        return iHashCode6 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelGuildTemplate(creatorId=");
        sbU.append(this.creatorId);
        sbU.append(", creator=");
        sbU.append(this.creator);
        sbU.append(", sourceGuildId=");
        sbU.append(this.sourceGuildId);
        sbU.append(", serializedSourceGuild=");
        sbU.append(this.serializedSourceGuild);
        sbU.append(", createdAt=");
        sbU.append(this.createdAt);
        sbU.append(", updatedAt=");
        sbU.append(this.updatedAt);
        sbU.append(", usageCount=");
        sbU.append(this.usageCount);
        sbU.append(", code=");
        sbU.append(this.code);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", description=");
        return outline.J(sbU, this.description, ")");
    }
}
