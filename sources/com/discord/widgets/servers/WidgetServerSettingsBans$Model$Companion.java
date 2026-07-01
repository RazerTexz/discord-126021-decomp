package com.discord.widgets.servers;

import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetServerSettingsBans.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsBans$Model$Companion {
    private WidgetServerSettingsBans$Model$Companion() {
    }

    public static final /* synthetic */ WidgetServerSettingsBans$Model access$createLoading(WidgetServerSettingsBans$Model$Companion widgetServerSettingsBans$Model$Companion, Guild guild) {
        return widgetServerSettingsBans$Model$Companion.createLoading(guild);
    }

    public static final /* synthetic */ Observable access$getBanItems(WidgetServerSettingsBans$Model$Companion widgetServerSettingsBans$Model$Companion, long j, Observable observable) {
        return widgetServerSettingsBans$Model$Companion.getBanItems(j, observable);
    }

    private final WidgetServerSettingsBans$Model createLoading(Guild guild) {
        if (guild == null) {
            return null;
        }
        return new WidgetServerSettingsBans$Model(0, WidgetServerSettingsBans$Model.access$getEmptyBansList$cp(), guild.getId(), guild.getName(), true);
    }

    private final Observable<WidgetServerSettingsBans$Model> getBanItems(long guildId, Observable<String> filterPublisher) {
        Observable<R> observableY = StoreStream.Companion.getBans().observeBans(guildId).Y(new WidgetServerSettingsBans$Model$Companion$getBanItems$1(guildId, filterPublisher));
        m.checkNotNullExpressionValue(observableY, "StoreStream\n            …          }\n            }");
        Observable<WidgetServerSettingsBans$Model> observableR = ObservableExtensionsKt.computationLatest(observableY).r();
        m.checkNotNullExpressionValue(observableR, "StoreStream\n            …  .distinctUntilChanged()");
        return observableR;
    }

    private final Observable<Boolean> getCanManageBans(long guildId) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable observableI = Observable.i(storeStream$Companion.getPermissions().observePermissionsForGuild(guildId), storeStream$Companion.getGuilds().observeGuild(guildId), StoreUser.observeMe$default(storeStream$Companion.getUsers(), false, 1, null), WidgetServerSettingsBans$Model$Companion$getCanManageBans$1.INSTANCE);
        m.checkNotNullExpressionValue(observableI, "Observable\n             …        }\n              }");
        Observable<Boolean> observableR = ObservableExtensionsKt.computationLatest(observableI).r();
        m.checkNotNullExpressionValue(observableR, "Observable\n             …  .distinctUntilChanged()");
        return observableR;
    }

    public final WidgetServerSettingsBans$Model create(Guild guild, Integer totalBannedUsers, List<WidgetServerSettingsBans$Model$BanItem> filteredBannedUsers) {
        if (guild == null || totalBannedUsers == null || filteredBannedUsers == null) {
            return null;
        }
        return new WidgetServerSettingsBans$Model(totalBannedUsers.intValue(), filteredBannedUsers, guild.getId(), guild.getName(), false);
    }

    public final Observable<WidgetServerSettingsBans$Model> get(long guildId, Observable<String> filterPublisher) {
        m.checkNotNullParameter(filterPublisher, "filterPublisher");
        Observable observableY = getCanManageBans(guildId).Y(new WidgetServerSettingsBans$Model$Companion$get$1(guildId, filterPublisher));
        m.checkNotNullExpressionValue(observableY, "getCanManageBans(guildId….just(null)\n            }");
        return observableY;
    }

    public /* synthetic */ WidgetServerSettingsBans$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
