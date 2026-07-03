package com.discord.stores;

import com.discord.api.guildjoinrequest.ApplicationStatus;
import com.discord.api.guildjoinrequest.GuildJoinRequest;
import com.discord.models.domain.ModelPayload;
import com.discord.models.guild.Guild;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.widgets.servers.member_verification.MemberVerificationSuccessDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p580t.C12136h0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: StoreGuildJoinRequest.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildJoinRequest extends StoreV2 {
    private final Dispatcher dispatcher;
    private final HashMap<Long, GuildJoinRequest> guildJoinRequests;
    private Map<Long, GuildJoinRequest> guildJoinRequestsSnapshot;
    private final StoreGuilds guildsStore;
    private final ObservationDeck observationDeck;
    private HashMap<Long, Guild> pendingGuilds;
    private Map<Long, Guild> pendingGuildsSnapshot;
    private final StoreUser userStore;

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildJoinRequest$fetchPendingGuilds$1 */
    /* JADX INFO: compiled from: StoreGuildJoinRequest.kt */
    public static final class C60281 extends AbstractC12240o implements Function0<Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreGuildJoinRequest$fetchPendingGuilds$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGuildJoinRequest.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<List<? extends com.discord.api.guild.Guild>, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StoreGuildJoinRequest$fetchPendingGuilds$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: StoreGuildJoinRequest.kt */
            public static final class C132541 extends AbstractC12240o implements Function0<Unit> {
                public final /* synthetic */ List $results;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C132541(List list) {
                    super(0);
                    this.$results = list;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    for (com.discord.api.guild.Guild guild : this.$results) {
                        StoreGuildJoinRequest.this.pendingGuilds.put(Long.valueOf(guild.getId()), new Guild(guild));
                    }
                    StoreGuildJoinRequest.this.markChanged();
                }
            }

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.discord.api.guild.Guild> list) {
                invoke2((List<com.discord.api.guild.Guild>) list);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<com.discord.api.guild.Guild> list) {
                C12238m.checkNotNullParameter(list, "results");
                StoreGuildJoinRequest.this.dispatcher.schedule(new C132541(list));
            }
        }

        public C60281() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Map<Long, Guild> guilds = StoreGuildJoinRequest.this.guildsStore.getGuilds();
            Set setKeySet = StoreGuildJoinRequest.this.guildJoinRequests.keySet();
            C12238m.checkNotNullExpressionValue(setKeySet, "guildJoinRequests.keys");
            ArrayList arrayList = new ArrayList();
            Iterator it = setKeySet.iterator();
            while (true) {
                boolean z2 = false;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                Long l = (Long) next;
                C12238m.checkNotNullExpressionValue(l, "it");
                if (!guilds.containsKey(l) && !StoreGuildJoinRequest.this.pendingGuilds.containsKey(l)) {
                    z2 = true;
                }
                if (z2) {
                    arrayList.add(next);
                }
            }
            if (!arrayList.isEmpty()) {
                ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getUserJoinRequestGuilds(), false, 1, null), (Class<?>) StoreGuildJoinRequest.this.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new AnonymousClass1());
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildJoinRequest$observeGuildJoinRequest$1 */
    /* JADX INFO: compiled from: StoreGuildJoinRequest.kt */
    public static final class C60291 extends AbstractC12240o implements Function0<GuildJoinRequest> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60291(long j) {
            super(0);
            this.$guildId = j;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final GuildJoinRequest invoke() {
            return (GuildJoinRequest) StoreGuildJoinRequest.this.guildJoinRequestsSnapshot.get(Long.valueOf(this.$guildId));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildJoinRequest$observeGuildJoinRequests$1 */
    /* JADX INFO: compiled from: StoreGuildJoinRequest.kt */
    public static final class C60301 extends AbstractC12240o implements Function0<Map<Long, ? extends GuildJoinRequest>> {
        public C60301() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends GuildJoinRequest> invoke() {
            return StoreGuildJoinRequest.this.guildJoinRequestsSnapshot;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildJoinRequest$observePendingGuilds$1 */
    /* JADX INFO: compiled from: StoreGuildJoinRequest.kt */
    public static final class C60311 extends AbstractC12240o implements Function0<Map<Long, ? extends Guild>> {
        public C60311() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends Guild> invoke() {
            return StoreGuildJoinRequest.this.pendingGuildsSnapshot;
        }
    }

    public StoreGuildJoinRequest(StoreUser storeUser, StoreGuilds storeGuilds, Dispatcher dispatcher, ObservationDeck observationDeck) {
        C12238m.checkNotNullParameter(storeUser, "userStore");
        C12238m.checkNotNullParameter(storeGuilds, "guildsStore");
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        this.userStore = storeUser;
        this.guildsStore = storeGuilds;
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.pendingGuilds = new HashMap<>();
        this.pendingGuildsSnapshot = C12136h0.emptyMap();
        this.guildJoinRequests = new HashMap<>();
        this.guildJoinRequestsSnapshot = C12136h0.emptyMap();
    }

    private final void handleGuildJoinRequestApproved(long guildId) {
        Guild guild = this.guildsStore.getGuild(guildId);
        if ((guild != null ? guild.getName() : null) != null) {
            MemberVerificationSuccessDialog.INSTANCE.enqueue(guildId);
        }
    }

    public final void fetchPendingGuilds() {
        this.dispatcher.schedule(new C60281());
    }

    public final GuildJoinRequest getGuildJoinRequest(long guildId) {
        return this.guildJoinRequestsSnapshot.get(Long.valueOf(guildId));
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        C12238m.checkNotNullParameter(payload, "payload");
        List<GuildJoinRequest> guildJoinRequests = payload.getGuildJoinRequests();
        if (guildJoinRequests != null) {
            for (GuildJoinRequest guildJoinRequest : guildJoinRequests) {
                HashMap<Long, GuildJoinRequest> map = this.guildJoinRequests;
                Long lValueOf = Long.valueOf(guildJoinRequest.getGuildId());
                C12238m.checkNotNullExpressionValue(guildJoinRequest, "joinRequest");
                map.put(lValueOf, guildJoinRequest);
            }
        }
        markChanged();
    }

    @StoreThread
    public final void handleGuildJoinRequestCreateOrUpdate(long guildId, GuildJoinRequest request) {
        C12238m.checkNotNullParameter(request, "request");
        if (request.getUserId() == this.userStore.getMeSnapshot().getId()) {
            this.guildJoinRequests.put(Long.valueOf(guildId), request);
            if (request.getApplicationStatus() == ApplicationStatus.APPROVED && request.getLastSeen() == null) {
                handleGuildJoinRequestApproved(guildId);
            }
            markChanged();
        }
    }

    @StoreThread
    public final void handleGuildJoinRequestDelete(long userId, long guildId) {
        if (userId == this.userStore.getMeSnapshot().getId()) {
            this.guildJoinRequests.remove(Long.valueOf(guildId));
            this.pendingGuilds.remove(Long.valueOf(guildId));
            markChanged();
        }
    }

    @StoreThread
    public final void handleGuildRemove(long guildId) {
        if (this.guildJoinRequests.remove(Long.valueOf(guildId)) != null) {
            markChanged();
        }
    }

    public final Observable<GuildJoinRequest> observeGuildJoinRequest(long guildId) {
        Observable<GuildJoinRequest> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C60291(guildId), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Map<Long, GuildJoinRequest>> observeGuildJoinRequests() {
        Observable<Map<Long, GuildJoinRequest>> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C60301(), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Map<Long, Guild>> observePendingGuilds() {
        Observable<Map<Long, Guild>> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C60311(), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableM11112r;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        this.guildJoinRequestsSnapshot = new HashMap(this.guildJoinRequests);
        this.pendingGuildsSnapshot = new HashMap(this.pendingGuilds);
    }
}
