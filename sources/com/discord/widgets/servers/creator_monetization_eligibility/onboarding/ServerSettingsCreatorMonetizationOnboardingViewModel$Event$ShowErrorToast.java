package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: ServerSettingsCreatorMonetizationOnboardingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ServerSettingsCreatorMonetizationOnboardingViewModel$Event$ShowErrorToast extends ServerSettingsCreatorMonetizationOnboardingViewModel$Event {
    private final Throwable error;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsCreatorMonetizationOnboardingViewModel$Event$ShowErrorToast(Throwable th) {
        super(null);
        m.checkNotNullParameter(th, "error");
        this.error = th;
    }

    public static /* synthetic */ ServerSettingsCreatorMonetizationOnboardingViewModel$Event$ShowErrorToast copy$default(ServerSettingsCreatorMonetizationOnboardingViewModel$Event$ShowErrorToast serverSettingsCreatorMonetizationOnboardingViewModel$Event$ShowErrorToast, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            th = serverSettingsCreatorMonetizationOnboardingViewModel$Event$ShowErrorToast.error;
        }
        return serverSettingsCreatorMonetizationOnboardingViewModel$Event$ShowErrorToast.copy(th);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Throwable getError() {
        return this.error;
    }

    public final ServerSettingsCreatorMonetizationOnboardingViewModel$Event$ShowErrorToast copy(Throwable error) {
        m.checkNotNullParameter(error, "error");
        return new ServerSettingsCreatorMonetizationOnboardingViewModel$Event$ShowErrorToast(error);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ServerSettingsCreatorMonetizationOnboardingViewModel$Event$ShowErrorToast) && m.areEqual(this.error, ((ServerSettingsCreatorMonetizationOnboardingViewModel$Event$ShowErrorToast) other).error);
        }
        return true;
    }

    public final Throwable getError() {
        return this.error;
    }

    public int hashCode() {
        Throwable th = this.error;
        if (th != null) {
            return th.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("ShowErrorToast(error=");
        sbU.append(this.error);
        sbU.append(")");
        return sbU.toString();
    }
}
