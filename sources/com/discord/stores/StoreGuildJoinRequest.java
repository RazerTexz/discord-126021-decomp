package com.discord.stores;

import com.discord.api.guildjoinrequest.ApplicationStatus;
import com.discord.api.guildjoinrequest.GuildJoinRequest;
import com.discord.models.domain.ModelPayload;
import com.discord.models.guild.Guild;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.servers.member_verification.MemberVerificationSuccessDialog;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;

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

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildJoinRequest$fetchPendingGuilds$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildJoinRequest.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreGuildJoinRequest$fetchPendingGuilds$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreGuildJoinRequest.kt */
        public static final class C01191 extends Lambda implements Function1<List<? extends com.discord.api.guild.Guild>, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StoreGuildJoinRequest$fetchPendingGuilds$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: StoreGuildJoinRequest.kt */
            public static final class C01201 extends Lambda implements Function0<Unit> {
                public final /* synthetic */ List $results;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01201(List list) {
                    super(0);
                    this.$results = list;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    for (com.discord.api.guild.Guild guild : this.$results) {
                        StoreGuildJoinRequest.this.pendingGuilds.put(Long.valueOf(guild.getId()), new Guild(guild));
                    }
                    StoreGuildJoinRequest.this.markChanged();
                }
            }

            public C01191() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.discord.api.guild.Guild> list) {
                invoke2((List<com.discord.api.guild.Guild>) list);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<com.discord.api.guild.Guild> list) {
                Intrinsics3.checkNotNullParameter(list, "results");
                StoreGuildJoinRequest.this.dispatcher.schedule(new C01201(list));
            }
        }

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
            Map<Long, Guild> guilds = StoreGuildJoinRequest.this.guildsStore.getGuilds();
            Set setKeySet = StoreGuildJoinRequest.this.guildJoinRequests.keySet();
            Intrinsics3.checkNotNullExpressionValue(setKeySet, "guildJoinRequests.keys");
            ArrayList arrayList = new ArrayList();
            Iterator it = setKeySet.iterator();
            while (true) {
                boolean z2 = false;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                Long l = (Long) next;
                Intrinsics3.checkNotNullExpressionValue(l, "it");
                if (!guilds.containsKey(l) && !StoreGuildJoinRequest.this.pendingGuilds.containsKey(l)) {
                    z2 = true;
                }
                if (z2) {
                    arrayList.add(next);
                }
            }
            if (!arrayList.isEmpty()) {
                ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getUserJoinRequestGuilds(), false, 1, null), (Class<?>) StoreGuildJoinRequest.this.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new C01191());
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildJoinRequest$observeGuildJoinRequest$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildJoinRequest.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<GuildJoinRequest> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final GuildJoinRequest invoke() {
            return (GuildJoinRequest) StoreGuildJoinRequest.this.guildJoinRequestsSnapshot.get(Long.valueOf(this.$guildId));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildJoinRequest$observeGuildJoinRequests$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildJoinRequest.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends GuildJoinRequest>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends GuildJoinRequest> invoke() {
            return StoreGuildJoinRequest.this.guildJoinRequestsSnapshot;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildJoinRequest$observePendingGuilds$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildJoinRequest.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends Guild>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends Guild> invoke() {
            return StoreGuildJoinRequest.this.pendingGuildsSnapshot;
        }
    }

    public StoreGuildJoinRequest(StoreUser storeUser, StoreGuilds storeGuilds, Dispatcher dispatcher, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(storeUser, "userStore");
        Intrinsics3.checkNotNullParameter(storeGuilds, "guildsStore");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.userStore = storeUser;
        this.guildsStore = storeGuilds;
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.pendingGuilds = new HashMap<>();
        this.pendingGuildsSnapshot = Maps6.emptyMap();
        this.guildJoinRequests = new HashMap<>();
        this.guildJoinRequestsSnapshot = Maps6.emptyMap();
    }

    private final void handleGuildJoinRequestApproved(long guildId) {
        Guild guild = this.guildsStore.getGuild(guildId);
        if ((guild != null ? guild.getName() : null) != null) {
            MemberVerificationSuccessDialog.INSTANCE.enqueue(guildId);
        }
    }

    public final void fetchPendingGuilds() {
        this.dispatcher.schedule(new AnonymousClass1());
    }

    public final GuildJoinRequest getGuildJoinRequest(long guildId) {
        return this.guildJoinRequestsSnapshot.get(Long.valueOf(guildId));
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        List<GuildJoinRequest> guildJoinRequests = payload.getGuildJoinRequests();
        if (guildJoinRequests != null) {
            for (GuildJoinRequest guildJoinRequest : guildJoinRequests) {
                HashMap<Long, GuildJoinRequest> map = this.guildJoinRequests;
                Long lValueOf = Long.valueOf(guildJoinRequest.getGuildId());
                Intrinsics3.checkNotNullExpressionValue(guildJoinRequest, "joinRequest");
                map.put(lValueOf, guildJoinRequest);
            }
        }
        markChanged();
    }

    @Store3
    public final void handleGuildJoinRequestCreateOrUpdate(long guildId, GuildJoinRequest request) {
        Intrinsics3.checkNotNullParameter(request, "request");
        if (request.getUserId() == this.userStore.getMeSnapshot().getId()) {
            this.guildJoinRequests.put(Long.valueOf(guildId), request);
            if (request.getApplicationStatus() == ApplicationStatus.APPROVED && request.getLastSeen() == null) {
                handleGuildJoinRequestApproved(guildId);
            }
            markChanged();
        }
    }

    @Store3
    public final void handleGuildJoinRequestDelete(long userId, long guildId) {
        if (userId == this.userStore.getMeSnapshot().getId()) {
            this.guildJoinRequests.remove(Long.valueOf(guildId));
            this.pendingGuilds.remove(Long.valueOf(guildId));
            markChanged();
        }
    }

    @Store3
    public final void handleGuildRemove(long guildId) {
        if (this.guildJoinRequests.remove(Long.valueOf(guildId)) != null) {
            markChanged();
        }
    }

    public final Observable<GuildJoinRequest> observeGuildJoinRequest(long guildId) {
        Observable<GuildJoinRequest> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(guildId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, GuildJoinRequest>> observeGuildJoinRequests() {
        Observable<Map<Long, GuildJoinRequest>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, Guild>> observePendingGuilds() {
        Observable<Map<Long, Guild>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        this.guildJoinRequestsSnapshot = new HashMap(this.guildJoinRequests);
        this.pendingGuildsSnapshot = new HashMap(this.pendingGuilds);
    }
}
