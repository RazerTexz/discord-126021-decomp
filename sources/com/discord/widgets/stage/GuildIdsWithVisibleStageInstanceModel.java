package com.discord.widgets.stage;

import com.discord.api.permission.Permission;
import com.discord.api.stageinstance.StageInstance;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStageInstances;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.permissions.PermissionUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p578f0.C12078q;
import p507d0.p580t.C12138i0;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;

/* JADX INFO: compiled from: GuildIdsWithVisibleStageInstanceModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildIdsWithVisibleStageInstanceModel {
    public static final GuildIdsWithVisibleStageInstanceModel INSTANCE = new GuildIdsWithVisibleStageInstanceModel();

    /* JADX INFO: renamed from: com.discord.widgets.stage.GuildIdsWithVisibleStageInstanceModel$compute$1 */
    /* JADX INFO: compiled from: GuildIdsWithVisibleStageInstanceModel.kt */
    public static final class C100011 extends AbstractC12240o implements Function1<Map.Entry<? extends Long, ? extends Map<Long, ? extends StageInstance>>, Boolean> {
        public final /* synthetic */ Map $permissionsByChannel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C100011(Map map) {
            super(1);
            this.$permissionsByChannel = map;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Map.Entry<? extends Long, ? extends Map<Long, ? extends StageInstance>> entry) {
            return Boolean.valueOf(invoke2((Map.Entry<Long, ? extends Map<Long, StageInstance>>) entry));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(Map.Entry<Long, ? extends Map<Long, StageInstance>> entry) {
            int i;
            C12238m.checkNotNullParameter(entry, "<name for destructuring parameter 0>");
            entry.getKey().longValue();
            Set<Long> setKeySet = entry.getValue().keySet();
            if ((setKeySet instanceof Collection) && setKeySet.isEmpty()) {
                i = 0;
            } else {
                Iterator<T> it = setKeySet.iterator();
                i = 0;
                while (it.hasNext()) {
                    if (PermissionUtils.can(Permission.VIEW_CHANNEL, (Long) this.$permissionsByChannel.get(Long.valueOf(((Number) it.next()).longValue()))) && (i = i + 1) < 0) {
                        C12147n.throwCountOverflow();
                    }
                }
            }
            return i > 0;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.GuildIdsWithVisibleStageInstanceModel$compute$2 */
    /* JADX INFO: compiled from: GuildIdsWithVisibleStageInstanceModel.kt */
    public static final class C100022 extends AbstractC12240o implements Function1<Map.Entry<? extends Long, ? extends Map<Long, ? extends StageInstance>>, Long> {
        public static final C100022 INSTANCE = new C100022();

        public C100022() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Long invoke(Map.Entry<? extends Long, ? extends Map<Long, ? extends StageInstance>> entry) {
            return Long.valueOf(invoke2((Map.Entry<Long, ? extends Map<Long, StageInstance>>) entry));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final long invoke2(Map.Entry<Long, ? extends Map<Long, StageInstance>> entry) {
            C12238m.checkNotNullParameter(entry, "entry");
            return entry.getKey().longValue();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.GuildIdsWithVisibleStageInstanceModel$observe$1 */
    /* JADX INFO: compiled from: GuildIdsWithVisibleStageInstanceModel.kt */
    public static final class C100031 extends AbstractC12240o implements Function0<Set<? extends Long>> {
        public final /* synthetic */ StorePermissions $storePermissions;
        public final /* synthetic */ StoreStageInstances $storeStageInstances;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C100031(StoreStageInstances storeStageInstances, StorePermissions storePermissions) {
            super(0);
            this.$storeStageInstances = storeStageInstances;
            this.$storePermissions = storePermissions;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Set<? extends Long> invoke() {
            return GuildIdsWithVisibleStageInstanceModel.INSTANCE.compute(this.$storeStageInstances.getStageInstancesByGuild(), this.$storePermissions.getPermissionsByChannel());
        }
    }

    private GuildIdsWithVisibleStageInstanceModel() {
    }

    public static /* synthetic */ Observable observe$default(GuildIdsWithVisibleStageInstanceModel guildIdsWithVisibleStageInstanceModel, StoreStageInstances storeStageInstances, StorePermissions storePermissions, ObservationDeck observationDeck, int i, Object obj) {
        if ((i & 1) != 0) {
            storeStageInstances = StoreStream.INSTANCE.getStageInstances();
        }
        if ((i & 2) != 0) {
            storePermissions = StoreStream.INSTANCE.getPermissions();
        }
        if ((i & 4) != 0) {
            observationDeck = ObservationDeckProvider.get();
        }
        return guildIdsWithVisibleStageInstanceModel.observe(storeStageInstances, storePermissions, observationDeck);
    }

    public final Set<Long> compute(Map<Long, ? extends Map<Long, StageInstance>> instancesByGuild, Map<Long, Long> permissionsByChannel) {
        C12238m.checkNotNullParameter(instancesByGuild, "instancesByGuild");
        C12238m.checkNotNullParameter(permissionsByChannel, "permissionsByChannel");
        return C12078q.toSet(C12078q.map(C12078q.filter(C12138i0.asSequence(instancesByGuild), new C100011(permissionsByChannel)), C100022.INSTANCE));
    }

    public final Observable<Set<Long>> observe(StoreStageInstances storeStageInstances, StorePermissions storePermissions, ObservationDeck observationDeck) {
        C12238m.checkNotNullParameter(storeStageInstances, "storeStageInstances");
        C12238m.checkNotNullParameter(storePermissions, "storePermissions");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{storeStageInstances, storePermissions}, false, null, null, new C100031(storeStageInstances, storePermissions), 14, null);
    }
}
