package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackAddressValidationFailed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackAddressValidationFailed implements AnalyticsSchema, TrackBase2 {
    private final CharSequence addressCountry = null;
    private final transient String analyticsSchemaTypeName = "address_validation_failed";
    private TrackBase trackBase;

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackAddressValidationFailed) && Intrinsics3.areEqual(this.addressCountry, ((TrackAddressValidationFailed) other).addressCountry);
        }
        return true;
    }

    public int hashCode() {
        CharSequence charSequence = this.addressCountry;
        if (charSequence != null) {
            return charSequence.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.E(outline.U("TrackAddressValidationFailed(addressCountry="), this.addressCountry, ")");
    }
}
