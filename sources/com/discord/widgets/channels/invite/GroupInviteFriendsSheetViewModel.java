package com.discord.widgets.channels.invite;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.api.channel.Channel;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.g0.w;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: GroupInviteFriendsSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GroupInviteFriendsSheetViewModel extends d0<GroupInviteFriendsSheetViewModel$ViewState> {
    public static final GroupInviteFriendsSheetViewModel$Companion Companion = new GroupInviteFriendsSheetViewModel$Companion(null);
    private static final int MAX_GROUP_MEMBERS = 10;
    private static final int MAX_GROUP_MEMBERS_STAFF = 25;
    private static final long SEARCH_DEBOUNCE_MILLIS = 150;
    private final long channelId;
    private final HashSet<User> checkedUsers;
    private GroupInviteFriendsSheetViewModel$StoreState currentStoreState;
    private final PublishSubject<GroupInviteFriendsSheetViewModel$Event> eventSubject;
    private final int maxNumMembers;
    private final BehaviorSubject<CharSequence> searchTextChangedPublisher;
    private final StoreUser storeUser;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GroupInviteFriendsSheetViewModel(long j, StoreUser storeUser, int i, Observable observable, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        storeUser = (i2 & 2) != 0 ? StoreStream.Companion.getUsers() : storeUser;
        i = (i2 & 4) != 0 ? GroupInviteFriendsSheetViewModel$Companion.access$getMaxNumMembers(Companion, storeUser) : i;
        if ((i2 & 8) != 0) {
            GroupInviteFriendsSheetViewModel$Companion groupInviteFriendsSheetViewModel$Companion = Companion;
            StoreStream$Companion storeStream$Companion = StoreStream.Companion;
            observable = GroupInviteFriendsSheetViewModel$Companion.access$observeStoreState(groupInviteFriendsSheetViewModel$Companion, j, storeStream$Companion.getUserRelationships(), storeUser, storeStream$Companion.getChannels());
        }
        this(j, storeUser, i, observable);
    }

    public static final /* synthetic */ void access$handleStoreState(GroupInviteFriendsSheetViewModel groupInviteFriendsSheetViewModel, GroupInviteFriendsSheetViewModel$StoreState groupInviteFriendsSheetViewModel$StoreState) {
        groupInviteFriendsSheetViewModel.handleStoreState(groupInviteFriendsSheetViewModel$StoreState);
    }

    public static final /* synthetic */ void access$onSearch(GroupInviteFriendsSheetViewModel groupInviteFriendsSheetViewModel, CharSequence charSequence) {
        groupInviteFriendsSheetViewModel.onSearch(charSequence);
    }

    private final void emitChannelFullEvent() {
        PublishSubject<GroupInviteFriendsSheetViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(GroupInviteFriendsSheetViewModel$Event$ChannelFull.INSTANCE);
    }

    private final List<User> excludeUsersAlreadyInChannel(Map<Long, ? extends User> users, Channel channel) {
        Set set;
        List<com.discord.api.user.User> listZ;
        if (channel == null || (listZ = channel.z()) == null) {
            set = null;
        } else {
            ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(listZ, 10));
            Iterator<T> it = listZ.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(((com.discord.api.user.User) it.next()).getId()));
            }
            set = u.toSet(arrayList);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map$Entry<Long, ? extends User> map$Entry : users.entrySet()) {
            boolean z2 = true;
            if (set != null && set.contains(map$Entry.getKey())) {
                z2 = false;
            }
            if (z2) {
                linkedHashMap.put(map$Entry.getKey(), map$Entry.getValue());
            }
        }
        return u.toList(linkedHashMap.values());
    }

    @MainThread
    private final void handleStoreState(GroupInviteFriendsSheetViewModel$StoreState storeState) {
        this.currentStoreState = storeState;
        List<User> listExcludeUsersAlreadyInChannel = excludeUsersAlreadyInChannel(storeState.getFriendUsersMap(), storeState.getChannel());
        HashSet<User> hashSet = this.checkedUsers;
        ArrayList<GroupInviteFriendsSheetAdapter$FriendItem> arrayListCreateItems = GroupInviteFriendsSheetAdapter$FriendItem.Companion.createItems(listExcludeUsersAlreadyInChannel, hashSet);
        GroupInviteFriendsSheetViewModel$ViewState viewState = getViewState();
        updateViewState(new GroupInviteFriendsSheetViewModel$ViewState(hashSet, arrayListCreateItems, viewState != null ? viewState.getShowSearchIcon() : true));
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
            if (w.contains((CharSequence) ((User) next).getUsername(), searchText, true)) {
                arrayList.add(next);
            }
        }
        HashSet<User> hashSet = this.checkedUsers;
        updateViewState(new GroupInviteFriendsSheetViewModel$ViewState(hashSet, GroupInviteFriendsSheetAdapter$FriendItem.Companion.createItems(arrayList, hashSet), (searchText.length() == 0) && this.checkedUsers.isEmpty()));
    }

    public final Observable<GroupInviteFriendsSheetViewModel$Event> observeEvents() {
        PublishSubject<GroupInviteFriendsSheetViewModel$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void onChangeUserChecked(User user, boolean isChecked) {
        m.checkNotNullParameter(user, "user");
        GroupInviteFriendsSheetViewModel$ViewState viewState = getViewState();
        if (viewState != null) {
            if (!isChecked) {
                this.checkedUsers.remove(user);
            } else if (this.checkedUsers.size() < this.maxNumMembers) {
                this.checkedUsers.add(user);
            } else {
                emitChannelFullEvent();
            }
            List<GroupInviteFriendsSheetAdapter$FriendItem> friendItems = viewState.getFriendItems();
            ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(friendItems, 10));
            Iterator<T> it = friendItems.iterator();
            while (it.hasNext()) {
                arrayList.add(((GroupInviteFriendsSheetAdapter$FriendItem) it.next()).getUser());
            }
            HashSet<User> hashSet = this.checkedUsers;
            updateViewState(GroupInviteFriendsSheetViewModel$ViewState.copy$default(viewState, hashSet, GroupInviteFriendsSheetAdapter$FriendItem.Companion.createItems(arrayList, hashSet), false, 4, null));
        }
    }

    public final void onSearchTextChanged(CharSequence searchText) {
        m.checkNotNullParameter(searchText, "searchText");
        this.searchTextChangedPublisher.onNext(searchText);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupInviteFriendsSheetViewModel(long j, StoreUser storeUser, int i, Observable<GroupInviteFriendsSheetViewModel$StoreState> observable) {
        super(null, 1, null);
        m.checkNotNullParameter(storeUser, "storeUser");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.channelId = j;
        this.storeUser = storeUser;
        this.maxNumMembers = i;
        this.eventSubject = PublishSubject.k0();
        this.currentStoreState = new GroupInviteFriendsSheetViewModel$StoreState(null, null, 3, null);
        this.checkedUsers = new HashSet<>();
        BehaviorSubject<CharSequence> behaviorSubjectK0 = BehaviorSubject.k0();
        this.searchTextChangedPublisher = behaviorSubjectK0;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), GroupInviteFriendsSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new GroupInviteFriendsSheetViewModel$1(this), 62, (Object) null);
        Observable<CharSequence> observableP = behaviorSubjectK0.p(150L, TimeUnit.MILLISECONDS);
        m.checkNotNullExpressionValue(observableP, "searchTextChangedPublish…S, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableP, this, null, 2, null), GroupInviteFriendsSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new GroupInviteFriendsSheetViewModel$2(this), 62, (Object) null);
    }
}
