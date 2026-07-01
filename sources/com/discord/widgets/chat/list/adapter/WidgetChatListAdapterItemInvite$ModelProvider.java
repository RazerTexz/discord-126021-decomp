package com.discord.widgets.chat.list.adapter;

import com.discord.models.domain.ModelInvite;
import com.discord.stores.StoreAccessibility;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreInstantInvites;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.SnowflakeUtils;
import com.discord.widgets.chat.list.entries.InviteEntry;
import d0.z.d.m;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChatListAdapterItemInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemInvite$ModelProvider {
    public static final WidgetChatListAdapterItemInvite$ModelProvider INSTANCE = new WidgetChatListAdapterItemInvite$ModelProvider();

    private WidgetChatListAdapterItemInvite$ModelProvider() {
    }

    public static final /* synthetic */ Observable access$getInvalidInvite(WidgetChatListAdapterItemInvite$ModelProvider widgetChatListAdapterItemInvite$ModelProvider, InviteEntry inviteEntry) {
        return widgetChatListAdapterItemInvite$ModelProvider.getInvalidInvite(inviteEntry);
    }

    public static final /* synthetic */ Observable access$observeModel(WidgetChatListAdapterItemInvite$ModelProvider widgetChatListAdapterItemInvite$ModelProvider, InviteEntry inviteEntry, ModelInvite modelInvite) {
        return widgetChatListAdapterItemInvite$ModelProvider.observeModel(inviteEntry, modelInvite);
    }

    private final Observable<WidgetChatListAdapterItemInvite$Model> getInvalidInvite(InviteEntry item) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable<WidgetChatListAdapterItemInvite$Model> observableJ = Observable.j(storeStream$Companion.getUsers().observeMeId(), storeStream$Companion.getUsers().observeUser(item.getUserId()), WidgetChatListAdapterItemInvite$ModelProvider$getInvalidInvite$1.INSTANCE);
        m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…authorUser, meId, null) }");
        return observableJ;
    }

    private final Observable<WidgetChatListAdapterItemInvite$Model> observeModel(InviteEntry item, ModelInvite invite) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        StoreUser users = storeStream$Companion.getUsers();
        StoreGuilds guilds = storeStream$Companion.getGuilds();
        StoreChannels channels = storeStream$Companion.getChannels();
        StoreAccessibility accessibility = storeStream$Companion.getAccessibility();
        return ObservationDeck.connectRx$default(ObservationDeckProvider.get(), new ObservationDeck$UpdateSource[]{users, guilds, channels, accessibility}, false, null, null, new WidgetChatListAdapterItemInvite$ModelProvider$observeModel$1(users, item, invite, guilds, channels, accessibility), 14, null);
    }

    public final Observable<WidgetChatListAdapterItemInvite$Model> get(InviteEntry item) {
        m.checkNotNullParameter(item, "item");
        StoreInstantInvites instantInvites = StoreStream.Companion.getInstantInvites();
        String inviteCode = item.getInviteCode();
        String eventId = item.getEventId();
        Observable observableY = instantInvites.observeInvite(ModelInvite.getInviteStoreKey(inviteCode, eventId != null ? SnowflakeUtils.INSTANCE.toSnowflake(eventId) : null)).Y(new WidgetChatListAdapterItemInvite$ModelProvider$get$1(item));
        m.checkNotNullExpressionValue(observableY, "StoreStream\n        .get…tes\n          }\n        }");
        return observableY;
    }
}
