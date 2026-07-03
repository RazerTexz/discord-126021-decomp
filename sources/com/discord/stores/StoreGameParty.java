package com.discord.stores;

import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityParty;
import com.discord.api.guild.Guild;
import com.discord.api.presence.ClientStatus;
import com.discord.api.presence.Presence;
import com.discord.api.thread.AugmentedThreadMember;
import com.discord.api.thread.ThreadListMember;
import com.discord.api.thread.ThreadMemberListUpdate;
import com.discord.api.thread.ThreadMembersUpdate;
import com.discord.models.domain.ModelPayload;
import com.discord.models.user.User;
import com.discord.stores.updates.ObservationDeck;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;
import kotlin.jvm.functions.Function0;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;

/* JADX INFO: compiled from: StoreGameParty.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGameParty extends StoreV2 {
    private final ObservationDeck observationDeck;
    private final HashMap<String, HashSet<Long>> parties;
    private HashMap<String, HashSet<Long>> partiesSnapshot;
    private final StoreUser storeUser;
    private final StoreUserPresence storeUserPresence;
    private final HashMap<Long, HashMap<Long, String>> userParties;

    /* JADX INFO: renamed from: com.discord.stores.StoreGameParty$observeUsersForPartyId$1 */
    /* JADX INFO: compiled from: StoreGameParty.kt */
    public static final class C59421 extends AbstractC12240o implements Function0<Map<Long, ? extends User>> {
        public final /* synthetic */ String $partyId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59421(String str) {
            super(0);
            this.$partyId = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends User> invoke() {
            List listEmptyList;
            HashSet hashSet = (HashSet) StoreGameParty.this.partiesSnapshot.get(this.$partyId);
            StoreUser storeUser = StoreGameParty.this.getStoreUser();
            if (hashSet == null || (listEmptyList = C12163u.toList(hashSet)) == null) {
                listEmptyList = C12147n.emptyList();
            }
            SortedMap sortedMap = C12134g0.toSortedMap(storeUser.getUsers(listEmptyList, false));
            Objects.requireNonNull(sortedMap, "null cannot be cast to non-null type kotlin.collections.Map<com.discord.primitives.UserId /* = kotlin.Long */, com.discord.models.user.User>");
            return sortedMap;
        }
    }

    public StoreGameParty(ObservationDeck observationDeck, StoreUserPresence storeUserPresence, StoreUser storeUser) {
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        C12238m.checkNotNullParameter(storeUserPresence, "storeUserPresence");
        C12238m.checkNotNullParameter(storeUser, "storeUser");
        this.observationDeck = observationDeck;
        this.storeUserPresence = storeUserPresence;
        this.storeUser = storeUser;
        this.userParties = new HashMap<>();
        this.parties = new HashMap<>();
        this.partiesSnapshot = new HashMap<>();
    }

    @StoreThread
    private final void addUserToParty(long userId, long guildId, String partyId) {
        if (partyId != null) {
            if (guildId > 0) {
                HashMap<Long, HashMap<Long, String>> map = this.userParties;
                Long lValueOf = Long.valueOf(userId);
                HashMap<Long, String> map2 = map.get(lValueOf);
                if (map2 == null) {
                    map2 = new HashMap<>();
                    map.put(lValueOf, map2);
                }
                map2.put(Long.valueOf(guildId), partyId);
            }
            HashSet<Long> hashSet = this.parties.get(partyId);
            HashSet<Long> hashSet2 = hashSet != null ? new HashSet<>(hashSet) : new HashSet<>();
            hashSet2.add(Long.valueOf(userId));
            this.parties.put(partyId, hashSet2);
            markChanged();
        }
    }

    public static /* synthetic */ void handlePresenceUpdate$default(StoreGameParty storeGameParty, Presence presence, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            Long guildId = presence.getGuildId();
            j = guildId != null ? guildId.longValue() : 0L;
        }
        storeGameParty.handlePresenceUpdate(presence, j);
    }

    @StoreThread
    private final void handlePresences(List<Presence> presences) {
        for (Presence presence : presences) {
            Long guildId = presence.getGuildId();
            updateParty(presence, guildId != null ? guildId.longValue() : 0L);
        }
    }

    @StoreThread
    private final void removeUserFromParty(long userId, long guildId) {
        String strRemove;
        HashMap<Long, String> map = this.userParties.get(Long.valueOf(userId));
        if (map == null || (strRemove = map.remove(Long.valueOf(guildId))) == null) {
            return;
        }
        C12238m.checkNotNullExpressionValue(strRemove, "userParties[userId]?.remove(guildId) ?: return");
        HashSet<Long> hashSet = this.parties.get(strRemove);
        if (hashSet != null) {
            if (hashSet.size() != 1) {
                HashMap<String, HashSet<Long>> map2 = this.parties;
                HashSet<Long> hashSet2 = new HashSet<>(hashSet);
                hashSet2.remove(Long.valueOf(userId));
                map2.put(strRemove, hashSet2);
            } else {
                this.parties.remove(strRemove);
            }
        }
        markChanged();
    }

    @StoreThread
    private final void updateParty(Presence presence, long guildId) {
        List<Activity> listEmptyList;
        boolean z2;
        Object next;
        ActivityParty party;
        ActivityParty party2;
        com.discord.api.user.User user = presence.getUser();
        if (user != null) {
            HashMap<Long, String> map = this.userParties.get(Long.valueOf(user.getId()));
            String id2 = null;
            String str = map != null ? map.get(Long.valueOf(guildId)) : null;
            Map<Long, com.discord.models.presence.Presence> mapM11396getPresences = this.storeUserPresence.m11396getPresences();
            com.discord.api.user.User user2 = presence.getUser();
            com.discord.models.presence.Presence presence2 = mapM11396getPresences.get(user2 != null ? Long.valueOf(user2.getId()) : null);
            if (presence2 == null || (listEmptyList = presence2.getActivities()) == null) {
                listEmptyList = C12147n.emptyList();
            }
            Iterator<T> it = listEmptyList.iterator();
            do {
                z2 = false;
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    party2 = ((Activity) next).getParty();
                }
            } while (!((party2 != null ? party2.getId() : null) != null));
            Activity activity = (Activity) next;
            if (activity != null && (party = activity.getParty()) != null) {
                id2 = party.getId();
            }
            String str2 = id2;
            if (str2 != null && presence.getStatus() != ClientStatus.OFFLINE) {
                z2 = true;
            }
            if (!z2) {
                removeUserFromParty(user.getId(), guildId);
                return;
            }
            if (!C12238m.areEqual(str, str2)) {
                removeUserFromParty(user.getId(), guildId);
            }
            addUserToParty(user.getId(), guildId, str2);
        }
    }

    public final ObservationDeck getObservationDeck() {
        return this.observationDeck;
    }

    public final StoreUser getStoreUser() {
        return this.storeUser;
    }

    public final StoreUserPresence getStoreUserPresence() {
        return this.storeUserPresence;
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        C12238m.checkNotNullParameter(payload, "payload");
        List<Presence> presences = payload.getPresences();
        if (presences != null) {
            handlePresences(presences);
        }
        List<Guild> guilds = payload.getGuilds();
        C12238m.checkNotNullExpressionValue(guilds, "payload.guilds");
        Iterator<T> it = guilds.iterator();
        while (it.hasNext()) {
            handleGuildCreateOrSync((Guild) it.next());
        }
    }

    @StoreThread
    public final void handleGuildCreateOrSync(Guild guild) {
        C12238m.checkNotNullParameter(guild, "guild");
        List<Presence> listM7839D = guild.m7839D();
        if (listM7839D != null) {
            handlePresences(listM7839D);
        }
    }

    @StoreThread
    public final void handlePresenceReplace(List<Presence> presences) {
        C12238m.checkNotNullParameter(presences, "presences");
        handlePresences(presences);
    }

    @StoreThread
    public final void handlePresenceUpdate(Presence presence) {
        handlePresenceUpdate$default(this, presence, 0L, 2, null);
    }

    @StoreThread
    public final void handlePresenceUpdate(Presence presence, long guildId) {
        C12238m.checkNotNullParameter(presence, "presence");
        updateParty(presence, guildId);
    }

    @StoreThread
    public final void handleThreadMemberListUpdate(ThreadMemberListUpdate threadMemberListUpdate) {
        C12238m.checkNotNullParameter(threadMemberListUpdate, "threadMemberListUpdate");
        List<ThreadListMember> listM8266b = threadMemberListUpdate.m8266b();
        if (listM8266b != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = listM8266b.iterator();
            while (it.hasNext()) {
                Presence presence = ((ThreadListMember) it.next()).getPresence();
                if (presence != null) {
                    arrayList.add(presence);
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                updateParty((Presence) it2.next(), threadMemberListUpdate.getGuildId());
            }
        }
    }

    @StoreThread
    public final void handleThreadMembersUpdate(ThreadMembersUpdate threadMembersUpdate) {
        C12238m.checkNotNullParameter(threadMembersUpdate, "threadMembersUpdate");
        List<AugmentedThreadMember> listM8275a = threadMembersUpdate.m8275a();
        if (listM8275a != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = listM8275a.iterator();
            while (it.hasNext()) {
                Presence presence = ((AugmentedThreadMember) it.next()).getPresence();
                if (presence != null) {
                    arrayList.add(presence);
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                updateParty((Presence) it2.next(), threadMembersUpdate.getGuildId());
            }
        }
    }

    public final Observable<Map<Long, User>> observeUsersForPartyId(String partyId) {
        Observable<Map<Long, User>> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this, StoreUser.INSTANCE.getUsersUpdate()}, false, null, null, new C59421(partyId), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableM11112r;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        this.partiesSnapshot = new HashMap<>();
        for (Map.Entry<String, HashSet<Long>> entry : this.parties.entrySet()) {
            this.partiesSnapshot.put(entry.getKey(), new HashSet<>(entry.getValue()));
        }
    }
}
