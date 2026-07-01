package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackStreamWarningTriggered.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackStreamWarningTriggered implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence noticeType = null;
    private final Long streamerUserId = null;
    private final Long streamChannelId = null;
    private final CharSequence streamRegion = null;
    private final CharSequence guildRegion = null;
    private final Boolean videoEnabled = null;
    private final CharSequence applicationName = null;
    private final Long applicationId = null;
    private final CharSequence videoLayout = null;
    private final CharSequence mediaSessionId = null;
    private final transient String analyticsSchemaTypeName = "stream_warning_triggered";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackStreamWarningTriggered)) {
            return false;
        }
        TrackStreamWarningTriggered trackStreamWarningTriggered = (TrackStreamWarningTriggered) other;
        return m.areEqual(this.noticeType, trackStreamWarningTriggered.noticeType) && m.areEqual(this.streamerUserId, trackStreamWarningTriggered.streamerUserId) && m.areEqual(this.streamChannelId, trackStreamWarningTriggered.streamChannelId) && m.areEqual(this.streamRegion, trackStreamWarningTriggered.streamRegion) && m.areEqual(this.guildRegion, trackStreamWarningTriggered.guildRegion) && m.areEqual(this.videoEnabled, trackStreamWarningTriggered.videoEnabled) && m.areEqual(this.applicationName, trackStreamWarningTriggered.applicationName) && m.areEqual(this.applicationId, trackStreamWarningTriggered.applicationId) && m.areEqual(this.videoLayout, trackStreamWarningTriggered.videoLayout) && m.areEqual(this.mediaSessionId, trackStreamWarningTriggered.mediaSessionId);
    }

    public int hashCode() {
        CharSequence charSequence = this.noticeType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.streamerUserId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.streamChannelId;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.streamRegion;
        int iHashCode4 = (iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.guildRegion;
        int iHashCode5 = (iHashCode4 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Boolean bool = this.videoEnabled;
        int iHashCode6 = (iHashCode5 + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.applicationName;
        int iHashCode7 = (iHashCode6 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l3 = this.applicationId;
        int iHashCode8 = (iHashCode7 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.videoLayout;
        int iHashCode9 = (iHashCode8 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.mediaSessionId;
        return iHashCode9 + (charSequence6 != null ? charSequence6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackStreamWarningTriggered(noticeType=");
        sbU.append(this.noticeType);
        sbU.append(", streamerUserId=");
        sbU.append(this.streamerUserId);
        sbU.append(", streamChannelId=");
        sbU.append(this.streamChannelId);
        sbU.append(", streamRegion=");
        sbU.append(this.streamRegion);
        sbU.append(", guildRegion=");
        sbU.append(this.guildRegion);
        sbU.append(", videoEnabled=");
        sbU.append(this.videoEnabled);
        sbU.append(", applicationName=");
        sbU.append(this.applicationName);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", videoLayout=");
        sbU.append(this.videoLayout);
        sbU.append(", mediaSessionId=");
        return a.E(sbU, this.mediaSessionId, ")");
    }
}
