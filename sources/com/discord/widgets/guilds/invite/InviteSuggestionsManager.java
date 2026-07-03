package com.discord.widgets.guilds.invite;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.channel.ChannelUtils$getSortByMostRecent$1;
import com.discord.models.user.User;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreMessagesMostRecent;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserAffinities;
import com.discord.stores.StoreUserRelationships;
import com.discord.widgets.guilds.invite.InviteSuggestion;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.functions.Func2;
import p658rx.functions.Func3;

/* JADX INFO: compiled from: InviteSuggestionsManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InviteSuggestionsManager {
    private final StoreChannels storeChannels;
    private final StoreMessagesMostRecent storeMessagesMostRecent;
    private final StoreUserAffinities storeUserAffinities;
    private final StoreUserRelationships storeUserRelationships;
    private final StoreUser storeUsers;

    /* JADX INFO: compiled from: InviteSuggestionsManager.kt */
    public static final /* data */ class UserAffinityData {
        private final Map<Long, Integer> relationships;
        private final List<Long> userIds;
        private final Map<Long, User> users;

        /* JADX WARN: Multi-variable type inference failed */
        public UserAffinityData(List<Long> list, Map<Long, ? extends User> map, Map<Long, Integer> map2) {
            C12238m.checkNotNullParameter(list, "userIds");
            C12238m.checkNotNullParameter(map, "users");
            C12238m.checkNotNullParameter(map2, "relationships");
            this.userIds = list;
            this.users = map;
            this.relationships = map2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ UserAffinityData copy$default(UserAffinityData userAffinityData, List list, Map map, Map map2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = userAffinityData.userIds;
            }
            if ((i & 2) != 0) {
                map = userAffinityData.users;
            }
            if ((i & 4) != 0) {
                map2 = userAffinityData.relationships;
            }
            return userAffinityData.copy(list, map, map2);
        }

        public final List<Long> component1() {
            return this.userIds;
        }

        public final Map<Long, User> component2() {
            return this.users;
        }

        public final Map<Long, Integer> component3() {
            return this.relationships;
        }

        public final UserAffinityData copy(List<Long> userIds, Map<Long, ? extends User> users, Map<Long, Integer> relationships) {
            C12238m.checkNotNullParameter(userIds, "userIds");
            C12238m.checkNotNullParameter(users, "users");
            C12238m.checkNotNullParameter(relationships, "relationships");
            return new UserAffinityData(userIds, users, relationships);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UserAffinityData)) {
                return false;
            }
            UserAffinityData userAffinityData = (UserAffinityData) other;
            return C12238m.areEqual(this.userIds, userAffinityData.userIds) && C12238m.areEqual(this.users, userAffinityData.users) && C12238m.areEqual(this.relationships, userAffinityData.relationships);
        }

        public final Map<Long, Integer> getRelationships() {
            return this.relationships;
        }

        public final List<Long> getUserIds() {
            return this.userIds;
        }

        public final Map<Long, User> getUsers() {
            return this.users;
        }

        public int hashCode() {
            List<Long> list = this.userIds;
            int iHashCode = (list != null ? list.hashCode() : 0) * 31;
            Map<Long, User> map = this.users;
            int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
            Map<Long, Integer> map2 = this.relationships;
            return iHashCode2 + (map2 != null ? map2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("UserAffinityData(userIds=");
            sbM833U.append(this.userIds);
            sbM833U.append(", users=");
            sbM833U.append(this.users);
            sbM833U.append(", relationships=");
            return C1643a.m825M(sbM833U, this.relationships, ")");
        }
    }

    public InviteSuggestionsManager() {
        this(null, null, null, null, null, 31, null);
    }

    public InviteSuggestionsManager(StoreChannels storeChannels, StoreMessagesMostRecent storeMessagesMostRecent, StoreUserAffinities storeUserAffinities, StoreUser storeUser, StoreUserRelationships storeUserRelationships) {
        C12238m.checkNotNullParameter(storeChannels, "storeChannels");
        C12238m.checkNotNullParameter(storeMessagesMostRecent, "storeMessagesMostRecent");
        C12238m.checkNotNullParameter(storeUserAffinities, "storeUserAffinities");
        C12238m.checkNotNullParameter(storeUser, "storeUsers");
        C12238m.checkNotNullParameter(storeUserRelationships, "storeUserRelationships");
        this.storeChannels = storeChannels;
        this.storeMessagesMostRecent = storeMessagesMostRecent;
        this.storeUserAffinities = storeUserAffinities;
        this.storeUsers = storeUser;
        this.storeUserRelationships = storeUserRelationships;
    }

    public final Observable<List<InviteSuggestion>> observeInviteSuggestions() {
        Observable<List<InviteSuggestion>> observableM11075i = Observable.m11075i(this.storeChannels.observePrivateChannels(), this.storeMessagesMostRecent.observeRecentMessageIds().m11100Z(1), this.storeUserAffinities.observeAffinityUserIds().m11099Y(new InterfaceC12589b<List<? extends Long>, Observable<? extends UserAffinityData>>() { // from class: com.discord.widgets.guilds.invite.InviteSuggestionsManager.observeInviteSuggestions.1
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ Observable<? extends UserAffinityData> call(List<? extends Long> list) {
                return call2((List<Long>) list);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Observable<? extends UserAffinityData> call2(final List<Long> list) {
                StoreUser storeUser = InviteSuggestionsManager.this.storeUsers;
                C12238m.checkNotNullExpressionValue(list, "affinityUserIds");
                return Observable.m11076j(storeUser.observeUsers(list).m11112r(), InviteSuggestionsManager.this.storeUserRelationships.observe(list), new Func2<Map<Long, ? extends User>, Map<Long, ? extends Integer>, UserAffinityData>() { // from class: com.discord.widgets.guilds.invite.InviteSuggestionsManager.observeInviteSuggestions.1.1
                    @Override // p658rx.functions.Func2
                    public /* bridge */ /* synthetic */ UserAffinityData call(Map<Long, ? extends User> map, Map<Long, ? extends Integer> map2) {
                        return call2(map, (Map<Long, Integer>) map2);
                    }

                    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                    public final UserAffinityData call2(Map<Long, ? extends User> map, Map<Long, Integer> map2) {
                        List list2 = list;
                        C12238m.checkNotNullExpressionValue(list2, "affinityUserIds");
                        C12238m.checkNotNullExpressionValue(map, "users");
                        C12238m.checkNotNullExpressionValue(map2, "relationships");
                        return new UserAffinityData(list2, map, map2);
                    }
                });
            }
        }), new Func3<Map<Long, ? extends Channel>, Map<Long, ? extends Long>, UserAffinityData, List<? extends InviteSuggestion>>() { // from class: com.discord.widgets.guilds.invite.InviteSuggestionsManager.observeInviteSuggestions.2
            @Override // p658rx.functions.Func3
            public /* bridge */ /* synthetic */ List<? extends InviteSuggestion> call(Map<Long, ? extends Channel> map, Map<Long, ? extends Long> map2, UserAffinityData userAffinityData) {
                return call2((Map<Long, Channel>) map, (Map<Long, Long>) map2, userAffinityData);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final List<InviteSuggestion> call2(Map<Long, Channel> map, Map<Long, Long> map2, UserAffinityData userAffinityData) {
                User userM7677a;
                ArrayList arrayList = new ArrayList();
                Collection<Channel> collectionValues = map.values();
                Channel.Companion companion = Channel.INSTANCE;
                C12238m.checkNotNullExpressionValue(map2, "mostRecentMessages");
                C12238m.checkNotNullParameter(companion, "$this$getSortByMostRecent");
                C12238m.checkNotNullParameter(map2, "mostRecentMessageIds");
                List listSortedWith = C12163u.sortedWith(collectionValues, new ChannelUtils$getSortByMostRecent$1(map2));
                Channel channel = listSortedWith.isEmpty() ^ true ? (Channel) listSortedWith.get(0) : null;
                if (channel != null) {
                    arrayList.add(new InviteSuggestion.ChannelItem(channel));
                }
                List<Long> userIds = userAffinityData.getUserIds();
                ArrayList arrayList2 = new ArrayList();
                Iterator<T> it = userIds.iterator();
                while (it.hasNext()) {
                    User user = userAffinityData.getUsers().get(Long.valueOf(((Number) it.next()).longValue()));
                    if (user != null) {
                        arrayList2.add(user);
                    }
                }
                ArrayList arrayList3 = new ArrayList();
                for (Object obj : arrayList2) {
                    User user2 = (User) obj;
                    Integer num = (Integer) C1643a.m849f(user2, userAffinityData.getRelationships());
                    if (!(!(channel == null || (userM7677a = ChannelUtils.m7677a(channel)) == null || userM7677a.getId() != user2.getId()) || (num != null && num.intValue() == 2))) {
                        arrayList3.add(obj);
                    }
                }
                List listDistinct = C12163u.distinct(arrayList3);
                Iterator it2 = listDistinct.iterator();
                while (it2.hasNext()) {
                    arrayList.add(new InviteSuggestion.UserSuggestion((User) it2.next()));
                }
                ArrayList arrayList4 = new ArrayList();
                for (Object obj2 : listSortedWith) {
                    Channel channel2 = (Channel) obj2;
                    if ((C12238m.areEqual(channel, channel2) ^ true) && (ChannelUtils.m7677a(channel2) == null || !C12163u.contains(listDistinct, ChannelUtils.m7677a(channel2)))) {
                        arrayList4.add(obj2);
                    }
                }
                ArrayList arrayList5 = new ArrayList(C12149o.collectionSizeOrDefault(arrayList4, 10));
                Iterator it3 = arrayList4.iterator();
                while (it3.hasNext()) {
                    arrayList5.add(Boolean.valueOf(arrayList.add(new InviteSuggestion.ChannelItem((Channel) it3.next()))));
                }
                return arrayList;
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11075i, "Observable.combineLatest… inviteSuggestionList\n  }");
        return observableM11075i;
    }

    public /* synthetic */ InviteSuggestionsManager(StoreChannels storeChannels, StoreMessagesMostRecent storeMessagesMostRecent, StoreUserAffinities storeUserAffinities, StoreUser storeUser, StoreUserRelationships storeUserRelationships, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 2) != 0 ? StoreStream.INSTANCE.getMessagesMostRecent() : storeMessagesMostRecent, (i & 4) != 0 ? StoreStream.INSTANCE.getUserAffinities() : storeUserAffinities, (i & 8) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 16) != 0 ? StoreStream.INSTANCE.getUserRelationships() : storeUserRelationships);
    }
}
