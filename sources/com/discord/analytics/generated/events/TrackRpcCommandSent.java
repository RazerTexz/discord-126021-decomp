package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackRpcCommandSent.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackRpcCommandSent implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence command = null;
    private final CharSequence scope = null;
    private final transient String analyticsSchemaTypeName = "rpc_command_sent";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackRpcCommandSent)) {
            return false;
        }
        TrackRpcCommandSent trackRpcCommandSent = (TrackRpcCommandSent) other;
        return Intrinsics3.areEqual(this.command, trackRpcCommandSent.command) && Intrinsics3.areEqual(this.scope, trackRpcCommandSent.scope);
    }

    public int hashCode() {
        CharSequence charSequence = this.command;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.scope;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackRpcCommandSent(command=");
        sbU.append(this.command);
        sbU.append(", scope=");
        return outline.E(sbU, this.scope, ")");
    }
}
