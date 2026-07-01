package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import b.d.b.a.a;
import com.discord.utilities.error.Error;
import d0.z.d.m;

/* JADX INFO: compiled from: ServerSettingsCreatorMonetizationOnboardingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ServerSettingsCreatorMonetizationOnboardingViewModel$RequirementsState$Error extends ServerSettingsCreatorMonetizationOnboardingViewModel$RequirementsState {
    private final Error error;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsCreatorMonetizationOnboardingViewModel$RequirementsState$Error(Error error) {
        super(null);
        m.checkNotNullParameter(error, "error");
        this.error = error;
    }

    public static /* synthetic */ ServerSettingsCreatorMonetizationOnboardingViewModel$RequirementsState$Error copy$default(ServerSettingsCreatorMonetizationOnboardingViewModel$RequirementsState$Error serverSettingsCreatorMonetizationOnboardingViewModel$RequirementsState$Error, Error error, int i, Object obj) {
        if ((i & 1) != 0) {
            error = serverSettingsCreatorMonetizationOnboardingViewModel$RequirementsState$Error.error;
        }
        return serverSettingsCreatorMonetizationOnboardingViewModel$RequirementsState$Error.copy(error);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Error getError() {
        return this.error;
    }

    public final ServerSettingsCreatorMonetizationOnboardingViewModel$RequirementsState$Error copy(Error error) {
        m.checkNotNullParameter(error, "error");
        return new ServerSettingsCreatorMonetizationOnboardingViewModel$RequirementsState$Error(error);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ServerSettingsCreatorMonetizationOnboardingViewModel$RequirementsState$Error) && m.areEqual(this.error, ((ServerSettingsCreatorMonetizationOnboardingViewModel$RequirementsState$Error) other).error);
        }
        return true;
    }

    public final Error getError() {
        return this.error;
    }

    public int hashCode() {
        Error error = this.error;
        if (error != null) {
            return error.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Error(error=");
        sbU.append(this.error);
        sbU.append(")");
        return sbU.toString();
    }
}
