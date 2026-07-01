package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackDismissibleContentDismissed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackDismissibleContentDismissed implements AnalyticsSchema, TrackBaseReceiver {
    private final CharSequence action;
    private final transient String analyticsSchemaTypeName;
    private final Boolean bypassFatigue;
    private final Long contentCount;
    private final CharSequence groupName;
    private TrackBase trackBase;
    private final CharSequence type;

    public TrackDismissibleContentDismissed() {
        this(null, null, null, null, null, 31);
    }

    public TrackDismissibleContentDismissed(CharSequence charSequence, CharSequence charSequence2, Long l, CharSequence charSequence3, Boolean bool, int i) {
        int i2 = i & 2;
        int i3 = i & 4;
        int i4 = i & 8;
        int i5 = i & 16;
        this.type = (i & 1) != 0 ? null : charSequence;
        this.action = null;
        this.contentCount = null;
        this.groupName = null;
        this.bypassFatigue = null;
        this.analyticsSchemaTypeName = "dismissible_content_dismissed";
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
        if (!(other instanceof TrackDismissibleContentDismissed)) {
            return false;
        }
        TrackDismissibleContentDismissed trackDismissibleContentDismissed = (TrackDismissibleContentDismissed) other;
        return m.areEqual(this.type, trackDismissibleContentDismissed.type) && m.areEqual(this.action, trackDismissibleContentDismissed.action) && m.areEqual(this.contentCount, trackDismissibleContentDismissed.contentCount) && m.areEqual(this.groupName, trackDismissibleContentDismissed.groupName) && m.areEqual(this.bypassFatigue, trackDismissibleContentDismissed.bypassFatigue);
    }

    public int hashCode() {
        CharSequence charSequence = this.type;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.action;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.contentCount;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.groupName;
        int iHashCode4 = (iHashCode3 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Boolean bool = this.bypassFatigue;
        return iHashCode4 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackDismissibleContentDismissed(type=");
        sbU.append(this.type);
        sbU.append(", action=");
        sbU.append(this.action);
        sbU.append(", contentCount=");
        sbU.append(this.contentCount);
        sbU.append(", groupName=");
        sbU.append(this.groupName);
        sbU.append(", bypassFatigue=");
        return a.D(sbU, this.bypassFatigue, ")");
    }
}
