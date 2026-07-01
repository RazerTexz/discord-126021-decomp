package com.discord.analytics.generated.events.network_action;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.analytics.generated.traits.TrackNetworkMetadata;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackNetworkActionUserResetPassword.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNetworkActionUserResetPassword implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver, TrackNetworkMetadataReceiver {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackNetworkMetadata trackNetworkMetadata;
    private final Boolean mfa = null;
    private final transient String analyticsSchemaTypeName = "network_action_user_reset_password";

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
            return (other instanceof TrackNetworkActionUserResetPassword) && m.areEqual(this.mfa, ((TrackNetworkActionUserResetPassword) other).mfa);
        }
        return true;
    }

    public int hashCode() {
        Boolean bool = this.mfa;
        if (bool != null) {
            return bool.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.D(a.U("TrackNetworkActionUserResetPassword(mfa="), this.mfa, ")");
    }
}
