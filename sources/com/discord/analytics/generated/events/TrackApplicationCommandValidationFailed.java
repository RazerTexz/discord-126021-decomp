package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackApplicationCommandValidationFailed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackApplicationCommandValidationFailed implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long applicationId = null;
    private final Long commandId = null;
    private final CharSequence argumentType = null;
    private final Boolean isRequired = null;
    private final transient String analyticsSchemaTypeName = "application_command_validation_failed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackApplicationCommandValidationFailed)) {
            return false;
        }
        TrackApplicationCommandValidationFailed trackApplicationCommandValidationFailed = (TrackApplicationCommandValidationFailed) other;
        return Intrinsics3.areEqual(this.applicationId, trackApplicationCommandValidationFailed.applicationId) && Intrinsics3.areEqual(this.commandId, trackApplicationCommandValidationFailed.commandId) && Intrinsics3.areEqual(this.argumentType, trackApplicationCommandValidationFailed.argumentType) && Intrinsics3.areEqual(this.isRequired, trackApplicationCommandValidationFailed.isRequired);
    }

    public int hashCode() {
        Long l = this.applicationId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.commandId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.argumentType;
        int iHashCode3 = (iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Boolean bool = this.isRequired;
        return iHashCode3 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackApplicationCommandValidationFailed(applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", commandId=");
        sbU.append(this.commandId);
        sbU.append(", argumentType=");
        sbU.append(this.argumentType);
        sbU.append(", isRequired=");
        return outline.D(sbU, this.isRequired, ")");
    }
}
