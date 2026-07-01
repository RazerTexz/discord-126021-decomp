package com.discord.widgets.stage;

import com.discord.api.stageinstance.StageInstance;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStageInstances;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import d0.f0.q;
import d0.t.i0;
import d0.z.d.m;
import java.util.Map;
import java.util.Set;
import rx.Observable;

/* JADX INFO: compiled from: GuildIdsWithVisibleStageInstanceModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildIdsWithVisibleStageInstanceModel {
    public static final GuildIdsWithVisibleStageInstanceModel INSTANCE = new GuildIdsWithVisibleStageInstanceModel();

    private GuildIdsWithVisibleStageInstanceModel() {
    }

    public static /* synthetic */ Observable observe$default(GuildIdsWithVisibleStageInstanceModel guildIdsWithVisibleStageInstanceModel, StoreStageInstances storeStageInstances, StorePermissions storePermissions, ObservationDeck observationDeck, int i, Object obj) {
        if ((i & 1) != 0) {
            storeStageInstances = StoreStream.Companion.getStageInstances();
        }
        if ((i & 2) != 0) {
            storePermissions = StoreStream.Companion.getPermissions();
        }
        if ((i & 4) != 0) {
            observationDeck = ObservationDeckProvider.get();
        }
        return guildIdsWithVisibleStageInstanceModel.observe(storeStageInstances, storePermissions, observationDeck);
    }

    public final Set<Long> compute(Map<Long, ? extends Map<Long, StageInstance>> instancesByGuild, Map<Long, Long> permissionsByChannel) {
        m.checkNotNullParameter(instancesByGuild, "instancesByGuild");
        m.checkNotNullParameter(permissionsByChannel, "permissionsByChannel");
        return q.toSet(q.map(q.filter(i0.asSequence(instancesByGuild), new GuildIdsWithVisibleStageInstanceModel$compute$1(permissionsByChannel)), GuildIdsWithVisibleStageInstanceModel$compute$2.INSTANCE));
    }

    public final Observable<Set<Long>> observe(StoreStageInstances storeStageInstances, StorePermissions storePermissions, ObservationDeck observationDeck) {
        m.checkNotNullParameter(storeStageInstances, "storeStageInstances");
        m.checkNotNullParameter(storePermissions, "storePermissions");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck$UpdateSource[]{storeStageInstances, storePermissions}, false, null, null, new GuildIdsWithVisibleStageInstanceModel$observe$1(storeStageInstances, storePermissions), 14, null);
    }
}
