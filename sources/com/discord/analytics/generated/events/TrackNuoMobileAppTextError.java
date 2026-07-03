package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackNuoMobileAppTextError.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNuoMobileAppTextError implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence error = null;
    private final transient String analyticsSchemaTypeName = "nuo_mobile_app_text_error";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackNuoMobileAppTextError) && C12238m.areEqual(this.error, ((TrackNuoMobileAppTextError) other).error);
        }
        return true;
    }

    public int hashCode() {
        CharSequence charSequence = this.error;
        if (charSequence != null) {
            return charSequence.hashCode();
        }
        return 0;
    }

    public String toString() {
        return C1643a.m817E(C1643a.m833U("TrackNuoMobileAppTextError(error="), this.error, ")");
    }
}
