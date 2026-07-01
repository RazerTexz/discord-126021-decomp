package com.discord.widgets.guilds.profile;

import com.discord.stores.StoreEmoji$EmojiContext$GuildProfile;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import com.discord.utilities.channel.GuildChannelsInfo;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetGuildProfileSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildProfileSheetViewModel$Companion {
    private WidgetGuildProfileSheetViewModel$Companion() {
    }

    public final Observable<WidgetGuildProfileSheetViewModel$StoreState> observeStores(long guildId) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable<WidgetGuildProfileSheetViewModel$StoreState> observableC = Observable.c(storeStream$Companion.getGuilds().observeGuild(guildId), storeStream$Companion.getGuildProfiles().observeGuildProfile(guildId), storeStream$Companion.getReadStates().getIsUnread(guildId), StoreUser.observeMe$default(storeStream$Companion.getUsers(), false, 1, null), StoreUser.observeMe$default(storeStream$Companion.getUsers(), false, 1, null).Y(new WidgetGuildProfileSheetViewModel$Companion$observeStores$1(guildId)), storeStream$Companion.getUserSettings().observeRestrictedGuildIds(), storeStream$Companion.getEmojis().getEmojiSet(new StoreEmoji$EmojiContext$GuildProfile(guildId), true, false).G(new WidgetGuildProfileSheetViewModel$Companion$observeStores$2(guildId)), storeStream$Companion.getLurking().isLurkingObs(guildId), GuildChannelsInfo.Companion.get(guildId), WidgetGuildProfileSheetViewModel$Companion$observeStores$3.INSTANCE);
        m.checkNotNullExpressionValue(observableC, "Observable.combineLatest…ead\n          )\n        }");
        return observableC;
    }

    public /* synthetic */ WidgetGuildProfileSheetViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
