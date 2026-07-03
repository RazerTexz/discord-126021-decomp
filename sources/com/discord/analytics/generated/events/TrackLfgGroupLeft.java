package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackLfgGroup;
import com.discord.analytics.generated.traits.TrackLfgGroupReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackLfgGroupLeft.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackLfgGroupLeft implements AnalyticsSchema, TrackBaseReceiver, TrackChannelReceiver, TrackLfgGroupReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackLfgGroup trackLfgGroup;
    private final CharSequence leaveType = null;
    private final transient String analyticsSchemaTypeName = "lfg_group_left";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackLfgGroupLeft) && C12238m.areEqual(this.leaveType, ((TrackLfgGroupLeft) other).leaveType);
        }
        return true;
    }

    public int hashCode() {
        CharSequence charSequence = this.leaveType;
        if (charSequence != null) {
            return charSequence.hashCode();
        }
        return 0;
    }

    public String toString() {
        return C1643a.m817E(C1643a.m833U("TrackLfgGroupLeft(leaveType="), this.leaveType, ")");
    }
}
