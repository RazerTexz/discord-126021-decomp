package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackAppFirstLaunched.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackAppFirstLaunched implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence platform = null;
    private final transient String analyticsSchemaTypeName = "app_first_launched";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackAppFirstLaunched) && C12238m.areEqual(this.platform, ((TrackAppFirstLaunched) other).platform);
        }
        return true;
    }

    public int hashCode() {
        CharSequence charSequence = this.platform;
        if (charSequence != null) {
            return charSequence.hashCode();
        }
        return 0;
    }

    public String toString() {
        return C1643a.m817E(C1643a.m833U("TrackAppFirstLaunched(platform="), this.platform, ")");
    }
}
