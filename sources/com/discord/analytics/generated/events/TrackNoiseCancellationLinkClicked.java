package com.discord.analytics.generated.events;

import androidx.core.app.NotificationCompat;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackNoiseCancellationLinkClicked.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNoiseCancellationLinkClicked implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver {
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
        return C12238m.areEqual(this.text, trackNoiseCancellationLinkClicked.text) && C12238m.areEqual(this.href, trackNoiseCancellationLinkClicked.href);
    }

    public int hashCode() {
        CharSequence charSequence = this.text;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.href;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackNoiseCancellationLinkClicked(text=");
        sbM833U.append(this.text);
        sbM833U.append(", href=");
        return C1643a.m817E(sbM833U, this.href, ")");
    }
}
