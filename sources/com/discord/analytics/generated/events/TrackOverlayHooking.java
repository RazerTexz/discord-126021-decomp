package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackOverlayHooking.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackOverlayHooking implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence nonce = null;
    private final CharSequence gameName = null;
    private final CharSequence cpu = null;
    private final CharSequence gpu = null;
    private final transient String analyticsSchemaTypeName = "overlay_hooking";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackOverlayHooking)) {
            return false;
        }
        TrackOverlayHooking trackOverlayHooking = (TrackOverlayHooking) other;
        return C12238m.areEqual(this.nonce, trackOverlayHooking.nonce) && C12238m.areEqual(this.gameName, trackOverlayHooking.gameName) && C12238m.areEqual(this.cpu, trackOverlayHooking.cpu) && C12238m.areEqual(this.gpu, trackOverlayHooking.gpu);
    }

    public int hashCode() {
        CharSequence charSequence = this.nonce;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.gameName;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.cpu;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.gpu;
        return iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackOverlayHooking(nonce=");
        sbM833U.append(this.nonce);
        sbM833U.append(", gameName=");
        sbM833U.append(this.gameName);
        sbM833U.append(", cpu=");
        sbM833U.append(this.cpu);
        sbM833U.append(", gpu=");
        return C1643a.m817E(sbM833U, this.gpu, ")");
    }
}
