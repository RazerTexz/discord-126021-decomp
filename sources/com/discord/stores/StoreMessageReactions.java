package com.discord.stores;

import android.content.Context;
import com.discord.api.message.reaction.MessageReactionEmoji;
import com.discord.api.message.reaction.MessageReactionUpdate;
import com.discord.models.user.User;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.z.d.m;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StoreMessageReactions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessageReactions extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final Map<Long, Map<String, StoreMessageReactions$EmojiResults>> reactions;
    private Map<Long, ? extends Map<String, ? extends StoreMessageReactions$EmojiResults>> reactionsSnapshot;
    private final StoreUser userStore;

    public /* synthetic */ StoreMessageReactions(Dispatcher dispatcher, StoreUser storeUser, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, storeUser, (i & 4) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public static final /* synthetic */ void access$fetchReactions(StoreMessageReactions storeMessageReactions, long j, long j2, MessageReactionEmoji messageReactionEmoji) {
        storeMessageReactions.fetchReactions(j, j2, messageReactionEmoji);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreMessageReactions storeMessageReactions) {
        return storeMessageReactions.dispatcher;
    }

    public static final /* synthetic */ Map access$getReactions$p(StoreMessageReactions storeMessageReactions) {
        return storeMessageReactions.reactions;
    }

    public static final /* synthetic */ Map access$getReactionsSnapshot$p(StoreMessageReactions storeMessageReactions) {
        return storeMessageReactions.reactionsSnapshot;
    }

    public static final /* synthetic */ void access$handleLoadReactionUsersFailure(StoreMessageReactions storeMessageReactions, long j, long j2, MessageReactionEmoji messageReactionEmoji) {
        storeMessageReactions.handleLoadReactionUsersFailure(j, j2, messageReactionEmoji);
    }

    public static final /* synthetic */ void access$handleReactionUsers(StoreMessageReactions storeMessageReactions, long j, long j2, MessageReactionEmoji messageReactionEmoji, List list) {
        storeMessageReactions.handleReactionUsers(j, j2, messageReactionEmoji, list);
    }

    public static final /* synthetic */ void access$setReactionsSnapshot$p(StoreMessageReactions storeMessageReactions, Map map) {
        storeMessageReactions.reactionsSnapshot = map;
    }

    @StoreThread
    private final StoreMessageReactions$EmojiResults ensureReactionResults(long messageId, String emoji) {
        Map<String, StoreMessageReactions$EmojiResults> map = this.reactions.get(Long.valueOf(messageId));
        if (map == null) {
            map = new HashMap<>();
        }
        StoreMessageReactions$EmojiResults storeMessageReactions$EmojiResults = map.get(emoji);
        if (storeMessageReactions$EmojiResults == null) {
            storeMessageReactions$EmojiResults = StoreMessageReactions$EmojiResults$Loading.INSTANCE;
        }
        map.put(emoji, storeMessageReactions$EmojiResults);
        this.reactions.put(Long.valueOf(messageId), map);
        return storeMessageReactions$EmojiResults;
    }

    @StoreThread
    private final void fetchReactions(long channelId, long messageId, MessageReactionEmoji emoji) {
        StoreMessageReactions$EmojiResults storeMessageReactions$EmojiResultsEnsureReactionResults = ensureReactionResults(messageId, emoji.c());
        if ((storeMessageReactions$EmojiResultsEnsureReactionResults instanceof StoreMessageReactions$EmojiResults$Users) && (!((StoreMessageReactions$EmojiResults$Users) storeMessageReactions$EmojiResultsEnsureReactionResults).getUsers().isEmpty())) {
            return;
        }
        String reactionEmojiRequestParam = getReactionEmojiRequestParam(emoji);
        Map<String, StoreMessageReactions$EmojiResults> map = this.reactions.get(Long.valueOf(messageId));
        if (map != null) {
            map.put(emoji.c(), StoreMessageReactions$EmojiResults$Loading.INSTANCE);
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().getReactionUsers(channelId, messageId, reactionEmojiRequestParam, 100), false, 1, null), StoreMessageReactions.class, (Context) null, (Function1) null, new StoreMessageReactions$fetchReactions$2(this, channelId, messageId, emoji), (Function0) null, (Function0) null, new StoreMessageReactions$fetchReactions$1(this, channelId, messageId, emoji), 54, (Object) null);
    }

    private final String getReactionEmojiRequestParam(MessageReactionEmoji emoji) {
        if (!emoji.e()) {
            String name = emoji.getName();
            return name != null ? name : "";
        }
        return emoji.getName() + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + emoji.getId();
    }

    @StoreThread
    private final void handleLoadReactionUsersFailure(long channelId, long messageId, MessageReactionEmoji emoji) {
        ensureReactionResults(messageId, emoji.c());
        Map<String, StoreMessageReactions$EmojiResults> map = this.reactions.get(Long.valueOf(messageId));
        if (map != null) {
            map.put(emoji.c(), new StoreMessageReactions$EmojiResults$Failure(channelId, messageId, emoji));
        }
        markChanged();
    }

    @StoreThread
    private final void handleReactionUsers(long channelId, long messageId, MessageReactionEmoji emoji, List<? extends User> reactionUsers) {
        ensureReactionResults(messageId, emoji.c());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : reactionUsers) {
            linkedHashMap.put(Long.valueOf(((User) obj).getId()), obj);
        }
        Map<String, StoreMessageReactions$EmojiResults> map = this.reactions.get(Long.valueOf(messageId));
        if (map != null) {
            map.put(emoji.c(), new StoreMessageReactions$EmojiResults$Users(linkedHashMap, channelId, messageId, emoji));
        }
        markChanged();
    }

    public final void deleteEmoji(long channelId, long messageId, MessageReactionEmoji emoji, long userId) {
        m.checkNotNullParameter(emoji, "emoji");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().removeReaction(channelId, messageId, getReactionEmojiRequestParam(emoji), userId), false, 1, null), StoreMessageReactions.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, StoreMessageReactions$deleteEmoji$1.INSTANCE, 62, (Object) null);
    }

    public final void forceRetryFetchReactions(long channelId, long messageId, MessageReactionEmoji emoji) {
        m.checkNotNullParameter(emoji, "emoji");
        this.dispatcher.schedule(new StoreMessageReactions$forceRetryFetchReactions$1(this, messageId, emoji, channelId));
    }

    @StoreThread
    public final void handleConnectionOpen() {
        if (!this.reactions.isEmpty()) {
            this.reactions.clear();
            markChanged();
        }
    }

    @StoreThread
    public final void handleReactionAdd(MessageReactionUpdate update) {
        m.checkNotNullParameter(update, "update");
        User user = this.userStore.getUsersInternal$app_productionGoogleRelease().get(Long.valueOf(update.getUserId()));
        if (user != null) {
            StoreMessageReactions$EmojiResults storeMessageReactions$EmojiResultsEnsureReactionResults = ensureReactionResults(update.getMessageId(), update.getEmoji().c());
            if (!(storeMessageReactions$EmojiResultsEnsureReactionResults instanceof StoreMessageReactions$EmojiResults$Users)) {
                storeMessageReactions$EmojiResultsEnsureReactionResults = null;
            }
            StoreMessageReactions$EmojiResults$Users storeMessageReactions$EmojiResults$Users = (StoreMessageReactions$EmojiResults$Users) storeMessageReactions$EmojiResultsEnsureReactionResults;
            if (storeMessageReactions$EmojiResults$Users != null) {
                storeMessageReactions$EmojiResults$Users.getUsers().put(Long.valueOf(update.getUserId()), user);
                markChanged();
            }
        }
    }

    @StoreThread
    public final void handleReactionRemove(MessageReactionUpdate update) {
        m.checkNotNullParameter(update, "update");
        StoreMessageReactions$EmojiResults storeMessageReactions$EmojiResultsEnsureReactionResults = ensureReactionResults(update.getMessageId(), update.getEmoji().c());
        if (!(storeMessageReactions$EmojiResultsEnsureReactionResults instanceof StoreMessageReactions$EmojiResults$Users)) {
            storeMessageReactions$EmojiResultsEnsureReactionResults = null;
        }
        StoreMessageReactions$EmojiResults$Users storeMessageReactions$EmojiResults$Users = (StoreMessageReactions$EmojiResults$Users) storeMessageReactions$EmojiResultsEnsureReactionResults;
        if (storeMessageReactions$EmojiResults$Users != null) {
            storeMessageReactions$EmojiResults$Users.getUsers().remove(Long.valueOf(update.getUserId()));
            markChanged();
        }
    }

    @StoreThread
    public final void handleReactionRemoveAll(MessageReactionUpdate update) {
        m.checkNotNullParameter(update, "update");
        this.reactions.remove(Long.valueOf(update.getMessageId()));
        markChanged();
    }

    @StoreThread
    public final void handleReactionRemoveEmoji(MessageReactionUpdate update) {
        m.checkNotNullParameter(update, "update");
        long messageId = update.getMessageId();
        String strC = update.getEmoji().c();
        ensureReactionResults(messageId, strC);
        Map<String, StoreMessageReactions$EmojiResults> map = this.reactions.get(Long.valueOf(messageId));
        if (map != null) {
            map.remove(strC);
        }
        markChanged();
    }

    public final Observable<StoreMessageReactions$EmojiResults> observeMessageReactions(long channelId, long messageId, MessageReactionEmoji emoji) {
        m.checkNotNullParameter(emoji, "emoji");
        this.dispatcher.schedule(new StoreMessageReactions$observeMessageReactions$1(this, channelId, messageId, emoji));
        Observable<StoreMessageReactions$EmojiResults> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreMessageReactions$observeMessageReactions$2(this, messageId, emoji), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        HashMap map = new HashMap(this.reactions);
        for (Map$Entry<Long, Map<String, StoreMessageReactions$EmojiResults>> map$Entry : this.reactions.entrySet()) {
            long jLongValue = map$Entry.getKey().longValue();
            HashMap map2 = new HashMap(map$Entry.getValue());
            map.put(Long.valueOf(jLongValue), map2);
            for (Map$Entry map$Entry2 : map2.entrySet()) {
                String str = (String) map$Entry2.getKey();
                Object objDeepCopy = (StoreMessageReactions$EmojiResults) map$Entry2.getValue();
                if (objDeepCopy instanceof StoreMessageReactions$EmojiResults$Users) {
                    objDeepCopy = ((StoreMessageReactions$EmojiResults$Users) objDeepCopy).deepCopy();
                }
                map2.put(str, objDeepCopy);
            }
        }
        this.reactionsSnapshot = map;
    }

    public StoreMessageReactions(Dispatcher dispatcher, StoreUser storeUser, ObservationDeck observationDeck) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(storeUser, "userStore");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.userStore = storeUser;
        this.observationDeck = observationDeck;
        this.reactions = new HashMap();
        this.reactionsSnapshot = new HashMap();
    }
}
