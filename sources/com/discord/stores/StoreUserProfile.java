package com.discord.stores;

import com.discord.api.user.User;
import com.discord.api.user.UserProfile;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: StoreUserProfile.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserProfile extends StoreV2 {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final UserProfile EMPTY_PROFILE = new UserProfile(null, null, null, null, null, null, null, Opcodes.LAND);
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final HashMap<Long, UserProfile> profiles;
    private final HashSet<Long> profilesLoading;
    private Map<Long, UserProfile> profilesSnapshot;
    private final RestAPI restAPI;
    private final StoreStream storeStream;

    /* JADX INFO: compiled from: StoreUserProfile.kt */
    public static final class Companion {
        private Companion() {
        }

        public final UserProfile getEMPTY_PROFILE() {
            return StoreUserProfile.EMPTY_PROFILE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUserProfile$fetchProfile$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreUserProfile.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Long $guildId;
        public final /* synthetic */ Function1 $onFetchSuccess;
        public final /* synthetic */ long $userId;
        public final /* synthetic */ boolean $withMutualGuilds;

        /* JADX INFO: renamed from: com.discord.stores.StoreUserProfile$fetchProfile$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreUserProfile.kt */
        public static final class C01891 extends Lambda implements Function1<UserProfile, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StoreUserProfile$fetchProfile$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: StoreUserProfile.kt */
            public static final class C01901 extends Lambda implements Function0<Unit> {
                public final /* synthetic */ UserProfile $userProfile;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01901(UserProfile userProfile) {
                    super(0);
                    this.$userProfile = userProfile;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    if (this.$userProfile != null) {
                        StoreUserProfile.this.storeStream.handleUserProfile(this.$userProfile, AnonymousClass1.this.$guildId);
                        Function1 function1 = AnonymousClass1.this.$onFetchSuccess;
                        if (function1 != null) {
                        }
                    }
                }
            }

            public C01891() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UserProfile userProfile) {
                invoke2(userProfile);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UserProfile userProfile) {
                StoreUserProfile.this.dispatcher.schedule(new C01901(userProfile));
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreUserProfile$fetchProfile$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: StoreUserProfile.kt */
        public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StoreUserProfile$fetchProfile$1$2$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: StoreUserProfile.kt */
            public static final class C01911 extends Lambda implements Function0<Unit> {
                public C01911() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    StoreUserProfile.this.handleFailure(anonymousClass1.$userId);
                }
            }

            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                Intrinsics3.checkNotNullParameter(error, "it");
                StoreUserProfile.this.dispatcher.schedule(new C01911());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, Long l, boolean z2, Function1 function1) {
            super(0);
            this.$userId = j;
            this.$guildId = l;
            this.$withMutualGuilds = z2;
            this.$onFetchSuccess = function1;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StoreUserProfile.this.profilesLoading.contains(Long.valueOf(this.$userId))) {
                return;
            }
            StoreUserProfile.this.profilesLoading.add(Long.valueOf(this.$userId));
            Observable observableR = ObservableExtensionsKt.restSubscribeOn$default(StoreUserProfile.this.restAPI.userProfileGet(this.$userId, this.$withMutualGuilds, this.$guildId), false, 1, null).r();
            Intrinsics3.checkNotNullExpressionValue(observableR, "restAPI\n          .userP…  .distinctUntilChanged()");
            ObservableExtensionsKt.appSubscribe(observableR, (Class<?>) StoreUserProfile.this.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new C01891());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUserProfile$observeUserProfile$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreUserProfile.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<UserProfile> {
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$userId = j;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final UserProfile invoke() {
            return StoreUserProfile.this.getUserProfile(this.$userId);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUserProfile$updateUser$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreUserProfile.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ User $user;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(User user) {
            super(0);
            this.$user = user;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreUserProfile.this.handleUser(this.$user);
        }
    }

    public /* synthetic */ StoreUserProfile(Dispatcher dispatcher, ObservationDeck observationDeck, StoreStream storeStream, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeck4.get() : observationDeck, storeStream, (i & 8) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    @Store3
    private final void handleFailure(long userId) {
        this.profilesLoading.remove(Long.valueOf(userId));
    }

    @Store3
    private final void handleUser(User user) {
        UserProfile userProfile = this.profiles.get(Long.valueOf(user.getId()));
        if (userProfile != null) {
            Intrinsics3.checkNotNullExpressionValue(userProfile, "profiles[user.id] ?: return");
            this.profiles.put(Long.valueOf(user.getId()), new UserProfile(userProfile.b(), userProfile.d(), user, userProfile.getPremiumSince(), userProfile.getPremiumGuildSince(), null, userProfile.getApplication()));
            markChanged();
        }
    }

    public final void fetchProfile(long userId, Long guildId, boolean withMutualGuilds, Function1<? super UserProfile, Unit> onFetchSuccess) {
        this.dispatcher.schedule(new AnonymousClass1(userId, guildId, withMutualGuilds, onFetchSuccess));
    }

    public final UserProfile getUserProfile(long userId) {
        UserProfile userProfile = this.profilesSnapshot.get(Long.valueOf(userId));
        return userProfile != null ? userProfile : EMPTY_PROFILE;
    }

    @Store3
    public final void handleUserProfile(UserProfile userProfile) {
        Intrinsics3.checkNotNullParameter(userProfile, "userProfile");
        long id2 = userProfile.getUser().getId();
        this.profilesLoading.remove(Long.valueOf(id2));
        this.profiles.put(Long.valueOf(id2), userProfile);
        markChanged();
    }

    public final Observable<UserProfile> observeUserProfile(long userId) {
        Observable<UserProfile> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(userId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        this.profilesSnapshot = new HashMap(this.profiles);
    }

    public final void updateUser(User user) {
        Intrinsics3.checkNotNullParameter(user, "user");
        this.dispatcher.schedule(new AnonymousClass1(user));
    }

    public StoreUserProfile(Dispatcher dispatcher, ObservationDeck observationDeck, StoreStream storeStream, RestAPI restAPI) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(storeStream, "storeStream");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.storeStream = storeStream;
        this.restAPI = restAPI;
        this.profilesLoading = new HashSet<>();
        this.profiles = new HashMap<>();
        this.profilesSnapshot = Maps6.emptyMap();
    }
}
