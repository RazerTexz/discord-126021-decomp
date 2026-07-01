package com.discord.widgets.user;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.embed.InviteEmbedModel;
import com.discord.utilities.embed.InviteEmbedModel$Companion;
import com.discord.utilities.rx.ObservableCombineLatestOverloadsKt;
import com.discord.widgets.chat.list.model.WidgetChatListModelMessages$MessagesWithMetadata;
import com.discord.widgets.tabs.NavigationTab;
import j0.k.b;
import rx.Observable;

/* JADX INFO: compiled from: WidgetUserMentions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMentions$Model$Companion$get$1<T, R> implements b<WidgetUserMentions$Model$MessageLoader$LoadingState, Observable<? extends WidgetUserMentions$Model>> {
    public final /* synthetic */ NavigationTab $selectedTab;

    public WidgetUserMentions$Model$Companion$get$1(NavigationTab navigationTab) {
        this.$selectedTab = navigationTab;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetUserMentions$Model> call(WidgetUserMentions$Model$MessageLoader$LoadingState widgetUserMentions$Model$MessageLoader$LoadingState) {
        return call2(widgetUserMentions$Model$MessageLoader$LoadingState);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetUserMentions$Model> call2(WidgetUserMentions$Model$MessageLoader$LoadingState widgetUserMentions$Model$MessageLoader$LoadingState) {
        Observable<WidgetChatListModelMessages$MessagesWithMetadata> observable = WidgetChatListModelMessages$MessagesWithMetadata.Companion.get(widgetUserMentions$Model$MessageLoader$LoadingState.getMentions());
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        return ObservableCombineLatestOverloadsKt.combineLatest(observable, storeStream$Companion.getGuildSelected().observeSelectedGuild(), storeStream$Companion.getChannels().observeAllChannels(), storeStream$Companion.getChannels().observeNames(), storeStream$Companion.getGuilds().observeGuilds(), storeStream$Companion.getGuilds().observeRoles(), storeStream$Companion.getGuilds().observeComputed(), storeStream$Companion.getUsers().observeMeId(), StoreUserSettings.observeIsAnimatedEmojisEnabled$default(storeStream$Companion.getUserSettings(), false, 1, null), StoreUserSettings.observeIsAutoPlayGifsEnabled$default(storeStream$Companion.getUserSettings(), false, 1, null), InviteEmbedModel$Companion.observe$default(InviteEmbedModel.Companion, null, null, null, null, 15, null), new WidgetUserMentions$Model$Companion$get$1$1(this, widgetUserMentions$Model$MessageLoader$LoadingState));
    }
}
