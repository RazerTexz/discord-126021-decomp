package com.discord.stores;

import com.discord.api.guild.Guild;
import com.discord.api.guildmember.GuildMember;
import com.discord.api.sticker.GuildStickersUpdate;
import com.discord.api.sticker.Sticker;
import com.discord.api.sticker.StickerType;
import com.discord.models.domain.ModelPayload;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import d0.d0.f;
import d0.t.g0;
import d0.t.h0;
import d0.t.n;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;
import kotlin.Unit;
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

    public /* synthetic */ StoreGuildStickers(Dispatcher dispatcher, ObservationDeck observationDeck, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeckProvider.get() : observationDeck, function1);
    }

    public static final /* synthetic */ Map access$getAllGuildStickers$p(StoreGuildStickers storeGuildStickers) {
        return storeGuildStickers.allGuildStickers;
    }

    public static final /* synthetic */ Map access$getAllGuildStickersSnapshot$p(StoreGuildStickers storeGuildStickers) {
        return storeGuildStickers.allGuildStickersSnapshot;
    }

    public static final /* synthetic */ void access$setAllGuildStickersSnapshot$p(StoreGuildStickers storeGuildStickers, Map map) {
        storeGuildStickers.allGuildStickersSnapshot = map;
    }

    private final void updateStickers(long guildId, Collection<Sticker> stickers) {
        if (stickers.isEmpty()) {
            this.allGuildStickers.remove(Long.valueOf(guildId));
        } else {
            Map<Long, Map<Long, Sticker>> map = this.allGuildStickers;
            Long lValueOf = Long.valueOf(guildId);
            LinkedHashMap linkedHashMap = new LinkedHashMap(f.coerceAtLeast(g0.mapCapacity(o.collectionSizeOrDefault(stickers, 10)), 16));
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

    @StoreThread
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
        return map != null ? map : h0.emptyMap();
    }

    @StoreThread
    public final Map<Long, Sticker> getStickersForGuildInternal(long guildId) {
        return this.allGuildStickers.get(Long.valueOf(guildId));
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        m.checkNotNullParameter(payload, "payload");
        this.me = payload.getMe().getId();
        for (Guild guild : payload.getGuilds()) {
            m.checkNotNullExpressionValue(guild, "guild");
            handleGuildCreateOrUpdate(guild);
        }
    }

    public final void handleFetchedSticker(Sticker sticker) {
        Long guildId;
        if (sticker == null || sticker.getType() != StickerType.GUILD || (guildId = sticker.getGuildId()) == null) {
            return;
        }
        this.dispatcher.schedule(new StoreGuildStickers$handleFetchedSticker$1(this, guildId.longValue(), sticker));
    }

    @StoreThread
    public final Unit handleGuildCreateOrUpdate(Guild guild) {
        Object next;
        m.checkNotNullParameter(guild, "guild");
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
            listK = n.emptyList();
        }
        updateStickers(id2, listK);
        return Unit.a;
    }

    @StoreThread
    public final void handleGuildRemove(long guildId) {
        if (this.allGuildStickers.containsKey(Long.valueOf(guildId))) {
            this.allGuildStickers.remove(Long.valueOf(guildId));
            markChanged();
        }
    }

    @StoreThread
    public final void handleStickerUpdate(GuildStickersUpdate stickersUpdate) {
        Collection collectionEmptyList;
        m.checkNotNullParameter(stickersUpdate, "stickersUpdate");
        long guildId = stickersUpdate.getGuildId();
        List<Sticker> listC = stickersUpdate.c();
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(listC, 10));
        Iterator<T> it = listC.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((Sticker) it.next()).getId()));
        }
        Set set = u.toSet(arrayList);
        Map<Long, Sticker> map = this.allGuildStickersSnapshot.get(Long.valueOf(guildId));
        if (map != null) {
            collectionEmptyList = new ArrayList(map.size());
            Iterator<Map$Entry<Long, Sticker>> it2 = map.entrySet().iterator();
            while (it2.hasNext()) {
                collectionEmptyList.add(Long.valueOf(it2.next().getKey().longValue()));
            }
        } else {
            collectionEmptyList = n.emptyList();
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
        Observable<Map<Long, Map<Long, Sticker>>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreGuildStickers$observeGuildStickers$1(this), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map$Entry<Long, Map<Long, Sticker>> map$Entry : this.allGuildStickers.entrySet()) {
            long jLongValue = map$Entry.getKey().longValue();
            Map<Long, Sticker> value = map$Entry.getValue();
            linkedHashMap.put(Long.valueOf(jLongValue), h0.toMap(value));
            arrayList.addAll(value.values());
        }
        this.allGuildStickersSnapshot = linkedHashMap;
        this.allGuildStickersFlattenedSnapshot = u.toList(arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StoreGuildStickers(Dispatcher dispatcher, ObservationDeck observationDeck, Function1<? super List<Long>, Unit> function1) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(function1, "onStickersDeleted");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.onStickersDeleted = function1;
        this.allGuildStickers = new LinkedHashMap();
        this.allGuildStickersSnapshot = h0.emptyMap();
        this.allGuildStickersFlattenedSnapshot = n.emptyList();
    }
}
