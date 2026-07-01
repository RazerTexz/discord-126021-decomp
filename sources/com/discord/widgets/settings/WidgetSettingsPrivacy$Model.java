package com.discord.widgets.settings;

import b.d.b.a.a;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.models.domain.Consents;
import com.discord.models.domain.ModelUserSettings$FriendSourceFlags;
import com.discord.models.user.MeUser;
import com.discord.utilities.rest.RestAPI$HarvestState;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetSettingsPrivacy$Model {
    public static final WidgetSettingsPrivacy$Model$Companion Companion = new WidgetSettingsPrivacy$Model$Companion(null);
    private final Consents consents;
    private final ConnectedAccount contactSyncConnection;
    private final boolean defaultRestrictedGuilds;
    private final int explicitContentFilter;
    private final ModelUserSettings$FriendSourceFlags friendSourceFlags;
    private final RestAPI$HarvestState harvestState;
    private final MeUser me;
    private final boolean showContactSync;
    private final int userDiscoveryFlags;

    public WidgetSettingsPrivacy$Model(MeUser meUser, int i, boolean z2, ModelUserSettings$FriendSourceFlags modelUserSettings$FriendSourceFlags, int i2, ConnectedAccount connectedAccount, boolean z3, Consents consents, RestAPI$HarvestState restAPI$HarvestState) {
        m.checkNotNullParameter(meUser, "me");
        m.checkNotNullParameter(consents, "consents");
        this.me = meUser;
        this.explicitContentFilter = i;
        this.defaultRestrictedGuilds = z2;
        this.friendSourceFlags = modelUserSettings$FriendSourceFlags;
        this.userDiscoveryFlags = i2;
        this.contactSyncConnection = connectedAccount;
        this.showContactSync = z3;
        this.consents = consents;
        this.harvestState = restAPI$HarvestState;
    }

    public static /* synthetic */ WidgetSettingsPrivacy$Model copy$default(WidgetSettingsPrivacy$Model widgetSettingsPrivacy$Model, MeUser meUser, int i, boolean z2, ModelUserSettings$FriendSourceFlags modelUserSettings$FriendSourceFlags, int i2, ConnectedAccount connectedAccount, boolean z3, Consents consents, RestAPI$HarvestState restAPI$HarvestState, int i3, Object obj) {
        return widgetSettingsPrivacy$Model.copy((i3 & 1) != 0 ? widgetSettingsPrivacy$Model.me : meUser, (i3 & 2) != 0 ? widgetSettingsPrivacy$Model.explicitContentFilter : i, (i3 & 4) != 0 ? widgetSettingsPrivacy$Model.defaultRestrictedGuilds : z2, (i3 & 8) != 0 ? widgetSettingsPrivacy$Model.friendSourceFlags : modelUserSettings$FriendSourceFlags, (i3 & 16) != 0 ? widgetSettingsPrivacy$Model.userDiscoveryFlags : i2, (i3 & 32) != 0 ? widgetSettingsPrivacy$Model.contactSyncConnection : connectedAccount, (i3 & 64) != 0 ? widgetSettingsPrivacy$Model.showContactSync : z3, (i3 & 128) != 0 ? widgetSettingsPrivacy$Model.consents : consents, (i3 & 256) != 0 ? widgetSettingsPrivacy$Model.harvestState : restAPI$HarvestState);
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
    public final int getUserDiscoveryFlags() {
        return this.userDiscoveryFlags;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final ConnectedAccount getContactSyncConnection() {
        return this.contactSyncConnection;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getShowContactSync() {
        return this.showContactSync;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Consents getConsents() {
        return this.consents;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final RestAPI$HarvestState getHarvestState() {
        return this.harvestState;
    }

    public final WidgetSettingsPrivacy$Model copy(MeUser me2, int explicitContentFilter, boolean defaultRestrictedGuilds, ModelUserSettings$FriendSourceFlags friendSourceFlags, int userDiscoveryFlags, ConnectedAccount contactSyncConnection, boolean showContactSync, Consents consents, RestAPI$HarvestState harvestState) {
        m.checkNotNullParameter(me2, "me");
        m.checkNotNullParameter(consents, "consents");
        return new WidgetSettingsPrivacy$Model(me2, explicitContentFilter, defaultRestrictedGuilds, friendSourceFlags, userDiscoveryFlags, contactSyncConnection, showContactSync, consents, harvestState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetSettingsPrivacy$Model)) {
            return false;
        }
        WidgetSettingsPrivacy$Model widgetSettingsPrivacy$Model = (WidgetSettingsPrivacy$Model) other;
        return m.areEqual(this.me, widgetSettingsPrivacy$Model.me) && this.explicitContentFilter == widgetSettingsPrivacy$Model.explicitContentFilter && this.defaultRestrictedGuilds == widgetSettingsPrivacy$Model.defaultRestrictedGuilds && m.areEqual(this.friendSourceFlags, widgetSettingsPrivacy$Model.friendSourceFlags) && this.userDiscoveryFlags == widgetSettingsPrivacy$Model.userDiscoveryFlags && m.areEqual(this.contactSyncConnection, widgetSettingsPrivacy$Model.contactSyncConnection) && this.showContactSync == widgetSettingsPrivacy$Model.showContactSync && m.areEqual(this.consents, widgetSettingsPrivacy$Model.consents) && m.areEqual(this.harvestState, widgetSettingsPrivacy$Model.harvestState);
    }

    public final Consents getConsents() {
        return this.consents;
    }

    public final ConnectedAccount getContactSyncConnection() {
        return this.contactSyncConnection;
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

    public final RestAPI$HarvestState getHarvestState() {
        return this.harvestState;
    }

    public final MeUser getMe() {
        return this.me;
    }

    public final boolean getShowContactSync() {
        return this.showContactSync;
    }

    public final int getUserDiscoveryFlags() {
        return this.userDiscoveryFlags;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
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
        int iHashCode2 = (((i + (modelUserSettings$FriendSourceFlags != null ? modelUserSettings$FriendSourceFlags.hashCode() : 0)) * 31) + this.userDiscoveryFlags) * 31;
        ConnectedAccount connectedAccount = this.contactSyncConnection;
        int iHashCode3 = (iHashCode2 + (connectedAccount != null ? connectedAccount.hashCode() : 0)) * 31;
        boolean z3 = this.showContactSync;
        int i2 = (iHashCode3 + (z3 ? 1 : z3)) * 31;
        Consents consents = this.consents;
        int iHashCode4 = (i2 + (consents != null ? consents.hashCode() : 0)) * 31;
        RestAPI$HarvestState restAPI$HarvestState = this.harvestState;
        return iHashCode4 + (restAPI$HarvestState != null ? restAPI$HarvestState.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(me=");
        sbU.append(this.me);
        sbU.append(", explicitContentFilter=");
        sbU.append(this.explicitContentFilter);
        sbU.append(", defaultRestrictedGuilds=");
        sbU.append(this.defaultRestrictedGuilds);
        sbU.append(", friendSourceFlags=");
        sbU.append(this.friendSourceFlags);
        sbU.append(", userDiscoveryFlags=");
        sbU.append(this.userDiscoveryFlags);
        sbU.append(", contactSyncConnection=");
        sbU.append(this.contactSyncConnection);
        sbU.append(", showContactSync=");
        sbU.append(this.showContactSync);
        sbU.append(", consents=");
        sbU.append(this.consents);
        sbU.append(", harvestState=");
        sbU.append(this.harvestState);
        sbU.append(")");
        return sbU.toString();
    }
}
