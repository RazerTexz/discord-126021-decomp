package com.discord.widgets.chat.managereactions;

import androidx.core.app.NotificationCompat;
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
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.chat.managereactions.ManageReactionsEmojisAdapter;
import com.discord.widgets.chat.managereactions.ManageReactionsResultsAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Triple;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p582u.C12169a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.functions.Func2;
import p658rx.functions.Func3;
import p658rx.subjects.BehaviorSubject;
import p658rx.subjects.SerializedSubject;

/* JADX INFO: compiled from: ManageReactionsModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ManageReactionsModelProvider {
    private final long channelId;
    private final long messageId;
    private final ObservationDeck observationDeck;
    private final StoreChannels storeChannels;
    private final StoreGuilds storeGuilds;
    private final SerializedSubject<String, String> targetedEmojiKeySubject;

    /* JADX INFO: renamed from: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider$get$1 */
    /* JADX INFO: compiled from: ManageReactionsModel.kt */
    public static final class C81781 extends AbstractC12240o implements Function1<Boolean, Observable<Boolean>> {
        public C81781() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Observable<Boolean> invoke(Boolean bool) {
            return invoke(bool.booleanValue());
        }

        public final Observable<Boolean> invoke(final boolean z2) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<Boolean> observableM11076j = Observable.m11076j(companion.getPermissions().observePermissionsForChannel(ManageReactionsModelProvider.this.getChannelId()), companion.getGuilds().observeFromChannelId(ManageReactionsModelProvider.this.getChannelId()), new Func2<Long, Guild, Boolean>() { // from class: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider.get.1.1
                @Override // p658rx.functions.Func2
                public final Boolean call(Long l, Guild guild) {
                    return Boolean.valueOf(guild != null && PermissionUtils.canAndIsElevated(Permission.MANAGE_MESSAGES, l, z2, guild.getMfaLevel()));
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11076j, "Observable.combineLatest…ld.mfaLevel\n      )\n    }");
            return observableM11076j;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider$get$2 */
    /* JADX INFO: compiled from: ManageReactionsModel.kt */
    public static final class C81792<T, R> implements InterfaceC12589b<MeUser, Observable<? extends ManageReactionsModel>> {
        public final /* synthetic */ C81781 $getCanManageMessagesObs$1;
        public final /* synthetic */ Observable $guildMembersObservable;
        public final /* synthetic */ Observable $reactionsObs;

        /* JADX INFO: renamed from: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider$get$2$2, reason: invalid class name */
        /* JADX INFO: compiled from: ManageReactionsModel.kt */
        public static final class AnonymousClass2<T, R> implements InterfaceC12589b<Triple<? extends Boolean, ? extends List<? extends MessageReaction>, ? extends Map<Long, ? extends GuildMember>>, Observable<? extends ManageReactionsModel>> {
            public final /* synthetic */ MeUser $me;

            public AnonymousClass2(MeUser meUser) {
                this.$me = meUser;
            }

            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ Observable<? extends ManageReactionsModel> call(Triple<? extends Boolean, ? extends List<? extends MessageReaction>, ? extends Map<Long, ? extends GuildMember>> triple) {
                return call2((Triple<Boolean, ? extends List<MessageReaction>, ? extends Map<Long, GuildMember>>) triple);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Observable<? extends ManageReactionsModel> call2(Triple<Boolean, ? extends List<MessageReaction>, ? extends Map<Long, GuildMember>> triple) {
                final Boolean boolComponent1 = triple.component1();
                final List<MessageReaction> listComponent2 = triple.component2();
                final Map<Long, GuildMember> mapComponent3 = triple.component3();
                return listComponent2.isEmpty() ? new C12721k(null) : ManageReactionsModelProvider.this.targetedEmojiKeySubject.m11112r().m11083G(new InterfaceC12589b<String, MessageReactionEmoji>() { // from class: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider.get.2.2.1
                    @Override // p637j0.p641k.InterfaceC12589b
                    public final MessageReactionEmoji call(String str) {
                        T next;
                        MessageReactionEmoji emoji;
                        List list = listComponent2;
                        C12238m.checkNotNullExpressionValue(list, "reactions");
                        Iterator<T> it = list.iterator();
                        do {
                            if (!it.hasNext()) {
                                next = (T) null;
                                break;
                            }
                            next = it.next();
                        } while (!C12238m.areEqual(((MessageReaction) next).getEmoji().m8116c(), str));
                        MessageReaction messageReaction = next;
                        if (messageReaction != null && (emoji = messageReaction.getEmoji()) != null) {
                            return emoji;
                        }
                        List list2 = listComponent2;
                        C12238m.checkNotNullExpressionValue(list2, "reactions");
                        return ((MessageReaction) C12163u.first(list2)).getEmoji();
                    }
                }).m11099Y(new InterfaceC12589b<MessageReactionEmoji, Observable<? extends ManageReactionsModel>>() { // from class: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider.get.2.2.2
                    @Override // p637j0.p641k.InterfaceC12589b
                    public final Observable<? extends ManageReactionsModel> call(final MessageReactionEmoji messageReactionEmoji) {
                        ManageReactionsModelProvider manageReactionsModelProvider = ManageReactionsModelProvider.this;
                        C12238m.checkNotNullExpressionValue(messageReactionEmoji, "targetedEmoji");
                        return manageReactionsModelProvider.getUsersForReaction(messageReactionEmoji).m11083G(new InterfaceC12589b<StoreMessageReactions.EmojiResults, ManageReactionsModel>() { // from class: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider.get.2.2.2.1
                            @Override // p637j0.p641k.InterfaceC12589b
                            public final ManageReactionsModel call(StoreMessageReactions.EmojiResults emojiResults) {
                                C132822 c132822 = C132822.this;
                                ManageReactionsModelProvider manageReactionsModelProvider2 = ManageReactionsModelProvider.this;
                                List list = listComponent2;
                                C12238m.checkNotNullExpressionValue(list, "reactions");
                                C12238m.checkNotNullExpressionValue(emojiResults, "users");
                                MessageReactionEmoji messageReactionEmoji2 = messageReactionEmoji;
                                Boolean bool = boolComponent1;
                                C12238m.checkNotNullExpressionValue(bool, "canManageMessages");
                                boolean zBooleanValue = bool.booleanValue();
                                long id2 = AnonymousClass2.this.$me.getId();
                                Map map = mapComponent3;
                                C12238m.checkNotNullExpressionValue(map, "guildMembers");
                                return manageReactionsModelProvider2.createModel(list, emojiResults, messageReactionEmoji2, zBooleanValue, id2, map);
                            }
                        });
                    }
                });
            }
        }

        public C81792(C81781 c81781, Observable observable, Observable observable2) {
            this.$getCanManageMessagesObs$1 = c81781;
            this.$reactionsObs = observable;
            this.$guildMembersObservable = observable2;
        }

        @Override // p637j0.p641k.InterfaceC12589b
        public final Observable<? extends ManageReactionsModel> call(MeUser meUser) {
            return Observable.m11075i(this.$getCanManageMessagesObs$1.invoke(meUser.getMfaEnabled()), this.$reactionsObs, this.$guildMembersObservable, new Func3<Boolean, List<? extends MessageReaction>, Map<Long, ? extends GuildMember>, Triple<? extends Boolean, ? extends List<? extends MessageReaction>, ? extends Map<Long, ? extends GuildMember>>>() { // from class: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider.get.2.1
                @Override // p658rx.functions.Func3
                public /* bridge */ /* synthetic */ Triple<? extends Boolean, ? extends List<? extends MessageReaction>, ? extends Map<Long, ? extends GuildMember>> call(Boolean bool, List<? extends MessageReaction> list, Map<Long, ? extends GuildMember> map) {
                    return call2(bool, (List<MessageReaction>) list, (Map<Long, GuildMember>) map);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final Triple<Boolean, List<MessageReaction>, Map<Long, GuildMember>> call2(Boolean bool, List<MessageReaction> list, Map<Long, GuildMember> map) {
                    return new Triple<>(bool, list, map);
                }
            }).m11099Y(new AnonymousClass2(meUser));
        }
    }

    public ManageReactionsModelProvider(long j, long j2, String str, StoreChannels storeChannels, StoreGuilds storeGuilds, ObservationDeck observationDeck) {
        C12238m.checkNotNullParameter(storeChannels, "storeChannels");
        C12238m.checkNotNullParameter(storeGuilds, "storeGuilds");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        this.channelId = j;
        this.messageId = j2;
        this.storeChannels = storeChannels;
        this.storeGuilds = storeGuilds;
        this.observationDeck = observationDeck;
        this.targetedEmojiKeySubject = new SerializedSubject<>(BehaviorSubject.m11130l0(str));
    }

    private final ManageReactionsModel createModel(List<MessageReaction> reactions, StoreMessageReactions.EmojiResults results, MessageReactionEmoji targetedEmoji, boolean canManageMessages, long myId, Map<Long, GuildMember> guildMembers) {
        List listListOf;
        ArrayList arrayList = new ArrayList();
        for (MessageReaction messageReaction : reactions) {
            arrayList.add(new ManageReactionsEmojisAdapter.ReactionEmojiItem(messageReaction, C12238m.areEqual(messageReaction.getEmoji(), targetedEmoji)));
        }
        if (results instanceof StoreMessageReactions.EmojiResults.Users) {
            StoreMessageReactions.EmojiResults.Users users = (StoreMessageReactions.EmojiResults.Users) results;
            Collection<User> collectionValues = users.getUsers().values();
            C12238m.checkNotNullExpressionValue(collectionValues, "results.users.values");
            ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(collectionValues, 10));
            for (User user : collectionValues) {
                C12238m.checkNotNullExpressionValue(user, "user");
                arrayList2.add(new ManageReactionsResultsAdapter.ReactionUserItem(user, this.channelId, this.messageId, users.getEmoji(), canManageMessages || user.getId() == myId, (GuildMember) C1643a.m849f(user, guildMembers)));
            }
            listListOf = C12163u.toList(arrayList2);
        } else if (results instanceof StoreMessageReactions.EmojiResults.Loading) {
            listListOf = C12145m.listOf(new ManageReactionsResultsAdapter.LoadingItem());
        } else {
            if (!(results instanceof StoreMessageReactions.EmojiResults.Failure)) {
                throw new NoWhenBranchMatchedException();
            }
            StoreMessageReactions.EmojiResults.Failure failure = (StoreMessageReactions.EmojiResults.Failure) results;
            listListOf = C12145m.listOf(new ManageReactionsResultsAdapter.ErrorItem(failure.getChannelId(), failure.getMessageId(), failure.getEmoji()));
        }
        return new ManageReactionsModel(arrayList, listListOf);
    }

    private final Observable<StoreMessageReactions.EmojiResults> getUsersForReaction(MessageReactionEmoji targetedEmoji) {
        return StoreStream.INSTANCE.getMessageReactions().observeMessageReactions(this.channelId, this.messageId, targetedEmoji);
    }

    public final Observable<ManageReactionsModel> get() {
        C81781 c81781 = new C81781();
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable observableM11083G = companion.getMessages().observeMessagesForChannel(this.channelId, this.messageId).m11083G(new InterfaceC12589b<Message, Map<String, ? extends MessageReaction>>() { // from class: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider$get$reactionsObs$1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Map<String, MessageReaction> call(Message message) {
                Map<String, MessageReaction> reactionsMap;
                return (message == null || (reactionsMap = message.getReactionsMap()) == null) ? C12136h0.emptyMap() : reactionsMap;
            }
        }).m11083G(new InterfaceC12589b<Map<String, ? extends MessageReaction>, List<? extends MessageReaction>>() { // from class: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider$get$reactionsObs$2
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ List<? extends MessageReaction> call(Map<String, ? extends MessageReaction> map) {
                return call2((Map<String, MessageReaction>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final List<MessageReaction> call2(Map<String, MessageReaction> map) {
                return C12163u.sortedWith(map.values(), new Comparator() { // from class: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider$get$reactionsObs$2$$special$$inlined$sortedByDescending$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return C12169a.compareValues(Integer.valueOf(((MessageReaction) t2).getCount()), Integer.valueOf(((MessageReaction) t).getCount()));
                    }
                });
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "StoreStream\n        .get…ion -> reaction.count } }");
        Observable observableM11099Y = StoreUser.observeMe$default(companion.getUsers(), false, 1, null).m11099Y(new C81792(c81781, observableM11083G, ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this.storeChannels, this.storeGuilds}, false, null, null, new ManageReactionsModelProvider$get$guildMembersObservable$1(this), 14, null)));
        C12238m.checkNotNullExpressionValue(observableM11099Y, "StoreStream\n        .get…              }\n        }");
        Observable<ManageReactionsModel> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11099Y).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "StoreStream\n        .get…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final long getMessageId() {
        return this.messageId;
    }

    public final void onEmojiTargeted(String emojiKey) {
        C12238m.checkNotNullParameter(emojiKey, "emojiKey");
        this.targetedEmojiKeySubject.f27653k.onNext(emojiKey);
    }

    public /* synthetic */ ManageReactionsModelProvider(long j, long j2, String str, StoreChannels storeChannels, StoreGuilds storeGuilds, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, (i & 4) != 0 ? null : str, (i & 8) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 16) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 32) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }
}
