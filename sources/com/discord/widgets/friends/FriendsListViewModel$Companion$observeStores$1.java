package com.discord.widgets.friends;

import androidx.core.app.NotificationCompat;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.stores.StoreApplicationStreaming;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreContactSync;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreFriendSuggestions;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserConnections;
import com.discord.stores.StoreUserConnections$State;
import com.discord.stores.StoreUserPresence;
import com.discord.stores.StoreUserRelationships;
import com.discord.stores.StoreUserRelationships$UserRelationshipsState;
import com.discord.utilities.collections.SnowflakePartitionMap$CopiablePartitionMap;
import d0.t.h0;
import d0.z.d.m;
import j0.k.b;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;

/* JADX INFO: compiled from: FriendsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FriendsListViewModel$Companion$observeStores$1<T, R> implements b<Unit, FriendsListViewModel$StoreState> {
    public final /* synthetic */ StoreApplicationStreaming $storeApplicationStreaming;
    public final /* synthetic */ StoreChannelsSelected $storeChannelsSelected;
    public final /* synthetic */ StoreContactSync $storeContactSync;
    public final /* synthetic */ StoreExperiments $storeExperiments;
    public final /* synthetic */ StoreFriendSuggestions $storeFriendSuggestions;
    public final /* synthetic */ StoreUserPresence $storePresences;
    public final /* synthetic */ StoreUserConnections $storeUserConnections;
    public final /* synthetic */ StoreUserRelationships $storeUserRelationships;
    public final /* synthetic */ StoreUser $storeUsers;

    public FriendsListViewModel$Companion$observeStores$1(StoreChannelsSelected storeChannelsSelected, StoreUserPresence storeUserPresence, StoreUser storeUser, StoreUserRelationships storeUserRelationships, StoreApplicationStreaming storeApplicationStreaming, StoreUserConnections storeUserConnections, StoreExperiments storeExperiments, StoreContactSync storeContactSync, StoreFriendSuggestions storeFriendSuggestions) {
        this.$storeChannelsSelected = storeChannelsSelected;
        this.$storePresences = storeUserPresence;
        this.$storeUsers = storeUser;
        this.$storeUserRelationships = storeUserRelationships;
        this.$storeApplicationStreaming = storeApplicationStreaming;
        this.$storeUserConnections = storeUserConnections;
        this.$storeExperiments = storeExperiments;
        this.$storeContactSync = storeContactSync;
        this.$storeFriendSuggestions = storeFriendSuggestions;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ FriendsListViewModel$StoreState call(Unit unit) {
        return call2(unit);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final FriendsListViewModel$StoreState call2(Unit unit) {
        boolean z2;
        boolean z3;
        long id2 = this.$storeChannelsSelected.getId();
        SnowflakePartitionMap$CopiablePartitionMap<Presence> presences = this.$storePresences.getPresences();
        Map<Long, User> users = this.$storeUsers.getUsers();
        StoreUserRelationships$UserRelationshipsState relationshipsStateSnapshot = this.$storeUserRelationships.getRelationshipsStateSnapshot();
        Map<Long, ModelApplicationStream> streamsByUser = this.$storeApplicationStreaming.getStreamsByUser();
        StoreUserConnections$State stateSnapshot = this.$storeUserConnections.getStateSnapshot();
        boolean z4 = stateSnapshot instanceof Collection;
        if (!z4 || !stateSnapshot.isEmpty()) {
            Iterator<ConnectedAccount> it = stateSnapshot.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                if (m.areEqual(it.next().getType(), "contacts")) {
                    z2 = true;
                    break;
                }
            }
        } else {
            z2 = false;
            break;
        }
        if (!z4 || !stateSnapshot.isEmpty()) {
            Iterator<ConnectedAccount> it2 = stateSnapshot.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z3 = false;
                    break;
                }
                ConnectedAccount next = it2.next();
                if (m.areEqual(next.getType(), "contacts") && next.getFriendSync()) {
                    z3 = true;
                    break;
                }
            }
        } else {
            z3 = false;
            break;
        }
        Experiment userExperiment = this.$storeExperiments.getUserExperiment("2021-04_contact_sync_android_main", !z2);
        boolean z5 = (userExperiment == null || userExperiment.getBucket() != 1 || z2) ? false : true;
        boolean z6 = !this.$storeContactSync.getFriendsListUpsellDismissed() && (userExperiment != null && userExperiment.getBucket() == 1 && !z3);
        return new FriendsListViewModel$StoreState(z5 && !z6, z6, id2, relationshipsStateSnapshot, users, presences, streamsByUser, (userExperiment == null || userExperiment.getBucket() != 1) ? h0.emptyMap() : this.$storeFriendSuggestions.getFriendSuggestions());
    }
}
