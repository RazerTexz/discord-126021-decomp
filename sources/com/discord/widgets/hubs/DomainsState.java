package com.discord.widgets.hubs;

import b.d.b.a.a;
import com.discord.stores.utilities.Default;
import com.discord.stores.utilities.RestCallState;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetHubDomainsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class DomainsState {
    private final Long selectedGuildId;
    private final RestCallState<Object> verifyEmailAsync;

    public DomainsState() {
        this(null, null, 3, null);
    }

    public DomainsState(Long l, RestCallState<? extends Object> restCallState) {
        m.checkNotNullParameter(restCallState, "verifyEmailAsync");
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
        m.checkNotNullParameter(verifyEmailAsync, "verifyEmailAsync");
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
        return m.areEqual(this.selectedGuildId, domainsState.selectedGuildId) && m.areEqual(this.verifyEmailAsync, domainsState.verifyEmailAsync);
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
        StringBuilder sbU = a.U("DomainsState(selectedGuildId=");
        sbU.append(this.selectedGuildId);
        sbU.append(", verifyEmailAsync=");
        sbU.append(this.verifyEmailAsync);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ DomainsState(Long l, RestCallState restCallState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? Default.INSTANCE : restCallState);
    }
}
