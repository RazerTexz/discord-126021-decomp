package com.discord.analytics.generated.events.network_action;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.analytics.generated.traits.TrackNetworkMetadata;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackNetworkActionEmailSettingsUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNetworkActionEmailSettingsUpdate implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver, TrackNetworkMetadataReceiver {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackNetworkMetadata trackNetworkMetadata;
    private final CharSequence category = null;
    private final Boolean value = null;
    private final List<CharSequence> categories = null;
    private final List<Boolean> values = null;
    private final transient String analyticsSchemaTypeName = "network_action_email_settings_update";

    @Override // com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver
    /* JADX INFO: renamed from: b */
    public void mo7529b(TrackNetworkMetadata trackNetworkMetadata) {
        this.trackNetworkMetadata = trackNetworkMetadata;
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackNetworkActionEmailSettingsUpdate)) {
            return false;
        }
        TrackNetworkActionEmailSettingsUpdate trackNetworkActionEmailSettingsUpdate = (TrackNetworkActionEmailSettingsUpdate) other;
        return C12238m.areEqual(this.category, trackNetworkActionEmailSettingsUpdate.category) && C12238m.areEqual(this.value, trackNetworkActionEmailSettingsUpdate.value) && C12238m.areEqual(this.categories, trackNetworkActionEmailSettingsUpdate.categories) && C12238m.areEqual(this.values, trackNetworkActionEmailSettingsUpdate.values);
    }

    public int hashCode() {
        CharSequence charSequence = this.category;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Boolean bool = this.value;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        List<CharSequence> list = this.categories;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        List<Boolean> list2 = this.values;
        return iHashCode3 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackNetworkActionEmailSettingsUpdate(category=");
        sbM833U.append(this.category);
        sbM833U.append(", value=");
        sbM833U.append(this.value);
        sbM833U.append(", categories=");
        sbM833U.append(this.categories);
        sbM833U.append(", values=");
        return C1643a.m824L(sbM833U, this.values, ")");
    }
}
