package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackVerifyAccount.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackVerifyAccount implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence source = null;
    private final Long fingerprint = null;
    private final transient String analyticsSchemaTypeName = "verify_account";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackVerifyAccount)) {
            return false;
        }
        TrackVerifyAccount trackVerifyAccount = (TrackVerifyAccount) other;
        return C12238m.areEqual(this.source, trackVerifyAccount.source) && C12238m.areEqual(this.fingerprint, trackVerifyAccount.fingerprint);
    }

    public int hashCode() {
        CharSequence charSequence = this.source;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.fingerprint;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackVerifyAccount(source=");
        sbM833U.append(this.source);
        sbM833U.append(", fingerprint=");
        return C1643a.m819G(sbM833U, this.fingerprint, ")");
    }
}
