package com.discord.widgets.chat.overlay;

import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreSlowMode;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.guilds.GuildVerificationLevelUtils;
import com.discord.widgets.chat.overlay.ChatTypingModel;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.a.OnSubscribeLift;
import j0.l.a.OperatorDistinctUntilChanged2;
import j0.l.e.ScalarSynchronousObservable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func2;

/* JADX INFO: compiled from: ChatTypingModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ChatTypingModel {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: ChatTypingModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<ChatTypingModel> getTypingObservableForChannel(Channel resolvedChannel) {
            ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(resolvedChannel);
            Observable<ChatTypingModel> observableY = Observable.h0(new OnSubscribeLift(scalarSynchronousObservable.j, new OperatorDistinctUntilChanged2(new Func1<Channel, Object[]>() { // from class: com.discord.widgets.chat.overlay.ChatTypingModel$Companion$getTypingObservableForChannel$1
                @Override // j0.k.Func1
                public final Object[] call(Channel channel) {
                    return channel != null ? new Object[]{Long.valueOf(channel.getId()), Long.valueOf(channel.getGuildId()), Integer.valueOf(channel.getRateLimitPerUser())} : new Object[0];
                }
            }))).Y(new Func1<Channel, Observable<? extends ChatTypingModel>>() { // from class: com.discord.widgets.chat.overlay.ChatTypingModel$Companion$getTypingObservableForChannel$2
                @Override // j0.k.Func1
                public final Observable<? extends ChatTypingModel> call(final Channel channel) {
                    return channel == null ? new ScalarSynchronousObservable(ChatTypingModel.Hide.INSTANCE) : GuildVerificationLevelUtils.observeVerificationLevelTriggered$default(GuildVerificationLevelUtils.INSTANCE, channel.getGuildId(), null, null, null, 14, null).Y(new Func1<GuildVerificationLevel, Observable<? extends ChatTypingModel>>() { // from class: com.discord.widgets.chat.overlay.ChatTypingModel$Companion$getTypingObservableForChannel$2.1
                        @Override // j0.k.Func1
                        public final Observable<? extends ChatTypingModel> call(GuildVerificationLevel guildVerificationLevel) {
                            return guildVerificationLevel.compareTo(GuildVerificationLevel.NONE) > 0 ? new ScalarSynchronousObservable(ChatTypingModel.Hide.INSTANCE) : Observable.j(ChatTypingModel.INSTANCE.getTypingUsers(channel), StoreStream.INSTANCE.getSlowMode().observeCooldownSecs(Long.valueOf(channel.getId()), StoreSlowMode.Type.MessageSend.INSTANCE), new Func2<List<? extends CharSequence>, Integer, ChatTypingModel.Typing>() { // from class: com.discord.widgets.chat.overlay.ChatTypingModel.Companion.getTypingObservableForChannel.2.1.1
                                @Override // rx.functions.Func2
                                public final ChatTypingModel.Typing call(List<? extends CharSequence> list, Integer num) {
                                    Intrinsics3.checkNotNullExpressionValue(list, "typingUsers");
                                    int rateLimitPerUser = channel.getRateLimitPerUser();
                                    Intrinsics3.checkNotNullExpressionValue(num, "cooldownSecs");
                                    return new ChatTypingModel.Typing(list, rateLimitPerUser, num.intValue());
                                }
                            });
                        }
                    });
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableY, "Observable.just(resolved…          }\n            }");
            return observableY;
        }

        private final Observable<ChatTypingModel> getTypingObservableForDraft(final Channel parentChannel) {
            Observable observableY = StoreStream.INSTANCE.getSlowMode().observeCooldownSecs(Long.valueOf(parentChannel.getId()), StoreSlowMode.Type.ThreadCreate.INSTANCE).Y(new Func1<Integer, Observable<? extends ChatTypingModel>>() { // from class: com.discord.widgets.chat.overlay.ChatTypingModel$Companion$getTypingObservableForDraft$1
                @Override // j0.k.Func1
                public final Observable<? extends ChatTypingModel> call(Integer num) {
                    List listEmptyList = Collections2.emptyList();
                    int rateLimitPerUser = parentChannel.getRateLimitPerUser();
                    Intrinsics3.checkNotNullExpressionValue(num, "cooldownSecs");
                    return new ScalarSynchronousObservable(new ChatTypingModel.Typing(listEmptyList, rateLimitPerUser, num.intValue()));
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n            …ldownSecs))\n            }");
            return observableY;
        }

        private final Observable<List<CharSequence>> getTypingUsers(final Channel channel) {
            Observable<List<CharSequence>> observableR = StoreStream.INSTANCE.getUsersTyping().observeTypingUsers(channel.getId()).Y(new Func1<Set<? extends Long>, Observable<? extends List<? extends String>>>() { // from class: com.discord.widgets.chat.overlay.ChatTypingModel$Companion$getTypingUsers$1
                @Override // j0.k.Func1
                public /* bridge */ /* synthetic */ Observable<? extends List<? extends String>> call(Set<? extends Long> set) {
                    return call2((Set<Long>) set);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final Observable<? extends List<String>> call2(Set<Long> set) {
                    StoreStream.Companion companion = StoreStream.INSTANCE;
                    StoreUser users = companion.getUsers();
                    Intrinsics3.checkNotNullExpressionValue(set, "userIds");
                    return Observable.j(users.observeUsers(set), companion.getGuilds().observeComputed(channel.getGuildId(), set), new Func2<Map<Long, ? extends User>, Map<Long, ? extends GuildMember>, List<? extends String>>() { // from class: com.discord.widgets.chat.overlay.ChatTypingModel$Companion$getTypingUsers$1.1
                        @Override // rx.functions.Func2
                        public /* bridge */ /* synthetic */ List<? extends String> call(Map<Long, ? extends User> map, Map<Long, ? extends GuildMember> map2) {
                            return call2(map, (Map<Long, GuildMember>) map2);
                        }

                        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                        public final List<String> call2(Map<Long, ? extends User> map, Map<Long, GuildMember> map2) {
                            Collection<? extends User> collectionValues = map.values();
                            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(collectionValues, 10));
                            for (User user : collectionValues) {
                                arrayList.add(GuildMember.INSTANCE.getNickOrUsername((GuildMember) outline.f(user, map2), user));
                            }
                            return arrayList;
                        }
                    });
                }
            }).G(new Func1<List<? extends String>, List<? extends CharSequence>>() { // from class: com.discord.widgets.chat.overlay.ChatTypingModel$Companion$getTypingUsers$2
                @Override // j0.k.Func1
                public /* bridge */ /* synthetic */ List<? extends CharSequence> call(List<? extends String> list) {
                    return call2((List<String>) list);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final List<CharSequence> call2(List<String> list) {
                    Intrinsics3.checkNotNullExpressionValue(list, "names");
                    ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(FormatUtils.g(outline.y("!!", (String) it.next(), "!!"), new Object[0], (2 & 2) != 0 ? FormatUtils.e.j : null));
                    }
                    return _Collections.take(arrayList, 4);
                }
            }).r();
            Intrinsics3.checkNotNullExpressionValue(observableR, "StoreStream\n          .g…  .distinctUntilChanged()");
            return observableR;
        }

        public final Observable<ChatTypingModel> get() {
            Observable<ChatTypingModel> observableR = StoreStream.INSTANCE.getChannelsSelected().observeResolvedSelectedChannel().Y(new Func1<StoreChannelsSelected.ResolvedSelectedChannel, Observable<? extends ChatTypingModel>>() { // from class: com.discord.widgets.chat.overlay.ChatTypingModel$Companion$get$1
                @Override // j0.k.Func1
                public final Observable<? extends ChatTypingModel> call(StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
                    if (resolvedSelectedChannel instanceof StoreChannelsSelected.ResolvedSelectedChannel.Channel) {
                        return ChatTypingModel.INSTANCE.getTypingObservableForChannel(((StoreChannelsSelected.ResolvedSelectedChannel.Channel) resolvedSelectedChannel).getChannel());
                    }
                    return resolvedSelectedChannel instanceof StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft ? ChatTypingModel.INSTANCE.getTypingObservableForDraft(((StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft) resolvedSelectedChannel).getParentChannel()) : new ScalarSynchronousObservable(ChatTypingModel.Hide.INSTANCE);
                }
            }).r();
            Intrinsics3.checkNotNullExpressionValue(observableR, "StoreStream.getChannelsS…  .distinctUntilChanged()");
            return observableR;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: ChatTypingModel.kt */
    public static final class Hide extends ChatTypingModel {
        public static final Hide INSTANCE = new Hide();

        private Hide() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: ChatTypingModel.kt */
    public static final /* data */ class Typing extends ChatTypingModel {
        private final int channelRateLimit;
        private final int cooldownSecs;
        private final List<CharSequence> typingUsers;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public Typing(List<? extends CharSequence> list, int i, int i2) {
            super(null);
            Intrinsics3.checkNotNullParameter(list, "typingUsers");
            this.typingUsers = list;
            this.channelRateLimit = i;
            this.cooldownSecs = i2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Typing copy$default(Typing typing, List list, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                list = typing.typingUsers;
            }
            if ((i3 & 2) != 0) {
                i = typing.channelRateLimit;
            }
            if ((i3 & 4) != 0) {
                i2 = typing.cooldownSecs;
            }
            return typing.copy(list, i, i2);
        }

        public final List<CharSequence> component1() {
            return this.typingUsers;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getChannelRateLimit() {
            return this.channelRateLimit;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getCooldownSecs() {
            return this.cooldownSecs;
        }

        public final Typing copy(List<? extends CharSequence> typingUsers, int channelRateLimit, int cooldownSecs) {
            Intrinsics3.checkNotNullParameter(typingUsers, "typingUsers");
            return new Typing(typingUsers, channelRateLimit, cooldownSecs);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Typing)) {
                return false;
            }
            Typing typing = (Typing) other;
            return Intrinsics3.areEqual(this.typingUsers, typing.typingUsers) && this.channelRateLimit == typing.channelRateLimit && this.cooldownSecs == typing.cooldownSecs;
        }

        public final int getChannelRateLimit() {
            return this.channelRateLimit;
        }

        public final int getCooldownSecs() {
            return this.cooldownSecs;
        }

        public final List<CharSequence> getTypingUsers() {
            return this.typingUsers;
        }

        public int hashCode() {
            List<CharSequence> list = this.typingUsers;
            return ((((list != null ? list.hashCode() : 0) * 31) + this.channelRateLimit) * 31) + this.cooldownSecs;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Typing(typingUsers=");
            sbU.append(this.typingUsers);
            sbU.append(", channelRateLimit=");
            sbU.append(this.channelRateLimit);
            sbU.append(", cooldownSecs=");
            return outline.B(sbU, this.cooldownSecs, ")");
        }
    }

    private ChatTypingModel() {
    }

    public /* synthetic */ ChatTypingModel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
