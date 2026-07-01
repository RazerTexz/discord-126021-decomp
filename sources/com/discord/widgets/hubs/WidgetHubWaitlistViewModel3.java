package com.discord.widgets.hubs;

import b.d.b.a.outline;
import com.discord.api.hubs.WaitlistSignup;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallState2;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.discord.widgets.hubs.HubWaitlistState, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubWaitlistViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetHubWaitlistViewModel3 {
    private final RestCallState<WaitlistSignup> waitlistAsync;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetHubWaitlistViewModel3() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public WidgetHubWaitlistViewModel3(RestCallState<WaitlistSignup> restCallState) {
        Intrinsics3.checkNotNullParameter(restCallState, "waitlistAsync");
        this.waitlistAsync = restCallState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetHubWaitlistViewModel3 copy$default(WidgetHubWaitlistViewModel3 widgetHubWaitlistViewModel3, RestCallState restCallState, int i, Object obj) {
        if ((i & 1) != 0) {
            restCallState = widgetHubWaitlistViewModel3.waitlistAsync;
        }
        return widgetHubWaitlistViewModel3.copy(restCallState);
    }

    public final RestCallState<WaitlistSignup> component1() {
        return this.waitlistAsync;
    }

    public final WidgetHubWaitlistViewModel3 copy(RestCallState<WaitlistSignup> waitlistAsync) {
        Intrinsics3.checkNotNullParameter(waitlistAsync, "waitlistAsync");
        return new WidgetHubWaitlistViewModel3(waitlistAsync);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetHubWaitlistViewModel3) && Intrinsics3.areEqual(this.waitlistAsync, ((WidgetHubWaitlistViewModel3) other).waitlistAsync);
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
        StringBuilder sbU = outline.U("HubWaitlistState(waitlistAsync=");
        sbU.append(this.waitlistAsync);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ WidgetHubWaitlistViewModel3(RestCallState restCallState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? RestCallState2.INSTANCE : restCallState);
    }
}
