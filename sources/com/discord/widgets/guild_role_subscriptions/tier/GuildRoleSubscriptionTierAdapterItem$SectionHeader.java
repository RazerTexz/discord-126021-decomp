package com.discord.widgets.guild_role_subscriptions.tier;

import androidx.annotation.PluralsRes;
import androidx.annotation.StringRes;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildRoleSubscriptionTierAdapterItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildRoleSubscriptionTierAdapterItem$SectionHeader extends GuildRoleSubscriptionTierAdapterItem {
    private final Integer formatArgument;
    private final String key;
    private final Integer titlePluralResId;
    private final Integer titleResId;

    public GuildRoleSubscriptionTierAdapterItem$SectionHeader(@StringRes Integer num, @PluralsRes Integer num2, Integer num3) {
        super(null);
        this.titleResId = num;
        this.titlePluralResId = num2;
        this.formatArgument = num3;
        StringBuilder sb = new StringBuilder();
        sb.append(num2);
        sb.append(num);
        this.key = sb.toString();
    }

    public static /* synthetic */ GuildRoleSubscriptionTierAdapterItem$SectionHeader copy$default(GuildRoleSubscriptionTierAdapterItem$SectionHeader guildRoleSubscriptionTierAdapterItem$SectionHeader, Integer num, Integer num2, Integer num3, int i, Object obj) {
        if ((i & 1) != 0) {
            num = guildRoleSubscriptionTierAdapterItem$SectionHeader.titleResId;
        }
        if ((i & 2) != 0) {
            num2 = guildRoleSubscriptionTierAdapterItem$SectionHeader.titlePluralResId;
        }
        if ((i & 4) != 0) {
            num3 = guildRoleSubscriptionTierAdapterItem$SectionHeader.formatArgument;
        }
        return guildRoleSubscriptionTierAdapterItem$SectionHeader.copy(num, num2, num3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getTitleResId() {
        return this.titleResId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getTitlePluralResId() {
        return this.titlePluralResId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getFormatArgument() {
        return this.formatArgument;
    }

    public final GuildRoleSubscriptionTierAdapterItem$SectionHeader copy(@StringRes Integer titleResId, @PluralsRes Integer titlePluralResId, Integer formatArgument) {
        return new GuildRoleSubscriptionTierAdapterItem$SectionHeader(titleResId, titlePluralResId, formatArgument);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildRoleSubscriptionTierAdapterItem$SectionHeader)) {
            return false;
        }
        GuildRoleSubscriptionTierAdapterItem$SectionHeader guildRoleSubscriptionTierAdapterItem$SectionHeader = (GuildRoleSubscriptionTierAdapterItem$SectionHeader) other;
        return m.areEqual(this.titleResId, guildRoleSubscriptionTierAdapterItem$SectionHeader.titleResId) && m.areEqual(this.titlePluralResId, guildRoleSubscriptionTierAdapterItem$SectionHeader.titlePluralResId) && m.areEqual(this.formatArgument, guildRoleSubscriptionTierAdapterItem$SectionHeader.formatArgument);
    }

    public final Integer getFormatArgument() {
        return this.formatArgument;
    }

    @Override // com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final Integer getTitlePluralResId() {
        return this.titlePluralResId;
    }

    public final Integer getTitleResId() {
        return this.titleResId;
    }

    public int hashCode() {
        Integer num = this.titleResId;
        int iHashCode = (num != null ? num.hashCode() : 0) * 31;
        Integer num2 = this.titlePluralResId;
        int iHashCode2 = (iHashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.formatArgument;
        return iHashCode2 + (num3 != null ? num3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("SectionHeader(titleResId=");
        sbU.append(this.titleResId);
        sbU.append(", titlePluralResId=");
        sbU.append(this.titlePluralResId);
        sbU.append(", formatArgument=");
        return a.F(sbU, this.formatArgument, ")");
    }
}
