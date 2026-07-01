package com.discord.widgets.stickers;

import com.discord.api.sticker.Sticker;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreUser;
import com.discord.utilities.rest.RestAPI;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: GuildStickerSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildStickerSheetViewModel$Companion {
    private GuildStickerSheetViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStoreState(GuildStickerSheetViewModel$Companion guildStickerSheetViewModel$Companion, RestAPI restAPI, Sticker sticker, StoreUser storeUser, StoreChannelsSelected storeChannelsSelected, StoreGuilds storeGuilds) {
        return guildStickerSheetViewModel$Companion.observeStoreState(restAPI, sticker, storeUser, storeChannelsSelected, storeGuilds);
    }

    private final Observable<GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo> getGuildForGuildSticker(RestAPI restAPI, Sticker sticker, StoreGuilds storeGuilds) {
        Observable<GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo> observableA = Observable.D(new GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$1(storeGuilds, sticker)).A(new GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$2(restAPI, sticker));
        m.checkNotNullExpressionValue(observableA, "Observable.fromCallable …      }\n        }\n      }");
        return observableA;
    }

    private final Observable<GuildStickerSheetViewModel$StoreState> observeStoreState(RestAPI restAPI, Sticker sticker, StoreUser storeUser, StoreChannelsSelected storeChannelsSelected, StoreGuilds storeGuilds) {
        Observable<GuildStickerSheetViewModel$StoreState> observableH = Observable.h(getGuildForGuildSticker(restAPI, sticker, storeGuilds), StoreUser.observeMe$default(storeUser, false, 1, null), storeChannelsSelected.observeSelectedChannel(), storeGuilds.observeGuilds(), GuildStickerSheetViewModel$Companion$observeStoreState$1.INSTANCE);
        m.checkNotNullExpressionValue(observableH, "Observable.combineLatest…erGuildInfo\n      )\n    }");
        return observableH;
    }

    public /* synthetic */ GuildStickerSheetViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
