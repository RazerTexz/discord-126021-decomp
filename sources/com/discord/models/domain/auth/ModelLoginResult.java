package com.discord.models.domain.auth;

import b.d.b.a.a;
import com.discord.api.auth.RequiredAction;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ModelLoginResult.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelLoginResult {
    private final boolean mfa;
    private final List<RequiredAction> requiredActions;
    private final String ticket;
    private final String token;
    private final ModelUserSettingsBootstrap userSettings;

    /* JADX WARN: Multi-variable type inference failed */
    public ModelLoginResult(boolean z2, String str, String str2, ModelUserSettingsBootstrap modelUserSettingsBootstrap, List<? extends RequiredAction> list) {
        this.mfa = z2;
        this.ticket = str;
        this.token = str2;
        this.userSettings = modelUserSettingsBootstrap;
        this.requiredActions = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelLoginResult copy$default(ModelLoginResult modelLoginResult, boolean z2, String str, String str2, ModelUserSettingsBootstrap modelUserSettingsBootstrap, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = modelLoginResult.mfa;
        }
        if ((i & 2) != 0) {
            str = modelLoginResult.ticket;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            str2 = modelLoginResult.token;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            modelUserSettingsBootstrap = modelLoginResult.userSettings;
        }
        ModelUserSettingsBootstrap modelUserSettingsBootstrap2 = modelUserSettingsBootstrap;
        if ((i & 16) != 0) {
            list = modelLoginResult.requiredActions;
        }
        return modelLoginResult.copy(z2, str3, str4, modelUserSettingsBootstrap2, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getMfa() {
        return this.mfa;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTicket() {
        return this.ticket;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final ModelUserSettingsBootstrap getUserSettings() {
        return this.userSettings;
    }

    public final List<RequiredAction> component5() {
        return this.requiredActions;
    }

    public final ModelLoginResult copy(boolean mfa, String ticket, String token, ModelUserSettingsBootstrap userSettings, List<? extends RequiredAction> requiredActions) {
        return new ModelLoginResult(mfa, ticket, token, userSettings, requiredActions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelLoginResult)) {
            return false;
        }
        ModelLoginResult modelLoginResult = (ModelLoginResult) other;
        return this.mfa == modelLoginResult.mfa && m.areEqual(this.ticket, modelLoginResult.ticket) && m.areEqual(this.token, modelLoginResult.token) && m.areEqual(this.userSettings, modelLoginResult.userSettings) && m.areEqual(this.requiredActions, modelLoginResult.requiredActions);
    }

    public final boolean getMfa() {
        return this.mfa;
    }

    public final List<RequiredAction> getRequiredActions() {
        return this.requiredActions;
    }

    public final String getTicket() {
        return this.ticket;
    }

    public final String getToken() {
        return this.token;
    }

    public final ModelUserSettingsBootstrap getUserSettings() {
        return this.userSettings;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public int hashCode() {
        boolean z2 = this.mfa;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        String str = this.ticket;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.token;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        ModelUserSettingsBootstrap modelUserSettingsBootstrap = this.userSettings;
        int iHashCode3 = (iHashCode2 + (modelUserSettingsBootstrap != null ? modelUserSettingsBootstrap.hashCode() : 0)) * 31;
        List<RequiredAction> list = this.requiredActions;
        return iHashCode3 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelLoginResult(mfa=");
        sbU.append(this.mfa);
        sbU.append(", ticket=");
        sbU.append(this.ticket);
        sbU.append(", token=");
        sbU.append(this.token);
        sbU.append(", userSettings=");
        sbU.append(this.userSettings);
        sbU.append(", requiredActions=");
        return a.L(sbU, this.requiredActions, ")");
    }

    public /* synthetic */ ModelLoginResult(boolean z2, String str, String str2, ModelUserSettingsBootstrap modelUserSettingsBootstrap, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z2, str, str2, modelUserSettingsBootstrap, list);
    }
}
