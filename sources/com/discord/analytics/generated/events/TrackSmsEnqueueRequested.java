package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackSmsEnqueueRequested.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSmsEnqueueRequested implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence phoneNumber = null;
    private final CharSequence phoneCountry = null;
    private final CharSequence carrierName = null;
    private final CharSequence carrierType = null;
    private final CharSequence source = null;
    private final transient String analyticsSchemaTypeName = "sms_enqueue_requested";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSmsEnqueueRequested)) {
            return false;
        }
        TrackSmsEnqueueRequested trackSmsEnqueueRequested = (TrackSmsEnqueueRequested) other;
        return m.areEqual(this.phoneNumber, trackSmsEnqueueRequested.phoneNumber) && m.areEqual(this.phoneCountry, trackSmsEnqueueRequested.phoneCountry) && m.areEqual(this.carrierName, trackSmsEnqueueRequested.carrierName) && m.areEqual(this.carrierType, trackSmsEnqueueRequested.carrierType) && m.areEqual(this.source, trackSmsEnqueueRequested.source);
    }

    public int hashCode() {
        CharSequence charSequence = this.phoneNumber;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.phoneCountry;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.carrierName;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.carrierType;
        int iHashCode4 = (iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.source;
        return iHashCode4 + (charSequence5 != null ? charSequence5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackSmsEnqueueRequested(phoneNumber=");
        sbU.append(this.phoneNumber);
        sbU.append(", phoneCountry=");
        sbU.append(this.phoneCountry);
        sbU.append(", carrierName=");
        sbU.append(this.carrierName);
        sbU.append(", carrierType=");
        sbU.append(this.carrierType);
        sbU.append(", source=");
        return a.E(sbU, this.source, ")");
    }
}
