package com.discord.api.guildrolesubscription;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: GuildRoleSubscriptionBenefit.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildRoleSubscriptionBenefit {
    private final String description;
    private final Long emojiId;
    private final String emojiName;
    private final String name;
    private final Long refId;
    private final GuildRoleSubscriptionBenefitType refType;

    public GuildRoleSubscriptionBenefit(Long l, String str, String str2, GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType, String str3, Long l2) {
        Intrinsics3.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(guildRoleSubscriptionBenefitType, "refType");
        this.emojiId = l;
        this.emojiName = str;
        this.name = str2;
        this.refType = guildRoleSubscriptionBenefitType;
        this.description = str3;
        this.refId = l2;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final Long getEmojiId() {
        return this.emojiId;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getEmojiName() {
        return this.emojiName;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final Long getRefId() {
        return this.refId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildRoleSubscriptionBenefit)) {
            return false;
        }
        GuildRoleSubscriptionBenefit guildRoleSubscriptionBenefit = (GuildRoleSubscriptionBenefit) other;
        return Intrinsics3.areEqual(this.emojiId, guildRoleSubscriptionBenefit.emojiId) && Intrinsics3.areEqual(this.emojiName, guildRoleSubscriptionBenefit.emojiName) && Intrinsics3.areEqual(this.name, guildRoleSubscriptionBenefit.name) && Intrinsics3.areEqual(this.refType, guildRoleSubscriptionBenefit.refType) && Intrinsics3.areEqual(this.description, guildRoleSubscriptionBenefit.description) && Intrinsics3.areEqual(this.refId, guildRoleSubscriptionBenefit.refId);
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final GuildRoleSubscriptionBenefitType getRefType() {
        return this.refType;
    }

    public int hashCode() {
        Long l = this.emojiId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        String str = this.emojiName;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.name;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType = this.refType;
        int iHashCode4 = (iHashCode3 + (guildRoleSubscriptionBenefitType != null ? guildRoleSubscriptionBenefitType.hashCode() : 0)) * 31;
        String str3 = this.description;
        int iHashCode5 = (iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Long l2 = this.refId;
        return iHashCode5 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildRoleSubscriptionBenefit(emojiId=");
        sbU.append(this.emojiId);
        sbU.append(", emojiName=");
        sbU.append(this.emojiName);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", refType=");
        sbU.append(this.refType);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", refId=");
        return outline.G(sbU, this.refId, ")");
    }
}
