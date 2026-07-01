package com.discord.analytics.generated.events;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackNoiseCancellationLinkClicked.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNoiseCancellationLinkClicked implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2 {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private final CharSequence text = null;
    private final CharSequence href = null;
    private final transient String analyticsSchemaTypeName = "noise_cancellation_link_clicked";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackNoiseCancellationLinkClicked)) {
            return false;
        }
        TrackNoiseCancellationLinkClicked trackNoiseCancellationLinkClicked = (TrackNoiseCancellationLinkClicked) other;
        return Intrinsics3.areEqual(this.text, trackNoiseCancellationLinkClicked.text) && Intrinsics3.areEqual(this.href, trackNoiseCancellationLinkClicked.href);
    }

    public int hashCode() {
        CharSequence charSequence = this.text;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.href;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackNoiseCancellationLinkClicked(text=");
        sbU.append(this.text);
        sbU.append(", href=");
        return outline.E(sbU, this.href, ")");
    }
}
