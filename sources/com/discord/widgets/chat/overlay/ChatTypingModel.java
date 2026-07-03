package com.discord.widgets.chat.overlay;

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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p643a.C12666r;
import p637j0.p642l.p643a.C12676u0;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.functions.Func2;

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
            C12721k c12721k = new C12721k(resolvedChannel);
            Observable<ChatTypingModel> observableM11099Y = Observable.m11074h0(new C12666r(c12721k.f27640j, new C12676u0(new InterfaceC12589b<Channel, Object[]>() { // from class: com.discord.widgets.chat.overlay.ChatTypingModel$Companion$getTypingObservableForChannel$1
                @Override // p637j0.p641k.InterfaceC12589b
                public final Object[] call(Channel channel) {
                    return channel != null ? new Object[]{Long.valueOf(channel.getId()), Long.valueOf(channel.getGuildId()), Integer.valueOf(channel.getRateLimitPerUser())} : new Object[0];
                }
            }))).m11099Y(new InterfaceC12589b<Channel, Observable<? extends ChatTypingModel>>() { // from class: com.discord.widgets.chat.overlay.ChatTypingModel$Companion$getTypingObservableForChannel$2
                @Override // p637j0.p641k.InterfaceC12589b
                public final Observable<? extends ChatTypingModel> call(final Channel channel) {
                    return channel == null ? new C12721k(ChatTypingModel.Hide.INSTANCE) : GuildVerificationLevelUtils.observeVerificationLevelTriggered$default(GuildVerificationLevelUtils.INSTANCE, channel.getGuildId(), null, null, null, 14, null).m11099Y(new InterfaceC12589b<GuildVerificationLevel, Observable<? extends ChatTypingModel>>() { // from class: com.discord.widgets.chat.overlay.ChatTypingModel$Companion$getTypingObservableForChannel$2.1
                        @Override // p637j0.p641k.InterfaceC12589b
                        public final Observable<? extends ChatTypingModel> call(GuildVerificationLevel guildVerificationLevel) {
                            return guildVerificationLevel.compareTo(GuildVerificationLevel.NONE) > 0 ? new C12721k(ChatTypingModel.Hide.INSTANCE) : Observable.m11076j(ChatTypingModel.INSTANCE.getTypingUsers(channel), StoreStream.INSTANCE.getSlowMode().observeCooldownSecs(Long.valueOf(channel.getId()), StoreSlowMode.Type.MessageSend.INSTANCE), new Func2<List<? extends CharSequence>, Integer, ChatTypingModel.Typing>() { // from class: com.discord.widgets.chat.overlay.ChatTypingModel.Companion.getTypingObservableForChannel.2.1.1
                                @Override // p658rx.functions.Func2
                                public final ChatTypingModel.Typing call(List<? extends CharSequence> list, Integer num) {
                                    C12238m.checkNotNullExpressionValue(list, "typingUsers");
                                    int rateLimitPerUser = channel.getRateLimitPerUser();
                                    C12238m.checkNotNullExpressionValue(num, "cooldownSecs");
                                    return new ChatTypingModel.Typing(list, rateLimitPerUser, num.intValue());
                                }
                            });
                        }
                    });
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11099Y, "Observable.just(resolved…          }\n            }");
            return observableM11099Y;
        }

        private final Observable<ChatTypingModel> getTypingObservableForDraft(final Channel parentChannel) {
            Observable observableM11099Y = StoreStream.INSTANCE.getSlowMode().observeCooldownSecs(Long.valueOf(parentChannel.getId()), StoreSlowMode.Type.ThreadCreate.INSTANCE).m11099Y(new InterfaceC12589b<Integer, Observable<? extends ChatTypingModel>>() { // from class: com.discord.widgets.chat.overlay.ChatTypingModel$Companion$getTypingObservableForDraft$1
                @Override // p637j0.p641k.InterfaceC12589b
                public final Observable<? extends ChatTypingModel> call(Integer num) {
                    List listEmptyList = C12147n.emptyList();
                    int rateLimitPerUser = parentChannel.getRateLimitPerUser();
                    C12238m.checkNotNullExpressionValue(num, "cooldownSecs");
                    return new C12721k(new ChatTypingModel.Typing(listEmptyList, rateLimitPerUser, num.intValue()));
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11099Y, "StoreStream\n            …ldownSecs))\n            }");
            return observableM11099Y;
        }

        private final Observable<List<CharSequence>> getTypingUsers(final Channel channel) {
            Observable<List<CharSequence>> observableM11112r = StoreStream.INSTANCE.getUsersTyping().observeTypingUsers(channel.getId()).m11099Y(new InterfaceC12589b<Set<? extends Long>, Observable<? extends List<? extends String>>>() { // from class: com.discord.widgets.chat.overlay.ChatTypingModel$Companion$getTypingUsers$1
                @Override // p637j0.p641k.InterfaceC12589b
                public /* bridge */ /* synthetic */ Observable<? extends List<? extends String>> call(Set<? extends Long> set) {
                    return call2((Set<Long>) set);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final Observable<? extends List<String>> call2(Set<Long> set) {
                    StoreStream.Companion companion = StoreStream.INSTANCE;
                    StoreUser users = companion.getUsers();
                    C12238m.checkNotNullExpressionValue(set, "userIds");
                    return Observable.m11076j(users.observeUsers(set), companion.getGuilds().observeComputed(channel.getGuildId(), set), new Func2<Map<Long, ? extends User>, Map<Long, ? extends GuildMember>, List<? extends String>>() { // from class: com.discord.widgets.chat.overlay.ChatTypingModel$Companion$getTypingUsers$1.1
                        @Override // p658rx.functions.Func2
                        public /* bridge */ /* synthetic */ List<? extends String> call(Map<Long, ? extends User> map, Map<Long, ? extends GuildMember> map2) {
                            return call2(map, (Map<Long, GuildMember>) map2);
                        }

                        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                        public final List<String> call2(Map<Long, ? extends User> map, Map<Long, GuildMember> map2) {
                            Collection<? extends User> collectionValues = map.values();
                            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(collectionValues, 10));
                            for (User user : collectionValues) {
                                arrayList.add(GuildMember.INSTANCE.getNickOrUsername((GuildMember) C1643a.m849f(user, map2), user));
                            }
                            return arrayList;
                        }
                    });
                }
            }).m11083G(new InterfaceC12589b<List<? extends String>, List<? extends CharSequence>>() { // from class: com.discord.widgets.chat.overlay.ChatTypingModel$Companion$getTypingUsers$2
                @Override // p637j0.p641k.InterfaceC12589b
                public /* bridge */ /* synthetic */ List<? extends CharSequence> call(List<? extends String> list) {
                    return call2((List<String>) list);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final List<CharSequence> call2(List<String> list) {
                    C12238m.checkNotNullExpressionValue(list, "names");
                    ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(list, 10));
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(C1107b.m215g(C1643a.m886y("!!", (String) it.next(), "!!"), new Object[0], (2 & 2) != 0 ? C1107b.e.f1494j : null));
                    }
                    return C12163u.take(arrayList, 4);
                }
            }).m11112r();
            C12238m.checkNotNullExpressionValue(observableM11112r, "StoreStream\n          .g…  .distinctUntilChanged()");
            return observableM11112r;
        }

        public final Observable<ChatTypingModel> get() {
            Observable<ChatTypingModel> observableM11112r = StoreStream.INSTANCE.getChannelsSelected().observeResolvedSelectedChannel().m11099Y(new InterfaceC12589b<StoreChannelsSelected.ResolvedSelectedChannel, Observable<? extends ChatTypingModel>>() { // from class: com.discord.widgets.chat.overlay.ChatTypingModel$Companion$get$1
                @Override // p637j0.p641k.InterfaceC12589b
                public final Observable<? extends ChatTypingModel> call(StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
                    if (resolvedSelectedChannel instanceof StoreChannelsSelected.ResolvedSelectedChannel.Channel) {
                        return ChatTypingModel.INSTANCE.getTypingObservableForChannel(((StoreChannelsSelected.ResolvedSelectedChannel.Channel) resolvedSelectedChannel).getChannel());
                    }
                    return resolvedSelectedChannel instanceof StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft ? ChatTypingModel.INSTANCE.getTypingObservableForDraft(((StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft) resolvedSelectedChannel).getParentChannel()) : new C12721k(ChatTypingModel.Hide.INSTANCE);
                }
            }).m11112r();
            C12238m.checkNotNullExpressionValue(observableM11112r, "StoreStream.getChannelsS…  .distinctUntilChanged()");
            return observableM11112r;
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
            C12238m.checkNotNullParameter(list, "typingUsers");
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
            C12238m.checkNotNullParameter(typingUsers, "typingUsers");
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
            return C12238m.areEqual(this.typingUsers, typing.typingUsers) && this.channelRateLimit == typing.channelRateLimit && this.cooldownSecs == typing.cooldownSecs;
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
            StringBuilder sbM833U = C1643a.m833U("Typing(typingUsers=");
            sbM833U.append(this.typingUsers);
            sbM833U.append(", channelRateLimit=");
            sbM833U.append(this.channelRateLimit);
            sbM833U.append(", cooldownSecs=");
            return C1643a.m814B(sbM833U, this.cooldownSecs, ")");
        }
    }

    private ChatTypingModel() {
    }

    public /* synthetic */ ChatTypingModel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
