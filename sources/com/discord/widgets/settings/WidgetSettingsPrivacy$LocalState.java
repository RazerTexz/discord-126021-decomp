package com.discord.widgets.settings;

import b.d.b.a.a;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.models.domain.ModelUserSettings$FriendSourceFlags;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.user.MeUser;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetSettingsPrivacy$LocalState {
    private final ConnectedAccount contactSyncConnection;
    private final Experiment contactSyncExperiment;
    private final boolean defaultRestrictedGuilds;
    private final int explicitContentFilter;
    private final ModelUserSettings$FriendSourceFlags friendSourceFlags;
    private final MeUser me;
    private final int userDiscoveryFlags;

    public WidgetSettingsPrivacy$LocalState(MeUser meUser, int i, boolean z2, ModelUserSettings$FriendSourceFlags modelUserSettings$FriendSourceFlags, ConnectedAccount connectedAccount, Experiment experiment, int i2) {
        m.checkNotNullParameter(meUser, "me");
        this.me = meUser;
        this.explicitContentFilter = i;
        this.defaultRestrictedGuilds = z2;
        this.friendSourceFlags = modelUserSettings$FriendSourceFlags;
        this.contactSyncConnection = connectedAccount;
        this.contactSyncExperiment = experiment;
        this.userDiscoveryFlags = i2;
    }

    public static /* synthetic */ WidgetSettingsPrivacy$LocalState copy$default(WidgetSettingsPrivacy$LocalState widgetSettingsPrivacy$LocalState, MeUser meUser, int i, boolean z2, ModelUserSettings$FriendSourceFlags modelUserSettings$FriendSourceFlags, ConnectedAccount connectedAccount, Experiment experiment, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            meUser = widgetSettingsPrivacy$LocalState.me;
        }
        if ((i3 & 2) != 0) {
            i = widgetSettingsPrivacy$LocalState.explicitContentFilter;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            z2 = widgetSettingsPrivacy$LocalState.defaultRestrictedGuilds;
        }
        boolean z3 = z2;
        if ((i3 & 8) != 0) {
            modelUserSettings$FriendSourceFlags = widgetSettingsPrivacy$LocalState.friendSourceFlags;
        }
        ModelUserSettings$FriendSourceFlags modelUserSettings$FriendSourceFlags2 = modelUserSettings$FriendSourceFlags;
        if ((i3 & 16) != 0) {
            connectedAccount = widgetSettingsPrivacy$LocalState.contactSyncConnection;
        }
        ConnectedAccount connectedAccount2 = connectedAccount;
        if ((i3 & 32) != 0) {
            experiment = widgetSettingsPrivacy$LocalState.contactSyncExperiment;
        }
        Experiment experiment2 = experiment;
        if ((i3 & 64) != 0) {
            i2 = widgetSettingsPrivacy$LocalState.userDiscoveryFlags;
        }
        return widgetSettingsPrivacy$LocalState.copy(meUser, i4, z3, modelUserSettings$FriendSourceFlags2, connectedAccount2, experiment2, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MeUser getMe() {
        return this.me;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getExplicitContentFilter() {
        return this.explicitContentFilter;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getDefaultRestrictedGuilds() {
        return this.defaultRestrictedGuilds;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final ModelUserSettings$FriendSourceFlags getFriendSourceFlags() {
        return this.friendSourceFlags;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final ConnectedAccount getContactSyncConnection() {
        return this.contactSyncConnection;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Experiment getContactSyncExperiment() {
        return this.contactSyncExperiment;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getUserDiscoveryFlags() {
        return this.userDiscoveryFlags;
    }

    public final WidgetSettingsPrivacy$LocalState copy(MeUser me2, int explicitContentFilter, boolean defaultRestrictedGuilds, ModelUserSettings$FriendSourceFlags friendSourceFlags, ConnectedAccount contactSyncConnection, Experiment contactSyncExperiment, int userDiscoveryFlags) {
        m.checkNotNullParameter(me2, "me");
        return new WidgetSettingsPrivacy$LocalState(me2, explicitContentFilter, defaultRestrictedGuilds, friendSourceFlags, contactSyncConnection, contactSyncExperiment, userDiscoveryFlags);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetSettingsPrivacy$LocalState)) {
            return false;
        }
        WidgetSettingsPrivacy$LocalState widgetSettingsPrivacy$LocalState = (WidgetSettingsPrivacy$LocalState) other;
        return m.areEqual(this.me, widgetSettingsPrivacy$LocalState.me) && this.explicitContentFilter == widgetSettingsPrivacy$LocalState.explicitContentFilter && this.defaultRestrictedGuilds == widgetSettingsPrivacy$LocalState.defaultRestrictedGuilds && m.areEqual(this.friendSourceFlags, widgetSettingsPrivacy$LocalState.friendSourceFlags) && m.areEqual(this.contactSyncConnection, widgetSettingsPrivacy$LocalState.contactSyncConnection) && m.areEqual(this.contactSyncExperiment, widgetSettingsPrivacy$LocalState.contactSyncExperiment) && this.userDiscoveryFlags == widgetSettingsPrivacy$LocalState.userDiscoveryFlags;
    }

    public final ConnectedAccount getContactSyncConnection() {
        return this.contactSyncConnection;
    }

    public final Experiment getContactSyncExperiment() {
        return this.contactSyncExperiment;
    }

    public final boolean getDefaultRestrictedGuilds() {
        return this.defaultRestrictedGuilds;
    }

    public final int getExplicitContentFilter() {
        return this.explicitContentFilter;
    }

    public final ModelUserSettings$FriendSourceFlags getFriendSourceFlags() {
        return this.friendSourceFlags;
    }

    public final MeUser getMe() {
        return this.me;
    }

    public final int getUserDiscoveryFlags() {
        return this.userDiscoveryFlags;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    public int hashCode() {
        MeUser meUser = this.me;
        int iHashCode = (((meUser != null ? meUser.hashCode() : 0) * 31) + this.explicitContentFilter) * 31;
        boolean z2 = this.defaultRestrictedGuilds;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode + r2) * 31;
        ModelUserSettings$FriendSourceFlags modelUserSettings$FriendSourceFlags = this.friendSourceFlags;
        int iHashCode2 = (i + (modelUserSettings$FriendSourceFlags != null ? modelUserSettings$FriendSourceFlags.hashCode() : 0)) * 31;
        ConnectedAccount connectedAccount = this.contactSyncConnection;
        int iHashCode3 = (iHashCode2 + (connectedAccount != null ? connectedAccount.hashCode() : 0)) * 31;
        Experiment experiment = this.contactSyncExperiment;
        return ((iHashCode3 + (experiment != null ? experiment.hashCode() : 0)) * 31) + this.userDiscoveryFlags;
    }

    public String toString() {
        StringBuilder sbU = a.U("LocalState(me=");
        sbU.append(this.me);
        sbU.append(", explicitContentFilter=");
        sbU.append(this.explicitContentFilter);
        sbU.append(", defaultRestrictedGuilds=");
        sbU.append(this.defaultRestrictedGuilds);
        sbU.append(", friendSourceFlags=");
        sbU.append(this.friendSourceFlags);
        sbU.append(", contactSyncConnection=");
        sbU.append(this.contactSyncConnection);
        sbU.append(", contactSyncExperiment=");
        sbU.append(this.contactSyncExperiment);
        sbU.append(", userDiscoveryFlags=");
        return a.B(sbU, this.userDiscoveryFlags, ")");
    }
}
