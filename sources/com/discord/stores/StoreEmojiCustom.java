package com.discord.stores;

import com.discord.api.emoji.GuildEmoji;
import com.discord.api.emoji.GuildEmojisUpdate;
import com.discord.api.guild.Guild;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.member.GuildMember;
import com.discord.utilities.persister.Persister;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p507d0.p512d0.C11226f;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;

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

    /* JADX INFO: renamed from: com.discord.stores.StoreEmojiCustom$updateAllowedGuildEmojis$1 */
    /* JADX INFO: compiled from: StoreEmojiCustom.kt */
    public static final class C58981 extends AbstractC12240o implements Function2<Long, ModelEmojiCustom, Unit> {
        public final /* synthetic */ Map $allowed;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C58981(Map map) {
            super(2);
            this.$allowed = map;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, ModelEmojiCustom modelEmojiCustom) {
            invoke(l.longValue(), modelEmojiCustom);
            return Unit.f27425a;
        }

        public final void invoke(long j, ModelEmojiCustom modelEmojiCustom) {
            C12238m.checkNotNullParameter(modelEmojiCustom, "emoji");
            Map map = this.$allowed;
            Long lValueOf = Long.valueOf(j);
            Object map2 = map.get(lValueOf);
            if (map2 == null) {
                map2 = new HashMap();
                map.put(lValueOf, map2);
            }
            Map map3 = (Map) map2;
            long id2 = modelEmojiCustom.getId();
            if (!C12238m.areEqual(modelEmojiCustom, (ModelEmojiCustom) map3.get(Long.valueOf(id2)))) {
                map3.put(Long.valueOf(id2), modelEmojiCustom);
                StoreEmojiCustom.this.markChanged();
            }
        }
    }

    public StoreEmojiCustom(StoreStream storeStream) {
        C12238m.checkNotNullParameter(storeStream, "stream");
        this.stream = storeStream;
        this.allGuildEmoji = new LinkedHashMap();
        this.allGuildEmojiSnapshot = C12136h0.emptyMap();
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
        C58981 c58981 = new C58981(map3);
        for (ModelEmojiCustom modelEmojiCustom : guildEmojis) {
            List<Long> roles = modelEmojiCustom.getRoles();
            if (roles.isEmpty()) {
                c58981.invoke(0L, modelEmojiCustom);
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
                    c58981.invoke(l.longValue(), modelEmojiCustom);
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
            LinkedHashMap linkedHashMap = new LinkedHashMap(C11226f.coerceAtLeast(C12134g0.mapCapacity(C12149o.collectionSizeOrDefault(emojis, 10)), 16));
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

    @StoreThread
    public final Map<Long, Map<Long, ModelEmojiCustom>> getAllGuildEmojiInternal() {
        return this.allGuildEmoji;
    }

    public final Map<Long, ModelEmojiCustom> getEmojiForGuild(long guildId) {
        Map<Long, ModelEmojiCustom> map = getAllGuildEmoji().get(Long.valueOf(guildId));
        return map != null ? map : C12136h0.emptyMap();
    }

    @StoreThread
    public final Map<Long, ModelEmojiCustom> getEmojiForGuildInternal(long guildId) {
        return this.allGuildEmoji.get(Long.valueOf(guildId));
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        C12238m.checkNotNullParameter(payload, "payload");
        this.me = payload.getMe().getId();
        for (Guild guild : payload.getGuilds()) {
            C12238m.checkNotNullExpressionValue(guild, "guild");
            handleGuildAdd(guild);
        }
    }

    @StoreThread
    public final void handleEmojiUpdate(GuildEmojisUpdate emojiUpdate) {
        GuildMember guildMember;
        C12238m.checkNotNullParameter(emojiUpdate, "emojiUpdate");
        long guildId = emojiUpdate.getGuildId();
        Map<Long, GuildMember> map = this.stream.getGuilds().getGuildMembersComputedInternal$app_productionGoogleRelease().get(Long.valueOf(guildId));
        List<GuildEmoji> listM7816a = emojiUpdate.m7816a();
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(listM7816a, 10));
        Iterator<T> it = listM7816a.iterator();
        while (it.hasNext()) {
            arrayList.add(new ModelEmojiCustom((GuildEmoji) it.next(), guildId));
        }
        if (map == null || (guildMember = map.get(Long.valueOf(this.me))) == null) {
            return;
        }
        updateGlobalEmojis(guildId, arrayList);
        updateAllowedGuildEmojis(guildId, guildMember.getRoles(), arrayList);
    }

    @StoreThread
    public final Unit handleGuildAdd(Guild guild) {
        Object next;
        Collection<? extends ModelEmojiCustom> collectionEmptyList;
        C12238m.checkNotNullParameter(guild, "guild");
        List<com.discord.api.guildmember.GuildMember> listM7875v = guild.m7875v();
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
        } while (!(((com.discord.api.guildmember.GuildMember) next).getUser().getId() == this.me));
        com.discord.api.guildmember.GuildMember guildMember = (com.discord.api.guildmember.GuildMember) next;
        if (guildMember == null) {
            return null;
        }
        long id2 = guild.getId();
        List<GuildEmoji> listM7864k = guild.m7864k();
        if (listM7864k != null) {
            collectionEmptyList = new ArrayList<>(C12149o.collectionSizeOrDefault(listM7864k, 10));
            Iterator<T> it2 = listM7864k.iterator();
            while (it2.hasNext()) {
                collectionEmptyList.add(new ModelEmojiCustom((GuildEmoji) it2.next(), id2));
            }
        } else {
            collectionEmptyList = C12147n.emptyList();
        }
        updateGlobalEmojis(id2, collectionEmptyList);
        updateAllowedGuildEmojis(id2, guildMember.m7926l(), collectionEmptyList);
        return Unit.f27425a;
    }

    @StoreThread
    public final void handleGuildMemberAdd(com.discord.api.guildmember.GuildMember member) {
        Collection<ModelEmojiCustom> collectionValues;
        C12238m.checkNotNullParameter(member, "member");
        if (member.getUser().getId() == this.me) {
            long guildId = member.getGuildId();
            Map<Long, ModelEmojiCustom> map = this.allGuildEmoji.get(Long.valueOf(guildId));
            if (map == null || (collectionValues = map.values()) == null) {
                return;
            }
            updateAllowedGuildEmojis(guildId, member.m7926l(), collectionValues);
        }
    }

    @StoreThread
    public final void handleGuildRemove(Guild guild) {
        C12238m.checkNotNullParameter(guild, "guild");
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
            linkedHashMap.put(Long.valueOf(entry.getKey().longValue()), C12136h0.toMap(entry.getValue()));
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
