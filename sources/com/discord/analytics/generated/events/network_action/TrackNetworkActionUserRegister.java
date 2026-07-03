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

/* JADX INFO: compiled from: TrackNetworkActionUserRegister.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNetworkActionUserRegister implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver, TrackNetworkMetadataReceiver {
    private final transient String analyticsSchemaTypeName;
    private final CharSequence inviteCode;
    private final Boolean promotionalEmailOptIn;
    private final Boolean promotionalEmailPreChecked;
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackNetworkMetadata trackNetworkMetadata;

    public TrackNetworkActionUserRegister() {
        this.inviteCode = null;
        this.promotionalEmailOptIn = null;
        this.promotionalEmailPreChecked = null;
        this.analyticsSchemaTypeName = "network_action_user_register";
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
        if (!(other instanceof TrackNetworkActionUserRegister)) {
            return false;
        }
        TrackNetworkActionUserRegister trackNetworkActionUserRegister = (TrackNetworkActionUserRegister) other;
        return C12238m.areEqual(this.inviteCode, trackNetworkActionUserRegister.inviteCode) && C12238m.areEqual(this.promotionalEmailOptIn, trackNetworkActionUserRegister.promotionalEmailOptIn) && C12238m.areEqual(this.promotionalEmailPreChecked, trackNetworkActionUserRegister.promotionalEmailPreChecked);
    }

    public int hashCode() {
        CharSequence charSequence = this.inviteCode;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Boolean bool = this.promotionalEmailOptIn;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.promotionalEmailPreChecked;
        return iHashCode2 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackNetworkActionUserRegister(inviteCode=");
        sbM833U.append(this.inviteCode);
        sbM833U.append(", promotionalEmailOptIn=");
        sbM833U.append(this.promotionalEmailOptIn);
        sbM833U.append(", promotionalEmailPreChecked=");
        return C1643a.m816D(sbM833U, this.promotionalEmailPreChecked, ")");
    }

    public TrackNetworkActionUserRegister(CharSequence charSequence, Boolean bool, Boolean bool2) {
        this.inviteCode = charSequence;
        this.promotionalEmailOptIn = bool;
        this.promotionalEmailPreChecked = bool2;
        this.analyticsSchemaTypeName = "network_action_user_register";
    }
}
