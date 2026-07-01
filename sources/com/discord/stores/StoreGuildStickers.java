package com.discord.stores;

import com.discord.api.guild.Guild;
import com.discord.api.guildmember.GuildMember;
import com.discord.api.sticker.GuildStickersUpdate;
import com.discord.api.sticker.Sticker;
import com.discord.api.sticker.StickerType;
import com.discord.models.domain.ModelPayload;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import d0.d0._Ranges;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StoreGuildStickers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildStickers extends StoreV2 {
    private final Map<Long, Map<Long, Sticker>> allGuildStickers;
    private List<Sticker> allGuildStickersFlattenedSnapshot;
    private Map<Long, ? extends Map<Long, Sticker>> allGuildStickersSnapshot;
    private final Dispatcher dispatcher;
    private long me;
    private final ObservationDeck observationDeck;
    private final Function1<List<Long>, Unit> onStickersDeleted;

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildStickers$handleFetchedSticker$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildStickers.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ Sticker $sticker;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, Sticker sticker) {
            super(0);
            this.$guildId = j;
            this.$sticker = sticker;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Map mapEmptyMap = (Map) StoreGuildStickers.this.allGuildStickers.get(Long.valueOf(this.$guildId));
            if (mapEmptyMap == null) {
                mapEmptyMap = Maps6.emptyMap();
            }
            linkedHashMap.putAll(mapEmptyMap);
            linkedHashMap.put(Long.valueOf(this.$sticker.getId()), this.$sticker);
            StoreGuildStickers.this.allGuildStickers.put(Long.valueOf(this.$guildId), linkedHashMap);
            StoreGuildStickers.this.markChanged();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildStickers$observeGuildStickers$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildStickers.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends Map<Long, ? extends Sticker>>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends Map<Long, ? extends Sticker>> invoke() {
            return StoreGuildStickers.this.allGuildStickersSnapshot;
        }
    }

    public /* synthetic */ StoreGuildStickers(Dispatcher dispatcher, ObservationDeck observationDeck, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeck4.get() : observationDeck, function1);
    }

    private final void updateStickers(long guildId, Collection<Sticker> stickers) {
        if (stickers.isEmpty()) {
            this.allGuildStickers.remove(Long.valueOf(guildId));
        } else {
            Map<Long, Map<Long, Sticker>> map = this.allGuildStickers;
            Long lValueOf = Long.valueOf(guildId);
            LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(stickers, 10)), 16));
            for (Object obj : stickers) {
                linkedHashMap.put(Long.valueOf(((Sticker) obj).getId()), obj);
            }
            map.put(lValueOf, linkedHashMap);
        }
        markChanged();
    }

    public final Map<Long, Map<Long, Sticker>> getAllGuildStickers() {
        return this.allGuildStickersSnapshot;
    }

    public final List<Sticker> getAllGuildStickersFlattened() {
        return this.allGuildStickersFlattenedSnapshot;
    }

    @Store3
    public final Map<Long, Map<Long, Sticker>> getAllGuildStickersInternal() {
        return this.allGuildStickers;
    }

    public final Sticker getGuildSticker(long stickerId) {
        Object next;
        Iterator<T> it = getAllGuildStickers().values().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((Map) next).containsKey(Long.valueOf(stickerId)));
        Map map = (Map) next;
        if (map != null) {
            return (Sticker) map.get(Long.valueOf(stickerId));
        }
        return null;
    }

    public final Map<Long, Sticker> getStickersForGuild(long guildId) {
        Map<Long, Sticker> map = getAllGuildStickers().get(Long.valueOf(guildId));
        return map != null ? map : Maps6.emptyMap();
    }

    @Store3
    public final Map<Long, Sticker> getStickersForGuildInternal(long guildId) {
        return this.allGuildStickers.get(Long.valueOf(guildId));
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        this.me = payload.getMe().getId();
        for (Guild guild : payload.getGuilds()) {
            Intrinsics3.checkNotNullExpressionValue(guild, "guild");
            handleGuildCreateOrUpdate(guild);
        }
    }

    public final void handleFetchedSticker(Sticker sticker) {
        Long guildId;
        if (sticker == null || sticker.getType() != StickerType.GUILD || (guildId = sticker.getGuildId()) == null) {
            return;
        }
        this.dispatcher.schedule(new AnonymousClass1(guildId.longValue(), sticker));
    }

    @Store3
    public final Unit handleGuildCreateOrUpdate(Guild guild) {
        Object next;
        Intrinsics3.checkNotNullParameter(guild, "guild");
        List<GuildMember> listV = guild.v();
        if (listV == null) {
            return null;
        }
        Iterator<T> it = listV.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(((GuildMember) next).getUser().getId() == this.me));
        if (((GuildMember) next) == null) {
            return null;
        }
        long id2 = guild.getId();
        List<Sticker> listK = guild.K();
        if (listK == null) {
            listK = Collections2.emptyList();
        }
        updateStickers(id2, listK);
        return Unit.a;
    }

    @Store3
    public final void handleGuildRemove(long guildId) {
        if (this.allGuildStickers.containsKey(Long.valueOf(guildId))) {
            this.allGuildStickers.remove(Long.valueOf(guildId));
            markChanged();
        }
    }

    @Store3
    public final void handleStickerUpdate(GuildStickersUpdate stickersUpdate) {
        Collection collectionEmptyList;
        Intrinsics3.checkNotNullParameter(stickersUpdate, "stickersUpdate");
        long guildId = stickersUpdate.getGuildId();
        List<Sticker> listC = stickersUpdate.c();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listC, 10));
        Iterator<T> it = listC.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((Sticker) it.next()).getId()));
        }
        Set set = _Collections.toSet(arrayList);
        Map<Long, Sticker> map = this.allGuildStickersSnapshot.get(Long.valueOf(guildId));
        if (map != null) {
            collectionEmptyList = new ArrayList(map.size());
            Iterator<Map.Entry<Long, Sticker>> it2 = map.entrySet().iterator();
            while (it2.hasNext()) {
                collectionEmptyList.add(Long.valueOf(it2.next().getKey().longValue()));
            }
        } else {
            collectionEmptyList = Collections2.emptyList();
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : collectionEmptyList) {
            if (!set.contains(Long.valueOf(((Number) obj).longValue()))) {
                arrayList2.add(obj);
            }
        }
        updateStickers(guildId, listC);
        this.onStickersDeleted.invoke(arrayList2);
    }

    public final Observable<Map<Long, Map<Long, Sticker>>> observeGuildStickers() {
        Observable<Map<Long, Map<Long, Sticker>>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Long, Map<Long, Sticker>> entry : this.allGuildStickers.entrySet()) {
            long jLongValue = entry.getKey().longValue();
            Map<Long, Sticker> value = entry.getValue();
            linkedHashMap.put(Long.valueOf(jLongValue), Maps6.toMap(value));
            arrayList.addAll(value.values());
        }
        this.allGuildStickersSnapshot = linkedHashMap;
        this.allGuildStickersFlattenedSnapshot = _Collections.toList(arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StoreGuildStickers(Dispatcher dispatcher, ObservationDeck observationDeck, Function1<? super List<Long>, Unit> function1) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(function1, "onStickersDeleted");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.onStickersDeleted = function1;
        this.allGuildStickers = new LinkedHashMap();
        this.allGuildStickersSnapshot = Maps6.emptyMap();
        this.allGuildStickersFlattenedSnapshot = Collections2.emptyList();
    }
}
