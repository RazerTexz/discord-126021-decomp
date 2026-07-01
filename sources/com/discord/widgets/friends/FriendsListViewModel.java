package com.discord.widgets.friends;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.StringRes;
import androidx.exifinterface.media.ExifInterface;
import b.a.d.d0;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.friendsuggestions.FriendSuggestion;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserRelationships$UserRelationshipsState$Loaded;
import com.discord.utilities.captcha.CaptchaHelper$CaptchaPayload;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.i0;
import d0.t.n;
import d0.t.q;
import d0.t.u;
import d0.z.d.m;
import j0.p.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.Emitter$BackpressureMode;
import rx.Observable;
import rx.functions.Cancellable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: FriendsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FriendsListViewModel extends d0<FriendsListViewModel$ViewState> {
    private static final int COLLAPSED_ITEM_COUNT = 2;
    public static final FriendsListViewModel$Companion Companion = new FriendsListViewModel$Companion(null);
    private static final String LOCATION = "Friends List";
    private Cancellable computeItemJob;
    private final PublishSubject<FriendsListViewModel$Event> eventSubject;
    private boolean isPendingSectionExpanded;
    private boolean isSuggestedSectionExpanded;
    private FriendsListViewModel$ListSections listSections;
    private final RestAPI restAPI;
    private final StoreChannels storeChannels;
    private final Observable<FriendsListViewModel$StoreState> storeObservable;

    public FriendsListViewModel() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ FriendsListViewModel(Observable observable, StoreChannels storeChannels, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Companion.observeStores() : observable, (i & 2) != 0 ? StoreStream.Companion.getChannels() : storeChannels, (i & 4) != 0 ? RestAPI.Companion.getApi() : restAPI);
    }

    public static /* synthetic */ void acceptFriendSuggestion$default(FriendsListViewModel friendsListViewModel, String str, int i, CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            captchaHelper$CaptchaPayload = null;
        }
        friendsListViewModel.acceptFriendSuggestion(str, i, captchaHelper$CaptchaPayload);
    }

    public static final /* synthetic */ void access$emitCaptchaErrorEvent(FriendsListViewModel friendsListViewModel, Error error, String str, int i) {
        friendsListViewModel.emitCaptchaErrorEvent(error, str, i);
    }

    public static final /* synthetic */ void access$emitLaunchVoiceCallEvent(FriendsListViewModel friendsListViewModel, long j) {
        friendsListViewModel.emitLaunchVoiceCallEvent(j);
    }

    public static final /* synthetic */ void access$emitShowFriendRequestAbortToast(FriendsListViewModel friendsListViewModel, int i, String str) {
        friendsListViewModel.emitShowFriendRequestAbortToast(i, str);
    }

    public static final /* synthetic */ void access$emitShowToastEvent(FriendsListViewModel friendsListViewModel, int i) {
        friendsListViewModel.emitShowToastEvent(i);
    }

    public static final /* synthetic */ FriendsListViewModel$ListSections access$getItems(FriendsListViewModel friendsListViewModel, Map map, Map map2, Map map3, Map map4, boolean z2, Map map5) {
        return friendsListViewModel.getItems(map, map2, map3, map4, z2, map5);
    }

    public static final /* synthetic */ void access$handleComputedItems(FriendsListViewModel friendsListViewModel, FriendsListViewModel$ListSections friendsListViewModel$ListSections, boolean z2) {
        friendsListViewModel.handleComputedItems(friendsListViewModel$ListSections, z2);
    }

    public static final /* synthetic */ void access$handleStoreState(FriendsListViewModel friendsListViewModel, FriendsListViewModel$StoreState friendsListViewModel$StoreState) throws Exception {
        friendsListViewModel.handleStoreState(friendsListViewModel$StoreState);
    }

    private final <T> Cancellable asyncComputeAndHandleOnUiThread(Function0<? extends T> compute, Function1<? super Error, Unit> onError, Function1<? super T, Unit> onSuccess) {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = null;
        Observable<T> observableX = Observable.o(new FriendsListViewModel$asyncComputeAndHandleOnUiThread$1(compute), Emitter$BackpressureMode.NONE).X(a.a());
        m.checkNotNullExpressionValue(observableX, "Observable\n        .crea…Schedulers.computation())");
        Observable observableUi$default = ObservableExtensionsKt.ui$default(observableX, this, null, 2, null);
        FriendsListViewModel$asyncComputeAndHandleOnUiThread$2 friendsListViewModel$asyncComputeAndHandleOnUiThread$2 = new FriendsListViewModel$asyncComputeAndHandleOnUiThread$2(onSuccess);
        ObservableExtensionsKt.appSubscribe$default(observableUi$default, FriendsListViewModel.class, (Context) null, new FriendsListViewModel$asyncComputeAndHandleOnUiThread$4(ref$ObjectRef), new FriendsListViewModel$asyncComputeAndHandleOnUiThread$3(onError), (Function0) null, (Function0) null, friendsListViewModel$asyncComputeAndHandleOnUiThread$2, 50, (Object) null);
        return new FriendsListViewModel$asyncComputeAndHandleOnUiThread$5(ref$ObjectRef);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Cancellable asyncComputeAndHandleOnUiThread$default(FriendsListViewModel friendsListViewModel, Function0 function0, Function1 function1, Function1 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        return friendsListViewModel.asyncComputeAndHandleOnUiThread(function0, function1, function2);
    }

    private final void emitCaptchaErrorEvent(Error error, String username, int discriminator) {
        PublishSubject<FriendsListViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new FriendsListViewModel$Event$CaptchaError(error, username, discriminator));
    }

    private final void emitLaunchVoiceCallEvent(long channelId) {
        PublishSubject<FriendsListViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new FriendsListViewModel$Event$LaunchVoiceCall(channelId));
    }

    private final void emitShowFriendRequestAbortToast(int abortCode, String username) {
        PublishSubject<FriendsListViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new FriendsListViewModel$Event$ShowFriendRequestErrorToast(abortCode, username));
    }

    private final void emitShowToastEvent(@StringRes int stringRes) {
        PublishSubject<FriendsListViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new FriendsListViewModel$Event$ShowToast(stringRes));
    }

    @MainThread
    private final void generateLoadedItems(boolean showContactSyncIcon) {
        FriendsListViewModel$Item$SuggestedFriendsHeader suggestionsHeaderItem = this.listSections.getSuggestionsHeaderItem();
        FriendsListViewModel$Item$SuggestedFriendsHeader friendsListViewModel$Item$SuggestedFriendsHeaderCopy$default = suggestionsHeaderItem != null ? FriendsListViewModel$Item$SuggestedFriendsHeader.copy$default(suggestionsHeaderItem, 0, this.isSuggestedSectionExpanded, false, 5, null) : null;
        FriendsListViewModel$Item$PendingHeader pendingHeaderItem = this.listSections.getPendingHeaderItem();
        FriendsListViewModel$ListSections friendsListViewModel$ListSectionsCopy$default = FriendsListViewModel$ListSections.copy$default(this.listSections, friendsListViewModel$Item$SuggestedFriendsHeaderCopy$default, null, pendingHeaderItem != null ? FriendsListViewModel$Item$PendingHeader.copy$default(pendingHeaderItem, 0, 0, this.isPendingSectionExpanded, false, 11, null) : null, null, null, null, 58, null);
        this.listSections = friendsListViewModel$ListSectionsCopy$default;
        List<FriendsListViewModel$Item> visibleItems = getVisibleItems(friendsListViewModel$ListSectionsCopy$default);
        updateViewState(visibleItems.isEmpty() ^ true ? new FriendsListViewModel$ViewState$Loaded(showContactSyncIcon, visibleItems) : new FriendsListViewModel$ViewState$Empty(showContactSyncIcon));
    }

    public static /* synthetic */ void generateLoadedItems$default(FriendsListViewModel friendsListViewModel, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        friendsListViewModel.generateLoadedItems(z2);
    }

    private final FriendsListViewModel$ListSections getItems(Map<Long, Integer> relationships, Map<Long, ? extends User> users, Map<Long, Presence> presences, Map<Long, ? extends ModelApplicationStream> applicationStreams, boolean showContactSyncUpsell, Map<Long, FriendSuggestion> friendSuggestions) {
        ArrayList arrayList = new ArrayList();
        if (!friendSuggestions.isEmpty()) {
            Iterator<T> it = friendSuggestions.values().iterator();
            while (it.hasNext()) {
                arrayList.add(new FriendsListViewModel$Item$SuggestedFriend((FriendSuggestion) it.next()));
            }
            if (arrayList.size() > 1) {
                q.sortWith(arrayList, new FriendsListViewModel$getItems$$inlined$sortBy$1());
            }
        }
        FriendsListViewModel$Item$SuggestedFriendsHeader friendsListViewModel$Item$SuggestedFriendsHeader = !arrayList.isEmpty() ? new FriendsListViewModel$Item$SuggestedFriendsHeader(arrayList.size(), false, arrayList.size() > 2) : null;
        FriendsListViewModel$getItems$3 friendsListViewModel$getItems$3 = FriendsListViewModel$getItems$3.INSTANCE;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Map$Entry map$Entry : i0.asSequence(relationships)) {
            long jLongValue = ((Number) map$Entry.getKey()).longValue();
            int iIntValue = ((Number) map$Entry.getValue()).intValue();
            User user = users.get(Long.valueOf(jLongValue));
            int type = ModelUserRelationship.getType(Integer.valueOf(iIntValue));
            Presence presence = presences.get(Long.valueOf(jLongValue));
            boolean zContainsKey = applicationStreams.containsKey(Long.valueOf(jLongValue));
            if (user != null && type != 2) {
                if (FriendsListViewModel$getItems$3.INSTANCE.invoke(type)) {
                    arrayList2.add(new FriendsListViewModel$Item$PendingFriendRequest(user, presence, type));
                } else {
                    arrayList3.add(new FriendsListViewModel$Item$Friend(user, presence, zContainsKey));
                }
            }
        }
        List list = u.toList(u.sortedWith(arrayList2, FriendsListViewModel$getItems$sortedPendingItems$1.INSTANCE));
        FriendsListViewModel$Item$PendingHeader friendsListViewModel$Item$PendingHeader = !list.isEmpty() ? new FriendsListViewModel$Item$PendingHeader(2131889489, list.size(), false, list.size() > 2) : null;
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        for (Object obj : arrayList3) {
            if (((FriendsListViewModel$Item$Friend) obj).isOnline()) {
                arrayList5.add(obj);
            }
        }
        List list2 = u.toList(u.sortedWith(arrayList5, FriendsListViewModel$getItems$onlineFriendItems$2.INSTANCE));
        if (!list2.isEmpty()) {
            arrayList4.add(new FriendsListViewModel$Item$Header(2131889485, list2.size()));
            arrayList4.addAll(list2);
        }
        ArrayList arrayList6 = new ArrayList();
        for (Object obj2 : arrayList3) {
            if (!((FriendsListViewModel$Item$Friend) obj2).isOnline()) {
                arrayList6.add(obj2);
            }
        }
        List list3 = u.toList(u.sortedWith(arrayList6, FriendsListViewModel$getItems$offlineFriendItems$2.INSTANCE));
        if (true ^ list3.isEmpty()) {
            arrayList4.add(new FriendsListViewModel$Item$Header(2131889484, list3.size()));
            arrayList4.addAll(list3);
        }
        return new FriendsListViewModel$ListSections(friendsListViewModel$Item$SuggestedFriendsHeader, arrayList, friendsListViewModel$Item$PendingHeader, list, arrayList4, showContactSyncUpsell ? new FriendsListViewModel$Item$ContactSyncUpsell(false) : null);
    }

    private final List<FriendsListViewModel$Item> getVisibleItems(FriendsListViewModel$ListSections listSections) {
        FriendsListViewModel$Item$SuggestedFriendsHeader suggestionsHeaderItem = listSections.getSuggestionsHeaderItem();
        List<FriendsListViewModel$Item$SuggestedFriend> suggestedFriendItems = listSections.getSuggestedFriendItems();
        FriendsListViewModel$Item$PendingHeader pendingHeaderItem = listSections.getPendingHeaderItem();
        List<FriendsListViewModel$Item> pendingItems = listSections.getPendingItems();
        List<FriendsListViewModel$Item> friendsItemsWithHeaders = listSections.getFriendsItemsWithHeaders();
        ArrayList arrayList = new ArrayList();
        if (listSections.getContactSyncUpsell() != null) {
            arrayList.add(listSections.getContactSyncUpsell());
        }
        if (!this.isSuggestedSectionExpanded) {
            suggestedFriendItems = u.take(suggestedFriendItems, 2);
        }
        if (suggestionsHeaderItem != null && (!suggestedFriendItems.isEmpty())) {
            arrayList.add(suggestionsHeaderItem);
            arrayList.addAll(suggestedFriendItems);
        }
        if (!this.isPendingSectionExpanded) {
            pendingItems = u.take(pendingItems, 2);
        }
        if (pendingHeaderItem != null && (!pendingItems.isEmpty())) {
            arrayList.add(pendingHeaderItem);
            arrayList.addAll(pendingItems);
        }
        arrayList.addAll(friendsItemsWithHeaders);
        return arrayList;
    }

    @MainThread
    private final void handleComputedItems(FriendsListViewModel$ListSections listSections, boolean showContactSyncIcon) {
        this.listSections = listSections;
        generateLoadedItems(showContactSyncIcon);
    }

    private final void handleStoreState(FriendsListViewModel$StoreState storeState) throws Exception {
        Cancellable cancellable = this.computeItemJob;
        if (cancellable != null) {
            cancellable.cancel();
        }
        if (!(storeState.getRelationshipsState() instanceof StoreUserRelationships$UserRelationshipsState$Loaded)) {
            updateViewState(FriendsListViewModel$ViewState$Uninitialized.INSTANCE);
            return;
        }
        Map<Long, Integer> relationships = ((StoreUserRelationships$UserRelationshipsState$Loaded) storeState.getRelationshipsState()).getRelationships();
        if (relationships.isEmpty()) {
            updateViewState(new FriendsListViewModel$ViewState$Empty(storeState.getShowContactSyncIcon() || storeState.getShowContactSyncUpsell()));
        } else {
            this.computeItemJob = asyncComputeAndHandleOnUiThread$default(this, new FriendsListViewModel$handleStoreState$1(this, relationships, storeState), null, new FriendsListViewModel$handleStoreState$2(this, storeState), 2, null);
        }
    }

    public final void acceptFriendRequest(long userId, String username) {
        m.checkNotNullParameter(username, "username");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.addRelationship$default(this.restAPI, LOCATION, userId, null, null, null, 28, null), false, 1, null), this, null, 2, null), FriendsListViewModel.class, (Context) null, (Function1) null, new FriendsListViewModel$acceptFriendRequest$2(this, username), (Function0) null, (Function0) null, new FriendsListViewModel$acceptFriendRequest$1(this), 54, (Object) null);
    }

    public final void acceptFriendSuggestion(String username, int discriminator, CaptchaHelper$CaptchaPayload captchaPayload) {
        m.checkNotNullParameter(username, "username");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().sendRelationshipRequest("Friends List - Friend Suggestion", username, discriminator, captchaPayload), false, 1, null), this, null, 2, null), FriendsListViewModel.class, (Context) null, (Function1) null, new FriendsListViewModel$acceptFriendSuggestion$2(this, username, discriminator), (Function0) null, (Function0) null, FriendsListViewModel$acceptFriendSuggestion$1.INSTANCE, 54, (Object) null);
    }

    @MainThread
    public final void dismissContactSyncUpsell() {
        StoreStream.Companion.getContactSync().dismissFriendsListUpsell();
    }

    public final RestAPI getRestAPI() {
        return this.restAPI;
    }

    public final StoreChannels getStoreChannels() {
        return this.storeChannels;
    }

    public final Observable<FriendsListViewModel$StoreState> getStoreObservable() {
        return this.storeObservable;
    }

    @MainThread
    public final void handleClickPendingHeader() {
        boolean showContactSyncIcon;
        this.isPendingSectionExpanded = !this.isPendingSectionExpanded;
        FriendsListViewModel$ViewState viewState = getViewState();
        if (viewState instanceof FriendsListViewModel$ViewState$Empty) {
            showContactSyncIcon = ((FriendsListViewModel$ViewState$Empty) viewState).getShowContactSyncIcon();
        } else {
            showContactSyncIcon = viewState instanceof FriendsListViewModel$ViewState$Loaded ? ((FriendsListViewModel$ViewState$Loaded) viewState).getShowContactSyncIcon() : false;
        }
        generateLoadedItems(showContactSyncIcon);
    }

    @MainThread
    public final void handleClickSuggestedHeader() {
        boolean showContactSyncIcon;
        this.isSuggestedSectionExpanded = !this.isSuggestedSectionExpanded;
        FriendsListViewModel$ViewState viewState = getViewState();
        if (viewState instanceof FriendsListViewModel$ViewState$Empty) {
            showContactSyncIcon = ((FriendsListViewModel$ViewState$Empty) viewState).getShowContactSyncIcon();
        } else {
            showContactSyncIcon = viewState instanceof FriendsListViewModel$ViewState$Loaded ? ((FriendsListViewModel$ViewState$Loaded) viewState).getShowContactSyncIcon() : false;
        }
        generateLoadedItems(showContactSyncIcon);
    }

    public final void ignoreSuggestion(long userId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.ignoreFriendSuggestion(userId), false, 1, null), this, null, 2, null), FriendsListViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, FriendsListViewModel$ignoreSuggestion$1.INSTANCE, 62, (Object) null);
    }

    public final void launchVoiceCall(long userId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.createOrFetchDM(userId), false, 1, null), this, null, 2, null), FriendsListViewModel.class, (Context) null, (Function1) null, new FriendsListViewModel$launchVoiceCall$2(this), (Function0) null, (Function0) null, new FriendsListViewModel$launchVoiceCall$1(this), 54, (Object) null);
    }

    @MainThread
    public final Observable<FriendsListViewModel$Event> observeEvents() {
        PublishSubject<FriendsListViewModel$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void removeFriendRequest(long userId, int relationshipType) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.removeRelationship(LOCATION, userId), false, 1, null), this, null, 2, null), FriendsListViewModel.class, (Context) null, (Function1) null, new FriendsListViewModel$removeFriendRequest$2(this), (Function0) null, (Function0) null, new FriendsListViewModel$removeFriendRequest$1(this, relationshipType == 3 ? 2131889460 : 2131889455), 54, (Object) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendsListViewModel(Observable<FriendsListViewModel$StoreState> observable, StoreChannels storeChannels, RestAPI restAPI) {
        super(FriendsListViewModel$ViewState$Uninitialized.INSTANCE);
        m.checkNotNullParameter(observable, "storeObservable");
        m.checkNotNullParameter(storeChannels, "storeChannels");
        m.checkNotNullParameter(restAPI, "restAPI");
        this.storeObservable = observable;
        this.storeChannels = storeChannels;
        this.restAPI = restAPI;
        this.listSections = new FriendsListViewModel$ListSections(null, n.emptyList(), null, n.emptyList(), n.emptyList(), null);
        this.eventSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), FriendsListViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new FriendsListViewModel$1(this), 62, (Object) null);
    }
}
