package com.discord.widgets.contact_sync;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.api.friendsuggestions.AllowedInSuggestionsType;
import com.discord.api.friendsuggestions.BulkAddFriendsResponse;
import com.discord.api.friendsuggestions.BulkFriendSuggestions;
import com.discord.api.friendsuggestions.FriendSuggestion;
import com.discord.api.friendsuggestions.FriendSuggestionReason;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.phone.PhoneCountryCode;
import com.discord.restapi.RestAPIParams$ConnectedAccount;
import com.discord.restapi.RestAPIParams$ConnectedAccountContacts;
import com.discord.restapi.RestAPIParams$ContactEntry;
import com.discord.restapi.RestAPIParams$Phone;
import com.discord.restapi.RestAPIParams$UploadContacts;
import com.discord.restapi.RestAPIParams$UserBulkRelationship;
import com.discord.restapi.RestAPIParams$UserSettings;
import com.discord.restapi.RestAPIParams$VerificationCodeOnly;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.captcha.CaptchaHelper$CaptchaPayload;
import com.discord.utilities.error.Error;
import com.discord.utilities.error.Error$Response;
import com.discord.utilities.error.Error$Type;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.ClockFactory;
import com.discord.widgets.user.phone.WidgetUserPhoneManage$Companion$Source;
import d0.g0.t;
import d0.g0.w;
import d0.o;
import d0.t.g0;
import d0.t.h0;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetContactSyncViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetContactSyncViewModel extends d0<WidgetContactSyncViewModel$ViewState> {
    public static final WidgetContactSyncViewModel$Companion Companion = new WidgetContactSyncViewModel$Companion(null);
    private final Function1<Error, Unit> captchaLauncher;
    private final PublishSubject<WidgetContactSyncViewModel$Event> eventsSubject;
    private boolean initialized;
    private final RestAPI restAPI;
    private final ContactSyncFlowAnalytics tracker;

    public /* synthetic */ WidgetContactSyncViewModel(ContactSyncMode contactSyncMode, boolean z2, boolean z3, RestAPI restAPI, Observable observable, ContactSyncFlowAnalytics contactSyncFlowAnalytics, boolean z4, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        ContactSyncFlowAnalytics contactSyncFlowAnalytics2;
        boolean z5 = (i & 2) != 0 ? true : z2;
        boolean z6 = (i & 4) != 0 ? true : z3;
        RestAPI api = (i & 8) != 0 ? RestAPI.Companion.getApi() : restAPI;
        Observable observableObserveStores = (i & 16) != 0 ? Companion.observeStores() : observable;
        if ((i & 32) != 0) {
            contactSyncFlowAnalytics2 = new ContactSyncFlowAnalytics(contactSyncMode == ContactSyncMode.ONBOARDING, ClockFactory.get());
        } else {
            contactSyncFlowAnalytics2 = contactSyncFlowAnalytics;
        }
        this(contactSyncMode, z5, z6, api, observableObserveStores, contactSyncFlowAnalytics2, (i & 64) != 0 ? false : z4, function1);
    }

    public static final /* synthetic */ Function1 access$getCaptchaLauncher$p(WidgetContactSyncViewModel widgetContactSyncViewModel) {
        return widgetContactSyncViewModel.captchaLauncher;
    }

    public static final /* synthetic */ void access$handleContactsEnableError(WidgetContactSyncViewModel widgetContactSyncViewModel, Error error) {
        widgetContactSyncViewModel.handleContactsEnableError(error);
    }

    public static final /* synthetic */ void access$handleContactsEnabled(WidgetContactSyncViewModel widgetContactSyncViewModel) {
        widgetContactSyncViewModel.handleContactsEnabled();
    }

    public static final /* synthetic */ void access$handleFriendSuggestions(WidgetContactSyncViewModel widgetContactSyncViewModel, BulkFriendSuggestions bulkFriendSuggestions) {
        widgetContactSyncViewModel.handleFriendSuggestions(bulkFriendSuggestions);
    }

    public static final /* synthetic */ void access$handleFriendsAdded(WidgetContactSyncViewModel widgetContactSyncViewModel, BulkAddFriendsResponse bulkAddFriendsResponse) {
        widgetContactSyncViewModel.handleFriendsAdded(bulkAddFriendsResponse);
    }

    public static final /* synthetic */ void access$handleFriendsAddedError(WidgetContactSyncViewModel widgetContactSyncViewModel, Error error) {
        widgetContactSyncViewModel.handleFriendsAddedError(error);
    }

    public static final /* synthetic */ void access$handlePhoneSubmitted(WidgetContactSyncViewModel widgetContactSyncViewModel) {
        widgetContactSyncViewModel.handlePhoneSubmitted();
    }

    public static final /* synthetic */ void access$handlePhoneSubmittedError(WidgetContactSyncViewModel widgetContactSyncViewModel) {
        widgetContactSyncViewModel.handlePhoneSubmittedError();
    }

    public static final /* synthetic */ void access$handlePhoneVerified(WidgetContactSyncViewModel widgetContactSyncViewModel) {
        widgetContactSyncViewModel.handlePhoneVerified();
    }

    public static final /* synthetic */ void access$handlePhoneVerifiedError(WidgetContactSyncViewModel widgetContactSyncViewModel, Error error) {
        widgetContactSyncViewModel.handlePhoneVerifiedError(error);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetContactSyncViewModel widgetContactSyncViewModel, WidgetContactSyncViewModel$StoreState widgetContactSyncViewModel$StoreState) {
        widgetContactSyncViewModel.handleStoreState(widgetContactSyncViewModel$StoreState);
    }

    public static final /* synthetic */ void access$handleUploadError(WidgetContactSyncViewModel widgetContactSyncViewModel, Error error) {
        widgetContactSyncViewModel.handleUploadError(error);
    }

    private final WidgetContactSyncViewModel$ToolbarConfig getLandingToolbarConfig(ContactSyncMode mode) {
        int iOrdinal = mode.ordinal();
        if (iOrdinal == 0) {
            return WidgetContactSyncViewModelKt.access$getTOOLBAR_CONFIG_ONBOARDING$p();
        }
        if (iOrdinal == 1) {
            return WidgetContactSyncViewModelKt.access$getTOOLBAR_CONFIG_DEFAULT$p();
        }
        throw new NoWhenBranchMatchedException();
    }

    private final void handleComplete() {
        WidgetContactSyncViewModel$ViewState viewState = getViewState();
        if (viewState != null) {
            if (viewState.getMode() == ContactSyncMode.ONBOARDING) {
                StoreStream.Companion.getNux().setContactSyncCompleted(true);
            }
            PublishSubject<WidgetContactSyncViewModel$Event> publishSubject = this.eventsSubject;
            publishSubject.k.onNext(WidgetContactSyncViewModel$Event$Completed.INSTANCE);
        }
    }

    @MainThread
    private final void handleContactsEnableError(Error error) {
        if (error.getType() == Error$Type.RATE_LIMITED) {
            PublishSubject<WidgetContactSyncViewModel$Event> publishSubject = this.eventsSubject;
            publishSubject.k.onNext(WidgetContactSyncViewModel$Event$RateLimited.INSTANCE);
        } else {
            PublishSubject<WidgetContactSyncViewModel$Event> publishSubject2 = this.eventsSubject;
            publishSubject2.k.onNext(WidgetContactSyncViewModel$Event$ContactsEnableFailed.INSTANCE);
        }
        WidgetContactSyncViewModel$ViewState viewState = getViewState();
        if (viewState != null) {
            updateViewState(WidgetContactSyncViewModel$ViewState.copy$default(viewState, false, null, null, null, null, null, null, false, false, WidgetContactSyncViewModel$Views.VIEW_LANDING, false, false, null, null, null, getLandingToolbarConfig(viewState.getMode()), 32255, null));
        }
    }

    @MainThread
    private final void handleContactsEnabled() {
        WidgetContactSyncViewModel$ViewState viewState = getViewState();
        if (viewState != null) {
            AnalyticsTracker.INSTANCE.contactSyncToggled(true, viewState.getAllowPhone(), viewState.getAllowEmail());
            PublishSubject<WidgetContactSyncViewModel$Event> publishSubject = this.eventsSubject;
            publishSubject.k.onNext(WidgetContactSyncViewModel$Event$ContactsEnabled.INSTANCE);
        }
    }

    @MainThread
    private final void handleFriendSuggestions(BulkFriendSuggestions suggestions) {
        WidgetContactSyncViewModel$ViewState viewState = getViewState();
        if (viewState != null) {
            if (suggestions.b().isEmpty()) {
                ContactSyncFlowAnalytics contactSyncFlowAnalytics = this.tracker;
                WidgetContactSyncViewModel$Views widgetContactSyncViewModel$Views = WidgetContactSyncViewModel$Views.VIEW_SUGGESTIONS_EMPTY;
                contactSyncFlowAnalytics.trackFlowStep(widgetContactSyncViewModel$Views.getTrackingStep(), false, false, g0.mapOf(o.to("num_contacts_found", 0)));
                updateViewState(WidgetContactSyncViewModel$ViewState.copy$default(viewState, false, null, null, null, null, null, null, false, false, widgetContactSyncViewModel$Views, false, false, null, null, null, new WidgetContactSyncViewModel$ToolbarConfig(false, false), 32127, null));
                return;
            }
            StoreStream.Companion.getFriendSuggestions().updateFriendSuggestions(suggestions.b());
            List<FriendSuggestion> listB = suggestions.b();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = listB.iterator();
            while (true) {
                boolean z2 = true;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                List<FriendSuggestionReason> listA = ((FriendSuggestion) next).a();
                if (!(listA instanceof Collection) || !listA.isEmpty()) {
                    Iterator<T> it2 = listA.iterator();
                    do {
                        if (!it2.hasNext()) {
                            z2 = false;
                            break;
                        }
                    } while (!m.areEqual(((FriendSuggestionReason) it2.next()).getPlatformType(), "contacts"));
                } else {
                    z2 = false;
                    break;
                }
                if (z2) {
                    arrayList.add(next);
                }
            }
            this.tracker.trackFlowStep(WidgetContactSyncViewModel$Views.VIEW_SUGGESTIONS.getTrackingStep(), false, false, g0.mapOf(o.to("num_contacts_found", Integer.valueOf(arrayList.size()))));
            String bulkAddToken = suggestions.getBulkAddToken();
            ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(arrayList, 10));
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                arrayList2.add(new WidgetContactSyncViewModel$Item$FriendSuggestionItem((FriendSuggestion) it3.next(), true));
            }
            ArrayList arrayList3 = new ArrayList(d0.t.o.collectionSizeOrDefault(arrayList, 10));
            Iterator it4 = arrayList.iterator();
            while (it4.hasNext()) {
                arrayList3.add(Long.valueOf(((FriendSuggestion) it4.next()).getSuggestedUser().getId()));
            }
            updateViewState(WidgetContactSyncViewModel$ViewState.copy$default(viewState, false, null, null, null, null, null, null, false, false, WidgetContactSyncViewModel$Views.VIEW_SUGGESTIONS, false, false, bulkAddToken, arrayList2, arrayList3, new WidgetContactSyncViewModel$ToolbarConfig(false, true), 3455, null));
        }
    }

    @MainThread
    private final void handleFriendsAdded(BulkAddFriendsResponse result) {
        WidgetContactSyncViewModel$ViewState viewState = getViewState();
        if (viewState != null) {
            updateViewState(WidgetContactSyncViewModel$ViewState.copy$default(viewState, false, null, null, null, null, null, null, false, false, null, false, false, null, null, null, null, 65407, null));
            this.tracker.trackEnd(false, h0.mapOf(o.to("num_contacts_found", Integer.valueOf(viewState.getFriendSuggestions().size())), o.to("num_contacts_added", Integer.valueOf(result.b().size()))));
            if (!(!result.a().isEmpty())) {
                handleComplete();
            } else {
                this.eventsSubject.k.onNext(WidgetContactSyncViewModel$Event$AddFriendsFailedPartial.INSTANCE);
            }
        }
    }

    @MainThread
    private final void handleFriendsAddedError(Error error) {
        WidgetContactSyncViewModel$ViewState viewState = getViewState();
        if (viewState != null) {
            updateViewState(WidgetContactSyncViewModel$ViewState.copy$default(viewState, false, null, null, null, null, null, null, false, false, null, false, false, null, null, null, null, 65407, null));
            this.tracker.trackEnd(false, h0.mapOf(o.to("num_contacts_found", Integer.valueOf(viewState.getFriendSuggestions().size())), o.to("num_contacts_added", 0)));
            Error$Response response = error.getResponse();
            m.checkNotNullExpressionValue(response, "error.response");
            Map<String, List<String>> messages = response.getMessages();
            m.checkNotNullExpressionValue(messages, "error.response.messages");
            if (!messages.isEmpty()) {
                this.eventsSubject.k.onNext(WidgetContactSyncViewModel$Event$AddFriendsFailed.INSTANCE);
            }
        }
    }

    @MainThread
    private final void handlePhoneSubmitted() {
        WidgetContactSyncViewModel$ViewState viewState = getViewState();
        if (viewState != null) {
            ContactSyncFlowAnalytics contactSyncFlowAnalytics = this.tracker;
            WidgetContactSyncViewModel$Views widgetContactSyncViewModel$Views = WidgetContactSyncViewModel$Views.VIEW_VERIFY_PHONE;
            ContactSyncFlowAnalytics.trackFlowStep$default(contactSyncFlowAnalytics, widgetContactSyncViewModel$Views.getTrackingStep(), false, false, null, 8, null);
            updateViewState(WidgetContactSyncViewModel$ViewState.copy$default(viewState, false, null, null, null, null, null, null, false, false, widgetContactSyncViewModel$Views, false, false, null, null, null, null, 65023, null));
        }
    }

    @MainThread
    private final void handlePhoneSubmittedError() {
        PublishSubject<WidgetContactSyncViewModel$Event> publishSubject = this.eventsSubject;
        publishSubject.k.onNext(WidgetContactSyncViewModel$Event$PhoneInvalid.INSTANCE);
    }

    @MainThread
    private final void handlePhoneVerified() {
        WidgetContactSyncViewModel$ViewState viewState = getViewState();
        if (viewState != null) {
            updateViewState(WidgetContactSyncViewModel$ViewState.copy$default(viewState, false, null, null, null, null, null, null, false, false, WidgetContactSyncViewModel$Views.VIEW_LANDING, false, false, null, null, null, getLandingToolbarConfig(viewState.getMode()), 32255, null));
            PublishSubject<WidgetContactSyncViewModel$Event> publishSubject = this.eventsSubject;
            publishSubject.k.onNext(WidgetContactSyncViewModel$Event$PermissionsNeeded.INSTANCE);
        }
    }

    @MainThread
    private final void handlePhoneVerifiedError(Error error) {
        Error$Response response = error.getResponse();
        m.checkNotNullExpressionValue(response, "error.response");
        Map<String, List<String>> messages = response.getMessages();
        m.checkNotNullExpressionValue(messages, "error.response.messages");
        if (!messages.isEmpty()) {
            this.eventsSubject.k.onNext(WidgetContactSyncViewModel$Event$VerificationCodeInvalid.INSTANCE);
        } else {
            this.eventsSubject.k.onNext(WidgetContactSyncViewModel$Event$VerificationFailed.INSTANCE);
        }
    }

    private final void handleStoreState(WidgetContactSyncViewModel$StoreState storeState) {
        WidgetContactSyncViewModel$ViewState viewState = getViewState();
        if (viewState != null) {
            updateViewState(WidgetContactSyncViewModel$ViewState.copy$default(viewState, true, null, storeState.getUserPhone(), storeState.getContactsConnection(), storeState.getCountryCode(), storeState.getUsername(), null, false, false, null, false, false, null, null, null, null, 65474, null));
            if (this.initialized) {
                return;
            }
            this.initialized = true;
            PublishSubject<WidgetContactSyncViewModel$Event> publishSubject = this.eventsSubject;
            publishSubject.k.onNext(WidgetContactSyncViewModel$Event$MaybeProceedFromLanding.INSTANCE);
        }
    }

    @MainThread
    private final void handleUploadError(Error error) {
        WidgetContactSyncViewModel$ViewState viewState = getViewState();
        if (viewState != null) {
            updateViewState(WidgetContactSyncViewModel$ViewState.copy$default(viewState, false, null, null, null, null, null, null, false, false, WidgetContactSyncViewModel$Views.VIEW_LANDING, false, false, null, null, null, getLandingToolbarConfig(viewState.getMode()), 32127, null));
            if (error.getType() == Error$Type.RATE_LIMITED) {
                PublishSubject<WidgetContactSyncViewModel$Event> publishSubject = this.eventsSubject;
                publishSubject.k.onNext(WidgetContactSyncViewModel$Event$RateLimited.INSTANCE);
            } else {
                PublishSubject<WidgetContactSyncViewModel$Event> publishSubject2 = this.eventsSubject;
                publishSubject2.k.onNext(WidgetContactSyncViewModel$Event$UploadFailed.INSTANCE);
            }
        }
    }

    @MainThread
    public final void dismissUpsell() {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        storeStream$Companion.getContactSync().dismissUpsell();
        storeStream$Companion.getUserSettings().updateContactSyncShown();
    }

    public final ContactSyncFlowAnalytics getTracker() {
        return this.tracker;
    }

    @MainThread
    public final void handleToggleFriendSuggestionSelected(long userId, boolean isSelected) {
        WidgetContactSyncViewModel$ViewState viewState = getViewState();
        if (viewState != null) {
            List mutableList = u.toMutableList((Collection) viewState.getSelectedFriendIds());
            if (isSelected) {
                mutableList.add(Long.valueOf(userId));
            } else {
                mutableList.remove(Long.valueOf(userId));
            }
            updateViewState(WidgetContactSyncViewModel$ViewState.copy$default(viewState, false, null, null, null, null, null, null, false, false, null, false, false, null, null, mutableList, null, 49151, null));
        }
    }

    public final Observable<WidgetContactSyncViewModel$Event> observeEvents() {
        PublishSubject<WidgetContactSyncViewModel$Event> publishSubject = this.eventsSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventsSubject");
        return publishSubject;
    }

    @MainThread
    public final void onBulkAddFriends() {
        String bulkAddToken;
        WidgetContactSyncViewModel$ViewState viewState = getViewState();
        if (viewState == null || (bulkAddToken = viewState.getBulkAddToken()) == null) {
            return;
        }
        List<Long> selectedFriendIds = viewState.getSelectedFriendIds();
        if (selectedFriendIds.isEmpty()) {
            this.tracker.trackEnd(false, h0.mapOf(o.to("num_contacts_found", Integer.valueOf(viewState.getFriendSuggestions().size())), o.to("num_contacts_added", 0)));
            handleComplete();
        } else {
            updateViewState(WidgetContactSyncViewModel$ViewState.copy$default(viewState, false, null, null, null, null, null, null, true, false, null, false, false, null, null, null, null, 65407, null));
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(RestCallStateKt.logNetworkAction(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.bulkAddRelationships(new RestAPIParams$UserBulkRelationship(selectedFriendIds, bulkAddToken)), false, 1, null), WidgetContactSyncViewModel$onBulkAddFriends$1.INSTANCE), this, null, 2, null), WidgetContactSyncViewModel.class, (Context) null, (Function1) null, new WidgetContactSyncViewModel$onBulkAddFriends$3(this), (Function0) null, (Function0) null, new WidgetContactSyncViewModel$onBulkAddFriends$2(this), 54, (Object) null);
        }
    }

    @MainThread
    public final void onContactsFetched(Set<String> contactNumbers) {
        m.checkNotNullParameter(contactNumbers, "contactNumbers");
        WidgetContactSyncViewModel$ViewState viewState = getViewState();
        if (viewState != null) {
            updateViewState(WidgetContactSyncViewModel$ViewState.copy$default(viewState, false, null, null, null, null, null, null, true, false, null, false, false, null, null, null, null, 65407, null));
            ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(contactNumbers, 10));
            for (String str : contactNumbers) {
                arrayList.add(new RestAPIParams$ContactEntry(str, str, g0.mapOf(new Pair("number", str))));
            }
            RestAPIParams$UploadContacts restAPIParams$UploadContacts = new RestAPIParams$UploadContacts(arrayList, false, AllowedInSuggestionsType.ANYONE_WITH_CONTACT_INFO);
            StoreStream.Companion.getContactSync().setContactSyncUploadTimestamp(ClockFactory.get().currentTimeMillis());
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestCallStateKt.logNetworkAction(this.restAPI.uploadContacts(restAPIParams$UploadContacts), WidgetContactSyncViewModel$onContactsFetched$1.INSTANCE), false, 1, null), this, null, 2, null), WidgetContactSyncViewModel.class, (Context) null, (Function1) null, new WidgetContactSyncViewModel$onContactsFetched$3(this), (Function0) null, (Function0) null, new WidgetContactSyncViewModel$onContactsFetched$2(this), 54, (Object) null);
        }
    }

    @MainThread
    public final void onLandingNext() {
        WidgetContactSyncViewModel$ViewState viewState = getViewState();
        if (viewState != null) {
            if (viewState.getPhoneNumber() != null) {
                PublishSubject<WidgetContactSyncViewModel$Event> publishSubject = this.eventsSubject;
                publishSubject.k.onNext(WidgetContactSyncViewModel$Event$PermissionsNeeded.INSTANCE);
            } else {
                ContactSyncFlowAnalytics contactSyncFlowAnalytics = this.tracker;
                WidgetContactSyncViewModel$Views widgetContactSyncViewModel$Views = WidgetContactSyncViewModel$Views.VIEW_ADD_PHONE;
                ContactSyncFlowAnalytics.trackFlowStep$default(contactSyncFlowAnalytics, widgetContactSyncViewModel$Views.getTrackingStep(), false, false, null, 8, null);
                updateViewState(WidgetContactSyncViewModel$ViewState.copy$default(viewState, false, null, null, null, null, null, null, false, false, widgetContactSyncViewModel$Views, false, false, null, null, null, WidgetContactSyncViewModelKt.access$getTOOLBAR_CONFIG_DEFAULT$p(), 32255, null));
            }
        }
    }

    @MainThread
    public final void onNameSubmitted(String name) {
        MGRecyclerAdapterSimple mGRecyclerAdapterSimple;
        m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        AnalyticsTracker.INSTANCE.nameSubmitted(w.split$default((CharSequence) name, new String[]{" "}, false, 0, 6, (Object) null).size(), name.length());
        String string = t.isBlank(name) ? null : w.trim(name).toString();
        WidgetContactSyncViewModel$ViewState viewState = getViewState();
        if (viewState != null) {
            updateViewState(WidgetContactSyncViewModel$ViewState.copy$default(viewState, false, null, null, null, null, null, name, false, false, null, false, false, null, null, null, null, 65471, null));
            ConnectedAccount existingConnection = viewState.getExistingConnection();
            if (existingConnection != null) {
                mGRecyclerAdapterSimple = null;
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(RestCallStateKt.logNetworkAction(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.updateConnection(existingConnection.getType(), existingConnection.getId(), new RestAPIParams$ConnectedAccount(true, existingConnection.getId(), string, existingConnection.getRevoked(), existingConnection.getShowActivity(), existingConnection.getType(), existingConnection.getVerified(), existingConnection.getVisibility())), false, 1, null), new WidgetContactSyncViewModel$onNameSubmitted$1(string)), this, null, 2, null), WidgetContactSyncViewModel.class, (Context) null, (Function1) null, new WidgetContactSyncViewModel$onNameSubmitted$3(this), (Function0) null, (Function0) null, new WidgetContactSyncViewModel$onNameSubmitted$2(this), 54, (Object) null);
            } else {
                mGRecyclerAdapterSimple = null;
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.createConnectionContacts(new RestAPIParams$ConnectedAccountContacts(string, true)), false, 1, null), this, null, 2, null), WidgetContactSyncViewModel.class, (Context) null, (Function1) null, new WidgetContactSyncViewModel$onNameSubmitted$5(this), (Function0) null, (Function0) null, new WidgetContactSyncViewModel$onNameSubmitted$4(this), 54, (Object) null);
            }
            int i = viewState.getAllowPhone() ? 2 : 0;
            if (viewState.getAllowEmail()) {
                i |= 4;
            }
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.updateUserSettings(RestAPIParams$UserSettings.Companion.createWithFriendDiscoveryFlags(Integer.valueOf(i))), false, 1, mGRecyclerAdapterSimple), this, mGRecyclerAdapterSimple, 2, mGRecyclerAdapterSimple), WidgetContactSyncViewModel.class, (Context) null, (Function1) null, new WidgetContactSyncViewModel$onNameSubmitted$7(this), (Function0) null, (Function0) null, WidgetContactSyncViewModel$onNameSubmitted$6.INSTANCE, 54, (Object) null);
        }
    }

    @MainThread
    public final void onPermissionsBecameAvailable() {
        WidgetContactSyncViewModel$ViewState viewState = getViewState();
        if (viewState != null) {
            updateViewState(WidgetContactSyncViewModel$ViewState.copy$default(viewState, false, null, null, null, null, null, null, false, false, null, false, false, null, null, null, null, 65279, null));
        }
    }

    @MainThread
    public final void onPermissionsDenied() {
        this.tracker.trackFlowStep(WidgetContactSyncViewModel$Views.VIEW_LANDING.getTrackingStep(), true, false, g0.mapOf(o.to("mobile_contacts_permission", "denied")));
        AnalyticsTracker.INSTANCE.permissionsAcked("contacts", false);
        WidgetContactSyncViewModel$ViewState viewState = getViewState();
        if (viewState != null) {
            updateViewState(WidgetContactSyncViewModel$ViewState.copy$default(viewState, false, null, null, null, null, null, null, false, true, null, false, false, null, null, null, null, 65151, null));
        }
    }

    @MainThread
    public final void onPermissionsGranted() {
        WidgetContactSyncViewModel$ViewState viewState = getViewState();
        if (viewState == null || viewState.getDisplayedChild() == WidgetContactSyncViewModel$Views.VIEW_SUGGESTIONS || viewState.getDisplayedChild() == WidgetContactSyncViewModel$Views.VIEW_SUGGESTIONS_EMPTY) {
            return;
        }
        AnalyticsTracker.INSTANCE.permissionsAcked("contacts", true);
        ContactSyncFlowAnalytics contactSyncFlowAnalytics = this.tracker;
        WidgetContactSyncViewModel$Views widgetContactSyncViewModel$Views = WidgetContactSyncViewModel$Views.VIEW_NAME_INPUT;
        ContactSyncFlowAnalytics.trackFlowStep$default(contactSyncFlowAnalytics, widgetContactSyncViewModel$Views.getTrackingStep(), false, false, null, 8, null);
        if (viewState.getName() != null) {
            onNameSubmitted(viewState.getName());
        } else {
            updateViewState(WidgetContactSyncViewModel$ViewState.copy$default(viewState, false, null, null, null, null, null, null, false, false, widgetContactSyncViewModel$Views, false, false, null, null, null, new WidgetContactSyncViewModel$ToolbarConfig(false, true), 31871, null));
        }
    }

    @MainThread
    public final void onPermissionsToggle(boolean allowPhone, boolean allowEmail) {
        AnalyticsTracker.INSTANCE.contactSyncToggled(false, allowPhone, allowEmail);
        WidgetContactSyncViewModel$ViewState viewState = getViewState();
        if (viewState != null) {
            updateViewState(WidgetContactSyncViewModel$ViewState.copy$default(viewState, false, null, null, null, null, null, null, false, false, null, allowPhone, allowEmail, null, null, null, null, 62463, null));
        }
    }

    @MainThread
    public final void onPhoneNumberSubmitted(String phoneNumber, CaptchaHelper$CaptchaPayload captchaPayload) {
        m.checkNotNullParameter(phoneNumber, "phoneNumber");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.userAddPhone(new RestAPIParams$Phone(phoneNumber, WidgetUserPhoneManage$Companion$Source.CONTACT_SYNC.getSource(), captchaPayload != null ? captchaPayload.getCaptchaKey() : null, captchaPayload != null ? captchaPayload.getCaptchaRqtoken() : null)), false, 1, null), this, null, 2, null), WidgetContactSyncViewModel.class, (Context) null, (Function1) null, new WidgetContactSyncViewModel$onPhoneNumberSubmitted$2(this), (Function0) null, (Function0) null, new WidgetContactSyncViewModel$onPhoneNumberSubmitted$1(this), 54, (Object) null);
    }

    @MainThread
    public final void onVerifyPhone(String code) {
        m.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.userAddPhoneNoPassword(new RestAPIParams$VerificationCodeOnly(code)), false, 1, null), this, null, 2, null), WidgetContactSyncViewModel.class, (Context) null, (Function1) null, new WidgetContactSyncViewModel$onVerifyPhone$2(this), (Function0) null, (Function0) null, new WidgetContactSyncViewModel$onVerifyPhone$1(this), 54, (Object) null);
    }

    @MainThread
    public final void requestingPermissions() {
        ContactSyncFlowAnalytics.trackFlowStep$default(this.tracker, "Contacts Permission Requested", false, false, null, 8, null);
    }

    public final void skip() {
        WidgetContactSyncViewModel$ViewState viewState = getViewState();
        if (viewState != null) {
            int iOrdinal = viewState.getDisplayedChild().ordinal();
            if (iOrdinal == 0) {
                ContactSyncFlowAnalytics.trackEnd$default(this.tracker, true, null, 2, null);
                handleComplete();
                return;
            }
            if (iOrdinal == 1) {
                ContactSyncFlowAnalytics contactSyncFlowAnalytics = this.tracker;
                WidgetContactSyncViewModel$Views widgetContactSyncViewModel$Views = WidgetContactSyncViewModel$Views.VIEW_LANDING;
                ContactSyncFlowAnalytics.trackFlowStep$default(contactSyncFlowAnalytics, widgetContactSyncViewModel$Views.getTrackingStep(), false, true, null, 8, null);
                updateViewState(WidgetContactSyncViewModel$ViewState.copy$default(viewState, false, null, null, null, null, null, null, false, false, widgetContactSyncViewModel$Views, false, false, null, null, null, getLandingToolbarConfig(viewState.getMode()), 32255, null));
                return;
            }
            if (iOrdinal == 2) {
                ContactSyncFlowAnalytics contactSyncFlowAnalytics2 = this.tracker;
                WidgetContactSyncViewModel$Views widgetContactSyncViewModel$Views2 = WidgetContactSyncViewModel$Views.VIEW_ADD_PHONE;
                ContactSyncFlowAnalytics.trackFlowStep$default(contactSyncFlowAnalytics2, widgetContactSyncViewModel$Views2.getTrackingStep(), false, true, null, 8, null);
                updateViewState(WidgetContactSyncViewModel$ViewState.copy$default(viewState, false, null, null, null, null, null, null, false, false, widgetContactSyncViewModel$Views2, false, false, null, null, null, null, 65023, null));
                return;
            }
            if (iOrdinal == 3) {
                onNameSubmitted("");
                return;
            }
            if (iOrdinal == 4) {
                this.tracker.trackEnd(false, h0.mapOf(o.to("num_contacts_found", Integer.valueOf(viewState.getFriendSuggestions().size())), o.to("num_contacts_added", 0)));
                handleComplete();
            } else {
                if (iOrdinal != 5) {
                    return;
                }
                this.tracker.trackEnd(false, h0.mapOf(o.to("num_contacts_found", Integer.valueOf(viewState.getFriendSuggestions().size())), o.to("num_contacts_added", 0)));
                handleComplete();
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public WidgetContactSyncViewModel(ContactSyncMode contactSyncMode, boolean z2, boolean z3, RestAPI restAPI, Observable<WidgetContactSyncViewModel$StoreState> observable, ContactSyncFlowAnalytics contactSyncFlowAnalytics, boolean z4, Function1<? super Error, Unit> function1) {
        WidgetContactSyncViewModel$ToolbarConfig widgetContactSyncViewModel$ToolbarConfigAccess$getTOOLBAR_CONFIG_ONBOARDING$p;
        m.checkNotNullParameter(contactSyncMode, "mode");
        m.checkNotNullParameter(restAPI, "restAPI");
        m.checkNotNullParameter(observable, "storeObservable");
        m.checkNotNullParameter(contactSyncFlowAnalytics, "tracker");
        m.checkNotNullParameter(function1, "captchaLauncher");
        PhoneCountryCode default_country_code = PhoneCountryCode.Companion.getDEFAULT_COUNTRY_CODE();
        WidgetContactSyncViewModel$Views widgetContactSyncViewModel$Views = WidgetContactSyncViewModel$Views.VIEW_LANDING;
        List listEmptyList = n.emptyList();
        List listEmptyList2 = n.emptyList();
        int iOrdinal = contactSyncMode.ordinal();
        if (iOrdinal == 0) {
            widgetContactSyncViewModel$ToolbarConfigAccess$getTOOLBAR_CONFIG_ONBOARDING$p = WidgetContactSyncViewModelKt.access$getTOOLBAR_CONFIG_ONBOARDING$p();
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            widgetContactSyncViewModel$ToolbarConfigAccess$getTOOLBAR_CONFIG_ONBOARDING$p = WidgetContactSyncViewModelKt.access$getTOOLBAR_CONFIG_DEFAULT$p();
        }
        super(new WidgetContactSyncViewModel$ViewState(false, contactSyncMode, null, null, default_country_code, "", null, false, false, widgetContactSyncViewModel$Views, z2, z3, null, listEmptyList, listEmptyList2, widgetContactSyncViewModel$ToolbarConfigAccess$getTOOLBAR_CONFIG_ONBOARDING$p));
        this.restAPI = restAPI;
        this.tracker = contactSyncFlowAnalytics;
        this.initialized = z4;
        this.captchaLauncher = function1;
        this.eventsSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), WidgetContactSyncViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetContactSyncViewModel$1(this), 62, (Object) null);
    }
}
