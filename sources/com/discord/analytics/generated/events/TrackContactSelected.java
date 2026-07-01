package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackContactSelected.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackContactSelected implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Boolean selected = null;
    private final transient String analyticsSchemaTypeName = "contact_selected";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackContactSelected) && m.areEqual(this.selected, ((TrackContactSelected) other).selected);
        }
        return true;
    }

    public int hashCode() {
        Boolean bool = this.selected;
        if (bool != null) {
            return bool.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.D(a.U("TrackContactSelected(selected="), this.selected, ")");
    }
}
