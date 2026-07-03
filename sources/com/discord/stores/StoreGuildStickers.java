package com.discord.stores;

import com.discord.api.guild.Guild;
import com.discord.api.guildmember.GuildMember;
import com.discord.api.sticker.GuildStickersUpdate;
import com.discord.api.sticker.Sticker;
import com.discord.api.sticker.StickerType;
import com.discord.models.domain.ModelPayload;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
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
import p507d0.p512d0.C11226f;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;

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

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildStickers$handleFetchedSticker$1 */
    /* JADX INFO: compiled from: StoreGuildStickers.kt */
    public static final class C60771 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ Sticker $sticker;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60771(long j, Sticker sticker) {
            super(0);
            this.$guildId = j;
            this.$sticker = sticker;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Map mapEmptyMap = (Map) StoreGuildStickers.this.allGuildStickers.get(Long.valueOf(this.$guildId));
            if (mapEmptyMap == null) {
                mapEmptyMap = C12136h0.emptyMap();
            }
            linkedHashMap.putAll(mapEmptyMap);
            linkedHashMap.put(Long.valueOf(this.$sticker.getId()), this.$sticker);
            StoreGuildStickers.this.allGuildStickers.put(Long.valueOf(this.$guildId), linkedHashMap);
            StoreGuildStickers.this.markChanged();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildStickers$observeGuildStickers$1 */
    /* JADX INFO: compiled from: StoreGuildStickers.kt */
    public static final class C60781 extends AbstractC12240o implements Function0<Map<Long, ? extends Map<Long, ? extends Sticker>>> {
        public C60781() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends Map<Long, ? extends Sticker>> invoke() {
            return StoreGuildStickers.this.allGuildStickersSnapshot;
        }
    }

    public /* synthetic */ StoreGuildStickers(Dispatcher dispatcher, ObservationDeck observationDeck, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeckProvider.get() : observationDeck, function1);
    }

    private final void updateStickers(long guildId, Collection<Sticker> stickers) {
        if (stickers.isEmpty()) {
            this.allGuildStickers.remove(Long.valueOf(guildId));
        } else {
            Map<Long, Map<Long, Sticker>> map = this.allGuildStickers;
            Long lValueOf = Long.valueOf(guildId);
            LinkedHashMap linkedHashMap = new LinkedHashMap(C11226f.coerceAtLeast(C12134g0.mapCapacity(C12149o.collectionSizeOrDefault(stickers, 10)), 16));
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
        return map != null ? map : C12136h0.emptyMap();
    }

    @StoreThread
    public final Map<Long, Sticker> getStickersForGuildInternal(long guildId) {
        return this.allGuildStickers.get(Long.valueOf(guildId));
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        C12238m.checkNotNullParameter(payload, "payload");
        this.me = payload.getMe().getId();
        for (Guild guild : payload.getGuilds()) {
            C12238m.checkNotNullExpressionValue(guild, "guild");
            handleGuildCreateOrUpdate(guild);
        }
    }

    public final void handleFetchedSticker(Sticker sticker) {
        Long guildId;
        if (sticker == null || sticker.getType() != StickerType.GUILD || (guildId = sticker.getGuildId()) == null) {
            return;
        }
        this.dispatcher.schedule(new C60771(guildId.longValue(), sticker));
    }

    @StoreThread
    public final Unit handleGuildCreateOrUpdate(Guild guild) {
        Object next;
        C12238m.checkNotNullParameter(guild, "guild");
        List<GuildMember> listM7875v = guild.m7875v();
        if (listM7875v == null) {
            return null;
        }
        Iterator<T> it = listM7875v.iterator();
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
        List<Sticker> listM7846K = guild.m7846K();
        if (listM7846K == null) {
            listM7846K = C12147n.emptyList();
        }
        updateStickers(id2, listM7846K);
        return Unit.f27425a;
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
        C12238m.checkNotNullParameter(stickersUpdate, "stickersUpdate");
        long guildId = stickersUpdate.getGuildId();
        List<Sticker> listM8233c = stickersUpdate.m8233c();
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(listM8233c, 10));
        Iterator<T> it = listM8233c.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((Sticker) it.next()).getId()));
        }
        Set set = C12163u.toSet(arrayList);
        Map<Long, Sticker> map = this.allGuildStickersSnapshot.get(Long.valueOf(guildId));
        if (map != null) {
            collectionEmptyList = new ArrayList(map.size());
            Iterator<Map.Entry<Long, Sticker>> it2 = map.entrySet().iterator();
            while (it2.hasNext()) {
                collectionEmptyList.add(Long.valueOf(it2.next().getKey().longValue()));
            }
        } else {
            collectionEmptyList = C12147n.emptyList();
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : collectionEmptyList) {
            if (!set.contains(Long.valueOf(((Number) obj).longValue()))) {
                arrayList2.add(obj);
            }
        }
        updateStickers(guildId, listM8233c);
        this.onStickersDeleted.invoke(arrayList2);
    }

    public final Observable<Map<Long, Map<Long, Sticker>>> observeGuildStickers() {
        Observable<Map<Long, Map<Long, Sticker>>> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C60781(), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableM11112r;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Long, Map<Long, Sticker>> entry : this.allGuildStickers.entrySet()) {
            long jLongValue = entry.getKey().longValue();
            Map<Long, Sticker> value = entry.getValue();
            linkedHashMap.put(Long.valueOf(jLongValue), C12136h0.toMap(value));
            arrayList.addAll(value.values());
        }
        this.allGuildStickersSnapshot = linkedHashMap;
        this.allGuildStickersFlattenedSnapshot = C12163u.toList(arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StoreGuildStickers(Dispatcher dispatcher, ObservationDeck observationDeck, Function1<? super List<Long>, Unit> function1) {
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        C12238m.checkNotNullParameter(function1, "onStickersDeleted");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.onStickersDeleted = function1;
        this.allGuildStickers = new LinkedHashMap();
        this.allGuildStickersSnapshot = C12136h0.emptyMap();
        this.allGuildStickersFlattenedSnapshot = C12147n.emptyList();
    }
}
