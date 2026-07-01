package com.discord.widgets.chat.managereactions;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.api.message.reaction.MessageReactionEmoji;
import com.discord.api.permission.Permission;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreMessageReactions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.managereactions.ManageReactionsEmojisAdapter;
import com.discord.widgets.chat.managereactions.ManageReactionsResultsAdapter;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t._Collections;
import d0.u.a;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Tuples3;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func2;
import rx.functions.Func3;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;

/* JADX INFO: renamed from: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider, reason: use source file name */
/* JADX INFO: compiled from: ManageReactionsModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ManageReactionsModel2 {
    private final long channelId;
    private final long messageId;
    private final ObservationDeck observationDeck;
    private final StoreChannels storeChannels;
    private final StoreGuilds storeGuilds;
    private final SerializedSubject<String, String> targetedEmojiKeySubject;

    /* JADX INFO: renamed from: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider$get$1, reason: invalid class name */
    /* JADX INFO: compiled from: ManageReactionsModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Boolean, Observable<Boolean>> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Observable<Boolean> invoke(Boolean bool) {
            return invoke(bool.booleanValue());
        }

        public final Observable<Boolean> invoke(final boolean z2) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<Boolean> observableJ = Observable.j(companion.getPermissions().observePermissionsForChannel(ManageReactionsModel2.this.getChannelId()), companion.getGuilds().observeFromChannelId(ManageReactionsModel2.this.getChannelId()), new Func2<Long, Guild, Boolean>() { // from class: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider.get.1.1
                @Override // rx.functions.Func2
                public final Boolean call(Long l, Guild guild) {
                    return Boolean.valueOf(guild != null && PermissionUtils.canAndIsElevated(Permission.MANAGE_MESSAGES, l, z2, guild.getMfaLevel()));
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…ld.mfaLevel\n      )\n    }");
            return observableJ;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider$get$2, reason: invalid class name */
    /* JADX INFO: compiled from: ManageReactionsModel.kt */
    public static final class AnonymousClass2<T, R> implements Func1<MeUser, Observable<? extends ManageReactionsModel>> {
        public final /* synthetic */ AnonymousClass1 $getCanManageMessagesObs$1;
        public final /* synthetic */ Observable $guildMembersObservable;
        public final /* synthetic */ Observable $reactionsObs;

        /* JADX INFO: renamed from: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider$get$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: ManageReactionsModel.kt */
        public static final class C02812<T, R> implements Func1<Tuples3<? extends Boolean, ? extends List<? extends MessageReaction>, ? extends Map<Long, ? extends GuildMember>>, Observable<? extends ManageReactionsModel>> {
            public final /* synthetic */ MeUser $me;

            public C02812(MeUser meUser) {
                this.$me = meUser;
            }

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Observable<? extends ManageReactionsModel> call(Tuples3<? extends Boolean, ? extends List<? extends MessageReaction>, ? extends Map<Long, ? extends GuildMember>> tuples3) {
                return call2((Tuples3<Boolean, ? extends List<MessageReaction>, ? extends Map<Long, GuildMember>>) tuples3);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Observable<? extends ManageReactionsModel> call2(Tuples3<Boolean, ? extends List<MessageReaction>, ? extends Map<Long, GuildMember>> tuples3) {
                final Boolean boolComponent1 = tuples3.component1();
                final List<MessageReaction> listComponent2 = tuples3.component2();
                final Map<Long, GuildMember> mapComponent3 = tuples3.component3();
                return listComponent2.isEmpty() ? new ScalarSynchronousObservable(null) : ManageReactionsModel2.this.targetedEmojiKeySubject.r().G(new Func1<String, MessageReactionEmoji>() { // from class: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider.get.2.2.1
                    @Override // j0.k.Func1
                    public final MessageReactionEmoji call(String str) {
                        T next;
                        MessageReactionEmoji emoji;
                        List list = listComponent2;
                        Intrinsics3.checkNotNullExpressionValue(list, "reactions");
                        Iterator<T> it = list.iterator();
                        do {
                            if (!it.hasNext()) {
                                next = (T) null;
                                break;
                            }
                            next = it.next();
                        } while (!Intrinsics3.areEqual(((MessageReaction) next).getEmoji().c(), str));
                        MessageReaction messageReaction = next;
                        if (messageReaction != null && (emoji = messageReaction.getEmoji()) != null) {
                            return emoji;
                        }
                        List list2 = listComponent2;
                        Intrinsics3.checkNotNullExpressionValue(list2, "reactions");
                        return ((MessageReaction) _Collections.first(list2)).getEmoji();
                    }
                }).Y(new Func1<MessageReactionEmoji, Observable<? extends ManageReactionsModel>>() { // from class: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider.get.2.2.2
                    @Override // j0.k.Func1
                    public final Observable<? extends ManageReactionsModel> call(final MessageReactionEmoji messageReactionEmoji) {
                        ManageReactionsModel2 manageReactionsModel2 = ManageReactionsModel2.this;
                        Intrinsics3.checkNotNullExpressionValue(messageReactionEmoji, "targetedEmoji");
                        return manageReactionsModel2.getUsersForReaction(messageReactionEmoji).G(new Func1<StoreMessageReactions.EmojiResults, ManageReactionsModel>() { // from class: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider.get.2.2.2.1
                            @Override // j0.k.Func1
                            public final ManageReactionsModel call(StoreMessageReactions.EmojiResults emojiResults) {
                                C02822 c02822 = C02822.this;
                                ManageReactionsModel2 manageReactionsModel3 = ManageReactionsModel2.this;
                                List list = listComponent2;
                                Intrinsics3.checkNotNullExpressionValue(list, "reactions");
                                Intrinsics3.checkNotNullExpressionValue(emojiResults, "users");
                                MessageReactionEmoji messageReactionEmoji2 = messageReactionEmoji;
                                Boolean bool = boolComponent1;
                                Intrinsics3.checkNotNullExpressionValue(bool, "canManageMessages");
                                boolean zBooleanValue = bool.booleanValue();
                                long id2 = C02812.this.$me.getId();
                                Map map = mapComponent3;
                                Intrinsics3.checkNotNullExpressionValue(map, "guildMembers");
                                return manageReactionsModel3.createModel(list, emojiResults, messageReactionEmoji2, zBooleanValue, id2, map);
                            }
                        });
                    }
                });
            }
        }

        public AnonymousClass2(AnonymousClass1 anonymousClass1, Observable observable, Observable observable2) {
            this.$getCanManageMessagesObs$1 = anonymousClass1;
            this.$reactionsObs = observable;
            this.$guildMembersObservable = observable2;
        }

        @Override // j0.k.Func1
        public final Observable<? extends ManageReactionsModel> call(MeUser meUser) {
            return Observable.i(this.$getCanManageMessagesObs$1.invoke(meUser.getMfaEnabled()), this.$reactionsObs, this.$guildMembersObservable, new Func3<Boolean, List<? extends MessageReaction>, Map<Long, ? extends GuildMember>, Tuples3<? extends Boolean, ? extends List<? extends MessageReaction>, ? extends Map<Long, ? extends GuildMember>>>() { // from class: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider.get.2.1
                @Override // rx.functions.Func3
                public /* bridge */ /* synthetic */ Tuples3<? extends Boolean, ? extends List<? extends MessageReaction>, ? extends Map<Long, ? extends GuildMember>> call(Boolean bool, List<? extends MessageReaction> list, Map<Long, ? extends GuildMember> map) {
                    return call2(bool, (List<MessageReaction>) list, (Map<Long, GuildMember>) map);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final Tuples3<Boolean, List<MessageReaction>, Map<Long, GuildMember>> call2(Boolean bool, List<MessageReaction> list, Map<Long, GuildMember> map) {
                    return new Tuples3<>(bool, list, map);
                }
            }).Y(new C02812(meUser));
        }
    }

    public ManageReactionsModel2(long j, long j2, String str, StoreChannels storeChannels, StoreGuilds storeGuilds, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.channelId = j;
        this.messageId = j2;
        this.storeChannels = storeChannels;
        this.storeGuilds = storeGuilds;
        this.observationDeck = observationDeck;
        this.targetedEmojiKeySubject = new SerializedSubject<>(BehaviorSubject.l0(str));
    }

    private final ManageReactionsModel createModel(List<MessageReaction> reactions, StoreMessageReactions.EmojiResults results, MessageReactionEmoji targetedEmoji, boolean canManageMessages, long myId, Map<Long, GuildMember> guildMembers) {
        List listListOf;
        ArrayList arrayList = new ArrayList();
        for (MessageReaction messageReaction : reactions) {
            arrayList.add(new ManageReactionsEmojisAdapter.ReactionEmojiItem(messageReaction, Intrinsics3.areEqual(messageReaction.getEmoji(), targetedEmoji)));
        }
        if (results instanceof StoreMessageReactions.EmojiResults.Users) {
            StoreMessageReactions.EmojiResults.Users users = (StoreMessageReactions.EmojiResults.Users) results;
            Collection<User> collectionValues = users.getUsers().values();
            Intrinsics3.checkNotNullExpressionValue(collectionValues, "results.users.values");
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(collectionValues, 10));
            for (User user : collectionValues) {
                Intrinsics3.checkNotNullExpressionValue(user, "user");
                arrayList2.add(new ManageReactionsResultsAdapter.ReactionUserItem(user, this.channelId, this.messageId, users.getEmoji(), canManageMessages || user.getId() == myId, (GuildMember) outline.f(user, guildMembers)));
            }
            listListOf = _Collections.toList(arrayList2);
        } else if (results instanceof StoreMessageReactions.EmojiResults.Loading) {
            listListOf = CollectionsJVM.listOf(new ManageReactionsResultsAdapter.LoadingItem());
        } else {
            if (!(results instanceof StoreMessageReactions.EmojiResults.Failure)) {
                throw new NoWhenBranchMatchedException();
            }
            StoreMessageReactions.EmojiResults.Failure failure = (StoreMessageReactions.EmojiResults.Failure) results;
            listListOf = CollectionsJVM.listOf(new ManageReactionsResultsAdapter.ErrorItem(failure.getChannelId(), failure.getMessageId(), failure.getEmoji()));
        }
        return new ManageReactionsModel(arrayList, listListOf);
    }

    private final Observable<StoreMessageReactions.EmojiResults> getUsersForReaction(MessageReactionEmoji targetedEmoji) {
        return StoreStream.INSTANCE.getMessageReactions().observeMessageReactions(this.channelId, this.messageId, targetedEmoji);
    }

    public final Observable<ManageReactionsModel> get() {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable observableG = companion.getMessages().observeMessagesForChannel(this.channelId, this.messageId).G(new Func1<Message, Map<String, ? extends MessageReaction>>() { // from class: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider$get$reactionsObs$1
            @Override // j0.k.Func1
            public final Map<String, MessageReaction> call(Message message) {
                Map<String, MessageReaction> reactionsMap;
                return (message == null || (reactionsMap = message.getReactionsMap()) == null) ? Maps6.emptyMap() : reactionsMap;
            }
        }).G(new Func1<Map<String, ? extends MessageReaction>, List<? extends MessageReaction>>() { // from class: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider$get$reactionsObs$2
            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ List<? extends MessageReaction> call(Map<String, ? extends MessageReaction> map) {
                return call2((Map<String, MessageReaction>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final List<MessageReaction> call2(Map<String, MessageReaction> map) {
                return _Collections.sortedWith(map.values(), new Comparator() { // from class: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider$get$reactionsObs$2$$special$$inlined$sortedByDescending$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return a.compareValues(Integer.valueOf(((MessageReaction) t2).getCount()), Integer.valueOf(((MessageReaction) t).getCount()));
                    }
                });
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableG, "StoreStream\n        .get…ion -> reaction.count } }");
        Observable observableY = StoreUser.observeMe$default(companion.getUsers(), false, 1, null).Y(new AnonymousClass2(anonymousClass1, observableG, ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this.storeChannels, this.storeGuilds}, false, null, null, new ManageReactionsModel3(this), 14, null)));
        Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n        .get…              }\n        }");
        Observable<ManageReactionsModel> observableR = ObservableExtensionsKt.computationLatest(observableY).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "StoreStream\n        .get…  .distinctUntilChanged()");
        return observableR;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final long getMessageId() {
        return this.messageId;
    }

    public final void onEmojiTargeted(String emojiKey) {
        Intrinsics3.checkNotNullParameter(emojiKey, "emojiKey");
        this.targetedEmojiKeySubject.k.onNext(emojiKey);
    }

    public /* synthetic */ ManageReactionsModel2(long j, long j2, String str, StoreChannels storeChannels, StoreGuilds storeGuilds, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, (i & 4) != 0 ? null : str, (i & 8) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 16) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 32) != 0 ? ObservationDeck4.get() : observationDeck);
    }
}
