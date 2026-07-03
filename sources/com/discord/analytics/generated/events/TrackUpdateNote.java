package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackUpdateNote.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackUpdateNote implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long otherUser = null;
    private final CharSequence type = null;
    private final transient String analyticsSchemaTypeName = "update_note";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackUpdateNote)) {
            return false;
        }
        TrackUpdateNote trackUpdateNote = (TrackUpdateNote) other;
        return C12238m.areEqual(this.otherUser, trackUpdateNote.otherUser) && C12238m.areEqual(this.type, trackUpdateNote.type);
    }

    public int hashCode() {
        Long l = this.otherUser;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.type;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackUpdateNote(otherUser=");
        sbM833U.append(this.otherUser);
        sbM833U.append(", type=");
        return C1643a.m817E(sbM833U, this.type, ")");
    }
}
