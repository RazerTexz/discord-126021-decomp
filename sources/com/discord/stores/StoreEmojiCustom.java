package com.discord.stores;

import com.discord.api.emoji.GuildEmoji;
import com.discord.api.emoji.GuildEmojisUpdate;
import com.discord.api.guild.Guild;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.member.GuildMember;
import com.discord.utilities.persister.Persister;
import d0.d0._Ranges;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import rx.Observable;

/* JADX INFO: compiled from: StoreEmojiCustom.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreEmojiCustom extends StoreV2 {
    private static final long NO_ROLE = 0;
    private final Map<Long, Map<Long, ModelEmojiCustom>> allGuildEmoji;
    private Map<Long, ? extends Map<Long, ? extends ModelEmojiCustom>> allGuildEmojiSnapshot;
    private final Persister<Map<Long, Map<Long, ModelEmojiCustom>>> allowedGuildEmojiPersister;
    private final Map<Long, Map<Long, Map<Long, ModelEmojiCustom>>> allowedGuildEmojis;
    private long me;
    private final StoreStream stream;

    /* JADX INFO: renamed from: com.discord.stores.StoreEmojiCustom$updateAllowedGuildEmojis$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreEmojiCustom.kt */
    public static final class AnonymousClass1 extends Lambda implements Function2<Long, ModelEmojiCustom, Unit> {
        public final /* synthetic */ Map $allowed;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Map map) {
            super(2);
            this.$allowed = map;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, ModelEmojiCustom modelEmojiCustom) {
            invoke(l.longValue(), modelEmojiCustom);
            return Unit.a;
        }

        public final void invoke(long j, ModelEmojiCustom modelEmojiCustom) {
            Intrinsics3.checkNotNullParameter(modelEmojiCustom, "emoji");
            Map map = this.$allowed;
            Long lValueOf = Long.valueOf(j);
            Object map2 = map.get(lValueOf);
            if (map2 == null) {
                map2 = new HashMap();
                map.put(lValueOf, map2);
            }
            Map map3 = (Map) map2;
            long id2 = modelEmojiCustom.getId();
            if (!Intrinsics3.areEqual(modelEmojiCustom, (ModelEmojiCustom) map3.get(Long.valueOf(id2)))) {
                map3.put(Long.valueOf(id2), modelEmojiCustom);
                StoreEmojiCustom.this.markChanged();
            }
        }
    }

    public StoreEmojiCustom(StoreStream storeStream) {
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        this.stream = storeStream;
        this.allGuildEmoji = new LinkedHashMap();
        this.allGuildEmojiSnapshot = Maps6.emptyMap();
        this.allowedGuildEmojis = new LinkedHashMap();
        this.allowedGuildEmojiPersister = new Persister<>("STORE_EMOJI_AVAILABLE_V5", new HashMap());
    }

    private final void updateAllowedGuildEmojis(long guildId, List<Long> myRoles, Collection<? extends ModelEmojiCustom> guildEmojis) {
        Object next;
        Map<Long, Map<Long, Map<Long, ModelEmojiCustom>>> map = this.allowedGuildEmojis;
        Long lValueOf = Long.valueOf(guildId);
        Map<Long, Map<Long, ModelEmojiCustom>> map2 = map.get(lValueOf);
        if (map2 == null) {
            map2 = new HashMap<>();
            map.put(lValueOf, map2);
        }
        Map<Long, Map<Long, ModelEmojiCustom>> map3 = map2;
        map3.clear();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(map3);
        for (ModelEmojiCustom modelEmojiCustom : guildEmojis) {
            List<Long> roles = modelEmojiCustom.getRoles();
            if (roles.isEmpty()) {
                anonymousClass1.invoke(0L, modelEmojiCustom);
            } else {
                Iterator<T> it = myRoles.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!roles.contains(Long.valueOf(((Number) next).longValue())));
                Long l = (Long) next;
                if (l != null) {
                    anonymousClass1.invoke(l.longValue(), modelEmojiCustom);
                }
            }
        }
    }

    private final void updateGlobalEmojis(long guildId, Collection<? extends ModelEmojiCustom> emojis) {
        if (emojis.isEmpty()) {
            this.allGuildEmoji.remove(Long.valueOf(guildId));
        } else {
            Map<Long, Map<Long, ModelEmojiCustom>> map = this.allGuildEmoji;
            Long lValueOf = Long.valueOf(guildId);
            LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(emojis, 10)), 16));
            for (Object obj : emojis) {
                linkedHashMap.put(Long.valueOf(((ModelEmojiCustom) obj).getId()), obj);
            }
            map.put(lValueOf, linkedHashMap);
        }
        markChanged();
    }

    public final Map<Long, Map<Long, ModelEmojiCustom>> getAllGuildEmoji() {
        return this.allGuildEmojiSnapshot;
    }

    @Store3
    public final Map<Long, Map<Long, ModelEmojiCustom>> getAllGuildEmojiInternal() {
        return this.allGuildEmoji;
    }

    public final Map<Long, ModelEmojiCustom> getEmojiForGuild(long guildId) {
        Map<Long, ModelEmojiCustom> map = getAllGuildEmoji().get(Long.valueOf(guildId));
        return map != null ? map : Maps6.emptyMap();
    }

    @Store3
    public final Map<Long, ModelEmojiCustom> getEmojiForGuildInternal(long guildId) {
        return this.allGuildEmoji.get(Long.valueOf(guildId));
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        this.me = payload.getMe().getId();
        for (Guild guild : payload.getGuilds()) {
            Intrinsics3.checkNotNullExpressionValue(guild, "guild");
            handleGuildAdd(guild);
        }
    }

    @Store3
    public final void handleEmojiUpdate(GuildEmojisUpdate emojiUpdate) {
        GuildMember guildMember;
        Intrinsics3.checkNotNullParameter(emojiUpdate, "emojiUpdate");
        long guildId = emojiUpdate.getGuildId();
        Map<Long, GuildMember> map = this.stream.getGuilds().getGuildMembersComputedInternal$app_productionGoogleRelease().get(Long.valueOf(guildId));
        List<GuildEmoji> listA = emojiUpdate.a();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listA, 10));
        Iterator<T> it = listA.iterator();
        while (it.hasNext()) {
            arrayList.add(new ModelEmojiCustom((GuildEmoji) it.next(), guildId));
        }
        if (map == null || (guildMember = map.get(Long.valueOf(this.me))) == null) {
            return;
        }
        updateGlobalEmojis(guildId, arrayList);
        updateAllowedGuildEmojis(guildId, guildMember.getRoles(), arrayList);
    }

    @Store3
    public final Unit handleGuildAdd(Guild guild) {
        Object next;
        Collection<? extends ModelEmojiCustom> collectionEmptyList;
        Intrinsics3.checkNotNullParameter(guild, "guild");
        List<com.discord.api.guildmember.GuildMember> listV = guild.v();
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
        } while (!(((com.discord.api.guildmember.GuildMember) next).getUser().getId() == this.me));
        com.discord.api.guildmember.GuildMember guildMember = (com.discord.api.guildmember.GuildMember) next;
        if (guildMember == null) {
            return null;
        }
        long id2 = guild.getId();
        List<GuildEmoji> listK = guild.k();
        if (listK != null) {
            collectionEmptyList = new ArrayList<>(Iterables2.collectionSizeOrDefault(listK, 10));
            Iterator<T> it2 = listK.iterator();
            while (it2.hasNext()) {
                collectionEmptyList.add(new ModelEmojiCustom((GuildEmoji) it2.next(), id2));
            }
        } else {
            collectionEmptyList = Collections2.emptyList();
        }
        updateGlobalEmojis(id2, collectionEmptyList);
        updateAllowedGuildEmojis(id2, guildMember.l(), collectionEmptyList);
        return Unit.a;
    }

    @Store3
    public final void handleGuildMemberAdd(com.discord.api.guildmember.GuildMember member) {
        Collection<ModelEmojiCustom> collectionValues;
        Intrinsics3.checkNotNullParameter(member, "member");
        if (member.getUser().getId() == this.me) {
            long guildId = member.getGuildId();
            Map<Long, ModelEmojiCustom> map = this.allGuildEmoji.get(Long.valueOf(guildId));
            if (map == null || (collectionValues = map.values()) == null) {
                return;
            }
            updateAllowedGuildEmojis(guildId, member.l(), collectionValues);
        }
    }

    @Store3
    public final void handleGuildRemove(Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        long id2 = guild.getId();
        if (this.allowedGuildEmojis.containsKey(Long.valueOf(id2))) {
            this.allowedGuildEmojis.remove(Long.valueOf(id2));
            markChanged();
        }
        if (this.allGuildEmoji.containsKey(Long.valueOf(id2))) {
            this.allGuildEmoji.remove(Long.valueOf(id2));
            markChanged();
        }
    }

    public final Observable<Map<Long, Map<Long, ModelEmojiCustom>>> observeAllowedGuildEmoji() {
        return this.allowedGuildEmojiPersister.getObservable();
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Long, Map<Long, ModelEmojiCustom>> entry : this.allGuildEmoji.entrySet()) {
            linkedHashMap.put(Long.valueOf(entry.getKey().longValue()), Maps6.toMap(entry.getValue()));
        }
        this.allGuildEmojiSnapshot = linkedHashMap;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry<Long, Map<Long, Map<Long, ModelEmojiCustom>>> entry2 : this.allowedGuildEmojis.entrySet()) {
            long jLongValue = entry2.getKey().longValue();
            Map<Long, Map<Long, ModelEmojiCustom>> value = entry2.getValue();
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            Iterator<Map.Entry<Long, Map<Long, ModelEmojiCustom>>> it = value.entrySet().iterator();
            while (it.hasNext()) {
                linkedHashMap3.putAll(it.next().getValue());
            }
            linkedHashMap2.put(Long.valueOf(jLongValue), linkedHashMap3);
        }
        Persister.set$default(this.allowedGuildEmojiPersister, linkedHashMap2, false, 2, null);
    }
}
