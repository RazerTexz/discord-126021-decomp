package com.discord.widgets.emoji;

import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreEmojiCustom;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreMediaFavorites;
import com.discord.stores.StoreMediaFavorites$Favorite;
import com.discord.stores.StoreUser;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.textprocessing.node.EmojiNode$EmojiIdAndType;
import com.discord.utilities.textprocessing.node.EmojiNode$EmojiIdAndType$Custom;
import d0.z.d.m;
import j0.l.e.k;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: EmojiSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiSheetViewModel$Companion {
    private EmojiSheetViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStoreState(EmojiSheetViewModel$Companion emojiSheetViewModel$Companion, RestAPI restAPI, EmojiNode$EmojiIdAndType emojiNode$EmojiIdAndType, StoreUser storeUser, StoreGuilds storeGuilds, StoreEmojiCustom storeEmojiCustom, StoreChannelsSelected storeChannelsSelected, StoreMediaFavorites storeMediaFavorites) {
        return emojiSheetViewModel$Companion.observeStoreState(restAPI, emojiNode$EmojiIdAndType, storeUser, storeGuilds, storeEmojiCustom, storeChannelsSelected, storeMediaFavorites);
    }

    private final Observable<EmojiSheetViewModel$Companion$CustomEmojGuildInfo> getGuildForCustomEmoji(RestAPI restAPI, EmojiNode$EmojiIdAndType emojiIdAndType, StoreGuilds storeGuilds, StoreEmojiCustom storeEmojiCustom) {
        if (!(emojiIdAndType instanceof EmojiNode$EmojiIdAndType$Custom)) {
            emojiIdAndType = null;
        }
        EmojiNode$EmojiIdAndType$Custom emojiNode$EmojiIdAndType$Custom = (EmojiNode$EmojiIdAndType$Custom) emojiIdAndType;
        if (emojiNode$EmojiIdAndType$Custom != null) {
            Observable<EmojiSheetViewModel$Companion$CustomEmojGuildInfo> observableA = Observable.D(new EmojiSheetViewModel$Companion$getGuildForCustomEmoji$1(storeEmojiCustom, emojiNode$EmojiIdAndType$Custom, storeGuilds)).A(new EmojiSheetViewModel$Companion$getGuildForCustomEmoji$2(restAPI, emojiNode$EmojiIdAndType$Custom));
            m.checkNotNullExpressionValue(observableA, "Observable.fromCallable …      }\n        }\n      }");
            return observableA;
        }
        k kVar = new k(null);
        m.checkNotNullExpressionValue(kVar, "Observable.just(null)");
        return kVar;
    }

    private final Observable<EmojiSheetViewModel$StoreState> observeStoreState(RestAPI restAPI, EmojiNode$EmojiIdAndType emojiIdAndType, StoreUser storeUsers, StoreGuilds storeGuilds, StoreEmojiCustom storeEmojiCustom, StoreChannelsSelected storeChannelsSelected, StoreMediaFavorites storeMediaFavorites) {
        Observable<EmojiSheetViewModel$StoreState> observableG = Observable.g(getGuildForCustomEmoji(restAPI, emojiIdAndType, storeGuilds, storeEmojiCustom), StoreUser.observeMe$default(storeUsers, false, 1, null), storeGuilds.observeGuilds(), storeChannelsSelected.observeSelectedChannel(), storeMediaFavorites.observeFavorites(StoreMediaFavorites$Favorite.Companion.getEmojiTypes()), new EmojiSheetViewModel$Companion$observeStoreState$1(emojiIdAndType));
        m.checkNotNullExpressionValue(observableG, "Observable.combineLatest…es,\n          )\n        }");
        return observableG;
    }

    public /* synthetic */ EmojiSheetViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
