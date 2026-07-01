package com.discord.stores;

import android.content.Context;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.api.friendsuggestions.AllowedInSuggestionsType;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams$ContactEntry;
import com.discord.restapi.RestAPIParams$UploadContacts;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.contacts.ContactsFetcher;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.user.UserUtils;
import d0.t.g0;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;

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

    public StoreContactSync(Dispatcher dispatcher, RestAPI restAPI, Clock clock, StoreUserConnections storeUserConnections, StoreUser storeUser, StoreExperiments storeExperiments, StoreNotices storeNotices, StoreUserSettings storeUserSettings) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(restAPI, "restAPI");
        m.checkNotNullParameter(clock, "clock");
        m.checkNotNullParameter(storeUserConnections, "connectionsStore");
        m.checkNotNullParameter(storeUser, "usersStore");
        m.checkNotNullParameter(storeExperiments, "experimentsStore");
        m.checkNotNullParameter(storeNotices, "noticesStore");
        m.checkNotNullParameter(storeUserSettings, "userSettingsStore");
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

    public static final /* synthetic */ Clock access$getClock$p(StoreContactSync storeContactSync) {
        return storeContactSync.clock;
    }

    public static final /* synthetic */ HashMap access$getDismissState$p(StoreContactSync storeContactSync) {
        return storeContactSync.dismissState;
    }

    public static final /* synthetic */ boolean access$getShouldTryUploadContacts$p(StoreContactSync storeContactSync) {
        return storeContactSync.shouldTryUploadContacts;
    }

    public static final /* synthetic */ void access$setShouldTryUploadContacts$p(StoreContactSync storeContactSync, boolean z2) {
        storeContactSync.shouldTryUploadContacts = z2;
    }

    private final StoreNotices$Notice createContactSyncNotice() {
        return new StoreNotices$Notice("CONTACT_SYNC_UPSELL", null, 1336L, 0, true, null, 0L, false, 0L, StoreContactSync$createContactSyncNotice$1.INSTANCE, 482, null);
    }

    public final void backgroundUploadContacts() {
        ContactsFetcher contactsFetcher = this.contactsFetcher;
        if (contactsFetcher == null) {
            m.throwUninitializedPropertyAccessException("contactsFetcher");
        }
        Set<String> setFetchContacts = contactsFetcher.fetchContacts();
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(setFetchContacts, 10));
        for (String str : setFetchContacts) {
            arrayList.add(new RestAPIParams$ContactEntry(str, str, g0.mapOf(new Pair("number", str))));
        }
        RestCallStateKt.logNetworkAction(this.restAPI.uploadContacts(new RestAPIParams$UploadContacts(arrayList, true, AllowedInSuggestionsType.ANYONE_WITH_CONTACT_INFO)), StoreContactSync$backgroundUploadContacts$1.INSTANCE);
        setContactSyncUploadTimestamp(this.clock.currentTimeMillis());
    }

    public final void clearDismissStates() {
        this.dismissStateCache.clear(true);
        getPrefsSessionDurable().edit().remove("CONTACT_SYNC_DISMISS_UPSELL").apply();
        this.dispatcher.schedule(new StoreContactSync$clearDismissStates$1(this));
    }

    public final void dismissFriendsListUpsell() {
        this.dismissStateCache.set(this.dismissState, true);
        this.dispatcher.schedule(new StoreContactSync$dismissFriendsListUpsell$1(this));
    }

    public final void dismissUpsell() {
        getPrefsSessionDurable().edit().putBoolean("CONTACT_SYNC_DISMISS_UPSELL", true).apply();
        this.dispatcher.schedule(new StoreContactSync$dismissUpsell$1(this));
    }

    public final boolean getFriendsListUpsellDismissed() {
        return m.areEqual(this.dismissState.get("CONTACT_SYNC_DISMISS_FRIENDS_UPSELL"), Boolean.TRUE);
    }

    @StoreThread
    public final void handleConnectionOpen() {
        this.dispatcher.schedule(new StoreContactSync$handleConnectionOpen$1(this));
    }

    @StoreThread
    public final void handlePostConnectionOpen() {
        ConnectedAccount connectedAccountPrevious;
        MeUser meSnapshot = this.usersStore.getMeSnapshot();
        StoreUserConnections$State stateSnapshot = this.connectionsStore.getStateSnapshot();
        ListIterator<ConnectedAccount> listIterator = stateSnapshot.listIterator(stateSnapshot.size());
        do {
            if (!listIterator.hasPrevious()) {
                connectedAccountPrevious = null;
                break;
            }
            connectedAccountPrevious = listIterator.previous();
        } while (!m.areEqual(connectedAccountPrevious.getType(), "contacts"));
        ConnectedAccount connectedAccount = connectedAccountPrevious;
        Boolean bool = this.dismissState.get("CONTACT_SYNC_DISMISS_UPSELL");
        Boolean contactSyncUpsellShown = this.userSettingsStore.getContactSyncUpsellShown();
        boolean z2 = false;
        Experiment userExperiment = this.experimentsStore.getUserExperiment("2021-04_contact_sync_android_main", connectedAccount == null);
        if (userExperiment != null && userExperiment.getBucket() == 1 && connectedAccount == null) {
            UserUtils userUtils = UserUtils.INSTANCE;
            if (userUtils.getHasPhone(meSnapshot)) {
                Boolean bool2 = Boolean.TRUE;
                if ((!m.areEqual(bool, bool2)) && (!m.areEqual(contactSyncUpsellShown, bool2)) && userUtils.getAgeMs(meSnapshot, ClockFactory.get()) > 604800000) {
                    z2 = true;
                }
            }
        }
        Boolean bool3 = Boolean.TRUE;
        if (m.areEqual(bool, bool3) && (!m.areEqual(contactSyncUpsellShown, bool3))) {
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
        m.checkNotNullParameter(context, "context");
        super.init(context);
        this.contactsFetcher = new ContactsFetcher(context);
        this.dismissState.putAll(this.dismissStateCache.get());
        if (m.areEqual(this.dismissState.get("CONTACT_SYNC_DISMISS_UPSELL"), Boolean.TRUE)) {
            getPrefsSessionDurable().edit().putBoolean("CONTACT_SYNC_DISMISS_UPSELL", true).apply();
        }
        this.dismissState.put("CONTACT_SYNC_DISMISS_UPSELL", Boolean.valueOf(getPrefsSessionDurable().getBoolean("CONTACT_SYNC_DISMISS_UPSELL", false)));
        this.shouldTryUploadContacts = this.clock.currentTimeMillis() - this.uploadTimestampCache.get().longValue() > 86400000;
        markChanged();
    }

    public final void setContactSyncUploadTimestamp(long timestamp) {
        this.uploadTimestampCache.set(Long.valueOf(timestamp), true);
        this.dispatcher.schedule(new StoreContactSync$setContactSyncUploadTimestamp$1(this, timestamp));
    }
}
