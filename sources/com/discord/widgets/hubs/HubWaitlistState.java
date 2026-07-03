package com.discord.widgets.hubs;

import com.discord.api.hubs.WaitlistSignup;
import com.discord.stores.utilities.Default;
import com.discord.stores.utilities.RestCallState;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetHubWaitlistViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class HubWaitlistState {
    private final RestCallState<WaitlistSignup> waitlistAsync;

    /* JADX WARN: Multi-variable type inference failed */
    public HubWaitlistState() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public HubWaitlistState(RestCallState<WaitlistSignup> restCallState) {
        C12238m.checkNotNullParameter(restCallState, "waitlistAsync");
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
        C12238m.checkNotNullParameter(waitlistAsync, "waitlistAsync");
        return new HubWaitlistState(waitlistAsync);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof HubWaitlistState) && C12238m.areEqual(this.waitlistAsync, ((HubWaitlistState) other).waitlistAsync);
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
        StringBuilder sbM833U = C1643a.m833U("HubWaitlistState(waitlistAsync=");
        sbM833U.append(this.waitlistAsync);
        sbM833U.append(")");
        return sbM833U.toString();
    }

    public /* synthetic */ HubWaitlistState(RestCallState restCallState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Default.INSTANCE : restCallState);
    }
}
