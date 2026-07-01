package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackRelationshipSyncFlow.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackRelationshipSyncFlow implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2 {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private final CharSequence flowType = null;
    private final CharSequence fromStep = null;
    private final CharSequence toStep = null;
    private final Boolean skip = null;
    private final Boolean back = null;
    private final Float secondsOnFromStep = null;
    private final Long numContactsFound = null;
    private final Long numContactsAdded = null;
    private final CharSequence mobileContactsPermission = null;
    private final Boolean hasPhoneNumber = null;
    private final transient String analyticsSchemaTypeName = "relationship_sync_flow";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackRelationshipSyncFlow)) {
            return false;
        }
        TrackRelationshipSyncFlow trackRelationshipSyncFlow = (TrackRelationshipSyncFlow) other;
        return Intrinsics3.areEqual(this.flowType, trackRelationshipSyncFlow.flowType) && Intrinsics3.areEqual(this.fromStep, trackRelationshipSyncFlow.fromStep) && Intrinsics3.areEqual(this.toStep, trackRelationshipSyncFlow.toStep) && Intrinsics3.areEqual(this.skip, trackRelationshipSyncFlow.skip) && Intrinsics3.areEqual(this.back, trackRelationshipSyncFlow.back) && Intrinsics3.areEqual(this.secondsOnFromStep, trackRelationshipSyncFlow.secondsOnFromStep) && Intrinsics3.areEqual(this.numContactsFound, trackRelationshipSyncFlow.numContactsFound) && Intrinsics3.areEqual(this.numContactsAdded, trackRelationshipSyncFlow.numContactsAdded) && Intrinsics3.areEqual(this.mobileContactsPermission, trackRelationshipSyncFlow.mobileContactsPermission) && Intrinsics3.areEqual(this.hasPhoneNumber, trackRelationshipSyncFlow.hasPhoneNumber);
    }

    public int hashCode() {
        CharSequence charSequence = this.flowType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.fromStep;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.toStep;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Boolean bool = this.skip;
        int iHashCode4 = (iHashCode3 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.back;
        int iHashCode5 = (iHashCode4 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Float f = this.secondsOnFromStep;
        int iHashCode6 = (iHashCode5 + (f != null ? f.hashCode() : 0)) * 31;
        Long l = this.numContactsFound;
        int iHashCode7 = (iHashCode6 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.numContactsAdded;
        int iHashCode8 = (iHashCode7 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.mobileContactsPermission;
        int iHashCode9 = (iHashCode8 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Boolean bool3 = this.hasPhoneNumber;
        return iHashCode9 + (bool3 != null ? bool3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackRelationshipSyncFlow(flowType=");
        sbU.append(this.flowType);
        sbU.append(", fromStep=");
        sbU.append(this.fromStep);
        sbU.append(", toStep=");
        sbU.append(this.toStep);
        sbU.append(", skip=");
        sbU.append(this.skip);
        sbU.append(", back=");
        sbU.append(this.back);
        sbU.append(", secondsOnFromStep=");
        sbU.append(this.secondsOnFromStep);
        sbU.append(", numContactsFound=");
        sbU.append(this.numContactsFound);
        sbU.append(", numContactsAdded=");
        sbU.append(this.numContactsAdded);
        sbU.append(", mobileContactsPermission=");
        sbU.append(this.mobileContactsPermission);
        sbU.append(", hasPhoneNumber=");
        return outline.D(sbU, this.hasPhoneNumber, ")");
    }
}
