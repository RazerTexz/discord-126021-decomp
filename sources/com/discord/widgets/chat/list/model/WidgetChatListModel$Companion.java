package com.discord.widgets.chat.list.model;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.sticker.Sticker;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.user.User;
import com.discord.stores.StoreMessagesLoader;
import com.discord.stores.StoreMessagesLoader$ChannelLoadedState;
import com.discord.stores.StoreStickers;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreThreadDraft$ThreadDraftState;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.StickerGreetCompactEntry;
import com.discord.widgets.chat.list.entries.StickerGreetEntry;
import d0.z.d.m;
import j0.l.e.k;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func2;

/* JADX INFO: compiled from: WidgetChatListModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListModel$Companion {
    private WidgetChatListModel$Companion() {
    }

    public static final /* synthetic */ Observable access$getChannel(WidgetChatListModel$Companion widgetChatListModel$Companion, Channel channel) {
        return widgetChatListModel$Companion.getChannel(channel);
    }

    public static final /* synthetic */ ChatListEntry access$getGreetMessageItem(WidgetChatListModel$Companion widgetChatListModel$Companion, WidgetChatListModelMessages widgetChatListModelMessages, Channel channel) {
        return widgetChatListModel$Companion.getGreetMessageItem(widgetChatListModelMessages, channel);
    }

    public static final /* synthetic */ Observable access$getThreadDraft(WidgetChatListModel$Companion widgetChatListModel$Companion, Channel channel, Long l) {
        return widgetChatListModel$Companion.getThreadDraft(channel, l);
    }

    public static final /* synthetic */ boolean access$shouldShowStickerGreet(WidgetChatListModel$Companion widgetChatListModel$Companion, StoreMessagesLoader$ChannelLoadedState storeMessagesLoader$ChannelLoadedState, WidgetChatListModelMessages widgetChatListModelMessages, Channel channel, Map map) {
        return widgetChatListModel$Companion.shouldShowStickerGreet(storeMessagesLoader$ChannelLoadedState, widgetChatListModelMessages, channel, map);
    }

    private final Observable<WidgetChatListModel> getChannel(Channel channel) {
        Observable<WidgetChatListModelTop> observable = WidgetChatListModelTop.Companion.get(channel);
        Observable<WidgetChatListModelMessages> observable2 = WidgetChatListModelMessages.Companion.get(channel);
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable<WidgetChatListModel> observableC = Observable.c(observable, observable2, observeIsLoadingMessages(storeStream$Companion.getMessagesLoader(), channel.getId()), storeStream$Companion.getChannels().observeNames(), storeStream$Companion.getUsers().observeMeId(), storeStream$Companion.getGuilds().observeComputed(channel.getGuildId()), storeStream$Companion.getGuilds().observeGuild(channel.getGuildId()), storeStream$Companion.getUserRelationships().observe(), WidgetChatListModel$ChatListState.Companion.get(channel.getId()), new WidgetChatListModel$Companion$getChannel$1(channel));
        m.checkNotNullExpressionValue(observableC, "Observable\n            .…          )\n            }");
        return observableC;
    }

    private final ChatListEntry getGreetMessageItem(WidgetChatListModelMessages messages, Channel channel) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        StoreStickers stickers = storeStream$Companion.getStickers();
        if (stickers.getStickers().get(749054660769218631L) == null) {
            stickers.fetchStickerPack(847199849233514549L);
        }
        Sticker sticker = stickers.getStickers().get(749054660769218631L);
        if (sticker != null) {
            Guild guild = storeStream$Companion.getGuilds().getGuild(channel.getGuildId());
            if (!(((guild != null ? guild.getSystemChannelFlags() : 0) & 8) == 0)) {
                return null;
            }
            if (messages.getItems().isEmpty()) {
                return new StickerGreetEntry(sticker, channel.getId(), ChannelUtils.c(channel), channel.getType());
            }
            if (messages.getItems().size() < 25) {
                return new StickerGreetCompactEntry(sticker, channel.getId(), ChannelUtils.c(channel), channel.getType());
            }
        }
        return null;
    }

    private final Observable<WidgetChatListModel> getThreadDraft(Channel parentChannel, Long parentMessageId) {
        Object widgetChatListModel$sam$rx_functions_Func2$0;
        Observable observableJ;
        Object widgetChatListModel$sam$rx_functions_Func2$1;
        long guildId = parentChannel.getGuildId();
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable<Map<Long, String>> observableObserveNames = storeStream$Companion.getChannels().observeNames();
        Observable<Long> observableObserveMeId = storeStream$Companion.getUsers().observeMeId();
        Observable<Map<Long, GuildMember>> observableObserveComputed = storeStream$Companion.getGuilds().observeComputed(guildId);
        Observable<Guild> observableObserveGuild = storeStream$Companion.getGuilds().observeGuild(guildId);
        Observable<StoreThreadDraft$ThreadDraftState> observableObserveDraftState = storeStream$Companion.getThreadDraft().observeDraftState();
        Observable<Long> observableObservePermissionsForChannel = storeStream$Companion.getPermissions().observePermissionsForChannel(parentChannel.getId());
        if (parentMessageId != null) {
            Observable<Message> observableObserveMessagesForChannel = storeStream$Companion.getMessages().observeMessagesForChannel(parentChannel.getId(), parentMessageId.longValue());
            Observable<List<ChatListEntry>> singleMessage = WidgetChatListModelMessages.Companion.getSingleMessage(parentChannel, parentMessageId.longValue());
            WidgetChatListModel$Companion$getThreadDraft$1 widgetChatListModel$Companion$getThreadDraft$1 = WidgetChatListModel$Companion$getThreadDraft$1.INSTANCE;
            if (widgetChatListModel$Companion$getThreadDraft$1 != null) {
                widgetChatListModel$sam$rx_functions_Func2$1 = widgetChatListModel$Companion$getThreadDraft$1;
                widgetChatListModel$sam$rx_functions_Func2$1 = new WidgetChatListModel$sam$rx_functions_Func2$0(widgetChatListModel$Companion$getThreadDraft$1);
            }
            widgetChatListModel$sam$rx_functions_Func2$1 = widgetChatListModel$Companion$getThreadDraft$1;
            observableJ = Observable.j(observableObserveMessagesForChannel, singleMessage, (Func2) widgetChatListModel$sam$rx_functions_Func2$1);
        } else {
            k kVar = new k(null);
            k kVar2 = new k(new ArrayList());
            WidgetChatListModel$Companion$getThreadDraft$2 widgetChatListModel$Companion$getThreadDraft$2 = WidgetChatListModel$Companion$getThreadDraft$2.INSTANCE;
            if (widgetChatListModel$Companion$getThreadDraft$2 != null) {
                widgetChatListModel$sam$rx_functions_Func2$0 = widgetChatListModel$Companion$getThreadDraft$2;
                widgetChatListModel$sam$rx_functions_Func2$0 = new WidgetChatListModel$sam$rx_functions_Func2$0(widgetChatListModel$Companion$getThreadDraft$2);
            }
            widgetChatListModel$sam$rx_functions_Func2$0 = widgetChatListModel$Companion$getThreadDraft$2;
            observableJ = Observable.j(kVar, kVar2, (Func2) widgetChatListModel$sam$rx_functions_Func2$0);
        }
        Observable<WidgetChatListModel> observableE = Observable.e(observableObserveNames, observableObserveMeId, observableObserveComputed, observableObserveGuild, observableObserveDraftState, observableObservePermissionsForChannel, observableJ, new WidgetChatListModel$Companion$getThreadDraft$3(parentChannel, parentMessageId, guildId));
        m.checkNotNullExpressionValue(observableE, "Observable\n          .co…            )\n          }");
        return observableE;
    }

    private final Observable<StoreMessagesLoader$ChannelLoadedState> observeIsLoadingMessages(StoreMessagesLoader storeMessagesLoader, long j) {
        return storeMessagesLoader.getMessagesLoadedState(j).r();
    }

    private final boolean shouldShowStickerGreet(StoreMessagesLoader$ChannelLoadedState loadingState, WidgetChatListModelMessages messages, Channel channel, Map<Long, Integer> relationships) {
        if (loadingState.isOldestMessagesLoaded() && loadingState.isInitialMessagesLoaded() && loadingState.getNewestSentByUserMessageId() == null && messages.getNewestSentByUserMessageId() == null && messages.getItems().size() < 25 && ChannelUtils.m(channel) && !ChannelUtils.E(channel)) {
            User userA = ChannelUtils.a(channel);
            Integer num = relationships.get(userA != null ? Long.valueOf(userA.getId()) : null);
            if (num == null || num.intValue() != 2) {
                return true;
            }
        }
        return false;
    }

    public final Observable<WidgetChatListModel> get() {
        Observable observableY = StoreStream.Companion.getChannelsSelected().observeResolvedSelectedChannel().Y(WidgetChatListModel$Companion$get$1.INSTANCE);
        m.checkNotNullExpressionValue(observableY, "StoreStream\n          .g…            }\n          }");
        return observableY;
    }

    public /* synthetic */ WidgetChatListModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
