package com.discord.widgets.channels.invite;

import androidx.annotation.MainThread;
import com.discord.api.channel.Channel;
import com.discord.models.user.User;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserRelationships;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12106w;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func2;
import p658rx.subjects.BehaviorSubject;
import p658rx.subjects.PublishSubject;

/* JADX INFO: compiled from: GroupInviteFriendsSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GroupInviteFriendsSheetViewModel extends AbstractC0859d0<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int MAX_GROUP_MEMBERS = 10;
    private static final int MAX_GROUP_MEMBERS_STAFF = 25;
    private static final long SEARCH_DEBOUNCE_MILLIS = 150;
    private final long channelId;
    private final HashSet<User> checkedUsers;
    private StoreState currentStoreState;
    private final PublishSubject<Event> eventSubject;
    private final int maxNumMembers;
    private final BehaviorSubject<CharSequence> searchTextChangedPublisher;
    private final StoreUser storeUser;

    /* JADX INFO: renamed from: com.discord.widgets.channels.invite.GroupInviteFriendsSheetViewModel$1 */
    /* JADX INFO: compiled from: GroupInviteFriendsSheetViewModel.kt */
    public static final class C74111 extends AbstractC12240o implements Function1<StoreState, Unit> {
        public C74111() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            C12238m.checkNotNullParameter(storeState, "storeState");
            GroupInviteFriendsSheetViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.invite.GroupInviteFriendsSheetViewModel$2 */
    /* JADX INFO: compiled from: GroupInviteFriendsSheetViewModel.kt */
    public static final class C74122 extends AbstractC12240o implements Function1<CharSequence, Unit> {
        public C74122() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(CharSequence charSequence) {
            invoke2(charSequence);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(CharSequence charSequence) {
            GroupInviteFriendsSheetViewModel groupInviteFriendsSheetViewModel = GroupInviteFriendsSheetViewModel.this;
            C12238m.checkNotNullExpressionValue(charSequence, "searchText");
            groupInviteFriendsSheetViewModel.onSearch(charSequence);
        }
    }

    /* JADX INFO: compiled from: GroupInviteFriendsSheetViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final int getMaxNumMembers(StoreUser storeUser) {
            return UserUtils.INSTANCE.isStaff(storeUser.getMeSnapshot()) ? 25 : 10;
        }

        private final Observable<Map<Long, User>> observeFriends(StoreUserRelationships storeUserRelationships, final StoreUser storeUser) {
            Observable observableM11099Y = storeUserRelationships.observeForType(1).m11099Y(new InterfaceC12589b<Map<Long, ? extends Integer>, Observable<? extends Map<Long, ? extends User>>>() { // from class: com.discord.widgets.channels.invite.GroupInviteFriendsSheetViewModel$Companion$observeFriends$1
                @Override // p637j0.p641k.InterfaceC12589b
                public /* bridge */ /* synthetic */ Observable<? extends Map<Long, ? extends User>> call(Map<Long, ? extends Integer> map) {
                    return call2((Map<Long, Integer>) map);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final Observable<? extends Map<Long, User>> call2(Map<Long, Integer> map) {
                    return storeUser.observeUsers(map.keySet());
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11099Y, "storeUserRelationships.o…ships.keys)\n            }");
            return observableM11099Y;
        }

        private final Observable<StoreState> observeStoreState(long channelId, StoreUserRelationships storeUserRelationships, StoreUser storeUser, StoreChannels storeChannels) {
            if (channelId == -1) {
                Observable observableM11083G = observeFriends(storeUserRelationships, storeUser).m11083G(new InterfaceC12589b<Map<Long, ? extends User>, StoreState>() { // from class: com.discord.widgets.channels.invite.GroupInviteFriendsSheetViewModel$Companion$observeStoreState$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // p637j0.p641k.InterfaceC12589b
                    public final GroupInviteFriendsSheetViewModel.StoreState call(Map<Long, ? extends User> map) {
                        C12238m.checkNotNullExpressionValue(map, "friendsUsers");
                        return new GroupInviteFriendsSheetViewModel.StoreState(map, null, 2, 0 == true ? 1 : 0);
                    }
                });
                C12238m.checkNotNullExpressionValue(observableM11083G, "observeFriends(storeUser…          )\n            }");
                return observableM11083G;
            }
            Observable<StoreState> observableM11076j = Observable.m11076j(storeChannels.observeChannel(channelId), observeFriends(storeUserRelationships, storeUser), new Func2<Channel, Map<Long, ? extends User>, StoreState>() { // from class: com.discord.widgets.channels.invite.GroupInviteFriendsSheetViewModel$Companion$observeStoreState$2
                @Override // p658rx.functions.Func2
                public final GroupInviteFriendsSheetViewModel.StoreState call(Channel channel, Map<Long, ? extends User> map) {
                    C12238m.checkNotNullExpressionValue(map, "friendUsersMap");
                    return new GroupInviteFriendsSheetViewModel.StoreState(map, channel);
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11076j, "Observable\n             …      )\n                }");
            return observableM11076j;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: GroupInviteFriendsSheetViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: GroupInviteFriendsSheetViewModel.kt */
        public static final class ChannelFull extends Event {
            public static final ChannelFull INSTANCE = new ChannelFull();

            private ChannelFull() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: GroupInviteFriendsSheetViewModel.kt */
    public static final /* data */ class StoreState {
        private final Channel channel;
        private final Map<Long, User> friendUsersMap;

        /* JADX WARN: Multi-variable type inference failed */
        public StoreState() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public StoreState(Map<Long, ? extends User> map, Channel channel) {
            C12238m.checkNotNullParameter(map, "friendUsersMap");
            this.friendUsersMap = map;
            this.channel = channel;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StoreState copy$default(StoreState storeState, Map map, Channel channel, int i, Object obj) {
            if ((i & 1) != 0) {
                map = storeState.friendUsersMap;
            }
            if ((i & 2) != 0) {
                channel = storeState.channel;
            }
            return storeState.copy(map, channel);
        }

        public final Map<Long, User> component1() {
            return this.friendUsersMap;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        public final StoreState copy(Map<Long, ? extends User> friendUsersMap, Channel channel) {
            C12238m.checkNotNullParameter(friendUsersMap, "friendUsersMap");
            return new StoreState(friendUsersMap, channel);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return C12238m.areEqual(this.friendUsersMap, storeState.friendUsersMap) && C12238m.areEqual(this.channel, storeState.channel);
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final Map<Long, User> getFriendUsersMap() {
            return this.friendUsersMap;
        }

        public int hashCode() {
            Map<Long, User> map = this.friendUsersMap;
            int iHashCode = (map != null ? map.hashCode() : 0) * 31;
            Channel channel = this.channel;
            return iHashCode + (channel != null ? channel.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("StoreState(friendUsersMap=");
            sbM833U.append(this.friendUsersMap);
            sbM833U.append(", channel=");
            sbM833U.append(this.channel);
            sbM833U.append(")");
            return sbM833U.toString();
        }

        public /* synthetic */ StoreState(Map map, Channel channel, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? C12136h0.emptyMap() : map, (i & 2) != 0 ? null : channel);
        }
    }

    /* JADX INFO: compiled from: GroupInviteFriendsSheetViewModel.kt */
    public static final /* data */ class ViewState {
        private final HashSet<User> checkedUsers;
        private final List<GroupInviteFriendsSheetAdapter.FriendItem> friendItems;
        private final boolean showSearchIcon;

        public ViewState(HashSet<User> hashSet, List<GroupInviteFriendsSheetAdapter.FriendItem> list, boolean z2) {
            C12238m.checkNotNullParameter(hashSet, "checkedUsers");
            C12238m.checkNotNullParameter(list, "friendItems");
            this.checkedUsers = hashSet;
            this.friendItems = list;
            this.showSearchIcon = z2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewState copy$default(ViewState viewState, HashSet hashSet, List list, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                hashSet = viewState.checkedUsers;
            }
            if ((i & 2) != 0) {
                list = viewState.friendItems;
            }
            if ((i & 4) != 0) {
                z2 = viewState.showSearchIcon;
            }
            return viewState.copy(hashSet, list, z2);
        }

        public final HashSet<User> component1() {
            return this.checkedUsers;
        }

        public final List<GroupInviteFriendsSheetAdapter.FriendItem> component2() {
            return this.friendItems;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getShowSearchIcon() {
            return this.showSearchIcon;
        }

        public final ViewState copy(HashSet<User> checkedUsers, List<GroupInviteFriendsSheetAdapter.FriendItem> friendItems, boolean showSearchIcon) {
            C12238m.checkNotNullParameter(checkedUsers, "checkedUsers");
            C12238m.checkNotNullParameter(friendItems, "friendItems");
            return new ViewState(checkedUsers, friendItems, showSearchIcon);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return C12238m.areEqual(this.checkedUsers, viewState.checkedUsers) && C12238m.areEqual(this.friendItems, viewState.friendItems) && this.showSearchIcon == viewState.showSearchIcon;
        }

        public final HashSet<User> getCheckedUsers() {
            return this.checkedUsers;
        }

        public final List<GroupInviteFriendsSheetAdapter.FriendItem> getFriendItems() {
            return this.friendItems;
        }

        public final boolean getShowSearchIcon() {
            return this.showSearchIcon;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public int hashCode() {
            HashSet<User> hashSet = this.checkedUsers;
            int iHashCode = (hashSet != null ? hashSet.hashCode() : 0) * 31;
            List<GroupInviteFriendsSheetAdapter.FriendItem> list = this.friendItems;
            int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
            boolean z2 = this.showSearchIcon;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode2 + r1;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ViewState(checkedUsers=");
            sbM833U.append(this.checkedUsers);
            sbM833U.append(", friendItems=");
            sbM833U.append(this.friendItems);
            sbM833U.append(", showSearchIcon=");
            return C1643a.m827O(sbM833U, this.showSearchIcon, ")");
        }

        public /* synthetic */ ViewState(HashSet hashSet, List list, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(hashSet, list, (i & 4) != 0 ? true : z2);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GroupInviteFriendsSheetViewModel(long j, StoreUser storeUser, int i, Observable observable, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        storeUser = (i2 & 2) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        i = (i2 & 4) != 0 ? INSTANCE.getMaxNumMembers(storeUser) : i;
        if ((i2 & 8) != 0) {
            Companion companion = INSTANCE;
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observable = companion.observeStoreState(j, companion2.getUserRelationships(), storeUser, companion2.getChannels());
        }
        this(j, storeUser, i, observable);
    }

    private final void emitChannelFullEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(Event.ChannelFull.INSTANCE);
    }

    private final List<User> excludeUsersAlreadyInChannel(Map<Long, ? extends User> users, Channel channel) {
        Set set;
        List<com.discord.api.user.User> listM7659z;
        if (channel == null || (listM7659z = channel.m7659z()) == null) {
            set = null;
        } else {
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(listM7659z, 10));
            Iterator<T> it = listM7659z.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(((com.discord.api.user.User) it.next()).getId()));
            }
            set = C12163u.toSet(arrayList);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Long, ? extends User> entry : users.entrySet()) {
            boolean z2 = true;
            if (set != null && set.contains(entry.getKey())) {
                z2 = false;
            }
            if (z2) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return C12163u.toList(linkedHashMap.values());
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        this.currentStoreState = storeState;
        List<User> listExcludeUsersAlreadyInChannel = excludeUsersAlreadyInChannel(storeState.getFriendUsersMap(), storeState.getChannel());
        HashSet<User> hashSet = this.checkedUsers;
        ArrayList<GroupInviteFriendsSheetAdapter.FriendItem> arrayListCreateItems = GroupInviteFriendsSheetAdapter.FriendItem.INSTANCE.createItems(listExcludeUsersAlreadyInChannel, hashSet);
        ViewState viewState = getViewState();
        updateViewState(new ViewState(hashSet, arrayListCreateItems, viewState != null ? viewState.getShowSearchIcon() : true));
    }

    private final void onSearch(CharSequence searchText) {
        Collection<User> collectionValues = this.currentStoreState.getFriendUsersMap().values();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collectionValues.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (C12106w.contains((CharSequence) ((User) next).getUsername(), searchText, true)) {
                arrayList.add(next);
            }
        }
        HashSet<User> hashSet = this.checkedUsers;
        updateViewState(new ViewState(hashSet, GroupInviteFriendsSheetAdapter.FriendItem.INSTANCE.createItems(arrayList, hashSet), (searchText.length() == 0) && this.checkedUsers.isEmpty()));
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        C12238m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void onChangeUserChecked(User user, boolean isChecked) {
        C12238m.checkNotNullParameter(user, "user");
        ViewState viewState = getViewState();
        if (viewState != null) {
            if (!isChecked) {
                this.checkedUsers.remove(user);
            } else if (this.checkedUsers.size() < this.maxNumMembers) {
                this.checkedUsers.add(user);
            } else {
                emitChannelFullEvent();
            }
            List<GroupInviteFriendsSheetAdapter.FriendItem> friendItems = viewState.getFriendItems();
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(friendItems, 10));
            Iterator<T> it = friendItems.iterator();
            while (it.hasNext()) {
                arrayList.add(((GroupInviteFriendsSheetAdapter.FriendItem) it.next()).getUser());
            }
            HashSet<User> hashSet = this.checkedUsers;
            updateViewState(ViewState.copy$default(viewState, hashSet, GroupInviteFriendsSheetAdapter.FriendItem.INSTANCE.createItems(arrayList, hashSet), false, 4, null));
        }
    }

    public final void onSearchTextChanged(CharSequence searchText) {
        C12238m.checkNotNullParameter(searchText, "searchText");
        this.searchTextChangedPublisher.onNext(searchText);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GroupInviteFriendsSheetViewModel(long j, StoreUser storeUser, int i, Observable<StoreState> observable) {
        super(null, 1, null);
        C12238m.checkNotNullParameter(storeUser, "storeUser");
        C12238m.checkNotNullParameter(observable, "storeStateObservable");
        this.channelId = j;
        this.storeUser = storeUser;
        this.maxNumMembers = i;
        this.eventSubject = PublishSubject.m11133k0();
        this.currentStoreState = new StoreState(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        this.checkedUsers = new HashSet<>();
        BehaviorSubject<CharSequence> behaviorSubjectM11129k0 = BehaviorSubject.m11129k0();
        this.searchTextChangedPublisher = behaviorSubjectM11129k0;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), (Class<?>) GroupInviteFriendsSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C74111());
        Observable<CharSequence> observableM11110p = behaviorSubjectM11129k0.m11110p(150L, TimeUnit.MILLISECONDS);
        C12238m.checkNotNullExpressionValue(observableM11110p, "searchTextChangedPublish…S, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11110p, this, null, 2, null), (Class<?>) GroupInviteFriendsSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C74122());
    }
}
