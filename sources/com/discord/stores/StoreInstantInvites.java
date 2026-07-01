package com.discord.stores;

import android.content.Context;
import com.discord.api.guild.Guild;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.h0;
import d0.z.d.m;
import j0.l.e.k;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StoreInstantInvites.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreInstantInvites extends StoreV2 {
    private final Dispatcher dispatcher;
    private final Map<Long, Map<String, ModelInvite>> invites;
    private Map<Long, ? extends Map<String, ? extends ModelInvite>> invitesSnapshot;
    private final Map<String, StoreInstantInvites$InviteState> knownInvites;
    private Map<String, ? extends StoreInstantInvites$InviteState> knownInvitesSnapshot;
    private final ObservationDeck observationDeck;
    private final RestAPI restAPI;

    public /* synthetic */ StoreInstantInvites(Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeckProvider.get() : observationDeck, (i & 4) != 0 ? RestAPI.Companion.getApi() : restAPI);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreInstantInvites storeInstantInvites) {
        return storeInstantInvites.dispatcher;
    }

    public static final /* synthetic */ Map access$getInvites$p(StoreInstantInvites storeInstantInvites) {
        return storeInstantInvites.invites;
    }

    public static final /* synthetic */ Map access$getKnownInvites(StoreInstantInvites storeInstantInvites) {
        return storeInstantInvites.getKnownInvites();
    }

    public static final /* synthetic */ Map access$getKnownInvites$p(StoreInstantInvites storeInstantInvites) {
        return storeInstantInvites.knownInvites;
    }

    public static final /* synthetic */ RestAPI access$getRestAPI$p(StoreInstantInvites storeInstantInvites) {
        return storeInstantInvites.restAPI;
    }

    public static final /* synthetic */ void access$onLoadedInvites(StoreInstantInvites storeInstantInvites, List list) {
        storeInstantInvites.onLoadedInvites(list);
    }

    public static final /* synthetic */ void access$setChatInvites(StoreInstantInvites storeInstantInvites, String str, StoreInstantInvites$InviteState storeInstantInvites$InviteState) {
        storeInstantInvites.setChatInvites(str, storeInstantInvites$InviteState);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void fetchInviteIfNotLoaded$default(StoreInstantInvites storeInstantInvites, String str, Long l, String str2, Boolean bool, Function0 function0, int i, Object obj) {
        storeInstantInvites.fetchInviteIfNotLoaded(str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : function0);
    }

    private final Map<Long, Map<String, ModelInvite>> getInvites() {
        return this.invitesSnapshot;
    }

    private final Map<String, StoreInstantInvites$InviteState> getKnownInvites() {
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
                m.checkNotNullExpressionValue(str, "invite.code");
                linkedHashMap.put(str, modelInvite);
                this.invites.put(lValueOf, linkedHashMap);
            }
        }
        markChanged();
    }

    @StoreThread
    private final void setChatInvites(String inviteKey, StoreInstantInvites$InviteState inviteState) {
        this.knownInvites.put(inviteKey, inviteState);
        markChanged();
    }

    public final void clearInvites(long guildId) {
        this.dispatcher.schedule(new StoreInstantInvites$clearInvites$1(this, guildId));
    }

    public final void fetchGuildInvites(long guildId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.getGuildInvites(guildId), false, 1, null), StoreInstantInvites.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreInstantInvites$fetchGuildInvites$1(this), 62, (Object) null);
    }

    public final void fetchInviteIfNotLoaded(String inviteCode, Long eventId, String location, Boolean inviteResolved, Function0<Unit> onError) {
        m.checkNotNullParameter(inviteCode, "inviteCode");
        this.dispatcher.schedule(new StoreInstantInvites$fetchInviteIfNotLoaded$1(this, ModelInvite.getInviteStoreKey(inviteCode, eventId), inviteCode, eventId, inviteResolved, location, onError));
    }

    public final Observable<StoreInstantInvites$InviteState> observeInvite(String inviteKey) {
        if (inviteKey == null) {
            k kVar = new k(StoreInstantInvites$InviteState$LoadFailed.INSTANCE);
            m.checkNotNullExpressionValue(kVar, "Observable.just(InviteState.LoadFailed)");
            return kVar;
        }
        Observable<StoreInstantInvites$InviteState> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreInstantInvites$observeInvite$1(this), 14, null).G(new StoreInstantInvites$observeInvite$2(inviteKey)).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<String, StoreInstantInvites$InviteState>> observeKnownInvites() {
        Observable<Map<String, StoreInstantInvites$InviteState>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreInstantInvites$observeKnownInvites$1(this), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final void onInviteRemoved(ModelInvite invite) {
        m.checkNotNullParameter(invite, "invite");
        this.dispatcher.schedule(new StoreInstantInvites$onInviteRemoved$1(this, invite));
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map$Entry<Long, Map<String, ModelInvite>> map$Entry : this.invites.entrySet()) {
            linkedHashMap.put(Long.valueOf(map$Entry.getKey().longValue()), new HashMap(map$Entry.getValue()));
        }
        this.invitesSnapshot = linkedHashMap;
        this.knownInvitesSnapshot = new HashMap(this.knownInvites);
    }

    public final Map<String, ModelInvite> getInvites(long guildId) {
        Map<String, ModelInvite> map = getInvites().get(Long.valueOf(guildId));
        return map != null ? map : h0.emptyMap();
    }

    public StoreInstantInvites(Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(restAPI, "restAPI");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.restAPI = restAPI;
        this.invites = new LinkedHashMap();
        this.invitesSnapshot = h0.emptyMap();
        this.knownInvites = new LinkedHashMap();
        this.knownInvitesSnapshot = h0.emptyMap();
    }
}
