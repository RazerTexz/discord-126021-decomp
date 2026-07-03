package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackCreateSticker.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackCreateSticker implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long id = null;
    private final Long guildId = null;
    private final Long formatType = null;
    private final transient String analyticsSchemaTypeName = "create_sticker";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackCreateSticker)) {
            return false;
        }
        TrackCreateSticker trackCreateSticker = (TrackCreateSticker) other;
        return C12238m.areEqual(this.id, trackCreateSticker.id) && C12238m.areEqual(this.guildId, trackCreateSticker.guildId) && C12238m.areEqual(this.formatType, trackCreateSticker.formatType);
    }

    public int hashCode() {
        Long l = this.id;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.guildId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.formatType;
        return iHashCode2 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackCreateSticker(id=");
        sbM833U.append(this.id);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", formatType=");
        return C1643a.m819G(sbM833U, this.formatType, ")");
    }
}
