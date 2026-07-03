package com.discord.widgets.hubs;

import androidx.core.app.NotificationCompat;
import com.discord.api.hubs.EmailVerification;
import com.discord.stores.utilities.Default;
import com.discord.stores.utilities.RestCallState;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetHubEmailViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class HubEmailState {
    private final String email;

    /* JADX INFO: renamed from: hasMultipleDomains$delegate, reason: from kotlin metadata */
    private final Lazy hasMultipleDomains;
    private final Long selectedGuildId;
    private final RestCallState<EmailVerification> verifyEmailAsync;
    private final HubWaitlistResult waitlistResult;

    public HubEmailState() {
        this(null, null, null, null, 15, null);
    }

    public HubEmailState(String str, Long l, HubWaitlistResult hubWaitlistResult, RestCallState<EmailVerification> restCallState) {
        C12238m.checkNotNullParameter(restCallState, "verifyEmailAsync");
        this.email = str;
        this.selectedGuildId = l;
        this.waitlistResult = hubWaitlistResult;
        this.verifyEmailAsync = restCallState;
        this.hasMultipleDomains = C12083g.lazy(new HubEmailState$hasMultipleDomains$2(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HubEmailState copy$default(HubEmailState hubEmailState, String str, Long l, HubWaitlistResult hubWaitlistResult, RestCallState restCallState, int i, Object obj) {
        if ((i & 1) != 0) {
            str = hubEmailState.email;
        }
        if ((i & 2) != 0) {
            l = hubEmailState.selectedGuildId;
        }
        if ((i & 4) != 0) {
            hubWaitlistResult = hubEmailState.waitlistResult;
        }
        if ((i & 8) != 0) {
            restCallState = hubEmailState.verifyEmailAsync;
        }
        return hubEmailState.copy(str, l, hubWaitlistResult, restCallState);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getSelectedGuildId() {
        return this.selectedGuildId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final HubWaitlistResult getWaitlistResult() {
        return this.waitlistResult;
    }

    public final RestCallState<EmailVerification> component4() {
        return this.verifyEmailAsync;
    }

    public final HubEmailState copy(String email, Long selectedGuildId, HubWaitlistResult waitlistResult, RestCallState<EmailVerification> verifyEmailAsync) {
        C12238m.checkNotNullParameter(verifyEmailAsync, "verifyEmailAsync");
        return new HubEmailState(email, selectedGuildId, waitlistResult, verifyEmailAsync);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HubEmailState)) {
            return false;
        }
        HubEmailState hubEmailState = (HubEmailState) other;
        return C12238m.areEqual(this.email, hubEmailState.email) && C12238m.areEqual(this.selectedGuildId, hubEmailState.selectedGuildId) && C12238m.areEqual(this.waitlistResult, hubEmailState.waitlistResult) && C12238m.areEqual(this.verifyEmailAsync, hubEmailState.verifyEmailAsync);
    }

    public final String getEmail() {
        return this.email;
    }

    public final boolean getHasMultipleDomains() {
        return ((Boolean) this.hasMultipleDomains.getValue()).booleanValue();
    }

    public final Long getSelectedGuildId() {
        return this.selectedGuildId;
    }

    public final RestCallState<EmailVerification> getVerifyEmailAsync() {
        return this.verifyEmailAsync;
    }

    public final HubWaitlistResult getWaitlistResult() {
        return this.waitlistResult;
    }

    public int hashCode() {
        String str = this.email;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Long l = this.selectedGuildId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        HubWaitlistResult hubWaitlistResult = this.waitlistResult;
        int iHashCode3 = (iHashCode2 + (hubWaitlistResult != null ? hubWaitlistResult.hashCode() : 0)) * 31;
        RestCallState<EmailVerification> restCallState = this.verifyEmailAsync;
        return iHashCode3 + (restCallState != null ? restCallState.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("HubEmailState(email=");
        sbM833U.append(this.email);
        sbM833U.append(", selectedGuildId=");
        sbM833U.append(this.selectedGuildId);
        sbM833U.append(", waitlistResult=");
        sbM833U.append(this.waitlistResult);
        sbM833U.append(", verifyEmailAsync=");
        sbM833U.append(this.verifyEmailAsync);
        sbM833U.append(")");
        return sbM833U.toString();
    }

    public /* synthetic */ HubEmailState(String str, Long l, HubWaitlistResult hubWaitlistResult, RestCallState restCallState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : hubWaitlistResult, (i & 8) != 0 ? Default.INSTANCE : restCallState);
    }
}
