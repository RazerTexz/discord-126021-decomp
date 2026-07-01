package com.discord.stores;

import b.d.b.a.outline;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionInviteResolve;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.api.channel.Channel;
import com.discord.api.guild.Guild;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.user.User;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.restapi.RestAPIAbortCodes;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: StoreInstantInvites.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreInstantInvites extends StoreV2 {
    private final Dispatcher dispatcher;
    private final Map<Long, Map<String, ModelInvite>> invites;
    private Map<Long, ? extends Map<String, ? extends ModelInvite>> invitesSnapshot;
    private final Map<String, InviteState> knownInvites;
    private Map<String, ? extends InviteState> knownInvitesSnapshot;
    private final ObservationDeck observationDeck;
    private final RestAPI restAPI;

    /* JADX INFO: compiled from: StoreInstantInvites.kt */
    public static abstract class InviteState {

        /* JADX INFO: compiled from: StoreInstantInvites.kt */
        public static final class Invalid extends InviteState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: StoreInstantInvites.kt */
        public static final class LoadFailed extends InviteState {
            public static final LoadFailed INSTANCE = new LoadFailed();

            private LoadFailed() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: StoreInstantInvites.kt */
        public static final class Loading extends InviteState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: StoreInstantInvites.kt */
        public static final /* data */ class Resolved extends InviteState {
            private final ModelInvite invite;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Resolved(ModelInvite modelInvite) {
                super(null);
                Intrinsics3.checkNotNullParameter(modelInvite, "invite");
                this.invite = modelInvite;
            }

            public static /* synthetic */ Resolved copy$default(Resolved resolved, ModelInvite modelInvite, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelInvite = resolved.invite;
                }
                return resolved.copy(modelInvite);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ModelInvite getInvite() {
                return this.invite;
            }

            public final Resolved copy(ModelInvite invite) {
                Intrinsics3.checkNotNullParameter(invite, "invite");
                return new Resolved(invite);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Resolved) && Intrinsics3.areEqual(this.invite, ((Resolved) other).invite);
                }
                return true;
            }

            public final ModelInvite getInvite() {
                return this.invite;
            }

            public int hashCode() {
                ModelInvite modelInvite = this.invite;
                if (modelInvite != null) {
                    return modelInvite.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Resolved(invite=");
                sbU.append(this.invite);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private InviteState() {
        }

        public /* synthetic */ InviteState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            Error.Type.values();
            int[] iArr = new int[18];
            $EnumSwitchMapping$0 = iArr;
            iArr[Error.Type.DISCORD_REQUEST_ERROR.ordinal()] = 1;
            iArr[Error.Type.NETWORK.ordinal()] = 2;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreInstantInvites$clearInvites$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreInstantInvites.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Map map = (Map) StoreInstantInvites.this.invites.get(Long.valueOf(this.$guildId));
            if (map != null) {
                map.clear();
            }
            StoreInstantInvites.this.markChanged();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreInstantInvites$fetchGuildInvites$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreInstantInvites.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends ModelInvite>, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreInstantInvites$fetchGuildInvites$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreInstantInvites.kt */
        public static final class C01411 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ List $invites;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01411(List list) {
                super(0);
                this.$invites = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreInstantInvites.this.onLoadedInvites(this.$invites);
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelInvite> list) {
            invoke2(list);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends ModelInvite> list) {
            Intrinsics3.checkNotNullParameter(list, "invites");
            StoreInstantInvites.this.dispatcher.schedule(new C01411(list));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreInstantInvites$fetchInviteIfNotLoaded$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreInstantInvites.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Long $eventId;
        public final /* synthetic */ String $inviteCode;
        public final /* synthetic */ String $inviteKey;
        public final /* synthetic */ Boolean $inviteResolved;
        public final /* synthetic */ String $location;
        public final /* synthetic */ Function0 $onError;

        /* JADX INFO: renamed from: com.discord.stores.StoreInstantInvites$fetchInviteIfNotLoaded$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreInstantInvites.kt */
        public static final class C01421 extends Lambda implements Function1<ModelInvite, TrackNetworkMetadata2> {
            public C01421() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final TrackNetworkMetadata2 invoke(ModelInvite modelInvite) {
                User inviter;
                Channel channel;
                Channel channel2;
                Guild guild;
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                return new TrackNetworkActionInviteResolve(anonymousClass1.$inviteResolved, anonymousClass1.$inviteCode, Boolean.valueOf(StoreStream.INSTANCE.getAuthentication().isAuthed()), (modelInvite == null || (guild = modelInvite.guild) == null) ? null : Long.valueOf(guild.getId()), (modelInvite == null || (channel2 = modelInvite.getChannel()) == null) ? null : Long.valueOf(channel2.getId()), (modelInvite == null || (channel = modelInvite.getChannel()) == null) ? null : Long.valueOf(channel.getType()), (modelInvite == null || (inviter = modelInvite.getInviter()) == null) ? null : Long.valueOf(inviter.getId()), modelInvite != null ? Long.valueOf(modelInvite.getApproximateMemberCount()) : null, modelInvite != null ? Long.valueOf(modelInvite.getApproximatePresenceCount()) : null, modelInvite != null ? modelInvite.getInviteType() : null, null, modelInvite != null ? Boolean.valueOf(Intrinsics3.areEqual(modelInvite.code, String.valueOf(RestAPIAbortCodes.USER_BANNED))) : null, null);
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreInstantInvites$fetchInviteIfNotLoaded$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: StoreInstantInvites.kt */
        public static final class AnonymousClass2 extends Lambda implements Function1<ModelInvite, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StoreInstantInvites$fetchInviteIfNotLoaded$1$2$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: StoreInstantInvites.kt */
            public static final class C01431 extends Lambda implements Function0<Unit> {
                public final /* synthetic */ ModelInvite $it;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01431(ModelInvite modelInvite) {
                    super(0);
                    this.$it = modelInvite;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    StoreInstantInvites storeInstantInvites = StoreInstantInvites.this;
                    String str = anonymousClass1.$inviteKey;
                    Intrinsics3.checkNotNullExpressionValue(str, "inviteKey");
                    storeInstantInvites.setChatInvites(str, new InviteState.Resolved(this.$it));
                    GuildScheduledEvent guildScheduledEvent = this.$it.getGuildScheduledEvent();
                    if (guildScheduledEvent != null) {
                        StoreGuildScheduledEvents guildScheduledEvents = StoreStream.INSTANCE.getGuildScheduledEvents();
                        Intrinsics3.checkNotNullExpressionValue(guildScheduledEvent, "event");
                        guildScheduledEvents.addGuildScheduledEventFromInvite(guildScheduledEvent);
                    }
                }
            }

            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ModelInvite modelInvite) {
                invoke2(modelInvite);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ModelInvite modelInvite) {
                Intrinsics3.checkNotNullParameter(modelInvite, "it");
                StoreInstantInvites.this.dispatcher.schedule(new C01431(modelInvite));
                String str = AnonymousClass1.this.$location;
                if (str != null) {
                    AnalyticsTracker.INSTANCE.inviteResolved(modelInvite, str);
                }
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreInstantInvites$fetchInviteIfNotLoaded$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: StoreInstantInvites.kt */
        public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StoreInstantInvites$fetchInviteIfNotLoaded$1$3$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: StoreInstantInvites.kt */
            public static final class C01441 extends Lambda implements Function0<Unit> {
                public C01441() {
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
                    StoreInstantInvites storeInstantInvites = StoreInstantInvites.this;
                    String str = anonymousClass1.$inviteKey;
                    Intrinsics3.checkNotNullExpressionValue(str, "inviteKey");
                    storeInstantInvites.setChatInvites(str, InviteState.Invalid.INSTANCE);
                }
            }

            /* JADX INFO: renamed from: com.discord.stores.StoreInstantInvites$fetchInviteIfNotLoaded$1$3$2, reason: invalid class name */
            /* JADX INFO: compiled from: StoreInstantInvites.kt */
            public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
                public AnonymousClass2() {
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
                    StoreInstantInvites storeInstantInvites = StoreInstantInvites.this;
                    String str = anonymousClass1.$inviteKey;
                    Intrinsics3.checkNotNullExpressionValue(str, "inviteKey");
                    storeInstantInvites.setChatInvites(str, InviteState.LoadFailed.INSTANCE);
                }
            }

            public AnonymousClass3() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                Intrinsics3.checkNotNullParameter(error, "error");
                Function0 function0 = AnonymousClass1.this.$onError;
                if (function0 != null) {
                }
                int iOrdinal = error.getType().ordinal();
                if (iOrdinal != 3) {
                    if (iOrdinal != 11) {
                        return;
                    }
                    StoreInstantInvites.this.dispatcher.schedule(new AnonymousClass2());
                    return;
                }
                error.setShowErrorToasts(false);
                StoreInstantInvites.this.dispatcher.schedule(new C01441());
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                String str = anonymousClass1.$location;
                if (str != null) {
                    String str2 = anonymousClass1.$inviteCode;
                    Error.Response response = error.getResponse();
                    Intrinsics3.checkNotNullExpressionValue(response, "error.response");
                    String message = response.getMessage();
                    Error.Response response2 = error.getResponse();
                    Intrinsics3.checkNotNullExpressionValue(response2, "error.response");
                    AnalyticsTracker.inviteResolveFailed(str2, str, message, Integer.valueOf(response2.getCode()));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, String str2, Long l, Boolean bool, String str3, Function0 function0) {
            super(0);
            this.$inviteKey = str;
            this.$inviteCode = str2;
            this.$eventId = l;
            this.$inviteResolved = bool;
            this.$location = str3;
            this.$onError = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (!StoreInstantInvites.this.knownInvites.containsKey(this.$inviteKey) || (StoreInstantInvites.this.knownInvites.get(this.$inviteKey) instanceof InviteState.LoadFailed)) {
                AnalyticsTracker.inviteOpened(this.$inviteCode);
                StoreInstantInvites storeInstantInvites = StoreInstantInvites.this;
                String str = this.$inviteKey;
                Intrinsics3.checkNotNullExpressionValue(str, "inviteKey");
                storeInstantInvites.setChatInvites(str, InviteState.Loading.INSTANCE);
                ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestCallState5.logNetworkAction(StoreInstantInvites.this.restAPI.getInviteCode(this.$inviteCode, true, this.$eventId), new C01421()), false, 1, null), (Class<?>) StoreInstantInvites.this.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass3()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreInstantInvites$observeInvite$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreInstantInvites.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<String, ? extends InviteState>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<String, ? extends InviteState> invoke() {
            return StoreInstantInvites.this.getKnownInvites();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreInstantInvites$observeKnownInvites$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreInstantInvites.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<String, ? extends InviteState>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<String, ? extends InviteState> invoke() {
            return StoreInstantInvites.this.getKnownInvites();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreInstantInvites$onInviteRemoved$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreInstantInvites.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ModelInvite $invite;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ModelInvite modelInvite) {
            super(0);
            this.$invite = modelInvite;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Map map;
            Guild guild = this.$invite.guild;
            Long lValueOf = guild != null ? Long.valueOf(guild.getId()) : null;
            String str = this.$invite.code;
            if (lValueOf == null || (map = (Map) StoreInstantInvites.this.invites.get(lValueOf)) == null || ((ModelInvite) map.remove(str)) == null) {
                return;
            }
            StoreInstantInvites.this.markChanged();
        }
    }

    public /* synthetic */ StoreInstantInvites(Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeck4.get() : observationDeck, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    private final Map<Long, Map<String, ModelInvite>> getInvites() {
        return this.invitesSnapshot;
    }

    private final Map<String, InviteState> getKnownInvites() {
        return this.knownInvitesSnapshot;
    }

    @Store3
    private final void onLoadedInvites(List<? extends ModelInvite> updatedInvites) {
        this.invites.clear();
        for (ModelInvite modelInvite : updatedInvites) {
            Guild guild = modelInvite.guild;
            Long lValueOf = guild != null ? Long.valueOf(guild.getId()) : null;
            if (lValueOf != null) {
                Map<String, ModelInvite> linkedHashMap = this.invites.get(lValueOf);
                if (linkedHashMap == null) {
                    linkedHashMap = new LinkedHashMap<>();
                }
                String str = modelInvite.code;
                Intrinsics3.checkNotNullExpressionValue(str, "invite.code");
                linkedHashMap.put(str, modelInvite);
                this.invites.put(lValueOf, linkedHashMap);
            }
        }
        markChanged();
    }

    @Store3
    private final void setChatInvites(String inviteKey, InviteState inviteState) {
        this.knownInvites.put(inviteKey, inviteState);
        markChanged();
    }

    public final void clearInvites(long guildId) {
        this.dispatcher.schedule(new AnonymousClass1(guildId));
    }

    public final void fetchGuildInvites(long guildId) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.getGuildInvites(guildId), false, 1, null), (Class<?>) StoreInstantInvites.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    public final void fetchInviteIfNotLoaded(String inviteCode, Long eventId, String location, Boolean inviteResolved, Function0<Unit> onError) {
        Intrinsics3.checkNotNullParameter(inviteCode, "inviteCode");
        this.dispatcher.schedule(new AnonymousClass1(ModelInvite.getInviteStoreKey(inviteCode, eventId), inviteCode, eventId, inviteResolved, location, onError));
    }

    public final Observable<InviteState> observeInvite(final String inviteKey) {
        if (inviteKey == null) {
            ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(InviteState.LoadFailed.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(InviteState.LoadFailed)");
            return scalarSynchronousObservable;
        }
        Observable<InviteState> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).G(new Func1<Map<String, ? extends InviteState>, InviteState>() { // from class: com.discord.stores.StoreInstantInvites.observeInvite.2
            @Override // j0.k.Func1
            public final InviteState call(Map<String, ? extends InviteState> map) {
                InviteState inviteState = map.get(inviteKey);
                return inviteState != null ? inviteState : InviteState.Loading.INSTANCE;
            }
        }).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<String, InviteState>> observeKnownInvites() {
        Observable<Map<String, InviteState>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final void onInviteRemoved(ModelInvite invite) {
        Intrinsics3.checkNotNullParameter(invite, "invite");
        this.dispatcher.schedule(new AnonymousClass1(invite));
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Long, Map<String, ModelInvite>> entry : this.invites.entrySet()) {
            linkedHashMap.put(Long.valueOf(entry.getKey().longValue()), new HashMap(entry.getValue()));
        }
        this.invitesSnapshot = linkedHashMap;
        this.knownInvitesSnapshot = new HashMap(this.knownInvites);
    }

    public final Map<String, ModelInvite> getInvites(long guildId) {
        Map<String, ModelInvite> map = getInvites().get(Long.valueOf(guildId));
        return map != null ? map : Maps6.emptyMap();
    }

    public StoreInstantInvites(Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.restAPI = restAPI;
        this.invites = new LinkedHashMap();
        this.invitesSnapshot = Maps6.emptyMap();
        this.knownInvites = new LinkedHashMap();
        this.knownInvitesSnapshot = Maps6.emptyMap();
    }
}
