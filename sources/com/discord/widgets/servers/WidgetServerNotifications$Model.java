package com.discord.widgets.servers;

import b.d.b.a.a;
import com.discord.api.guild.preview.GuildPreview;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuildProfiles$GuildProfileData;
import com.discord.utilities.features.GrowthTeamFeatures;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerNotifications.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetServerNotifications$Model {
    public static final WidgetServerNotifications$Model$Companion Companion = new WidgetServerNotifications$Model$Companion(null);
    private final Integer approximateMemberCount;
    private final Guild guild;
    private final StoreGuildProfiles$GuildProfileData guildProfile;
    private final ModelNotificationSettings guildSettings;
    private final boolean highlightsEnabled;
    private final boolean isAboveHighlightsSize;
    private final boolean isAboveNotifyAllSize;
    private final int notificationsSetting;

    public WidgetServerNotifications$Model(Guild guild, ModelNotificationSettings modelNotificationSettings, StoreGuildProfiles$GuildProfileData storeGuildProfiles$GuildProfileData) {
        GuildPreview data;
        m.checkNotNullParameter(guild, "guild");
        m.checkNotNullParameter(modelNotificationSettings, "guildSettings");
        this.guild = guild;
        this.guildSettings = modelNotificationSettings;
        this.guildProfile = storeGuildProfiles$GuildProfileData;
        this.notificationsSetting = modelNotificationSettings.getMessageNotifications() != ModelNotificationSettings.FREQUENCY_UNSET ? modelNotificationSettings.getMessageNotifications() : guild.getDefaultMessageNotifications();
        Integer approximateMemberCount = (storeGuildProfiles$GuildProfileData == null || (data = storeGuildProfiles$GuildProfileData.getData()) == null) ? null : data.getApproximateMemberCount();
        this.approximateMemberCount = approximateMemberCount;
        this.isAboveNotifyAllSize = approximateMemberCount != null && approximateMemberCount.intValue() > 2500;
        boolean zIsHighlightsSettingsEnabled = GrowthTeamFeatures.INSTANCE.isHighlightsSettingsEnabled();
        this.highlightsEnabled = zIsHighlightsSettingsEnabled;
        this.isAboveHighlightsSize = zIsHighlightsSettingsEnabled && approximateMemberCount != null && approximateMemberCount.intValue() > 2500;
    }

    public static /* synthetic */ WidgetServerNotifications$Model copy$default(WidgetServerNotifications$Model widgetServerNotifications$Model, Guild guild, ModelNotificationSettings modelNotificationSettings, StoreGuildProfiles$GuildProfileData storeGuildProfiles$GuildProfileData, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = widgetServerNotifications$Model.guild;
        }
        if ((i & 2) != 0) {
            modelNotificationSettings = widgetServerNotifications$Model.guildSettings;
        }
        if ((i & 4) != 0) {
            storeGuildProfiles$GuildProfileData = widgetServerNotifications$Model.guildProfile;
        }
        return widgetServerNotifications$Model.copy(guild, modelNotificationSettings, storeGuildProfiles$GuildProfileData);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ModelNotificationSettings getGuildSettings() {
        return this.guildSettings;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final StoreGuildProfiles$GuildProfileData getGuildProfile() {
        return this.guildProfile;
    }

    public final WidgetServerNotifications$Model copy(Guild guild, ModelNotificationSettings guildSettings, StoreGuildProfiles$GuildProfileData guildProfile) {
        m.checkNotNullParameter(guild, "guild");
        m.checkNotNullParameter(guildSettings, "guildSettings");
        return new WidgetServerNotifications$Model(guild, guildSettings, guildProfile);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetServerNotifications$Model)) {
            return false;
        }
        WidgetServerNotifications$Model widgetServerNotifications$Model = (WidgetServerNotifications$Model) other;
        return m.areEqual(this.guild, widgetServerNotifications$Model.guild) && m.areEqual(this.guildSettings, widgetServerNotifications$Model.guildSettings) && m.areEqual(this.guildProfile, widgetServerNotifications$Model.guildProfile);
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final StoreGuildProfiles$GuildProfileData getGuildProfile() {
        return this.guildProfile;
    }

    public final ModelNotificationSettings getGuildSettings() {
        return this.guildSettings;
    }

    public final boolean getHighlightsEnabled() {
        return this.highlightsEnabled;
    }

    public final int getNotificationsSetting() {
        return this.notificationsSetting;
    }

    public int hashCode() {
        Guild guild = this.guild;
        int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
        ModelNotificationSettings modelNotificationSettings = this.guildSettings;
        int iHashCode2 = (iHashCode + (modelNotificationSettings != null ? modelNotificationSettings.hashCode() : 0)) * 31;
        StoreGuildProfiles$GuildProfileData storeGuildProfiles$GuildProfileData = this.guildProfile;
        return iHashCode2 + (storeGuildProfiles$GuildProfileData != null ? storeGuildProfiles$GuildProfileData.hashCode() : 0);
    }

    /* JADX INFO: renamed from: isAboveHighlightsSize, reason: from getter */
    public final boolean getIsAboveHighlightsSize() {
        return this.isAboveHighlightsSize;
    }

    /* JADX INFO: renamed from: isAboveNotifyAllSize, reason: from getter */
    public final boolean getIsAboveNotifyAllSize() {
        return this.isAboveNotifyAllSize;
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(guild=");
        sbU.append(this.guild);
        sbU.append(", guildSettings=");
        sbU.append(this.guildSettings);
        sbU.append(", guildProfile=");
        sbU.append(this.guildProfile);
        sbU.append(")");
        return sbU.toString();
    }
}
