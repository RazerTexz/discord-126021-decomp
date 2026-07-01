package com.discord.stores;

import android.content.SharedPreferences;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserSurveyFetch;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.api.guild.GuildFeature;
import com.discord.api.user.UserSurvey;
import com.discord.api.user.UserSurvey2;
import com.discord.api.user.UserSurvey3;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.error.Error;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: StoreUserSurvey.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserSurvey extends StoreV2 {
    private final Clock clock;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private int refetchIntervalMs;
    private final RestAPI restApi;
    private final SharedPreferences sharedPreferences;
    private final StoreGuilds storeGuilds;
    private final StorePermissions storePermissions;
    private final StoreUser storeUser;
    private UserSurvey userSurvey;

    /* JADX INFO: renamed from: com.discord.stores.StoreUserSurvey$fetchUserSurvey$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreUserSurvey.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<UserSurvey3, TrackNetworkMetadata2> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final TrackNetworkMetadata2 invoke(UserSurvey3 userSurvey3) {
            UserSurvey survey;
            return new TrackNetworkActionUserSurveyFetch((userSurvey3 == null || (survey = userSurvey3.getSurvey()) == null) ? null : survey.getKey());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUserSurvey$fetchUserSurvey$2, reason: invalid class name */
    /* JADX INFO: compiled from: StoreUserSurvey.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<UserSurvey3, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreUserSurvey$fetchUserSurvey$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreUserSurvey.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ UserSurvey3 $res;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(UserSurvey3 userSurvey3) {
                super(0);
                this.$res = userSurvey3;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreUserSurvey.this.handleUserSurveyFetchSuccess(this.$res);
            }
        }

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(UserSurvey3 userSurvey3) {
            invoke2(userSurvey3);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(UserSurvey3 userSurvey3) {
            Intrinsics3.checkNotNullParameter(userSurvey3, "res");
            StoreUserSurvey.this.dispatcher.schedule(new AnonymousClass1(userSurvey3));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUserSurvey$observeUserSurvey$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreUserSurvey.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<UserSurvey> {
        public AnonymousClass1() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final UserSurvey invoke() {
            return StoreUserSurvey.this.getUserSurvey();
        }
    }

    public /* synthetic */ StoreUserSurvey(Dispatcher dispatcher, StoreUser storeUser, StoreGuilds storeGuilds, StorePermissions storePermissions, ObservationDeck observationDeck, RestAPI restAPI, Clock clock, SharedPreferences sharedPreferences, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, storeUser, storeGuilds, storePermissions, observationDeck, (i & 32) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, clock, sharedPreferences);
    }

    @Store3
    private final void fetchUserSurvey() {
        setLastFetched();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestCallState5.logNetworkAction(this.restApi.getUserSurvey(), AnonymousClass1.INSTANCE), false, 1, null), (Class<?>) StoreUserSurvey.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }

    private final UserSurvey getUserSurvey() {
        return this.userSurvey;
    }

    @Store3
    private final void handleUserSurveyFetchSuccess(UserSurvey3 res) {
        UserSurvey survey;
        if (res == null || (survey = res.getSurvey()) == null || !meetsGuildRequirements(survey)) {
            return;
        }
        this.userSurvey = survey;
        markChanged();
    }

    private final boolean meetsGuildRequirements(UserSurvey survey) {
        boolean z2;
        List<String> listC = survey.c();
        if (listC.isEmpty()) {
            return true;
        }
        Iterator<String> it = listC.iterator();
        while (it.hasNext()) {
            if (!StoreUserSurvey2.getIMPLEMENTED_GUILD_REQUIREMENTS().contains(it.next())) {
                return false;
            }
        }
        MeUser meSnapshot = this.storeUser.getMeSnapshot();
        for (Map.Entry<Long, Guild> entry : this.storeGuilds.getGuilds().entrySet()) {
            long jLongValue = entry.getKey().longValue();
            Guild value = entry.getValue();
            if (!listC.contains(UserSurvey2.IS_COMMUNITY.getValue()) || value.getFeatures().contains(GuildFeature.COMMUNITY)) {
                if (!listC.contains(UserSurvey2.IS_HUB.getValue()) || value.getFeatures().contains(GuildFeature.HUB)) {
                    if (listC.contains(UserSurvey2.GUILD_SIZE.getValue())) {
                        Integer num = survey.d().get(0);
                        Integer num2 = survey.d().get(1);
                        int memberCount = value.getMemberCount();
                        if (num == null || memberCount >= num.intValue()) {
                            if (num2 == null || memberCount <= num2.intValue()) {
                            }
                        }
                    }
                    Map<Long, Long> guildPermissions = this.storePermissions.getGuildPermissions();
                    if (listC.contains(UserSurvey2.GUILD_PERMISSIONS.getValue())) {
                        List<Long> listB = survey.b();
                        if (listB.isEmpty()) {
                            continue;
                        } else {
                            Iterator<Long> it2 = listB.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    z2 = false;
                                    break;
                                }
                                if (PermissionUtils.can(it2.next().longValue(), guildPermissions.get(Long.valueOf(jLongValue)))) {
                                    z2 = true;
                                    break;
                                }
                            }
                            if (!z2) {
                                continue;
                            }
                        }
                    }
                    boolean zIsOwner = value.isOwner(meSnapshot.getId());
                    boolean zCan = PermissionUtils.can(8L, guildPermissions.get(Long.valueOf(jLongValue)));
                    if (!listC.contains(UserSurvey2.IS_OWNER.getValue()) || zIsOwner) {
                        if (!listC.contains(UserSurvey2.IS_ADMIN.getValue()) || zCan) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private final void setLastFetched() {
        this.sharedPreferences.edit().putLong("CACHE_KEY_USER_SURVEY_LAST_FETCHED", this.clock.currentTimeMillis()).apply();
    }

    @Store3
    public final void handleConnectionOpen() {
        if (this.clock.currentTimeMillis() - this.sharedPreferences.getLong("CACHE_KEY_USER_SURVEY_LAST_FETCHED", 0L) > this.refetchIntervalMs) {
            fetchUserSurvey();
        }
    }

    public final Observable<UserSurvey> observeUserSurvey() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public StoreUserSurvey(Dispatcher dispatcher, StoreUser storeUser, StoreGuilds storeGuilds, StorePermissions storePermissions, ObservationDeck observationDeck, RestAPI restAPI, Clock clock, SharedPreferences sharedPreferences) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(storePermissions, "storePermissions");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(restAPI, "restApi");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        this.dispatcher = dispatcher;
        this.storeUser = storeUser;
        this.storeGuilds = storeGuilds;
        this.storePermissions = storePermissions;
        this.observationDeck = observationDeck;
        this.restApi = restAPI;
        this.clock = clock;
        this.sharedPreferences = sharedPreferences;
        this.refetchIntervalMs = 86400000;
    }
}
