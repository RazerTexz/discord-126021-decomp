package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackRpcCommandSent.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackRpcCommandSent implements AnalyticsSchema, TrackBaseReceiver {
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
        return m.areEqual(this.command, trackRpcCommandSent.command) && m.areEqual(this.scope, trackRpcCommandSent.scope);
    }

    public int hashCode() {
        CharSequence charSequence = this.command;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.scope;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackRpcCommandSent(command=");
        sbU.append(this.command);
        sbU.append(", scope=");
        return a.E(sbU, this.scope, ")");
    }
}
