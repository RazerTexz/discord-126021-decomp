package com.discord.analytics.generated.events.network_action;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.analytics.generated.traits.TrackNetworkMetadata;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackNetworkActionUserAccountEmailChangeSendCode.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNetworkActionUserAccountEmailChangeSendCode implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver, TrackNetworkMetadataReceiver {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackNetworkMetadata trackNetworkMetadata;
    private final Boolean isResend = null;
    private final transient String analyticsSchemaTypeName = "network_action_user_account_email_change_send_code";

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
        if (this != other) {
            return (other instanceof TrackNetworkActionUserAccountEmailChangeSendCode) && C12238m.areEqual(this.isResend, ((TrackNetworkActionUserAccountEmailChangeSendCode) other).isResend);
        }
        return true;
    }

    public int hashCode() {
        Boolean bool = this.isResend;
        if (bool != null) {
            return bool.hashCode();
        }
        return 0;
    }

    public String toString() {
        return C1643a.m816D(C1643a.m833U("TrackNetworkActionUserAccountEmailChangeSendCode(isResend="), this.isResend, ")");
    }
}
