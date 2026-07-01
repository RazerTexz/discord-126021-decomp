package com.discord.widgets.auth;

import b.d.b.a.a;
import com.discord.models.domain.ModelInvite;
import com.discord.stores.StoreGuildTemplates$GuildTemplateState;
import com.discord.stores.StoreInviteSettings$InviteCode;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetAuthLandingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetAuthLandingViewModel$StoreState {
    private final String ageGateError;
    private final StoreGuildTemplates$GuildTemplateState guildTemplateState;
    private final ModelInvite invite;
    private final StoreInviteSettings$InviteCode inviteCode;

    public WidgetAuthLandingViewModel$StoreState(StoreInviteSettings$InviteCode storeInviteSettings$InviteCode, ModelInvite modelInvite, StoreGuildTemplates$GuildTemplateState storeGuildTemplates$GuildTemplateState, String str) {
        m.checkNotNullParameter(storeGuildTemplates$GuildTemplateState, "guildTemplateState");
        this.inviteCode = storeInviteSettings$InviteCode;
        this.invite = modelInvite;
        this.guildTemplateState = storeGuildTemplates$GuildTemplateState;
        this.ageGateError = str;
    }

    public static /* synthetic */ WidgetAuthLandingViewModel$StoreState copy$default(WidgetAuthLandingViewModel$StoreState widgetAuthLandingViewModel$StoreState, StoreInviteSettings$InviteCode storeInviteSettings$InviteCode, ModelInvite modelInvite, StoreGuildTemplates$GuildTemplateState storeGuildTemplates$GuildTemplateState, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            storeInviteSettings$InviteCode = widgetAuthLandingViewModel$StoreState.inviteCode;
        }
        if ((i & 2) != 0) {
            modelInvite = widgetAuthLandingViewModel$StoreState.invite;
        }
        if ((i & 4) != 0) {
            storeGuildTemplates$GuildTemplateState = widgetAuthLandingViewModel$StoreState.guildTemplateState;
        }
        if ((i & 8) != 0) {
            str = widgetAuthLandingViewModel$StoreState.ageGateError;
        }
        return widgetAuthLandingViewModel$StoreState.copy(storeInviteSettings$InviteCode, modelInvite, storeGuildTemplates$GuildTemplateState, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StoreInviteSettings$InviteCode getInviteCode() {
        return this.inviteCode;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ModelInvite getInvite() {
        return this.invite;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final StoreGuildTemplates$GuildTemplateState getGuildTemplateState() {
        return this.guildTemplateState;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAgeGateError() {
        return this.ageGateError;
    }

    public final WidgetAuthLandingViewModel$StoreState copy(StoreInviteSettings$InviteCode inviteCode, ModelInvite invite, StoreGuildTemplates$GuildTemplateState guildTemplateState, String ageGateError) {
        m.checkNotNullParameter(guildTemplateState, "guildTemplateState");
        return new WidgetAuthLandingViewModel$StoreState(inviteCode, invite, guildTemplateState, ageGateError);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetAuthLandingViewModel$StoreState)) {
            return false;
        }
        WidgetAuthLandingViewModel$StoreState widgetAuthLandingViewModel$StoreState = (WidgetAuthLandingViewModel$StoreState) other;
        return m.areEqual(this.inviteCode, widgetAuthLandingViewModel$StoreState.inviteCode) && m.areEqual(this.invite, widgetAuthLandingViewModel$StoreState.invite) && m.areEqual(this.guildTemplateState, widgetAuthLandingViewModel$StoreState.guildTemplateState) && m.areEqual(this.ageGateError, widgetAuthLandingViewModel$StoreState.ageGateError);
    }

    public final String getAgeGateError() {
        return this.ageGateError;
    }

    public final StoreGuildTemplates$GuildTemplateState getGuildTemplateState() {
        return this.guildTemplateState;
    }

    public final ModelInvite getInvite() {
        return this.invite;
    }

    public final StoreInviteSettings$InviteCode getInviteCode() {
        return this.inviteCode;
    }

    public int hashCode() {
        StoreInviteSettings$InviteCode storeInviteSettings$InviteCode = this.inviteCode;
        int iHashCode = (storeInviteSettings$InviteCode != null ? storeInviteSettings$InviteCode.hashCode() : 0) * 31;
        ModelInvite modelInvite = this.invite;
        int iHashCode2 = (iHashCode + (modelInvite != null ? modelInvite.hashCode() : 0)) * 31;
        StoreGuildTemplates$GuildTemplateState storeGuildTemplates$GuildTemplateState = this.guildTemplateState;
        int iHashCode3 = (iHashCode2 + (storeGuildTemplates$GuildTemplateState != null ? storeGuildTemplates$GuildTemplateState.hashCode() : 0)) * 31;
        String str = this.ageGateError;
        return iHashCode3 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(inviteCode=");
        sbU.append(this.inviteCode);
        sbU.append(", invite=");
        sbU.append(this.invite);
        sbU.append(", guildTemplateState=");
        sbU.append(this.guildTemplateState);
        sbU.append(", ageGateError=");
        return a.J(sbU, this.ageGateError, ")");
    }
}
