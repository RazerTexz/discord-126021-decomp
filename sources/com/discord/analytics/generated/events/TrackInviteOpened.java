package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackInviteOpened.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackInviteOpened implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence inviteCode = null;
    private final Long loadTime = null;
    private final transient String analyticsSchemaTypeName = "invite_opened";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackInviteOpened)) {
            return false;
        }
        TrackInviteOpened trackInviteOpened = (TrackInviteOpened) other;
        return m.areEqual(this.inviteCode, trackInviteOpened.inviteCode) && m.areEqual(this.loadTime, trackInviteOpened.loadTime);
    }

    public int hashCode() {
        CharSequence charSequence = this.inviteCode;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.loadTime;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackInviteOpened(inviteCode=");
        sbU.append(this.inviteCode);
        sbU.append(", loadTime=");
        return a.G(sbU, this.loadTime, ")");
    }
}
