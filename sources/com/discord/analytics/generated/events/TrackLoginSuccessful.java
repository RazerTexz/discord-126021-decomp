package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackGiftCodeMetadata;
import com.discord.analytics.generated.traits.TrackGiftCodeMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackLoginSuccessful.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackLoginSuccessful implements AnalyticsSchema, TrackBaseReceiver, TrackGiftCodeMetadataReceiver {
    private TrackBase trackBase;
    private TrackGiftCodeMetadata trackGiftCodeMetadata;
    private final CharSequence loginSource = null;
    private final CharSequence source = null;
    private final Boolean isNewUser = null;
    private final Long fingerprint = null;
    private final CharSequence loginMethod = null;
    private final transient String analyticsSchemaTypeName = "login_successful";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackLoginSuccessful)) {
            return false;
        }
        TrackLoginSuccessful trackLoginSuccessful = (TrackLoginSuccessful) other;
        return m.areEqual(this.loginSource, trackLoginSuccessful.loginSource) && m.areEqual(this.source, trackLoginSuccessful.source) && m.areEqual(this.isNewUser, trackLoginSuccessful.isNewUser) && m.areEqual(this.fingerprint, trackLoginSuccessful.fingerprint) && m.areEqual(this.loginMethod, trackLoginSuccessful.loginMethod);
    }

    public int hashCode() {
        CharSequence charSequence = this.loginSource;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.source;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Boolean bool = this.isNewUser;
        int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l = this.fingerprint;
        int iHashCode4 = (iHashCode3 + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.loginMethod;
        return iHashCode4 + (charSequence3 != null ? charSequence3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackLoginSuccessful(loginSource=");
        sbU.append(this.loginSource);
        sbU.append(", source=");
        sbU.append(this.source);
        sbU.append(", isNewUser=");
        sbU.append(this.isNewUser);
        sbU.append(", fingerprint=");
        sbU.append(this.fingerprint);
        sbU.append(", loginMethod=");
        return a.E(sbU, this.loginMethod, ")");
    }
}
