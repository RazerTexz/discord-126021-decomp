package com.discord.analytics.generated.events.network_action;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.analytics.generated.traits.TrackNetworkMetadata;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackNetworkActionUserSurveyFetch.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNetworkActionUserSurveyFetch implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver, TrackNetworkMetadataReceiver {
    private final transient String analyticsSchemaTypeName;
    private final CharSequence key;
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackNetworkMetadata trackNetworkMetadata;

    public TrackNetworkActionUserSurveyFetch() {
        this.key = null;
        this.analyticsSchemaTypeName = "network_action_user_survey_fetch";
    }

    @Override // com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver
    public void b(TrackNetworkMetadata trackNetworkMetadata) {
        this.trackNetworkMetadata = trackNetworkMetadata;
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackNetworkActionUserSurveyFetch) && m.areEqual(this.key, ((TrackNetworkActionUserSurveyFetch) other).key);
        }
        return true;
    }

    public int hashCode() {
        CharSequence charSequence = this.key;
        if (charSequence != null) {
            return charSequence.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.E(a.U("TrackNetworkActionUserSurveyFetch(key="), this.key, ")");
    }

    public TrackNetworkActionUserSurveyFetch(CharSequence charSequence) {
        this.key = charSequence;
        this.analyticsSchemaTypeName = "network_action_user_survey_fetch";
    }
}
