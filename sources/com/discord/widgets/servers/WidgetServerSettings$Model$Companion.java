package com.discord.widgets.servers;

import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionsFeatureFlag;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetServerSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettings$Model$Companion {
    private WidgetServerSettings$Model$Companion() {
    }

    public final Observable<WidgetServerSettings$Model> get(long guildId) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable observableF = Observable.f(StoreUser.observeMe$default(storeStream$Companion.getUsers(), false, 1, null), storeStream$Companion.getGuilds().observeGuild(guildId), storeStream$Companion.getPermissions().observePermissionsForGuild(guildId), storeStream$Companion.getChannels().observeChannelCategories(guildId), storeStream$Companion.getPermissions().observeChannelPermissionsForGuild(guildId), GuildRoleSubscriptionsFeatureFlag.Companion.getINSTANCE().observeCanGuildSeeGuildRoleSubscriptionsSettings(guildId), WidgetServerSettings$Model$Companion$get$1.INSTANCE);
        m.checkNotNullExpressionValue(observableF, "Observable\n          .co…            )\n          }");
        Observable<WidgetServerSettings$Model> observableR = ObservableExtensionsKt.computationLatest(observableF).r();
        m.checkNotNullExpressionValue(observableR, "Observable\n          .co…  .distinctUntilChanged()");
        return observableR;
    }

    public /* synthetic */ WidgetServerSettings$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
