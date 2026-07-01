package com.discord.widgets.auth;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.media.AudioAttributesCompat;
import b.a.d.d0;
import com.discord.api.channel.Channel;
import com.discord.api.user.NsfwAllowance;
import com.discord.restapi.RestAPIParams$UserInfo;
import com.discord.stores.StoreAuthentication;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.birthday.BirthdayHelper;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.error.Error;
import com.discord.utilities.error.Error$Response;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.time.TimeUtils$UTCFormat;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetAgeVerifyViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAgeVerifyViewModel extends d0<WidgetAgeVerifyViewModel$ViewState> {
    public static final WidgetAgeVerifyViewModel$Companion Companion = new WidgetAgeVerifyViewModel$Companion(null);
    private final PublishSubject<WidgetAgeVerifyViewModel$Event> eventsSubject;
    private final RestAPI restAPI;
    private final StoreAuthentication storeAuth;

    public WidgetAgeVerifyViewModel() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ WidgetAgeVerifyViewModel(RestAPI restAPI, StoreAuthentication storeAuthentication, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? RestAPI.Companion.getApi() : restAPI, (i & 2) != 0 ? StoreStream.Companion.getAuthentication() : storeAuthentication, (i & 4) != 0 ? Companion.observeStores() : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetAgeVerifyViewModel widgetAgeVerifyViewModel, WidgetAgeVerifyViewModel$StoreState widgetAgeVerifyViewModel$StoreState) {
        widgetAgeVerifyViewModel.handleStoreState(widgetAgeVerifyViewModel$StoreState);
    }

    public static final /* synthetic */ void access$handleUserUpdateFailure(WidgetAgeVerifyViewModel widgetAgeVerifyViewModel, Error error) {
        widgetAgeVerifyViewModel.handleUserUpdateFailure(error);
    }

    public static final /* synthetic */ void access$handleUserUpdateSuccess(WidgetAgeVerifyViewModel widgetAgeVerifyViewModel) {
        widgetAgeVerifyViewModel.handleUserUpdateSuccess();
    }

    private final void handleStoreState(WidgetAgeVerifyViewModel$StoreState storeState) {
        WidgetAgeVerifyViewModel$ViewState viewState = getViewState();
        if (viewState != null) {
            updateViewState(WidgetAgeVerifyViewModel$ViewState.copy$default(viewState, false, null, 0, null, null, storeState.getSafeChannel(), (storeState.getAuthed() && storeState.getNsfwAllowed() == NsfwAllowance.UNKNOWN) ? false : true, 31, null));
        }
    }

    @MainThread
    private final void handleUserUpdateFailure(Error error) {
        WidgetAgeVerifyViewModel$ViewState viewState = getViewState();
        if (viewState != null) {
            Error$Response response = error.getResponse();
            m.checkNotNullExpressionValue(response, "error.response");
            Map<String, List<String>> messages = response.getMessages();
            m.checkNotNullExpressionValue(messages, "error.response.messages");
            if (!messages.containsKey(BirthdayHelper.DATE_OF_BIRTH_KEY)) {
                updateViewState(WidgetAgeVerifyViewModel$ViewState.copy$default(viewState, false, 2131886387, 0, null, null, null, false, 124, null));
                return;
            }
            Error$Response response2 = error.getResponse();
            m.checkNotNullExpressionValue(response2, "error.response");
            Map<String, List<String>> messages2 = response2.getMessages();
            m.checkNotNullExpressionValue(messages2, "error.response.messages");
            List<String> listEmptyList = messages2.get(BirthdayHelper.DATE_OF_BIRTH_KEY);
            if (listEmptyList == null) {
                listEmptyList = n.emptyList();
            }
            m.checkNotNullExpressionValue(listEmptyList, "error.response.messages\n…IRTH_KEY) { emptyList() }");
            String strJoinToString$default = u.joinToString$default(listEmptyList, "\n", null, null, 0, null, null, 62, null);
            updateViewState(WidgetAgeVerifyViewModel$ViewState.copy$default(viewState, false, null, 2, null, strJoinToString$default, null, false, 106, null));
            this.storeAuth.setAgeGateError(strJoinToString$default);
        }
    }

    @MainThread
    private final void handleUserUpdateSuccess() {
        WidgetAgeVerifyViewModel$ViewState viewState = getViewState();
        if (viewState != null) {
            updateViewState(WidgetAgeVerifyViewModel$ViewState.copy$default(viewState, false, null, 0, null, null, null, false, 126, null));
            PublishSubject<WidgetAgeVerifyViewModel$Event> publishSubject = this.eventsSubject;
            publishSubject.k.onNext(WidgetAgeVerifyViewModel$Event$Verified.INSTANCE);
        }
    }

    @MainThread
    public final boolean backToSafety() {
        WidgetAgeVerifyViewModel$ViewState viewState = getViewState();
        Channel safeChannel = viewState != null ? viewState.getSafeChannel() : null;
        if (safeChannel == null) {
            ChannelSelector.selectChannel$default(ChannelSelector.Companion.getInstance(), 0L, 0L, null, null, 12, null);
            return true;
        }
        ChannelSelector.selectChannel$default(ChannelSelector.Companion.getInstance(), safeChannel, null, null, 6, null);
        return false;
    }

    public final Observable<WidgetAgeVerifyViewModel$Event> observeEvents() {
        PublishSubject<WidgetAgeVerifyViewModel$Event> publishSubject = this.eventsSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventsSubject");
        return publishSubject;
    }

    @MainThread
    public final void onConfirmBackClicked() {
        WidgetAgeVerifyViewModel$ViewState viewState = getViewState();
        if (viewState != null) {
            updateViewState(WidgetAgeVerifyViewModel$ViewState.copy$default(viewState, false, null, 0, null, null, null, false, 123, null));
        }
    }

    @MainThread
    public final void setDateOfBirth(long dateOfBirth) {
        WidgetAgeVerifyViewModel$ViewState viewState = getViewState();
        if (viewState != null) {
            updateViewState(WidgetAgeVerifyViewModel$ViewState.copy$default(viewState, false, null, 0, Long.valueOf(dateOfBirth), null, null, false, 119, null));
        }
    }

    @MainThread
    public final void submit(boolean isNSFWChannel) {
        Long dateOfBirth;
        WidgetAgeVerifyViewModel$ViewState viewState = getViewState();
        if (viewState == null || (dateOfBirth = viewState.getDateOfBirth()) == null) {
            return;
        }
        long jLongValue = dateOfBirth.longValue();
        boolean z2 = BirthdayHelper.INSTANCE.getAge(jLongValue) < 18;
        if (isNSFWChannel && z2 && viewState.getDisplayedChild() == 0) {
            updateViewState(WidgetAgeVerifyViewModel$ViewState.copy$default(viewState, false, null, 1, null, null, null, false, 123, null));
            return;
        }
        RestAPIParams$UserInfo restAPIParams$UserInfo = new RestAPIParams$UserInfo(null, null, null, null, null, null, null, null, null, null, TimeUtils.toUTCDateTime(Long.valueOf(jLongValue), TimeUtils$UTCFormat.SHORT), AudioAttributesCompat.FLAG_ALL, null);
        updateViewState(WidgetAgeVerifyViewModel$ViewState.copy$default(viewState, true, null, 0, null, null, null, false, 124, null));
        AnalyticsTracker.INSTANCE.ageGateSubmitted(jLongValue, isNSFWChannel ? "NSFW Channel" : "Public Server");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.patchUser(restAPIParams$UserInfo), false, 1, null), this, null, 2, null), WidgetAgeVerifyViewModel.class, (Context) null, (Function1) null, new WidgetAgeVerifyViewModel$submit$2(this), (Function0) null, (Function0) null, new WidgetAgeVerifyViewModel$submit$1(this), 54, (Object) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAgeVerifyViewModel(RestAPI restAPI, StoreAuthentication storeAuthentication, Observable<WidgetAgeVerifyViewModel$StoreState> observable) {
        super(new WidgetAgeVerifyViewModel$ViewState(false, null, 0, null, null, null, false));
        m.checkNotNullParameter(restAPI, "restAPI");
        m.checkNotNullParameter(storeAuthentication, "storeAuth");
        m.checkNotNullParameter(observable, "storeObservable");
        this.restAPI = restAPI;
        this.storeAuth = storeAuthentication;
        this.eventsSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), WidgetAgeVerifyViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetAgeVerifyViewModel$1(this), 62, (Object) null);
    }
}
