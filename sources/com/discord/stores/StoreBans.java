package com.discord.stores;

import com.discord.models.domain.ModelBan;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: StoreBans.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreBans extends StoreV2 {
    private final HashMap<Long, HashMap<Long, ModelBan>> bannedUsers;
    private HashMap<Long, HashMap<Long, ModelBan>> bannedUsersSnapshot;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;

    /* JADX INFO: renamed from: com.discord.stores.StoreBans$observeBans$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreBans.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends ModelBan>, Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX INFO: renamed from: com.discord.stores.StoreBans$observeBans$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreBans.kt */
        public static final class C00941 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ List $bans;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00941(List list) {
                super(0);
                this.$bans = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                HashMap map = StoreBans.this.bannedUsers;
                Long lValueOf = Long.valueOf(AnonymousClass1.this.$guildId);
                Object map2 = map.get(lValueOf);
                if (map2 == null) {
                    map2 = new HashMap();
                    map.put(lValueOf, map2);
                }
                HashMap map3 = (HashMap) map2;
                for (ModelBan modelBan : this.$bans) {
                    map3.put(Long.valueOf(modelBan.getUser().getId()), modelBan);
                }
                StoreBans.this.markChanged();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelBan> list) {
            invoke2(list);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends ModelBan> list) {
            Intrinsics3.checkNotNullParameter(list, "bans");
            StoreBans.this.dispatcher.schedule(new C00941(list));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreBans$observeBans$2, reason: invalid class name */
    /* JADX INFO: compiled from: StoreBans.kt */
    public static final class AnonymousClass2 extends Lambda implements Function0<Map<Long, ? extends ModelBan>> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends ModelBan> invoke() {
            return (Map) StoreBans.this.bannedUsersSnapshot.get(Long.valueOf(this.$guildId));
        }
    }

    public StoreBans(Dispatcher dispatcher, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.bannedUsers = new HashMap<>();
        this.bannedUsersSnapshot = new HashMap<>();
    }

    @Store3
    public final void handleBanAdd(ModelBan ban) {
        Intrinsics3.checkNotNullParameter(ban, "ban");
        if (this.bannedUsers.get(Long.valueOf(ban.getGuildId())) != null) {
            HashMap<Long, ModelBan> map = this.bannedUsers.get(Long.valueOf(ban.getGuildId()));
            if (map != null) {
                map.put(Long.valueOf(ban.getUser().getId()), ban);
            }
            markChanged();
        }
    }

    @Store3
    public final void handleBanRemove(ModelBan ban) {
        Intrinsics3.checkNotNullParameter(ban, "ban");
        if (this.bannedUsers.get(Long.valueOf(ban.getGuildId())) != null) {
            HashMap<Long, ModelBan> map = this.bannedUsers.get(Long.valueOf(ban.getGuildId()));
            if (map != null) {
                map.remove(Long.valueOf(ban.getUser().getId()));
            }
            markChanged();
        }
    }

    public final Observable<Map<Long, ModelBan>> observeBans(long guildId) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getBans(guildId), false, 1, null), (Class<?>) StoreBans.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(guildId));
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass2(guildId), 14, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        HashMap<Long, HashMap<Long, ModelBan>> map = new HashMap<>(this.bannedUsers);
        Iterator<T> it = this.bannedUsers.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            map.put(entry.getKey(), new HashMap((HashMap) entry.getValue()));
        }
        this.bannedUsersSnapshot = map;
    }
}
