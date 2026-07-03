package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackApplicationCommandValidationFailed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackApplicationCommandValidationFailed implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.applicationId, trackApplicationCommandValidationFailed.applicationId) && C12238m.areEqual(this.commandId, trackApplicationCommandValidationFailed.commandId) && C12238m.areEqual(this.argumentType, trackApplicationCommandValidationFailed.argumentType) && C12238m.areEqual(this.isRequired, trackApplicationCommandValidationFailed.isRequired);
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
        StringBuilder sbM833U = C1643a.m833U("TrackApplicationCommandValidationFailed(applicationId=");
        sbM833U.append(this.applicationId);
        sbM833U.append(", commandId=");
        sbM833U.append(this.commandId);
        sbM833U.append(", argumentType=");
        sbM833U.append(this.argumentType);
        sbM833U.append(", isRequired=");
        return C1643a.m816D(sbM833U, this.isRequired, ")");
    }
}
