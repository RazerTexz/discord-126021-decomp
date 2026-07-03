package com.discord.stores;

import android.content.SharedPreferences;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserSurveyFetch;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.api.guild.GuildFeature;
import com.discord.api.user.SurveyGuildRequirements;
import com.discord.api.user.UserSurvey;
import com.discord.api.user.UserSurveyFetchResponse;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.time.Clock;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

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

    /* JADX INFO: renamed from: com.discord.stores.StoreUserSurvey$fetchUserSurvey$1 */
    /* JADX INFO: compiled from: StoreUserSurvey.kt */
    public static final class C66071 extends AbstractC12240o implements Function1<UserSurveyFetchResponse, TrackNetworkMetadataReceiver> {
        public static final C66071 INSTANCE = new C66071();

        public C66071() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final TrackNetworkMetadataReceiver invoke(UserSurveyFetchResponse userSurveyFetchResponse) {
            UserSurvey survey;
            return new TrackNetworkActionUserSurveyFetch((userSurveyFetchResponse == null || (survey = userSurveyFetchResponse.getSurvey()) == null) ? null : survey.getKey());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUserSurvey$fetchUserSurvey$2 */
    /* JADX INFO: compiled from: StoreUserSurvey.kt */
    public static final class C66082 extends AbstractC12240o implements Function1<UserSurveyFetchResponse, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreUserSurvey$fetchUserSurvey$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreUserSurvey.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ UserSurveyFetchResponse $res;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(UserSurveyFetchResponse userSurveyFetchResponse) {
                super(0);
                this.$res = userSurveyFetchResponse;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreUserSurvey.this.handleUserSurveyFetchSuccess(this.$res);
            }
        }

        public C66082() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(UserSurveyFetchResponse userSurveyFetchResponse) {
            invoke2(userSurveyFetchResponse);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(UserSurveyFetchResponse userSurveyFetchResponse) {
            C12238m.checkNotNullParameter(userSurveyFetchResponse, "res");
            StoreUserSurvey.this.dispatcher.schedule(new AnonymousClass1(userSurveyFetchResponse));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUserSurvey$observeUserSurvey$1 */
    /* JADX INFO: compiled from: StoreUserSurvey.kt */
    public static final class C66091 extends AbstractC12240o implements Function0<UserSurvey> {
        public C66091() {
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

    @StoreThread
    private final void fetchUserSurvey() {
        setLastFetched();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestCallStateKt.logNetworkAction(this.restApi.getUserSurvey(), C66071.INSTANCE), false, 1, null), (Class<?>) StoreUserSurvey.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C66082());
    }

    private final UserSurvey getUserSurvey() {
        return this.userSurvey;
    }

    @StoreThread
    private final void handleUserSurveyFetchSuccess(UserSurveyFetchResponse res) {
        UserSurvey survey;
        if (res == null || (survey = res.getSurvey()) == null || !meetsGuildRequirements(survey)) {
            return;
        }
        this.userSurvey = survey;
        markChanged();
    }

    private final boolean meetsGuildRequirements(UserSurvey survey) {
        boolean z2;
        List<String> listM8316c = survey.m8316c();
        if (listM8316c.isEmpty()) {
            return true;
        }
        Iterator<String> it = listM8316c.iterator();
        while (it.hasNext()) {
            if (!StoreUserSurveyKt.getIMPLEMENTED_GUILD_REQUIREMENTS().contains(it.next())) {
                return false;
            }
        }
        MeUser meSnapshot = this.storeUser.getMeSnapshot();
        for (Map.Entry<Long, Guild> entry : this.storeGuilds.getGuilds().entrySet()) {
            long jLongValue = entry.getKey().longValue();
            Guild value = entry.getValue();
            if (!listM8316c.contains(SurveyGuildRequirements.IS_COMMUNITY.getValue()) || value.getFeatures().contains(GuildFeature.COMMUNITY)) {
                if (!listM8316c.contains(SurveyGuildRequirements.IS_HUB.getValue()) || value.getFeatures().contains(GuildFeature.HUB)) {
                    if (listM8316c.contains(SurveyGuildRequirements.GUILD_SIZE.getValue())) {
                        Integer num = survey.m8317d().get(0);
                        Integer num2 = survey.m8317d().get(1);
                        int memberCount = value.getMemberCount();
                        if (num == null || memberCount >= num.intValue()) {
                            if (num2 == null || memberCount <= num2.intValue()) {
                            }
                        }
                    }
                    Map<Long, Long> guildPermissions = this.storePermissions.getGuildPermissions();
                    if (listM8316c.contains(SurveyGuildRequirements.GUILD_PERMISSIONS.getValue())) {
                        List<Long> listM8315b = survey.m8315b();
                        if (listM8315b.isEmpty()) {
                            continue;
                        } else {
                            Iterator<Long> it2 = listM8315b.iterator();
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
                    if (!listM8316c.contains(SurveyGuildRequirements.IS_OWNER.getValue()) || zIsOwner) {
                        if (!listM8316c.contains(SurveyGuildRequirements.IS_ADMIN.getValue()) || zCan) {
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

    @StoreThread
    public final void handleConnectionOpen() {
        if (this.clock.currentTimeMillis() - this.sharedPreferences.getLong("CACHE_KEY_USER_SURVEY_LAST_FETCHED", 0L) > this.refetchIntervalMs) {
            fetchUserSurvey();
        }
    }

    public final Observable<UserSurvey> observeUserSurvey() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C66091(), 14, null);
    }

    public StoreUserSurvey(Dispatcher dispatcher, StoreUser storeUser, StoreGuilds storeGuilds, StorePermissions storePermissions, ObservationDeck observationDeck, RestAPI restAPI, Clock clock, SharedPreferences sharedPreferences) {
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(storeUser, "storeUser");
        C12238m.checkNotNullParameter(storeGuilds, "storeGuilds");
        C12238m.checkNotNullParameter(storePermissions, "storePermissions");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        C12238m.checkNotNullParameter(restAPI, "restApi");
        C12238m.checkNotNullParameter(clock, "clock");
        C12238m.checkNotNullParameter(sharedPreferences, "sharedPreferences");
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
