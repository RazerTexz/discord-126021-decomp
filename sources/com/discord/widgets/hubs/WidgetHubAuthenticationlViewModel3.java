package com.discord.widgets.hubs;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.hubs.EmailVerification;
import com.discord.api.hubs.EmailVerification2;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallState2;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.discord.widgets.hubs.HubAuthenticationState, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubAuthenticationlViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetHubAuthenticationlViewModel3 {
    private final RestCallState<EmailVerification2> authenticationAsync;
    private final String email;
    private final RestCallState<EmailVerification> resendEmailAsync;

    public WidgetHubAuthenticationlViewModel3() {
        this(null, null, null, 7, null);
    }

    public WidgetHubAuthenticationlViewModel3(String str, RestCallState<EmailVerification> restCallState, RestCallState<EmailVerification2> restCallState2) {
        Intrinsics3.checkNotNullParameter(restCallState, "resendEmailAsync");
        Intrinsics3.checkNotNullParameter(restCallState2, "authenticationAsync");
        this.email = str;
        this.resendEmailAsync = restCallState;
        this.authenticationAsync = restCallState2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetHubAuthenticationlViewModel3 copy$default(WidgetHubAuthenticationlViewModel3 widgetHubAuthenticationlViewModel3, String str, RestCallState restCallState, RestCallState restCallState2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = widgetHubAuthenticationlViewModel3.email;
        }
        if ((i & 2) != 0) {
            restCallState = widgetHubAuthenticationlViewModel3.resendEmailAsync;
        }
        if ((i & 4) != 0) {
            restCallState2 = widgetHubAuthenticationlViewModel3.authenticationAsync;
        }
        return widgetHubAuthenticationlViewModel3.copy(str, restCallState, restCallState2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    public final RestCallState<EmailVerification> component2() {
        return this.resendEmailAsync;
    }

    public final RestCallState<EmailVerification2> component3() {
        return this.authenticationAsync;
    }

    public final WidgetHubAuthenticationlViewModel3 copy(String email, RestCallState<EmailVerification> resendEmailAsync, RestCallState<EmailVerification2> authenticationAsync) {
        Intrinsics3.checkNotNullParameter(resendEmailAsync, "resendEmailAsync");
        Intrinsics3.checkNotNullParameter(authenticationAsync, "authenticationAsync");
        return new WidgetHubAuthenticationlViewModel3(email, resendEmailAsync, authenticationAsync);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetHubAuthenticationlViewModel3)) {
            return false;
        }
        WidgetHubAuthenticationlViewModel3 widgetHubAuthenticationlViewModel3 = (WidgetHubAuthenticationlViewModel3) other;
        return Intrinsics3.areEqual(this.email, widgetHubAuthenticationlViewModel3.email) && Intrinsics3.areEqual(this.resendEmailAsync, widgetHubAuthenticationlViewModel3.resendEmailAsync) && Intrinsics3.areEqual(this.authenticationAsync, widgetHubAuthenticationlViewModel3.authenticationAsync);
    }

    public final RestCallState<EmailVerification2> getAuthenticationAsync() {
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
        RestCallState<EmailVerification2> restCallState2 = this.authenticationAsync;
        return iHashCode2 + (restCallState2 != null ? restCallState2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("HubAuthenticationState(email=");
        sbU.append(this.email);
        sbU.append(", resendEmailAsync=");
        sbU.append(this.resendEmailAsync);
        sbU.append(", authenticationAsync=");
        sbU.append(this.authenticationAsync);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ WidgetHubAuthenticationlViewModel3(String str, RestCallState restCallState, RestCallState restCallState2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? RestCallState2.INSTANCE : restCallState, (i & 4) != 0 ? RestCallState2.INSTANCE : restCallState2);
    }
}
