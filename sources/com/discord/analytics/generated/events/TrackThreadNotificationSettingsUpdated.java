package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.analytics.generated.traits.TrackThread;
import com.discord.analytics.generated.traits.TrackThreadReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.channelId, trackThreadNotificationSettingsUpdated.channelId) && C12238m.areEqual(this.parentId, trackThreadNotificationSettingsUpdated.parentId) && C12238m.areEqual(this.guildId, trackThreadNotificationSettingsUpdated.guildId) && C12238m.areEqual(this.channelType, trackThreadNotificationSettingsUpdated.channelType) && C12238m.areEqual(this.hasInteractedWithThread, trackThreadNotificationSettingsUpdated.hasInteractedWithThread) && C12238m.areEqual(this.parentIsMuted, trackThreadNotificationSettingsUpdated.parentIsMuted) && C12238m.areEqual(this.oldThreadNotificationSetting, trackThreadNotificationSettingsUpdated.oldThreadNotificationSetting) && C12238m.areEqual(this.newThreadNotificationSetting, trackThreadNotificationSettingsUpdated.newThreadNotificationSetting) && C12238m.areEqual(this.parentNotificationSetting, trackThreadNotificationSettingsUpdated.parentNotificationSetting) && C12238m.areEqual(this.oldThreadIsMuted, trackThreadNotificationSettingsUpdated.oldThreadIsMuted) && C12238m.areEqual(this.newThreadIsMuted, trackThreadNotificationSettingsUpdated.newThreadIsMuted) && C12238m.areEqual(this.oldThreadMutedUntil, trackThreadNotificationSettingsUpdated.oldThreadMutedUntil) && C12238m.areEqual(this.newThreadMutedUntil, trackThreadNotificationSettingsUpdated.newThreadMutedUntil);
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
        StringBuilder sbM833U = C1643a.m833U("TrackThreadNotificationSettingsUpdated(channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", parentId=");
        sbM833U.append(this.parentId);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", channelType=");
        sbM833U.append(this.channelType);
        sbM833U.append(", hasInteractedWithThread=");
        sbM833U.append(this.hasInteractedWithThread);
        sbM833U.append(", parentIsMuted=");
        sbM833U.append(this.parentIsMuted);
        sbM833U.append(", oldThreadNotificationSetting=");
        sbM833U.append(this.oldThreadNotificationSetting);
        sbM833U.append(", newThreadNotificationSetting=");
        sbM833U.append(this.newThreadNotificationSetting);
        sbM833U.append(", parentNotificationSetting=");
        sbM833U.append(this.parentNotificationSetting);
        sbM833U.append(", oldThreadIsMuted=");
        sbM833U.append(this.oldThreadIsMuted);
        sbM833U.append(", newThreadIsMuted=");
        sbM833U.append(this.newThreadIsMuted);
        sbM833U.append(", oldThreadMutedUntil=");
        sbM833U.append(this.oldThreadMutedUntil);
        sbM833U.append(", newThreadMutedUntil=");
        return C1643a.m819G(sbM833U, this.newThreadMutedUntil, ")");
    }
}
