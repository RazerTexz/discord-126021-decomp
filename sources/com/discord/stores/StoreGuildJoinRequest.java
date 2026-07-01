package com.discord.stores;

import com.discord.api.guildjoinrequest.ApplicationStatus;
import com.discord.api.guildjoinrequest.GuildJoinRequest;
import com.discord.models.domain.ModelPayload;
import com.discord.models.guild.Guild;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.widgets.servers.member_verification.MemberVerificationSuccessDialog;
import d0.t.h0;
import d0.z.d.m;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.Observable;

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

    public StoreGuildJoinRequest(StoreUser storeUser, StoreGuilds storeGuilds, Dispatcher dispatcher, ObservationDeck observationDeck) {
        m.checkNotNullParameter(storeUser, "userStore");
        m.checkNotNullParameter(storeGuilds, "guildsStore");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.userStore = storeUser;
        this.guildsStore = storeGuilds;
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.pendingGuilds = new HashMap<>();
        this.pendingGuildsSnapshot = h0.emptyMap();
        this.guildJoinRequests = new HashMap<>();
        this.guildJoinRequestsSnapshot = h0.emptyMap();
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreGuildJoinRequest storeGuildJoinRequest) {
        return storeGuildJoinRequest.dispatcher;
    }

    public static final /* synthetic */ HashMap access$getGuildJoinRequests$p(StoreGuildJoinRequest storeGuildJoinRequest) {
        return storeGuildJoinRequest.guildJoinRequests;
    }

    public static final /* synthetic */ Map access$getGuildJoinRequestsSnapshot$p(StoreGuildJoinRequest storeGuildJoinRequest) {
        return storeGuildJoinRequest.guildJoinRequestsSnapshot;
    }

    public static final /* synthetic */ StoreGuilds access$getGuildsStore$p(StoreGuildJoinRequest storeGuildJoinRequest) {
        return storeGuildJoinRequest.guildsStore;
    }

    public static final /* synthetic */ HashMap access$getPendingGuilds$p(StoreGuildJoinRequest storeGuildJoinRequest) {
        return storeGuildJoinRequest.pendingGuilds;
    }

    public static final /* synthetic */ Map access$getPendingGuildsSnapshot$p(StoreGuildJoinRequest storeGuildJoinRequest) {
        return storeGuildJoinRequest.pendingGuildsSnapshot;
    }

    public static final /* synthetic */ void access$setGuildJoinRequestsSnapshot$p(StoreGuildJoinRequest storeGuildJoinRequest, Map map) {
        storeGuildJoinRequest.guildJoinRequestsSnapshot = map;
    }

    public static final /* synthetic */ void access$setPendingGuilds$p(StoreGuildJoinRequest storeGuildJoinRequest, HashMap map) {
        storeGuildJoinRequest.pendingGuilds = map;
    }

    public static final /* synthetic */ void access$setPendingGuildsSnapshot$p(StoreGuildJoinRequest storeGuildJoinRequest, Map map) {
        storeGuildJoinRequest.pendingGuildsSnapshot = map;
    }

    private final void handleGuildJoinRequestApproved(long guildId) {
        Guild guild = this.guildsStore.getGuild(guildId);
        if ((guild != null ? guild.getName() : null) != null) {
            MemberVerificationSuccessDialog.Companion.enqueue(guildId);
        }
    }

    public final void fetchPendingGuilds() {
        this.dispatcher.schedule(new StoreGuildJoinRequest$fetchPendingGuilds$1(this));
    }

    public final GuildJoinRequest getGuildJoinRequest(long guildId) {
        return this.guildJoinRequestsSnapshot.get(Long.valueOf(guildId));
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        m.checkNotNullParameter(payload, "payload");
        List<GuildJoinRequest> guildJoinRequests = payload.getGuildJoinRequests();
        if (guildJoinRequests != null) {
            for (GuildJoinRequest guildJoinRequest : guildJoinRequests) {
                HashMap<Long, GuildJoinRequest> map = this.guildJoinRequests;
                Long lValueOf = Long.valueOf(guildJoinRequest.getGuildId());
                m.checkNotNullExpressionValue(guildJoinRequest, "joinRequest");
                map.put(lValueOf, guildJoinRequest);
            }
        }
        markChanged();
    }

    @StoreThread
    public final void handleGuildJoinRequestCreateOrUpdate(long guildId, GuildJoinRequest request) {
        m.checkNotNullParameter(request, "request");
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
        Observable<GuildJoinRequest> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreGuildJoinRequest$observeGuildJoinRequest$1(this, guildId), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, GuildJoinRequest>> observeGuildJoinRequests() {
        Observable<Map<Long, GuildJoinRequest>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreGuildJoinRequest$observeGuildJoinRequests$1(this), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, Guild>> observePendingGuilds() {
        Observable<Map<Long, Guild>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreGuildJoinRequest$observePendingGuilds$1(this), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        this.guildJoinRequestsSnapshot = new HashMap(this.guildJoinRequests);
        this.pendingGuildsSnapshot = new HashMap(this.pendingGuilds);
    }
}
