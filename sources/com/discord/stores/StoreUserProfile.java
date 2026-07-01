package com.discord.stores;

import com.discord.api.user.User;
import com.discord.api.user.UserProfile;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.rest.RestAPI;
import d0.t.h0;
import d0.z.d.m;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import rx.Observable;

/* JADX INFO: compiled from: StoreUserProfile.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserProfile extends StoreV2 {
    public static final StoreUserProfile$Companion Companion = new StoreUserProfile$Companion(null);
    private static final UserProfile EMPTY_PROFILE = new UserProfile(null, null, null, null, null, null, null, Opcodes.LAND);
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final HashMap<Long, UserProfile> profiles;
    private final HashSet<Long> profilesLoading;
    private Map<Long, UserProfile> profilesSnapshot;
    private final RestAPI restAPI;
    private final StoreStream storeStream;

    public /* synthetic */ StoreUserProfile(Dispatcher dispatcher, ObservationDeck observationDeck, StoreStream storeStream, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeckProvider.get() : observationDeck, storeStream, (i & 8) != 0 ? RestAPI.Companion.getApi() : restAPI);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreUserProfile storeUserProfile) {
        return storeUserProfile.dispatcher;
    }

    public static final /* synthetic */ UserProfile access$getEMPTY_PROFILE$cp() {
        return EMPTY_PROFILE;
    }

    public static final /* synthetic */ HashSet access$getProfilesLoading$p(StoreUserProfile storeUserProfile) {
        return storeUserProfile.profilesLoading;
    }

    public static final /* synthetic */ RestAPI access$getRestAPI$p(StoreUserProfile storeUserProfile) {
        return storeUserProfile.restAPI;
    }

    public static final /* synthetic */ StoreStream access$getStoreStream$p(StoreUserProfile storeUserProfile) {
        return storeUserProfile.storeStream;
    }

    public static final /* synthetic */ void access$handleFailure(StoreUserProfile storeUserProfile, long j) {
        storeUserProfile.handleFailure(j);
    }

    public static final /* synthetic */ void access$handleUser(StoreUserProfile storeUserProfile, User user) {
        storeUserProfile.handleUser(user);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void fetchProfile$default(StoreUserProfile storeUserProfile, long j, Long l, boolean z2, Function1 function1, int i, Object obj) {
        storeUserProfile.fetchProfile(j, (i & 2) != 0 ? null : l, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? null : function1);
    }

    @StoreThread
    private final void handleFailure(long userId) {
        this.profilesLoading.remove(Long.valueOf(userId));
    }

    @StoreThread
    private final void handleUser(User user) {
        UserProfile userProfile = this.profiles.get(Long.valueOf(user.getId()));
        if (userProfile != null) {
            m.checkNotNullExpressionValue(userProfile, "profiles[user.id] ?: return");
            this.profiles.put(Long.valueOf(user.getId()), new UserProfile(userProfile.b(), userProfile.d(), user, userProfile.getPremiumSince(), userProfile.getPremiumGuildSince(), null, userProfile.getApplication()));
            markChanged();
        }
    }

    public final void fetchProfile(long userId, Long guildId, boolean withMutualGuilds, Function1<? super UserProfile, Unit> onFetchSuccess) {
        this.dispatcher.schedule(new StoreUserProfile$fetchProfile$1(this, userId, guildId, withMutualGuilds, onFetchSuccess));
    }

    public final UserProfile getUserProfile(long userId) {
        UserProfile userProfile = this.profilesSnapshot.get(Long.valueOf(userId));
        return userProfile != null ? userProfile : EMPTY_PROFILE;
    }

    @StoreThread
    public final void handleUserProfile(UserProfile userProfile) {
        m.checkNotNullParameter(userProfile, "userProfile");
        long id2 = userProfile.getUser().getId();
        this.profilesLoading.remove(Long.valueOf(id2));
        this.profiles.put(Long.valueOf(id2), userProfile);
        markChanged();
    }

    public final Observable<UserProfile> observeUserProfile(long userId) {
        Observable<UserProfile> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreUserProfile$observeUserProfile$1(this, userId), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        this.profilesSnapshot = new HashMap(this.profiles);
    }

    public final void updateUser(User user) {
        m.checkNotNullParameter(user, "user");
        this.dispatcher.schedule(new StoreUserProfile$updateUser$1(this, user));
    }

    public StoreUserProfile(Dispatcher dispatcher, ObservationDeck observationDeck, StoreStream storeStream, RestAPI restAPI) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(storeStream, "storeStream");
        m.checkNotNullParameter(restAPI, "restAPI");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.storeStream = storeStream;
        this.restAPI = restAPI;
        this.profilesLoading = new HashSet<>();
        this.profiles = new HashMap<>();
        this.profilesSnapshot = h0.emptyMap();
    }
}
