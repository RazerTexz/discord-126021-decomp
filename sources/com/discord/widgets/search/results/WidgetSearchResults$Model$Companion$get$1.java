package com.discord.widgets.search.results;

import androidx.core.app.NotificationCompat;
import com.discord.models.message.Message;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.embed.InviteEmbedModel;
import com.discord.utilities.embed.InviteEmbedModel$Companion;
import com.discord.utilities.rx.ObservableCombineLatestOverloadsKt;
import com.discord.utilities.search.network.state.SearchState;
import com.discord.widgets.chat.list.model.WidgetChatListModelMessages$MessagesWithMetadata;
import com.discord.widgets.chat.list.model.WidgetChatListModelMessages$MessagesWithMetadata$Companion;
import j0.k.b;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;

/* JADX INFO: compiled from: WidgetSearchResults.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearchResults$Model$Companion$get$1<T, R> implements b<SearchState, Observable<? extends WidgetSearchResults$Model>> {
    public static final WidgetSearchResults$Model$Companion$get$1 INSTANCE = new WidgetSearchResults$Model$Companion$get$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetSearchResults$Model> call(SearchState searchState) {
        return call2(searchState);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetSearchResults$Model> call2(SearchState searchState) {
        WidgetChatListModelMessages$MessagesWithMetadata$Companion widgetChatListModelMessages$MessagesWithMetadata$Companion = WidgetChatListModelMessages$MessagesWithMetadata.Companion;
        List<Message> hits = searchState.getHits();
        if (hits == null) {
            hits = new ArrayList<>();
        }
        Observable<WidgetChatListModelMessages$MessagesWithMetadata> observable = widgetChatListModelMessages$MessagesWithMetadata$Companion.get(hits);
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        return ObservableCombineLatestOverloadsKt.combineLatest(observable, storeStream$Companion.getUsers().observeMeId(), storeStream$Companion.getChannels().observeNames(), storeStream$Companion.getGuilds().observeGuilds(), storeStream$Companion.getGuilds().observeComputed(), storeStream$Companion.getGuilds().observeRoles(), storeStream$Companion.getChannels().observeAllChannels(), StoreUserSettings.observeIsAnimatedEmojisEnabled$default(storeStream$Companion.getUserSettings(), false, 1, null), StoreUserSettings.observeIsAutoPlayGifsEnabled$default(storeStream$Companion.getUserSettings(), false, 1, null), InviteEmbedModel$Companion.observe$default(InviteEmbedModel.Companion, null, null, null, null, 15, null), new WidgetSearchResults$Model$Companion$get$1$1(searchState));
    }
}
