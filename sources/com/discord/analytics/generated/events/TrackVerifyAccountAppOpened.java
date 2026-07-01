package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackVerifyAccountAppOpened.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackVerifyAccountAppOpened implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long verifyingUserId = null;
    private final transient String analyticsSchemaTypeName = "verify_account_app_opened";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackVerifyAccountAppOpened) && Intrinsics3.areEqual(this.verifyingUserId, ((TrackVerifyAccountAppOpened) other).verifyingUserId);
        }
        return true;
    }

    public int hashCode() {
        Long l = this.verifyingUserId;
        if (l != null) {
            return l.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.G(outline.U("TrackVerifyAccountAppOpened(verifyingUserId="), this.verifyingUserId, ")");
    }
}
