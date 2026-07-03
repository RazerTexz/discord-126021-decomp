package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackRelationshipSyncFlow.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackRelationshipSyncFlow implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver {
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
        return C12238m.areEqual(this.flowType, trackRelationshipSyncFlow.flowType) && C12238m.areEqual(this.fromStep, trackRelationshipSyncFlow.fromStep) && C12238m.areEqual(this.toStep, trackRelationshipSyncFlow.toStep) && C12238m.areEqual(this.skip, trackRelationshipSyncFlow.skip) && C12238m.areEqual(this.back, trackRelationshipSyncFlow.back) && C12238m.areEqual(this.secondsOnFromStep, trackRelationshipSyncFlow.secondsOnFromStep) && C12238m.areEqual(this.numContactsFound, trackRelationshipSyncFlow.numContactsFound) && C12238m.areEqual(this.numContactsAdded, trackRelationshipSyncFlow.numContactsAdded) && C12238m.areEqual(this.mobileContactsPermission, trackRelationshipSyncFlow.mobileContactsPermission) && C12238m.areEqual(this.hasPhoneNumber, trackRelationshipSyncFlow.hasPhoneNumber);
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
        StringBuilder sbM833U = C1643a.m833U("TrackRelationshipSyncFlow(flowType=");
        sbM833U.append(this.flowType);
        sbM833U.append(", fromStep=");
        sbM833U.append(this.fromStep);
        sbM833U.append(", toStep=");
        sbM833U.append(this.toStep);
        sbM833U.append(", skip=");
        sbM833U.append(this.skip);
        sbM833U.append(", back=");
        sbM833U.append(this.back);
        sbM833U.append(", secondsOnFromStep=");
        sbM833U.append(this.secondsOnFromStep);
        sbM833U.append(", numContactsFound=");
        sbM833U.append(this.numContactsFound);
        sbM833U.append(", numContactsAdded=");
        sbM833U.append(this.numContactsAdded);
        sbM833U.append(", mobileContactsPermission=");
        sbM833U.append(this.mobileContactsPermission);
        sbM833U.append(", hasPhoneNumber=");
        return C1643a.m816D(sbM833U, this.hasPhoneNumber, ")");
    }
}
