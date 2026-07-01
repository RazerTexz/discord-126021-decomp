package com.discord.widgets.guilds.profile;

import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.channel.GuildChannelsInfo;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChangeGuildIdentityViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChangeGuildIdentityViewModel$Companion {
    private WidgetChangeGuildIdentityViewModel$Companion() {
    }

    private final Observable<WidgetChangeGuildIdentityViewModel$StoreState> observeStoreState(long guildId, StoreGuilds storeGuilds, StoreUser storeUser) {
        Observable<WidgetChangeGuildIdentityViewModel$StoreState> observableH = Observable.h(GuildChannelsInfo.Companion.get(guildId), storeGuilds.observeGuild(guildId), StoreUser.observeMe$default(storeUser, false, 1, null), StoreUser.observeMe$default(storeUser, false, 1, null).Y(new WidgetChangeGuildIdentityViewModel$Companion$observeStoreState$1(guildId)), WidgetChangeGuildIdentityViewModel$Companion$observeStoreState$2.INSTANCE);
        m.checkNotNullExpressionValue(observableH, "Observable.combineLatest…uildChannelsInfo)\n      }");
        return observableH;
    }

    public static /* synthetic */ Observable observeStoreState$default(WidgetChangeGuildIdentityViewModel$Companion widgetChangeGuildIdentityViewModel$Companion, long j, StoreGuilds storeGuilds, StoreUser storeUser, int i, Object obj) {
        if ((i & 2) != 0) {
            storeGuilds = StoreStream.Companion.getGuilds();
        }
        if ((i & 4) != 0) {
            storeUser = StoreStream.Companion.getUsers();
        }
        return widgetChangeGuildIdentityViewModel$Companion.observeStoreState(j, storeGuilds, storeUser);
    }

    public /* synthetic */ WidgetChangeGuildIdentityViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
