package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackSmsMessageStatusChanged.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSmsMessageStatusChanged implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.messageStatus, trackSmsMessageStatusChanged.messageStatus) && C12238m.areEqual(this.phoneNumber, trackSmsMessageStatusChanged.phoneNumber) && C12238m.areEqual(this.carrierName, trackSmsMessageStatusChanged.carrierName) && C12238m.areEqual(this.messageId, trackSmsMessageStatusChanged.messageId) && C12238m.areEqual(this.accountId, trackSmsMessageStatusChanged.accountId) && C12238m.areEqual(this.errorCode, trackSmsMessageStatusChanged.errorCode) && C12238m.areEqual(this.phoneCountry, trackSmsMessageStatusChanged.phoneCountry);
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
        StringBuilder sbM833U = C1643a.m833U("TrackSmsMessageStatusChanged(messageStatus=");
        sbM833U.append(this.messageStatus);
        sbM833U.append(", phoneNumber=");
        sbM833U.append(this.phoneNumber);
        sbM833U.append(", carrierName=");
        sbM833U.append(this.carrierName);
        sbM833U.append(", messageId=");
        sbM833U.append(this.messageId);
        sbM833U.append(", accountId=");
        sbM833U.append(this.accountId);
        sbM833U.append(", errorCode=");
        sbM833U.append(this.errorCode);
        sbM833U.append(", phoneCountry=");
        return C1643a.m817E(sbM833U, this.phoneCountry, ")");
    }
}
