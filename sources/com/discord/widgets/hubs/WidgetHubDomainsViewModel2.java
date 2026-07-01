package com.discord.widgets.hubs;

import b.d.b.a.outline;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallState2;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.discord.widgets.hubs.DomainsState, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubDomainsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetHubDomainsViewModel2 {
    private final Long selectedGuildId;
    private final RestCallState<Object> verifyEmailAsync;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetHubDomainsViewModel2() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public WidgetHubDomainsViewModel2(Long l, RestCallState<? extends Object> restCallState) {
        Intrinsics3.checkNotNullParameter(restCallState, "verifyEmailAsync");
        this.selectedGuildId = l;
        this.verifyEmailAsync = restCallState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetHubDomainsViewModel2 copy$default(WidgetHubDomainsViewModel2 widgetHubDomainsViewModel2, Long l, RestCallState restCallState, int i, Object obj) {
        if ((i & 1) != 0) {
            l = widgetHubDomainsViewModel2.selectedGuildId;
        }
        if ((i & 2) != 0) {
            restCallState = widgetHubDomainsViewModel2.verifyEmailAsync;
        }
        return widgetHubDomainsViewModel2.copy(l, restCallState);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Long getSelectedGuildId() {
        return this.selectedGuildId;
    }

    public final RestCallState<Object> component2() {
        return this.verifyEmailAsync;
    }

    public final WidgetHubDomainsViewModel2 copy(Long selectedGuildId, RestCallState<? extends Object> verifyEmailAsync) {
        Intrinsics3.checkNotNullParameter(verifyEmailAsync, "verifyEmailAsync");
        return new WidgetHubDomainsViewModel2(selectedGuildId, verifyEmailAsync);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetHubDomainsViewModel2)) {
            return false;
        }
        WidgetHubDomainsViewModel2 widgetHubDomainsViewModel2 = (WidgetHubDomainsViewModel2) other;
        return Intrinsics3.areEqual(this.selectedGuildId, widgetHubDomainsViewModel2.selectedGuildId) && Intrinsics3.areEqual(this.verifyEmailAsync, widgetHubDomainsViewModel2.verifyEmailAsync);
    }

    public final Long getSelectedGuildId() {
        return this.selectedGuildId;
    }

    public final RestCallState<Object> getVerifyEmailAsync() {
        return this.verifyEmailAsync;
    }

    public int hashCode() {
        Long l = this.selectedGuildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        RestCallState<Object> restCallState = this.verifyEmailAsync;
        return iHashCode + (restCallState != null ? restCallState.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("DomainsState(selectedGuildId=");
        sbU.append(this.selectedGuildId);
        sbU.append(", verifyEmailAsync=");
        sbU.append(this.verifyEmailAsync);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ WidgetHubDomainsViewModel2(Long l, RestCallState restCallState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? RestCallState2.INSTANCE : restCallState);
    }
}
