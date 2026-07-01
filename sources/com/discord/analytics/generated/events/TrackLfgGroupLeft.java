package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackLfgGroup;
import com.discord.analytics.generated.traits.TrackLfgGroup2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackLfgGroupLeft.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackLfgGroupLeft implements AnalyticsSchema, TrackBase2, TrackChannel2, TrackLfgGroup2 {
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
            return (other instanceof TrackLfgGroupLeft) && Intrinsics3.areEqual(this.leaveType, ((TrackLfgGroupLeft) other).leaveType);
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
        return outline.E(outline.U("TrackLfgGroupLeft(leaveType="), this.leaveType, ")");
    }
}
