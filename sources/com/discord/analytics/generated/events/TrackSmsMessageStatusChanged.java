package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackSmsMessageStatusChanged.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSmsMessageStatusChanged implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence messageStatus = null;
    private final CharSequence phoneNumber = null;
    private final CharSequence carrierName = null;
    private final CharSequence messageId = null;
    private final CharSequence accountId = null;
    private final Long errorCode = null;
    private final CharSequence phoneCountry = null;
    private final transient String analyticsSchemaTypeName = "sms_message_status_changed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSmsMessageStatusChanged)) {
            return false;
        }
        TrackSmsMessageStatusChanged trackSmsMessageStatusChanged = (TrackSmsMessageStatusChanged) other;
        return Intrinsics3.areEqual(this.messageStatus, trackSmsMessageStatusChanged.messageStatus) && Intrinsics3.areEqual(this.phoneNumber, trackSmsMessageStatusChanged.phoneNumber) && Intrinsics3.areEqual(this.carrierName, trackSmsMessageStatusChanged.carrierName) && Intrinsics3.areEqual(this.messageId, trackSmsMessageStatusChanged.messageId) && Intrinsics3.areEqual(this.accountId, trackSmsMessageStatusChanged.accountId) && Intrinsics3.areEqual(this.errorCode, trackSmsMessageStatusChanged.errorCode) && Intrinsics3.areEqual(this.phoneCountry, trackSmsMessageStatusChanged.phoneCountry);
    }

    public int hashCode() {
        CharSequence charSequence = this.messageStatus;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.phoneNumber;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.carrierName;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.messageId;
        int iHashCode4 = (iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.accountId;
        int iHashCode5 = (iHashCode4 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        Long l = this.errorCode;
        int iHashCode6 = (iHashCode5 + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.phoneCountry;
        return iHashCode6 + (charSequence6 != null ? charSequence6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackSmsMessageStatusChanged(messageStatus=");
        sbU.append(this.messageStatus);
        sbU.append(", phoneNumber=");
        sbU.append(this.phoneNumber);
        sbU.append(", carrierName=");
        sbU.append(this.carrierName);
        sbU.append(", messageId=");
        sbU.append(this.messageId);
        sbU.append(", accountId=");
        sbU.append(this.accountId);
        sbU.append(", errorCode=");
        sbU.append(this.errorCode);
        sbU.append(", phoneCountry=");
        return outline.E(sbU, this.phoneCountry, ")");
    }
}
