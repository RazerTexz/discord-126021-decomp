package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackGiftCodeMetadata;
import com.discord.analytics.generated.traits.TrackGiftCodeMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.loginSource, trackLoginSuccessful.loginSource) && C12238m.areEqual(this.source, trackLoginSuccessful.source) && C12238m.areEqual(this.isNewUser, trackLoginSuccessful.isNewUser) && C12238m.areEqual(this.fingerprint, trackLoginSuccessful.fingerprint) && C12238m.areEqual(this.loginMethod, trackLoginSuccessful.loginMethod);
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
        StringBuilder sbM833U = C1643a.m833U("TrackLoginSuccessful(loginSource=");
        sbM833U.append(this.loginSource);
        sbM833U.append(", source=");
        sbM833U.append(this.source);
        sbM833U.append(", isNewUser=");
        sbM833U.append(this.isNewUser);
        sbM833U.append(", fingerprint=");
        sbM833U.append(this.fingerprint);
        sbM833U.append(", loginMethod=");
        return C1643a.m817E(sbM833U, this.loginMethod, ")");
    }
}
