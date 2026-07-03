package com.discord.stores;

import com.discord.analytics.generated.events.network_action.TrackNetworkActionInviteResolve;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.api.channel.Channel;
import com.discord.api.guild.Guild;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.user.User;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.restapi.RestAPIAbortCodes;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12136h0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;

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
                C12238m.checkNotNullParameter(modelInvite, "invite");
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
                C12238m.checkNotNullParameter(invite, "invite");
                return new Resolved(invite);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Resolved) && C12238m.areEqual(this.invite, ((Resolved) other).invite);
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
                StringBuilder sbM833U = C1643a.m833U("Resolved(invite=");
                sbM833U.append(this.invite);
                sbM833U.append(")");
                return sbM833U.toString();
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

    /* JADX INFO: renamed from: com.discord.stores.StoreInstantInvites$clearInvites$1 */
    /* JADX INFO: compiled from: StoreInstantInvites.kt */
    public static final class C61261 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C61261(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
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

    /* JADX INFO: renamed from: com.discord.stores.StoreInstantInvites$fetchGuildInvites$1 */
    /* JADX INFO: compiled from: StoreInstantInvites.kt */
    public static final class C61271 extends AbstractC12240o implements Function1<List<? extends ModelInvite>, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreInstantInvites$fetchGuildInvites$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreInstantInvites.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ List $invites;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list) {
                super(0);
                this.$invites = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreInstantInvites.this.onLoadedInvites(this.$invites);
            }
        }

        public C61271() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelInvite> list) {
            invoke2(list);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends ModelInvite> list) {
            C12238m.checkNotNullParameter(list, "invites");
            StoreInstantInvites.this.dispatcher.schedule(new AnonymousClass1(list));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreInstantInvites$fetchInviteIfNotLoaded$1 */
    /* JADX INFO: compiled from: StoreInstantInvites.kt */
    public static final class C61281 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ Long $eventId;
        public final /* synthetic */ String $inviteCode;
        public final /* synthetic */ String $inviteKey;
        public final /* synthetic */ Boolean $inviteResolved;
        public final /* synthetic */ String $location;
        public final /* synthetic */ Function0 $onError;

        /* JADX INFO: renamed from: com.discord.stores.StoreInstantInvites$fetchInviteIfNotLoaded$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreInstantInvites.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<ModelInvite, TrackNetworkMetadataReceiver> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final TrackNetworkMetadataReceiver invoke(ModelInvite modelInvite) {
                User inviter;
                Channel channel;
                Channel channel2;
                Guild guild;
                C61281 c61281 = C61281.this;
                return new TrackNetworkActionInviteResolve(c61281.$inviteResolved, c61281.$inviteCode, Boolean.valueOf(StoreStream.INSTANCE.getAuthentication().isAuthed()), (modelInvite == null || (guild = modelInvite.guild) == null) ? null : Long.valueOf(guild.getId()), (modelInvite == null || (channel2 = modelInvite.getChannel()) == null) ? null : Long.valueOf(channel2.getId()), (modelInvite == null || (channel = modelInvite.getChannel()) == null) ? null : Long.valueOf(channel.getType()), (modelInvite == null || (inviter = modelInvite.getInviter()) == null) ? null : Long.valueOf(inviter.getId()), modelInvite != null ? Long.valueOf(modelInvite.getApproximateMemberCount()) : null, modelInvite != null ? Long.valueOf(modelInvite.getApproximatePresenceCount()) : null, modelInvite != null ? modelInvite.getInviteType() : null, null, modelInvite != null ? Boolean.valueOf(C12238m.areEqual(modelInvite.code, String.valueOf(RestAPIAbortCodes.USER_BANNED))) : null, null);
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreInstantInvites$fetchInviteIfNotLoaded$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: StoreInstantInvites.kt */
        public static final class AnonymousClass2 extends AbstractC12240o implements Function1<ModelInvite, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StoreInstantInvites$fetchInviteIfNotLoaded$1$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: StoreInstantInvites.kt */
            public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
                public final /* synthetic */ ModelInvite $it;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(ModelInvite modelInvite) {
                    super(0);
                    this.$it = modelInvite;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    C61281 c61281 = C61281.this;
                    StoreInstantInvites storeInstantInvites = StoreInstantInvites.this;
                    String str = c61281.$inviteKey;
                    C12238m.checkNotNullExpressionValue(str, "inviteKey");
                    storeInstantInvites.setChatInvites(str, new InviteState.Resolved(this.$it));
                    GuildScheduledEvent guildScheduledEvent = this.$it.getGuildScheduledEvent();
                    if (guildScheduledEvent != null) {
                        StoreGuildScheduledEvents guildScheduledEvents = StoreStream.INSTANCE.getGuildScheduledEvents();
                        C12238m.checkNotNullExpressionValue(guildScheduledEvent, "event");
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
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ModelInvite modelInvite) {
                C12238m.checkNotNullParameter(modelInvite, "it");
                StoreInstantInvites.this.dispatcher.schedule(new AnonymousClass1(modelInvite));
                String str = C61281.this.$location;
                if (str != null) {
                    AnalyticsTracker.INSTANCE.inviteResolved(modelInvite, str);
                }
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreInstantInvites$fetchInviteIfNotLoaded$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: StoreInstantInvites.kt */
        public static final class AnonymousClass3 extends AbstractC12240o implements Function1<Error, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StoreInstantInvites$fetchInviteIfNotLoaded$1$3$1, reason: invalid class name */
            /* JADX INFO: compiled from: StoreInstantInvites.kt */
            public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
                public AnonymousClass1() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    C61281 c61281 = C61281.this;
                    StoreInstantInvites storeInstantInvites = StoreInstantInvites.this;
                    String str = c61281.$inviteKey;
                    C12238m.checkNotNullExpressionValue(str, "inviteKey");
                    storeInstantInvites.setChatInvites(str, InviteState.Invalid.INSTANCE);
                }
            }

            /* JADX INFO: renamed from: com.discord.stores.StoreInstantInvites$fetchInviteIfNotLoaded$1$3$2, reason: invalid class name */
            /* JADX INFO: compiled from: StoreInstantInvites.kt */
            public static final class AnonymousClass2 extends AbstractC12240o implements Function0<Unit> {
                public AnonymousClass2() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    C61281 c61281 = C61281.this;
                    StoreInstantInvites storeInstantInvites = StoreInstantInvites.this;
                    String str = c61281.$inviteKey;
                    C12238m.checkNotNullExpressionValue(str, "inviteKey");
                    storeInstantInvites.setChatInvites(str, InviteState.LoadFailed.INSTANCE);
                }
            }

            public AnonymousClass3() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                C12238m.checkNotNullParameter(error, "error");
                Function0 function0 = C61281.this.$onError;
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
                StoreInstantInvites.this.dispatcher.schedule(new AnonymousClass1());
                C61281 c61281 = C61281.this;
                String str = c61281.$location;
                if (str != null) {
                    String str2 = c61281.$inviteCode;
                    Error.Response response = error.getResponse();
                    C12238m.checkNotNullExpressionValue(response, "error.response");
                    String message = response.getMessage();
                    Error.Response response2 = error.getResponse();
                    C12238m.checkNotNullExpressionValue(response2, "error.response");
                    AnalyticsTracker.inviteResolveFailed(str2, str, message, Integer.valueOf(response2.getCode()));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C61281(String str, String str2, Long l, Boolean bool, String str3, Function0 function0) {
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
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (!StoreInstantInvites.this.knownInvites.containsKey(this.$inviteKey) || (StoreInstantInvites.this.knownInvites.get(this.$inviteKey) instanceof InviteState.LoadFailed)) {
                AnalyticsTracker.inviteOpened(this.$inviteCode);
                StoreInstantInvites storeInstantInvites = StoreInstantInvites.this;
                String str = this.$inviteKey;
                C12238m.checkNotNullExpressionValue(str, "inviteKey");
                storeInstantInvites.setChatInvites(str, InviteState.Loading.INSTANCE);
                ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestCallStateKt.logNetworkAction(StoreInstantInvites.this.restAPI.getInviteCode(this.$inviteCode, true, this.$eventId), new AnonymousClass1()), false, 1, null), (Class<?>) StoreInstantInvites.this.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass3()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new AnonymousClass2());
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreInstantInvites$observeInvite$1 */
    /* JADX INFO: compiled from: StoreInstantInvites.kt */
    public static final class C61291 extends AbstractC12240o implements Function0<Map<String, ? extends InviteState>> {
        public C61291() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<String, ? extends InviteState> invoke() {
            return StoreInstantInvites.this.getKnownInvites();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreInstantInvites$observeKnownInvites$1 */
    /* JADX INFO: compiled from: StoreInstantInvites.kt */
    public static final class C61311 extends AbstractC12240o implements Function0<Map<String, ? extends InviteState>> {
        public C61311() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<String, ? extends InviteState> invoke() {
            return StoreInstantInvites.this.getKnownInvites();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreInstantInvites$onInviteRemoved$1 */
    /* JADX INFO: compiled from: StoreInstantInvites.kt */
    public static final class C61321 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ ModelInvite $invite;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C61321(ModelInvite modelInvite) {
            super(0);
            this.$invite = modelInvite;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
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
        this(dispatcher, (i & 2) != 0 ? ObservationDeckProvider.get() : observationDeck, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    private final Map<Long, Map<String, ModelInvite>> getInvites() {
        return this.invitesSnapshot;
    }

    private final Map<String, InviteState> getKnownInvites() {
        return this.knownInvitesSnapshot;
    }

    @StoreThread
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
                C12238m.checkNotNullExpressionValue(str, "invite.code");
                linkedHashMap.put(str, modelInvite);
                this.invites.put(lValueOf, linkedHashMap);
            }
        }
        markChanged();
    }

    @StoreThread
    private final void setChatInvites(String inviteKey, InviteState inviteState) {
        this.knownInvites.put(inviteKey, inviteState);
        markChanged();
    }

    public final void clearInvites(long guildId) {
        this.dispatcher.schedule(new C61261(guildId));
    }

    public final void fetchGuildInvites(long guildId) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.getGuildInvites(guildId), false, 1, null), (Class<?>) StoreInstantInvites.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C61271());
    }

    public final void fetchInviteIfNotLoaded(String inviteCode, Long eventId, String location, Boolean inviteResolved, Function0<Unit> onError) {
        C12238m.checkNotNullParameter(inviteCode, "inviteCode");
        this.dispatcher.schedule(new C61281(ModelInvite.getInviteStoreKey(inviteCode, eventId), inviteCode, eventId, inviteResolved, location, onError));
    }

    public final Observable<InviteState> observeInvite(final String inviteKey) {
        if (inviteKey == null) {
            C12721k c12721k = new C12721k(InviteState.LoadFailed.INSTANCE);
            C12238m.checkNotNullExpressionValue(c12721k, "Observable.just(InviteState.LoadFailed)");
            return c12721k;
        }
        Observable<InviteState> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C61291(), 14, null).m11083G(new InterfaceC12589b<Map<String, ? extends InviteState>, InviteState>() { // from class: com.discord.stores.StoreInstantInvites.observeInvite.2
            @Override // p637j0.p641k.InterfaceC12589b
            public final InviteState call(Map<String, ? extends InviteState> map) {
                InviteState inviteState = map.get(inviteKey);
                return inviteState != null ? inviteState : InviteState.Loading.INSTANCE;
            }
        }).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Map<String, InviteState>> observeKnownInvites() {
        Observable<Map<String, InviteState>> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C61311(), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableM11112r;
    }

    public final void onInviteRemoved(ModelInvite invite) {
        C12238m.checkNotNullParameter(invite, "invite");
        this.dispatcher.schedule(new C61321(invite));
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
        return map != null ? map : C12136h0.emptyMap();
    }

    public StoreInstantInvites(Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI) {
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        C12238m.checkNotNullParameter(restAPI, "restAPI");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.restAPI = restAPI;
        this.invites = new LinkedHashMap();
        this.invitesSnapshot = C12136h0.emptyMap();
        this.knownInvites = new LinkedHashMap();
        this.knownInvitesSnapshot = C12136h0.emptyMap();
    }
}
