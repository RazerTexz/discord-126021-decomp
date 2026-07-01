package com.discord.widgets.servers.community;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.guild.GuildFeature;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig {
    private final boolean defaultMessageNotifications;
    private final boolean everyonePermissions;
    private final boolean explicitContentFilter;
    private final List<GuildFeature> features;
    private final Guild guild;
    private final boolean isPrivacyPolicyAccepted;
    private final Map<Long, GuildRole> roles;
    private final Channel rulesChannel;
    private final Long rulesChannelId;
    private final Channel updatesChannel;
    private final Long updatesChannelId;
    private final boolean verificationLevel;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig(Channel channel, Channel channel2, Long l, Long l2, boolean z2, boolean z3, boolean z4, boolean z5, Guild guild, boolean z6, List<? extends GuildFeature> list, Map<Long, GuildRole> map) {
        m.checkNotNullParameter(list, "features");
        this.rulesChannel = channel;
        this.updatesChannel = channel2;
        this.rulesChannelId = l;
        this.updatesChannelId = l2;
        this.isPrivacyPolicyAccepted = z2;
        this.defaultMessageNotifications = z3;
        this.verificationLevel = z4;
        this.explicitContentFilter = z5;
        this.guild = guild;
        this.everyonePermissions = z6;
        this.features = list;
        this.roles = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig copy$default(WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig, Channel channel, Channel channel2, Long l, Long l2, boolean z2, boolean z3, boolean z4, boolean z5, Guild guild, boolean z6, List list, Map map, int i, Object obj) {
        return widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig.copy((i & 1) != 0 ? widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig.rulesChannel : channel, (i & 2) != 0 ? widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig.updatesChannel : channel2, (i & 4) != 0 ? widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig.rulesChannelId : l, (i & 8) != 0 ? widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig.updatesChannelId : l2, (i & 16) != 0 ? widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig.isPrivacyPolicyAccepted : z2, (i & 32) != 0 ? widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig.defaultMessageNotifications : z3, (i & 64) != 0 ? widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig.verificationLevel : z4, (i & 128) != 0 ? widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig.explicitContentFilter : z5, (i & 256) != 0 ? widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig.guild : guild, (i & 512) != 0 ? widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig.everyonePermissions : z6, (i & 1024) != 0 ? widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig.features : list, (i & 2048) != 0 ? widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig.roles : map);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getRulesChannel() {
        return this.rulesChannel;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getEveryonePermissions() {
        return this.everyonePermissions;
    }

    public final List<GuildFeature> component11() {
        return this.features;
    }

    public final Map<Long, GuildRole> component12() {
        return this.roles;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Channel getUpdatesChannel() {
        return this.updatesChannel;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Long getRulesChannelId() {
        return this.rulesChannelId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Long getUpdatesChannelId() {
        return this.updatesChannelId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsPrivacyPolicyAccepted() {
        return this.isPrivacyPolicyAccepted;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getDefaultMessageNotifications() {
        return this.defaultMessageNotifications;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getVerificationLevel() {
        return this.verificationLevel;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getExplicitContentFilter() {
        return this.explicitContentFilter;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    public final WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig copy(Channel rulesChannel, Channel updatesChannel, Long rulesChannelId, Long updatesChannelId, boolean isPrivacyPolicyAccepted, boolean defaultMessageNotifications, boolean verificationLevel, boolean explicitContentFilter, Guild guild, boolean everyonePermissions, List<? extends GuildFeature> features, Map<Long, GuildRole> roles) {
        m.checkNotNullParameter(features, "features");
        return new WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig(rulesChannel, updatesChannel, rulesChannelId, updatesChannelId, isPrivacyPolicyAccepted, defaultMessageNotifications, verificationLevel, explicitContentFilter, guild, everyonePermissions, features, roles);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig)) {
            return false;
        }
        WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig = (WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig) other;
        return m.areEqual(this.rulesChannel, widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig.rulesChannel) && m.areEqual(this.updatesChannel, widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig.updatesChannel) && m.areEqual(this.rulesChannelId, widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig.rulesChannelId) && m.areEqual(this.updatesChannelId, widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig.updatesChannelId) && this.isPrivacyPolicyAccepted == widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig.isPrivacyPolicyAccepted && this.defaultMessageNotifications == widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig.defaultMessageNotifications && this.verificationLevel == widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig.verificationLevel && this.explicitContentFilter == widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig.explicitContentFilter && m.areEqual(this.guild, widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig.guild) && this.everyonePermissions == widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig.everyonePermissions && m.areEqual(this.features, widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig.features) && m.areEqual(this.roles, widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig.roles);
    }

    public final boolean getDefaultMessageNotifications() {
        return this.defaultMessageNotifications;
    }

    public final boolean getEveryonePermissions() {
        return this.everyonePermissions;
    }

    public final boolean getExplicitContentFilter() {
        return this.explicitContentFilter;
    }

    public final List<GuildFeature> getFeatures() {
        return this.features;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final Map<Long, GuildRole> getRoles() {
        return this.roles;
    }

    public final Channel getRulesChannel() {
        return this.rulesChannel;
    }

    public final Long getRulesChannelId() {
        return this.rulesChannelId;
    }

    public final Channel getUpdatesChannel() {
        return this.updatesChannel;
    }

    public final Long getUpdatesChannelId() {
        return this.updatesChannelId;
    }

    public final boolean getVerificationLevel() {
        return this.verificationLevel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        Channel channel = this.rulesChannel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        Channel channel2 = this.updatesChannel;
        int iHashCode2 = (iHashCode + (channel2 != null ? channel2.hashCode() : 0)) * 31;
        Long l = this.rulesChannelId;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.updatesChannelId;
        int iHashCode4 = (iHashCode3 + (l2 != null ? l2.hashCode() : 0)) * 31;
        boolean z2 = this.isPrivacyPolicyAccepted;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode4 + r2) * 31;
        boolean z3 = this.defaultMessageNotifications;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i2 = (i + r3) * 31;
        boolean z4 = this.verificationLevel;
        ?? r4 = z4;
        if (z4) {
            r4 = 1;
        }
        int i3 = (i2 + r4) * 31;
        boolean z5 = this.explicitContentFilter;
        ?? r5 = z5;
        if (z5) {
            r5 = 1;
        }
        int i4 = (i3 + r5) * 31;
        Guild guild = this.guild;
        int iHashCode5 = (i4 + (guild != null ? guild.hashCode() : 0)) * 31;
        boolean z6 = this.everyonePermissions;
        int i5 = (iHashCode5 + (z6 ? 1 : z6)) * 31;
        List<GuildFeature> list = this.features;
        int iHashCode6 = (i5 + (list != null ? list.hashCode() : 0)) * 31;
        Map<Long, GuildRole> map = this.roles;
        return iHashCode6 + (map != null ? map.hashCode() : 0);
    }

    public final boolean isPrivacyPolicyAccepted() {
        return this.isPrivacyPolicyAccepted;
    }

    public String toString() {
        StringBuilder sbU = a.U("CommunityGuildConfig(rulesChannel=");
        sbU.append(this.rulesChannel);
        sbU.append(", updatesChannel=");
        sbU.append(this.updatesChannel);
        sbU.append(", rulesChannelId=");
        sbU.append(this.rulesChannelId);
        sbU.append(", updatesChannelId=");
        sbU.append(this.updatesChannelId);
        sbU.append(", isPrivacyPolicyAccepted=");
        sbU.append(this.isPrivacyPolicyAccepted);
        sbU.append(", defaultMessageNotifications=");
        sbU.append(this.defaultMessageNotifications);
        sbU.append(", verificationLevel=");
        sbU.append(this.verificationLevel);
        sbU.append(", explicitContentFilter=");
        sbU.append(this.explicitContentFilter);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(", everyonePermissions=");
        sbU.append(this.everyonePermissions);
        sbU.append(", features=");
        sbU.append(this.features);
        sbU.append(", roles=");
        return a.M(sbU, this.roles, ")");
    }

    public /* synthetic */ WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig(Channel channel, Channel channel2, Long l, Long l2, boolean z2, boolean z3, boolean z4, boolean z5, Guild guild, boolean z6, List list, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(channel, channel2, l, l2, z2, z3, z4, z5, guild, z6, (i & 1024) != 0 ? new ArrayList() : list, map);
    }
}
