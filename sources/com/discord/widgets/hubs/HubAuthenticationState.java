package com.discord.widgets.hubs;

import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.discord.api.hubs.EmailVerification;
import com.discord.api.hubs.EmailVerificationCode;
import com.discord.stores.utilities.Default;
import com.discord.stores.utilities.RestCallState;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetHubAuthenticationlViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class HubAuthenticationState {
    private final RestCallState<EmailVerificationCode> authenticationAsync;
    private final String email;
    private final RestCallState<EmailVerification> resendEmailAsync;

    public HubAuthenticationState() {
        this(null, null, null, 7, null);
    }

    public HubAuthenticationState(String str, RestCallState<EmailVerification> restCallState, RestCallState<EmailVerificationCode> restCallState2) {
        m.checkNotNullParameter(restCallState, "resendEmailAsync");
        m.checkNotNullParameter(restCallState2, "authenticationAsync");
        this.email = str;
        this.resendEmailAsync = restCallState;
        this.authenticationAsync = restCallState2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HubAuthenticationState copy$default(HubAuthenticationState hubAuthenticationState, String str, RestCallState restCallState, RestCallState restCallState2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = hubAuthenticationState.email;
        }
        if ((i & 2) != 0) {
            restCallState = hubAuthenticationState.resendEmailAsync;
        }
        if ((i & 4) != 0) {
            restCallState2 = hubAuthenticationState.authenticationAsync;
        }
        return hubAuthenticationState.copy(str, restCallState, restCallState2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    public final RestCallState<EmailVerification> component2() {
        return this.resendEmailAsync;
    }

    public final RestCallState<EmailVerificationCode> component3() {
        return this.authenticationAsync;
    }

    public final HubAuthenticationState copy(String email, RestCallState<EmailVerification> resendEmailAsync, RestCallState<EmailVerificationCode> authenticationAsync) {
        m.checkNotNullParameter(resendEmailAsync, "resendEmailAsync");
        m.checkNotNullParameter(authenticationAsync, "authenticationAsync");
        return new HubAuthenticationState(email, resendEmailAsync, authenticationAsync);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HubAuthenticationState)) {
            return false;
        }
        HubAuthenticationState hubAuthenticationState = (HubAuthenticationState) other;
        return m.areEqual(this.email, hubAuthenticationState.email) && m.areEqual(this.resendEmailAsync, hubAuthenticationState.resendEmailAsync) && m.areEqual(this.authenticationAsync, hubAuthenticationState.authenticationAsync);
    }

    public final RestCallState<EmailVerificationCode> getAuthenticationAsync() {
        return this.authenticationAsync;
    }

    public final String getEmail() {
        return this.email;
    }

    public final RestCallState<EmailVerification> getResendEmailAsync() {
        return this.resendEmailAsync;
    }

    public int hashCode() {
        String str = this.email;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        RestCallState<EmailVerification> restCallState = this.resendEmailAsync;
        int iHashCode2 = (iHashCode + (restCallState != null ? restCallState.hashCode() : 0)) * 31;
        RestCallState<EmailVerificationCode> restCallState2 = this.authenticationAsync;
        return iHashCode2 + (restCallState2 != null ? restCallState2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("HubAuthenticationState(email=");
        sbU.append(this.email);
        sbU.append(", resendEmailAsync=");
        sbU.append(this.resendEmailAsync);
        sbU.append(", authenticationAsync=");
        sbU.append(this.authenticationAsync);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ HubAuthenticationState(String str, RestCallState restCallState, RestCallState restCallState2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? Default.INSTANCE : restCallState, (i & 4) != 0 ? Default.INSTANCE : restCallState2);
    }
}
