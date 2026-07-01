package com.discord.widgets.settings.account;

import b.d.b.a.a;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreMFA$State;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettingsAccount.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetSettingsAccount$Model {
    public static final WidgetSettingsAccount$Model$Companion Companion = new WidgetSettingsAccount$Model$Companion(null);
    private final ConnectedAccount contactSyncConnection;
    private final MeUser meUser;
    private final boolean ownsAnyGuilds;
    private final StoreMFA$State pendingMFAState;

    public WidgetSettingsAccount$Model(MeUser meUser, StoreMFA$State storeMFA$State, boolean z2, ConnectedAccount connectedAccount) {
        m.checkNotNullParameter(meUser, "meUser");
        m.checkNotNullParameter(storeMFA$State, "pendingMFAState");
        this.meUser = meUser;
        this.pendingMFAState = storeMFA$State;
        this.ownsAnyGuilds = z2;
        this.contactSyncConnection = connectedAccount;
    }

    public static /* synthetic */ WidgetSettingsAccount$Model copy$default(WidgetSettingsAccount$Model widgetSettingsAccount$Model, MeUser meUser, StoreMFA$State storeMFA$State, boolean z2, ConnectedAccount connectedAccount, int i, Object obj) {
        if ((i & 1) != 0) {
            meUser = widgetSettingsAccount$Model.meUser;
        }
        if ((i & 2) != 0) {
            storeMFA$State = widgetSettingsAccount$Model.pendingMFAState;
        }
        if ((i & 4) != 0) {
            z2 = widgetSettingsAccount$Model.ownsAnyGuilds;
        }
        if ((i & 8) != 0) {
            connectedAccount = widgetSettingsAccount$Model.contactSyncConnection;
        }
        return widgetSettingsAccount$Model.copy(meUser, storeMFA$State, z2, connectedAccount);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MeUser getMeUser() {
        return this.meUser;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final StoreMFA$State getPendingMFAState() {
        return this.pendingMFAState;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getOwnsAnyGuilds() {
        return this.ownsAnyGuilds;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final ConnectedAccount getContactSyncConnection() {
        return this.contactSyncConnection;
    }

    public final WidgetSettingsAccount$Model copy(MeUser meUser, StoreMFA$State pendingMFAState, boolean ownsAnyGuilds, ConnectedAccount contactSyncConnection) {
        m.checkNotNullParameter(meUser, "meUser");
        m.checkNotNullParameter(pendingMFAState, "pendingMFAState");
        return new WidgetSettingsAccount$Model(meUser, pendingMFAState, ownsAnyGuilds, contactSyncConnection);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetSettingsAccount$Model)) {
            return false;
        }
        WidgetSettingsAccount$Model widgetSettingsAccount$Model = (WidgetSettingsAccount$Model) other;
        return m.areEqual(this.meUser, widgetSettingsAccount$Model.meUser) && m.areEqual(this.pendingMFAState, widgetSettingsAccount$Model.pendingMFAState) && this.ownsAnyGuilds == widgetSettingsAccount$Model.ownsAnyGuilds && m.areEqual(this.contactSyncConnection, widgetSettingsAccount$Model.contactSyncConnection);
    }

    public final ConnectedAccount getContactSyncConnection() {
        return this.contactSyncConnection;
    }

    public final MeUser getMeUser() {
        return this.meUser;
    }

    public final boolean getOwnsAnyGuilds() {
        return this.ownsAnyGuilds;
    }

    public final StoreMFA$State getPendingMFAState() {
        return this.pendingMFAState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public int hashCode() {
        MeUser meUser = this.meUser;
        int iHashCode = (meUser != null ? meUser.hashCode() : 0) * 31;
        StoreMFA$State storeMFA$State = this.pendingMFAState;
        int iHashCode2 = (iHashCode + (storeMFA$State != null ? storeMFA$State.hashCode() : 0)) * 31;
        boolean z2 = this.ownsAnyGuilds;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode2 + r2) * 31;
        ConnectedAccount connectedAccount = this.contactSyncConnection;
        return i + (connectedAccount != null ? connectedAccount.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(meUser=");
        sbU.append(this.meUser);
        sbU.append(", pendingMFAState=");
        sbU.append(this.pendingMFAState);
        sbU.append(", ownsAnyGuilds=");
        sbU.append(this.ownsAnyGuilds);
        sbU.append(", contactSyncConnection=");
        sbU.append(this.contactSyncConnection);
        sbU.append(")");
        return sbU.toString();
    }
}
