package com.discord.widgets.hubs;

import b.d.b.a.a;
import com.discord.api.hubs.WaitlistSignup;
import com.discord.stores.utilities.Default;
import com.discord.stores.utilities.RestCallState;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetHubWaitlistViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class HubWaitlistState {
    private final RestCallState<WaitlistSignup> waitlistAsync;

    public HubWaitlistState() {
        this(null, 1, null);
    }

    public HubWaitlistState(RestCallState<WaitlistSignup> restCallState) {
        m.checkNotNullParameter(restCallState, "waitlistAsync");
        this.waitlistAsync = restCallState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HubWaitlistState copy$default(HubWaitlistState hubWaitlistState, RestCallState restCallState, int i, Object obj) {
        if ((i & 1) != 0) {
            restCallState = hubWaitlistState.waitlistAsync;
        }
        return hubWaitlistState.copy(restCallState);
    }

    public final RestCallState<WaitlistSignup> component1() {
        return this.waitlistAsync;
    }

    public final HubWaitlistState copy(RestCallState<WaitlistSignup> waitlistAsync) {
        m.checkNotNullParameter(waitlistAsync, "waitlistAsync");
        return new HubWaitlistState(waitlistAsync);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof HubWaitlistState) && m.areEqual(this.waitlistAsync, ((HubWaitlistState) other).waitlistAsync);
        }
        return true;
    }

    public final RestCallState<WaitlistSignup> getWaitlistAsync() {
        return this.waitlistAsync;
    }

    public int hashCode() {
        RestCallState<WaitlistSignup> restCallState = this.waitlistAsync;
        if (restCallState != null) {
            return restCallState.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("HubWaitlistState(waitlistAsync=");
        sbU.append(this.waitlistAsync);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ HubWaitlistState(RestCallState restCallState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Default.INSTANCE : restCallState);
    }
}
