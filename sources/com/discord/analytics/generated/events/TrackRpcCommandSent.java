package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.command, trackRpcCommandSent.command) && C12238m.areEqual(this.scope, trackRpcCommandSent.scope);
    }

    public int hashCode() {
        CharSequence charSequence = this.command;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.scope;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackRpcCommandSent(command=");
        sbM833U.append(this.command);
        sbM833U.append(", scope=");
        return C1643a.m817E(sbM833U, this.scope, ")");
    }
}
