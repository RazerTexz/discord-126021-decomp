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

/* JADX INFO: compiled from: TrackNetworkActionUserLogin.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNetworkActionUserLogin implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver, TrackNetworkMetadataReceiver {
    private final transient String analyticsSchemaTypeName;
    private final CharSequence inviteCode;
    private final Boolean isMultiAccount;
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackNetworkMetadata trackNetworkMetadata;

    public TrackNetworkActionUserLogin() {
        this(null, null, 3);
    }

    public TrackNetworkActionUserLogin(CharSequence charSequence, Boolean bool, int i) {
        int i2 = i & 2;
        this.inviteCode = (i & 1) != 0 ? null : charSequence;
        this.isMultiAccount = null;
        this.analyticsSchemaTypeName = "network_action_user_login";
    }

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
        if (!(other instanceof TrackNetworkActionUserLogin)) {
            return false;
        }
        TrackNetworkActionUserLogin trackNetworkActionUserLogin = (TrackNetworkActionUserLogin) other;
        return C12238m.areEqual(this.inviteCode, trackNetworkActionUserLogin.inviteCode) && C12238m.areEqual(this.isMultiAccount, trackNetworkActionUserLogin.isMultiAccount);
    }

    public int hashCode() {
        CharSequence charSequence = this.inviteCode;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Boolean bool = this.isMultiAccount;
        return iHashCode + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackNetworkActionUserLogin(inviteCode=");
        sbM833U.append(this.inviteCode);
        sbM833U.append(", isMultiAccount=");
        return C1643a.m816D(sbM833U, this.isMultiAccount, ")");
    }
}
