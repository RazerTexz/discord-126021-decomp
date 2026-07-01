package com.discord.widgets.settings.account;

import android.content.Context;
import androidx.annotation.StringRes;
import b.a.d.d0;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.f0.q;
import d0.t.i0;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetSettingsBlockedUsersViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsBlockedUsersViewModel extends d0<WidgetSettingsBlockedUsersViewModel$ViewState> {
    public static final WidgetSettingsBlockedUsersViewModel$Companion Companion = new WidgetSettingsBlockedUsersViewModel$Companion(null);
    private static final String LOCATION = "Blocked Users List";
    public static final int VIEW_TYPE_BLOCKED_USER_ITEM = 0;
    private final PublishSubject<WidgetSettingsBlockedUsersViewModel$Event> eventSubject;
    private final RestAPI restAPI;

    public WidgetSettingsBlockedUsersViewModel() {
        this(null, null, 3, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetSettingsBlockedUsersViewModel(Observable observable, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            WidgetSettingsBlockedUsersViewModel$Companion widgetSettingsBlockedUsersViewModel$Companion = Companion;
            StoreStream$Companion storeStream$Companion = StoreStream.Companion;
            observable = widgetSettingsBlockedUsersViewModel$Companion.observeStores(storeStream$Companion.getUserRelationships(), storeStream$Companion.getUsers());
        }
        this(observable, (i & 2) != 0 ? RestAPI.Companion.getApi() : restAPI);
    }

    public static final /* synthetic */ void access$emitShowToastEvent(WidgetSettingsBlockedUsersViewModel widgetSettingsBlockedUsersViewModel, int i) {
        widgetSettingsBlockedUsersViewModel.emitShowToastEvent(i);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetSettingsBlockedUsersViewModel widgetSettingsBlockedUsersViewModel, WidgetSettingsBlockedUsersViewModel$StoreState widgetSettingsBlockedUsersViewModel$StoreState) {
        widgetSettingsBlockedUsersViewModel.handleStoreState(widgetSettingsBlockedUsersViewModel$StoreState);
    }

    private final void emitShowToastEvent(@StringRes int stringRes) {
        PublishSubject<WidgetSettingsBlockedUsersViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new WidgetSettingsBlockedUsersViewModel$Event$ShowToast(stringRes));
    }

    private final List<WidgetSettingsBlockedUsersViewModel$Item> getItems(Map<Long, ? extends User> users) {
        return q.toList(q.sortedWith(q.map(i0.asSequence(users), WidgetSettingsBlockedUsersViewModel$getItems$1.INSTANCE), WidgetSettingsBlockedUsersViewModel$getItems$2.INSTANCE));
    }

    private final void handleStoreState(WidgetSettingsBlockedUsersViewModel$StoreState storeState) {
        List<WidgetSettingsBlockedUsersViewModel$Item> items = getItems(storeState.getUsers());
        if (items.isEmpty()) {
            updateViewState(WidgetSettingsBlockedUsersViewModel$ViewState$Empty.INSTANCE);
        } else {
            updateViewState(new WidgetSettingsBlockedUsersViewModel$ViewState$Loaded(items));
        }
    }

    public final RestAPI getRestAPI() {
        return this.restAPI;
    }

    public final Observable<WidgetSettingsBlockedUsersViewModel$Event> observeEvents() {
        PublishSubject<WidgetSettingsBlockedUsersViewModel$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void onClickUnblock(long userId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.removeRelationship(LOCATION, userId), false, 1, null), this, null, 2, null), WidgetSettingsBlockedUsersViewModel.class, (Context) null, (Function1) null, new WidgetSettingsBlockedUsersViewModel$onClickUnblock$2(this), (Function0) null, (Function0) null, new WidgetSettingsBlockedUsersViewModel$onClickUnblock$1(this), 54, (Object) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsBlockedUsersViewModel(Observable<WidgetSettingsBlockedUsersViewModel$StoreState> observable, RestAPI restAPI) {
        super(WidgetSettingsBlockedUsersViewModel$ViewState$Uninitialized.INSTANCE);
        m.checkNotNullParameter(observable, "storeObservable");
        m.checkNotNullParameter(restAPI, "restAPI");
        this.restAPI = restAPI;
        this.eventSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), WidgetSettingsBlockedUsersViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetSettingsBlockedUsersViewModel$1(this), 62, (Object) null);
    }
}
