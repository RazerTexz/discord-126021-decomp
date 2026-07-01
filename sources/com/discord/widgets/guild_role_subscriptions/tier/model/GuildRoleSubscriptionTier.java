package com.discord.widgets.guild_role_subscriptions.tier.model;

import b.d.b.a.a;
import com.discord.api.guildrolesubscription.SubscriptionTrialInterval;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildRoleSubscriptionTier.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildRoleSubscriptionTier {
    private final Integer activeTrialUserLimit;
    private final Long applicationId;
    private final Boolean canAccessAllChannels;
    private final List<Benefit$ChannelBenefit> channelBenefits;
    private final String description;
    private final GuildRole guildRole;
    private final String image;
    private final Long imageAssetId;
    private final List<Benefit$IntangibleBenefit> intangibleBenefits;
    private final Boolean isPublished;
    private final Integer memberColor;
    private final String memberIcon;
    private final String name;
    private final Integer priceTier;
    private final SubscriptionTrialInterval trialInterval;

    public GuildRoleSubscriptionTier() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
    }

    public GuildRoleSubscriptionTier(String str, Long l, Integer num, Integer num2, String str2, GuildRole guildRole, String str3, Long l2, String str4, Boolean bool, Boolean bool2, List<Benefit$ChannelBenefit> list, List<Benefit$IntangibleBenefit> list2, SubscriptionTrialInterval subscriptionTrialInterval, Integer num3) {
        m.checkNotNullParameter(list, "channelBenefits");
        m.checkNotNullParameter(list2, "intangibleBenefits");
        this.name = str;
        this.applicationId = l;
        this.priceTier = num;
        this.memberColor = num2;
        this.memberIcon = str2;
        this.guildRole = guildRole;
        this.image = str3;
        this.imageAssetId = l2;
        this.description = str4;
        this.isPublished = bool;
        this.canAccessAllChannels = bool2;
        this.channelBenefits = list;
        this.intangibleBenefits = list2;
        this.trialInterval = subscriptionTrialInterval;
        this.activeTrialUserLimit = num3;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    private final Boolean getCanAccessAllChannels() {
        return this.canAccessAllChannels;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuildRoleSubscriptionTier copy$default(GuildRoleSubscriptionTier guildRoleSubscriptionTier, String str, Long l, Integer num, Integer num2, String str2, GuildRole guildRole, String str3, Long l2, String str4, Boolean bool, Boolean bool2, List list, List list2, SubscriptionTrialInterval subscriptionTrialInterval, Integer num3, int i, Object obj) {
        return guildRoleSubscriptionTier.copy((i & 1) != 0 ? guildRoleSubscriptionTier.name : str, (i & 2) != 0 ? guildRoleSubscriptionTier.applicationId : l, (i & 4) != 0 ? guildRoleSubscriptionTier.priceTier : num, (i & 8) != 0 ? guildRoleSubscriptionTier.memberColor : num2, (i & 16) != 0 ? guildRoleSubscriptionTier.memberIcon : str2, (i & 32) != 0 ? guildRoleSubscriptionTier.guildRole : guildRole, (i & 64) != 0 ? guildRoleSubscriptionTier.image : str3, (i & 128) != 0 ? guildRoleSubscriptionTier.imageAssetId : l2, (i & 256) != 0 ? guildRoleSubscriptionTier.description : str4, (i & 512) != 0 ? guildRoleSubscriptionTier.isPublished : bool, (i & 1024) != 0 ? guildRoleSubscriptionTier.canAccessAllChannels : bool2, (i & 2048) != 0 ? guildRoleSubscriptionTier.channelBenefits : list, (i & 4096) != 0 ? guildRoleSubscriptionTier.intangibleBenefits : list2, (i & 8192) != 0 ? guildRoleSubscriptionTier.trialInterval : subscriptionTrialInterval, (i & 16384) != 0 ? guildRoleSubscriptionTier.activeTrialUserLimit : num3);
    }

    public final boolean canAccessAllChannelsOrDefault(Boolean isFullServerGating) {
        Boolean bool = Boolean.TRUE;
        return m.areEqual(isFullServerGating, bool) && (m.areEqual(this.canAccessAllChannels, bool) || this.canAccessAllChannels == null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Boolean getIsPublished() {
        return this.isPublished;
    }

    public final List<Benefit$ChannelBenefit> component12() {
        return this.channelBenefits;
    }

    public final List<Benefit$IntangibleBenefit> component13() {
        return this.intangibleBenefits;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final SubscriptionTrialInterval getTrialInterval() {
        return this.trialInterval;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final Integer getActiveTrialUserLimit() {
        return this.activeTrialUserLimit;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getApplicationId() {
        return this.applicationId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getPriceTier() {
        return this.priceTier;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getMemberColor() {
        return this.memberColor;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getMemberIcon() {
        return this.memberIcon;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final GuildRole getGuildRole() {
        return this.guildRole;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Long getImageAssetId() {
        return this.imageAssetId;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final GuildRoleSubscriptionTier copy(String name, Long applicationId, Integer priceTier, Integer memberColor, String memberIcon, GuildRole guildRole, String image, Long imageAssetId, String description, Boolean isPublished, Boolean canAccessAllChannels, List<Benefit$ChannelBenefit> channelBenefits, List<Benefit$IntangibleBenefit> intangibleBenefits, SubscriptionTrialInterval trialInterval, Integer activeTrialUserLimit) {
        m.checkNotNullParameter(channelBenefits, "channelBenefits");
        m.checkNotNullParameter(intangibleBenefits, "intangibleBenefits");
        return new GuildRoleSubscriptionTier(name, applicationId, priceTier, memberColor, memberIcon, guildRole, image, imageAssetId, description, isPublished, canAccessAllChannels, channelBenefits, intangibleBenefits, trialInterval, activeTrialUserLimit);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildRoleSubscriptionTier)) {
            return false;
        }
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = (GuildRoleSubscriptionTier) other;
        return m.areEqual(this.name, guildRoleSubscriptionTier.name) && m.areEqual(this.applicationId, guildRoleSubscriptionTier.applicationId) && m.areEqual(this.priceTier, guildRoleSubscriptionTier.priceTier) && m.areEqual(this.memberColor, guildRoleSubscriptionTier.memberColor) && m.areEqual(this.memberIcon, guildRoleSubscriptionTier.memberIcon) && m.areEqual(this.guildRole, guildRoleSubscriptionTier.guildRole) && m.areEqual(this.image, guildRoleSubscriptionTier.image) && m.areEqual(this.imageAssetId, guildRoleSubscriptionTier.imageAssetId) && m.areEqual(this.description, guildRoleSubscriptionTier.description) && m.areEqual(this.isPublished, guildRoleSubscriptionTier.isPublished) && m.areEqual(this.canAccessAllChannels, guildRoleSubscriptionTier.canAccessAllChannels) && m.areEqual(this.channelBenefits, guildRoleSubscriptionTier.channelBenefits) && m.areEqual(this.intangibleBenefits, guildRoleSubscriptionTier.intangibleBenefits) && m.areEqual(this.trialInterval, guildRoleSubscriptionTier.trialInterval) && m.areEqual(this.activeTrialUserLimit, guildRoleSubscriptionTier.activeTrialUserLimit);
    }

    public final Integer getActiveTrialUserLimit() {
        return this.activeTrialUserLimit;
    }

    public final Long getApplicationId() {
        return this.applicationId;
    }

    public final List<Benefit$ChannelBenefit> getChannelBenefits() {
        return this.channelBenefits;
    }

    public final String getDescription() {
        return this.description;
    }

    public final GuildRole getGuildRole() {
        return this.guildRole;
    }

    public final String getImage() {
        return this.image;
    }

    public final Long getImageAssetId() {
        return this.imageAssetId;
    }

    public final List<Benefit$IntangibleBenefit> getIntangibleBenefits() {
        return this.intangibleBenefits;
    }

    public final Integer getMemberColor() {
        return this.memberColor;
    }

    public final String getMemberIcon() {
        return this.memberIcon;
    }

    public final String getName() {
        return this.name;
    }

    public final Integer getPriceTier() {
        return this.priceTier;
    }

    public final SubscriptionTrialInterval getTrialInterval() {
        return this.trialInterval;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Long l = this.applicationId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Integer num = this.priceTier;
        int iHashCode3 = (iHashCode2 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.memberColor;
        int iHashCode4 = (iHashCode3 + (num2 != null ? num2.hashCode() : 0)) * 31;
        String str2 = this.memberIcon;
        int iHashCode5 = (iHashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        GuildRole guildRole = this.guildRole;
        int iHashCode6 = (iHashCode5 + (guildRole != null ? guildRole.hashCode() : 0)) * 31;
        String str3 = this.image;
        int iHashCode7 = (iHashCode6 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Long l2 = this.imageAssetId;
        int iHashCode8 = (iHashCode7 + (l2 != null ? l2.hashCode() : 0)) * 31;
        String str4 = this.description;
        int iHashCode9 = (iHashCode8 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Boolean bool = this.isPublished;
        int iHashCode10 = (iHashCode9 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.canAccessAllChannels;
        int iHashCode11 = (iHashCode10 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        List<Benefit$ChannelBenefit> list = this.channelBenefits;
        int iHashCode12 = (iHashCode11 + (list != null ? list.hashCode() : 0)) * 31;
        List<Benefit$IntangibleBenefit> list2 = this.intangibleBenefits;
        int iHashCode13 = (iHashCode12 + (list2 != null ? list2.hashCode() : 0)) * 31;
        SubscriptionTrialInterval subscriptionTrialInterval = this.trialInterval;
        int iHashCode14 = (iHashCode13 + (subscriptionTrialInterval != null ? subscriptionTrialInterval.hashCode() : 0)) * 31;
        Integer num3 = this.activeTrialUserLimit;
        return iHashCode14 + (num3 != null ? num3.hashCode() : 0);
    }

    public final Boolean isPublished() {
        return this.isPublished;
    }

    public String toString() {
        StringBuilder sbU = a.U("GuildRoleSubscriptionTier(name=");
        sbU.append(this.name);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", priceTier=");
        sbU.append(this.priceTier);
        sbU.append(", memberColor=");
        sbU.append(this.memberColor);
        sbU.append(", memberIcon=");
        sbU.append(this.memberIcon);
        sbU.append(", guildRole=");
        sbU.append(this.guildRole);
        sbU.append(", image=");
        sbU.append(this.image);
        sbU.append(", imageAssetId=");
        sbU.append(this.imageAssetId);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", isPublished=");
        sbU.append(this.isPublished);
        sbU.append(", canAccessAllChannels=");
        sbU.append(this.canAccessAllChannels);
        sbU.append(", channelBenefits=");
        sbU.append(this.channelBenefits);
        sbU.append(", intangibleBenefits=");
        sbU.append(this.intangibleBenefits);
        sbU.append(", trialInterval=");
        sbU.append(this.trialInterval);
        sbU.append(", activeTrialUserLimit=");
        return a.F(sbU, this.activeTrialUserLimit, ")");
    }

    public /* synthetic */ GuildRoleSubscriptionTier(String str, Long l, Integer num, Integer num2, String str2, GuildRole guildRole, String str3, Long l2, String str4, Boolean bool, Boolean bool2, List list, List list2, SubscriptionTrialInterval subscriptionTrialInterval, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : guildRole, (i & 64) != 0 ? null : str3, (i & 128) != 0 ? null : l2, (i & 256) != 0 ? null : str4, (i & 512) != 0 ? null : bool, (i & 1024) != 0 ? null : bool2, (i & 2048) != 0 ? n.emptyList() : list, (i & 4096) != 0 ? n.emptyList() : list2, (i & 8192) != 0 ? null : subscriptionTrialInterval, (i & 16384) == 0 ? num3 : null);
    }
}
