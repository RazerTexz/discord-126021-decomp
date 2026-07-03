package com.discord.widgets.hubs;

import com.discord.stores.utilities.Default;
import com.discord.stores.utilities.RestCallState;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetHubDomainsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class DomainsState {
    private final Long selectedGuildId;
    private final RestCallState<Object> verifyEmailAsync;

    /* JADX WARN: Multi-variable type inference failed */
    public DomainsState() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public DomainsState(Long l, RestCallState<? extends Object> restCallState) {
        C12238m.checkNotNullParameter(restCallState, "verifyEmailAsync");
        this.selectedGuildId = l;
        this.verifyEmailAsync = restCallState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DomainsState copy$default(DomainsState domainsState, Long l, RestCallState restCallState, int i, Object obj) {
        if ((i & 1) != 0) {
            l = domainsState.selectedGuildId;
        }
        if ((i & 2) != 0) {
            restCallState = domainsState.verifyEmailAsync;
        }
        return domainsState.copy(l, restCallState);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Long getSelectedGuildId() {
        return this.selectedGuildId;
    }

    public final RestCallState<Object> component2() {
        return this.verifyEmailAsync;
    }

    public final DomainsState copy(Long selectedGuildId, RestCallState<? extends Object> verifyEmailAsync) {
        C12238m.checkNotNullParameter(verifyEmailAsync, "verifyEmailAsync");
        return new DomainsState(selectedGuildId, verifyEmailAsync);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainsState)) {
            return false;
        }
        DomainsState domainsState = (DomainsState) other;
        return C12238m.areEqual(this.selectedGuildId, domainsState.selectedGuildId) && C12238m.areEqual(this.verifyEmailAsync, domainsState.verifyEmailAsync);
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
        StringBuilder sbM833U = C1643a.m833U("DomainsState(selectedGuildId=");
        sbM833U.append(this.selectedGuildId);
        sbM833U.append(", verifyEmailAsync=");
        sbM833U.append(this.verifyEmailAsync);
        sbM833U.append(")");
        return sbM833U.toString();
    }

    public /* synthetic */ DomainsState(Long l, RestCallState restCallState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? Default.INSTANCE : restCallState);
    }
}
