package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackSentMissedMessageEmail.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSentMissedMessageEmail implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence trackingPixelUuid = null;
    private final CharSequence subjectClassification = null;
    private final Long totalGuildsMissed = null;
    private final Long totalChannelsMissed = null;
    private final Long totalDmsMissed = null;
    private final Long totalApproximateMessagesMissed = null;
    private final Long lastAckAt = null;
    private final Boolean didSend = null;
    private final transient String analyticsSchemaTypeName = "sent_missed_message_email";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSentMissedMessageEmail)) {
            return false;
        }
        TrackSentMissedMessageEmail trackSentMissedMessageEmail = (TrackSentMissedMessageEmail) other;
        return m.areEqual(this.trackingPixelUuid, trackSentMissedMessageEmail.trackingPixelUuid) && m.areEqual(this.subjectClassification, trackSentMissedMessageEmail.subjectClassification) && m.areEqual(this.totalGuildsMissed, trackSentMissedMessageEmail.totalGuildsMissed) && m.areEqual(this.totalChannelsMissed, trackSentMissedMessageEmail.totalChannelsMissed) && m.areEqual(this.totalDmsMissed, trackSentMissedMessageEmail.totalDmsMissed) && m.areEqual(this.totalApproximateMessagesMissed, trackSentMissedMessageEmail.totalApproximateMessagesMissed) && m.areEqual(this.lastAckAt, trackSentMissedMessageEmail.lastAckAt) && m.areEqual(this.didSend, trackSentMissedMessageEmail.didSend);
    }

    public int hashCode() {
        CharSequence charSequence = this.trackingPixelUuid;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.subjectClassification;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.totalGuildsMissed;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.totalChannelsMissed;
        int iHashCode4 = (iHashCode3 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.totalDmsMissed;
        int iHashCode5 = (iHashCode4 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.totalApproximateMessagesMissed;
        int iHashCode6 = (iHashCode5 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.lastAckAt;
        int iHashCode7 = (iHashCode6 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Boolean bool = this.didSend;
        return iHashCode7 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackSentMissedMessageEmail(trackingPixelUuid=");
        sbU.append(this.trackingPixelUuid);
        sbU.append(", subjectClassification=");
        sbU.append(this.subjectClassification);
        sbU.append(", totalGuildsMissed=");
        sbU.append(this.totalGuildsMissed);
        sbU.append(", totalChannelsMissed=");
        sbU.append(this.totalChannelsMissed);
        sbU.append(", totalDmsMissed=");
        sbU.append(this.totalDmsMissed);
        sbU.append(", totalApproximateMessagesMissed=");
        sbU.append(this.totalApproximateMessagesMissed);
        sbU.append(", lastAckAt=");
        sbU.append(this.lastAckAt);
        sbU.append(", didSend=");
        return a.D(sbU, this.didSend, ")");
    }
}
