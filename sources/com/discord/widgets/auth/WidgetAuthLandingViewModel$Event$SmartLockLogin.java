package com.discord.widgets.auth;

import b.d.b.a.a;
import com.discord.utilities.auth.GoogleSmartLockManager$SmartLockCredentials;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetAuthLandingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetAuthLandingViewModel$Event$SmartLockLogin extends WidgetAuthLandingViewModel$Event {
    private final GoogleSmartLockManager$SmartLockCredentials smartLockCredentials;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthLandingViewModel$Event$SmartLockLogin(GoogleSmartLockManager$SmartLockCredentials googleSmartLockManager$SmartLockCredentials) {
        super(null);
        m.checkNotNullParameter(googleSmartLockManager$SmartLockCredentials, "smartLockCredentials");
        this.smartLockCredentials = googleSmartLockManager$SmartLockCredentials;
    }

    public static /* synthetic */ WidgetAuthLandingViewModel$Event$SmartLockLogin copy$default(WidgetAuthLandingViewModel$Event$SmartLockLogin widgetAuthLandingViewModel$Event$SmartLockLogin, GoogleSmartLockManager$SmartLockCredentials googleSmartLockManager$SmartLockCredentials, int i, Object obj) {
        if ((i & 1) != 0) {
            googleSmartLockManager$SmartLockCredentials = widgetAuthLandingViewModel$Event$SmartLockLogin.smartLockCredentials;
        }
        return widgetAuthLandingViewModel$Event$SmartLockLogin.copy(googleSmartLockManager$SmartLockCredentials);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final GoogleSmartLockManager$SmartLockCredentials getSmartLockCredentials() {
        return this.smartLockCredentials;
    }

    public final WidgetAuthLandingViewModel$Event$SmartLockLogin copy(GoogleSmartLockManager$SmartLockCredentials smartLockCredentials) {
        m.checkNotNullParameter(smartLockCredentials, "smartLockCredentials");
        return new WidgetAuthLandingViewModel$Event$SmartLockLogin(smartLockCredentials);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetAuthLandingViewModel$Event$SmartLockLogin) && m.areEqual(this.smartLockCredentials, ((WidgetAuthLandingViewModel$Event$SmartLockLogin) other).smartLockCredentials);
        }
        return true;
    }

    public final GoogleSmartLockManager$SmartLockCredentials getSmartLockCredentials() {
        return this.smartLockCredentials;
    }

    public int hashCode() {
        GoogleSmartLockManager$SmartLockCredentials googleSmartLockManager$SmartLockCredentials = this.smartLockCredentials;
        if (googleSmartLockManager$SmartLockCredentials != null) {
            return googleSmartLockManager$SmartLockCredentials.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("SmartLockLogin(smartLockCredentials=");
        sbU.append(this.smartLockCredentials);
        sbU.append(")");
        return sbU.toString();
    }
}
