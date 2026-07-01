package com.discord.widgets.auth;

import b.d.b.a.a;
import com.discord.models.domain.ModelInvite;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetAuthLandingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetAuthLandingViewModel$ViewState$Invite extends WidgetAuthLandingViewModel$ViewState {
    private final String ageGateError;
    private final ModelInvite invite;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthLandingViewModel$ViewState$Invite(ModelInvite modelInvite, String str) {
        super(str, null);
        m.checkNotNullParameter(modelInvite, "invite");
        this.invite = modelInvite;
        this.ageGateError = str;
    }

    public static /* synthetic */ WidgetAuthLandingViewModel$ViewState$Invite copy$default(WidgetAuthLandingViewModel$ViewState$Invite widgetAuthLandingViewModel$ViewState$Invite, ModelInvite modelInvite, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            modelInvite = widgetAuthLandingViewModel$ViewState$Invite.invite;
        }
        if ((i & 2) != 0) {
            str = widgetAuthLandingViewModel$ViewState$Invite.getAgeGateError();
        }
        return widgetAuthLandingViewModel$ViewState$Invite.copy(modelInvite, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelInvite getInvite() {
        return this.invite;
    }

    public final String component2() {
        return getAgeGateError();
    }

    public final WidgetAuthLandingViewModel$ViewState$Invite copy(ModelInvite invite, String ageGateError) {
        m.checkNotNullParameter(invite, "invite");
        return new WidgetAuthLandingViewModel$ViewState$Invite(invite, ageGateError);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetAuthLandingViewModel$ViewState$Invite)) {
            return false;
        }
        WidgetAuthLandingViewModel$ViewState$Invite widgetAuthLandingViewModel$ViewState$Invite = (WidgetAuthLandingViewModel$ViewState$Invite) other;
        return m.areEqual(this.invite, widgetAuthLandingViewModel$ViewState$Invite.invite) && m.areEqual(getAgeGateError(), widgetAuthLandingViewModel$ViewState$Invite.getAgeGateError());
    }

    @Override // com.discord.widgets.auth.WidgetAuthLandingViewModel$ViewState
    public String getAgeGateError() {
        return this.ageGateError;
    }

    public final ModelInvite getInvite() {
        return this.invite;
    }

    public int hashCode() {
        ModelInvite modelInvite = this.invite;
        int iHashCode = (modelInvite != null ? modelInvite.hashCode() : 0) * 31;
        String ageGateError = getAgeGateError();
        return iHashCode + (ageGateError != null ? ageGateError.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Invite(invite=");
        sbU.append(this.invite);
        sbU.append(", ageGateError=");
        sbU.append(getAgeGateError());
        sbU.append(")");
        return sbU.toString();
    }
}
