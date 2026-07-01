package com.discord.stores;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserContactsSync;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.api.friendsuggestions.AllowedInSuggestionsType;
import com.discord.api.friendsuggestions.BulkFriendSuggestions;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreUserConnections;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.contacts.ContactsFetcher;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.contact_sync.ContactSyncFlowAnalytics;
import com.discord.widgets.contact_sync.ContactSyncUpsellSheet;
import d0.Tuples;
import d0.t.Iterables2;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreContactSync.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreContactSync extends StoreV2 {
    private final Clock clock;
    private final StoreUserConnections connectionsStore;
    private ContactsFetcher contactsFetcher;
    private final HashMap<String, Boolean> dismissState;
    private final Persister<Map<String, Boolean>> dismissStateCache;
    private final Dispatcher dispatcher;
    private final StoreExperiments experimentsStore;
    private final StoreNotices noticesStore;
    private final RestAPI restAPI;
    private boolean shouldTryUploadContacts;
    private final Persister<Long> uploadTimestampCache;
    private final StoreUserSettings userSettingsStore;
    private final StoreUser usersStore;

    /* JADX INFO: renamed from: com.discord.stores.StoreContactSync$backgroundUploadContacts$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreContactSync.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<BulkFriendSuggestions, TrackNetworkMetadata2> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final TrackNetworkMetadata2 invoke(BulkFriendSuggestions bulkFriendSuggestions) {
            return new TrackNetworkActionUserContactsSync();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreContactSync$clearDismissStates$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreContactSync.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreContactSync.this.dismissState.clear();
            StoreContactSync.this.markChanged();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreContactSync$createContactSyncNotice$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreContactSync.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<FragmentActivity, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
            return Boolean.valueOf(invoke2(fragmentActivity));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(FragmentActivity fragmentActivity) {
            Intrinsics3.checkNotNullParameter(fragmentActivity, "appActivity");
            AnalyticsTracker.INSTANCE.openPopout("Contact Sync", new Traits.Location("Release Upsell", null, null, null, null, 30, null));
            ContactSyncFlowAnalytics.Companion.trackStart$default(ContactSyncFlowAnalytics.INSTANCE, false, MapsJVM.mapOf(Tuples.to("location_page", "Release Upsell")), 1, null);
            ContactSyncUpsellSheet.Companion companion = ContactSyncUpsellSheet.INSTANCE;
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(supportFragmentManager, "appActivity.supportFragmentManager");
            companion.show(supportFragmentManager);
            return true;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreContactSync$dismissFriendsListUpsell$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreContactSync.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreContactSync.this.dismissState.put("CONTACT_SYNC_DISMISS_FRIENDS_UPSELL", Boolean.TRUE);
            StoreContactSync.this.markChanged();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreContactSync$dismissUpsell$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreContactSync.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreContactSync.this.dismissState.put("CONTACT_SYNC_DISMISS_UPSELL", Boolean.TRUE);
            StoreContactSync.this.markChanged();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreContactSync$handleConnectionOpen$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreContactSync.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreContactSync.this.handlePostConnectionOpen();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreContactSync$setContactSyncUploadTimestamp$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreContactSync.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $timestamp;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$timestamp = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreContactSync storeContactSync = StoreContactSync.this;
            storeContactSync.shouldTryUploadContacts = storeContactSync.clock.currentTimeMillis() - this.$timestamp > 86400000;
            StoreContactSync.this.markChanged();
        }
    }

    public StoreContactSync(Dispatcher dispatcher, RestAPI restAPI, Clock clock, StoreUserConnections storeUserConnections, StoreUser storeUser, StoreExperiments storeExperiments, StoreNotices storeNotices, StoreUserSettings storeUserSettings) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(storeUserConnections, "connectionsStore");
        Intrinsics3.checkNotNullParameter(storeUser, "usersStore");
        Intrinsics3.checkNotNullParameter(storeExperiments, "experimentsStore");
        Intrinsics3.checkNotNullParameter(storeNotices, "noticesStore");
        Intrinsics3.checkNotNullParameter(storeUserSettings, "userSettingsStore");
        this.dispatcher = dispatcher;
        this.restAPI = restAPI;
        this.clock = clock;
        this.connectionsStore = storeUserConnections;
        this.usersStore = storeUser;
        this.experimentsStore = storeExperiments;
        this.noticesStore = storeNotices;
        this.userSettingsStore = storeUserSettings;
        this.dismissStateCache = new Persister<>("CONTACT_SYNC_DISMISS_STATE", new HashMap());
        this.uploadTimestampCache = new Persister<>("CONTACT_SYNC_LAST_UPLOAD_TIME", 0L);
        this.dismissState = new HashMap<>();
    }

    private final StoreNotices.Notice createContactSyncNotice() {
        return new StoreNotices.Notice("CONTACT_SYNC_UPSELL", null, 1336L, 0, true, null, 0L, false, 0L, AnonymousClass1.INSTANCE, 482, null);
    }

    public final void backgroundUploadContacts() {
        ContactsFetcher contactsFetcher = this.contactsFetcher;
        if (contactsFetcher == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("contactsFetcher");
        }
        Set<String> setFetchContacts = contactsFetcher.fetchContacts();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(setFetchContacts, 10));
        for (String str : setFetchContacts) {
            arrayList.add(new RestAPIParams.ContactEntry(str, str, MapsJVM.mapOf(new Tuples2("number", str))));
        }
        RestCallState5.logNetworkAction(this.restAPI.uploadContacts(new RestAPIParams.UploadContacts(arrayList, true, AllowedInSuggestionsType.ANYONE_WITH_CONTACT_INFO)), AnonymousClass1.INSTANCE);
        setContactSyncUploadTimestamp(this.clock.currentTimeMillis());
    }

    public final void clearDismissStates() {
        this.dismissStateCache.clear(true);
        getPrefsSessionDurable().edit().remove("CONTACT_SYNC_DISMISS_UPSELL").apply();
        this.dispatcher.schedule(new AnonymousClass1());
    }

    public final void dismissFriendsListUpsell() {
        this.dismissStateCache.set(this.dismissState, true);
        this.dispatcher.schedule(new AnonymousClass1());
    }

    public final void dismissUpsell() {
        getPrefsSessionDurable().edit().putBoolean("CONTACT_SYNC_DISMISS_UPSELL", true).apply();
        this.dispatcher.schedule(new AnonymousClass1());
    }

    public final boolean getFriendsListUpsellDismissed() {
        return Intrinsics3.areEqual(this.dismissState.get("CONTACT_SYNC_DISMISS_FRIENDS_UPSELL"), Boolean.TRUE);
    }

    @Store3
    public final void handleConnectionOpen() {
        this.dispatcher.schedule(new AnonymousClass1());
    }

    @Store3
    public final void handlePostConnectionOpen() {
        ConnectedAccount connectedAccountPrevious;
        MeUser meSnapshot = this.usersStore.getMeSnapshot();
        StoreUserConnections.State stateSnapshot = this.connectionsStore.getStateSnapshot();
        ListIterator<ConnectedAccount> listIterator = stateSnapshot.listIterator(stateSnapshot.size());
        do {
            if (!listIterator.hasPrevious()) {
                connectedAccountPrevious = null;
                break;
            }
            connectedAccountPrevious = listIterator.previous();
        } while (!Intrinsics3.areEqual(connectedAccountPrevious.getType(), "contacts"));
        ConnectedAccount connectedAccount = connectedAccountPrevious;
        Boolean bool = this.dismissState.get("CONTACT_SYNC_DISMISS_UPSELL");
        Boolean contactSyncUpsellShown = this.userSettingsStore.getContactSyncUpsellShown();
        boolean z2 = false;
        Experiment userExperiment = this.experimentsStore.getUserExperiment("2021-04_contact_sync_android_main", connectedAccount == null);
        if (userExperiment != null && userExperiment.getBucket() == 1 && connectedAccount == null) {
            UserUtils userUtils = UserUtils.INSTANCE;
            if (userUtils.getHasPhone(meSnapshot)) {
                Boolean bool2 = Boolean.TRUE;
                if ((!Intrinsics3.areEqual(bool, bool2)) && (!Intrinsics3.areEqual(contactSyncUpsellShown, bool2)) && userUtils.getAgeMs(meSnapshot, ClockFactory.get()) > 604800000) {
                    z2 = true;
                }
            }
        }
        Boolean bool3 = Boolean.TRUE;
        if (Intrinsics3.areEqual(bool, bool3) && (!Intrinsics3.areEqual(contactSyncUpsellShown, bool3))) {
            this.userSettingsStore.updateContactSyncShown();
        }
        if (z2) {
            this.noticesStore.requestToShow(createContactSyncNotice());
        }
        if (this.shouldTryUploadContacts) {
            backgroundUploadContacts();
        }
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        this.contactsFetcher = new ContactsFetcher(context);
        this.dismissState.putAll(this.dismissStateCache.get());
        if (Intrinsics3.areEqual(this.dismissState.get("CONTACT_SYNC_DISMISS_UPSELL"), Boolean.TRUE)) {
            getPrefsSessionDurable().edit().putBoolean("CONTACT_SYNC_DISMISS_UPSELL", true).apply();
        }
        this.dismissState.put("CONTACT_SYNC_DISMISS_UPSELL", Boolean.valueOf(getPrefsSessionDurable().getBoolean("CONTACT_SYNC_DISMISS_UPSELL", false)));
        this.shouldTryUploadContacts = this.clock.currentTimeMillis() - this.uploadTimestampCache.get().longValue() > 86400000;
        markChanged();
    }

    public final void setContactSyncUploadTimestamp(long timestamp) {
        this.uploadTimestampCache.set(Long.valueOf(timestamp), true);
        this.dispatcher.schedule(new AnonymousClass1(timestamp));
    }
}
