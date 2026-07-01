package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.models.domain.Consents;
import com.discord.models.domain.ModelUserSettings$FriendSourceFlags;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.user.MeUser;
import com.discord.utilities.rest.RestAPI$HarvestState;
import d0.z.d.m;
import rx.functions.Func3;

/* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPrivacy$Model$Companion$get$3$3<T1, T2, T3, R> implements Func3<WidgetSettingsPrivacy$LocalState, Consents, RestAPI$HarvestState, WidgetSettingsPrivacy$Model> {
    public static final WidgetSettingsPrivacy$Model$Companion$get$3$3 INSTANCE = new WidgetSettingsPrivacy$Model$Companion$get$3$3();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ WidgetSettingsPrivacy$Model call(WidgetSettingsPrivacy$LocalState widgetSettingsPrivacy$LocalState, Consents consents, RestAPI$HarvestState restAPI$HarvestState) {
        return call2(widgetSettingsPrivacy$LocalState, consents, restAPI$HarvestState);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetSettingsPrivacy$Model call2(WidgetSettingsPrivacy$LocalState widgetSettingsPrivacy$LocalState, Consents consents, RestAPI$HarvestState restAPI$HarvestState) {
        ConnectedAccount contactSyncConnection = widgetSettingsPrivacy$LocalState.getContactSyncConnection();
        Experiment contactSyncExperiment = widgetSettingsPrivacy$LocalState.getContactSyncExperiment();
        boolean z2 = contactSyncExperiment != null && contactSyncExperiment.getBucket() == 1;
        MeUser me2 = widgetSettingsPrivacy$LocalState.getMe();
        int explicitContentFilter = widgetSettingsPrivacy$LocalState.getExplicitContentFilter();
        boolean defaultRestrictedGuilds = widgetSettingsPrivacy$LocalState.getDefaultRestrictedGuilds();
        ModelUserSettings$FriendSourceFlags friendSourceFlags = widgetSettingsPrivacy$LocalState.getFriendSourceFlags();
        int userDiscoveryFlags = widgetSettingsPrivacy$LocalState.getUserDiscoveryFlags();
        m.checkNotNullExpressionValue(consents, "consent");
        return new WidgetSettingsPrivacy$Model(me2, explicitContentFilter, defaultRestrictedGuilds, friendSourceFlags, userDiscoveryFlags, contactSyncConnection, z2, consents, restAPI$HarvestState);
    }
}
