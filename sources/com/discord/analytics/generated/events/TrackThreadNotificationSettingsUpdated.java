package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.analytics.generated.traits.TrackThread;
import com.discord.analytics.generated.traits.TrackThreadReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackThreadNotificationSettingsUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackThreadNotificationSettingsUpdated implements AnalyticsSchema, TrackBaseReceiver, TrackThreadReceiver, TrackLocationMetadataReceiver {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackThread trackThread;
    private final Long channelId = null;
    private final Long parentId = null;
    private final Long guildId = null;
    private final Long channelType = null;
    private final Boolean hasInteractedWithThread = null;
    private final Boolean parentIsMuted = null;
    private final CharSequence oldThreadNotificationSetting = null;
    private final CharSequence newThreadNotificationSetting = null;
    private final CharSequence parentNotificationSetting = null;
    private final Boolean oldThreadIsMuted = null;
    private final Boolean newThreadIsMuted = null;
    private final Long oldThreadMutedUntil = null;
    private final Long newThreadMutedUntil = null;
    private final transient String analyticsSchemaTypeName = "thread_notification_settings_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackThreadNotificationSettingsUpdated)) {
            return false;
        }
        TrackThreadNotificationSettingsUpdated trackThreadNotificationSettingsUpdated = (TrackThreadNotificationSettingsUpdated) other;
        return m.areEqual(this.channelId, trackThreadNotificationSettingsUpdated.channelId) && m.areEqual(this.parentId, trackThreadNotificationSettingsUpdated.parentId) && m.areEqual(this.guildId, trackThreadNotificationSettingsUpdated.guildId) && m.areEqual(this.channelType, trackThreadNotificationSettingsUpdated.channelType) && m.areEqual(this.hasInteractedWithThread, trackThreadNotificationSettingsUpdated.hasInteractedWithThread) && m.areEqual(this.parentIsMuted, trackThreadNotificationSettingsUpdated.parentIsMuted) && m.areEqual(this.oldThreadNotificationSetting, trackThreadNotificationSettingsUpdated.oldThreadNotificationSetting) && m.areEqual(this.newThreadNotificationSetting, trackThreadNotificationSettingsUpdated.newThreadNotificationSetting) && m.areEqual(this.parentNotificationSetting, trackThreadNotificationSettingsUpdated.parentNotificationSetting) && m.areEqual(this.oldThreadIsMuted, trackThreadNotificationSettingsUpdated.oldThreadIsMuted) && m.areEqual(this.newThreadIsMuted, trackThreadNotificationSettingsUpdated.newThreadIsMuted) && m.areEqual(this.oldThreadMutedUntil, trackThreadNotificationSettingsUpdated.oldThreadMutedUntil) && m.areEqual(this.newThreadMutedUntil, trackThreadNotificationSettingsUpdated.newThreadMutedUntil);
    }

    public int hashCode() {
        Long l = this.channelId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.parentId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.guildId;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.channelType;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Boolean bool = this.hasInteractedWithThread;
        int iHashCode5 = (iHashCode4 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.parentIsMuted;
        int iHashCode6 = (iHashCode5 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.oldThreadNotificationSetting;
        int iHashCode7 = (iHashCode6 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.newThreadNotificationSetting;
        int iHashCode8 = (iHashCode7 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.parentNotificationSetting;
        int iHashCode9 = (iHashCode8 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Boolean bool3 = this.oldThreadIsMuted;
        int iHashCode10 = (iHashCode9 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.newThreadIsMuted;
        int iHashCode11 = (iHashCode10 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Long l5 = this.oldThreadMutedUntil;
        int iHashCode12 = (iHashCode11 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.newThreadMutedUntil;
        return iHashCode12 + (l6 != null ? l6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackThreadNotificationSettingsUpdated(channelId=");
        sbU.append(this.channelId);
        sbU.append(", parentId=");
        sbU.append(this.parentId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", channelType=");
        sbU.append(this.channelType);
        sbU.append(", hasInteractedWithThread=");
        sbU.append(this.hasInteractedWithThread);
        sbU.append(", parentIsMuted=");
        sbU.append(this.parentIsMuted);
        sbU.append(", oldThreadNotificationSetting=");
        sbU.append(this.oldThreadNotificationSetting);
        sbU.append(", newThreadNotificationSetting=");
        sbU.append(this.newThreadNotificationSetting);
        sbU.append(", parentNotificationSetting=");
        sbU.append(this.parentNotificationSetting);
        sbU.append(", oldThreadIsMuted=");
        sbU.append(this.oldThreadIsMuted);
        sbU.append(", newThreadIsMuted=");
        sbU.append(this.newThreadIsMuted);
        sbU.append(", oldThreadMutedUntil=");
        sbU.append(this.oldThreadMutedUntil);
        sbU.append(", newThreadMutedUntil=");
        return a.G(sbU, this.newThreadMutedUntil, ")");
    }
}
