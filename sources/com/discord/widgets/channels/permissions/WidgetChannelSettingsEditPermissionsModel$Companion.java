package com.discord.widgets.channels.permissions;

import com.discord.api.permission.Permission;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.list.NewThreadsPermissionsFeatureFlag;
import d0.z.d.m;
import j0.l.e.k;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChannelSettingsEditPermissionsModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsEditPermissionsModel$Companion {
    private WidgetChannelSettingsEditPermissionsModel$Companion() {
    }

    public static final /* synthetic */ boolean access$isAbleToManagePerms(WidgetChannelSettingsEditPermissionsModel$Companion widgetChannelSettingsEditPermissionsModel$Companion, Guild guild, MeUser meUser, long j) {
        return widgetChannelSettingsEditPermissionsModel$Companion.isAbleToManagePerms(guild, meUser, j);
    }

    private final Observable<WidgetChannelSettingsEditPermissionsModel> getForRole(long guildId, long channelId, long targetRoleId) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable observableE = Observable.e(storeStream$Companion.getChannels().observeChannel(channelId), StoreUser.observeMe$default(storeStream$Companion.getUsers(), false, 1, null), storeStream$Companion.getGuilds().observeGuild(guildId), storeStream$Companion.getPermissions().observePermissionsForChannel(channelId), storeStream$Companion.getGuilds().observeRoles(guildId), storeStream$Companion.getGuilds().observeComputed(guildId), NewThreadsPermissionsFeatureFlag.Companion.getINSTANCE().observeEnabled(guildId), new WidgetChannelSettingsEditPermissionsModel$Companion$getForRole$1(targetRoleId));
        m.checkNotNullExpressionValue(observableE, "Observable\n            .…          }\n            }");
        Observable<WidgetChannelSettingsEditPermissionsModel> observableR = ObservableExtensionsKt.computationLatest(observableE).r();
        m.checkNotNullExpressionValue(observableR, "Observable\n            .…  .distinctUntilChanged()");
        return observableR;
    }

    private final Observable<WidgetChannelSettingsEditPermissionsModel> getForUser(long guildId, long channelId, long targetUserId, StoreChannels storeChannels, StoreUser storeUser, StoreGuilds storeGuilds, StorePermissions storePermissions) {
        Observable<WidgetChannelSettingsEditPermissionsModel> observableR = ObservableExtensionsKt.computationLatest(ObservationDeck.connectRx$default(ObservationDeckProvider.get(), new ObservationDeck$UpdateSource[]{storeChannels, storeUser, storeGuilds, storePermissions}, false, null, null, new WidgetChannelSettingsEditPermissionsModel$Companion$getForUser$1(storeChannels, channelId, storeUser, targetUserId, storeGuilds, guildId, storePermissions), 14, null)).r();
        m.checkNotNullExpressionValue(observableR, "ObservationDeckProvider.…  .distinctUntilChanged()");
        return observableR;
    }

    public static /* synthetic */ Observable getForUser$default(WidgetChannelSettingsEditPermissionsModel$Companion widgetChannelSettingsEditPermissionsModel$Companion, long j, long j2, long j3, StoreChannels storeChannels, StoreUser storeUser, StoreGuilds storeGuilds, StorePermissions storePermissions, int i, Object obj) {
        return widgetChannelSettingsEditPermissionsModel$Companion.getForUser(j, j2, j3, (i & 8) != 0 ? StoreStream.Companion.getChannels() : storeChannels, (i & 16) != 0 ? StoreStream.Companion.getUsers() : storeUser, (i & 32) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds, (i & 64) != 0 ? StoreStream.Companion.getPermissions() : storePermissions);
    }

    private final boolean isAbleToManagePerms(Guild guild, MeUser meUser, long myPermissionsForChannel) {
        return ((guild.getOwnerId() > meUser.getId() ? 1 : (guild.getOwnerId() == meUser.getId() ? 0 : -1)) == 0) || PermissionUtils.canAndIsElevated(Permission.MANAGE_ROLES, Long.valueOf(myPermissionsForChannel), meUser.getMfaEnabled(), guild.getMfaLevel()) || PermissionUtils.canAndIsElevated(8L, Long.valueOf(myPermissionsForChannel), meUser.getMfaEnabled(), guild.getMfaLevel());
    }

    public final Observable<WidgetChannelSettingsEditPermissionsModel> get(long guildId, long channelId, long targetId, int type) {
        if (type == 0) {
            return getForUser$default(this, guildId, channelId, targetId, null, null, null, null, 120, null);
        }
        if (type == 1) {
            return getForRole(guildId, channelId, targetId);
        }
        k kVar = new k(null);
        m.checkNotNullExpressionValue(kVar, "Observable\n              .just(null)");
        return kVar;
    }

    public /* synthetic */ WidgetChannelSettingsEditPermissionsModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
