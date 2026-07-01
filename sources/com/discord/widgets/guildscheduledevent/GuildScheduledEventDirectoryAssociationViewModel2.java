package com.discord.widgets.guildscheduledevent;

import b.d.b.a.outline;
import com.discord.api.guildscheduledevent.GuildScheduledEventBroadcast;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallState2;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventDirectoryAssociationState, reason: use source file name */
/* JADX INFO: compiled from: GuildScheduledEventDirectoryAssociationViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildScheduledEventDirectoryAssociationViewModel2 {
    private final RestCallState<GuildScheduledEventBroadcast> enabledAsync;

    /* JADX WARN: Multi-variable type inference failed */
    public GuildScheduledEventDirectoryAssociationViewModel2() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public GuildScheduledEventDirectoryAssociationViewModel2(RestCallState<GuildScheduledEventBroadcast> restCallState) {
        Intrinsics3.checkNotNullParameter(restCallState, "enabledAsync");
        this.enabledAsync = restCallState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuildScheduledEventDirectoryAssociationViewModel2 copy$default(GuildScheduledEventDirectoryAssociationViewModel2 guildScheduledEventDirectoryAssociationViewModel2, RestCallState restCallState, int i, Object obj) {
        if ((i & 1) != 0) {
            restCallState = guildScheduledEventDirectoryAssociationViewModel2.enabledAsync;
        }
        return guildScheduledEventDirectoryAssociationViewModel2.copy(restCallState);
    }

    public final RestCallState<GuildScheduledEventBroadcast> component1() {
        return this.enabledAsync;
    }

    public final GuildScheduledEventDirectoryAssociationViewModel2 copy(RestCallState<GuildScheduledEventBroadcast> enabledAsync) {
        Intrinsics3.checkNotNullParameter(enabledAsync, "enabledAsync");
        return new GuildScheduledEventDirectoryAssociationViewModel2(enabledAsync);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof GuildScheduledEventDirectoryAssociationViewModel2) && Intrinsics3.areEqual(this.enabledAsync, ((GuildScheduledEventDirectoryAssociationViewModel2) other).enabledAsync);
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
        StringBuilder sbU = outline.U("GuildScheduledEventDirectoryAssociationState(enabledAsync=");
        sbU.append(this.enabledAsync);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ GuildScheduledEventDirectoryAssociationViewModel2(RestCallState restCallState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? RestCallState2.INSTANCE : restCallState);
    }
}
