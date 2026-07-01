package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackExpressionPickerTabClicked.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackExpressionPickerTabClicked implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence tab = null;
    private final Boolean badged = null;
    private final transient String analyticsSchemaTypeName = "expression_picker_tab_clicked";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackExpressionPickerTabClicked)) {
            return false;
        }
        TrackExpressionPickerTabClicked trackExpressionPickerTabClicked = (TrackExpressionPickerTabClicked) other;
        return Intrinsics3.areEqual(this.tab, trackExpressionPickerTabClicked.tab) && Intrinsics3.areEqual(this.badged, trackExpressionPickerTabClicked.badged);
    }

    public int hashCode() {
        CharSequence charSequence = this.tab;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Boolean bool = this.badged;
        return iHashCode + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackExpressionPickerTabClicked(tab=");
        sbU.append(this.tab);
        sbU.append(", badged=");
        return outline.D(sbU, this.badged, ")");
    }
}
