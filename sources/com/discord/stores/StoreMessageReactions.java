package com.discord.stores;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.api.message.reaction.MessageReactionEmoji;
import com.discord.api.message.reaction.MessageReactionUpdate;
import com.discord.models.user.CoreUser;
import com.discord.models.user.User;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.input.MentionUtils;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: StoreMessageReactions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessageReactions extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final Map<Long, Map<String, EmojiResults>> reactions;
    private Map<Long, ? extends Map<String, ? extends EmojiResults>> reactionsSnapshot;
    private final StoreUser userStore;

    /* JADX INFO: compiled from: StoreMessageReactions.kt */
    public static abstract class EmojiResults {

        /* JADX INFO: compiled from: StoreMessageReactions.kt */
        public static final /* data */ class Failure extends EmojiResults {
            private final long channelId;
            private final MessageReactionEmoji emoji;
            private final long messageId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Failure(long j, long j2, MessageReactionEmoji messageReactionEmoji) {
                super(null);
                Intrinsics3.checkNotNullParameter(messageReactionEmoji, "emoji");
                this.channelId = j;
                this.messageId = j2;
                this.emoji = messageReactionEmoji;
            }

            public static /* synthetic */ Failure copy$default(Failure failure, long j, long j2, MessageReactionEmoji messageReactionEmoji, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = failure.channelId;
                }
                long j3 = j;
                if ((i & 2) != 0) {
                    j2 = failure.messageId;
                }
                long j4 = j2;
                if ((i & 4) != 0) {
                    messageReactionEmoji = failure.emoji;
                }
                return failure.copy(j3, j4, messageReactionEmoji);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final long getMessageId() {
                return this.messageId;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final MessageReactionEmoji getEmoji() {
                return this.emoji;
            }

            public final Failure copy(long channelId, long messageId, MessageReactionEmoji emoji) {
                Intrinsics3.checkNotNullParameter(emoji, "emoji");
                return new Failure(channelId, messageId, emoji);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Failure)) {
                    return false;
                }
                Failure failure = (Failure) other;
                return this.channelId == failure.channelId && this.messageId == failure.messageId && Intrinsics3.areEqual(this.emoji, failure.emoji);
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public final MessageReactionEmoji getEmoji() {
                return this.emoji;
            }

            public final long getMessageId() {
                return this.messageId;
            }

            public int hashCode() {
                int iA = (b.a(this.messageId) + (b.a(this.channelId) * 31)) * 31;
                MessageReactionEmoji messageReactionEmoji = this.emoji;
                return iA + (messageReactionEmoji != null ? messageReactionEmoji.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Failure(channelId=");
                sbU.append(this.channelId);
                sbU.append(", messageId=");
                sbU.append(this.messageId);
                sbU.append(", emoji=");
                sbU.append(this.emoji);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* JADX INFO: compiled from: StoreMessageReactions.kt */
        public static final class Loading extends EmojiResults {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: StoreMessageReactions.kt */
        public static final /* data */ class Users extends EmojiResults {
            private final long channelId;
            private final MessageReactionEmoji emoji;
            private final long messageId;
            private final LinkedHashMap<Long, User> users;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Users(LinkedHashMap<Long, User> linkedHashMap, long j, long j2, MessageReactionEmoji messageReactionEmoji) {
                super(null);
                Intrinsics3.checkNotNullParameter(linkedHashMap, "users");
                Intrinsics3.checkNotNullParameter(messageReactionEmoji, "emoji");
                this.users = linkedHashMap;
                this.channelId = j;
                this.messageId = j2;
                this.emoji = messageReactionEmoji;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Users copy$default(Users users, LinkedHashMap linkedHashMap, long j, long j2, MessageReactionEmoji messageReactionEmoji, int i, Object obj) {
                if ((i & 1) != 0) {
                    linkedHashMap = users.users;
                }
                if ((i & 2) != 0) {
                    j = users.channelId;
                }
                long j3 = j;
                if ((i & 4) != 0) {
                    j2 = users.messageId;
                }
                long j4 = j2;
                if ((i & 8) != 0) {
                    messageReactionEmoji = users.emoji;
                }
                return users.copy(linkedHashMap, j3, j4, messageReactionEmoji);
            }

            public final LinkedHashMap<Long, User> component1() {
                return this.users;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final long getMessageId() {
                return this.messageId;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final MessageReactionEmoji getEmoji() {
                return this.emoji;
            }

            public final Users copy(LinkedHashMap<Long, User> users, long channelId, long messageId, MessageReactionEmoji emoji) {
                Intrinsics3.checkNotNullParameter(users, "users");
                Intrinsics3.checkNotNullParameter(emoji, "emoji");
                return new Users(users, channelId, messageId, emoji);
            }

            public final Users deepCopy() {
                return new Users(new LinkedHashMap(this.users), this.channelId, this.messageId, this.emoji);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Users)) {
                    return false;
                }
                Users users = (Users) other;
                return Intrinsics3.areEqual(this.users, users.users) && this.channelId == users.channelId && this.messageId == users.messageId && Intrinsics3.areEqual(this.emoji, users.emoji);
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public final MessageReactionEmoji getEmoji() {
                return this.emoji;
            }

            public final long getMessageId() {
                return this.messageId;
            }

            public final LinkedHashMap<Long, User> getUsers() {
                return this.users;
            }

            public int hashCode() {
                LinkedHashMap<Long, User> linkedHashMap = this.users;
                int iA = (b.a(this.messageId) + ((b.a(this.channelId) + ((linkedHashMap != null ? linkedHashMap.hashCode() : 0) * 31)) * 31)) * 31;
                MessageReactionEmoji messageReactionEmoji = this.emoji;
                return iA + (messageReactionEmoji != null ? messageReactionEmoji.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Users(users=");
                sbU.append(this.users);
                sbU.append(", channelId=");
                sbU.append(this.channelId);
                sbU.append(", messageId=");
                sbU.append(this.messageId);
                sbU.append(", emoji=");
                sbU.append(this.emoji);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private EmojiResults() {
        }

        public /* synthetic */ EmojiResults(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessageReactions$deleteEmoji$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessageReactions.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessageReactions$fetchReactions$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessageReactions.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends com.discord.api.user.User>, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ MessageReactionEmoji $emoji;
        public final /* synthetic */ long $messageId;

        /* JADX INFO: renamed from: com.discord.stores.StoreMessageReactions$fetchReactions$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreMessageReactions.kt */
        public static final class C01531 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ List $reactionUsers;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01531(List list) {
                super(0);
                this.$reactionUsers = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                StoreMessageReactions storeMessageReactions = StoreMessageReactions.this;
                long j = anonymousClass1.$channelId;
                long j2 = anonymousClass1.$messageId;
                MessageReactionEmoji messageReactionEmoji = anonymousClass1.$emoji;
                List list = this.$reactionUsers;
                ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new CoreUser((com.discord.api.user.User) it.next()));
                }
                storeMessageReactions.handleReactionUsers(j, j2, messageReactionEmoji, arrayList);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2, MessageReactionEmoji messageReactionEmoji) {
            super(1);
            this.$channelId = j;
            this.$messageId = j2;
            this.$emoji = messageReactionEmoji;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.discord.api.user.User> list) {
            invoke2((List<com.discord.api.user.User>) list);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<com.discord.api.user.User> list) {
            Intrinsics3.checkNotNullParameter(list, "reactionUsers");
            StoreMessageReactions.this.dispatcher.schedule(new C01531(list));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessageReactions$fetchReactions$2, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessageReactions.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ MessageReactionEmoji $emoji;
        public final /* synthetic */ long $messageId;

        /* JADX INFO: renamed from: com.discord.stores.StoreMessageReactions$fetchReactions$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreMessageReactions.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                StoreMessageReactions.this.handleLoadReactionUsersFailure(anonymousClass2.$channelId, anonymousClass2.$messageId, anonymousClass2.$emoji);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(long j, long j2, MessageReactionEmoji messageReactionEmoji) {
            super(1);
            this.$channelId = j;
            this.$messageId = j2;
            this.$emoji = messageReactionEmoji;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            StoreMessageReactions.this.dispatcher.schedule(new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessageReactions$forceRetryFetchReactions$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessageReactions.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ MessageReactionEmoji $emoji;
        public final /* synthetic */ long $messageId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, MessageReactionEmoji messageReactionEmoji, long j2) {
            super(0);
            this.$messageId = j;
            this.$emoji = messageReactionEmoji;
            this.$channelId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Map map = (Map) StoreMessageReactions.this.reactions.get(Long.valueOf(this.$messageId));
            if (map != null) {
            }
            StoreMessageReactions.this.fetchReactions(this.$channelId, this.$messageId, this.$emoji);
            StoreMessageReactions.this.markChanged();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessageReactions$observeMessageReactions$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessageReactions.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ MessageReactionEmoji $emoji;
        public final /* synthetic */ long $messageId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2, MessageReactionEmoji messageReactionEmoji) {
            super(0);
            this.$channelId = j;
            this.$messageId = j2;
            this.$emoji = messageReactionEmoji;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMessageReactions.this.fetchReactions(this.$channelId, this.$messageId, this.$emoji);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessageReactions$observeMessageReactions$2, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessageReactions.kt */
    public static final class AnonymousClass2 extends Lambda implements Function0<EmojiResults> {
        public final /* synthetic */ MessageReactionEmoji $emoji;
        public final /* synthetic */ long $messageId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(long j, MessageReactionEmoji messageReactionEmoji) {
            super(0);
            this.$messageId = j;
            this.$emoji = messageReactionEmoji;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final EmojiResults invoke() {
            EmojiResults emojiResults;
            Map map = (Map) StoreMessageReactions.this.reactionsSnapshot.get(Long.valueOf(this.$messageId));
            return (map == null || (emojiResults = (EmojiResults) map.get(this.$emoji.c())) == null) ? EmojiResults.Loading.INSTANCE : emojiResults;
        }
    }

    public /* synthetic */ StoreMessageReactions(Dispatcher dispatcher, StoreUser storeUser, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, storeUser, (i & 4) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    @Store3
    private final EmojiResults ensureReactionResults(long messageId, String emoji) {
        Map<String, EmojiResults> map = this.reactions.get(Long.valueOf(messageId));
        if (map == null) {
            map = new HashMap<>();
        }
        EmojiResults emojiResults = map.get(emoji);
        if (emojiResults == null) {
            emojiResults = EmojiResults.Loading.INSTANCE;
        }
        map.put(emoji, emojiResults);
        this.reactions.put(Long.valueOf(messageId), map);
        return emojiResults;
    }

    @Store3
    private final void fetchReactions(long channelId, long messageId, MessageReactionEmoji emoji) {
        EmojiResults emojiResultsEnsureReactionResults = ensureReactionResults(messageId, emoji.c());
        if ((emojiResultsEnsureReactionResults instanceof EmojiResults.Users) && (!((EmojiResults.Users) emojiResultsEnsureReactionResults).getUsers().isEmpty())) {
            return;
        }
        String reactionEmojiRequestParam = getReactionEmojiRequestParam(emoji);
        Map<String, EmojiResults> map = this.reactions.get(Long.valueOf(messageId));
        if (map != null) {
            map.put(emoji.c(), EmojiResults.Loading.INSTANCE);
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getReactionUsers(channelId, messageId, reactionEmojiRequestParam, 100), false, 1, null), (Class<?>) StoreMessageReactions.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2(channelId, messageId, emoji)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(channelId, messageId, emoji));
    }

    private final String getReactionEmojiRequestParam(MessageReactionEmoji emoji) {
        if (!emoji.e()) {
            String name = emoji.getName();
            return name != null ? name : "";
        }
        return emoji.getName() + MentionUtils.EMOJIS_AND_STICKERS_CHAR + emoji.getId();
    }

    @Store3
    private final void handleLoadReactionUsersFailure(long channelId, long messageId, MessageReactionEmoji emoji) {
        ensureReactionResults(messageId, emoji.c());
        Map<String, EmojiResults> map = this.reactions.get(Long.valueOf(messageId));
        if (map != null) {
            map.put(emoji.c(), new EmojiResults.Failure(channelId, messageId, emoji));
        }
        markChanged();
    }

    @Store3
    private final void handleReactionUsers(long channelId, long messageId, MessageReactionEmoji emoji, List<? extends User> reactionUsers) {
        ensureReactionResults(messageId, emoji.c());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : reactionUsers) {
            linkedHashMap.put(Long.valueOf(((User) obj).getId()), obj);
        }
        Map<String, EmojiResults> map = this.reactions.get(Long.valueOf(messageId));
        if (map != null) {
            map.put(emoji.c(), new EmojiResults.Users(linkedHashMap, channelId, messageId, emoji));
        }
        markChanged();
    }

    public final void deleteEmoji(long channelId, long messageId, MessageReactionEmoji emoji, long userId) {
        Intrinsics3.checkNotNullParameter(emoji, "emoji");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().removeReaction(channelId, messageId, getReactionEmojiRequestParam(emoji), userId), false, 1, null), (Class<?>) StoreMessageReactions.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), AnonymousClass1.INSTANCE);
    }

    public final void forceRetryFetchReactions(long channelId, long messageId, MessageReactionEmoji emoji) {
        Intrinsics3.checkNotNullParameter(emoji, "emoji");
        this.dispatcher.schedule(new AnonymousClass1(messageId, emoji, channelId));
    }

    @Store3
    public final void handleConnectionOpen() {
        if (!this.reactions.isEmpty()) {
            this.reactions.clear();
            markChanged();
        }
    }

    @Store3
    public final void handleReactionAdd(MessageReactionUpdate update) {
        Intrinsics3.checkNotNullParameter(update, "update");
        User user = this.userStore.getUsersInternal$app_productionGoogleRelease().get(Long.valueOf(update.getUserId()));
        if (user != null) {
            EmojiResults emojiResultsEnsureReactionResults = ensureReactionResults(update.getMessageId(), update.getEmoji().c());
            if (!(emojiResultsEnsureReactionResults instanceof EmojiResults.Users)) {
                emojiResultsEnsureReactionResults = null;
            }
            EmojiResults.Users users = (EmojiResults.Users) emojiResultsEnsureReactionResults;
            if (users != null) {
                users.getUsers().put(Long.valueOf(update.getUserId()), user);
                markChanged();
            }
        }
    }

    @Store3
    public final void handleReactionRemove(MessageReactionUpdate update) {
        Intrinsics3.checkNotNullParameter(update, "update");
        EmojiResults emojiResultsEnsureReactionResults = ensureReactionResults(update.getMessageId(), update.getEmoji().c());
        if (!(emojiResultsEnsureReactionResults instanceof EmojiResults.Users)) {
            emojiResultsEnsureReactionResults = null;
        }
        EmojiResults.Users users = (EmojiResults.Users) emojiResultsEnsureReactionResults;
        if (users != null) {
            users.getUsers().remove(Long.valueOf(update.getUserId()));
            markChanged();
        }
    }

    @Store3
    public final void handleReactionRemoveAll(MessageReactionUpdate update) {
        Intrinsics3.checkNotNullParameter(update, "update");
        this.reactions.remove(Long.valueOf(update.getMessageId()));
        markChanged();
    }

    @Store3
    public final void handleReactionRemoveEmoji(MessageReactionUpdate update) {
        Intrinsics3.checkNotNullParameter(update, "update");
        long messageId = update.getMessageId();
        String strC = update.getEmoji().c();
        ensureReactionResults(messageId, strC);
        Map<String, EmojiResults> map = this.reactions.get(Long.valueOf(messageId));
        if (map != null) {
            map.remove(strC);
        }
        markChanged();
    }

    public final Observable<EmojiResults> observeMessageReactions(long channelId, long messageId, MessageReactionEmoji emoji) {
        Intrinsics3.checkNotNullParameter(emoji, "emoji");
        this.dispatcher.schedule(new AnonymousClass1(channelId, messageId, emoji));
        Observable<EmojiResults> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass2(messageId, emoji), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        HashMap map = new HashMap(this.reactions);
        for (Map.Entry<Long, Map<String, EmojiResults>> entry : this.reactions.entrySet()) {
            long jLongValue = entry.getKey().longValue();
            HashMap map2 = new HashMap(entry.getValue());
            map.put(Long.valueOf(jLongValue), map2);
            for (Map.Entry entry2 : map2.entrySet()) {
                String str = (String) entry2.getKey();
                Object objDeepCopy = (EmojiResults) entry2.getValue();
                if (objDeepCopy instanceof EmojiResults.Users) {
                    objDeepCopy = ((EmojiResults.Users) objDeepCopy).deepCopy();
                }
                map2.put(str, objDeepCopy);
            }
        }
        this.reactionsSnapshot = map;
    }

    public StoreMessageReactions(Dispatcher dispatcher, StoreUser storeUser, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(storeUser, "userStore");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.userStore = storeUser;
        this.observationDeck = observationDeck;
        this.reactions = new HashMap();
        this.reactionsSnapshot = new HashMap();
    }
}
