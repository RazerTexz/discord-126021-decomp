package com.discord.widgets.guildscheduledevent;

import b.d.b.a.a;
import com.discord.api.guildscheduledevent.GuildScheduledEventBroadcast;
import com.discord.stores.utilities.Default;
import com.discord.stores.utilities.RestCallState;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildScheduledEventDirectoryAssociationViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildScheduledEventDirectoryAssociationState {
    private final RestCallState<GuildScheduledEventBroadcast> enabledAsync;

    public GuildScheduledEventDirectoryAssociationState() {
        this(null, 1, null);
    }

    public GuildScheduledEventDirectoryAssociationState(RestCallState<GuildScheduledEventBroadcast> restCallState) {
        m.checkNotNullParameter(restCallState, "enabledAsync");
        this.enabledAsync = restCallState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuildScheduledEventDirectoryAssociationState copy$default(GuildScheduledEventDirectoryAssociationState guildScheduledEventDirectoryAssociationState, RestCallState restCallState, int i, Object obj) {
        if ((i & 1) != 0) {
            restCallState = guildScheduledEventDirectoryAssociationState.enabledAsync;
        }
        return guildScheduledEventDirectoryAssociationState.copy(restCallState);
    }

    public final RestCallState<GuildScheduledEventBroadcast> component1() {
        return this.enabledAsync;
    }

    public final GuildScheduledEventDirectoryAssociationState copy(RestCallState<GuildScheduledEventBroadcast> enabledAsync) {
        m.checkNotNullParameter(enabledAsync, "enabledAsync");
        return new GuildScheduledEventDirectoryAssociationState(enabledAsync);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof GuildScheduledEventDirectoryAssociationState) && m.areEqual(this.enabledAsync, ((GuildScheduledEventDirectoryAssociationState) other).enabledAsync);
        }
        return true;
    }

    public final RestCallState<GuildScheduledEventBroadcast> getEnabledAsync() {
        return this.enabledAsync;
    }

    public int hashCode() {
        RestCallState<GuildScheduledEventBroadcast> restCallState = this.enabledAsync;
        if (restCallState != null) {
            return restCallState.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("GuildScheduledEventDirectoryAssociationState(enabledAsync=");
        sbU.append(this.enabledAsync);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ GuildScheduledEventDirectoryAssociationState(RestCallState restCallState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Default.INSTANCE : restCallState);
    }
}
