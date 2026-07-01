package com.discord.stores;

import android.content.Context;
import com.discord.api.guild.Guild;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import com.discord.api.guildscheduledevent.GuildScheduledEventUserUpdate;
import com.discord.api.permission.Permission;
import com.discord.models.domain.ModelPayload;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.restapi.RestAPIParams$GuildFeatureAck;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventUser;
import d0.d0.f;
import d0.t.h0;
import d0.t.n;
import d0.t.n0;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: StoreGuildScheduledEvents.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildScheduledEvents extends StoreV2 {
    public static final StoreGuildScheduledEvents$Companion Companion = new StoreGuildScheduledEvents$Companion(null);
    public static final long FETCH_GUILD_EVENTS_THRESHOLD = 1800000;
    private final Clock clock;
    private final Dispatcher dispatcher;
    private final StoreExperiments experimentsStore;
    private final HashMap<Long, HashMap<Long, GuildScheduledEventUser>> guildScheduledEventUsers;
    private final HashMap<Long, Set<Long>> guildScheduledEventUsersFetches;
    private Map<Long, ? extends Map<Long, GuildScheduledEventUser>> guildScheduledEventUsersSnapshot;
    private final HashMap<Long, List<GuildScheduledEvent>> guildScheduledEvents;
    private final HashMap<Long, Long> guildScheduledEventsFetchTimestamps;
    private Map<Long, ? extends List<GuildScheduledEvent>> guildScheduledEventsSnapshot;
    private final StoreGuilds guildsStore;
    private boolean isFetchingGuildScheduledEventUsers;
    private boolean isGuildScheduledEventUsersError;
    private final HashMap<Long, Long> lastAckedGuildScheduledEventIds;
    private final HashMap<Long, Set<Long>> meGuildScheduledEventIds;
    private Map<Long, ? extends Set<Long>> meGuildScheduledEventIdsSnapshot;
    private final HashSet<Long> meGuildScheduledEventsFetches;
    private final ObservationDeck observationDeck;
    private final StorePermissions permissionsStore;
    private final HashSet<Long> rsvpsAwaitingNetwork;
    private HashSet<Long> rsvpsAwaitingSnapshot;
    private final StoreUser userStore;

    public StoreGuildScheduledEvents(Dispatcher dispatcher, ObservationDeck observationDeck, StorePermissions storePermissions, StoreUser storeUser, StoreGuilds storeGuilds, Clock clock, StoreExperiments storeExperiments) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(storePermissions, "permissionsStore");
        m.checkNotNullParameter(storeUser, "userStore");
        m.checkNotNullParameter(storeGuilds, "guildsStore");
        m.checkNotNullParameter(clock, "clock");
        m.checkNotNullParameter(storeExperiments, "experimentsStore");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.permissionsStore = storePermissions;
        this.userStore = storeUser;
        this.guildsStore = storeGuilds;
        this.clock = clock;
        this.experimentsStore = storeExperiments;
        this.guildScheduledEvents = new HashMap<>();
        this.guildScheduledEventsSnapshot = h0.emptyMap();
        this.lastAckedGuildScheduledEventIds = new HashMap<>();
        this.guildScheduledEventsFetchTimestamps = new HashMap<>();
        this.meGuildScheduledEventIds = new HashMap<>();
        this.meGuildScheduledEventIdsSnapshot = h0.emptyMap();
        this.meGuildScheduledEventsFetches = new HashSet<>();
        this.rsvpsAwaitingNetwork = new HashSet<>();
        this.rsvpsAwaitingSnapshot = new HashSet<>();
        this.guildScheduledEventUsers = new HashMap<>();
        this.guildScheduledEventUsersSnapshot = h0.emptyMap();
        this.guildScheduledEventUsersFetches = new HashMap<>();
    }

    public static final /* synthetic */ GuildScheduledEvent access$findEventFromStore(StoreGuildScheduledEvents storeGuildScheduledEvents, GuildScheduledEvent guildScheduledEvent) {
        return storeGuildScheduledEvents.findEventFromStore(guildScheduledEvent);
    }

    public static final /* synthetic */ Clock access$getClock$p(StoreGuildScheduledEvents storeGuildScheduledEvents) {
        return storeGuildScheduledEvents.clock;
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreGuildScheduledEvents storeGuildScheduledEvents) {
        return storeGuildScheduledEvents.dispatcher;
    }

    public static final /* synthetic */ HashMap access$getGuildScheduledEventUsers$p(StoreGuildScheduledEvents storeGuildScheduledEvents) {
        return storeGuildScheduledEvents.guildScheduledEventUsers;
    }

    public static final /* synthetic */ HashMap access$getGuildScheduledEventUsersFetches$p(StoreGuildScheduledEvents storeGuildScheduledEvents) {
        return storeGuildScheduledEvents.guildScheduledEventUsersFetches;
    }

    public static final /* synthetic */ HashMap access$getGuildScheduledEvents$p(StoreGuildScheduledEvents storeGuildScheduledEvents) {
        return storeGuildScheduledEvents.guildScheduledEvents;
    }

    public static final /* synthetic */ HashMap access$getGuildScheduledEventsFetchTimestamps$p(StoreGuildScheduledEvents storeGuildScheduledEvents) {
        return storeGuildScheduledEvents.guildScheduledEventsFetchTimestamps;
    }

    public static final /* synthetic */ StoreGuilds access$getGuildsStore$p(StoreGuildScheduledEvents storeGuildScheduledEvents) {
        return storeGuildScheduledEvents.guildsStore;
    }

    public static final /* synthetic */ HashMap access$getLastAckedGuildScheduledEventIds$p(StoreGuildScheduledEvents storeGuildScheduledEvents) {
        return storeGuildScheduledEvents.lastAckedGuildScheduledEventIds;
    }

    public static final /* synthetic */ HashMap access$getMeGuildScheduledEventIds$p(StoreGuildScheduledEvents storeGuildScheduledEvents) {
        return storeGuildScheduledEvents.meGuildScheduledEventIds;
    }

    public static final /* synthetic */ HashSet access$getMeGuildScheduledEventsFetches$p(StoreGuildScheduledEvents storeGuildScheduledEvents) {
        return storeGuildScheduledEvents.meGuildScheduledEventsFetches;
    }

    public static final /* synthetic */ HashSet access$getRsvpsAwaitingNetwork$p(StoreGuildScheduledEvents storeGuildScheduledEvents) {
        return storeGuildScheduledEvents.rsvpsAwaitingNetwork;
    }

    public static final /* synthetic */ StoreUser access$getUserStore$p(StoreGuildScheduledEvents storeGuildScheduledEvents) {
        return storeGuildScheduledEvents.userStore;
    }

    public static final /* synthetic */ void access$handleFetchRsvpUsersFailure(StoreGuildScheduledEvents storeGuildScheduledEvents) {
        storeGuildScheduledEvents.handleFetchRsvpUsersFailure();
    }

    public static final /* synthetic */ boolean access$isFetchingGuildScheduledEventUsers$p(StoreGuildScheduledEvents storeGuildScheduledEvents) {
        return storeGuildScheduledEvents.isFetchingGuildScheduledEventUsers;
    }

    public static final /* synthetic */ boolean access$isGuildScheduledEventUsersError$p(StoreGuildScheduledEvents storeGuildScheduledEvents) {
        return storeGuildScheduledEvents.isGuildScheduledEventUsersError;
    }

    public static final /* synthetic */ void access$processRsvpCreate(StoreGuildScheduledEvents storeGuildScheduledEvents, GuildScheduledEvent guildScheduledEvent, long j) {
        storeGuildScheduledEvents.processRsvpCreate(guildScheduledEvent, j);
    }

    public static final /* synthetic */ void access$processRsvpDelete(StoreGuildScheduledEvents storeGuildScheduledEvents, GuildScheduledEvent guildScheduledEvent, long j) {
        storeGuildScheduledEvents.processRsvpDelete(guildScheduledEvent, j);
    }

    public static final /* synthetic */ void access$setFetchingGuildScheduledEventUsers$p(StoreGuildScheduledEvents storeGuildScheduledEvents, boolean z2) {
        storeGuildScheduledEvents.isFetchingGuildScheduledEventUsers = z2;
    }

    public static final /* synthetic */ void access$setGuildScheduledEventUsersError$p(StoreGuildScheduledEvents storeGuildScheduledEvents, boolean z2) {
        storeGuildScheduledEvents.isGuildScheduledEventUsersError = z2;
    }

    @StoreThread
    private final void addMeRsvpForEvent(long guildId, long guildScheduledEventId) {
        if (!this.meGuildScheduledEventIds.containsKey(Long.valueOf(guildId))) {
            this.meGuildScheduledEventIds.put(Long.valueOf(guildId), n0.mutableSetOf(Long.valueOf(guildScheduledEventId)));
            return;
        }
        Set<Long> set = this.meGuildScheduledEventIds.get(Long.valueOf(guildId));
        if (set != null) {
            set.add(Long.valueOf(guildScheduledEventId));
        }
    }

    @StoreThread
    private final void addUserRsvpForEvent(long userId, long guildId, long guildScheduledEventId) {
        GuildMember member;
        if (userId == this.userStore.getMeSnapshot().getId() && !isMeRsvpedToEvent(guildId, guildScheduledEventId)) {
            addMeRsvpForEvent(guildId, guildScheduledEventId);
        }
        HashMap<Long, GuildScheduledEventUser> map = this.guildScheduledEventUsers.get(Long.valueOf(guildScheduledEventId));
        if (map == null) {
            map = new HashMap<>();
        }
        User user = this.userStore.getUsers(d0.t.m.listOf(Long.valueOf(userId)), false).get(Long.valueOf(userId));
        if (user != null && (member = this.guildsStore.getMember(guildId, userId)) != null) {
            map.put(Long.valueOf(userId), new GuildScheduledEventUser(user, member, guildScheduledEventId));
        }
        this.guildScheduledEventUsers.put(Long.valueOf(guildScheduledEventId), map);
    }

    private final GuildScheduledEvent findEventFromStore(GuildScheduledEvent event) {
        GuildScheduledEvent guildScheduledEventFindEventFromStore = findEventFromStore(event.getId(), Long.valueOf(event.getGuildId()));
        return guildScheduledEventFindEventFromStore != null ? guildScheduledEventFindEventFromStore : event;
    }

    public static /* synthetic */ GuildScheduledEvent findEventFromStore$default(StoreGuildScheduledEvents storeGuildScheduledEvents, long j, Long l, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        return storeGuildScheduledEvents.findEventFromStore(j, l);
    }

    public static /* synthetic */ List getGuildScheduledEvents$default(StoreGuildScheduledEvents storeGuildScheduledEvents, long j, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        return storeGuildScheduledEvents.getGuildScheduledEvents(j, z2);
    }

    private final void handleFetchRsvpUsersFailure() {
        this.dispatcher.schedule(new StoreGuildScheduledEvents$handleFetchRsvpUsersFailure$1(this));
    }

    public static /* synthetic */ Observable observeGuildScheduledEvents$default(StoreGuildScheduledEvents storeGuildScheduledEvents, long j, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        return storeGuildScheduledEvents.observeGuildScheduledEvents(j, z2);
    }

    private final void processGuildScheduledEventCreateOrUpdate(GuildScheduledEvent guildScheduledEvent) {
        int i;
        GuildScheduledEvent guildScheduledEvent2;
        GuildScheduledEvent guildScheduledEventA = guildScheduledEvent;
        long guildId = guildScheduledEvent.getGuildId();
        List<GuildScheduledEvent> list = this.guildScheduledEvents.get(Long.valueOf(guildId));
        if (list == null) {
            i = -1;
            break;
        }
        Iterator<GuildScheduledEvent> it = list.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (it.next().getId() == guildScheduledEvent.getId()) {
                i = i2;
                break;
            }
            i2++;
        }
        if (this.guildScheduledEvents.get(Long.valueOf(guildId)) == null) {
            this.guildScheduledEvents.put(Long.valueOf(guildId), n.mutableListOf(guildScheduledEventA));
        } else if (i == -1) {
            List<GuildScheduledEvent> list2 = this.guildScheduledEvents.get(Long.valueOf(guildId));
            if (list2 != null) {
                list2.add(guildScheduledEventA);
            }
        } else {
            List<GuildScheduledEvent> list3 = this.guildScheduledEvents.get(Long.valueOf(guildId));
            Integer userCount = (list3 == null || (guildScheduledEvent2 = list3.get(i)) == null) ? null : guildScheduledEvent2.getUserCount();
            if (guildScheduledEvent.getUserCount() == null) {
                guildScheduledEventA = GuildScheduledEvent.a(guildScheduledEvent, 0L, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, userCount, null, null, 229375);
            }
            List<GuildScheduledEvent> list4 = this.guildScheduledEvents.get(Long.valueOf(guildId));
            if (list4 != null) {
                list4.set(i, guildScheduledEventA);
            }
        }
        markChanged();
    }

    @StoreThread
    private final void processRsvpCreate(GuildScheduledEvent guildScheduledEvent, long userId) {
        long id2 = guildScheduledEvent.getId();
        if (userId == this.userStore.getMeSnapshot().getId() && isMeRsvpedToEvent(guildScheduledEvent.getGuildId(), id2)) {
            return;
        }
        this.rsvpsAwaitingSnapshot.add(Long.valueOf(id2));
        addUserRsvpForEvent(userId, guildScheduledEvent.getGuildId(), id2);
        Integer userCount = guildScheduledEvent.getUserCount();
        GuildScheduledEvent guildScheduledEventA = GuildScheduledEvent.a(guildScheduledEvent, 0L, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf((userCount != null ? userCount.intValue() : 0) + 1), null, null, 229375);
        List<GuildScheduledEvent> list = this.guildScheduledEvents.get(Long.valueOf(guildScheduledEventA.getGuildId()));
        if (list != null) {
            m.checkNotNullExpressionValue(list, "eventList");
            Iterator<GuildScheduledEvent> it = list.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else {
                    if (it.next().getId() == id2) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
            if (i != -1) {
                list.set(i, guildScheduledEventA);
            } else {
                list.add(guildScheduledEventA);
            }
        } else {
            this.guildScheduledEvents.put(Long.valueOf(guildScheduledEvent.getGuildId()), n.mutableListOf(guildScheduledEventA));
        }
        markChanged();
    }

    @StoreThread
    private final void processRsvpDelete(GuildScheduledEvent guildScheduledEvent, long userId) {
        long id2 = guildScheduledEvent.getId();
        if (userId != this.userStore.getMeSnapshot().getId() || isMeRsvpedToEvent(guildScheduledEvent.getGuildId(), id2)) {
            this.rsvpsAwaitingSnapshot.add(Long.valueOf(id2));
            removeUserRsvpForEvent(userId, guildScheduledEvent.getGuildId(), id2);
            List<GuildScheduledEvent> list = this.guildScheduledEvents.get(Long.valueOf(guildScheduledEvent.getGuildId()));
            if (list != null) {
                m.checkNotNullExpressionValue(list, "eventList");
                Iterator<GuildScheduledEvent> it = list.iterator();
                int i = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i = -1;
                        break;
                    } else {
                        if (it.next().getId() == id2) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                Integer numValueOf = Integer.valueOf(i);
                if (!(numValueOf.intValue() != -1)) {
                    numValueOf = null;
                }
                if (numValueOf != null) {
                    int iIntValue = numValueOf.intValue();
                    Integer userCount = guildScheduledEvent.getUserCount();
                    list.set(iIntValue, GuildScheduledEvent.a(guildScheduledEvent, 0L, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(f.coerceAtLeast(0, userCount != null ? userCount.intValue() - 1 : 0)), null, null, 229375));
                }
            }
            markChanged();
        }
    }

    @StoreThread
    private final void removeMeRsvpForEvent(long guildId, long guildScheduledEventId) {
        Set<Long> set = this.meGuildScheduledEventIds.get(Long.valueOf(guildId));
        if (set != null) {
            set.remove(Long.valueOf(guildScheduledEventId));
        }
    }

    @StoreThread
    private final void removeUserRsvpForEvent(long userId, long guildId, long guildScheduledEventId) {
        if (userId == this.userStore.getMeSnapshot().getId() && isMeRsvpedToEvent(guildId, guildScheduledEventId)) {
            removeMeRsvpForEvent(guildId, guildScheduledEventId);
        }
        HashMap<Long, GuildScheduledEventUser> map = this.guildScheduledEventUsers.get(Long.valueOf(guildScheduledEventId));
        if (map != null) {
            map.remove(Long.valueOf(userId));
        }
    }

    public final void ackGuildEvents(long guildId) {
        Object next;
        List<GuildScheduledEvent> list = this.guildScheduledEvents.get(Long.valueOf(guildId));
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<T> it = list.iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                long id2 = ((GuildScheduledEvent) next).getId();
                do {
                    Object next2 = it.next();
                    long id3 = ((GuildScheduledEvent) next2).getId();
                    if (id2 < id3) {
                        next = next2;
                        id2 = id3;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        GuildScheduledEvent guildScheduledEvent = (GuildScheduledEvent) next;
        if (guildScheduledEvent != null) {
            Long l = this.lastAckedGuildScheduledEventIds.get(Long.valueOf(guildId));
            if (l == null || l.longValue() < guildScheduledEvent.getId()) {
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().postGuildFeatureAck(guildId, 1, guildScheduledEvent.getId(), new RestAPIParams$GuildFeatureAck(Boolean.FALSE, 0)), false, 1, null), (Context) null, "REST: guildFeatureAck", (Function1) null, new StoreGuildScheduledEvents$ackGuildEvents$1(this, guildScheduledEvent, guildId), (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
            }
        }
    }

    public final void addGuildScheduledEventFromInvite(GuildScheduledEvent guildScheduledEvent) {
        int i;
        m.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        long guildId = guildScheduledEvent.getGuildId();
        List<GuildScheduledEvent> list = this.guildScheduledEvents.get(Long.valueOf(guildId));
        if (list == null) {
            i = -1;
            break;
        }
        Iterator<GuildScheduledEvent> it = list.iterator();
        i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else {
                if (it.next().getId() == guildScheduledEvent.getId()) {
                    break;
                } else {
                    i++;
                }
            }
        }
        if (i == -1 && !this.guildScheduledEvents.containsKey(Long.valueOf(guildId))) {
            this.guildScheduledEvents.put(Long.valueOf(guildId), n.mutableListOf(guildScheduledEvent));
        } else if (i == -1) {
            ((List) h0.getValue(this.guildScheduledEvents, Long.valueOf(guildId))).add(guildScheduledEvent);
        } else {
            ((List) h0.getValue(this.guildScheduledEvents, Long.valueOf(guildId))).set(i, guildScheduledEvent);
        }
        if (guildScheduledEvent.getUserRsvp() != null) {
            addMeRsvpForEvent(guildId, guildScheduledEvent.getId());
        }
        markChanged();
    }

    @StoreThread
    public final void addMeRsvpsForEvent(List<Pair<Long, Long>> events) {
        m.checkNotNullParameter(events, "events");
        Iterator<T> it = events.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            addMeRsvpForEvent(((Number) pair.getFirst()).longValue(), ((Number) pair.getSecond()).longValue());
        }
        markChanged();
    }

    public final void fetchGuildScheduledEventUserCounts(long guildId) {
        List<GuildScheduledEvent> list = this.guildScheduledEvents.get(Long.valueOf(guildId));
        if (list == null || list.isEmpty()) {
            return;
        }
        Long l = this.guildScheduledEventsFetchTimestamps.get(Long.valueOf(guildId));
        if (l == null || this.clock.currentTimeMillis() - l.longValue() >= FETCH_GUILD_EVENTS_THRESHOLD) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().getGuildScheduledEvents(guildId, true), false, 1, null), StoreGuildScheduledEvents.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreGuildScheduledEvents$fetchGuildScheduledEventUserCounts$1(this, guildId), 62, (Object) null);
        }
    }

    public final void fetchGuildScheduledEventUsers(long guildId, long eventId) {
        this.dispatcher.schedule(new StoreGuildScheduledEvents$fetchGuildScheduledEventUsers$1(this, guildId, eventId));
    }

    public final void fetchMeGuildScheduledEvents(long guildId) {
        List<GuildScheduledEvent> list = this.guildScheduledEvents.get(Long.valueOf(guildId));
        if ((list == null || list.isEmpty()) || this.meGuildScheduledEventsFetches.contains(Long.valueOf(guildId))) {
            return;
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().getMeGuildScheduledEvents(guildId), false, 1, null), StoreGuildScheduledEvents.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreGuildScheduledEvents$fetchMeGuildScheduledEvents$1(this, guildId), 62, (Object) null);
    }

    public final GuildScheduledEvent getActiveEventForChannel(Long guildId, Long channelId) {
        Object obj = null;
        if (guildId == null || channelId == null) {
            return null;
        }
        for (Object obj2 : getGuildScheduledEvents$default(this, guildId.longValue(), false, 2, null)) {
            GuildScheduledEvent guildScheduledEvent = (GuildScheduledEvent) obj2;
            if (m.areEqual(guildScheduledEvent.getChannelId(), channelId) && guildScheduledEvent.getStatus() == GuildScheduledEventStatus.ACTIVE) {
                obj = obj2;
                break;
            }
        }
        return (GuildScheduledEvent) obj;
    }

    public final Map<Long, List<GuildScheduledEvent>> getAllGuildScheduledEvents() {
        return this.guildScheduledEventsSnapshot;
    }

    public final Map<Long, GuildScheduledEventUser> getGuildScheduledEventUsers(long eventId) {
        HashMap<Long, GuildScheduledEventUser> map = this.guildScheduledEventUsers.get(Long.valueOf(eventId));
        return map != null ? map : h0.emptyMap();
    }

    /* JADX WARN: Code duplicated, block: B:9:0x002e  */
    public final List<GuildScheduledEvent> getGuildScheduledEvents(long guildId, boolean filterInaccessible) {
        Map<Long, Long> permissionsByChannel = this.permissionsStore.getPermissionsByChannel();
        List<GuildScheduledEvent> list = this.guildScheduledEventsSnapshot.get(Long.valueOf(guildId));
        if (list == null) {
            return n.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            GuildScheduledEvent guildScheduledEvent = (GuildScheduledEvent) obj;
            boolean zCan = false;
            if (!filterInaccessible) {
                zCan = true;
            } else if (guildScheduledEvent.getStatus() != GuildScheduledEventStatus.COMPLETED) {
                if (guildScheduledEvent.getChannelId() == null) {
                    zCan = true;
                } else {
                    Long l = permissionsByChannel.get(guildScheduledEvent.getChannelId());
                    if (l != null) {
                        zCan = PermissionUtils.can(Permission.VIEW_CHANNEL, Long.valueOf(l.longValue()));
                    }
                }
            }
            if (zCan) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final boolean getIsFetchingGuildScheduledEventUsers() {
        return this.isFetchingGuildScheduledEventUsers;
    }

    public final boolean getIsGuildScheduledEventUsersError() {
        return this.isGuildScheduledEventUsersError;
    }

    public final Set<Long> getMeGuildScheduledEventIds(long guildId) {
        Set<Long> set = this.meGuildScheduledEventIdsSnapshot.get(Long.valueOf(guildId));
        return set != null ? set : n0.emptySet();
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        m.checkNotNullParameter(payload, "payload");
        this.guildScheduledEventsFetchTimestamps.clear();
        this.meGuildScheduledEventsFetches.clear();
        this.guildScheduledEventUsersFetches.clear();
        this.guildScheduledEvents.clear();
        this.meGuildScheduledEventIds.clear();
        List<Guild> guilds = payload.getGuilds();
        m.checkNotNullExpressionValue(guilds, "payload.guilds");
        Iterator<T> it = guilds.iterator();
        while (it.hasNext()) {
            List<GuildScheduledEvent> listO = ((Guild) it.next()).o();
            if (listO != null) {
                Iterator<T> it2 = listO.iterator();
                while (it2.hasNext()) {
                    processGuildScheduledEventCreateOrUpdate((GuildScheduledEvent) it2.next());
                }
            }
        }
        markChanged();
    }

    @StoreThread
    public final void handleGuildCreate(Guild guild) {
        m.checkNotNullParameter(guild, "guild");
        List<GuildScheduledEvent> listO = guild.o();
        if (listO != null) {
            Iterator<T> it = listO.iterator();
            while (it.hasNext()) {
                processGuildScheduledEventCreateOrUpdate((GuildScheduledEvent) it.next());
            }
        }
    }

    @StoreThread
    public final void handleGuildRemove(long guildId) {
        this.guildScheduledEvents.remove(Long.valueOf(guildId));
        this.guildScheduledEventsFetchTimestamps.remove(Long.valueOf(guildId));
        this.meGuildScheduledEventIds.remove(Long.valueOf(guildId));
        this.meGuildScheduledEventsFetches.remove(Long.valueOf(guildId));
        this.guildScheduledEventUsersFetches.remove(Long.valueOf(guildId));
        markChanged();
    }

    @StoreThread
    public final void handleGuildScheduledEventCreate(GuildScheduledEvent guildScheduledEvent) {
        m.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        processGuildScheduledEventCreateOrUpdate(guildScheduledEvent);
    }

    @StoreThread
    public final void handleGuildScheduledEventDelete(GuildScheduledEvent guildScheduledEvent) {
        List<GuildScheduledEvent> list;
        m.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        List<GuildScheduledEvent> list2 = this.guildScheduledEvents.get(Long.valueOf(guildScheduledEvent.getGuildId()));
        if (list2 != null) {
            Iterator<GuildScheduledEvent> it = list2.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else {
                    if (it.next().getId() == guildScheduledEvent.getId()) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
            if (i != -1 && (list = this.guildScheduledEvents.get(Long.valueOf(guildScheduledEvent.getGuildId()))) != null) {
                list.remove(i);
            }
            removeMeRsvpForEvent(guildScheduledEvent.getGuildId(), guildScheduledEvent.getId());
            markChanged();
        }
    }

    @StoreThread
    public final void handleGuildScheduledEventUpdate(GuildScheduledEvent guildScheduledEvent) {
        m.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        processGuildScheduledEventCreateOrUpdate(guildScheduledEvent);
    }

    @StoreThread
    public final void handleGuildScheduledEventUserAdd(GuildScheduledEventUserUpdate guildScheduledEventUserUpdate) {
        m.checkNotNullParameter(guildScheduledEventUserUpdate, "guildScheduledEventUserUpdate");
        GuildScheduledEvent guildScheduledEventFindEventFromStore$default = findEventFromStore$default(this, guildScheduledEventUserUpdate.getGuildScheduledEventId(), null, 2, null);
        if (guildScheduledEventFindEventFromStore$default != null) {
            processRsvpCreate(guildScheduledEventFindEventFromStore$default, guildScheduledEventUserUpdate.getUserId());
        }
    }

    @StoreThread
    public final void handleGuildScheduledEventUserRemove(GuildScheduledEventUserUpdate guildScheduledEventUserUpdate) {
        m.checkNotNullParameter(guildScheduledEventUserUpdate, "guildScheduledEventUserUpdate");
        GuildScheduledEvent guildScheduledEventFindEventFromStore$default = findEventFromStore$default(this, guildScheduledEventUserUpdate.getGuildScheduledEventId(), null, 2, null);
        if (guildScheduledEventFindEventFromStore$default != null) {
            processRsvpDelete(guildScheduledEventFindEventFromStore$default, guildScheduledEventUserUpdate.getUserId());
        }
    }

    public final boolean isMeRsvpedToEvent(long guildId, long guildScheduledEventId) {
        Set<Long> setEmptySet = this.meGuildScheduledEventIdsSnapshot.get(Long.valueOf(guildId));
        if (setEmptySet == null) {
            setEmptySet = n0.emptySet();
        }
        return setEmptySet.contains(Long.valueOf(guildScheduledEventId));
    }

    public final Observable<GuildScheduledEvent> observeGuildScheduledEvent(Long eventId, Long guildId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreGuildScheduledEvents$observeGuildScheduledEvent$1(this, eventId, guildId), 14, null);
    }

    public final Observable<List<GuildScheduledEvent>> observeGuildScheduledEvents(long guildId, boolean filterInaccessible) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreGuildScheduledEvents$observeGuildScheduledEvents$1(this, guildId, filterInaccessible), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.guildScheduledEventsSnapshot = new HashMap(this.guildScheduledEvents);
        this.meGuildScheduledEventIdsSnapshot = new HashMap(this.meGuildScheduledEventIds);
        this.guildScheduledEventUsersSnapshot = new HashMap(this.guildScheduledEventUsers);
        this.rsvpsAwaitingSnapshot.clear();
    }

    public final void toggleMeRsvpForEvent(GuildScheduledEvent guildScheduledEvent) {
        m.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        GuildScheduledEvent guildScheduledEventFindEventFromStore = findEventFromStore(guildScheduledEvent);
        long id2 = guildScheduledEventFindEventFromStore.getId();
        if (this.rsvpsAwaitingNetwork.contains(Long.valueOf(id2)) || this.rsvpsAwaitingSnapshot.contains(Long.valueOf(id2))) {
            return;
        }
        this.rsvpsAwaitingNetwork.add(Long.valueOf(id2));
        this.dispatcher.schedule(new StoreGuildScheduledEvents$toggleMeRsvpForEvent$1(this, guildScheduledEvent, id2, guildScheduledEventFindEventFromStore));
    }

    public final GuildScheduledEvent findEventFromStore(long eventId, Long guildId) {
        GuildScheduledEvent guildScheduledEvent;
        Object next;
        Object obj = null;
        if (guildId != null) {
            List<GuildScheduledEvent> list = this.guildScheduledEventsSnapshot.get(Long.valueOf(guildId.longValue()));
            if (list != null) {
                Iterator<T> it = list.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!(eventId == ((GuildScheduledEvent) next).getId()));
                guildScheduledEvent = (GuildScheduledEvent) next;
            } else {
                guildScheduledEvent = null;
            }
            if (guildScheduledEvent != null) {
                return guildScheduledEvent;
            }
        }
        for (Object obj2 : o.flatten(this.guildScheduledEventsSnapshot.values())) {
            if (eventId == ((GuildScheduledEvent) obj2).getId()) {
                obj = obj2;
                break;
            }
        }
        return (GuildScheduledEvent) obj;
    }
}
